package controlador;

import java.security.SecureRandom;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.Cliente;
import modelo.Coordinador;
import modelo.DetallePedido;
import modelo.Empleado;
import modelo.Pedido;
import modelo.Producto;
import modelo.Proveedor;


public class Procesos {

	private Coordinador miCoordinador;	
	
	private static Conexion miConexion;
	
	public Procesos(Coordinador miCoordinador, Conexion miConexion) {
		this.miCoordinador = miCoordinador;
		Procesos.miConexion = miConexion;
	}
	
/****************************************************	
	
MÉTODOS SETTER Y GETTER

*****************************************************/	
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
		Procesos.miConexion = miConexion;
	}
	
/****************************************************	
	
MÉTODOS VALIDADORES

*****************************************************/	
	
	// Método para validar el formato de un número de teléfono
    public static boolean validarTelefono(String telefono) {
        // El teléfono puede tener un prefijo opcional seguido de 9 o 10 dígitos
        return telefono.matches("^\\+?\\d{0,2}-?\\d{9,10}$");
    }
    
    // Método para validar el formato de un DNI
    public static boolean validarDNI(String dni) {
        // El DNI puede tener 8 dígitos seguidos de una letra opcional
        return dni.matches("^\\d{8}-?[A-HJ-NP-TV-Za-hj-np-tv-z]$");
    }
    
    // Método para validar  el formato de un correo electrónico
    public static boolean validarEmail(String email) {
        // Expresión regular para validar direcciones de correo electrónico
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    //Metodo para validar que los puntos sean un numero entero
    public static boolean validarPuntos(String puntos) {
    	
    	try {
            // Intenta convertir la cadena a un número entero
            int puntosInt = Integer.parseInt(puntos);
            // Verifica que el número sea mayor o igual a cero
            return puntosInt >= 0;
        } catch (NumberFormatException e) {
            // Si la conversión falla, significa que la cadena no representa un número entero válido
            return false;
        }
    }
    
/**
* Metodos para generar y comprobar codigos ID en la BD
*/    
        
    // Método para generar codigos ID aleatorios
    public static String generarIDAleatorio(int longitud) {
    	String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    	SecureRandom random = new SecureRandom();
    	StringBuilder sb = new StringBuilder(longitud);
    	for (int i = 0; i < longitud; i++) {
    		int indice = random.nextInt(caracteres.length());
    		sb.append(caracteres.charAt(indice));
    	}
    	return sb.toString();
    }

    /*
     * Para Clientes
     */
    
    // Método para verificar si el código ya está en uso en la base de datos
    public static boolean codigoClienteExisteEnBD(String codigoClienteGenerado) {
    	try (Session sessionClienteExisteEnBD = miConexion.getSessionFactory().openSession()) {
    		// Comienza una transacción
    		sessionClienteExisteEnBD.beginTransaction();
        	        
    		// Crea la consulta para contar el número de registros con el código generado
    		Query<Long> query = sessionClienteExisteEnBD.createQuery(
    				"SELECT COUNT(*) FROM Cliente WHERE idCliente = :codigo", Long.class);
    		query.setParameter("codigo", codigoClienteGenerado);
    		Long count = query.getSingleResult();
        	        
    		// Confirma la transacción
    		sessionClienteExisteEnBD.getTransaction().commit();
        	        
    		// Retorna true si el código ya está en uso, de lo contrario, retorna false
    		return count > 0;
    	} catch (Exception ex) {
    		ex.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tu necesidad)
    		return false;
    	}
    }
    
    // Método para generar un ID único no utilizado en la base de datos
    public static String generarClienteID(int longitud) {
        String codigoClienteGenerado;
        do {
        	codigoClienteGenerado = generarIDAleatorio(longitud);
        } while (codigoClienteExisteEnBD(codigoClienteGenerado));
        return codigoClienteGenerado;
    }
    
    /*
     * Para Empleados
     */
    
    // Método para verificar si el código ya está en uso en la base de datos
    public static boolean codigoEmpleadoExisteEnBD(String codigoEmpleadoGenerado) {
    	Session sessionEmpleadoExisteEnBD = miConexion.getSessionFactory().openSession();
        try {
            
            // Comienza una transacción
        	sessionEmpleadoExisteEnBD.beginTransaction();
            
            // Crea la consulta para contar el número de registros con el código generado
            Query<Long> query = sessionEmpleadoExisteEnBD.createQuery(
                "SELECT COUNT(*) FROM Empleado WHERE idEmpleado = :codigo", Long.class);
            query.setParameter("codigo", codigoEmpleadoGenerado);
            Long count = query.getSingleResult();
            
            // Confirma la transacción
            sessionEmpleadoExisteEnBD.getTransaction().commit();
            
            // Retorna true si el código ya está en uso, de lo contrario, retorna false
            return count > 0;
        } catch (Exception ex) {
            if (sessionEmpleadoExisteEnBD != null && sessionEmpleadoExisteEnBD.getTransaction() != null) {
                // Deshace la transacción en caso de excepción
            	sessionEmpleadoExisteEnBD.getTransaction().rollback();
            }
            ex.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tu necesidad)
            return false;
            
        } finally {
            if (sessionEmpleadoExisteEnBD != null) {
                // Cierra la sesión
            	sessionEmpleadoExisteEnBD.close();
            }
        	
        }
    }
    
    // Método para generar un ID único no utilizado en la base de datos
    public static String generarEmpleadoID(int longitud) {
        String codigoEmpleadoGenerado;
        do {
        	codigoEmpleadoGenerado = generarIDAleatorio(longitud);
        } while (codigoEmpleadoExisteEnBD(codigoEmpleadoGenerado));
        return codigoEmpleadoGenerado;
    }
    
 // Método para verificar si el DNI ya está en uso en la base de datos
    public static boolean dniEmpleadoExisteEnBD(String dniEmpleadoIntroducido) {
    	Session sessionDniEmpleadoExisteEnBD = miConexion.getSessionFactory().openSession();
        try {
            
            // Comienza una transacción
        	sessionDniEmpleadoExisteEnBD.beginTransaction();
            
            // Crea la consulta para contar el número de registros con el código generado
            Query<Long> query = sessionDniEmpleadoExisteEnBD.createQuery(
                "SELECT COUNT(*) FROM Empleado WHERE empleadoDNI = :codigo", Long.class);
            query.setParameter("codigo", dniEmpleadoIntroducido);
            Long count = query.getSingleResult();
            
            // Confirma la transacción
            sessionDniEmpleadoExisteEnBD.getTransaction().commit();
            
            // Retorna true si el código ya está en uso, de lo contrario, retorna false
            return count > 0;
        } catch (Exception ex) {
            if (sessionDniEmpleadoExisteEnBD != null && sessionDniEmpleadoExisteEnBD.getTransaction() != null) {
                // Deshace la transacción en caso de excepción
            	sessionDniEmpleadoExisteEnBD.getTransaction().rollback();
            }
            ex.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tu necesidad)
            return false;
            
        } finally {
            if (sessionDniEmpleadoExisteEnBD != null) {
                // Cierra la sesión
            	sessionDniEmpleadoExisteEnBD.close();
            }
        	
        }
    }

    /*
     * Para Pedidos
     */
    
    // Método para verificar si el código ya está en uso en la base de datos
    public static boolean codigoPedidoExisteEnBD(String codigoPedidoGenerado) {
    	Session sessionPedidoExisteEnBD = miConexion.getSessionFactory().openSession();
        try {
            
            // Comienza una transacción
        	sessionPedidoExisteEnBD.beginTransaction();
            
            // Crea la consulta para contar el número de registros con el código generado
            Query<Long> query = sessionPedidoExisteEnBD.createQuery(
                "SELECT COUNT(*) FROM Pedido WHERE idPedido = :codigo", Long.class);
            query.setParameter("codigo", codigoPedidoGenerado);
            Long count = query.getSingleResult();
            
            // Confirma la transacción
            sessionPedidoExisteEnBD.getTransaction().commit();
            
            // Retorna true si el código ya está en uso, de lo contrario, retorna false
            return count > 0;
        } catch (Exception ex) {
            if (sessionPedidoExisteEnBD != null && sessionPedidoExisteEnBD.getTransaction() != null) {
                // Deshace la transacción en caso de excepción
            	sessionPedidoExisteEnBD.getTransaction().rollback();
            }
            ex.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tu necesidad)
            return false;
            
        } finally {
            if (sessionPedidoExisteEnBD != null) {
                // Cierra la sesión
            	sessionPedidoExisteEnBD.close();
            }
        	
        }
    }
    
    // Método para generar un ID único no utilizado en la base de datos
    public static String generarPedidoID(int longitud) {
        String codigoPedidoGenerado;
        do {
        	codigoPedidoGenerado = generarIDAleatorio(longitud);
        } while (codigoPedidoExisteEnBD(codigoPedidoGenerado));
        return codigoPedidoGenerado;
    }
    
    /*
     * Para DetallePedidos
     */
    
    // Método para verificar si el código ya está en uso en la base de datos
    public static boolean codigoDetallePedidoExisteEnBD(String codigoDetallePedidoGenerado) {
    	Session sessionDetallePedidoExisteEnBD = miConexion.getSessionFactory().openSession();
        try {
            
            // Comienza una transacción
        	sessionDetallePedidoExisteEnBD.beginTransaction();
            
            // Crea la consulta para contar el número de registros con el código generado
            Query<Long> query = sessionDetallePedidoExisteEnBD.createQuery(
                "SELECT COUNT(*) FROM DetallePedido WHERE idDetallePedido = :codigo", Long.class);
            query.setParameter("codigo", codigoDetallePedidoGenerado);
            Long count = query.getSingleResult();
            
            // Confirma la transacción
            sessionDetallePedidoExisteEnBD.getTransaction().commit();
            
            // Retorna true si el código ya está en uso, de lo contrario, retorna false
            return count > 0;
        } catch (Exception ex) {
            if (sessionDetallePedidoExisteEnBD != null && sessionDetallePedidoExisteEnBD.getTransaction() != null) {
                // Deshace la transacción en caso de excepción
            	sessionDetallePedidoExisteEnBD.getTransaction().rollback();
            }
            ex.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tu necesidad)
            return false;
            
        } finally {
            if (sessionDetallePedidoExisteEnBD != null) {
                // Cierra la sesión
            	sessionDetallePedidoExisteEnBD.close();
            }
        	
        }
    }
    
    // Método para generar un ID único no utilizado en la base de datos
    public static String generarDetallePedidoID(int longitud) {
        String codigoDetallePedidoGenerado;
        do {
        	codigoDetallePedidoGenerado = generarIDAleatorio(longitud);
        } while (codigoDetallePedidoExisteEnBD(codigoDetallePedidoGenerado));
        return codigoDetallePedidoGenerado;
    }
    
    /*
     * Para Productos
     */
    // Método para verificar si el código ya está en uso en la base de datos
    public static boolean codigoProductoExisteEnBD(String codigoProductoGenerado) {
    	Session sessionProductoExisteEnBD = miConexion.getSessionFactory().openSession();
        try {
            
            // Comienza una transacción
        	sessionProductoExisteEnBD.beginTransaction();
            
            // Crea la consulta para contar el número de registros con el código generado
            Query<Long> query = sessionProductoExisteEnBD.createQuery(
                "SELECT COUNT(*) FROM Producto WHERE idProducto = :codigo", Long.class);
            query.setParameter("codigo", codigoProductoGenerado);
            Long count = query.getSingleResult();
            
            // Confirma la transacción
            sessionProductoExisteEnBD.getTransaction().commit();
            
            // Retorna true si el código ya está en uso, de lo contrario, retorna false
            return count > 0;
        } catch (Exception ex) {
            if (sessionProductoExisteEnBD != null && sessionProductoExisteEnBD.getTransaction() != null) {
                // Deshace la transacción en caso de excepción
            	sessionProductoExisteEnBD.getTransaction().rollback();
            }
            ex.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tu necesidad)
            return false;
            
        } finally {
            if (sessionProductoExisteEnBD != null) {
                // Cierra la sesión
            	sessionProductoExisteEnBD.close();
            }
        	
        }
    }
    
    // Método para generar un ID único no utilizado en la base de datos
    public static String generarProductoID(int longitud) {
        String codigoProductoGenerado;
        do {
        	codigoProductoGenerado = generarIDAleatorio(longitud);
        } while (codigoProductoExisteEnBD(codigoProductoGenerado));
        return codigoProductoGenerado;
    }
    
    /*
     * Para Proveedores
     */
    
    // Método para verificar si el código ya está en uso en la base de datos
    public static boolean codigoProveedorExisteEnBD(String codigoProveedorGenerado) {
    	Session sessionProveedorExisteEnBD = miConexion.getSessionFactory().openSession();
        try {
            
            // Comienza una transacción
        	sessionProveedorExisteEnBD.beginTransaction();
            
            // Crea la consulta para contar el número de registros con el código generado
            Query<Long> query = sessionProveedorExisteEnBD.createQuery(
                "SELECT COUNT(*) FROM Proveedor WHERE idProveedor = :codigo", Long.class);
            query.setParameter("codigo", codigoProveedorGenerado);
            Long count = query.getSingleResult();
            
            // Confirma la transacción
            sessionProveedorExisteEnBD.getTransaction().commit();
            
            // Retorna true si el código ya está en uso, de lo contrario, retorna false
            return count > 0;
        } catch (Exception ex) {
            if (sessionProveedorExisteEnBD != null && sessionProveedorExisteEnBD.getTransaction() != null) {
                // Deshace la transacción en caso de excepción
            	sessionProveedorExisteEnBD.getTransaction().rollback();
            }
            ex.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tu necesidad)
            return false;
            
        } finally {
            if (sessionProveedorExisteEnBD != null) {
                // Cierra la sesión
            	sessionProveedorExisteEnBD.close();
            }
        	
        }
    }
    
    // Método para generar un ID único no utilizado en la base de datos
    public static String generarProveedorID(int longitud) {
        String codigoProveedorGenerado;
        do {
        	codigoProveedorGenerado = generarIDAleatorio(longitud);
        } while (codigoProveedorExisteEnBD(codigoProveedorGenerado));
        return codigoProveedorGenerado;
    }

/****************************************************	
	
MÉTODOS TABLAS

*****************************************************/	
	
    public void cargarDatos() {
		//actualizarTablaClientes();
	}

    public void actualizarTablaClientes(List<Cliente> listaClientes, JTable tablaClientes) {
    	DefaultTableModel modelClientes = (DefaultTableModel) miCoordinador.getVentanaGerente().getTbClientesVG().getModel();
    	modelClientes.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
    }
	 
    public void actualizarTablaEmpleados(List<Empleado> listaEmpleados, JTable tablaEmpleados) {
    	DefaultTableModel modelEmpleados = (DefaultTableModel) miCoordinador.getVentanaGerente().getTbEmpleadoVG().getModel();
    	modelEmpleados.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
    }
	 
    public void actualizarTablaProductos(List<Producto> listaProductos, JTable tablaProductos) {
    	DefaultTableModel modelProductos = (DefaultTableModel) miCoordinador.getVentanaGerente().getTbProductosVG().getModel();
    	modelProductos.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
    }
	 
    public void actualizarTablaProveedores(List<Proveedor> listaProveedores, JTable tablaProveedores) {
    	DefaultTableModel modelProveedores = (DefaultTableModel) miCoordinador.getVentanaGerente().getTbProveedoresVG().getModel();
    	modelProveedores.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
    }
	 
    public void actualizarTablaPedidos(List<Pedido> listaPedidos, JTable tablaPedidos) {
    	DefaultTableModel modelPedidos = (DefaultTableModel) miCoordinador.getVentanaGerente().getTbPedidosVG().getModel();
    	modelPedidos.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
    }
    
    public void actualizarTablaDetallePedidos(List<DetallePedido> listaDetallePedidos, JTable tablaDetallePedidos) {
    	DefaultTableModel modelDetallePedidos = (DefaultTableModel) miCoordinador.getVentanaGerente().getTbPedidosVG().getModel();
    	modelDetallePedidos.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
    }

/****************************************************	
		
MÉTODOS  OTRAS CONSULTAS

*****************************************************/	 
	 
	 public Producto buscarIdProductoPorNombre(String nombreProducto) {
		 Session session = null;
		    try {
		        // Abrir la sesión de Hibernate
		        session = miConexion.getSessionFactory().openSession();
		        // Iniciar la transacción
		        session.beginTransaction();

		        // Crear la consulta para buscar el producto por nombre del producto
		        Query<Producto> query = session.createQuery("FROM Producto WHERE nombreProducto = :nombreProducto", Producto.class);
		        query.setParameter("nombreProducto", nombreProducto);
		       
		        // Ejecutar la consulta y obtener el producto si se encuentra algún producto con el nombre dado
		        Producto producto = query.uniqueResult();

		        // Confirmar la transacción
		        session.getTransaction().commit();
		        
		        // Devolver el producto encontrado
		        return producto;
		    } catch (Exception e) {
		        // Manejo de excepciones
		        if (session != null && session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        // Cerrar la sesión de Hibernate
		        if (session != null) {
		            session.close();
		        }
		    }
		    return null; // Devolver null si no se encuentra ningún producto con el nombre dado
		}
	 
	 public Cliente buscarClienteIdPorTelefono(String telefono) {
		 Session session = null;
		 try {
			 // Abrir la sesión de Hibernate
			 session = miConexion.getSessionFactory().openSession();
			 // Iniciar la transacción
			 session.beginTransaction();

			 // Crear la consulta para verificar si existe un cliente con el número de teléfono dado
			 Query<Cliente> query = session.createQuery("FROM Cliente WHERE telefonoCliente = :telefono", Cliente.class);
			 query.setParameter("telefono", telefono);
		       
			 // Ejecutar la consulta y verificar si se encuentra algún cliente con el número de teléfono dado
			 return query.uniqueResult();

			 // Confirmar la transacción
		       
		 } catch (Exception e) {
			 // Manejo de excepciones
			 if (session != null && session.getTransaction() != null) {
				 session.getTransaction().rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 // Cerrar la sesión de Hibernate
			 if (session != null) {
				 session.close();
			 }
		 }
		 return null;
	}
	    
	
	public boolean comprobarTelefonoClienteRegistrado(String telefono) {
	    boolean registrado = false;
	    Session session = null;
	    try {
	        // Abrir la sesión de Hibernate
	        session = miConexion.getSessionFactory().openSession();
	        // Iniciar la transacción
	        session.beginTransaction();

	        // Crear la consulta para verificar si existe un cliente con el número de teléfono dado
	        Query<Cliente> query = session.createQuery("FROM Cliente WHERE telefonoCliente = :telefono", Cliente.class);
	        query.setParameter("telefono", telefono);
	       
	        // Ejecutar la consulta y verificar si se encuentra algún cliente con el número de teléfono dado
	        registrado = (query.uniqueResult() != null);

	        // Confirmar la transacción
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        // Manejo de excepciones
	        if (session != null && session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        // Cerrar la sesión de Hibernate
	        if (session != null) {
	            session.close();
	        }
	    }
	  
	    return registrado;
	}
	 
	// Método para obtener el precio de un producto por su ID
	    public double obtenerPrecioProductoPorId(String idProducto) {
	        double precioProducto = 0.0;

	        // Obtener la sesión de Hibernate desde la conexión
	        Session session = miConexion.getSessionFactory().openSession();

	        try {
	            // Crear la consulta HQL para obtener el precio del producto por su ID
	            Query<Double> query = session.createQuery("SELECT p.precioVentaProducto FROM Producto p WHERE p.idProducto = :idProducto", Double.class);
	            query.setParameter("idProducto", idProducto);

	            // Ejecutar la consulta y obtener el precio del producto
	            precioProducto = query.uniqueResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sesión de Hibernate
	            session.close();
	        }

	        return precioProducto;
	    }
	    
	 // Método para calcular cuántos productos se han consumido
	    public int calcularCantidadProductosConsumidos() {
	    	 int cantidadTotal = 0;

	    	    // Obtener la sesión de Hibernate desde la conexión
	    	    Session session = miConexion.getSessionFactory().openSession();

	    	    try {
	    	        // Crear la consulta HQL para obtener la suma de la cantidad de productos en todos los detalles de pedidos
	    	        Query<Long> query = session.createQuery("SELECT SUM(p.cantidadProductoSolicitado) FROM Pedido p", Long.class);

	    	        // Ejecutar la consulta y obtener la cantidad total de productos consumidos
	    	        Long resultado = query.uniqueResult();
	    	        cantidadTotal = resultado != null ? resultado.intValue() : 0;
	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	    } finally {
	    	        // Cerrar la sesión de Hibernate
	    	        session.close();
	    	    }

	    	    return cantidadTotal;
	       
	    }
	  
	    public String calcularProductoMasDemandado() {
	    	String nombreProductoMasDemandado = null;

	        // Obtener la sesión de Hibernate desde la conexión
	        Session session = miConexion.getSessionFactory().openSession();

	        try {
	            // Crear la consulta HQL para obtener el nombre del producto más demandado
	            Query<Object[]> query = session.createQuery("SELECT p.nombreProductoSolicitado, SUM(p.cantidadProductoSolicitado) " +
	                                                         "FROM Pedido p " +
	                                                         "GROUP BY p.nombreProductoSolicitado " +
	                                                         "ORDER BY SUM(p.cantidadProductoSolicitado) DESC", Object[].class);
	            // Establecer el límite de resultados a 1 para obtener solo el producto más demandado
	            query.setMaxResults(1);

	            // Ejecutar la consulta y obtener el resultado como un arreglo de objetos
	            Object[] resultado = query.uniqueResult();
	            
	            // Verificar si se encontró algún resultado
	            if (resultado != null) {
	                // El primer elemento del arreglo es el nombre del producto
	                nombreProductoMasDemandado = (String) resultado[0];
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sesión de Hibernate
	            session.close();
	        }

	        return nombreProductoMasDemandado;
	       
	    }	    
	    
	    public int calcularTotalProductosEnStock() {
	        int totalProductosEnStock = 0;

	        // Obtener la sesión de Hibernate desde la conexión
	        Session session = miConexion.getSessionFactory().openSession();

	        try {
	            // Crear la consulta HQL para obtener la suma de la cantidad de productos en stock
	            Query<Long> query = session.createQuery("SELECT SUM(p.cantidadStock) FROM Producto p", Long.class);

	            // Ejecutar la consulta y obtener el total de productos en stock
	            Long resultado = query.uniqueResult();
	            
	            // Verificar si se encontró algún resultado
	            if (resultado != null) {
	                totalProductosEnStock = resultado.intValue();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sesión de Hibernate
	            session.close();
	        }

	        return totalProductosEnStock;
	    }	    
	    
	    public double calcularTotalCaja() {
	    	double totalCaja = 0.0;

	        // Obtener la sesión de Hibernate desde la conexión
	        Session session = miConexion.getSessionFactory().openSession();

	        try {
	            // Crear la consulta HQL para obtener la suma del total de tickets de todos los pedidos
	            Query<Double> query = session.createQuery("SELECT SUM(p.totalTicketPedido) FROM Pedido p", Double.class);

	            // Ejecutar la consulta y obtener el total en caja
	            totalCaja = query.uniqueResult();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sesión de Hibernate
	            session.close();
	        }

	        return totalCaja;
	    }
	    
	    public double calcularTicketMedio() {
	        double ticketMedio = 0.0;

	        // Obtener la sesión de Hibernate desde la conexión
	        Session session = miConexion.getSessionFactory().openSession();

	        try {
	            // Crear la consulta HQL para obtener el ticket medio
	            Query<Double> query = session.createQuery("SELECT AVG(p.totalTicketPedido) FROM Pedido p", Double.class);

	            // Ejecutar la consulta y obtenemos el ticket medio
	            ticketMedio = query.uniqueResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sesión de Hibernate
	            session.close();
	        }

	        return ticketMedio;
	    }
	    
	    public double calcularTicketMasAlto() {
	        double ticketMasAlto = 0.0;

	        // Obtener la sesión de Hibernate desde la conexión
	        Session session = miConexion.getSessionFactory().openSession();

	        try {
	            // Crear la consulta HQL para obtener el máximo total de ticket de todos los pedidos
	            Query<Double> query = session.createQuery("SELECT MAX(p.totalTicketPedido) FROM Pedido p", Double.class);

	            // Ejecutar la consulta y obtener el ticket más alto
	            ticketMasAlto = query.uniqueResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sesión de Hibernate
	            session.close();
	        }

	        return ticketMasAlto;
	    }
	    
	    public int calcularTotalPedidos() {
	        int totalPedidos = 0;

	        // Obtener la sesión de Hibernate desde la conexión
	        Session session = miConexion.getSessionFactory().openSession();

	        try {
	            // Crear la consulta HQL para obtener el número total de pedidos
	            Query<Number> query = session.createQuery("SELECT COUNT(p) FROM Pedido p", Number.class);

	            // Ejecutar la consulta y obtener el número total de pedidos
	            Number result = query.uniqueResult();
	            if (result != null) {
	                totalPedidos = result.intValue();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la sesión de Hibernate
	            session.close();
	        }

	        return totalPedidos;
	    }

}