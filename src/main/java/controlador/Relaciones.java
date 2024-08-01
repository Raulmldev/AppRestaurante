package controlador;

import modelo.Coordinador;
import modelo.EventoCliente;
import modelo.EventoEmpleado;
import modelo.EventoGerente;
import modelo.EventoLista;
import modelo.EventoPrincipal;
import vista.VentanaCliente;
import vista.VentanaEmpleado;
import vista.VentanaGerente;
import vista.VentanaLista;
import vista.VentanaPrincipal;

public class Relaciones {	
		
	public void iniciar() {
		
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		VentanaLista ventanaLista = new VentanaLista();
		VentanaCliente ventanaCliente = new VentanaCliente();
		VentanaEmpleado ventanaEmpleado = new VentanaEmpleado();
		VentanaGerente ventanaGerente = new VentanaGerente();
		
		Coordinador miCoordinador = new Coordinador();
		
		Conexion miConexion = new Conexion();	
		
		Procesos misProcesos = new Procesos(miCoordinador,miConexion);
		
		//iniciar conexion
		miConexion.conectar();	
	
		
		ClienteDAO miClienteDAO = new ClienteDAO(miCoordinador, miConexion);
		EmpleadoDAO miEmpleadoDAO = new EmpleadoDAO(miCoordinador, miConexion);
		PedidoDAO miPedidoDAO = new PedidoDAO(miCoordinador, miConexion);
		DetallePedidoDAO miDetallePedidoDAO = new DetallePedidoDAO(miCoordinador, miConexion);
		ProductoDAO miProductoDAO= new ProductoDAO (miCoordinador, miConexion);
		ProveedorDAO miProveedorDAO = new ProveedorDAO (miCoordinador, miConexion);
		
		//Se establece relacion entre las clases
		ventanaPrincipal.setCoordinador(miCoordinador);
		ventanaLista.setCoordinador(miCoordinador);
		ventanaCliente.setCoordinador(miCoordinador);
		ventanaEmpleado.setCoordinador(miCoordinador);
		ventanaGerente.setCoordinador(miCoordinador);
		
		miConexion.setCoordinador(miCoordinador);		
		
		misProcesos.setCoordinador(miCoordinador);		
		
		miClienteDAO.setCoordinador(miCoordinador);
		miEmpleadoDAO.setCoordinador(miCoordinador);
		miPedidoDAO.setCoordinador(miCoordinador);
		miDetallePedidoDAO.setCoordinador(miCoordinador);
		miProductoDAO.setCoordinador(miCoordinador);
		miProveedorDAO.setCoordinador(miCoordinador);
		
		//Se establecen las relaciones con la clase Coordinador
		miCoordinador.setVentanaPrincipal(ventanaPrincipal);
		miCoordinador.setVentanaLista(ventanaLista);
		miCoordinador.setVentanaCliente(ventanaCliente);
		miCoordinador.setVentanaEmpleado(ventanaEmpleado);
		miCoordinador.setVentanaGerente(ventanaGerente);
		
		miCoordinador.setConexion(miConexion);
		
		miCoordinador.setProcesos(misProcesos);
		
		miCoordinador.setClienteDAO(miClienteDAO);
		miCoordinador.setEmpleadoDAO(miEmpleadoDAO);
		miCoordinador.setPedidoDAO(miPedidoDAO);
		miCoordinador.setDetallePedidoDAO(miDetallePedidoDAO);
		miCoordinador.setProductoDAO(miProductoDAO);
		miCoordinador.setProveedorDAO(miProveedorDAO);
	
		//muestra VentanaPrincipal
		miCoordinador.mostrarVentanaPrincipal();
		
		//carga datos de todas las tablas
		miCoordinador.cargarDatosTablas();
		
		// Crear una instancia de EventoPrincipal pasando el Coordinador y los getter de los botones
        EventoPrincipal eventoPrincipal = new EventoPrincipal(miCoordinador, ventanaPrincipal.getBtnVentanaCliente(), ventanaPrincipal.getBtnVentanaEmpleado(),ventanaPrincipal.getBtnVentanaGerente(), ventanaPrincipal.getBtnSalir());

        // Asignar el evento creado a los botones
        ventanaPrincipal.getBtnVentanaCliente().addActionListener(eventoPrincipal);
        ventanaPrincipal.getBtnVentanaEmpleado().addActionListener(eventoPrincipal);
        ventanaPrincipal.getBtnVentanaGerente().addActionListener(eventoPrincipal);
        ventanaPrincipal.getBtnSalir().addActionListener(eventoPrincipal);
        
        // Crear una instancia de EventoCliente pasando el Coordinador y los getter de los botones
        EventoLista eventoLista = new EventoLista(miCoordinador, ventanaLista.getBtnNuevoPedidoVL());
        
        // Asignar el evento creado a los botones
        ventanaLista.getBtnNuevoPedidoVL().addActionListener(eventoLista);
        
        // Crear una instancia de EventoCliente pasando el Coordinador y los getter de los botones
        EventoCliente eventoCliente = new EventoCliente(miCoordinador, ventanaCliente.getBtnVolver(), ventanaCliente.getBtnAyuda(), 
        		ventanaCliente.getBtnReiniciar(), ventanaCliente.getBtnComentario(), ventanaCliente.getBtnAgregar(), 
        		ventanaCliente.getBtnRealizarPedido(), ventanaCliente.getRadioEfectivo(),ventanaCliente.getRadioTarjeta());
        
        // Asignar el evento creado a los botones
        ventanaCliente.getBtnVolver().addActionListener(eventoCliente);
        ventanaCliente.getBtnAyuda().addActionListener(eventoCliente);
        ventanaCliente.getBtnReiniciar().addActionListener(eventoCliente);
        ventanaCliente.getBtnComentario().addActionListener(eventoCliente);
        ventanaCliente.getBtnAgregar().addActionListener(eventoCliente);
        ventanaCliente.getBtnRealizarPedido().addActionListener(eventoCliente);
        ventanaCliente.getRadioEfectivo().addActionListener(eventoCliente);
        ventanaCliente.getRadioTarjeta().addActionListener(eventoCliente);
        
        //Crear una instancia de EventoEmpleado pasando el Coordinador y los getter de los botones
        EventoEmpleado eventoEmpleado = new EventoEmpleado(miCoordinador, ventanaEmpleado.getBtnPedidoEntregado(), ventanaEmpleado.getBtnEliminarPedidosConfirmados(),
        		ventanaEmpleado.getBtnPedidoListo(), ventanaEmpleado.getBtnEliminarPedidoSinConfirmar(), ventanaEmpleado.getBtnConfirmarPedido(), 
        		ventanaEmpleado.getLstSinConfirmar(), ventanaEmpleado.getLstPedidosConfirmados(), ventanaEmpleado.getLstPedidosListos());
        
        // Asignar el evento creado a los botones
        ventanaEmpleado.getBtnPedidoEntregado().addActionListener(eventoEmpleado);
        ventanaEmpleado.getBtnEliminarPedidosConfirmados().addActionListener(eventoEmpleado);
        ventanaEmpleado.getBtnPedidoListo().addActionListener(eventoEmpleado);
        ventanaEmpleado.getBtnEliminarPedidoSinConfirmar().addActionListener(eventoEmpleado);
        ventanaEmpleado.getBtnConfirmarPedido().addActionListener(eventoEmpleado);
        ventanaEmpleado.getLstSinConfirmar().addListSelectionListener(eventoEmpleado);
        ventanaEmpleado.getLstPedidosConfirmados().addListSelectionListener(eventoEmpleado);
        ventanaEmpleado.getLstPedidosListos().addListSelectionListener(eventoEmpleado);
        
        //Crear una instancia de EventoGerente pasando el Coordinador y los getter de los botones
        EventoGerente eventoGerente = new EventoGerente(miCoordinador, ventanaGerente.getTbClientesVG(), ventanaGerente.getBtnRegistrarClienteVG(), 
        		ventanaGerente.getBtnEditarClienteVG(), ventanaGerente.getBtnEliminarClienteVG(), ventanaGerente.getBtnRefreshClientesVG(),	
        		ventanaGerente.getTbProductosVG(), ventanaGerente.getBtnRegistrarProductoVG(), ventanaGerente.getBtnActualizarProductoVG(),
        		ventanaGerente.getBtnEliminarProductoVG(), ventanaGerente.getBtnRefreshProductosVG(), ventanaGerente.getTbProveedoresVG(), 
        		ventanaGerente.getBtnRegistrarProveedorVG(), ventanaGerente.getBtnActualizarProveedorVG(), ventanaGerente.getBtnEliminarProveedorVG(),
        		ventanaGerente.getBtnRefreshProveedoresVG(), ventanaGerente.getTbEmpleadoVG(), ventanaGerente.getBtnRegistrarEmpleadoVG(),
        		ventanaGerente.getBtnEditarEmpleadoVG(), ventanaGerente.getBtnEliminarEmpleadoVG(), ventanaGerente.getBtnRefreshEmpleadosVG(),
        		ventanaGerente.getBtnPonerTurnoEmpleadoVG(), ventanaGerente.getBtnQuitarTurnoEmpleadoVG(), ventanaGerente.getTbPedidosVG(), 
        		ventanaGerente.getBtnRegistrarPedidosVG(), ventanaGerente.getBtnEditarPedidosVG(), ventanaGerente.getBtnEliminarPedidosVG(),
        		ventanaGerente.getBtnRefreshPedidosVG(), ventanaGerente.getBtnDetalleGerente(), ventanaGerente.getBtnRefreshInformesVG());
        
     // Asignar el evento creado a los botones
        
        ventanaGerente.getTbClientesVG().getSelectionModel().addListSelectionListener(eventoGerente);
        
        ventanaGerente.getBtnRegistrarClienteVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEditarClienteVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEliminarClienteVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnRefreshClientesVG().addActionListener(eventoGerente);
        
        ventanaGerente.getTbProductosVG().getSelectionModel().addListSelectionListener(eventoGerente);
        
        ventanaGerente.getBtnRegistrarProductoVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnActualizarProductoVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEliminarProductoVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnRefreshProductosVG().addActionListener(eventoGerente);
        
        ventanaGerente.getTbProveedoresVG().getSelectionModel().addListSelectionListener(eventoGerente);
        
        ventanaGerente.getBtnRegistrarProveedorVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnActualizarProveedorVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEliminarProveedorVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnRefreshProveedoresVG().addActionListener(eventoGerente);
        
        ventanaGerente.getTbEmpleadoVG().getSelectionModel().addListSelectionListener(eventoGerente);
        
        ventanaGerente.getBtnRegistrarEmpleadoVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEditarEmpleadoVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEliminarEmpleadoVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnRefreshEmpleadosVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnPonerTurnoEmpleadoVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnQuitarTurnoEmpleadoVG().addActionListener(eventoGerente);
        
        ventanaGerente.getTbPedidosVG().getSelectionModel().addListSelectionListener(eventoGerente);
        
        ventanaGerente.getBtnRegistrarPedidosVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEditarPedidosVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnEliminarPedidosVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnRefreshPedidosVG().addActionListener(eventoGerente);
        ventanaGerente.getBtnDetalleGerente().addActionListener(eventoGerente);
        
        ventanaGerente.getBtnRefreshInformesVG().addActionListener(eventoGerente);
		
	}
		
}