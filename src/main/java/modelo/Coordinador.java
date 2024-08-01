package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ClienteDAO;
import controlador.Conexion;
import controlador.DetallePedidoDAO;
import controlador.EmpleadoDAO;
import controlador.PedidoDAO;
import controlador.Procesos;
import controlador.ProductoDAO;
import controlador.ProveedorDAO;
import vista.VentanaCliente;
import vista.VentanaEmpleado;
import vista.VentanaGerente;
import vista.VentanaLista;
import vista.VentanaPrincipal;

public class Coordinador {

	private VentanaPrincipal ventanaPrincipal;
	private VentanaLista ventanaLista;
	private VentanaCliente ventanaCliente;
	private VentanaEmpleado ventanaEmpleado;
	private VentanaGerente ventanaGerente;
	
	private Procesos misProcesos;
	
	private Conexion miConexion;
	
	private ClienteDAO miClienteDAO;
	private EmpleadoDAO miEmpleadoDAO;
	private PedidoDAO miPedidoDAO;
	private DetallePedidoDAO miDetallePedidoDAO;
	private ProductoDAO miProductoDAO;
	private ProveedorDAO miProveedorDAO;
	
	private Object[] datosItemProvisional;
	private List<Object[]> productosSeleccionadosProvisional = new ArrayList<>();
	private Map<String, Object[]> detallesSinConfirmar = new HashMap<>();
	private static int ordenPedido = 0;
	private Empleado empleadoTrabajando;
	
	/**
	 * 
	 * Metodos getter y setter
	 */
	public Map<String,Object[] > getDetallesSinConfirmar() {
		return detallesSinConfirmar;
	}

	public void setDetallesSinConfirmar(Map<String, Object[]> detallesSinConfirmar) {
		this.detallesSinConfirmar = detallesSinConfirmar;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {

		this.ventanaPrincipal = ventanaPrincipal;;
	}

	public VentanaLista getVentanaLista() {
		return ventanaLista;
	}

	public void setVentanaLista(VentanaLista ventanaLista) {
		
		this.ventanaLista = ventanaLista;
	}

	public VentanaCliente getVentanaCliente() {
		return ventanaCliente;
	}

	public void setVentanaCliente(VentanaCliente ventanaCliente) {
		
		this.ventanaCliente = ventanaCliente;
	}

	public VentanaEmpleado getVentanaEmpleado() {
		return ventanaEmpleado;
	}

	public void setVentanaEmpleado(VentanaEmpleado ventanaEmpleado) {
		
		this.ventanaEmpleado = ventanaEmpleado;
	}
	
	public VentanaGerente getVentanaGerente() {
		return ventanaGerente;
	}

	public void setVentanaGerente(VentanaGerente ventanaGerente) {
		
		this.ventanaGerente = ventanaGerente;
	}

	public Conexion getConexion() {
		return miConexion;
	}
	
	public void setConexion(Conexion miConexion) {
		
		this.miConexion = miConexion;
	}	
	
	public Procesos getProcesos() {
		return misProcesos;
	}

	public void setProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;
	}	
	
	public ClienteDAO getClienteDAO() {
		return miClienteDAO;
	}

	public void setClienteDAO(ClienteDAO miClienteDAO) {
		this.miClienteDAO = miClienteDAO;
	}

	public EmpleadoDAO getEmpleadoDAO() {
		return miEmpleadoDAO;
	}

	public void setEmpleadoDAO(EmpleadoDAO miEmpleadoDAO) {
		this.miEmpleadoDAO = miEmpleadoDAO;
	}

	public PedidoDAO getPedidoDAO() {
		return miPedidoDAO;
	}

	public void setPedidoDAO(PedidoDAO miPedidoDAO) {
		this.miPedidoDAO = miPedidoDAO;
	}

	public DetallePedidoDAO getDetallePedidoDAO() {
		return miDetallePedidoDAO;
	}

	public void setDetallePedidoDAO(DetallePedidoDAO miDetallePedidoDAO) {
		this.miDetallePedidoDAO = miDetallePedidoDAO;
	}

	public ProductoDAO getProductoDAO() {
		return miProductoDAO;
	}

	public void setProductoDAO(ProductoDAO miProductoDAO) {
		this.miProductoDAO = miProductoDAO;
	}

	public ProveedorDAO getProveedorDAO() {
		return miProveedorDAO;
	}

	public void setProveedorDAO(ProveedorDAO miProveedorDAO) {
		this.miProveedorDAO = miProveedorDAO;
	}

/****************************************************	

MÉTODOS DE VENTANA PRINCIPAL

*****************************************************/
	
	//método para mostrar VentanaPrincipal
	public void mostrarVentanaPrincipal() {
			
		ventanaPrincipal.setVisible(true);
	}

	//método para mostrar VentanaLista
	public void mostrarVentanaLista() {
		
		ventanaLista.setVisible(true);
	}

	//método para mostrar VentanaCliente
	public void mostrarVentanaCliente() {
	
		ventanaCliente.setVisible(true);
	}

	//método para mostrar VentanaEmpleado
	public void mostrarVentanaEmpleado() {
	
		ventanaEmpleado.setVisible(true);
	}

	//método para mostrar VentanaGerente
	public void mostrarVentanaGerente() {
	
		ventanaGerente.setVisible(true);
	}
	
	//método para el boton cerrar de VentanaPrincipal
	public void salir() {
		miConexion.desconectar();	
		System.exit(0);
	}

/****************************************************	
	
	MÉTODOS DE VENTANA CLIENTE

*****************************************************/

	//método para el boton volver de VentanaClientes
	public void volverVentanaCliente() {
		//volver a VentanaLista		
		ventanaCliente.dispose(); 
	}
	
	//método para el boton ayuda de VentanaClientes
	public void ayuda() {

		int respuesta = JOptionPane.showConfirmDialog(null, "¿Necesita asistencia para hacer su pedido?", "Ayuda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
        	JOptionPane.showMessageDialog(null, "En breve vendrá un miembro del equipo para atenderle, espere", "Solicitud de ayuda", JOptionPane.INFORMATION_MESSAGE);
	    	
            // Obtener referencia al JTextArea en la ventana del empleado
           
            ventanaEmpleado.getTxtAreaSinConfirmar().setText("SOLICITUD DE AYUDA");
           
        } else {
            // Acción si el usuario elige "No"
        }
	}
	
	//método para añadir un comentario al ticket
	public void comentarTicket() {
				
		// Obtener el nuevo comentario del campo txtComentario
		String nuevoComentario = ventanaCliente.getTxtComentario().getText();
				    
		// Verificar si el nuevo comentario no está vacío
		if (!nuevoComentario.trim().isEmpty()) {
			// Obtener el texto actual del área de texto
			String comentarioActual = ventanaCliente.getTxtAreaComentario().getText();
				        
			// Concatenar el nuevo comentario al texto actual del área de texto, separado por una nueva línea
			String comentarioActualizado = comentarioActual + "\n" + nuevoComentario;
				        
			// Establecer el texto actualizado en el área de texto
			ventanaCliente.setTxtAreaComentario(comentarioActualizado);
		}
				    
		// Limpiar el campo de texto txtComentario
		ventanaCliente.setTxtComentario("");
	}	
		
	//método para el boton reiniciar para vaciar todo el texto de la ventana del ticket de VentanaClientes
	public void reiniciarTicket() {
		ventanaCliente.getTxtAreaComentario().setText("");
		ventanaCliente.getTxtAreaListaTicket().setText("");
		// Establecer el valor de lbtTotal a 0
		ventanaCliente.getLblTotalTicket().setText("0 €");
	}
	
	public Object[] agregarItemTicket(@SuppressWarnings("rawtypes") JComboBox comboBox, JSpinner spinner, JLabel lblPrecio, String nombreItem) {
		
		String tipoItem;
	    int cantidadItem = 0;
	    double precioItemDouble = 0.0;
	    double precioSumaItem = 0.0;

	    tipoItem = (String) comboBox.getSelectedItem();

	    cantidadItem = (int) spinner.getValue();

	    String precioItemString = lblPrecio.getText();
	    String precioItemStringNoSimbol = precioItemString.substring(0, precioItemString.length() - 1);

	    if (tipoItem != null && !tipoItem.isEmpty() && cantidadItem > 0) {
	        String cantidadItemString = String.valueOf(cantidadItem);
	        precioItemDouble = Double.parseDouble(precioItemStringNoSimbol);
	        precioSumaItem = precioItemDouble * cantidadItem;

	        String textoTicket = "-" + nombreItem + ": " + tipoItem + ", Cantidad: " + cantidadItemString + ", Suma: " + precioSumaItem + "\n";

	        ventanaCliente.getTxtAreaListaTicket().append(textoTicket);

	        spinner.setValue(0);
	        comboBox.setSelectedIndex(0);

	        datosItemProvisional = new Object[]{tipoItem, cantidadItem, precioItemDouble, precioSumaItem};
	       
	        productosSeleccionadosProvisional.add(datosItemProvisional);
	        return datosItemProvisional;
	    
	    } else if (cantidadItem == 0) {
			 // Si la cantidad es cero, no hacer nada
			 return null;
	    } else {
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un(a) " + nombreItem + ".");
	         datosItemProvisional = new Object[]{null, 0, 0.0, 0.0};
	       
	        return datosItemProvisional;
	    }
	    
	}

	public Object[] agregarPizza() {
	    return agregarItemTicket(ventanaCliente.getJComboPizza(), ventanaCliente.getSpinnerPizza(), ventanaCliente.getLblPrecioPizza(), "Pizza");
	}

	public Object[] agregarHamburguesa() {
	    return agregarItemTicket(ventanaCliente.getJComboHamburguesa(), ventanaCliente.getSpinnerHamburguesa(), ventanaCliente.getLblPrecioHamburguesa(), "Hamburguesa");
	}

	public Object[] agregarHotDog() {
	    return agregarItemTicket(ventanaCliente.getJComboHotDog(), ventanaCliente.getSpinnerHotDog(), ventanaCliente.getLblPrecioHotDog(), "HotDog");
	}

	public Object[] agregarPasta() {
	    return agregarItemTicket(ventanaCliente.getJComboPasta(), ventanaCliente.getSpinnerPasta(), ventanaCliente.getLblPrecioPasta(), "Pasta");
	}

	public Object[] agregarEnsalada() {
	    return agregarItemTicket(ventanaCliente.getJComboEnsalada(), ventanaCliente.getSpinnerEnsalada(), ventanaCliente.getLblPrecioEnsalada(), "Ensalada");
	}

	public Object[] agregarBebida() {
	    return agregarItemTicket(ventanaCliente.getJComboBebida(), ventanaCliente.getSpinnerBebida(), ventanaCliente.getLblPrecioBebida(), "Bebida");
	}

	public Object[] agregarPostre() {
	    return agregarItemTicket(ventanaCliente.getJComboPostre(), ventanaCliente.getSpinnerPostre(), ventanaCliente.getLblPrecioPostre(), "Postre");
	}
	
	public void agregarPrecioTotal() {
		
		// Declarar variables para almacenar los precios totales de cada tipo de elemento
	    double precioSumaPizzaProvisional = 0.0;
	    double precioSumaHamburguesaProvisional = 0.0;
	    double precioSumaHotDogProvisional = 0.0;
	    double precioSumaPastaProvisional = 0.0;
	    double precioSumaEnsaladaProvisional = 0.0;
	    double precioSumaBebidaProvisional = 0.0;
	    double precioSumaPostreProvisional = 0.0;
	    
		 // Llamar a los métodos de agregar para cada tipo de elemento y sumar los precios totales
	    Object[] datosPizza = agregarPizza();
	    if (datosPizza != null) {
	        precioSumaPizzaProvisional += (double) datosPizza[3];
	    }
	    
	    Object[] datosHamburguesa = agregarHamburguesa();
	    if (datosHamburguesa != null) {
	        precioSumaHamburguesaProvisional += (double) datosHamburguesa[3];
	    }
	    
	    Object[] datosHotDog = agregarHotDog();
	    if (datosHotDog != null) {
	        precioSumaHotDogProvisional += (double) datosHotDog[3];
	    }
	    
	    Object[] datosPasta = agregarPasta();
	    if (datosPasta != null) {
	        precioSumaPastaProvisional += (double) datosPasta[3];
	    }
	    
	    Object[] datosEnsalada = agregarEnsalada();
	    if (datosEnsalada != null) {
	        precioSumaEnsaladaProvisional += (double) datosEnsalada[3];
	    }
	    
	    Object[] datosBebida = agregarBebida();
	    if (datosBebida != null) {
	        precioSumaBebidaProvisional += (double) datosBebida[3];
	    }
	    
	    Object[] datosPostre = agregarPostre();
	    if (datosPostre != null) {
	        precioSumaPostreProvisional += (double) datosPostre[3];
	    }

	    // Obtener el precio total actual del lblTotalTicket
	    String totalActualString = ventanaCliente.getLblTotalTicket().getText();
	    
	    // Reemplazar la coma por un punto para que el formato sea válido
	    totalActualString = totalActualString.replace(',', '.');

	    // Eliminar el símbolo de moneda (por ejemplo, €) del precio total actual 
	    String totalActualStringNoSimbol = totalActualString.substring(0, totalActualString.length() - 1);

	    // Pasar precio a double
	    double totalActualDouble = Double.parseDouble(totalActualStringNoSimbol);

	    // Calcular el nuevo precio total sumando el precio total actual con el precio total de Suma
	    double nuevoTotal = totalActualDouble + precioSumaPizzaProvisional + precioSumaHamburguesaProvisional + precioSumaHotDogProvisional + precioSumaPastaProvisional + precioSumaEnsaladaProvisional + precioSumaBebidaProvisional + precioSumaPostreProvisional;

	    // Actualizar el texto del lblTotalTicket con el nuevo precio total
	    ventanaCliente.getLblTotalTicket().setText(String.format("%.2f", nuevoTotal) + " €");
		 	
		}	
	
	public void reiniciarVentanaCliente() {
		//Poner a cero la cantidad en el spinner
		ventanaCliente.getSpinnerPizza().setValue(0);
				   
		//Poner en el indice 0 la seleccion del JComboBox
		ventanaCliente.getJComboPizza().setSelectedIndex(0);
					
		//Poner a cero la cantidad en el spinner
		ventanaCliente.getSpinnerHamburguesa().setValue(0);
				   
		//Poner en el indice 0 la seleccion del JComboBox
		ventanaCliente.getJComboHamburguesa().setSelectedIndex(0);
				
		//Poner a cero la cantidad en el spinner
		ventanaCliente.getSpinnerHotDog().setValue(0);
				   
		//Poner en el indice 0 la seleccion del JComboBox
		ventanaCliente.getJComboHotDog().setSelectedIndex(0);
				
		//Poner a cero la cantidad en el spinner
		ventanaCliente.getSpinnerPasta().setValue(0);
				   
		//Poner en el indice 0 la seleccion del JComboBox
		ventanaCliente.getJComboPasta().setSelectedIndex(0);
				
		//Poner a cero la cantidad en el spinner
		ventanaCliente.getSpinnerEnsalada().setValue(0);
				   
		//Poner en el indice 0 la seleccion del JComboBox
		ventanaCliente.getJComboEnsalada().setSelectedIndex(0);
				
		//Poner a cero la cantidad en el spinner
		ventanaCliente.getSpinnerBebida().setValue(0);
				   
		//Poner en el indice 0 la seleccion del JComboBox
		ventanaCliente.getJComboBebida().setSelectedIndex(0);
				
		//Poner a cero la cantidad en el spinner
		ventanaCliente.getSpinnerPostre().setValue(0);
				   
		//Poner en el indice 0 la seleccion del JComboBox
		ventanaCliente.getJComboPostre().setSelectedIndex(0);
				
		//Vaciar el txtComentario
		ventanaCliente.getTxtComentario().setText("");
						
		//Vaciar el txtAreaComentario
		ventanaCliente.getTxtAreaComentario().setText("");
				
		//Vaciar el txtAreaListaTicket
		ventanaCliente.getTxtAreaListaTicket().setText("");
				
		//Poner a 0 el Total del ticket
		ventanaCliente.getLblTotalTicket().setText("0 €");;
				
		//Vaciar el txtNombre
		ventanaCliente.getTxtNombre().setText("");
				
		//Vaciar el txtTelefono
		ventanaCliente.getTxtTelefono().setText("");
				
		//Vaciar el txtDNI
		ventanaCliente.getTxtDNI().setText("");
				
		//Vaciar el txtEMail
		ventanaCliente.getTxtEMail().setText("");
				
		//Vaciar el txtClienteID
		ventanaCliente.getTxtDireccion().setText("");
		
		volverVentanaCliente();
	}	
	
	public void elegirModoRegistroPedido() {
		 // Confirmar si se desea realizar el pedido
	    int respuestaPedido = JOptionPane.showConfirmDialog(null, "¿Desea realizar el pedido?",
	            "Confirmar Pedido", JOptionPane.YES_NO_OPTION);

	    // Proceder si el usuario confirma
	    if (respuestaPedido == JOptionPane.YES_OPTION) {
	        // Verificar si el número de teléfono está registrado en la base de datos
	        String telefono = ventanaCliente.getTxtTelefono().getText();
	        boolean clienteRegistrado = misProcesos.comprobarTelefonoClienteRegistrado(telefono);
	        
	        // Si el cliente está registrado, realizar el pedido sin registro
	        if (clienteRegistrado) {
	        	modoPedidoSinRegistro();
	            
	        } else {
	            // Si el cliente no está registrado, solicitar registro como nuevo cliente
	            int respuestaRegistro = JOptionPane.showConfirmDialog(null, "No está registrado como cliente. ¿Desea registrarse como nuevo cliente?",
	                    "Nuevo Cliente", JOptionPane.YES_NO_OPTION);
	            
	            // Proceder con el registro si el usuario confirma
	            if (respuestaRegistro == JOptionPane.YES_OPTION) {
	                if (modoPedidoConRegistro()) {
	                    // Realizar el pedido provisional con registro
	                     realizarPedido();
	                     
	                } 
	            }
	        }
	    }
	
	}
	
	public boolean modoPedidoSinRegistro() {		
		
		// Verificar si los campos obligatorios están completos
	   if (!ventanaCliente.getTxtAreaListaTicket().getText().isBlank() && 
			   !ventanaCliente.getTxtNombre().getText().isBlank() && 
			   !ventanaCliente.getTxtTelefono().getText().isBlank() &&
			   ventanaCliente.getTxtDNI().getText().isBlank() &&
			   ventanaCliente.getTxtEMail().getText().isBlank() && 
			   ventanaCliente.getTxtDireccion().getText().isBlank()) {	    

		   realizarPedido();		   		   
		   return true;  	     
	    } else {   
	    	
	    	// Mostrar mensaje de advertencia si faltan campos obligatorios
	        JOptionPane.showMessageDialog(null, "Asegúrese de haber agregado algún elemento del menú al ticket, completado el nombre y el teléfono correctamente. Por favor, complete los campos obligatorios.", "Campos Obligatorios", JOptionPane.WARNING_MESSAGE);
	        return false;
	    }   
	   
	}
	
	@SuppressWarnings("static-access")
	public boolean modoPedidoConRegistro() {		
	
		if (!ventanaCliente.getTxtAreaListaTicket().getText().isBlank() && 
			!ventanaCliente.getTxtNombre().getText().isBlank() && 
			!ventanaCliente.getTxtTelefono().getText().isBlank() && 
			!ventanaCliente.getTxtDNI().getText().isBlank() && 
			!ventanaCliente.getTxtEMail().getText().isBlank() && 
			!ventanaCliente.getTxtDireccion().getText().isBlank()) {
	    	     
			// Verificar si el cliente ya está registrado
			boolean clienteRegistrado = misProcesos.comprobarTelefonoClienteRegistrado(ventanaCliente.getTxtTelefono().getText());
		         
			if (!clienteRegistrado) {
	 	        	
				// Si el cliente no está registrado, registrar al cliente	  
	                
				Cliente primerRegistroCliente = new Cliente();
	                
				primerRegistroCliente.setIdCliente(misProcesos.generarClienteID(8));
				primerRegistroCliente.setNombreCliente(ventanaCliente.getTxtNombre().getText());
				primerRegistroCliente.setClienteDNI(ventanaCliente.getTxtDNI().getText());
				primerRegistroCliente.setDireccionCliente(ventanaCliente.getTxtDireccion().getText());
				primerRegistroCliente.setTelefonoCliente(ventanaCliente.getTxtTelefono().getText());
				primerRegistroCliente.setEmailCliente(ventanaCliente.getTxtEMail().getText());
				primerRegistroCliente.setPuntosCliente(5);
	 	        	
				miClienteDAO.guardarCliente(primerRegistroCliente);
	 	        	
				JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.", "Registro de Cliente Exitoso", JOptionPane.INFORMATION_MESSAGE);
	 	        	      
	              
				return true;
			}
			// Si el cliente no está registrado, se permite el pedido sin registro
			return true;   
	    	    
		} else {   
	    	    	
			// Mostrar mensaje de advertencia si faltan campos obligatorios
			JOptionPane.showMessageDialog(null, "Para registrarse como nuevo cliente, complete todos los datos de contacto.", "Campos Obligatorios", JOptionPane.WARNING_MESSAGE);
			return false;     
		}   
	        
	}
		
	public void realizarPedido() {
	
		// Verificar si hay productos seleccionados
		if (productosSeleccionadosProvisional.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "No hay productos seleccionados para realizar el pedido.", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}

		// Obtener el cliente por teléfono
		String telefonoCliente = ventanaCliente.getTxtTelefono().getText();
		Cliente idClienteProvisional = misProcesos.buscarClienteIdPorTelefono(telefonoCliente);

		// Verificar si se encontró el cliente
		if (idClienteProvisional == null) {
		    JOptionPane.showMessageDialog(null, "Cliente no encontrado. El numero de telefono no se ha encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}

		// Generar ID de pedido provisional
		@SuppressWarnings("static-access")
		String idPedidoProvisional = misProcesos.generarPedidoID(8);

		// Declarar variables para el precio total y el texto del ticket
	
		 String nombreItemProvisional = "";
		 int cantidadItemProvisional = 0;

		// Utilizar la información almacenada en la lista de productos seleccionados
		for (Object[] producto : productosSeleccionadosProvisional) {
		    if (producto == null) {
		        // Manejar el caso cuando no se pudo obtener la información del producto
		        continue;
		    }
		    nombreItemProvisional = (String) producto[0];
		    cantidadItemProvisional = (int) producto[1];
	  
		}

		// Mostrar el mensaje de confirmación
		String metodoPagoProvisional = ventanaCliente.getTextBtnGroupMetodoPago().toString();
		String comentarioClienteProvisional = ventanaCliente.getTxtAreaComentario().getText();
		String textoTicketClienteProvisional = ventanaCliente.getTxtAreaListaTicket().getText();
		
		// Buscar el ID del producto por su nombre
	    Producto idProductoProvisional = misProcesos.buscarIdProductoPorNombre(nombreItemProvisional);
		 // Obtener el precio del producto
	    String precioString = ventanaCliente.getLblTotalTicket().getText().trim();
	    // Eliminar el símbolo del euro y los espacios en blanco
	    precioString = precioString.replaceAll("[€\\s]", "");
	    // Reemplazar las comas por puntos
	    precioString = precioString.replace(",", ".");
	    double precioTotalTicketProvisional = Double.parseDouble(precioString);

		JOptionPane.showMessageDialog(null, "Detalles del Pedido:\n" +
	        "Numero de Orden: " + ordenPedido + "\n" +
	        "ID de Pedido: " + idPedidoProvisional + "\n" +
	        "Teléfono: " + idClienteProvisional.getTelefonoCliente().toString() + "\n" +
	        "Pedido Seleccionado:\n" + textoTicketClienteProvisional + "\n" +
	        "Comentario: " + comentarioClienteProvisional + "\n" +
	        "Método de Pago: " + metodoPagoProvisional + "\n" +
	        "Total: " + precioTotalTicketProvisional + "\n" +
	        "Pedido realizado con éxito. En breve tendremos su pedido listo, " + idClienteProvisional.getNombreCliente().toString() +
	        ". Permanezca atento a la pantalla.",
	        "Pedido Realizado", JOptionPane.INFORMATION_MESSAGE);

		// Guardar el pedido sin confirmar
		guardarPedidoSinConfirmar(idPedidoProvisional, idClienteProvisional, idProductoProvisional, metodoPagoProvisional,
				nombreItemProvisional, cantidadItemProvisional, precioTotalTicketProvisional, comentarioClienteProvisional,
		        textoTicketClienteProvisional);
		contadorPedidosEmpleado();
		volverVentanaCliente();
		reiniciarVentanaCliente();
		}
	
/****************************************************	
	
MÉTODOS DE VENTANA EMPLEADO

*****************************************************/
	
	public void guardarPedidoSinConfirmar(String idPedidoProvisional, Cliente idClienteProvisional, Producto idProductoProvisional,
		String metodoPagoProvisional, String nombreProductoProvisional, int cantidadProductoProvisional, double precioTotalTicket,
		String comentarioClienteProvisional, String	textoTicketClienteProvisional) {

		ordenPedido++;
		
		@SuppressWarnings("unused")
		String nombrePedido = nombreProductoProvisional;
		String idPedido =  idPedidoProvisional;
		String estadoPedido = "Sin Confirmar";
		
		// Agregar el pedido a la lista de pedidos sin confirmar
	    DefaultListModel<String> modeloListaSinConfirmar = (DefaultListModel<String>) ventanaEmpleado.getLstSinConfirmar().getModel();
  
	    String textoPedidoSC = "Pedido " + ordenPedido;
	    
	    modeloListaSinConfirmar.addElement(textoPedidoSC);
	    
	    // Asignar el modelo actualizado a la lista
	    ventanaEmpleado.getLstSinConfirmar().setModel(modeloListaSinConfirmar);
	    
	    Object[] datosPedido = {estadoPedido, textoPedidoSC, idPedido, idClienteProvisional, idProductoProvisional, metodoPagoProvisional,
	    	nombreProductoProvisional, cantidadProductoProvisional, precioTotalTicket, comentarioClienteProvisional, textoTicketClienteProvisional,
	    	idClienteProvisional.getTelefonoCliente(), idClienteProvisional.getDireccionCliente(), idClienteProvisional.getClienteDNI(),
	    	idClienteProvisional.getEmailCliente()};
	    
	   // recogerDetallesPedido(datosPedido);
	    
	    DefaultTableModel modelTablaSinConfirmarVE = (DefaultTableModel) ventanaEmpleado.getTbSinConfirmar().getModel();
	    DefaultTableModel modelTablaSinConfirmarVL = (DefaultTableModel) ventanaLista.getTbVentanaLista().getModel();
	    DefaultTableModel modelTablaEPClientes = (DefaultTableModel) ventanaCliente.getTbEPCliente().getModel();
	    
	    Object[] fila = {textoPedidoSC, idClienteProvisional.getNombreCliente(), idPedido, estadoPedido};
	    
	    modelTablaSinConfirmarVE.addRow(fila);
	    modelTablaSinConfirmarVL.addRow(fila);
	    modelTablaEPClientes.addRow(fila);

	    mostrarDatosItemLstSinConfirmar(datosPedido);

	}
	
	private String construirTextoPedido(Object[] datosPedido) {
        // Construir el texto con los detalles del pedido
		@SuppressWarnings("unused")
		Object[] datos = datosPedido;
	
		return "Detalles del Pedido:\n" +
		"Numero de Orden: " + datosPedido[1] + "\n" +
		"ID de Pedido: " + datosPedido[2] + "\n" +
		"Teléfono: " + datosPedido[11] + "\n" +
		"Dirección: " + datosPedido[12] + "\n" +
		"DNI: " + datosPedido[13] + "\n" +
		"Email: " + datosPedido[14] + "\n" +
		"Pedido Seleccionado:\n" + datosPedido[10] + "\n" +
		"Comentario: " + datosPedido[9] + "\n" +
		"Método de Pago: " + datosPedido[5] + "\n" +
		"Total: " + datosPedido[8] + "\n";
	}
	private Object[] construirDetallesPedido(Object[] datosPedido) {
        // devolver el objeto con los detalles del pedido
		Object[] datos = datosPedido;
	
		return datos;
	}
	
	public Object obtenerDatosPedidoPorNumeroOrden(String numeroOrden) {
		
		return detallesSinConfirmar.get(numeroOrden);
	}
	
	private void refrescarTabla(JTable tabla) {
	    DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
	    modeloTabla.fireTableDataChanged(); // Notificar a la tabla que los datos han cambiado
	}
	
	public void mostrarDatosItemLstSinConfirmar(Object datosPedido) {
				
		if (datosPedido instanceof Object[]) {
			// Procesar el arreglo de objetos
			Object[] datos = (Object[]) datosPedido;
		
			String textoPedido = datos[1].toString();
			@SuppressWarnings("unused")
			String idPedido = datos[2].toString();
			
			Object[] detalles = construirDetallesPedido(datos);			
			
			ventanaEmpleado.getTxtAreaSinConfirmar().setText(construirTextoPedido(datos));
			detallesSinConfirmar.put(textoPedido,detalles);
			
			ventanaEmpleado.getTxtPagoElegidoVE().setText(detalles[5].toString());
			ventanaEmpleado.getLblTotalTicketVE().setText(detalles[8].toString());
		} else if (datosPedido instanceof String) {
			
			// Manejar la cadena de texto seleccionada
			String textoSeleccionado = (String) datosPedido;
		        
			// Actualizar el txtAreaSinConfirmar con el texto seleccionado
			ventanaEmpleado.getTxtAreaSinConfirmar().setText(textoSeleccionado);
		
		}		
	}
	
	private void eliminarFilaPorNumeroOrden(JTable tabla, String numeroOrden) {
	    DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
	    
	    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
	        if (modeloTabla.getValueAt(i, 0).equals(numeroOrden)) {
	        	
	            modeloTabla.removeRow(i);//eliminar la fila
	            break; // Detener el bucle después de eliminar la fila
	        }
	    }
	}
	
	public void eliminarPedidoEmpleadoSC() {
		// Obtener el modelo de la lista
	    DefaultListModel<String> modeloListaSinConfirmar = (DefaultListModel<String>) ventanaEmpleado.getLstSinConfirmar().getModel();
	    
	    // Verificar si hay un elemento seleccionado
	    if (!ventanaEmpleado.getLstSinConfirmar().isSelectionEmpty()) {
	    	
	    	 // Obtener el número de orden seleccionado
	        String numeroOrden = (String) ventanaEmpleado.getLstSinConfirmar().getSelectedValue();
	    	
	        // Eliminar el elemento seleccionado de la lista
	        modeloListaSinConfirmar.removeElement(numeroOrden);
     
	        // Eliminar la fila correspondiente a la orden en las tablas
	        eliminarFilaPorNumeroOrden(ventanaEmpleado.getTbSinConfirmar(), numeroOrden);
	        eliminarFilaPorNumeroOrden(ventanaLista.getTbVentanaLista(), numeroOrden);
	        eliminarFilaPorNumeroOrden(ventanaCliente.getTbEPCliente(), numeroOrden);
	        
	        // Borrar el texto asociado en txtAreaSinConfirmar
	        ventanaEmpleado.getTxtAreaSinConfirmar().setText("");
	        
	        // Refrescar las tablas
	        refrescarTabla(ventanaEmpleado.getTbSinConfirmar());
	        refrescarTabla(ventanaLista.getTbVentanaLista());
	        refrescarTabla(ventanaCliente.getTbEPCliente());
	    }		
	}
	
	private void modificarEstadoPedidoTabla(String numeroOrden, String estado) {
		
		DefaultTableModel modeloTablaSinConfirmarVL = (DefaultTableModel) ventanaLista.getTbVentanaLista().getModel();
		for (int i = 0; i < modeloTablaSinConfirmarVL.getRowCount(); i++) {
	        if (modeloTablaSinConfirmarVL.getValueAt(i, 0).equals(numeroOrden)) {
	        	modeloTablaSinConfirmarVL.setValueAt(estado, i, 3); // Columna 3 es el estado del pedido
	            break;
	        }
	    }
		
	    DefaultTableModel modeloTablaEPClientes = (DefaultTableModel) ventanaCliente.getTbEPCliente().getModel();
	    for (int i = 0; i < modeloTablaEPClientes.getRowCount(); i++) {
	        if (modeloTablaEPClientes.getValueAt(i, 0).equals(numeroOrden)) {
	        	modeloTablaEPClientes.setValueAt(estado, i, 3); // Columna 3 es el estado del pedido
	            break;
	        }
	    }
	    
	    DefaultTableModel modeloTablaSinConfirmar = (DefaultTableModel) ventanaEmpleado.getTbSinConfirmar().getModel();
	    for (int i = 0; i < modeloTablaSinConfirmar.getRowCount(); i++) {
	        if (modeloTablaSinConfirmar.getValueAt(i, 0).equals(numeroOrden)) {
	            modeloTablaSinConfirmar.setValueAt(estado, i, 3); // Columna 3 es el estado del pedido
	            break;
	        }
	    }
	    
	    // Actualizar las tablas
	    refrescarTabla(ventanaEmpleado.getTbSinConfirmar()); 
	    refrescarTabla(ventanaLista.getTbVentanaLista()); 
	    refrescarTabla(ventanaCliente.getTbEPCliente()); 
	}
    		
    public void confirmarPedidoEmpleadoSC() {
    	 // Verificar si hay un pedido seleccionado en la lista sin confirmar
        if (!ventanaEmpleado.getLstSinConfirmar().isSelectionEmpty()) {
            // Obtener el número de orden seleccionado
            String numeroOrden = (String) ventanaEmpleado.getLstSinConfirmar().getSelectedValue();

            // Obtener los datos del pedido por el número de orden
            Object datosPedido = obtenerDatosPedidoPorNumeroOrden(numeroOrden);//el objeto que devuelve es el mapa
                      
            // Verificar si se encontraron los datos del pedido
            if (datosPedido != null) {
            	
                // Agregar el número de pedido confirmado al modelo de la lista de pedidos confirmados
                DefaultListModel<String> modeloListaConfirmados = (DefaultListModel<String>) ventanaEmpleado.getLstPedidosConfirmados().getModel();
               
                modeloListaConfirmados.addElement(numeroOrden);
                
                // Modificar el estado del pedido de "Sin Confirmar" a "Confirmado" en la tabla correspondiente
                modificarEstadoPedidoTabla(numeroOrden, "Confirmado");

                // Mostrar detalles del pedido confirmado
                mostrarDetallesPedidoConfirmado(datosPedido);
                
                //obtener el modelo de la lista de pedidos sin confirmar
                DefaultListModel<String> modeloListaSinConfirmar = (DefaultListModel<String>) ventanaEmpleado.getLstSinConfirmar().getModel();
               
                //eliminar el elemento de la lista
                modeloListaSinConfirmar.removeElement(numeroOrden);
                
                //poner los textos en blanco
                ventanaEmpleado.getTxtAreaSinConfirmar().setText("");
                ventanaEmpleado.getTxtPagoElegidoVE().setText("");
                ventanaEmpleado.getLblTotalTicketVE().setText("");
                
                //actualizar el contador de los pedidos
                contadorPedidosEmpleado();
                
            } else {
                // Si no se encontraron los datos del pedido, mostrar un mensaje 
                System.err.println("No se encontraron datos para el pedido con número de orden: " + numeroOrden);
            }
            
            
        } else {
            // Si no se ha seleccionado ningún pedido en la lista sin confirmar, mostrar un mensaje de advertencia 
            System.err.println("No se ha seleccionado ningún pedido para confirmar.");
        }
    
    }
    
    public void obtenerDetallesPedidoConfirmado() {
    	
    	// Obtener el número de orden seleccionado
        String numeroOrden = (String) ventanaEmpleado.getLstSinConfirmar().getSelectedValue();
        
        if (numeroOrden != null) {
        	
            // Obtener los datos del pedido por el número de orden
            Object datosPedido = obtenerDatosPedidoPorNumeroOrden(numeroOrden);
            
            if (datosPedido != null) {
            	
                // Mostrar detalles del pedido confirmado en el txtAreaDetallePedidosConfirmados
                mostrarDetallesPedidoConfirmado(datosPedido);
                
            } else {
            	
                // Manejar el caso en que no se encuentren datos para el pedido
                ventanaEmpleado.getTxtAreaDetallePedidosConfirmados().setText("No se encontraron detalles para el pedido seleccionado.");
            }
        } else {
            // Manejar el caso en que no se haya seleccionado ningún pedido
            ventanaEmpleado.getTxtAreaDetallePedidosConfirmados().setText("No se ha seleccionado ningún pedido.");
        }

    }
	
    public void mostrarDetallesPedidoConfirmado(Object datosPedido) {
    	
    	if (datosPedido instanceof Object[]) {
    		
			// Procesar el arreglo de objetos
			Object[] datos = (Object[]) datosPedido;
			String textoPedido = datos[1].toString();
			@SuppressWarnings("unused")
			String idPedido = datos[2].toString();
			
			Object[] detalles = construirDetallesPedido(datos);
			
			// Actualizar el txtAreaDetallePedidosConfirmados con el texto de los datos
			ventanaEmpleado.getTxtAreaDetallePedidosConfirmados().setText(construirTextoPedido(datos));
			
			detallesSinConfirmar.put(textoPedido,detalles);
	
		} else if (datosPedido instanceof String) {
			// Manejar la cadena de texto seleccionada
			String textoSeleccionado = (String) datosPedido;
	        
			// Actualizar el txtAreaDetallePedidosConfirmados con el texto seleccionado
			ventanaEmpleado.getTxtAreaDetallePedidosConfirmados().setText(textoSeleccionado);
		}
    	
    }
    
    public void eliminarPedidoEmpleadoConfirmado() {
    	
    	// Verificar si hay un pedido seleccionado en la lista de pedidos confirmados
        if (!ventanaEmpleado.getLstPedidosConfirmados().isSelectionEmpty()) {
        	
            // Obtener el número de orden seleccionado
            String numeroOrden = (String) ventanaEmpleado.getLstPedidosConfirmados().getSelectedValue();

            // Eliminar el número de pedido confirmado del modelo de la lista de pedidos confirmados
            DefaultListModel<String> modeloListaConfirmados = (DefaultListModel<String>) ventanaEmpleado.getLstPedidosConfirmados().getModel();          
            modeloListaConfirmados.removeElement(numeroOrden);

            // Eliminar la fila correspondiente a la orden en las tablas
	        eliminarFilaPorNumeroOrden(ventanaEmpleado.getTbSinConfirmar(), numeroOrden);
	        eliminarFilaPorNumeroOrden(ventanaLista.getTbVentanaLista(), numeroOrden);
	        eliminarFilaPorNumeroOrden(ventanaCliente.getTbEPCliente(), numeroOrden);
	        
	        // Borrar el texto asociado en txtAreaSinConfirmar
	        ventanaEmpleado.getTxtAreaSinConfirmar().setText("");
	        
	        // Refrescar las tablas
	        refrescarTabla(ventanaEmpleado.getTbSinConfirmar());
	        refrescarTabla(ventanaLista.getTbVentanaLista());
	        refrescarTabla(ventanaCliente.getTbEPCliente());
            
           
        } else {
            // Si no se ha seleccionado ningún pedido en la lista de pedidos confirmados, mostrar un mensaje de advertencia 
            System.err.println("No se ha seleccionado ningún pedido confirmado para eliminar.");
        }
    }
    
    public void pedidoListo() {
    	
    	 // Verificar si hay un pedido seleccionado en la lista sin confirmar
        if (!ventanaEmpleado.getLstPedidosConfirmados().isSelectionEmpty()) {
        	
            // Obtener el número de orden seleccionado
            String numeroOrden = (String) ventanaEmpleado.getLstPedidosConfirmados().getSelectedValue();

            // Obtener los datos del pedido por el número de orden
            Object datosPedido = obtenerDatosPedidoPorNumeroOrden(numeroOrden);

            // Verificar si se encontraron los datos del pedido
            if (datosPedido != null) {
            	
                // Agregar el número de pedido confirmado al modelo de la lista de pedidos listos
                DefaultListModel<String> modeloListaPedidoListo = (DefaultListModel<String>) ventanaEmpleado.getLstPedidosListos().getModel();
                modeloListaPedidoListo.addElement(numeroOrden);
                
                // Modificar el estado del pedido de "Confirmado" a "Listo" en la tabla correspondiente
                modificarEstadoPedidoTabla(numeroOrden, "Listo");

                DefaultListModel<String> modeloListaConfirmado = (DefaultListModel<String>) ventanaEmpleado.getLstPedidosConfirmados().getModel();
                modeloListaConfirmado.removeElement(numeroOrden);
                ventanaEmpleado.getTxtAreaDetallePedidosConfirmados().setText("");
             
                //actualizar el contador
                contadorPedidosEmpleado();
                
            } else {
                // Si no se encontraron los datos del pedido, mostrar un mensaje de error 
                System.err.println("No se encontraron datos para el pedido con número de orden: " + numeroOrden);
            }
        } else {
            // Si no se ha seleccionado ningún pedido en la lista sin confirmar, mostrar un mensaje de advertencia 
            System.err.println("No se ha seleccionado ningún pedido para confirmar.");
        }
    }   
    
    @SuppressWarnings("static-access")
	public void enviarPedidoEntregado(Object datosPedido) {
    	
    	if (datosPedido instanceof Object[]) {
    		
			// Procesar el arreglo de objetos
			Object[] datos = (Object[]) datosPedido;
			
			String textoPedido = datos[1].toString();			
			
			@SuppressWarnings("unused")
			Object[] detalles = construirDetallesPedido(datos);		
			
			Pedido pedidoEntregado = new Pedido ();
			
			String idPedido = datos[2].toString();
			
			
		
			
			Cliente idCliente = (Cliente) datos[3];
			Producto idProducto= (Producto) datos[4];
			
			
			String metodoPago = datos[5].toString();
			String nombreProducto = datos[6].toString();
			int cantidadProducto = (int) datos[7];
			double totalTicket = (double) datos[8];
			
			DetallePedido detallePedidoEntregado = new DetallePedido();
			Empleado idEmpleadoTrabajando = empleadoTrabajando;
			
			
			pedidoEntregado.setIdPedido(idPedido);
			pedidoEntregado.setIdCliente(idCliente);
			pedidoEntregado.setIdProducto(idProducto);
			pedidoEntregado.setMetodoPago(metodoPago);
			pedidoEntregado.setNombreProductoSolicitado(nombreProducto);
			pedidoEntregado.setCantidadProductoSolicitado(cantidadProducto);
			pedidoEntregado.setTotalTicketPedido(totalTicket);
			
			detallePedidoEntregado.setIdDetallePedido(misProcesos.generarDetallePedidoID(8));
			detallePedidoEntregado.setIdCliente(idCliente);
			detallePedidoEntregado.setIdPedido(pedidoEntregado);
			detallePedidoEntregado.setIdEmpleado(idEmpleadoTrabajando);
		
			detallePedidoEntregado.setDescripcion(textoPedido);
			
			miPedidoDAO.guardarPedido(pedidoEntregado);
			
			
			
			@SuppressWarnings({ "unused" })
			String idDetallePedido = misProcesos.generarDetallePedidoID(8);
			@SuppressWarnings("unused")
			String detallesPedido = datos[9].toString() + datos[10].toString();
			
			/*detallePedidoEntregado.setIdDetallePedido(idDetallePedido);
			detallePedidoEntregado.setIdCliente(idCliente);
			detallePedidoEntregado.setIdPedido(pedidoEntregado);
			detallePedidoEntregado.setIdEmpleado(idEmpleado);
			detallePedidoEntregado.setDescripcion(detallesPedido);*/
			
			miDetallePedidoDAO.guardarDetallePedido(detallePedidoEntregado);

    	}
    	
    }
    
    public void seleccionarDetallesPedidosListos(Object datosPedido) {
    	
    	if (datosPedido instanceof Object[]) {
			// Procesar el arreglo de objetos
			Object[] datos = (Object[]) datosPedido;
			String textoPedido = datos[1].toString();
			@SuppressWarnings("unused")
			String idPedido = datos[2].toString();
			
			Object[] detalles = construirDetallesPedido(datos);
		
			detallesSinConfirmar.put(textoPedido,detalles);
		
		} else if (datosPedido instanceof String) {
			// Manejar la cadena de texto seleccionada
			@SuppressWarnings("unused")
			String textoSeleccionado = (String) datosPedido;
        
		}
    	
    }
      
    public void pedidosEntregados() {   	
    	
    	 // Verificar si hay un pedido seleccionado en la lista de pedidos listos
        if (!ventanaEmpleado.getLstPedidosListos().isSelectionEmpty()) {
        	
            // Obtener el número de orden seleccionado
            String numeroOrden = (String) ventanaEmpleado.getLstPedidosListos().getSelectedValue();
         
            // Obtener los datos del pedido por el número de orden
            Object datosPedido = obtenerDatosPedidoPorNumeroOrden(numeroOrden);

            // Verificar si se encontraron los datos del pedido
            if (datosPedido != null) {
            	
                // Procesar los datos del pedido como entregados
                enviarPedidoEntregado(datosPedido);
               
                // Eliminar el pedido de la lista y las tablas
                eliminarPedidoListoEmpleado(numeroOrden);
                
                // Actualizar el contador de pedidos
                contadorPedidosEmpleado();
            }
          
        }  	
    }
    
    public void eliminarPedidoListoEmpleado(String numeroOrden) {

        // Verificar si se ha seleccionado un pedido
        if (numeroOrden != null) {
        	
            // Eliminar el número de pedido de la lista de pedidos listos
            DefaultListModel<String> modeloListaPedidoListo = (DefaultListModel<String>) ventanaEmpleado.getLstPedidosListos().getModel();
            modeloListaPedidoListo.removeElement(numeroOrden);

            // Eliminar la fila correspondiente a la orden en las tablas
            eliminarFilaPorNumeroOrden(ventanaEmpleado.getTbSinConfirmar(), numeroOrden);
            eliminarFilaPorNumeroOrden(ventanaLista.getTbVentanaLista(), numeroOrden);
            eliminarFilaPorNumeroOrden(ventanaCliente.getTbEPCliente(), numeroOrden);

            // Refrescar las tablas
            refrescarTabla(ventanaEmpleado.getTbSinConfirmar());
            refrescarTabla(ventanaLista.getTbVentanaLista());
            refrescarTabla(ventanaCliente.getTbEPCliente());
            
        } else {
        	
            // Si no se ha seleccionado ningún pedido, mostrar un mensaje de advertencia
            System.err.println("No se ha seleccionado ningún pedido para eliminar.");
        }
	}
    
    public void contadorPedidosEmpleado() {
    	// Obtener el numero de items de las tablas 
        int numPedidosListos = ventanaEmpleado.getLstPedidosListos().getModel().getSize();
        int numPedidosConfirmados = ventanaEmpleado.getLstPedidosConfirmados().getModel().getSize();
        int numPedidosSinConfirmar = ventanaEmpleado.getLstSinConfirmar().getModel().getSize(); 
        
        // Calcular el total de pedidos gestionados
        int numPedidosTotal = numPedidosListos + numPedidosConfirmados + numPedidosSinConfirmar;
        
        // Concatenar las cadenas individualmente con sus respectivos valores numéricos
        ventanaEmpleado.getLblNumPTotalListos().setText(String.valueOf(numPedidosTotal));
        
        ventanaEmpleado.getLblNumPPendientesListos().setText(String.valueOf(numPedidosSinConfirmar + numPedidosConfirmados));
        
        ventanaEmpleado.getLblNumPEListosListos().setText(String.valueOf(numPedidosListos));
    }

/****************************************************	
	
MÉTODOS DE VENTANA GERENTE

*****************************************************/	
	
	public void cargarDatosTablas() {
		leerDatosTablaClientes();
		leerDatosTablaEmpleados();
		leerDatosTablaProductos();
		leerDatosTablaProveedores();
		leerDatosTablaPedidos();
	}

/*
 * PESTAÑA CLIENTES	
 */
	
	public void extraerDatosTablaClientes() {
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbClientesVG().getModel();
	    
	    // Obtener el índice de la fila seleccionada
	    int selectedRow = ventanaGerente.getTbClientesVG().getSelectedRow();
	    
	    // Verificar si hay una fila seleccionada
	    if (selectedRow != -1) {
	        // Obtener los valores de cada celda de la fila seleccionada
	        String idCliente = (String) model.getValueAt(selectedRow, 0);
	        String nombreCliente = (String) model.getValueAt(selectedRow, 1);
	        String dniCliente = (String) model.getValueAt(selectedRow, 2);
	        String direccionCliente = (String) model.getValueAt(selectedRow, 3);
	        String telefonoCliente = (String) model.getValueAt(selectedRow, 4);
	        String emailCliente = (String) model.getValueAt(selectedRow, 5);
	        int puntosCliente = (int) model.getValueAt(selectedRow, 6);
	        
	        // Escribir los valores en los campos de texto correspondientes
	        ventanaGerente.getTxtClienteIdClienteVG().setText(idCliente);
	        ventanaGerente.getTxtNombreClienteVG().setText(nombreCliente);
	        ventanaGerente.getTxtDNIClienteVG().setText(dniCliente);
	        ventanaGerente.getTxtDireccionClienteVG().setText(direccionCliente);
	        ventanaGerente.getTxtTelefonoClienteVG().setText(telefonoCliente);
	        ventanaGerente.getTxtEmailClienteVG().setText(emailCliente);
	        ventanaGerente.getTxtPuntosClienteVG().setText(String.valueOf(puntosCliente));
	    } else {
	        // Si no hay fila seleccionada, limpiar todos los campos de texto
	    	vaciarDatosTxtClienteVG();
	    }
	}
	 public void vaciarDatosTxtClienteVG() {
		 
		 ventanaGerente.getTxtClienteIdClienteVG().setText("");
		 ventanaGerente.getTxtNombreClienteVG().setText("");
		 ventanaGerente.getTxtDNIClienteVG().setText("");
		 ventanaGerente.getTxtDireccionClienteVG().setText("");
		 ventanaGerente.getTxtTelefonoClienteVG().setText("");
		 ventanaGerente.getTxtEmailClienteVG().setText("");
		 ventanaGerente.getTxtPuntosClienteVG().setText("");
	 }
	 
	public void leerDatosTablaClientes() {
		
		 // Limpiar la tabla antes de agregar nuevos datos
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbClientesVG().getModel();
	    
	    // Obtener la lista actualizada de clientes desde la base de datos
	    List<Cliente> listaClientes = miClienteDAO.obtenerTodosLosClientes();
	    misProcesos.actualizarTablaClientes(listaClientes, ventanaGerente.getTbClientesVG());
	    
	    // Verificar si la lista de clientes no está vacía
	    if (listaClientes != null) {
	        // Iterar sobre la lista de clientes y agregar cada cliente a la tabla
	        for (Cliente cliente : listaClientes) {
	            model.addRow(new Object[] {
	                cliente.getIdCliente(),
	                cliente.getNombreCliente(),
	                cliente.getClienteDNI(),
	                cliente.getDireccionCliente(),
	                cliente.getTelefonoCliente(),
	                cliente.getEmailCliente(),
	                cliente.getPuntosCliente()
	            });
	        }
	    }
	}
	
	public void registrarCliente() {
		
		// Obtener los valores ingresados en los JTextField
		String idNuevoCliente = ventanaGerente.getTxtClienteIdClienteVG().getText();
	    String nombreNuevoCliente = ventanaGerente.getTxtNombreClienteVG().getText();
	    String dniNuevoCliente = ventanaGerente.getTxtDNIClienteVG().getText();
	    String direccionNuevoCliente = ventanaGerente.getTxtDireccionClienteVG().getText();
	    String telefonoNuevoCliente = ventanaGerente.getTxtTelefonoClienteVG().getText();
	    String emailNuevoCliente = ventanaGerente.getTxtEmailClienteVG().getText();
	    int puntosNuevoCliente;
	    
	    try {
	        // Parse puntosNuevoCliente
	        puntosNuevoCliente = Integer.parseInt(ventanaGerente.getTxtPuntosClienteVG().getText());
	    } catch (NumberFormatException e) {
	        // Manejar la excepción cuando no se puede convertir a entero
	        
	        puntosNuevoCliente = 0;
	    }
   
	    // Crear un nuevo objeto Cliente con los valores obtenidos
	    Cliente nuevoCliente = new Cliente();
 
		    	//control de excepciones para idNuevoCliente
		    	try {
		    		if (idNuevoCliente == null || idNuevoCliente.isBlank()) {
		    			idNuevoCliente = Procesos.generarClienteID(8);
		    			nuevoCliente.setIdCliente(idNuevoCliente);	
		    			JOptionPane.showMessageDialog(null, "Como el campo ID estaba vacio, se ha generado un ID automaticamente .", "ID GENERADO", JOptionPane.INFORMATION_MESSAGE);   	        
		    		}else {
		    			if (!Procesos.codigoClienteExisteEnBD(idNuevoCliente)) {
		    				nuevoCliente.setIdCliente(idNuevoCliente);
		    			}else {
		    				JOptionPane.showMessageDialog(null, "El ID introducido ya existe en la base de datos.", "ID EXISTENTE", JOptionPane.ERROR_MESSAGE);
		    			}
		    		}
		    	}catch (Exception e){
		    		e.printStackTrace();
		    		System.out.println("Error en idNuevoCliente: " + idNuevoCliente );
		    	}
	    	
		    	//control de excepciones para nombreNuevoCliente
		    	try {
		    		if (nombreNuevoCliente == null || nombreNuevoCliente.isBlank()) {
		    			
		    			JOptionPane.showMessageDialog(null, "El campo nombre esta vacio.", "NOMBRE VACIO", JOptionPane.ERROR_MESSAGE);
		    		}else {
		    			nuevoCliente.setNombreCliente(nombreNuevoCliente);
		    		}
		    	}catch (Exception e){
		    		e.printStackTrace();
		    		System.out.println("Error en nombreNuevoCliente: " + nombreNuevoCliente );
		    	}
	    	
		    	//control de excepciones para dniNuevoCliente
		    	try {
		    		if (dniNuevoCliente == null ) {
		    			JOptionPane.showMessageDialog(null, "El campo DNI  no puede estar vacio.", "DNI VACIO", JOptionPane.ERROR_MESSAGE);
		    	
		    		}else {
		    		
		    			if (!Procesos.validarDNI(dniNuevoCliente)) {
		    				JOptionPane.showMessageDialog(null, "El campo dniCliente no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
		    				return;
		    			}else {
		    				nuevoCliente.setClienteDNI(dniNuevoCliente);
		    			}	
	        	
		    		}
	    		
		    	}catch (Exception e){
		    		e.printStackTrace();
		    		System.out.println("Error en dniNuevoCliente: " + dniNuevoCliente );
		    	}
	    	
		    	//control de excepciones para direccionNuevoCliente
		    	try {
		    		if (direccionNuevoCliente == null ) {
		    			JOptionPane.showMessageDialog(null, "El campo direccion no puede estar vacio.", "DIRECCION VACIO", JOptionPane.ERROR_MESSAGE);
		    		}else {
		    			nuevoCliente.setDireccionCliente(direccionNuevoCliente);
		    		}
		    	}catch (Exception e){
		    		e.printStackTrace();
		    		System.out.println("Error en direccionNuevoCliente: " + direccionNuevoCliente );
		    	}
	    	
		    	//control de excepciones para telefonoNuevoCliente
		    	try {
		    		if (telefonoNuevoCliente == null ) {
		    			JOptionPane.showMessageDialog(null, "El campo telefono no puede estar vacio.", "TELEFONO VACIO", JOptionPane.ERROR_MESSAGE);
		    		}else {
	        	
		    			if (!Procesos.validarTelefono(telefonoNuevoCliente)) {
		    				JOptionPane.showMessageDialog(null, "El campo telefonoCliente no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
		    				return;
		    			}else {
		    				nuevoCliente.setTelefonoCliente(telefonoNuevoCliente);
		    			}
	        	
		    		}
		    	}catch (Exception e){
		    		e.printStackTrace();
		    		System.out.println("Error en telefonoNuevoCliente: " + telefonoNuevoCliente );
		    	}
	    	  
		    	//control de excepciones para emailNuevoCliente
		    	try {
		    		if (emailNuevoCliente == null ) {
			    		JOptionPane.showMessageDialog(null, "El campo email no puede estar vacio.", "EMAIL VACIO", JOptionPane.ERROR_MESSAGE);
		    		
			    	}else {
			    		if (!Procesos.validarEmail(emailNuevoCliente)) {
			    			JOptionPane.showMessageDialog(null, "El campo emailCliente no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
			    			return;
				
			    		}else {	        	
		            	
			    			nuevoCliente.setEmailCliente(emailNuevoCliente);
	        	
			    		}
	        	
			    	}
		    	}catch (Exception e) {
		    		e.printStackTrace();
		    		System.out.println("Error en emailNuevoCliente: " + emailNuevoCliente );
		    	}
		    	
	    	
		    	//control de excepciones para puntosNuevoCliente
		    	try {
		    		if (puntosNuevoCliente == -1) {
		    			JOptionPane.showMessageDialog(null, "El campo puntos no puede estar vacio.", "PUNTOS VACIO", JOptionPane.ERROR_MESSAGE);
		    			ventanaGerente.getTxtPuntosClienteVG().setText("0");
		    		}else {    			
		    				
		    				nuevoCliente.setPuntosCliente(puntosNuevoCliente);

		    		}
		    	}catch (NumberFormatException e) {
		    		JOptionPane.showMessageDialog(null, "El campo puntosCliente no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
		            return; // Salir del método si los puntos no son válidos
		    	}
	   
	    // Validar los campos obligatorios
	    if (idNuevoCliente.isBlank() || nombreNuevoCliente.isBlank() || dniNuevoCliente.isBlank() || direccionNuevoCliente.isBlank() ||
		            telefonoNuevoCliente.isBlank() || emailNuevoCliente.isBlank() || puntosNuevoCliente == -1) {
	    	JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Debe rellenar todos los campos.\n Compruebe que todos los los formatos estan correctamente", JOptionPane.INFORMATION_MESSAGE);
    		return;
    	
	    }else {
	    	if (!Procesos.codigoClienteExisteEnBD(idNuevoCliente)) {
				
	    		nuevoCliente.setIdCliente(idNuevoCliente);
	    		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea registrar este cliente?", "Confirmar registro", JOptionPane.YES_NO_OPTION);
			    
			    // Si el usuario confirma la eliminación, proceder con la eliminación del cliente
			    if (opcion == JOptionPane.YES_OPTION) {
			        // Llamar al método eliminarCliente() de ClienteDAO para eliminar el cliente de la base de datos
			        miClienteDAO.guardarCliente(nuevoCliente);
			        
			        // Actualizar la tabla para reflejar los cambios
			        leerDatosTablaClientes(); 
			        vaciarDatosTxtClienteVG();
			    }
			    
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, introduzca otro ID o deje el campo en blanco para generar uno automaticamente.", "ID EXISTENTE", JOptionPane.INFORMATION_MESSAGE);
			}			
	    	
    	}
	    
	}
	
	public void btnActualizarCliente() {
		
		// Obtener el modelo de la tabla
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbClientesVG().getModel();
    
		// Obtener el índice de la fila seleccionada
		int selectedRow = ventanaGerente.getTbClientesVG().getSelectedRow();
    
		// Verificar si hay una fila seleccionada
		if (selectedRow != -1) {
			// Obtener el ID del cliente de la fila seleccionada
			String idClienteTxt = (String) model.getValueAt(selectedRow, 0);
        
			// Validar que los campos obligatorios no estén vacíos
			if (ventanaGerente.getTxtNombreClienteVG().getText().isBlank() ||
					ventanaGerente.getTxtDNIClienteVG().getText().isBlank() ||
					ventanaGerente.getTxtDireccionClienteVG().getText().isBlank() ||
					ventanaGerente.getTxtTelefonoClienteVG().getText().isBlank() ||
					ventanaGerente.getTxtEmailClienteVG().getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.",
				"Debe rellenar todos los campos.", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
        
			// Crear un objeto Cliente con los nuevos valores
			Cliente clienteActualizado = new Cliente();
			clienteActualizado.setIdCliente(idClienteTxt);
			clienteActualizado.setNombreCliente(ventanaGerente.getTxtNombreClienteVG().getText());
			clienteActualizado.setClienteDNI(ventanaGerente.getTxtDNIClienteVG().getText());
			clienteActualizado.setDireccionCliente(ventanaGerente.getTxtDireccionClienteVG().getText());
			clienteActualizado.setTelefonoCliente(ventanaGerente.getTxtTelefonoClienteVG().getText());
			clienteActualizado.setEmailCliente(ventanaGerente.getTxtEmailClienteVG().getText());
        
			// Validar y asignar los puntos del cliente
			try {
				int puntosClienteTxt = Integer.parseInt(ventanaGerente.getTxtPuntosClienteVG().getText());
				clienteActualizado.setPuntosCliente(puntosClienteTxt);
			} catch (NumberFormatException e) {
            
				clienteActualizado.setPuntosCliente(0);
			}
        
			// Verificar si se está intentando editar el ID del cliente
			String nuevoIdCliente = ventanaGerente.getTxtClienteIdClienteVG().getText();
			
			if (nuevoIdCliente.isBlank()) {				
				// Si el campo de ID está vacío, generar un nuevo ID automáticamente
				nuevoIdCliente = Procesos.generarClienteID(8);
				clienteActualizado.setIdCliente(nuevoIdCliente);
           
			} else if (!nuevoIdCliente.equals(idClienteTxt)) {				
				// Se está intentando editar el ID del cliente
				if (Procesos.codigoClienteExisteEnBD(nuevoIdCliente)) {
					
					// El nuevo ID del cliente ya existe en la base de datos
					JOptionPane.showMessageDialog(null, "El nuevo ID introducido ya existe en la base de datos.", "ID EXISTENTE", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					// Actualizar el ID del cliente
					clienteActualizado.setIdCliente(nuevoIdCliente);
				}
			}
        
			// Confirmar la actualización del cliente
			int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea editar este cliente?",
					"Confirmar edicion", JOptionPane.YES_NO_OPTION);
        
			// Proceder con la actualización del cliente si el usuario confirma
			if (opcion == JOptionPane.YES_OPTION) {
				miClienteDAO.actualizarCliente(clienteActualizado);
				leerDatosTablaClientes(); // Actualizar la tabla con los datos de la base de datos
				vaciarDatosTxtClienteVG(); // Limpiar los campos de texto
			}
		} else {
			JOptionPane.showMessageDialog(null, "Para poder editar un cliente primero debe seleccionar una fila.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	
	public void btnEliminarCliente() {
		
		 // Obtener la fila seleccionada en la tabla
	    int filaSeleccionada = ventanaGerente.getTbClientesVG().getSelectedRow();
	    
	    // Verificar si se ha seleccionado una fila
	    if (filaSeleccionada == -1) {
	        // No se ha seleccionado ninguna fila, mostrar un mensaje de error o advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un cliente de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    // Obtener el ID del cliente seleccionado en la tabla
	    String idCliente = (String) ventanaGerente.getTbClientesVG().getValueAt(filaSeleccionada, 0);
	    
	    // Obtener el objeto Cliente correspondiente al ID seleccionado
	    Cliente clienteAEliminar = miClienteDAO.buscarClientePorId(idCliente);
	    
	    // Confirmar si el usuario realmente desea eliminar el cliente seleccionado
	    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
	    
	    // Si el usuario confirma la eliminación, proceder con la eliminación del cliente
	    if (opcion == JOptionPane.YES_OPTION) {
	        // Llamar al método eliminarCliente() de ClienteDAO para eliminar el cliente de la base de datos
	        miClienteDAO.eliminarCliente(clienteAEliminar);
	        
	        // Actualizar la tabla para reflejar los cambios
	        leerDatosTablaClientes(); 
	        vaciarDatosTxtClienteVG();
	    }
	}
	
/*
 * PESTAÑA EMPLEADOS
 */
		
	public void extraerDatosTablaEmpleados() {
		// Obtener el modelo de la tabla
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbEmpleadoVG().getModel();
		    
		// Obtener el índice de la fila seleccionada
		int selectedRow = ventanaGerente.getTbEmpleadoVG().getSelectedRow();
		    
		// Verificar si hay una fila seleccionada
		if (selectedRow != -1) {
			
			// Obtener los valores de cada celda de la fila seleccionada
			String idEmpleado = (String) model.getValueAt(selectedRow, 0);
			String nombreEmpleado = (String) model.getValueAt(selectedRow, 1);
			String dniEmpleado = (String) model.getValueAt(selectedRow, 2);
			String direccionEmpleado = (String) model.getValueAt(selectedRow, 3);
			String telefonoEmpleado = (String) model.getValueAt(selectedRow, 4);
			String emailEmpleado = (String) model.getValueAt(selectedRow, 5);
			String rolEmpleado = (String) model.getValueAt(selectedRow, 6);
			double salarioEmpleado = (double) model.getValueAt(selectedRow, 7);
		        
			// Escribir los valores en los campos de texto correspondientes
			ventanaGerente.getTxtEmpleadoIdEmpleadosVG().setText(idEmpleado);
			ventanaGerente.getTxtNombreEmpleadoVG().setText(nombreEmpleado);
			ventanaGerente.getTxtDNIEmpleadoVG().setText(dniEmpleado);
			ventanaGerente.getTxtDireccionEmpleadoVG().setText(direccionEmpleado);
			ventanaGerente.getTxtTelefonoEmpleadoVG().setText(telefonoEmpleado);
			ventanaGerente.getTxtEmailEmpleadoVG().setText(emailEmpleado);
			ventanaGerente.getTxtRolEmpleadoVG().setText(rolEmpleado);
			ventanaGerente.getTxtSalarioEmpleadoVG().setText(String.valueOf(salarioEmpleado));
		        
		} else {
			
			// Si no hay fila seleccionada, limpiar todos los campos de texto
			vaciarDatosTxtEmpleadoVG();
		    }
	}
	public void vaciarDatosTxtEmpleadoVG() {
			 
		ventanaGerente.getTxtEmpleadoIdEmpleadosVG().setText("");
		ventanaGerente.getTxtNombreEmpleadoVG().setText("");
		ventanaGerente.getTxtDNIEmpleadoVG().setText("");
		ventanaGerente.getTxtDireccionEmpleadoVG().setText("");
		ventanaGerente.getTxtTelefonoEmpleadoVG().setText("");
		ventanaGerente.getTxtEmailEmpleadoVG().setText("");
		ventanaGerente.getTxtRolEmpleadoVG().setText("");
		ventanaGerente.getTxtSalarioEmpleadoVG().setText("");
	}
		 
	public void leerDatosTablaEmpleados() {
		
		// Limpiar la tabla antes de agregar nuevos datos
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbEmpleadoVG().getModel();

		    
		// Obtener la lista actualizada de empleado desde la base de datos
		List<Empleado> listaEmpleados = miEmpleadoDAO.obtenerTodosLosEmpleados();
		misProcesos.actualizarTablaEmpleados(listaEmpleados, ventanaGerente.getTbEmpleadoVG());
		// Verificar si la lista de clientes no está vacía
		if (listaEmpleados != null) {
			// Iterar sobre la lista de clientes y agregar cada cliente a la tabla
			for (Empleado empleado : listaEmpleados) {
				model.addRow(new Object[] {
					empleado.getIdEmpleado(),
					empleado.getNombreEmpleado(),
					empleado.getEmpleadoDNI(),
					empleado.getDireccionEmpleado(),
					empleado.getTelefonoEmpleado(),
					empleado.getEmailEmpleado(),
					empleado.getRolEmpleado(),
					empleado.getSalarioEmpleado()
				});
			}
		}
	}
		
	public void registrarEmpleado() {
		
		// Obtener los valores ingresados en los JTextField
	    String idNuevoEmpleado = ventanaGerente.getTxtEmpleadoIdEmpleadosVG().getText().trim();
	    String nombreNuevoEmpleado = ventanaGerente.getTxtNombreEmpleadoVG().getText().trim();
	    String dniNuevoEmpleado = ventanaGerente.getTxtDNIEmpleadoVG().getText().trim();
	    String direccionNuevoEmpleado = ventanaGerente.getTxtDireccionEmpleadoVG().getText().trim();
	    String telefonoNuevoEmpleado = ventanaGerente.getTxtTelefonoEmpleadoVG().getText().trim();
	    String emailNuevoEmpleado = ventanaGerente.getTxtEmailEmpleadoVG().getText().trim();
	    String rolNuevoEmpleado = ventanaGerente.getTxtRolEmpleadoVG().getText().trim();
	    double salarioNuevoEmpleado = -1; // Inicializar con un valor negativo

	    try {
	        salarioNuevoEmpleado = Double.parseDouble(ventanaGerente.getTxtSalarioEmpleadoVG().getText().trim());
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "El campo salarioEmpleado no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Validar campos obligatorios
	    if (nombreNuevoEmpleado.isBlank() || dniNuevoEmpleado.isBlank() ||
	        direccionNuevoEmpleado.isBlank() || telefonoNuevoEmpleado.isBlank() || emailNuevoEmpleado.isBlank() ||
	        rolNuevoEmpleado.isBlank() || salarioNuevoEmpleado < 0) {
	        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.\n" + 
	            "Compruebe que todos los formatos están correctamente.", 
	            "Debe rellenar todos los campos.", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    // Generar ID automáticamente si está en blanco y no existe en la base de datos
	    if (idNuevoEmpleado.isBlank()) {
	        idNuevoEmpleado = Procesos.generarEmpleadoID(8);
	        JOptionPane.showMessageDialog(null, "Como el campo ID estaba vacío, se ha generado un ID automáticamente: " + idNuevoEmpleado, "ID Generado", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        // Verificar si el ID ya existe en la base de datos
	        if (Procesos.codigoEmpleadoExisteEnBD(idNuevoEmpleado)) {
	            JOptionPane.showMessageDialog(null, "El ID introducido ya existe en la base de datos. " + 
	                "Por favor, introduzca otro ID o deje el campo en blanco para generar uno automáticamente.", 
	                "ID Existente", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	    }

	    // Validar DNI
	    if (!Procesos.validarDNI(dniNuevoEmpleado)) {
	        JOptionPane.showMessageDialog(null, "El campo dniEmpleado no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Validar Teléfono
	    if (!Procesos.validarTelefono(telefonoNuevoEmpleado)) {
	        JOptionPane.showMessageDialog(null, "El campo telefonoEmpleado no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Validar Email
	    if (!Procesos.validarEmail(emailNuevoEmpleado)) {
	        JOptionPane.showMessageDialog(null, "El campo emailEmpleado no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar si el DNI ya existe en la base de datos
	    if (Procesos.dniEmpleadoExisteEnBD(dniNuevoEmpleado)) {
	        JOptionPane.showMessageDialog(null, "El DNI introducido ya existe en la base de datos.", "DNI Existente", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    // Crear un nuevo objeto Empleado con los valores obtenidos
	    Empleado nuevoEmpleado = new Empleado();
	    nuevoEmpleado.setIdEmpleado(idNuevoEmpleado);
	    nuevoEmpleado.setNombreEmpleado(nombreNuevoEmpleado);
	    nuevoEmpleado.setEmpleadoDNI(dniNuevoEmpleado);
	    nuevoEmpleado.setDireccionEmpleado(direccionNuevoEmpleado);
	    nuevoEmpleado.setTelefonoEmpleado(telefonoNuevoEmpleado);
	    nuevoEmpleado.setEmailEmpleado(emailNuevoEmpleado);
	    nuevoEmpleado.setRolEmpleado(rolNuevoEmpleado);
	    nuevoEmpleado.setSalarioEmpleado(salarioNuevoEmpleado);

	    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea registrar este empleado?", "Confirmar registro", JOptionPane.YES_NO_OPTION);

	    // Si el usuario confirma el registro, proceder con el registro del empleado
	    if (opcion == JOptionPane.YES_OPTION) {
	        // Llamar al método guardarEmpleado() de EmpleadoDAO para guardar el empleado en la base de datos
	        miEmpleadoDAO.guardarEmpleado(nuevoEmpleado);
	        
	        // Actualizar la tabla para reflejar los cambios
	        leerDatosTablaEmpleados(); 
	        vaciarDatosTxtEmpleadoVG();
	    }
					    
	}
		
	public void btnActualizarEmpleado() {
			
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbEmpleadoVG().getModel();

	    // Obtener el índice de la fila seleccionada
	    int selectedRow = ventanaGerente.getTbEmpleadoVG().getSelectedRow();

	    // Verificar si hay una fila seleccionada
	    if (selectedRow != -1) {
	        // Obtener el ID del cliente de la fila seleccionada
	        String idEmpleadoTxt = (String) model.getValueAt(selectedRow, 0);
	        
	        
	        String dniEmpleadoActual = (String) model.getValueAt(selectedRow, 3);

	        // Validar que los campos obligatorios no estén vacíos
	        if (ventanaGerente.getTxtNombreEmpleadoVG().getText().isBlank() || ventanaGerente.getTxtDNIEmpleadoVG().getText().isBlank() ||
	                ventanaGerente.getTxtDireccionEmpleadoVG().getText().isBlank() || ventanaGerente.getTxtTelefonoEmpleadoVG().getText().isBlank() ||
	                ventanaGerente.getTxtEmailEmpleadoVG().getText().isBlank() || ventanaGerente.getTxtRolEmpleadoVG().getText().isBlank()||
	                ventanaGerente.getTxtSalarioEmpleadoVG().getText().isBlank()){
	            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.",
	                    "Debe rellenar todos los campos.", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	        
	        // Crear un objeto Empleado con los nuevos valores
	        Empleado empleadoActualizado = new Empleado();
	        empleadoActualizado.setIdEmpleado(idEmpleadoTxt);
	        empleadoActualizado.setNombreEmpleado(ventanaGerente.getTxtNombreEmpleadoVG().getText());
	        empleadoActualizado.setEmpleadoDNI(ventanaGerente.getTxtDNIEmpleadoVG().getText());
	        empleadoActualizado.setDireccionEmpleado(ventanaGerente.getTxtDireccionEmpleadoVG().getText());
	        empleadoActualizado.setTelefonoEmpleado(ventanaGerente.getTxtTelefonoEmpleadoVG().getText());
	        empleadoActualizado.setEmailEmpleado(ventanaGerente.getTxtEmailEmpleadoVG().getText());
	        empleadoActualizado.setRolEmpleado(ventanaGerente.getTxtRolEmpleadoVG().getText());

	        // Validar y asignar el salario del empleado
	        try {
	            double salarioEmpleado = Double.parseDouble(ventanaGerente.getTxtSalarioEmpleadoVG().getText());
	            empleadoActualizado.setSalarioEmpleado(salarioEmpleado);
	        } catch (NumberFormatException e) {
	            empleadoActualizado.setSalarioEmpleado(0);
	        }
	 	        
	     // Verificar si el DNI ingresado es diferente del DNI actual del empleado
	        String dniEmpleadoNuevo = ventanaGerente.getTxtDNIEmpleadoVG().getText();
	        
	        
	     // Verificar si el DNI ingresado es diferente del DNI actual del empleado
	        if (!dniEmpleadoNuevo.equals(dniEmpleadoActual)) {
	            // Si el DNI ha cambiado, verificar si ya existe en la base de datos
	            if (Procesos.dniEmpleadoExisteEnBD(dniEmpleadoNuevo)) {
	                Empleado empleadoExistente = miEmpleadoDAO.buscarEmpleadoPorId(dniEmpleadoNuevo);
	                
	                if (empleadoExistente != null) {
	                    // Se encontró un empleado con el mismo DNI en la base de datos
	                    if (empleadoExistente.getIdEmpleado().equals(idEmpleadoTxt)) {
	                        // El DNI introducido ya existe en la base de datos pero pertenece al mismo empleado, por lo que permitimos la actualización
	                        empleadoActualizado.setEmpleadoDNI(dniEmpleadoNuevo);
	                    } else {
	                        // El DNI introducido ya existe en la base de datos y pertenece a otro empleado
	                        JOptionPane.showMessageDialog(null, "El DNI introducido ya existe en la base de datos y pertenece a otro empleado.",
	                                "DNI Existente", JOptionPane.INFORMATION_MESSAGE);
	                        return; // Interrumpir el proceso de actualización
	                    }
	                } else {
	                    // No se encontró ningún empleado con ese DNI en la base de datos
	                    
	                }
	            } else {
	                // El DNI no existe en la base de datos, se asigna al empleado actualizado
	                empleadoActualizado.setEmpleadoDNI(dniEmpleadoNuevo);
	            }
	        }

	        // Confirmar la actualización del empleado
	        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea editar este empleado?",
	                "Confirmar edición", JOptionPane.YES_NO_OPTION);

	        // Proceder con la actualización del empleado si el usuario confirma
	        if (opcion == JOptionPane.YES_OPTION) {
	            miEmpleadoDAO.actualizarEmpleado(empleadoActualizado);
	            leerDatosTablaEmpleados(); // Actualizar la tabla con los datos de la base de datos
	            vaciarDatosTxtEmpleadoVG(); // Limpiar los campos de texto
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Para poder editar un empleado primero debe seleccionar una fila.",
	                "Error", JOptionPane.ERROR_MESSAGE);
	    }
				
	}
		
		
	public void btnEliminarEmpleado() {
		
		// Obtener la fila seleccionada en la tabla
		int filaSeleccionada = ventanaGerente.getTbEmpleadoVG().getSelectedRow();
		    
		// Verificar si se ha seleccionado una fila
		if (filaSeleccionada == -1) {
			// No se ha seleccionado ninguna fila, mostrar un mensaje de error o advertencia
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un empleado de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		    
		// Obtener el ID del empleado seleccionado en la tabla
		String idEmpleado = (String) ventanaGerente.getTbEmpleadoVG().getValueAt(filaSeleccionada, 0);
		    
		// Obtener el objeto Empleado correspondiente al ID seleccionado
		Empleado empleadoAEliminar = miEmpleadoDAO.buscarEmpleadoPorId(idEmpleado);
		    
		// Confirmar si el usuario realmente desea eliminar el empleado seleccionado
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este empleado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		    
		// Si el usuario confirma la eliminación, proceder con la eliminación del empleado
		if (opcion == JOptionPane.YES_OPTION) {
			// Llamar al método eliminarEmpleado() de ClienteDAO para eliminar el empleado de la base de datos
			miEmpleadoDAO.eliminarEmpleado(empleadoAEliminar);
		        
			// Actualizar la tabla para reflejar los cambios
			leerDatosTablaEmpleados(); // Suponiendo que este método actualiza la tabla con los datos de la base de datos
			vaciarDatosTxtEmpleadoVG();
		}
	}
	
	public void ponerTurno() {
		 // Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbEmpleadoVG().getModel();

	    // Obtener el índice de la fila seleccionada
	    int selectedRow = ventanaGerente.getTbEmpleadoVG().getSelectedRow();

	    // Verificar si hay una fila seleccionada
	    if (selectedRow != -1) {
	    	
	    	 // Obtener el ID del empleado seleccionado
	    	String idEmpleado = (String) model.getValueAt(selectedRow, 0);
	    	
	        // Obtener el DNI del empleado seleccionado
	        String dniEmpleado = (String) model.getValueAt(selectedRow, 2); // Índice de la columna del DNI

	        // Pedir confirmación y el DNI del empleado
	        String inputDNI = JOptionPane.showInputDialog(null, "Por favor, ingrese el DNI del empleado:", "Confirmación de DNI", JOptionPane.QUESTION_MESSAGE);

	        // Verificar si se ingresó un DNI y si coincide con el del empleado seleccionado
	        if (inputDNI != null && inputDNI.equals(dniEmpleado)) {
	            // Si coincide el DNI, proceder con el registro del turno
	            String nombreEmpleado = (String) model.getValueAt(selectedRow, 1); // Índice de la columna del nombre
	            
	            String rolEmpleado = (String) model.getValueAt(selectedRow, 6); // Índice de la columna del rol

	            // Obtener la fecha y hora de entrada al turno
	            LocalDateTime fechaHoraEntrada = LocalDateTime.now(); 

	            // Formatear la fecha y la hora por separado
	            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	            String fechaFormateada = fechaHoraEntrada.format(dateFormatter);
	            String horaFormateada = fechaHoraEntrada.format(timeFormatter);

	            // Construir el texto a mostrar en el txtAreaTurnoEmpleado
	            StringBuilder textoTurnoEntrada = new StringBuilder();
	            textoTurnoEntrada.append("-Id: ").append(idEmpleado).append(" ");
	            textoTurnoEntrada.append("-Nombre: ").append(nombreEmpleado).append(" ");
	            textoTurnoEntrada.append("-Puesto: ").append(rolEmpleado).append(" ");
	            textoTurnoEntrada.append("-Fecha de entrada: ").append(fechaFormateada).append(" ");
	            textoTurnoEntrada.append("-Hora de entrada: ").append(horaFormateada).append("\n");
	            
	            // Enviar el trabajador del turno
	            empleadoTrabajando = empleadoTrabajando(idEmpleado);

	            // Mostrar el texto en el txtAreaTurnoEmpleado sin reemplazar el texto anterior
	            ventanaGerente.getTxtAreaEmpleadosVG().append(textoTurnoEntrada.toString());
	        } else {
	            // Si no coincide el DNI o se cancela la ventana, mostrar un mensaje de error
	            JOptionPane.showMessageDialog(null, "El DNI ingresado no coincide con el del empleado seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado para poner en turno.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
		
	}
	
	
	public Empleado empleadoTrabajando(String idEmpleado ) {
		Empleado empleado = miEmpleadoDAO.buscarEmpleadoPorId(idEmpleado);
		
		return empleado;
	}
	
	public void quitarTurno() {
		
		 // Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbEmpleadoVG().getModel();

	    // Obtener el índice de la fila seleccionada
	    int selectedRow = ventanaGerente.getTbEmpleadoVG().getSelectedRow();

	    // Verificar si hay una fila seleccionada
	    if (selectedRow != -1) {
	        // Obtener el DNI del empleado seleccionado
	        String dniEmpleado = (String) model.getValueAt(selectedRow, 2); // Índice de la columna del DNI
	        @SuppressWarnings("unused")
			String idEmpleado = (String) model.getValueAt(selectedRow, 0);
	        // Pedir confirmación y el DNI del empleado
	        String inputDNI = JOptionPane.showInputDialog(null, "Por favor, ingrese el DNI del empleado:", "Confirmación de DNI", JOptionPane.QUESTION_MESSAGE);

	        // Verificar si se ingresó un DNI y si coincide con el del empleado seleccionado
	        if (inputDNI != null && inputDNI.equals(dniEmpleado)) {
	            // Si coincide el DNI, proceder con el registro de la salida del turno
	            String nombreEmpleado = (String) model.getValueAt(selectedRow, 1); // Índice de la columna del nombre
	            String rolEmpleado = (String) model.getValueAt(selectedRow, 6); // Índice de la columna del rol

	            // Obtener la fecha y hora de salida del turno
	            LocalDateTime fechaHoraSalida = LocalDateTime.now(); // Aquí deberías obtener la fecha y hora actual

	            // Formatear la fecha y la hora por separado
	            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	            String fechaFormateada = fechaHoraSalida.format(dateFormatter);
	            String horaFormateada = fechaHoraSalida.format(timeFormatter);

	            // Construir el texto a mostrar en el txtAreaTurnoEmpleado
	            StringBuilder textoTurnoSalida = new StringBuilder();
	            textoTurnoSalida.append("-Nombre: ").append(nombreEmpleado).append(" ");
	            textoTurnoSalida.append("-Puesto: ").append(rolEmpleado).append(" ");
	            textoTurnoSalida.append("-Fecha de salida: ").append(fechaFormateada).append(" ");
	            textoTurnoSalida.append("-Hora de salida: ").append(horaFormateada).append("\n");

	            empleadoTrabajando = null;
	            
	            // Mostrar el texto en el txtAreaTurnoEmpleado sin reemplazar el texto anterior
	            ventanaGerente.getTxtAreaEmpleadosVG().append(textoTurnoSalida.toString());
	            
	        } else {
	            // Si no coincide el DNI o se cancela la ventana, mostrar un mensaje de error
	            JOptionPane.showMessageDialog(null, "El DNI ingresado no coincide con el del empleado seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado para quitar de turno.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
		
	}
	
/*
 * PESTAÑA PRODUCTOS	
 */
	
	public void extraerDatosTablaProductos() {
		
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbProductosVG().getModel();
	    
	    // Obtener el índice de la fila seleccionada
	    int selectedRow = ventanaGerente.getTbProductosVG().getSelectedRow();
	    
	    // Verificar si hay una fila seleccionada
	    if (selectedRow != -1) {
	        // Obtener los valores de cada celda de la fila seleccionada
	        String idProductoVG = (String) model.getValueAt(selectedRow, 0);
	        String nombreProductoVG = (String) model.getValueAt(selectedRow, 1);
	        int cantidadStockVG = (int) model.getValueAt(selectedRow, 2);
	        Double precioVentaProductoVG = (Double) model.getValueAt(selectedRow, 3);
	        
	        
	        // Escribir los valores en los campos de texto correspondientes
	        ventanaGerente.getTxtProductoIdProductosVG().setText(idProductoVG);
	        ventanaGerente.getTxtNombreProductoVG().setText(nombreProductoVG);
	        ventanaGerente.getTxtCantidadProductoVG().setText(String.valueOf(cantidadStockVG));
	        ventanaGerente.getTxtPrecioVentaProductoVG().setText(String.valueOf(precioVentaProductoVG));
	        
	    } else {
	        // Si no hay fila seleccionada, limpiar todos los campos de texto
	    
	      
	    }
	}	
	
	public void vaciarDatosProductosVG() {
		 
	 	ventanaGerente.getTxtProductoIdProductosVG().setText("");
    	ventanaGerente.getTxtNombreProductoVG().setText("");
    	ventanaGerente.getTxtCantidadProductoVG().setText("");
    	ventanaGerente.getTxtPrecioVentaProductoVG().setText("");
	 }
	
	public void leerDatosTablaProductos() {
		 // Limpiar la tabla antes de agregar nuevos datos
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbProductosVG().getModel();
	    
	    // Obtener la lista actualizada de clientes desde la base de datos
	    List<Producto> listaProductos = miProductoDAO.obtenerTodosLosProductos();
	    misProcesos.actualizarTablaProductos(listaProductos, ventanaGerente.getTbProductosVG());
	    // Verificar si la lista de clientes no está vacía
	    if (listaProductos != null) {
	        // Iterar sobre la lista de clientes y agregar cada cliente a la tabla
	        for (Producto productos : listaProductos) {
	            model.addRow(new Object[] {
	            		productos.getIdProducto(),
	            		productos.getNombreProducto(),
	            		productos.getCantidadStock(),
	            		productos.getPrecioVentaProducto()
	            });
	        }
	    }
	}
	
	public void registrarProducto() {
		String idNuevoProducto = ventanaGerente.getTxtProductoIdProductosVG().getText().trim();
	    String nombreNuevoProducto = ventanaGerente.getTxtNombreProductoVG().getText().trim();
	    int cantidadNuevoProducto = 0;
	    double precioVentaNuevoProducto = 0.0;

	    try {
	        cantidadNuevoProducto = Integer.parseInt(ventanaGerente.getTxtCantidadProductoVG().getText());
	        precioVentaNuevoProducto = Double.parseDouble(ventanaGerente.getTxtPrecioVentaProductoVG().getText().replace(',', '.'));
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido para cantidad y precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Validar campos obligatorios
	    if (nombreNuevoProducto.isBlank() || cantidadNuevoProducto <= 0 || precioVentaNuevoProducto <= 0) {
	        JOptionPane.showMessageDialog(null, "El nombre, la cantidad y el precio son campos obligatorios y deben contener valores válidos.", "Campos Obligatorios", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Si el ID está vacío, genera un ID automático
	    if (idNuevoProducto.isBlank()) {
	        idNuevoProducto = Procesos.generarProductoID(8); // Genera un ID de 8 caracteres automáticamente
	        JOptionPane.showMessageDialog(null, "Como el campo ID estaba vacío, se ha generado un ID automáticamente: " + idNuevoProducto, "ID Generado", JOptionPane.INFORMATION_MESSAGE);
	    }

	    // Verificar si el ID del producto ya existe en la base de datos
	    if (Procesos.codigoProductoExisteEnBD(idNuevoProducto)) {
	        JOptionPane.showMessageDialog(null, "El ID del producto ya existe en la base de datos.", "ID Duplicado", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    Producto nuevoProducto = new Producto();
	    nuevoProducto.setIdProducto(idNuevoProducto);
	    nuevoProducto.setNombreProducto(nombreNuevoProducto);
	    nuevoProducto.setCantidadStock(cantidadNuevoProducto);
	    nuevoProducto.setPrecioVentaProducto(precioVentaNuevoProducto);

	    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea registrar este producto?", "Confirmar Registro", JOptionPane.YES_NO_OPTION);
	    if (opcion == JOptionPane.YES_OPTION) {
	        miProductoDAO.guardarProducto(nuevoProducto);
	        leerDatosTablaProductos();
	        vaciarDatosProductosVG();
	    }
		
	}
	
	public void btnActualizarProducto() {
		
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbProductosVG().getModel();
	    
	    // Obtener el índice de la fila seleccionada
	    int selectedRow = ventanaGerente.getTbProductosVG().getSelectedRow();
	    
	    // Verificar si hay una fila seleccionada
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Para poder editar un producto primero debe seleccionar una fila.",
	                "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Obtener el ID del producto de la fila seleccionada
	    String idProductoTxt = (String) model.getValueAt(selectedRow, 0);
	    
	    // Validar campos obligatorios
	    String nombreProducto = ventanaGerente.getTxtNombreProductoVG().getText().trim();
	    String cantidadProductoStr = ventanaGerente.getTxtCantidadProductoVG().getText().trim();
	    String precioProductoStr = ventanaGerente.getTxtPrecioVentaProductoVG().getText().trim().replace(',', '.');
	    
	    if (nombreProducto.isBlank() || cantidadProductoStr.isBlank() || precioProductoStr.isBlank()) {
	        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.",
	                "Debe rellenar todos los campos.", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    // Crear un objeto Producto con los nuevos valores
	    Producto productoActualizado = new Producto();
	    
	    productoActualizado.setIdProducto(idProductoTxt);
	    productoActualizado.setNombreProducto(nombreProducto);

	    try {
	        double precioVentaProducto = Double.parseDouble(precioProductoStr);
	        int cantidadStock = Integer.parseInt(cantidadProductoStr);
	        if (cantidadStock < 0) {
	            JOptionPane.showMessageDialog(null, "La cantidad del producto debe ser un valor entero positivo.",
	                    "Error de Formato", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        productoActualizado.setPrecioVentaProducto(precioVentaProducto);
	        productoActualizado.setCantidadStock(cantidadStock);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos para cantidad y precio.",
	                "Error de Formato", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar si se está intentando editar el ID del producto
	    String nuevoIdProducto = ventanaGerente.getTxtProductoIdProductosVG().getText().trim();
	    if (!nuevoIdProducto.equals(idProductoTxt)) {
	        if (nuevoIdProducto.isBlank()) {
	            nuevoIdProducto = Procesos.generarClienteID(8);
	        }

	        if (Procesos.codigoProductoExisteEnBD(nuevoIdProducto)) {
	            JOptionPane.showMessageDialog(null, "El nuevo ID introducido ya existe en la base de datos.",
	                    "ID EXISTENTE", JOptionPane.ERROR_MESSAGE);
	            return;
	        } else {
	            productoActualizado.setIdProducto(nuevoIdProducto);
	        }
	    }

	    // Confirmar la actualización del producto
	    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea editar este producto?",
	            "Confirmar edicion", JOptionPane.YES_NO_OPTION);

	    // Proceder con la actualización del producto si el usuario confirma
	    if (opcion == JOptionPane.YES_OPTION) {
	        miProductoDAO.actualizarProducto(productoActualizado);
	        leerDatosTablaProductos(); // Actualizar la tabla con los datos de la base de datos
	        vaciarDatosProductosVG(); // Limpiar los campos de texto
	    }
			
	}
		
		
	public void btnEliminarProducto() {
		
		// Obtener la fila seleccionada en la tabla
		int filaSeleccionada = ventanaGerente.getTbProductosVG().getSelectedRow();
		    
		// Verificar si se ha seleccionado una fila
		if (filaSeleccionada == -1) {
			// No se ha seleccionado ninguna fila, mostrar un mensaje de error
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		    
		// Obtener el ID del producto seleccionado en la tabla
		String idProducto = (String) ventanaGerente.getTbProductosVG().getValueAt(filaSeleccionada, 0);
		    
		// Obtener el objeto Producto correspondiente al ID seleccionado
		Producto productoAEliminar = miProductoDAO.buscarProductoPorId(idProducto);
		    
		// Confirmar si el usuario realmente desea eliminar el producto seleccionado
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		    
		// Si el usuario confirma la eliminación, proceder con la eliminación del producto
		if (opcion == JOptionPane.YES_OPTION) {
			// Llamar al método eliminarProducto() de ClienteDAO para eliminar el producto de la base de datos
			miProductoDAO.eliminarProducto(productoAEliminar);
		        
			// Actualizar la tabla para reflejar los cambios
			leerDatosTablaProductos(); // Suponiendo que este método actualiza la tabla con los datos de la base de datos
			vaciarDatosProductosVG();
		}
	}

	/*
	 * PESTAÑA PROVEEDORES
	 */
			
	public void extraerDatosTablaProveedores() {
		
		// Obtener el modelo de la tabla
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbProveedoresVG().getModel();
			    
		// Obtener el índice de la fila seleccionada
		int selectedRow = ventanaGerente.getTbProveedoresVG().getSelectedRow();
			    
		// Verificar si hay una fila seleccionada
		if (selectedRow != -1) {
			// Obtener los valores de cada celda de la fila seleccionada
			String idProveedor = (String) model.getValueAt(selectedRow, 0);
			String idProducto = (String) model.getValueAt(selectedRow, 1);
			String nombreProveedor = (String) model.getValueAt(selectedRow, 2);
			String telefonoProveedor = (String) model.getValueAt(selectedRow, 3);
			String emailProveedor = (String) model.getValueAt(selectedRow, 4);
			double precioProveedor = (double) model.getValueAt(selectedRow, 5);
			int cantidadProveedor = (int) model.getValueAt(selectedRow, 6);
			        
			// Escribir los valores en los campos de texto correspondientes
			ventanaGerente.getTxtProveedorIdProveedoresVG().setText(idProveedor);
			ventanaGerente.getTxtProductoIdProveedoresVG().setText(idProducto);
			ventanaGerente.getTxtNombreProveedorVG().setText(nombreProveedor);			        
			ventanaGerente.getTxtTelefonoProveedorVG().setText(telefonoProveedor);
			ventanaGerente.getTxtEmailProveedorVG().setText(emailProveedor);
			ventanaGerente.getTxtPrecioProveedorVG().setText(String.valueOf(precioProveedor));
			ventanaGerente.getTxtCantidadProveedorVG().setText(String.valueOf(cantidadProveedor));
		} else {
			// Si no hay fila seleccionada, limpiar todos los campos de texto
			vaciarDatosTxtProveedoresVG();
		}
	}
	
	public void vaciarDatosTxtProveedoresVG() {
				 
		ventanaGerente.getTxtProveedorIdProveedoresVG().setText("");
		ventanaGerente.getTxtProductoIdProveedoresVG().setText("");
		ventanaGerente.getTxtNombreProveedorVG().setText("");
		ventanaGerente.getTxtTelefonoProveedorVG().setText("");
		ventanaGerente.getTxtEmailProveedorVG().setText("");
		ventanaGerente.getTxtPrecioProveedorVG().setText("");
		ventanaGerente.getTxtCantidadProveedorVG().setText("");
	}
			 
	public void leerDatosTablaProveedores() {
		
		// Limpiar la tabla antes de agregar nuevos datos
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbProveedoresVG().getModel();
		model.setRowCount(0);
			    
		// Obtener la lista actualizada de clientes desde la base de datos
		List<Proveedor> listaProveedores = miProveedorDAO.obtenerTodosLosProveedores();
		misProcesos.actualizarTablaProveedores(listaProveedores, ventanaGerente.getTbProveedoresVG());
		// Verificar si la lista de clientes no está vacía
		if (listaProveedores != null) {
			// Iterar sobre la lista de clientes y agregar cada cliente a la tabla
			for (Proveedor proveedor : listaProveedores) {
				model.addRow(new Object[] {
						proveedor.getIdProveedor(),
						proveedor.getIdProducto().getIdProducto(),
						proveedor.getNombreProveedor(),
						proveedor.getTelefonoProveedor(),
						proveedor.getEmailProveedor(),
						proveedor.getPrecioCompraProducto(),
						proveedor.getCantidadCompraProducto()
				});
			}
		}
	}
			
	public void registrarProveedor() {

		// Obtener los valores ingresados en los JTextField
	    String idNuevoProveedor = ventanaGerente.getTxtProveedorIdProveedoresVG().getText().trim();
	    String idNuevoProducto = ventanaGerente.getTxtProductoIdProveedoresVG().getText().trim();
	    String nombreNuevoProveedor = ventanaGerente.getTxtNombreProveedorVG().getText().trim();
	    String telefonoNuevoProveedor = ventanaGerente.getTxtTelefonoProveedorVG().getText().trim();
	    String emailNuevoProveedor = ventanaGerente.getTxtEmailProveedorVG().getText().trim();
	    double precioCompraNuevoProveedor;
	    int cantidadCompraNuevoProveedor;

	    // Validar entrada numérica
	    try {
	        cantidadCompraNuevoProveedor = Integer.parseInt(ventanaGerente.getTxtCantidadProveedorVG().getText().trim());
	        precioCompraNuevoProveedor = Double.parseDouble(ventanaGerente.getTxtPrecioProveedorVG().getText().replace(',', '.').trim());
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido para cantidad y precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Validar campos obligatorios y formatos
	    if (idNuevoProducto.isEmpty() || nombreNuevoProveedor.isEmpty() || telefonoNuevoProveedor.isEmpty() || emailNuevoProveedor.isEmpty() ||
	            cantidadCompraNuevoProveedor <= 0 || precioCompraNuevoProveedor <= 0 || !Procesos.validarTelefono(telefonoNuevoProveedor) || 
	            !Procesos.validarEmail(emailNuevoProveedor)) {
	        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios y asegúrese de que los formatos sean correctos.", "Campos Obligatorios", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Generar ID automático si está en blanco
	    if (idNuevoProveedor.isEmpty()) {
	        idNuevoProveedor = Procesos.generarProveedorID(8); // Genera un ID de 8 caracteres automáticamente
	        JOptionPane.showMessageDialog(null, "Como el campo ID estaba vacío, se ha generado un ID automáticamente: " + idNuevoProveedor, "ID Generado", JOptionPane.INFORMATION_MESSAGE);
	    }

	    // Verificar duplicados
	    if (Procesos.codigoProveedorExisteEnBD(idNuevoProveedor)) {
	        JOptionPane.showMessageDialog(null, "El ID del proveedor ya existe en la base de datos.", "ID Duplicado", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar si el producto existe
	    Producto productoExistente = miProductoDAO.buscarProductoPorId(idNuevoProducto);
	    if (productoExistente == null) {
	        // Mostrar un mensaje de confirmación para agregar un nuevo producto
	        int opcion = JOptionPane.showConfirmDialog(null, "El ID del producto no existe en la base de datos. ¿Desea agregar un nuevo producto?", "Producto no encontrado", JOptionPane.YES_NO_OPTION);
	        if (opcion == JOptionPane.YES_OPTION) {
	        	
	        	// Solicitar los parámetros para el nuevo producto
	            String nombreNuevoProducto = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo producto:", "Nuevo Producto", JOptionPane.QUESTION_MESSAGE);
	            if (nombreNuevoProducto == null || nombreNuevoProducto.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "El nombre del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            
	            
	            int cantidadStockNuevoProducto;
	            try {
	                String cantidadNuevoProductoStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad del nuevo producto:", "Nuevo Producto", JOptionPane.QUESTION_MESSAGE);
	                if (cantidadNuevoProductoStr == null || cantidadNuevoProductoStr.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "La cantidad del producto es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }
	                cantidadStockNuevoProducto = Integer.parseInt(cantidadNuevoProductoStr);
	                if (cantidadStockNuevoProducto <= 0) {
	                    JOptionPane.showMessageDialog(null, "La cantidad del producto debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "La cantidad del producto debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            double precioVentaNuevoProducto;
	            try {
	                String precioNuevoProductoStr = JOptionPane.showInputDialog(null, "Ingrese el precio de venta del nuevo producto:", "Nuevo Producto", JOptionPane.QUESTION_MESSAGE);
	                if (precioNuevoProductoStr == null || precioNuevoProductoStr.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "El precio del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }
	                precioVentaNuevoProducto = Double.parseDouble(precioNuevoProductoStr);
	                if (precioVentaNuevoProducto <= 0) {
	                    JOptionPane.showMessageDialog(null, "El precio del producto debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "El precio del producto debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	         
	            // Crear el nuevo producto
	            Producto nuevoProducto = new Producto(idNuevoProducto, nombreNuevoProducto, cantidadStockNuevoProducto, precioVentaNuevoProducto);
	           
	            // Actualizar el proveedor con el nuevo producto
                nuevoProducto.setIdProducto(idNuevoProducto);
	            miProductoDAO.guardarProducto(nuevoProducto);
	            leerDatosTablaProductos();
	           
	        } else {
	            // El usuario decidió no agregar un nuevo producto, salir del método
	            return;
	        }
	    }

	    // Verificar si el producto ya está asociado a algún proveedor
	    Proveedor proveedorExistente = miProveedorDAO.buscarProveedorPorIdProducto(productoExistente);
	    if (proveedorExistente != null) {
	        // Verificar si el proveedor es el mismo que se está agregando
	        if (proveedorExistente.getIdProveedor().equals(idNuevoProveedor)) {
	            // El proveedor es el mismo, actualizar los campos de cantidad y precio del producto
	            proveedorExistente.setPrecioCompraProducto(precioCompraNuevoProveedor);
	            proveedorExistente.setCantidadCompraProducto(cantidadCompraNuevoProveedor);
	            miProveedorDAO.actualizarProveedor(proveedorExistente);
	            JOptionPane.showMessageDialog(null, "Se actualizaron los datos del producto para el proveedor existente.", "Producto Actualizado", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            // El proveedor es diferente, crear un nuevo registro en la tabla de proveedores
	            
	        }
	    } else {
	        // El producto no tiene proveedor asociado, crear un nuevo registro en la tabla de proveedores
	       
	    }

	    // Crear nuevo proveedor
	    Proveedor nuevoProveedor = new Proveedor();
	    nuevoProveedor.setIdProveedor(idNuevoProveedor);
	    nuevoProveedor.setIdProducto(miProductoDAO.buscarProductoPorId(idNuevoProducto));
	    nuevoProveedor.setNombreProveedor(nombreNuevoProveedor);
	    nuevoProveedor.setTelefonoProveedor(telefonoNuevoProveedor);
	    nuevoProveedor.setEmailProveedor(emailNuevoProveedor);
	    nuevoProveedor.setPrecioCompraProducto(precioCompraNuevoProveedor);
	    nuevoProveedor.setCantidadCompraProducto(cantidadCompraNuevoProveedor);

	    // Confirmar registro
	    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea registrar este proveedor?", "Confirmar Registro", JOptionPane.YES_NO_OPTION);
	    if (opcion == JOptionPane.YES_OPTION) {
	        miProveedorDAO.guardarProveedor(nuevoProveedor);
	        leerDatosTablaProveedores();
	        vaciarDatosTxtProveedoresVG();
	    }
			    
	}
			
	public void btnActualizarProveedor() {
		
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbProveedoresVG().getModel();
	    int selectedRow = ventanaGerente.getTbProveedoresVG().getSelectedRow();

	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Para poder editar un proveedor primero debe seleccionar una fila.",
	                "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String idProveedorTxt = (String) model.getValueAt(selectedRow, 0);
	    String idProductoTxt = (String) model.getValueAt(selectedRow, 1);

	    String nombreProveedor = ventanaGerente.getTxtNombreProveedorVG().getText().trim();
	    String telefonoProveedor = ventanaGerente.getTxtTelefonoProveedorVG().getText().trim();
	    String emailProveedor = ventanaGerente.getTxtEmailProveedorVG().getText().trim();
	    String cantidadProveedorStr = ventanaGerente.getTxtCantidadProveedorVG().getText().trim();
	    String precioProveedorStr = ventanaGerente.getTxtPrecioProveedorVG().getText().trim().replace(',', '.');

	    if (idProveedorTxt.isBlank() || idProductoTxt.isBlank() || nombreProveedor.isBlank() || telefonoProveedor.isBlank() ||
	            emailProveedor.isBlank() || cantidadProveedorStr.isBlank() || precioProveedorStr.isBlank() 
	            || !Procesos.validarTelefono(telefonoProveedor) || !Procesos.validarEmail(emailProveedor)) {
	        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.",
	                "Debe rellenar todos los campos.", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    Proveedor proveedorActualizado = new Proveedor();
	    Producto productoActualizado = new Producto();

	    productoActualizado = miProductoDAO.buscarProductoPorId(idProductoTxt);

	    proveedorActualizado.setIdProveedor(idProveedorTxt);
	    proveedorActualizado.setIdProducto(productoActualizado);
	    proveedorActualizado.setNombreProveedor(nombreProveedor);
	    proveedorActualizado.setTelefonoProveedor(telefonoProveedor);
	    proveedorActualizado.setEmailProveedor(emailProveedor);

	    try {
	        double precioCompraProveedor = Double.parseDouble(precioProveedorStr);
	        int cantidadProveedor = Integer.parseInt(cantidadProveedorStr);
	        if (cantidadProveedor < 0) {
	            JOptionPane.showMessageDialog(null, "La cantidad del proveedor debe ser un valor entero positivo.",
	                    "Error de Formato", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        proveedorActualizado.setPrecioCompraProducto(precioCompraProveedor);
	        proveedorActualizado.setCantidadCompraProducto(cantidadProveedor);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos para cantidad y precio.",
	                "Error de Formato", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String nuevoIdProveedor = ventanaGerente.getTxtProveedorIdProveedoresVG().getText().trim();
	    if (!nuevoIdProveedor.equals(idProveedorTxt)) {
	        if (!nuevoIdProveedor.isBlank()) {
	            if (Procesos.codigoProveedorExisteEnBD(nuevoIdProveedor)) {
	                JOptionPane.showMessageDialog(null, "No se puede editar el ID existente.",
	                        "ID EXISTENTE", JOptionPane.ERROR_MESSAGE);
	                return;
	            } else {
	                proveedorActualizado.setIdProveedor(nuevoIdProveedor);
	            }
	        }
	    }

	    String nuevoIdProducto = ventanaGerente.getTxtProductoIdProveedoresVG().getText().trim();

	    if (!nuevoIdProducto.equals(idProductoTxt)) {
	        if (!nuevoIdProducto.isBlank()) {
	            if (!nuevoIdProducto.equals(productoActualizado.getIdProducto())) {
	                if (Procesos.codigoProductoExisteEnBD(nuevoIdProducto)) {
	                    productoActualizado.setIdProducto(nuevoIdProducto);
	                } else {
	                    int opcionNuevoProducto = JOptionPane.showConfirmDialog(null, "El ID del producto no existe en la base de datos. ¿Desea crear un nuevo producto?", "Crear Nuevo Producto", JOptionPane.YES_NO_OPTION);
	                    if (opcionNuevoProducto == JOptionPane.YES_OPTION) {
	                        String nombreNuevoProducto = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo producto:", "Nuevo Producto", JOptionPane.QUESTION_MESSAGE);
	                        if (nombreNuevoProducto == null || nombreNuevoProducto.isEmpty()) {
	                            JOptionPane.showMessageDialog(null, "El nombre del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	                            return;
	                        }

	                        int cantidadStockNuevoProducto;
	                        try {
	                            String cantidadNuevoProductoStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad del nuevo producto:", "Nuevo Producto", JOptionPane.QUESTION_MESSAGE);
	                            if (cantidadNuevoProductoStr == null || cantidadNuevoProductoStr.isEmpty()) {
	                                JOptionPane.showMessageDialog(null, "La cantidad del producto es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
	                                return;
	                            }
	                            cantidadStockNuevoProducto = Integer.parseInt(cantidadNuevoProductoStr);
	                            if (cantidadStockNuevoProducto <= 0) {
	                                JOptionPane.showMessageDialog(null, "La cantidad del producto debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                                return;
	                            }
	                        } catch (NumberFormatException e) {
	                            JOptionPane.showMessageDialog(null, "La cantidad del producto debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                            return;
	                        }

	                        double precioVentaNuevoProducto;
	                        try {
	                            String precioNuevoProductoStr = JOptionPane.showInputDialog(null, "Ingrese el precio de venta del nuevo producto:", "Nuevo Producto", JOptionPane.QUESTION_MESSAGE);
	                            if (precioNuevoProductoStr == null || precioNuevoProductoStr.isEmpty()) {
	                                JOptionPane.showMessageDialog(null, "El precio del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	                                return;
	                            }
	                            precioNuevoProductoStr = precioNuevoProductoStr.replace(",", ".");
	                            precioVentaNuevoProducto = Double.parseDouble(precioNuevoProductoStr);
	                            if (precioVentaNuevoProducto <= 0) {
	                                JOptionPane.showMessageDialog(null, "El precio del producto debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                                return;
	                            }
	                        } catch (NumberFormatException e) {
	                            JOptionPane.showMessageDialog(null, "El precio del producto debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                            return;
	                        }

	                        Producto nuevoProducto = new Producto(nuevoIdProducto, nombreNuevoProducto, cantidadStockNuevoProducto, precioVentaNuevoProducto);
	                        miProductoDAO.guardarProducto(nuevoProducto);
	                        leerDatosTablaProductos();
	                        JOptionPane.showMessageDialog(null, "Se ha guardado el nuevo producto.",
	                                "Nuevo producto guardado", JOptionPane.INFORMATION_MESSAGE);
	                        
	                        // Actualizamos el proveedor con el nuevo producto
	                        productoActualizado.setIdProducto(nuevoIdProducto);
	                    } else {
	                        return;
	                    }
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "El ID del producto no puede estar vacio.", "ID Producto sin rellenar", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    }

	    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea editar este proveedor?",
	            "Confirmar edicion", JOptionPane.YES_NO_OPTION);

	    if (opcion == JOptionPane.YES_OPTION) {
	        miProveedorDAO.actualizarProveedor(proveedorActualizado);
	        leerDatosTablaProveedores();
	        vaciarDatosTxtProveedoresVG();
	    }		
	}			
			
	public void btnEliminarProveedor() {
		
		// Obtener la fila seleccionada en la tabla
		int filaSeleccionada = ventanaGerente.getTbProveedoresVG().getSelectedRow();
			    
		// Verificar si se ha seleccionado una fila
		if (filaSeleccionada == -1) {
			// No se ha seleccionado ninguna fila, mostrar un mensaje de error
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un proveedor de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			    
		// Obtener el ID del cliente seleccionado en la tabla
		String idProveedor = (String) ventanaGerente.getTbProveedoresVG().getValueAt(filaSeleccionada, 0);
			    
		// Obtener el objeto Cliente correspondiente al ID seleccionado
		Proveedor proveedorAEliminar = miProveedorDAO.buscarProveedorPorId(idProveedor);
			    
		// Confirmar si el usuario realmente desea eliminar el cliente seleccionado
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este proveedor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			    
		// Si el usuario confirma la eliminación, proceder con la eliminación del cliente
		if (opcion == JOptionPane.YES_OPTION) {
			// Llamar al método eliminarCliente() de ClienteDAO para eliminar el cliente de la base de datos
			miProveedorDAO.eliminarProveedor(proveedorAEliminar);
			        
			// Actualizar la tabla para reflejar los cambios
			leerDatosTablaProveedores(); 
			vaciarDatosTxtProveedoresVG();
		}
	}
			
	/*
	 * PESTAÑA PEDIDOS
	 */
			
	public void extraerDatosTablaPedidos() {
		
		// Obtener el modelo de la tabla
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbPedidosVG().getModel();
			    
		// Obtener el índice de la fila seleccionada
		int selectedRow = ventanaGerente.getTbPedidosVG().getSelectedRow();
			    
		// Verificar si hay una fila seleccionada
		if (selectedRow != -1) {
			// Obtener los valores de cada celda de la fila seleccionada
			String idPedido = (String) model.getValueAt(selectedRow, 0);
			String idCliente = (String) model.getValueAt(selectedRow, 1);
			String idProducto = (String) model.getValueAt(selectedRow, 2);
			String metodoPago = (String) model.getValueAt(selectedRow, 3);
			String nombreProductoSolicitado = (String) model.getValueAt(selectedRow, 4);
			int cantidadProductoSolicitador = (int) model.getValueAt(selectedRow, 5);
			double totalTicketPedido = (double) model.getValueAt(selectedRow, 6);			
			        
			// Escribir los valores en los campos de texto correspondientes
			ventanaGerente.getTxtPedidoIdPedidosVG().setText(idPedido);
			ventanaGerente.getTxtClienteIdPedidosVG().setText(idCliente);
			ventanaGerente.getTxtProductoIdPedidosVG().setText(idProducto);			        
			ventanaGerente.getTxtMetodoPagoClientesVG().setText(metodoPago);
			ventanaGerente.getTxtNombreProductoPedidosVG().setText(nombreProductoSolicitado);			
			ventanaGerente.getTxtCantidadProductoPedidosVG().setText(String.valueOf(cantidadProductoSolicitador));
			ventanaGerente.getTxtTotalTicketPedidoPedidosVG().setText(String.valueOf(totalTicketPedido));
		} else {
			// Si no hay fila seleccionada, limpiar todos los campos de texto
			vaciarDatosTxtPedidosVG();
		}
	}
	
	public void vaciarDatosTxtPedidosVG() {
				 
		ventanaGerente.getTxtPedidoIdPedidosVG().setText("");
		ventanaGerente.getTxtClienteIdPedidosVG().setText("");
		ventanaGerente.getTxtProductoIdPedidosVG().setText("");
		ventanaGerente.getTxtMetodoPagoClientesVG().setText("");
		ventanaGerente.getTxtNombreProductoPedidosVG().setText("");
		ventanaGerente.getTxtCantidadProductoPedidosVG().setText("");
		ventanaGerente.getTxtTotalTicketPedidoPedidosVG().setText("");
	}
			 
	public void leerDatosTablaPedidos() {
		
		// Limpiar la tabla antes de agregar nuevos datos
		DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbPedidosVG().getModel();
		model.setRowCount(0);
			    
		// Obtener la lista actualizada de pedidos desde la base de datos
		List<Pedido> listaPedidos = miPedidoDAO.obtenerTodosLosPedidos();
		misProcesos.actualizarTablaPedidos(listaPedidos, ventanaGerente.getTbPedidosVG());
		// Verificar si la lista de pedidos no está vacía
		if (listaPedidos != null) {
			// Iterar sobre la lista de pedidos y agregar cada pedido a la tabla
			for (Pedido pedido : listaPedidos) {
				model.addRow(new Object[] {
						pedido.getIdPedido(),
						pedido.getIdCliente().getIdCliente(),
						pedido.getIdProducto().getIdProducto(),
						pedido.getMetodoPago(),
						pedido.getNombreProductoSolicitado(),
						pedido.getCantidadProductoSolicitado(),
						pedido.getTotalTicketPedido()
				});
			}
		}
	}
			
	public void registrarPedido() {

		// Obtener los valores ingresados en los JTextField
	    String idNuevoPedido = ventanaGerente.getTxtPedidoIdPedidosVG().getText().trim();
	    String idNuevoCliente = ventanaGerente.getTxtClienteIdPedidosVG().getText().trim();
	    String idNuevoProducto = ventanaGerente.getTxtProductoIdPedidosVG().getText().trim();
	    String metodoPagoNuevoPedido = ventanaGerente.getTxtMetodoPagoClientesVG().getText().trim();
	    String nombreProductoNuevoPedido = ventanaGerente.getTxtNombreProductoPedidosVG().getText().trim();
	    int cantidadProductoNuevoPedido;
	    double totalTicketNuevoPedido;
	    

	    // Validar entrada numérica
	    try {
	        cantidadProductoNuevoPedido = Integer.parseInt(ventanaGerente.getTxtCantidadProductoPedidosVG().getText().trim());
	        totalTicketNuevoPedido = Double.parseDouble(ventanaGerente.getTxtTotalTicketPedidoPedidosVG().getText().replace(',', '.').trim());
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido para cantidad y total.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Validar campos obligatorios y formatos
	    if (idNuevoCliente.isEmpty() || idNuevoProducto.isEmpty() || metodoPagoNuevoPedido.isEmpty() || nombreProductoNuevoPedido.isEmpty() ||
	            cantidadProductoNuevoPedido <= 0 || totalTicketNuevoPedido <= 0) {
	        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios y asegúrese de que los formatos sean correctos.", "Campos Obligatorios", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Generar ID automático si está en blanco
	    if (idNuevoPedido.isEmpty()) {
	        idNuevoPedido = Procesos.generarPedidoID(8); // Genera un ID de 8 caracteres automáticamente
	        JOptionPane.showMessageDialog(null, "Como el campo ID estaba vacío, se ha generado un ID automáticamente: " + idNuevoPedido, "ID Generado", JOptionPane.INFORMATION_MESSAGE);
	    }

	    // Verificar duplicados
	    if (Procesos.codigoPedidoExisteEnBD(idNuevoPedido)) {
	        JOptionPane.showMessageDialog(null, "El ID del pedido ya existe en la base de datos.", "ID Duplicado", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar si el producto existe
	    Producto productoExistente = miProductoDAO.buscarProductoPorId(idNuevoProducto);
	   
	    if (productoExistente != null) {
	        // Si se encuentra el producto por su ID, verificar si el nombre coincide
	        if (!productoExistente.getNombreProducto().equals(nombreProductoNuevoPedido)) {
	            // Si el nombre no coincide, mostrar un mensaje y salir del método
	            JOptionPane.showMessageDialog(null, "El nombre del producto no coincide con el producto encontrado por ID en la base de datos.", "Nombre de Producto Incorrecto", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    } else {
	        // Si no se encuentra el producto por su ID, mostrar un mensaje y salir del método
	        JOptionPane.showMessageDialog(null, "El producto no existe en la base de datos.", "Producto no Encontrado", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    Cliente clienteExistente = miClienteDAO.buscarClientePorId(idNuevoCliente);
	    
	    if (clienteExistente != null) {
	        // Si se encuentra el cliente por su ID, verificar si el nombre coincide
	        if (!clienteExistente.getIdCliente().equals(idNuevoCliente)) {
	            // Si el nombre no coincide, mostrar un mensaje y salir del método
	            JOptionPane.showMessageDialog(null, "El Id del cliente no coincide con el cliente encontrado por ID en la base de datos.", "Cliente Incorrecto", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    } else {
	        // Si no se encuentra el producto por su ID, mostrar un mensaje y salir del método
	        JOptionPane.showMessageDialog(null, "El cliente no existe en la base de datos.", "Cliente no Encontrado", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Crear nuevo pedido
	    Pedido nuevoPedido = new Pedido();
	    nuevoPedido.setIdPedido(idNuevoPedido);
	    nuevoPedido.setIdCliente(miClienteDAO.buscarClientePorId(idNuevoCliente));
	    nuevoPedido.setIdProducto(miProductoDAO.buscarProductoPorId(idNuevoProducto));
	    nuevoPedido.setMetodoPago(metodoPagoNuevoPedido);
	    nuevoPedido.setNombreProductoSolicitado(nombreProductoNuevoPedido);
	    nuevoPedido.setCantidadProductoSolicitado(cantidadProductoNuevoPedido);
	    nuevoPedido.setTotalTicketPedido(totalTicketNuevoPedido);	   

	    // Confirmar registro
	    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea registrar este pedido?", "Confirmar Registro", JOptionPane.YES_NO_OPTION);
	    if (opcion == JOptionPane.YES_OPTION) {
	        miPedidoDAO.guardarPedido(nuevoPedido);
	        leerDatosTablaPedidos();
	        vaciarDatosTxtPedidosVG();
	    }
	    
	    // Crear nuevo detalle de pedido
	    DetallePedido detallePedido = new DetallePedido();
	    detallePedido.setIdDetallePedido(Procesos.generarDetallePedidoID(8));
	    detallePedido.setIdCliente(clienteExistente);
	    detallePedido.setIdPedido(nuevoPedido);
	    detallePedido.setDescripcion(crearDescripcionPedido(nombreProductoNuevoPedido, cantidadProductoNuevoPedido, totalTicketNuevoPedido));
	    // Guardar el detalle del pedido
	    miDetallePedidoDAO.guardarDetallePedido(detallePedido);
		}

		// Método para crear la descripción del pedido
		private String crearDescripcionPedido(String nombreProducto, int cantidadProducto, double precioProducto) {
	    return "Nombre del Producto: " + nombreProducto + "\n" +
	           "Cantidad del Producto: " + cantidadProducto + "\n" +
	           "Precio del Producto: " + precioProducto + "\n";
	    
	}
			
	public void btnActualizarPedido() {
		
		 DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbPedidosVG().getModel();
		    int selectedRow = ventanaGerente.getTbPedidosVG().getSelectedRow();

		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Para poder editar un pedido primero debe seleccionar una fila.",
		                "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    String idPedidoTxt = (String) model.getValueAt(selectedRow, 0);
		    String idCliente = (String) model.getValueAt(selectedRow, 1);
		    String idProducto = (String) model.getValueAt(selectedRow, 2);

		    String nuevoIdCliente = ventanaGerente.getTxtClienteIdPedidosVG().getText().trim();
		    String nuevoIdProducto = ventanaGerente.getTxtProductoIdPedidosVG().getText().trim();
		    String metodoPagoPedidoTxt = ventanaGerente.getTxtMetodoPagoClientesVG().getText().trim();
		    String nombreProductoPedidoTxt = ventanaGerente.getTxtNombreProductoPedidosVG().getText().trim();
		    String cantidadPedidoStr = ventanaGerente.getTxtCantidadProductoPedidosVG().getText().trim();
		    String precioPedidoStr = ventanaGerente.getTxtTotalTicketPedidoPedidosVG().getText().trim().replace(',', '.');

		    if (nuevoIdCliente.isBlank() || nuevoIdProducto.isBlank() || metodoPagoPedidoTxt.isBlank() || nombreProductoPedidoTxt.isBlank() || cantidadPedidoStr.isBlank() || precioPedidoStr.isBlank()) {
		        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.",
		                "Debe rellenar todos los campos.", JOptionPane.INFORMATION_MESSAGE);
		        return;
		    }

		    Pedido pedidoActualizado = new Pedido();
		    Cliente clienteEncontrado = miClienteDAO.buscarClientePorId(idCliente);
		    Producto productoEncontrado = miProductoDAO.buscarProductoPorId(idProducto);

		    pedidoActualizado.setIdPedido(idPedidoTxt);
		    pedidoActualizado.setIdCliente(clienteEncontrado);
		    pedidoActualizado.setIdProducto(productoEncontrado);
		    pedidoActualizado.setMetodoPago(metodoPagoPedidoTxt);
		    pedidoActualizado.setNombreProductoSolicitado(nombreProductoPedidoTxt);

		    try {
		        double precioTotalPedido = Double.parseDouble(precioPedidoStr);
		        int cantidadPedido = Integer.parseInt(cantidadPedidoStr);
		        if (cantidadPedido < 0) {
		            JOptionPane.showMessageDialog(null, "La cantidad del pedido debe ser un valor entero positivo.",
		                    "Error de Formato", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        pedidoActualizado.setTotalTicketPedido(precioTotalPedido);
		        pedidoActualizado.setCantidadProductoSolicitado(cantidadPedido);
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos para cantidad y total.",
		                "Error de Formato", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    String nuevoIdPedido = ventanaGerente.getTxtPedidoIdPedidosVG().getText().trim();
		    if (!nuevoIdPedido.equals(idPedidoTxt)) {
		        if (!nuevoIdPedido.isBlank()) {
		            if (Procesos.codigoPedidoExisteEnBD(nuevoIdPedido)) {
		                JOptionPane.showMessageDialog(null, "No se puede editar el ID existente.",
		                        "ID EXISTENTE", JOptionPane.ERROR_MESSAGE);
		                return;
		            } else {
		                pedidoActualizado.setIdPedido(nuevoIdPedido);
		            }
		        }
		    }
		    
		    
		    if (nuevoIdCliente.isBlank()) {
		        JOptionPane.showMessageDialog(null, "El ID del cliente no puede estar vacío.", "ID de Cliente Vacío", JOptionPane.ERROR_MESSAGE);
		        return;
		    }
		    Cliente clienteExiste = miClienteDAO.buscarClientePorId(nuevoIdCliente);
		    
		  
		    if (clienteExiste != null) {
		    	if (!clienteExiste.getIdCliente().equals(nuevoIdCliente)) {
		    		JOptionPane.showMessageDialog(null, "El ID del cliente no coincide con el cliente encontrado por ID en la base de datos.", "ID de Producto Incorrecto", JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
		    	// Aquí puedes hacer algo con clienteExiste
		    	pedidoActualizado.setIdCliente(clienteExiste);
		    } else {
		    	// Si no se encuentra el cliente por su ID, mostrar un mensaje y salir del método
		    	JOptionPane.showMessageDialog(null, "El cliente con ID " + nuevoIdCliente + " no existe en la base de datos.", "Cliente no Encontrado", JOptionPane.ERROR_MESSAGE);
		    	return;
		    }
		   		    
		    Producto productoExiste = miProductoDAO.buscarProductoPorId(nuevoIdProducto);
		    
		    
		    if (productoEncontrado != null) {
		    	if (!productoExiste.getIdProducto().equals(nuevoIdProducto)) {
		    		JOptionPane.showMessageDialog(null, "El ID del producto no coincide con el producto encontrado por ID en la base de datos.", "ID de Producto Incorrecto", JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
		    	// Si se encuentra el producto por su ID, verificar si el nombre coincide
		    	if (!productoExiste.getNombreProducto().equals(nombreProductoPedidoTxt)) {
		    		JOptionPane.showMessageDialog(null, "El nombre del producto no coincide con el producto encontrado por ID en la base de datos.", "Nombre de Producto Incorrecto", JOptionPane.ERROR_MESSAGE);
		    		return;
		    	}
		          
		    	pedidoActualizado.setIdProducto(productoExiste);
		    	pedidoActualizado.setNombreProductoSolicitado(nombreProductoPedidoTxt);
		            
		    } else {
		    	// Si no se encuentra el producto por su ID, mostrar un mensaje y salir del método
		    	JOptionPane.showMessageDialog(null, "El producto con ID " + nuevoIdProducto + " no existe en la base de datos.", "Producto no Encontrado", JOptionPane.ERROR_MESSAGE);
		    	return;
		    }

		    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea editar este pedido?",
		            "Confirmar edicion", JOptionPane.YES_NO_OPTION);

		    if (opcion == JOptionPane.YES_OPTION) {
		        miPedidoDAO.actualizarPedido(pedidoActualizado);
		        leerDatosTablaPedidos();
		        vaciarDatosTxtPedidosVG();
		    }    
	    
	    }
								
	public void btnEliminarPedido() {
		
		// Obtener la fila seleccionada en la tabla
		int filaSeleccionada = ventanaGerente.getTbPedidosVG().getSelectedRow();
			    
		// Verificar si se ha seleccionado una fila
		if (filaSeleccionada == -1) {
			// No se ha seleccionado ninguna fila, mostrar un mensaje de error o advertencia
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un pedido de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			    
		// Obtener el ID del pedido seleccionado en la tabla
		String idPedido = (String) ventanaGerente.getTbPedidosVG().getValueAt(filaSeleccionada, 0);
			    
		// Obtener el objeto Cliente correspondiente al ID seleccionado
		Pedido pedidoAEliminar = miPedidoDAO.buscarPedidoPorId(idPedido);
			    
		// Confirmar si el usuario realmente desea eliminar el cliente seleccionado
		int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este pedido?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			    
		// Si el usuario confirma la eliminación, proceder con la eliminación del pedido
		if (opcion == JOptionPane.YES_OPTION) {
			// Llamar al método eliminarPedido() de PedidoDAO para eliminar el pedido de la base de datos
			miPedidoDAO.eliminarPedido(pedidoAEliminar);
			        
			// Actualizar la tabla para reflejar los cambios
			leerDatosTablaPedidos(); 
			vaciarDatosTxtPedidosVG();
		}
	}	
	
	public void btndDetallePedido() {
		
		 // Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) ventanaGerente.getTbPedidosVG().getModel();
	    
	    // Obtener el índice de la fila seleccionada
	    int selectedRow = ventanaGerente.getTbPedidosVG().getSelectedRow();

	    // Verificar si se ha seleccionado alguna fila
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para ver el detalle del pedido.",
	                "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Obtener los datos necesarios para construir la descripción del pedido
	    String idProducto = (String) model.getValueAt(selectedRow, 2);
	    String nombreProducto = (String) model.getValueAt(selectedRow, 4);
	    int cantidadProducto = (int) model.getValueAt(selectedRow, 5);
	    double totalProducto = (double) model.getValueAt(selectedRow, 6);
	    double precioVentaProducto = misProcesos.obtenerPrecioProductoPorId(idProducto);

	    // Construir la descripción del pedido
	    String descripcionPedido = "Nombre del Producto: " + nombreProducto + "\n" +
	                                "Cantidad del Producto: " + cantidadProducto + "\n" +
	                                "Precio del Producto: " + precioVentaProducto + "\n" +
	                                "Total del Ticket: " + totalProducto + "\n";
	    	    
	    // Establecer el texto actualizado en el JTextArea
	    ventanaGerente.getTxtAreaDetallePedidoGerente().setText(descripcionPedido);
	}
	
	/*
	 * PESTAÑA INFORMES	
	 */
	
	public void numProductosConsumidos() {
		
		int cantidadProductosConsumidos = misProcesos.calcularCantidadProductosConsumidos();
	    String calculoProductosConsumidos = String.valueOf(cantidadProductosConsumidos);
	    ventanaGerente.getLblNumProductosConsumidosVG().setText(calculoProductosConsumidos);
	}
	
	public void productoTop() {
		
		String productoTop = misProcesos.calcularProductoMasDemandado();
	    
	    ventanaGerente.getLblNombreProductoTopVG().setText(productoTop);
	}
	
	public void totalStockProductos() {
		
		int cantidadProductosStock = misProcesos.calcularTotalProductosEnStock();
		
		String totalStock = String.valueOf(cantidadProductosStock);
	    
	    ventanaGerente.getLblNumTotalStockVG().setText(totalStock);
	}
	
	public void totalCaja() {
		
		double totalCaja = misProcesos.calcularTotalCaja();
		
		String total = String.valueOf(totalCaja);
	    
	    ventanaGerente.getLblNumCajaVG().setText(total);
	}
	
	public void ticketMedio() {
		
		double ticketMedio = misProcesos.calcularTicketMedio();
		
		String media = String.valueOf(ticketMedio);
	    
	    ventanaGerente.getLblNumTicketMedioVG().setText(media);
	}
	
	public void highTicket() {
		
		double highTicket = misProcesos.calcularTicketMasAlto();
		
		String high = String.valueOf(highTicket);
	    
	    ventanaGerente.getLblNumTicketTopVG().setText(high);
	}
	
	public void totalPedidos() {
		
		int totalPedidos = misProcesos.calcularTotalPedidos();
		
		String totalP = String.valueOf(totalPedidos);
	    
	    ventanaGerente.getLblNumTotalPedidosVG().setText(totalP);
	}
	
	public void contadorPedidosVG() {
		
		 int numPedidosSinConfirmar = ventanaEmpleado.getLstSinConfirmar().getModel().getSize();
		 int numPedidosConfirmados = ventanaEmpleado.getLstPedidosConfirmados().getModel().getSize();		 
		 int numPedidosListos = ventanaEmpleado.getLstPedidosListos().getModel().getSize();
	     
		 // Calcular el total de pedidos gestionados
		 int numPedidosTotal = numPedidosListos + numPedidosConfirmados + numPedidosSinConfirmar;
	      
		 // Concatenar las cadenas individualmente con sus respectivos valores numéricos
		 ventanaGerente.getLblNumPedidosSinConfirmarVG().setText(String.valueOf(numPedidosSinConfirmar));
	       
		 ventanaGerente.getLblNumPedidosConfirmadosVG().setText(String.valueOf(numPedidosConfirmados));
	        
		 ventanaGerente.getLblNumPedidosEntregadosVG().setText(String.valueOf(numPedidosListos));
	        
		 ventanaGerente.getLblNumPedidosTotalVG().setText(String.valueOf(numPedidosTotal));
	}

	public Empleado getEmpleadoTrabajando() {
		return empleadoTrabajando;
	}

	public void setEmpleadoTrabajando(Empleado empleadoTrabajando) {
		this.empleadoTrabajando = empleadoTrabajando;
	}
	
}	