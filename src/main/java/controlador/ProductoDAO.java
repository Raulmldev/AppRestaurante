package controlador;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Coordinador;
import modelo.Producto;

/**
 * Clase DAO para la entidad Producto.
 */
public class ProductoDAO {
	
private Coordinador miCoordinador;
	
	private Conexion miConexion;

    private final SessionFactory sessionFactory;

    /**
     * Constructor de ProductoDAO que inicializa la sesión de Hibernate.
     */
    public ProductoDAO(Coordinador miCoordinador, Conexion miConexion) {
    	this.miCoordinador = miCoordinador;
    	this.miConexion = miConexion;
        sessionFactory = miConexion.getSessionFactory();

    }

    /**
     * Guarda un nuevo producto en la base de datos.
     *
     * @param producto El producto a guardar.
     */
    @SuppressWarnings("deprecation")
	public void guardarProducto(Producto producto) {
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
            session.save(producto);
            transaction.commit();
            
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un producto existente en la base de datos.
     *
     * @param producto El producto a actualizar.
     */
    @SuppressWarnings("deprecation")
	public void actualizarProducto(Producto producto) {
    	
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
            
            // Obtener el producto de la base de datos usando su ID
            Producto productoPersistente = session.get(Producto.class, producto.getIdProducto());
            
            // Verificar si el cliente persistente existe
            if (productoPersistente != null) {
            	
                // Modificar los atributos del cliente persistente con los nuevos valores
            	productoPersistente.setIdProducto(producto.getIdProducto());
            	productoPersistente.setNombreProducto(producto.getNombreProducto());
            	productoPersistente.setCantidadStock(producto.getCantidadStock());
            	productoPersistente.setPrecioVentaProducto(producto.getPrecioVentaProducto());
                
                session.update(productoPersistente);
                transaction.commit();
                
            } else {
            	  JOptionPane.showMessageDialog(null, "No se puede editar el ID de un producto registrado.",
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
     * Elimina un producto de la base de datos.
     *
     * @param producto El producto a eliminar.
     */
    @SuppressWarnings("deprecation")
	public void eliminarProducto(Producto producto) {
    	
        Transaction transaction = null;
        
        try (Session session = sessionFactory.openSession()) {
        	
            transaction = session.beginTransaction();
            session.delete(producto);
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todos los productos almacenados en la base de datos.
     *
     * @return Una lista de todos los productos.
     */
    public List<Producto> obtenerTodosLosProductos() {
    	
        try (Session session = sessionFactory.openSession()) {
        	
            Query<Producto> query = session.createQuery("FROM Producto", Producto.class);
           
            return query.list();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Busca un producto por su identificador único.
     *
     * @param idProducto El identificador único del producto.
     * @return El producto encontrado, o null si no se encuentra.
     */
    public Producto buscarProductoPorId(String idProducto) {
    	
        try (Session session = sessionFactory.openSession()) {
        	
            return session.get(Producto.class, idProducto);
            
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
