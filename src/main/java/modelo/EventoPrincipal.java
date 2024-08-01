package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class EventoPrincipal implements ActionListener{

	private Coordinador miCoordinador;

	private JButton btnVentanaCliente;
	private JButton btnVentanaEmpleado;
	private JButton btnVentanaGerente;
	private JButton btnSalir;

	 // Constructor que recibe una instancia de Coordinador y referencia de a los objetos de tipo boton
	public EventoPrincipal(Coordinador miCoordinador, JButton btnVentanaCliente, JButton btnVentanaEmpleado, JButton btnVentanaGerente, 
			JButton btnSalir) {
		
		this.miCoordinador = miCoordinador;
		this.btnVentanaCliente = btnVentanaCliente;
		this.btnVentanaEmpleado = btnVentanaEmpleado;
		this.btnVentanaGerente = btnVentanaGerente;
		this.btnSalir = btnSalir;
		
	}

	// Método que se ejecutará cuando se produzca el evento
	public void actionPerformed(ActionEvent e) {
			
		if (e.getSource() == btnVentanaCliente) {
			
			miCoordinador.mostrarVentanaLista();
			
		} else if (e.getSource() == btnVentanaEmpleado) {
			
			miCoordinador.mostrarVentanaEmpleado();
			
		} else if (e.getSource() == btnVentanaGerente) {
			
			miCoordinador.mostrarVentanaGerente();
			
			miCoordinador.numProductosConsumidos();
			miCoordinador.productoTop();
			miCoordinador.totalStockProductos();
			
			miCoordinador.totalCaja();
			miCoordinador.ticketMedio();
			miCoordinador.highTicket();
			
			miCoordinador.totalPedidos();
			
			
		} else if (e.getSource() == btnSalir) {
			
			miCoordinador.salir();
		}
			 
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}