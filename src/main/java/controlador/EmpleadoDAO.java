package controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Coordinador;
import modelo.Empleado;

/**
 * Clase DAO para la entidad Empleado.
 */
public class EmpleadoDAO {

	private Coordinador miCoordinador;
	private Conexion miConexion;
	
    private final SessionFactory sessionFactory;

    /**
     * Constructor de EmpleadoDAO que inicializa la sesión de Hibernate.
     */
    public EmpleadoDAO(Coordinador miCoordinador, Conexion miConexion) {
    	this.miCoordinador = miCoordinador;
    	this.miConexion = miConexion;
        sessionFactory = miConexion.getSessionFactory();
        
    }

    /**
     * Guarda un nuevo empleado en la base de datos.
     *
     * @param empleado El empleado a guardar.
     */
    @SuppressWarnings("deprecation")
	public void guardarEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
            session.save(empleado);
            transaction.commit();
       
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un empleado existente en la base de datos.
     *
     * @param empleado El empleado a actualizar.
     */
    @SuppressWarnings("deprecation")
	public void actualizarEmpleado(Empleado empleado) {
    	   	
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(empleado);
            transaction.commit();
         
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Elimina un empleado de la base de datos.
     *
     * @param empleado El empleado a eliminar.
     */
    @SuppressWarnings("deprecation")
	public void eliminarEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(empleado);
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todos los empleados almacenados en la base de datos.
     *
     * @return Una lista de todos los empleados.
     */
    public List<Empleado> obtenerTodosLosEmpleados() {
        try (Session session = sessionFactory.openSession()) {
            Query<Empleado> query = session.createQuery("FROM Empleado", Empleado.class);
           
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca un empleado por su identificador único.
     *
     * @param idEmpleado El identificador único del empleado.
     * @return El empleado encontrado, o null si no se encuentra.
     */
    public Empleado buscarEmpleadoPorId(String idEmpleado) {
        try (Session session = sessionFactory.openSession()) {
        	
            return session.get(Empleado.class, idEmpleado);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	public Coordinador getCoordinador() {
		return miCoordinador;
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public Conexion getConexion() {
		return miConexion;
	}

	public void setConexion(Conexion miConexion) {
		this.miConexion = miConexion;
	}
}