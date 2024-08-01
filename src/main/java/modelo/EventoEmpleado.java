package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EventoEmpleado implements ActionListener, ListSelectionListener {
	
	private Coordinador miCoordinador;
	
	private JButton btnPedidoEntregado;
	private JButton btnEliminarPedidosConfirmados;
	private JButton btnPedidoListo;
	private JButton btnConfirmarPedido;
	private JButton btnEliminarPedidoSinConfirmar;
	@SuppressWarnings("rawtypes")
	private JList lstSinConfirmar;
	@SuppressWarnings("rawtypes")
	private JList lstPedidosConfirmados;
	@SuppressWarnings("rawtypes")
	private JList lstPedidosListos;
	
	public EventoEmpleado(Coordinador miCoordinador, JButton btnPedidoEntregado, JButton btnEliminarPedidosConfirmados, JButton btnPedidoListo, 
			JButton btnEliminarPedidoSinConfirmar, JButton btnConfirmarPedido, @SuppressWarnings("rawtypes") JList lstSinConfirmar, @SuppressWarnings("rawtypes") JList lstPedidosConfirmados, @SuppressWarnings("rawtypes") JList lstPedidosListos) {
		
		this.miCoordinador = miCoordinador;		
		this.btnPedidoEntregado = btnPedidoEntregado;
		this.btnEliminarPedidosConfirmados = btnEliminarPedidosConfirmados;
		this.btnPedidoListo = btnPedidoListo;
		this.btnEliminarPedidoSinConfirmar = btnEliminarPedidoSinConfirmar;
		this.btnConfirmarPedido = btnConfirmarPedido;
		this.lstSinConfirmar = lstSinConfirmar;
		this.lstPedidosConfirmados = lstPedidosConfirmados;
		this.lstPedidosListos = lstPedidosListos;
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btnConfirmarPedido) {
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea confirmar el pedido del cliente?", "Confirmar Pedido", JOptionPane.YES_NO_OPTION);
	            
	        // Proceder con el registro si el usuario confirma
			if (respuesta == JOptionPane.YES_OPTION) {
			miCoordinador.confirmarPedidoEmpleadoSC();
			}
			
		} else if (e.getSource() == btnEliminarPedidoSinConfirmar) {
			
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el pedido sin confirmar del cliente?", "Eliminar Pedido Sin Confirmar", JOptionPane.YES_NO_OPTION);
		            
			// Eliminar si el usuario confirma
			if (respuesta == JOptionPane.YES_OPTION) {	
				miCoordinador.eliminarPedidoEmpleadoSC();	
			}
			
		}else if (e.getSource() == btnPedidoListo) {
			
			int respuesta = JOptionPane.showConfirmDialog(null, "¿ESta seguro que ya esta todo el pedido listo?", "Pedido Listo", JOptionPane.YES_NO_OPTION);
            
	        // Proceder con el pedido si el usuario confirma
			if (respuesta == JOptionPane.YES_OPTION) {	
			miCoordinador.pedidoListo();	
			}

		}else if (e.getSource() == btnEliminarPedidosConfirmados) {
			
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el pedido confirmado del cliente?", "Eliminar Pedido Confirmado", JOptionPane.YES_NO_OPTION);
            
	        // Eliminar si el usuario confirma
			if (respuesta == JOptionPane.YES_OPTION) {	
			 miCoordinador.eliminarPedidoEmpleadoConfirmado();	
			}
			
		}else if (e.getSource() == btnPedidoEntregado) {
			
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea entregar el pedido al cliente?", "Entregar Pedido Listo", JOptionPane.YES_NO_OPTION);
            
	        // Proceder con el registro si el usuario confirma
			if (respuesta == JOptionPane.YES_OPTION) {	
			 miCoordinador.pedidosEntregados();	
			 
			}
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting()) { // Verificar si el evento de selección ha finalizado
			 Object seleccionadoSinConfirmar = lstSinConfirmar.getSelectedValue();
			 Object seleccionadoConfirmado = lstPedidosConfirmados.getSelectedValue();
			 Object seleccionadoListos = lstPedidosListos.getSelectedValue();
		        
		        if (seleccionadoSinConfirmar != null && seleccionadoSinConfirmar instanceof Object) {
		        	
		            String numeroOrden = (String) seleccionadoSinConfirmar;
		            Object datosPedido = miCoordinador.obtenerDatosPedidoPorNumeroOrden(numeroOrden);
		            
		            if (datosPedido != null) {
		                miCoordinador.mostrarDatosItemLstSinConfirmar(datosPedido);
		                
		            }
		        }
		        
		        if (seleccionadoConfirmado != null && seleccionadoConfirmado instanceof String) {
		            String numeroOrden = (String) seleccionadoConfirmado;
		            Object datosPedido = miCoordinador.obtenerDatosPedidoPorNumeroOrden(numeroOrden);
		            
		            if (datosPedido != null) {
		                miCoordinador.mostrarDetallesPedidoConfirmado(datosPedido);
		            }
		        }
		        
		        if (seleccionadoListos != null && seleccionadoListos instanceof String) {
		            String numeroOrden = (String) seleccionadoListos;
		            Object datosPedido = miCoordinador.obtenerDatosPedidoPorNumeroOrden(numeroOrden);
		            
		            if (datosPedido != null) {
		            	
		              miCoordinador.seleccionarDetallesPedidosListos(datosPedido);
		            }
		        }		
	    }
    }

	public Coordinador getCoordinador() {
		return miCoordinador;
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
