package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class EventoCliente implements ActionListener{
	
	private Coordinador miCoordinador;

	private JButton btnVolver;
    private JButton btnAyuda;
    private JButton btnReiniciar;
    private JButton btnComentario;
    private JButton btnAgregar;
    private JButton btnRealizarPedido;
    private JRadioButton jRadioEfectivo;
    private JRadioButton jRadioTarjeta;
    
	public EventoCliente(Coordinador miCoordinador, JButton btnVolver, JButton btnAyuda, 
			JButton btnReiniciar, JButton btnComentario, JButton btnAgregar, JButton btnRealizarPedido, 
			JRadioButton jRadioEfectivo, JRadioButton jRadioTarjeta) {
		
		this.miCoordinador = miCoordinador;
        this.btnVolver = btnVolver;
        this.btnAyuda = btnAyuda;
        this.btnReiniciar = btnReiniciar;
        this.btnComentario = btnComentario;
        this.btnAgregar = btnAgregar;
        this.btnRealizarPedido = btnRealizarPedido;
        this.jRadioEfectivo = jRadioEfectivo;
        this.jRadioTarjeta = jRadioTarjeta;
                
    }
	
	//@Override
	public void actionPerformed(ActionEvent e) {		

		if (e.getSource() == btnVolver) {
		
			miCoordinador.mostrarVentanaLista();
			miCoordinador.volverVentanaCliente();
			
		} else if (e.getSource() == btnAyuda) {
			
			miCoordinador.ayuda();
			
		} else if (e.getSource() == btnReiniciar) {
				
			miCoordinador.reiniciarTicket();
				
		} else if (e.getSource() == btnComentario) {
			
			miCoordinador.comentarTicket();	
			
		} else if (e.getSource() == btnAgregar) {
			
			miCoordinador.agregarPrecioTotal();		
			 		
		} else if (e.getSource() == btnRealizarPedido) {
		
			miCoordinador.elegirModoRegistroPedido();	
			
		} else if (e.getSource() == jRadioEfectivo) {
         
			jRadioTarjeta.setSelected(false);
	       
        } else if (e.getSource() == jRadioTarjeta) {
        	jRadioEfectivo.setSelected(false);
		}
	}
	
	public Coordinador getCoordinador() {
		return miCoordinador;
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}	
	
}
