package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EventoGerente implements ActionListener, ListSelectionListener{

	private Coordinador miCoordinador;
	
	private JButton btnRegistrarClienteVG;
	private JButton btnEditarClienteVG;
	private JButton btnEliminarClienteVG;
	private JButton btnRefreshClientesVG;
	
	private JButton btnRegistrarProductoVG;
	private JButton btnEditarProductoVG;
	private JButton btnEliminarProductoVG;
	private JButton btnRefreshProductosVG;
	
	private JButton btnRegistrarProveedorVG;
	private JButton btnEditarProveedorVG;
	private JButton btnEliminarProveedorVG;
	private JButton btnRefresProveedorVG;
	
	private JButton btnRegistrarEmpleadoVG;
	private JButton btnEditarEmpleadoVG;
	private JButton btnEliminarEmpleadoVG;
	private JButton btnRefreshEmpleadosVG;
	private JButton BtnPonerTurnoEmpleadoVG;
	private JButton BtnQuitarTurnoEmpleadoVG;
	
	private JButton btnRegistrarPedidoVG;
	private JButton btnEditarPedidoVG;
	private JButton btnEliminarPedidoVG;
	private JButton btnRefreshPedidoVG;
	private JButton btnDetalleGerente;
	
	private JButton btnRefreshInformesVG;
	
	private JTable tbClientesVG;
	private JTable tbEmpleadosVG;
	private JTable tbProductosVG;
	private JTable tbProveedorVG;
	private JTable tbPedidoVG;
		
	public EventoGerente (Coordinador miCoordinador, JTable tbClientesVG, JButton btnRegistrarClienteVG, JButton btnEditarClienteVG,
			JButton btnEliminarClienteVG, JButton btnRefreshClientesVG, JTable tbProductosVG, JButton btnRegistrarProductoVG, 
			JButton btnEditarProductoVG, JButton btnEliminarProductoVG, JButton btnRefreshProductosVG, JTable tbProveedorVG,  
			JButton btnRegistrarProveedorVG, JButton btnEditarProveedorVG,JButton btnEliminarProveedorVG, JButton btnRefresProveedorVG,
			JTable tbEmpleadosVG, JButton btnRegistrarEmpleadoVG, JButton btnEditarEmpleadoVG, JButton btnEliminarEmpleadoVG,
			JButton btnRefresEmpleadoVG, JButton BtnPonerTurnoEmpleadoVG, JButton BtnQuitarTurnoEmpleadoVG, JTable tbPedidoVG,
			JButton btnRegistrarPedidoVG, JButton btnEditarPedidoVG, JButton btnEliminarPedidoVG, JButton btnRefreshPedidoVG, 
			JButton btnDetalleGerente, JButton btnRefreshInformesVG) {
		
		this.miCoordinador = miCoordinador;
		
		this.tbClientesVG = tbClientesVG;
		this.btnRegistrarClienteVG = btnRegistrarClienteVG;
		this.btnEditarClienteVG = btnEditarClienteVG;
		this.btnEliminarClienteVG = btnEliminarClienteVG;
		this.btnRefreshClientesVG = btnRefreshClientesVG;
		
		this.tbProductosVG = tbProductosVG;
		this.btnRegistrarProductoVG = btnRegistrarProductoVG;
		this.btnEditarProductoVG = btnEditarProductoVG;
		this.btnEliminarProductoVG = btnEliminarProductoVG;
		this.btnRefreshProductosVG = btnRefreshProductosVG;
		
		this.tbProveedorVG = tbProveedorVG;
		this.btnRegistrarProveedorVG = btnRegistrarProveedorVG;
		this.btnEditarProveedorVG = btnEditarProveedorVG;
		this.btnEliminarProveedorVG = btnEliminarProveedorVG;
		this.btnRefresProveedorVG = btnRefresProveedorVG;
		
		this.tbEmpleadosVG = tbEmpleadosVG;
		this.btnRegistrarEmpleadoVG = btnRegistrarEmpleadoVG;
		this.btnEditarEmpleadoVG = btnEditarEmpleadoVG;
		this.btnEliminarEmpleadoVG = btnEliminarEmpleadoVG;
		this.btnRefreshEmpleadosVG = btnRefresEmpleadoVG;
		this.BtnPonerTurnoEmpleadoVG = BtnPonerTurnoEmpleadoVG;
		this.BtnQuitarTurnoEmpleadoVG = BtnQuitarTurnoEmpleadoVG;
		
		this.tbPedidoVG = tbPedidoVG;
		this.btnRegistrarPedidoVG = btnRegistrarPedidoVG;
		this.btnEditarPedidoVG = btnEditarPedidoVG;
		this.btnEliminarPedidoVG = btnEliminarPedidoVG;
		this.btnRefreshPedidoVG = btnRefreshPedidoVG;
		this.btnDetalleGerente = btnDetalleGerente;
		
		this.btnRefreshInformesVG = btnRefreshInformesVG;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		/*
		 * Pestaña Informes
		 */
		
		if (e.getSource() == btnRefreshInformesVG) {
			miCoordinador.numProductosConsumidos();
			miCoordinador.productoTop();
			miCoordinador.totalStockProductos();
			
			miCoordinador.totalCaja();
			miCoordinador.ticketMedio();
			miCoordinador.highTicket();
			
			miCoordinador.totalPedidos();
			miCoordinador.contadorPedidosVG();
						
		} 
		
		/*
		 * Pestaña Clientes
		 */
		if (e.getSource() == btnRegistrarClienteVG) {
			miCoordinador.registrarCliente();
						
		} else if (e.getSource() == btnRefreshClientesVG) {
			
			miCoordinador.vaciarDatosTxtClienteVG();
			miCoordinador.leerDatosTablaClientes();
			
		} else if (e.getSource() == btnEditarClienteVG) {
			
			miCoordinador.btnActualizarCliente();
			
		}else if (e.getSource() == btnEliminarClienteVG) {
			
			miCoordinador.btnEliminarCliente();
						
		/*
		 * PestañaProductos	
		 */
			
		}else if (e.getSource() == btnRefreshProductosVG) {
						
			miCoordinador.vaciarDatosProductosVG();
			miCoordinador.leerDatosTablaProductos();
			
		}else if (e.getSource() == btnRegistrarProductoVG) {
			
			miCoordinador.registrarProducto();
			
		} else if (e.getSource() == btnEditarProductoVG) {
			
			miCoordinador.btnActualizarProducto();
			
		}else if (e.getSource() == btnEliminarProductoVG) {
			
			miCoordinador.btnEliminarProducto();
		
		/*
		 * Pestaña Proveedores	
		 */
			
		}else if (e.getSource() == btnRegistrarProveedorVG) {
			
			miCoordinador.registrarProveedor();
			
		} else if (e.getSource() == btnEditarProveedorVG) {
			
			miCoordinador.btnActualizarProveedor();
			
		}else if (e.getSource() == btnEliminarProveedorVG) {
			
			miCoordinador.btnEliminarProveedor();
			
		}else if (e.getSource() == btnRefresProveedorVG) {
			
			miCoordinador.vaciarDatosTxtProveedoresVG();
			miCoordinador.leerDatosTablaProveedores();	
		}
		
		/*
		 * Pestaña Empleados
		 */
		if (e.getSource() == btnRegistrarEmpleadoVG) {
			miCoordinador.registrarEmpleado();
							
		} else if (e.getSource() == btnRefreshEmpleadosVG) {
				
			miCoordinador.vaciarDatosTxtEmpleadoVG();
			miCoordinador.leerDatosTablaEmpleados();
				
		} else if (e.getSource() == btnEditarEmpleadoVG) {
				
			miCoordinador.btnActualizarEmpleado();
				
		}else if (e.getSource() == btnEliminarEmpleadoVG) {
				
			miCoordinador.btnEliminarEmpleado();	
		
		}else if (e.getSource() == BtnPonerTurnoEmpleadoVG) {
			
		miCoordinador.ponerTurno();
		
		}else if (e.getSource() == BtnQuitarTurnoEmpleadoVG) {
			
		miCoordinador.quitarTurno();
		
		/*
		 * Pestaña Pedidos
		 */
			
		}else if (e.getSource() == btnRefreshPedidoVG) {
						
			miCoordinador.vaciarDatosTxtPedidosVG();
			miCoordinador.leerDatosTablaPedidos();
			
		}else if (e.getSource() == btnRegistrarPedidoVG) {
			
			miCoordinador.registrarPedido();
			
		} else if (e.getSource() == btnEditarPedidoVG) {
			
			miCoordinador.btnActualizarPedido();
			
		}else if (e.getSource() == btnEliminarPedidoVG) {
			
			miCoordinador.btnEliminarPedido();
		
		
		}else if (e.getSource() == btnDetalleGerente) {
			
			miCoordinador.btndDetallePedido();		
		
		}
	}	
	
	@Override
    public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting()) {
	        // Obtener el índice de la fila seleccionada
	        int selectedClienteRow = tbClientesVG.getSelectedRow();
	        // Verificar si hay una fila seleccionada
	        if (selectedClienteRow != -1) {
	            // Aquí se llama al método para extraer los datos de la tabla
	            miCoordinador.extraerDatosTablaClientes();
	        }
	        	        
	        // Obtener el índice de la fila seleccionada para la tabla de productos
	        int selectedProductoRow = tbProductosVG.getSelectedRow();
	        // Verificar si hay una fila seleccionada en la tabla de productos
	        if (selectedProductoRow != -1) {
	            // Aquí se llama al método para extraer los datos de la tabla de productos
	            miCoordinador.extraerDatosTablaProductos();
	        }
	        
	        // Obtener el índice de la fila seleccionada para la tabla de proveedores
	        int selectedProveedorRow = tbProveedorVG.getSelectedRow();
	        // Verificar si hay una fila seleccionada en la tabla de proveedores
	        if (selectedProveedorRow != -1) {
	            // Aquí se llama al método para extraer los datos de la tabla de proveedores
	            miCoordinador.extraerDatosTablaProveedores();
	        }
	        
	        // Obtener el índice de la fila seleccionada para la tabla de empleados
	        int selectedEmpleadoRow = tbEmpleadosVG.getSelectedRow();
	        // Verificar si hay una fila seleccionada en la tabla de empleados
	        if (selectedEmpleadoRow != -1) {
	            // Aquí se llama al método para extraer los datos de la tabla de empleados
	            miCoordinador.extraerDatosTablaEmpleados();
	        }
	        
	        // Obtener el índice de la fila seleccionada para la tabla de pedidos
	        int selectedPedidoRow = tbPedidoVG.getSelectedRow();
	        // Verificar si hay una fila seleccionada en la tabla de pedidos
	        if (selectedPedidoRow != -1) {
	            // Aquí se llama al método para extraer los datos de la tabla de pedidos
	            miCoordinador.extraerDatosTablaPedidos();
	        }
	    }
        
    }
}
