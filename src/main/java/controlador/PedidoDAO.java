package controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Coordinador;
import modelo.Pedido;

/**
 * Clase DAO para la entidad Pedido.
 */
public class PedidoDAO {

	private Coordinador miCoordinador;
	private Conexion miConexion;
	
    private final SessionFactory sessionFactory;

    /**
     * Constructor de PedidoDAO que inicializa la sesión de Hibernate.
     */
    public PedidoDAO(Coordinador miCoordinador, Conexion miConexion) {
    	this.miCoordinador = miCoordinador;
    	this.miConexion = miConexion;
        sessionFactory = miConexion.getSessionFactory();
        
    }

    /**
     * Guarda un nuevo pedido en la base de datos.
     *
     * @param pedido El pedido a guardar.
     */
    @SuppressWarnings("deprecation")
	public void guardarPedido(Pedido pedido) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(pedido);
            transaction.commit();
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un pedido existente en la base de datos.
     *
     * @param pedido El pedido a actualizar.
     */
    @SuppressWarnings("deprecation")
	public void actualizarPedido(Pedido pedido) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(pedido);
            transaction.commit();
        
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Elimina un pedido de la base de datos.
     *
     * @param pedido El pedido a eliminar.
     */
    @SuppressWarnings("deprecation")
	public void eliminarPedido(Pedido pedido) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(pedido);
            transaction.commit();
       
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todos los pedidos almacenados en la base de datos.
     *
     * @return Una lista de todos los pedidos.
     */
    public List<Pedido> obtenerTodosLosPedidos() {
        try (Session session = sessionFactory.openSession()) {
            Query<Pedido> query = session.createQuery("FROM Pedido", Pedido.class);
  
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca un pedido por su identificador único.
     *
     * @param idPedido El identificador único del pedido.
     * @return El pedido encontrado, o null si no se encuentra.
     */
    public Pedido buscarPedidoPorId(String idPedido) {
        try (Session session = sessionFactory.openSession()) {
   
            return session.get(Pedido.class, idPedido);
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