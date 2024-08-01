package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EventoLista implements ActionListener{
	
	private Coordinador miCoordinador;
	private JButton btnNuevoPedidoVL;		
	private JButton btnVolver;    
    
	public EventoLista(Coordinador miCoordinador, JButton btnNuevoPedidoVL) {
		
		this.miCoordinador = miCoordinador;
        this.btnNuevoPedidoVL = btnNuevoPedidoVL;
		
	}        
    
	//@Override
	public void actionPerformed(ActionEvent e) {		

		if (e.getSource() == btnVolver) {
			
			miCoordinador.mostrarVentanaLista();
			miCoordinador.volverVentanaCliente();
			
		} else if (e.getSource() == btnNuevoPedidoVL) {
			
			miCoordinador.mostrarVentanaCliente();
			
		}
	}
	
	public Coordinador getCoordinador() {
		return miCoordinador;
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}	
	
}
