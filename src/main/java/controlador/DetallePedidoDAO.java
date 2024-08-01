package controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Coordinador;
import modelo.DetallePedido;

import java.util.List;

public class DetallePedidoDAO {

	private Coordinador miCoordinador;
	private Conexion miConexion;
	
    private final SessionFactory sessionFactory;

    public DetallePedidoDAO(Coordinador miCoordinador, Conexion miConexion) {
    	this.miCoordinador = miCoordinador;
    	this.miConexion = miConexion;
        this.sessionFactory = miConexion.getSessionFactory();
        
    }

    @SuppressWarnings("deprecation")
	public void guardarDetallePedido(DetallePedido detallePedido) {
    	
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
   
            transaction = session.beginTransaction();
            
            session.save(detallePedido);
    
            transaction.commit();
   
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
 
            }
            e.printStackTrace();
           
        }
    }

    @SuppressWarnings("deprecation")
	public void actualizarDetallePedido(DetallePedido detallePedido) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(detallePedido);
            transaction.commit();
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
	public void eliminarDetallePedido(DetallePedido detallePedido) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(detallePedido);
            transaction.commit();
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<DetallePedido> obtenerTodosLosDetallesPedido() {
        try (Session session = sessionFactory.openSession()) {
            Query<DetallePedido> query = session.createQuery("FROM DetallePedido", DetallePedido.class);
         
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DetallePedido buscarDetallePedidoPorId(String idDetallePedido) {
        try (Session session = sessionFactory.openSession()) {
     
            return session.get(DetallePedido.class, idDetallePedido);
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