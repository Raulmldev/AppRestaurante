package controlador;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Cliente;
import modelo.Coordinador;

/**
 * Clase DAO para la entidad Cliente.
 */
public class ClienteDAO {
	
	private Coordinador miCoordinador;
	
	private Conexion miConexion;

    private final SessionFactory sessionFactory;

    /**
     * Constructor de ClienteDAO que inicializa la sesión de Hibernate.
     */
    public ClienteDAO(Coordinador miCoordinador, Conexion miConexion) {
    	
    	this.miCoordinador = miCoordinador;
    	this.miConexion = miConexion;
    	sessionFactory = miConexion.getSessionFactory();   	
        
    }

    /**
     * Guarda un nuevo cliente en la base de datos.
     *
     * @param cliente El cliente a guardar.
     */
    @SuppressWarnings("deprecation")
	public void guardarCliente(Cliente cliente) {
    	
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()){
        	 
            transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un cliente existente en la base de datos.
     *
     * @param cliente El cliente a actualizar.
     */
    @SuppressWarnings("deprecation")
	public void actualizarCliente(Cliente cliente) {
    	
    	Transaction transaction = null;
    	
        try (Session session = sessionFactory.openSession()) {
            
            transaction = session.beginTransaction();
            
            // Obtener el cliente de la base de datos usando su ID
            Cliente clientePersistente = session.get(Cliente.class, cliente.getIdCliente());

            // Verificar si el cliente persistente existe
            if (clientePersistente != null) {
                // Modificar los atributos del cliente persistente con los nuevos valores
            	clientePersistente.setIdCliente(cliente.getIdCliente());
                clientePersistente.setNombreCliente(cliente.getNombreCliente());
                clientePersistente.setClienteDNI(cliente.getClienteDNI());
                clientePersistente.setDireccionCliente(cliente.getDireccionCliente());
                clientePersistente.setTelefonoCliente(cliente.getTelefonoCliente());
                clientePersistente.setEmailCliente(cliente.getEmailCliente());
                clientePersistente.setPuntosCliente(cliente.getPuntosCliente());
                
                session.update(clientePersistente);
                transaction.commit();
                
            } else {
            	  JOptionPane.showMessageDialog(null, "No se puede editar el ID de un cliente registrado.",
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
     * Elimina un cliente de la base de datos.
     *
     * @param cliente El cliente a eliminar.
     */
    @SuppressWarnings("deprecation")
	public void eliminarCliente(Cliente cliente) {
    	
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
            session.delete(cliente);
            transaction.commit();
           
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todos los clientes almacenados en la base de datos.
     *
     * @return Una lista de todos los clientes.
     */
    public List<Cliente> obtenerTodosLosClientes() {
    	
        try (Session session = sessionFactory.openSession()) {
        	
            Query<Cliente> query = session.createQuery("FROM Cliente", Cliente.class);
           
            return query.list();
    
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca un cliente por su identificador único.
     *
     * @param idCliente El identificador único del cliente.
     * @return El cliente encontrado, o null si no se encuentra.
     */
    public Cliente buscarClientePorId(String idCliente) {
    	
        try (Session session = sessionFactory.openSession()) {
        	
            return session.get(Cliente.class, idCliente);
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return null;
        }
    }
    
   

	public Conexion getConexion() {
		return miConexion;
	}

	public void setConexion(Conexion miConexion) {
		this.miConexion = miConexion;
	}

	public Coordinador getCoordinador() {
		return miCoordinador;
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}