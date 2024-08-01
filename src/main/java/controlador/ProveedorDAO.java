package controlador;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Coordinador;
import modelo.Producto;
import modelo.Proveedor;

/**
 * Clase DAO para la entidad Proveedor.
 */
public class ProveedorDAO {

	private Coordinador miCoordinador;
	
	private Conexion miConexion;
	
    private final SessionFactory sessionFactory;

    /**
     * Constructor de ProveedorDAO que inicializa la sesión de Hibernate.
     */
    public ProveedorDAO(Coordinador miCoordinador, Conexion miConexion) {
    	
    	this.miCoordinador = miCoordinador;
    	this.miConexion = miConexion;
        sessionFactory = miConexion.getSessionFactory();
       
    }

    /**
     * Guarda un nuevo proveedor en la base de datos.
     *
     * @param proveedor El proveedor a guardar.
     */
    @SuppressWarnings("deprecation")
	public void guardarProveedor(Proveedor proveedor) {
    	
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
         
            session.save(proveedor);
          
            transaction.commit();
         
        
        } catch (Exception e) {
        
            if (transaction != null) {
                transaction.rollback();
            }
            
            e.printStackTrace();
           
        }
    }

    /**
     * Actualiza un proveedor existente en la base de datos.
     *
     * @param proveedor El proveedor a actualizar.
     */
    @SuppressWarnings("deprecation")
	public void actualizarProveedor(Proveedor proveedor) {
    	
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
            
         // Obtener el proveedor de la base de datos usando su ID
            Proveedor proveedorPersistente = session.get(Proveedor.class, proveedor.getIdProveedor());

            // Verificar si el proveedor persistente existe
            if (proveedorPersistente != null) {
            	
                // Modificar los atributos del proveedor persistente con los nuevos valores
            	proveedorPersistente.setIdProveedor(proveedor.getIdProveedor());
            	proveedorPersistente.setIdProducto(proveedor.getIdProducto());
            	proveedorPersistente.setNombreProveedor(proveedor.getNombreProveedor());
            	proveedorPersistente.setTelefonoProveedor(proveedor.getTelefonoProveedor());
            	proveedorPersistente.setEmailProveedor(proveedor.getEmailProveedor());
            	proveedorPersistente.setPrecioCompraProducto(proveedor.getPrecioCompraProducto());
            	proveedorPersistente.setCantidadCompraProducto(proveedor.getCantidadCompraProducto());

            session.update(proveedorPersistente);
            transaction.commit();
            
            } else {
          	  JOptionPane.showMessageDialog(null, "No se puede editar el ID de un proveedor registrado.",
                        "No se puede editar el ID.", JOptionPane.ERROR_MESSAGE);
              
          }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Elimina un proveedor de la base de datos.
     *
     * @param proveedor El proveedor a eliminar.
     */
    @SuppressWarnings("deprecation")
	public void eliminarProveedor(Proveedor proveedor) {
    	
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
            session.delete(proveedor);
            transaction.commit();           
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todos los proveedores almacenados en la base de datos.
     *
     * @return Una lista de todos los proveedores.
     */
    public List<Proveedor> obtenerTodosLosProveedores() {
    	
        try (Session session = sessionFactory.openSession()) {
        	       	
           Query<Proveedor> query = session.createQuery("FROM Proveedor", Proveedor.class);
    	
            return query.list();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca un proveedor por su identificador único.
     *
     * @param idProveedor El identificador único del proveedor.
     * @return El proveedor encontrado, o null si no se encuentra.
     */
    public Proveedor buscarProveedorPorId(String idProveedor) {
    	
        try (Session session = sessionFactory.openSession()) {
        
            return session.get(Proveedor.class, idProveedor);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Proveedor buscarProveedorPorIdProducto(Producto idProducto) {
        try (Session session = sessionFactory.openSession()) {
            Query<Proveedor> query = session.createQuery("FROM Proveedor p WHERE p.idProducto = :idProducto", Proveedor.class);
            query.setParameter("idProducto", idProducto);
            return query.setMaxResults(1).uniqueResult();
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