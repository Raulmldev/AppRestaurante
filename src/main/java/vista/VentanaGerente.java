package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Coordinador;

public class VentanaGerente extends javax.swing.JFrame {

	private Coordinador miCoordinador;
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnActualizarProductoVG;
	private JButton btnActualizarProveedorVG;
	private JButton btnRegistrarProductoVG;
	private JButton btnRegistrarProveedorVG;
	private JButton btnDetalleGerente;
	private JButton btnEditarClienteVG;
	private JButton btnEditarEmpleadoVG;
	private JButton btnEliminarClienteVG;
	private JButton btnEliminarEmpleadoVG;
	private JButton btnEliminarProductoVG;
	private JButton btnEliminarProveedorVG;
	private JButton btnQuitarTurnoEmpleadoVG;
	private JButton btnPonerTurnoEmpleadoVG;
    private JButton btnRegistrarClienteVG;
    private JButton btnRegistrarEmpleadoVG;
    private JButton btnRefreshInformesVG;
    private JButton btnRefreshPedidosVG;
    private JButton btnRegistrarPedidosVG;
    private JButton btnEliminarPedidosVG;
    private JButton btnEditarPedidosVG;
    private JButton btnRefreshEmpleadosVG;
    private JButton btnRefreshClientesVG;
    private JButton btnRefreshProveedoresVG;
    
    private JLabel lblCajaVG;
    private JLabel lblCantidadProductoVG;
    private JLabel lblCantidadProveedorVG;
    private JLabel lblDireccionEmpleadoVG;
    private JLabel lblDireccionClienteVG;
    private JLabel lblDNIClienteVG;
    private JLabel lblDNIEmpleadoVG;
    private JLabel lblEmailClienteVG;
    private JLabel lblEmailEmpleadoVG;
    private JLabel lblEmailProveedorVG;
    private JLabel lblEmpleadosTurnoVG;
    private JLabel lblProveedorIdProveedoresVG;
    private JLabel lblProductoIdProductosVG;
    private JLabel lblNombreClienteVG;
    private JLabel lblNombreEmpleadoVG;
    private JLabel lblNombreProductoVG;
    private JLabel lblNombreProductoTopVG;
    private JLabel lblNombreProveedorVG;
    private JLabel lblNumCajaVG;
    private JLabel lblNumPedidosConfirmadosVG;
    private JLabel lblNumPedidosEntregadosVG;
    private JLabel lblNumPedidosSinConfirmarVG;   
    private JLabel lblNumPedidosTotalVG;
    private JLabel lblNumProductosConsumidosVG;  
    private JLabel lblNumTicketMedioVG;
    private JLabel lblNumTicketTopVG;
    private JLabel lblNumTotalPedidosVG;
    private JLabel lblNumTotalStockVG;
    private JLabel lblPedidosConfirmadosVG;
    private JLabel lblPedidosEntregadosVG;
    private JLabel lblPedidosSinConfirmarVG;
    private JLabel lblPrecioProveedorVG;
    private JLabel lblPrecioVentaProductoVG;
    private JLabel lblProductosConsumidosVG;
    private JLabel lblProductoIdProveedoresVG;
    private JLabel lblProductoTopVG;
    private JLabel lblPuntosClienteVG;
    private JLabel lblRolEmpleadoVG;
    private JLabel lblSalarioEmpleadoVG;
    private JLabel lblTelefonoClienteVG;
    private JLabel lblTelefonoEmpleadoVG;
    private JLabel lblTelefonoProveedorVG;
    private JLabel lblTicketMedioVG;
    private JLabel lblTicketTopVG;
    private JLabel lblTotalPedidosVG;
    private JLabel lblTotalStockVG;
      
    private JPanel jPanelCajaVG;
    private JPanel jPanelClientesVG;
    private JPanel jPanelDatosClientesVG;
    private JPanel jPanelDatosEmpleadosVG;
    private JPanel jPanelDatosProductos;
    private JPanel jPanelDatosProveedoresVG;
    private JPanel jPanelDetallePedidosVG;
    private JPanel jPanelEmpleadosVG;
    private JPanel jPanelInformesVG;
    private JPanel jPanelPedidosCLienteVG;
    private JPanel jPanelPestañaEmpleados;
    private JPanel jPanelProductosVG;
    private JPanel jPanelTablaClientesVG;
    private JPanel jPanelTablaEmpleados;
    private JPanel jPanelTotalPedidosVG;
    private JPanel jPanelTablaProductos;
    private JPanel jPanelTablaProveedoresVG;
    
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    
    private JSeparator jSeparator1;
    
    private JTabbedPane jTabbedGerente;
    
    private JTable tbClientesVG;
    
    private JTable tbEmpleadoVG;
    private JTable tbProductosVG;
    private JTable tbProveedoresVG;
    private JTable tbPedidosVG;

    private JTextArea txtAreaDetallePedidoGerente;
    private JTextArea txtAreaEmpleadosVG;
    
    private JTextField txtCantidadProductoVG;
    private JTextField txtCantidadProveedorVG;
    private JTextField txtDireccionClienteVG;
    private JTextField txtDireccionEmpleadoVG;
    private JTextField txtDNIEmpleadoVG;
    private JTextField txtDNIClienteVG;
    private JTextField txtEmailClienteVG;
    private JTextField txtEmailEmpleadoVG;
    private JTextField txtEmailProveedorVG;
	private JTextField txtProveedorIdProveedoresVG;
    private JTextField txtProductoIdProductosVG;
    private JTextField txtNombreClienteVG;
    private JTextField txtNombreEmpleadoVG;
    private JTextField txtNombreProductoVG;
    private JTextField txtNombreProveedorVG;
    private JTextField txtPrecioProveedorVG;
    private JTextField txtPrecioVentaProductoVG;
    private JTextField txtProductoIdProveedoresVG;
    private JTextField txtPuntosClienteVG;
    private JTextField txtRolEmpleadoVG;
    private JTextField txtSalarioEmpleadoVG;
    private JTextField txtTelefonoClienteVG;
    private JTextField txtTelefonoEmpleadoVG;
    private JTextField txtTelefonoProveedorVG;
    private JButton btnRefreshProductosVG;
    private JTextField txtEmpleadoIdEmpleadosVG;
    private JTextField txtClienteIdClienteVG;
    private JTextField txtPedidoIdPedidosVG;
    private JTextField txtClienteIdPedidosVG;
    private JLabel lblProductoIdPedidosVG;
    private JTextField txtProductoIdPedidosVG;
    private JLabel lblMetodoPagoClientesVG;
    private JTextField txtMetodoPagoClientesVG;
    private JLabel lblNombrePoductoClientesVG;
    private JTextField txtNombreProductoPedidosVG;
    private JLabel lblCantidadProductoClientesVG;
    private JTextField txtCantidadProductoPedidosVG;
    private JLabel lblTotalTicketPedidoClientesVG;
    private JTextField txtTotalTicketPedidoPedidosVG;

	/**
     * Creates new form VentanaGerente
     */
    public VentanaGerente() {
        initComponents();
    }

                          
    private void initComponents() {
    	
    	setTitle("GERENTE");

    	btnActualizarProductoVG = new JButton();
        btnActualizarProductoVG.setFont(new Font("Arial", Font.PLAIN, 11));
        btnActualizarProductoVG.setText("EDITAR");
        
        btnActualizarProveedorVG = new JButton();
        btnActualizarProveedorVG.setFont(new Font("Arial", Font.PLAIN, 11)); 
        btnActualizarProveedorVG.setText("EDITAR");
        
    	btnRegistrarProductoVG = new JButton();
    	btnRegistrarProductoVG.setText("REGISTRAR");
    	 
    	btnRegistrarProveedorVG = new JButton();
    	btnRegistrarProveedorVG.setText("REGISTRAR");
          
    	btnEditarClienteVG = new JButton();
    	btnEditarClienteVG.setText("EDITAR");
    	 
    	btnEditarEmpleadoVG = new JButton();
    	btnEditarEmpleadoVG.setText("EDITAR");
    	
    	btnEliminarClienteVG = new JButton();
    	btnEliminarClienteVG.setText("ELIMINAR");
    	 
        btnEliminarEmpleadoVG = new JButton();
        btnEliminarEmpleadoVG.setText("ELIMINAR");
        
        btnEliminarProductoVG = new JButton();
        btnEliminarProductoVG.setText("ELIMINAR");
        
        btnEliminarProveedorVG = new JButton();
        btnEliminarProveedorVG.setText("ELIMINAR");
        
        btnQuitarTurnoEmpleadoVG = new JButton("QUITAR TURNO");
        btnQuitarTurnoEmpleadoVG.setFont(new Font("Arial", Font.BOLD, 18));
        
        btnPonerTurnoEmpleadoVG = new JButton("PONER TURNO");
        btnPonerTurnoEmpleadoVG.setFont(new Font("Arial", Font.BOLD, 18));
        
        btnRegistrarClienteVG = new JButton();
        btnRegistrarClienteVG.setText("REGISTRAR");
        
        btnRegistrarEmpleadoVG = new JButton();
        btnRegistrarEmpleadoVG.setText("REGISTRAR");
        
        btnRefreshInformesVG = new JButton();
        btnRefreshInformesVG.setText("REFRESH");
        
        btnRefreshProveedoresVG= new JButton();
        btnRefreshProveedoresVG.setText("REFRESH");
        
        lblCajaVG = new JLabel();
        lblCajaVG.setFont(new Font("Arial", 1, 18)); 
        lblCajaVG.setText("TOTAL CAJA :");
        
        lblCantidadProductoVG = new JLabel();
        lblCantidadProductoVG.setText("CANTIDAD:");
        
        lblCantidadProveedorVG = new JLabel();
        lblCantidadProveedorVG.setText("CANTIDAD:");
        
        lblDireccionClienteVG = new JLabel();
        lblDireccionClienteVG.setText("DIRECCIÓN:");
        
        lblDireccionEmpleadoVG = new JLabel();
        lblDireccionEmpleadoVG.setText("DIRECCIÓN:");
        
        lblDNIClienteVG = new JLabel();
        lblDNIClienteVG.setText("DNI:");
        
        lblDNIEmpleadoVG = new JLabel();
        lblDNIEmpleadoVG.setText("DNI:");
        
        lblEmailClienteVG = new JLabel();
        lblEmailClienteVG.setText("EMAIL:");
        
        lblEmailEmpleadoVG = new JLabel();
        lblEmailEmpleadoVG.setText("EMAIL:");
        
        lblEmailProveedorVG = new JLabel("EMAIL:");
        
        lblEmpleadosTurnoVG = new JLabel();
        lblEmpleadosTurnoVG.setFont(new Font("Arial", 1, 12)); 
        lblEmpleadosTurnoVG.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmpleadosTurnoVG.setText("EMPLEADOS TURNO");
        
        lblProveedorIdProveedoresVG = new JLabel("PROVEEDOR ID:");
        
        lblProductoIdProductosVG = new JLabel();
        lblProductoIdProductosVG.setText("PRODUCTO ID:");
        
        lblNombreClienteVG = new JLabel();
        lblNombreClienteVG.setText("NOMBRE:");
        
        lblNombreEmpleadoVG = new JLabel();
        lblNombreEmpleadoVG.setText("NOMBRE:");
        
        lblNombreProductoVG = new JLabel();
        lblNombreProductoVG.setText("NOMBRE:");
        
        lblNombreProductoTopVG = new JLabel("Pizza");
        lblNombreProductoTopVG.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblNombreProveedorVG = new JLabel();
        lblNombreProveedorVG.setText("NOMBRE PROVEEDOR:");
        
        lblNumCajaVG = new JLabel();
        lblNumCajaVG.setFont(new Font("Arial", 1, 18)); 
        lblNumCajaVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumCajaVG.setText("0");
        
        lblNumPedidosConfirmadosVG = new JLabel();
        lblNumPedidosConfirmadosVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumPedidosConfirmadosVG.setText("0");
        
        lblNumPedidosEntregadosVG = new JLabel(); 
        lblNumPedidosEntregadosVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumPedidosEntregadosVG.setText("0");
        
        lblNumPedidosSinConfirmarVG = new JLabel();
        lblNumPedidosSinConfirmarVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumPedidosSinConfirmarVG.setText("0");
        
        lblNumPedidosTotalVG = new JLabel("0");
        lblNumPedidosTotalVG.setFont(new Font("Arial", Font.BOLD, 14));
        lblNumPedidosTotalVG.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblNumProductosConsumidosVG = new JLabel();
        lblNumProductosConsumidosVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumProductosConsumidosVG.setText("0");
        
        lblNumTicketMedioVG = new JLabel();  
        lblNumTicketMedioVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumTicketMedioVG.setText("0");
        
        lblNumTicketTopVG = new JLabel("0");
        lblNumTicketTopVG.setHorizontalAlignment(SwingConstants.RIGHT);
        
        lblNumTotalPedidosVG = new JLabel();   
        lblNumTotalPedidosVG.setFont(new Font("Arial", 1, 18)); 
        lblNumTotalPedidosVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumTotalPedidosVG.setText("0");
        
        lblNumTotalStockVG = new JLabel();
        lblNumTotalStockVG.setFont(new Font("Arial", Font.BOLD, 18));
        lblNumTotalStockVG.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumTotalStockVG.setText("0");
                
        lblPedidosSinConfirmarVG = new JLabel();
        lblPedidosSinConfirmarVG.setFont(new Font("Arial", 1, 12)); 
        lblPedidosSinConfirmarVG.setText("Pedidos sin confirmar:");

        lblPedidosConfirmadosVG = new JLabel();
        lblPedidosConfirmadosVG.setFont(new Font("Arial", 1, 12)); 
        lblPedidosConfirmadosVG.setText("Pedidos confirmados:");
        
        lblPedidosEntregadosVG = new JLabel();
        lblPedidosEntregadosVG.setFont(new Font("Arial", 1, 12)); 
        lblPedidosEntregadosVG.setText("Pedidos listos:");
        
        lblPrecioProveedorVG = new JLabel();
        lblPrecioProveedorVG.setText("PRECIO:");
        
        lblPrecioVentaProductoVG = new JLabel();
        lblPrecioVentaProductoVG.setText("PRECIO VENTA:");
        
        lblProductosConsumidosVG = new JLabel();
        lblProductosConsumidosVG.setFont(new Font("Arial", 1, 12)); 
        lblProductosConsumidosVG.setText("Nº de productos consumidos:");
        
        lblProductoIdProveedoresVG = new JLabel();
        lblProductoIdProveedoresVG.setText("PRODUCTO ID:");
        
        lblProductoTopVG = new JLabel("Producto mas demandado:");
        lblProductoTopVG.setFont(new Font("Arial", Font.BOLD, 11));
        
        lblPuntosClienteVG = new JLabel();
        lblPuntosClienteVG.setText("PUNTOS:");
        
        lblRolEmpleadoVG = new JLabel();
        lblRolEmpleadoVG.setText("ROL:");
        
        lblSalarioEmpleadoVG = new JLabel("SALARIO:");
        
        lblTelefonoClienteVG = new JLabel();
        lblTelefonoClienteVG.setText("TELÉFONO:");
        
        lblTelefonoEmpleadoVG = new JLabel();
        lblTelefonoEmpleadoVG.setText("TELÉFONO:");
        
        lblTelefonoProveedorVG = new JLabel();
        lblTelefonoProveedorVG.setText("TELEFONO:");
        
        lblTicketMedioVG = new JLabel();
        lblTicketMedioVG.setFont(new Font("Arial", 1, 12)); 
        lblTicketMedioVG.setText("Ticket medio:");
        
        lblTicketTopVG = new JLabel("Ticket mas alto:");
        lblTicketTopVG.setFont(new Font("Arial", Font.BOLD, 11));
        
        lblTotalPedidosVG = new JLabel();
        lblTotalPedidosVG.setFont(new Font("Arial", Font.BOLD, 14)); 
        lblTotalPedidosVG.setText("TOTAL PEDIDOS ENTREGADOS:");
        
        lblTotalStockVG = new JLabel(); 
        lblTotalStockVG.setFont(new Font("Arial", Font.BOLD, 18));
        lblTotalStockVG.setText("STOCK TOTAL PRODUCTOS :");
        
        jPanelCajaVG = new JPanel();
        jPanelCajaVG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        
        jPanelClientesVG = new JPanel();
        
        jPanelDatosClientesVG = new JPanel();
        jPanelDatosClientesVG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        
        jPanelDatosEmpleadosVG = new JPanel();
        jPanelDatosEmpleadosVG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        
        jPanelDatosProductos = new JPanel();
        jPanelDatosProductos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        
        jPanelDatosProveedoresVG = new JPanel();
        jPanelDatosProveedoresVG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanelEmpleadosVG = new JPanel();
        jPanelInformesVG = new JPanel();
        jPanelPestañaEmpleados = new JPanel();
        
        jPanelProductosVG = new JPanel();
        jPanelProductosVG.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));      
        
        jPanelTablaClientesVG = new JPanel();
        jPanelTablaEmpleados = new JPanel();
        jPanelTablaProductos = new JPanel();
        jPanelTablaProveedoresVG = new JPanel();
        
        jPanelTotalPedidosVG = new JPanel();
        jPanelTotalPedidosVG.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2 = new JScrollPane();
        jScrollPane3 = new JScrollPane();
        jScrollPane4 = new JScrollPane();
        
        jScrollPane6 = new JScrollPane();
        
        jSeparator1 = new JSeparator();
        
        jTabbedGerente = new JTabbedPane();
        jTabbedGerente.addTab("INFORMES", jPanelInformesVG);
        jTabbedGerente.addTab("CLIENTES", jPanelClientesVG);
        jTabbedGerente.addTab("EMPLEADOS", jPanelPestañaEmpleados);
        jTabbedGerente.addTab("PRODUCTOS", jPanelTablaProductos);
        
        tbClientesVG = new JTable();
        tbClientesVG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbClientesVG.setShowHorizontalLines(true);
    
        tbEmpleadoVG = new JTable();
        tbEmpleadoVG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
        tbProductosVG = new JTable();
        tbProductosVG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
        tbProveedoresVG = new JTable();
        tbProveedoresVG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        txtCantidadProductoVG = new JTextField();
        txtCantidadProductoVG.setColumns(10);
        
        txtCantidadProveedorVG = new JTextField();
        txtCantidadProveedorVG.setColumns(10);
        
        txtDireccionClienteVG = new JTextField();
                
        txtDireccionEmpleadoVG = new JTextField();
        
        txtDNIClienteVG = new JTextField();
        txtDNIEmpleadoVG = new JTextField();
        
        txtEmailClienteVG = new JTextField();
        
        txtEmailEmpleadoVG = new JTextField();
        
        txtEmailProveedorVG = new JTextField();
        txtEmailProveedorVG.setColumns(10);
        
        txtProveedorIdProveedoresVG = new JTextField();
        txtProveedorIdProveedoresVG.setColumns(10);
        
        txtProductoIdProductosVG = new JTextField();
        txtProductoIdProductosVG.setColumns(10);
        
        txtNombreClienteVG = new JTextField();
       
        txtNombreEmpleadoVG = new JTextField();
        
        txtNombreProductoVG = new JTextField();
        txtNombreProductoVG.setColumns(10);
        
        txtNombreProveedorVG = new JTextField();
        
       
        txtTelefonoClienteVG = new JTextField();
       
        txtTelefonoEmpleadoVG = new JTextField();
      
        txtPrecioProveedorVG = new JTextField();
        txtPrecioProveedorVG.setColumns(10);
        
        txtPrecioVentaProductoVG = new JTextField();
        txtPrecioVentaProductoVG.setColumns(10);
        
        txtProductoIdProveedoresVG = new JTextField();
       
        txtPuntosClienteVG = new JTextField();
       
        txtRolEmpleadoVG = new JTextField();
        
        txtSalarioEmpleadoVG = new JTextField();
        txtSalarioEmpleadoVG.setColumns(10);
        
        txtTelefonoProveedorVG = new JTextField();
        
        JLabel lblPedidosTotalVG = new JLabel();
        lblPedidosTotalVG.setText("PEDIDOS PENDIENTES:");
        lblPedidosTotalVG.setFont(new Font("Arial", Font.BOLD, 14));

        GroupLayout gl_jPanelTotalPedidosVG = new GroupLayout(jPanelTotalPedidosVG);
        gl_jPanelTotalPedidosVG.setHorizontalGroup(
        	gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_jPanelTotalPedidosVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, gl_jPanelTotalPedidosVG.createSequentialGroup()
        					.addComponent(lblTotalPedidosVG)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNumTotalPedidosVG, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        				.addGroup(Alignment.TRAILING, gl_jPanelTotalPedidosVG.createSequentialGroup()
        					.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblPedidosSinConfirmarVG)
        						.addComponent(lblPedidosConfirmadosVG))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblNumPedidosConfirmadosVG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblNumPedidosSinConfirmarVG, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
        				.addGroup(Alignment.TRAILING, gl_jPanelTotalPedidosVG.createSequentialGroup()
        					.addComponent(lblPedidosEntregadosVG)
        					.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
        					.addComponent(lblNumPedidosEntregadosVG, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.TRAILING, gl_jPanelTotalPedidosVG.createSequentialGroup()
        					.addComponent(lblPedidosTotalVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNumPedidosTotalVG, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_jPanelTotalPedidosVG.setVerticalGroup(
        	gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelTotalPedidosVG.createSequentialGroup()
        			.addGap(37)
        			.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTotalPedidosVG)
        				.addComponent(lblNumTotalPedidosVG))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPedidosSinConfirmarVG)
        				.addComponent(lblNumPedidosSinConfirmarVG))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPedidosConfirmadosVG)
        				.addComponent(lblNumPedidosConfirmadosVG))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNumPedidosEntregadosVG)
        				.addComponent(lblPedidosEntregadosVG))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelTotalPedidosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPedidosTotalVG)
        				.addComponent(lblNumPedidosTotalVG))
        			.addContainerGap(30, Short.MAX_VALUE))
        );
        jPanelTotalPedidosVG.setLayout(gl_jPanelTotalPedidosVG);
        
        JScrollPane scrollPane = new JScrollPane();

        GroupLayout gl_jPanelEmpleadosVG = new GroupLayout(jPanelEmpleadosVG);
        gl_jPanelEmpleadosVG.setHorizontalGroup(
        	gl_jPanelEmpleadosVG.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_jPanelEmpleadosVG.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_jPanelEmpleadosVG.setVerticalGroup(
        	gl_jPanelEmpleadosVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelEmpleadosVG.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(14, Short.MAX_VALUE))
        );
        
               txtAreaEmpleadosVG = new JTextArea();
               scrollPane.setViewportView(txtAreaEmpleadosVG);
               txtAreaEmpleadosVG.setEditable(false);
               txtAreaEmpleadosVG.setBorder(new LineBorder(new Color(0, 0, 0)));
        jPanelEmpleadosVG.setLayout(gl_jPanelEmpleadosVG);

        GroupLayout gl_jPanelCajaVG = new GroupLayout(jPanelCajaVG);
        gl_jPanelCajaVG.setHorizontalGroup(
        	gl_jPanelCajaVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelCajaVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelCajaVG.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanelCajaVG.createSequentialGroup()
        					.addComponent(lblCajaVG)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNumCajaVG, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        				.addGroup(gl_jPanelCajaVG.createSequentialGroup()
        					.addComponent(lblTicketMedioVG, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNumTicketMedioVG, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        				.addGroup(gl_jPanelCajaVG.createSequentialGroup()
        					.addComponent(lblTicketTopVG)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNumTicketTopVG, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        gl_jPanelCajaVG.setVerticalGroup(
        	gl_jPanelCajaVG.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_jPanelCajaVG.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_jPanelCajaVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCajaVG)
        				.addComponent(lblNumCajaVG))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelCajaVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTicketMedioVG)
        				.addComponent(lblNumTicketMedioVG))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelCajaVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTicketTopVG)
        				.addComponent(lblNumTicketTopVG))
        			.addGap(10))
        );
        jPanelCajaVG.setLayout(gl_jPanelCajaVG);

        GroupLayout gl_jPanelProductosVG = new GroupLayout(jPanelProductosVG);
        gl_jPanelProductosVG.setHorizontalGroup(
        	gl_jPanelProductosVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelProductosVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelProductosVG.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, gl_jPanelProductosVG.createSequentialGroup()
        					.addComponent(lblProductoTopVG, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblNombreProductoTopVG, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
        				.addGroup(gl_jPanelProductosVG.createSequentialGroup()
        					.addComponent(lblProductosConsumidosVG, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNumProductosConsumidosVG, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
        				.addGroup(gl_jPanelProductosVG.createSequentialGroup()
        					.addComponent(lblTotalStockVG, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNumTotalStockVG, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        gl_jPanelProductosVG.setVerticalGroup(
        	gl_jPanelProductosVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelProductosVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelProductosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTotalStockVG, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNumTotalStockVG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelProductosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblProductosConsumidosVG)
        				.addComponent(lblNumProductosConsumidosVG))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelProductosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblProductoTopVG)
        				.addComponent(lblNombreProductoTopVG))
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelProductosVG.setLayout(gl_jPanelProductosVG);

        GroupLayout gl_jPanelInformesVG = new GroupLayout(jPanelInformesVG);
        gl_jPanelInformesVG.setHorizontalGroup(
        	gl_jPanelInformesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelInformesVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelInformesVG.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanelEmpleadosVG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(gl_jPanelInformesVG.createSequentialGroup()
        					.addComponent(jPanelTotalPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_jPanelInformesVG.createParallelGroup(Alignment.LEADING)
        						.addComponent(jPanelProductosVG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jPanelCajaVG, GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)))
        				.addGroup(gl_jPanelInformesVG.createSequentialGroup()
        					.addGroup(gl_jPanelInformesVG.createParallelGroup(Alignment.LEADING)
        						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblEmpleadosTurnoVG, GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnRefreshInformesVG)))
        			.addContainerGap())
        );
        gl_jPanelInformesVG.setVerticalGroup(
        	gl_jPanelInformesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelInformesVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelInformesVG.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_jPanelInformesVG.createSequentialGroup()
        					.addComponent(jPanelProductosVG, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanelCajaVG, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jPanelTotalPedidosVG, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelInformesVG.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanelInformesVG.createSequentialGroup()
        					.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblEmpleadosTurnoVG, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnRefreshInformesVG))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanelEmpleadosVG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanelInformesVG.setLayout(gl_jPanelInformesVG);
        
        JLabel lblClienteIdClienteVG = new JLabel("CLIENTE ID:");
        
        txtClienteIdClienteVG = new JTextField();
        txtClienteIdClienteVG.setColumns(10);
        
        btnRefreshClientesVG = new JButton("REFRESH");

        GroupLayout gl_jPanelDatosClientesVG = new GroupLayout(jPanelDatosClientesVG);
        gl_jPanelDatosClientesVG.setHorizontalGroup(
        	gl_jPanelDatosClientesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosClientesVG.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnRegistrarClienteVG, GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
        				.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        					.addGroup(gl_jPanelDatosClientesVG.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        							.addComponent(lblNombreClienteVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtNombreClienteVG))
        						.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        							.addComponent(lblDNIClienteVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtDNIClienteVG, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
        					.addGap(18)
        					.addGroup(gl_jPanelDatosClientesVG.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        							.addComponent(lblDireccionClienteVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtDireccionClienteVG, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        							.addComponent(lblPuntosClienteVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtPuntosClienteVG)))
        					.addGap(18)
        					.addGroup(gl_jPanelDatosClientesVG.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        							.addComponent(lblTelefonoClienteVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtTelefonoClienteVG, GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
        						.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        							.addComponent(lblEmailClienteVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtEmailClienteVG, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblClienteIdClienteVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtClienteIdClienteVG, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(btnRefreshClientesVG, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))))
        			.addContainerGap())
        );
        gl_jPanelDatosClientesVG.setVerticalGroup(
        	gl_jPanelDatosClientesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosClientesVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosClientesVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombreClienteVG)
        				.addComponent(txtNombreClienteVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDireccionClienteVG)
        				.addComponent(txtDireccionClienteVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTelefonoClienteVG)
        				.addComponent(txtTelefonoClienteVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelDatosClientesVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDNIClienteVG)
        				.addComponent(txtDNIClienteVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPuntosClienteVG)
        				.addComponent(txtPuntosClienteVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEmailClienteVG)
        				.addComponent(txtEmailClienteVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblClienteIdClienteVG)
        				.addComponent(txtClienteIdClienteVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnRefreshClientesVG))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnRegistrarClienteVG)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosClientesVG.setLayout(gl_jPanelDatosClientesVG);

        tbClientesVG.setModel(new DefaultTableModel(
            	new Object[][] {
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		{null, null, null, null, null, null, null, null, null},
            		
            	},
            	new String[] {
            		"CLIENTE ID", "NOMBRE CLIENTE", "CLIENTE DNI", "DIRECCION CLIENTE", "TELEFONO CLIENTE", "EMAIL CLIENTE", "PUNTOS CLIENTE"
            	}
            ));
       
        jScrollPane2.setViewportView(tbClientesVG);

        GroupLayout gl_jPanelTablaClientesVG = new GroupLayout(jPanelTablaClientesVG);
        gl_jPanelTablaClientesVG.setHorizontalGroup(
        	gl_jPanelTablaClientesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_jPanelTablaClientesVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelTablaClientesVG.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        				.addComponent(jPanelDatosClientesVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        				.addComponent(btnEditarClienteVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        				.addComponent(btnEliminarClienteVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_jPanelTablaClientesVG.setVerticalGroup(
        	gl_jPanelTablaClientesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelTablaClientesVG.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelDatosClientesVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnEditarClienteVG)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnEliminarClienteVG)
        			.addContainerGap())
        );
        jPanelTablaClientesVG.setLayout(gl_jPanelTablaClientesVG);

        GroupLayout gl_jPanelClientesVG = new GroupLayout(jPanelClientesVG);
        gl_jPanelClientesVG.setHorizontalGroup(
        	gl_jPanelClientesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelClientesVG.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelTablaClientesVG, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_jPanelClientesVG.setVerticalGroup(
        	gl_jPanelClientesVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelClientesVG.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelTablaClientesVG, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );
        jPanelClientesVG.setLayout(gl_jPanelClientesVG);
        
        JLabel lblEmpleadoIdEmpleadosVG = new JLabel("EMPLEADO ID:");
        
        txtEmpleadoIdEmpleadosVG = new JTextField();
        txtEmpleadoIdEmpleadosVG.setColumns(10);
        
        btnRefreshEmpleadosVG = new JButton("REFRESH");

        GroupLayout gl_jPanelDatosEmpleadosVG = new GroupLayout(jPanelDatosEmpleadosVG);
        gl_jPanelDatosEmpleadosVG.setHorizontalGroup(
        	gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosEmpleadosVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnRegistrarEmpleadoVG, GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
        				.addGroup(gl_jPanelDatosEmpleadosVG.createSequentialGroup()
        					.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanelDatosEmpleadosVG.createSequentialGroup()
        							.addComponent(lblNombreEmpleadoVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtNombreEmpleadoVG, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_jPanelDatosEmpleadosVG.createSequentialGroup()
        							.addComponent(lblDNIEmpleadoVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtDNIEmpleadoVG, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
        					.addGap(18)
        					.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanelDatosEmpleadosVG.createSequentialGroup()
        							.addComponent(lblEmpleadoIdEmpleadosVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtEmpleadoIdEmpleadosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblDireccionEmpleadoVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtDireccionEmpleadoVG, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblTelefonoEmpleadoVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtTelefonoEmpleadoVG, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblEmailEmpleadoVG))
        						.addGroup(gl_jPanelDatosEmpleadosVG.createSequentialGroup()
        							.addComponent(lblRolEmpleadoVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtRolEmpleadoVG, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        							.addGap(18)
        							.addComponent(lblSalarioEmpleadoVG)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtSalarioEmpleadoVG, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtEmailEmpleadoVG)
        						.addComponent(btnRefreshEmpleadosVG, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
        			.addContainerGap())
        );
        gl_jPanelDatosEmpleadosVG.setVerticalGroup(
        	gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosEmpleadosVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombreEmpleadoVG)
        				.addComponent(txtNombreEmpleadoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEmpleadoIdEmpleadosVG)
        				.addComponent(txtEmpleadoIdEmpleadosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDireccionEmpleadoVG)
        				.addComponent(txtDireccionEmpleadoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTelefonoEmpleadoVG)
        				.addComponent(txtTelefonoEmpleadoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEmailEmpleadoVG)
        				.addComponent(txtEmailEmpleadoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblDNIEmpleadoVG)
        					.addComponent(txtDNIEmpleadoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblRolEmpleadoVG))
        				.addGroup(gl_jPanelDatosEmpleadosVG.createParallelGroup(Alignment.BASELINE)
        					.addComponent(txtRolEmpleadoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtSalarioEmpleadoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblSalarioEmpleadoVG)
        					.addComponent(btnRefreshEmpleadosVG)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnRegistrarEmpleadoVG)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosEmpleadosVG.setLayout(gl_jPanelDatosEmpleadosVG);

        tbEmpleadoVG.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"EMPLEADO ID", "NOMBRE EMPLEADO", "EMPLEADO DNI", "DIRECCION EMPLEADO", "TELEFONO EMPLEADO", "EMAIL EMPLEADO",
        		"ROL EMPLEADO", "SALARIO EMPLEADO"
        	}
        ));
        tbEmpleadoVG.setShowHorizontalLines(true);
        jScrollPane3.setViewportView(tbEmpleadoVG);

        GroupLayout gl_jPanelTablaEmpleados = new GroupLayout(jPanelTablaEmpleados);
        gl_jPanelTablaEmpleados.setHorizontalGroup(
        	gl_jPanelTablaEmpleados.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_jPanelTablaEmpleados.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelTablaEmpleados.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanelTablaEmpleados.createSequentialGroup()
        					.addComponent(jPanelDatosEmpleadosVG, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, gl_jPanelTablaEmpleados.createSequentialGroup()
        					.addGroup(gl_jPanelTablaEmpleados.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jScrollPane3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        						.addComponent(btnEliminarEmpleadoVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        						.addComponent(btnQuitarTurnoEmpleadoVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        						.addComponent(btnPonerTurnoEmpleadoVG, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        						.addComponent(btnEditarEmpleadoVG, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
        					.addContainerGap())))
        );
        gl_jPanelTablaEmpleados.setVerticalGroup(
        	gl_jPanelTablaEmpleados.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelTablaEmpleados.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelDatosEmpleadosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnEditarEmpleadoVG)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnEliminarEmpleadoVG)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnPonerTurnoEmpleadoVG)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnQuitarTurnoEmpleadoVG, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        );
        jPanelTablaEmpleados.setLayout(gl_jPanelTablaEmpleados);

        GroupLayout gl_jPanelPestañaEmpleados = new GroupLayout(jPanelPestañaEmpleados);
        gl_jPanelPestañaEmpleados.setHorizontalGroup(
        	gl_jPanelPestañaEmpleados.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelPestañaEmpleados.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelTablaEmpleados, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_jPanelPestañaEmpleados.setVerticalGroup(
        	gl_jPanelPestañaEmpleados.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelPestañaEmpleados.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelTablaEmpleados, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanelPestañaEmpleados.setLayout(gl_jPanelPestañaEmpleados);
        
        btnRefreshProductosVG = new JButton("REFRESH");

        GroupLayout gl_jPanelDatosProductos = new GroupLayout(jPanelDatosProductos);
        gl_jPanelDatosProductos.setHorizontalGroup(
        	gl_jPanelDatosProductos.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosProductos.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosProductos.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanelDatosProductos.createSequentialGroup()
        					.addComponent(btnRefreshProductosVG, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(gl_jPanelDatosProductos.createSequentialGroup()
        					.addGroup(gl_jPanelDatosProductos.createParallelGroup(Alignment.TRAILING)
        						.addComponent(btnRegistrarProductoVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        						.addGroup(gl_jPanelDatosProductos.createSequentialGroup()
        							.addComponent(lblNombreProductoVG, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtNombreProductoVG, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        							.addGap(18)
        							.addComponent(lblPrecioVentaProductoVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtPrecioVentaProductoVG, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblCantidadProductoVG)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtCantidadProductoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblProductoIdProductosVG)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtProductoIdProductosVG, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
        					.addGap(10))))
        );
        gl_jPanelDatosProductos.setVerticalGroup(
        	gl_jPanelDatosProductos.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosProductos.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosProductos.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombreProductoVG)
        				.addComponent(lblPrecioVentaProductoVG)
        				.addComponent(txtPrecioVentaProductoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblCantidadProductoVG)
        				.addComponent(txtCantidadProductoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblProductoIdProductosVG)
        				.addComponent(txtProductoIdProductosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtNombreProductoVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnRefreshProductosVG, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnRegistrarProductoVG, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosProductos.setLayout(gl_jPanelDatosProductos);

        tbProductosVG.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"PRODUCTO ID", "NOMBRE PRODUCTO", "CANTIDAD STOCK", "PRECIO VENTA PRODUCTO"
        	}
        ));
        tbProductosVG.setShowHorizontalLines(true);
        jScrollPane4.setViewportView(tbProductosVG);

        GroupLayout gl_jPanelTablaProductos = new GroupLayout(jPanelTablaProductos);
        gl_jPanelTablaProductos.setHorizontalGroup(
        	gl_jPanelTablaProductos.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelTablaProductos.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelTablaProductos.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanelDatosProductos, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        				.addComponent(btnEliminarProductoVG, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        				.addComponent(jScrollPane4)
        				.addComponent(btnActualizarProductoVG, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)))
        );
        gl_jPanelTablaProductos.setVerticalGroup(
        	gl_jPanelTablaProductos.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelTablaProductos.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelDatosProductos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnEliminarProductoVG)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnActualizarProductoVG)
        			.addContainerGap())
        );
        jPanelTablaProductos.setLayout(gl_jPanelTablaProductos);
        
        

        GroupLayout gl_jPanelDatosProveedoresVG = new GroupLayout(jPanelDatosProveedoresVG);
        gl_jPanelDatosProveedoresVG.setHorizontalGroup(
        	gl_jPanelDatosProveedoresVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosProveedoresVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosProveedoresVG.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnRegistrarProveedorVG, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        				.addGroup(gl_jPanelDatosProveedoresVG.createSequentialGroup()
        					.addComponent(lblPrecioProveedorVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtPrecioProveedorVG, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(lblCantidadProveedorVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtCantidadProveedorVG, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(lblProductoIdProveedoresVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtProductoIdProveedoresVG, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(lblProveedorIdProveedoresVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtProveedorIdProveedoresVG, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        				.addGroup(gl_jPanelDatosProveedoresVG.createSequentialGroup()
        					.addComponent(lblNombreProveedorVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtNombreProveedorVG, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(lblTelefonoProveedorVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtTelefonoProveedorVG, 112, 112, 112)
        					.addGap(18)
        					.addComponent(lblEmailProveedorVG)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtEmailProveedorVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnRefreshProveedoresVG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        gl_jPanelDatosProveedoresVG.setVerticalGroup(
        	gl_jPanelDatosProveedoresVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelDatosProveedoresVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelDatosProveedoresVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombreProveedorVG)
        				.addComponent(txtNombreProveedorVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTelefonoProveedorVG)
        				.addComponent(txtTelefonoProveedorVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEmailProveedorVG)
        				.addComponent(txtEmailProveedorVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnRefreshProveedoresVG))
        			.addGap(18)
        			.addGroup(gl_jPanelDatosProveedoresVG.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPrecioProveedorVG)
        				.addComponent(txtPrecioProveedorVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblCantidadProveedorVG)
        				.addComponent(txtCantidadProveedorVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblProductoIdProveedoresVG)
        				.addComponent(txtProductoIdProveedoresVG, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblProveedorIdProveedoresVG)
        				.addComponent(txtProveedorIdProveedoresVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnRegistrarProveedorVG)
        			.addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelDatosProveedoresVG.setLayout(gl_jPanelDatosProveedoresVG);

        tbProveedoresVG.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"PROVEEDOR ID", "PRODUCTO ID", "NOMBRE PROVEEDOR", "TELEFONO PROVEEDOR", "EMAIL PROVEEDOR", "PRECIO COMPRA PRODUCTO", "CANTIDAD COMPRA PRODUCTO"
        	}
        ));
        jScrollPane6.setViewportView(tbProveedoresVG);

        GroupLayout gl_jPanelTablaProveedoresVG = new GroupLayout(jPanelTablaProveedoresVG);
        gl_jPanelTablaProveedoresVG.setHorizontalGroup(
        	gl_jPanelTablaProveedoresVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_jPanelTablaProveedoresVG.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_jPanelTablaProveedoresVG.createParallelGroup(Alignment.TRAILING)
        				.addComponent(btnActualizarProveedorVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        				.addComponent(jPanelDatosProveedoresVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        				.addComponent(btnEliminarProveedorVG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        				.addComponent(jScrollPane6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_jPanelTablaProveedoresVG.setVerticalGroup(
        	gl_jPanelTablaProveedoresVG.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanelTablaProveedoresVG.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelDatosProveedoresVG, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jScrollPane6, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnEliminarProveedorVG)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnActualizarProveedorVG)
        			.addContainerGap())
        );
        jPanelTablaProveedoresVG.setLayout(gl_jPanelTablaProveedoresVG);

        jTabbedGerente.addTab("PROVEEDORES", jPanelTablaProveedoresVG);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedGerente)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedGerente, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        btnDetalleGerente = new JButton();
        btnDetalleGerente.setFont(new Font("Arial", 1, 12)); 
        btnDetalleGerente.setText("DETALLE");
        
        jPanelDetallePedidosVG = new JPanel();
        jPanelPedidosCLienteVG = new JPanel();
        
        jScrollPane1 = new JScrollPane();
        
        jScrollPane5 = new JScrollPane();
        jScrollPane5.setEnabled(false);
        jTabbedGerente.addTab("PEDIDOS", jPanelPedidosCLienteVG);
        
        tbPedidosVG = new JTable();       
        tbPedidosVG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbPedidosVG.setShowGrid(false);
        tbPedidosVG.setShowHorizontalLines(true);
        
         txtAreaDetallePedidoGerente = new JTextArea();
      
         
         tbPedidosVG.setModel(new DefaultTableModel(
             	new Object[][] {
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		{null, null, null, null, null, null, null, null, null},
             		
             	},
             	new String[] {
             		"PEDIDO ID", "CLIENTE ID", "PRODUCTO ID", "METODO PAGO", "NOMBRE PRODUCTO SOLICITADO", 
             		"CANTIDAD PRODUCTO SOLICITADO", "TOTAL TICKET PEDIDO"
             	}
             ));
         
         jScrollPane1.setViewportView(tbPedidosVG);
         jScrollPane5.setViewportView(txtAreaDetallePedidoGerente);
         
                 GroupLayout gl_jPanelDetallePedidosVG = new GroupLayout(jPanelDetallePedidosVG);
                 jPanelDetallePedidosVG.setLayout(gl_jPanelDetallePedidosVG);
                 gl_jPanelDetallePedidosVG.setHorizontalGroup(
                     gl_jPanelDetallePedidosVG.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addGroup(gl_jPanelDetallePedidosVG.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(jScrollPane5)
                         .addContainerGap())
                 );
                 gl_jPanelDetallePedidosVG.setVerticalGroup(
                     gl_jPanelDetallePedidosVG.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addGroup(gl_jPanelDetallePedidosVG.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(jScrollPane5, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                 );
                 
                 JLabel lblPedidoIDPedidosVG = new JLabel("PEDIDO ID:");
                 
                 txtPedidoIdPedidosVG = new JTextField();
                 txtPedidoIdPedidosVG.setColumns(10);
                 
                 JLabel lblClienteIdPedidosVG = new JLabel("CLIENTE ID:");
                 
                 txtClienteIdPedidosVG = new JTextField();
                 txtClienteIdPedidosVG.setColumns(10);
                 
                 lblProductoIdPedidosVG = new JLabel("PRODUCTO ID:");
                 
                 txtProductoIdPedidosVG = new JTextField();
                 txtProductoIdPedidosVG.setColumns(10);
                 
                 lblMetodoPagoClientesVG = new JLabel("METODO PAGO:");
                 
                 txtMetodoPagoClientesVG = new JTextField();
                 txtMetodoPagoClientesVG.setColumns(10);
                 
                 lblNombrePoductoClientesVG = new JLabel("NOMBRE PRODUCTO:");
                 
                 txtNombreProductoPedidosVG = new JTextField();
                 txtNombreProductoPedidosVG.setColumns(10);
                 
                 lblCantidadProductoClientesVG = new JLabel("CANTIDAD PRODUCTO:");
                 
                 txtCantidadProductoPedidosVG = new JTextField();
                 txtCantidadProductoPedidosVG.setColumns(10);
                 
                 lblTotalTicketPedidoClientesVG = new JLabel("TOTAL TICKET:");
                 
                 txtTotalTicketPedidoPedidosVG = new JTextField();
                 txtTotalTicketPedidoPedidosVG.setColumns(10);
                 
                 btnRefreshPedidosVG = new JButton("REFRESH");
                 
                 btnRegistrarPedidosVG = new JButton("REGISTRAR");
                         
                         btnEliminarPedidosVG = new JButton("ELIMINAR");
                         
                         btnEditarPedidosVG = new JButton("EDITAR");
                 
                         GroupLayout gl_jPanelPedidosCLienteVG = new GroupLayout(jPanelPedidosCLienteVG);
                         gl_jPanelPedidosCLienteVG.setHorizontalGroup(
                         	gl_jPanelPedidosCLienteVG.createParallelGroup(Alignment.TRAILING)
                         		.addGroup(gl_jPanelPedidosCLienteVG.createSequentialGroup()
                         			.addGroup(gl_jPanelPedidosCLienteVG.createParallelGroup(Alignment.LEADING)
                         				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                         				.addGroup(gl_jPanelPedidosCLienteVG.createSequentialGroup()
                         					.addContainerGap()
                         					.addGroup(gl_jPanelPedidosCLienteVG.createParallelGroup(Alignment.LEADING)
                         						.addGroup(gl_jPanelPedidosCLienteVG.createSequentialGroup()
                         							.addComponent(lblNombrePoductoClientesVG)
                         							.addPreferredGap(ComponentPlacement.UNRELATED)
                         							.addComponent(txtNombreProductoPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         							.addGap(18)
                         							.addComponent(lblCantidadProductoClientesVG)
                         							.addPreferredGap(ComponentPlacement.UNRELATED)
                         							.addComponent(txtCantidadProductoPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         							.addGap(18)
                         							.addComponent(lblTotalTicketPedidoClientesVG)
                         							.addPreferredGap(ComponentPlacement.UNRELATED)
                         							.addComponent(txtTotalTicketPedidoPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         							.addGap(18)
                         							.addComponent(btnRefreshPedidosVG, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                         						.addGroup(gl_jPanelPedidosCLienteVG.createSequentialGroup()
                         							.addComponent(lblPedidoIDPedidosVG)
                         							.addPreferredGap(ComponentPlacement.UNRELATED)
                         							.addComponent(txtPedidoIdPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         							.addGap(18)
                         							.addComponent(lblClienteIdPedidosVG)
                         							.addPreferredGap(ComponentPlacement.UNRELATED)
                         							.addComponent(txtClienteIdPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         							.addGap(18)
                         							.addComponent(lblProductoIdPedidosVG)
                         							.addPreferredGap(ComponentPlacement.UNRELATED)
                         							.addComponent(txtProductoIdPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         							.addGap(18)
                         							.addComponent(lblMetodoPagoClientesVG)
                         							.addGap(18)
                         							.addComponent(txtMetodoPagoClientesVG, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                         					.addGap(18)
                         					.addGroup(gl_jPanelPedidosCLienteVG.createParallelGroup(Alignment.LEADING)
                         						.addGroup(gl_jPanelPedidosCLienteVG.createSequentialGroup()
                         							.addComponent(btnEditarPedidosVG, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                         							.addGap(18)
                         							.addComponent(btnEliminarPedidosVG, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                         						.addComponent(btnRegistrarPedidosVG, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                         				.addComponent(jPanelDetallePedidosVG, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                         				.addComponent(btnDetalleGerente, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE))
                         			.addContainerGap())
                         );
                         gl_jPanelPedidosCLienteVG.setVerticalGroup(
                         	gl_jPanelPedidosCLienteVG.createParallelGroup(Alignment.TRAILING)
                         		.addGroup(gl_jPanelPedidosCLienteVG.createSequentialGroup()
                         			.addContainerGap()
                         			.addGroup(gl_jPanelPedidosCLienteVG.createParallelGroup(Alignment.BASELINE)
                         				.addComponent(lblPedidoIDPedidosVG)
                         				.addComponent(txtPedidoIdPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         				.addComponent(lblClienteIdPedidosVG)
                         				.addComponent(txtClienteIdPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         				.addComponent(lblProductoIdPedidosVG)
                         				.addComponent(txtProductoIdPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         				.addComponent(lblMetodoPagoClientesVG)
                         				.addComponent(txtMetodoPagoClientesVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         				.addComponent(btnRegistrarPedidosVG, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                         			.addPreferredGap(ComponentPlacement.UNRELATED)
                         			.addGroup(gl_jPanelPedidosCLienteVG.createParallelGroup(Alignment.BASELINE)
                         				.addComponent(lblNombrePoductoClientesVG)
                         				.addComponent(txtNombreProductoPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         				.addComponent(lblCantidadProductoClientesVG)
                         				.addComponent(txtCantidadProductoPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         				.addComponent(lblTotalTicketPedidoClientesVG)
                         				.addComponent(txtTotalTicketPedidoPedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         				.addComponent(btnEliminarPedidosVG)
                         				.addComponent(btnEditarPedidosVG)
                         				.addComponent(btnRefreshPedidosVG))
                         			.addGap(18)
                         			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                         			.addPreferredGap(ComponentPlacement.RELATED)
                         			.addComponent(btnDetalleGerente, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                         			.addPreferredGap(ComponentPlacement.RELATED)
                         			.addComponent(jPanelDetallePedidosVG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                         			.addContainerGap())
                         );
                         jPanelPedidosCLienteVG.setLayout(gl_jPanelPedidosCLienteVG);

        pack();
    }        
       
    public JTextField getTxtCantidadProductoPedidosVG() {
		return txtCantidadProductoPedidosVG;
	}

	public void setTxtCantidadProductoPedidosVG(JTextField txtCantidadProductoPedidosVG) {
		this.txtCantidadProductoPedidosVG = txtCantidadProductoPedidosVG;
	}

	public JTextField getTxtTotalTicketPedidoPedidosVG() {
		return txtTotalTicketPedidoPedidosVG;
	}

	public void setTxtTotalTicketPedidoPedidosVG(JTextField txtTotalTicketPedidoPedidosVG) {
		this.txtTotalTicketPedidoPedidosVG = txtTotalTicketPedidoPedidosVG;
	}

	public JTextField getTxtNombreProductoPedidosVG() {
		return txtNombreProductoPedidosVG;
	}

	public void setTxtNombreProductoPedidosVG(JTextField txtNombreProductoPedidosVG) {
		this.txtNombreProductoPedidosVG = txtNombreProductoPedidosVG;
	}

	public JButton getBtnRefreshProveedoresVG() {
		return btnRefreshProveedoresVG;
	}

	public void setBtnRefreshProveedoresVG(JButton btnRefreshProveedoresVG) {
		this.btnRefreshProveedoresVG = btnRefreshProveedoresVG;
	}

	public JButton getBtnRefreshClientesVG() {
		return btnRefreshClientesVG;
	}

	public void setBtnRefreshClientesVG(JButton btnRefreshClientesVG) {
		this.btnRefreshClientesVG = btnRefreshClientesVG;
	}

	public JTable getTbClientesVG() {
		return tbClientesVG;
	}

	public void setTbClientesVG(JTable tbClientesVG) {
		this.tbClientesVG = tbClientesVG;
	}

	public JTable getTbEmpleadoVG() {
		return tbEmpleadoVG;
	}

	public void setTbEmpleadoVG(JTable tbEmpleadoVG) {
		this.tbEmpleadoVG = tbEmpleadoVG;
	}

	public JTable getTbPedidosVG() {
		return tbPedidosVG;
	}

	public void setTbPedidosVG(JTable tbPedidosVG) {
		this.tbPedidosVG = tbPedidosVG;
	}

	public JTable getTbProductosVG() {
		return tbProductosVG;
	}

	public void setTbProductosVG(JTable tbProductosVG) {
		this.tbProductosVG = tbProductosVG;
	}

	public JTable getTbProveedoresVG() {
		return tbProveedoresVG;
	}

	public void setTbProveedoresVG(JTable tbProveedoresVG) {
		this.tbProveedoresVG = tbProveedoresVG;
	}

	public JTable getTbVistaPedidos() {
		return tbPedidosVG;
	}

	public void setTbVistaPedidos(JTable tbVistaPedidos) {
		this.tbPedidosVG = tbVistaPedidos;
	}

	public JLabel getLblNombreProductoTopVG() {
		return lblNombreProductoTopVG;
	}

	public void setLblNombreProductoTopVG(JLabel lblNombreProductoTopVG) {
		this.lblNombreProductoTopVG = lblNombreProductoTopVG;
	}

	public JLabel getLblNumCajaVG() {
		return lblNumCajaVG;
	}

	public void setLblNumCajaVG(JLabel lblNumCajaVG) {
		this.lblNumCajaVG = lblNumCajaVG;
	}

	public JLabel getLblNumPedidosConfirmadosVG() {
		return lblNumPedidosConfirmadosVG;
	}

	public void setLblNumPedidosConfirmadosVG(JLabel lblNumPedidosConfirmadosVG) {
		this.lblNumPedidosConfirmadosVG = lblNumPedidosConfirmadosVG;
	}

	public JLabel getLblNumPedidosEntregadosVG() {
		return lblNumPedidosEntregadosVG;
	}

	public void setLblNumPedidosEntregadosVG(JLabel lblNumPedidosEntregadosVG) {
		this.lblNumPedidosEntregadosVG = lblNumPedidosEntregadosVG;
	}

	public JLabel getLblNumPedidosSinConfirmarVG() {
		return lblNumPedidosSinConfirmarVG;
	}

	public void setLblNumPedidosSinConfirmarVG(JLabel lblNumPedidosSinConfirmarVG) {
		this.lblNumPedidosSinConfirmarVG = lblNumPedidosSinConfirmarVG;
	}

	public JLabel getLblNumPedidosTotalVG() {
		return lblNumPedidosTotalVG;
	}

	public void setLblNumPedidosTotalVG(JLabel lblNumPedidosTotalVG) {
		this.lblNumPedidosTotalVG = lblNumPedidosTotalVG;
	}

	public JLabel getLblNumProductosConsumidosVG() {
		return lblNumProductosConsumidosVG;
	}

	public void setLblNumProductosConsumidosVG(JLabel lblNumProductosConsumidosVG) {
		this.lblNumProductosConsumidosVG = lblNumProductosConsumidosVG;
	}

	public JLabel getLblNumTicketMedioVG() {
		return lblNumTicketMedioVG;
	}

	public void setLblNumTicketMedioVG(JLabel lblNumTicketMedioVG) {
		this.lblNumTicketMedioVG = lblNumTicketMedioVG;
	}

	public JLabel getLblNumTicketTopVG() {
		return lblNumTicketTopVG;
	}

	public void setLblNumTicketTopVG(JLabel lblNumTicketTopVG) {
		this.lblNumTicketTopVG = lblNumTicketTopVG;
	}

	public JLabel getLblNumTotalPedidosVG() {
		return lblNumTotalPedidosVG;
	}

	public void setLblNumTotalPedidosVG(JLabel lblNumTotalPedidosVG) {
		this.lblNumTotalPedidosVG = lblNumTotalPedidosVG;
	}

	public JLabel getLblNumTotalStockVG() {
		return lblNumTotalStockVG;
	}

	public void setLblNumTotalStockVG(JLabel lblNumTotalStockVG) {
		this.lblNumTotalStockVG = lblNumTotalStockVG;
	}

	public JButton getBtnActualizarProductoVG() {
		return btnActualizarProductoVG;
	}

	public JButton getBtnActualizarProveedorVG() {
		return btnActualizarProveedorVG;
	}

	public JButton getBtnAñadirProductoVG() {
		return btnRegistrarProductoVG;
	}

	public JButton getBtnAñadirProveedorVG() {
		return btnRegistrarProveedorVG;
	}

	public JButton getBtnDetalleGerente() {
		return btnDetalleGerente;
	}

	public JButton getBtnEditarClienteVG() {
		return btnEditarClienteVG;
	}

	public JButton getBtnEditarEmpleadoVG() {
		return btnEditarEmpleadoVG;
	}

	public JButton getBtnEliminarClienteVG() {
		return btnEliminarClienteVG;
	}

	public JButton getBtnEliminarEmpleadoVG() {
		return btnEliminarEmpleadoVG;
	}

	public JButton getBtnEliminarProductoVG() {
		return btnEliminarProductoVG;
	}

	public JButton getBtnEliminarProveedorVG() {
		return btnEliminarProveedorVG;
	}

	public JButton getBtnQuitarTurnoEmpleadoVG() {
		return btnQuitarTurnoEmpleadoVG;
	}

	public JButton getBtnPonerTurnoEmpleadoVG() {
		return btnPonerTurnoEmpleadoVG;
	}

	public JButton getBtnRegistrarClienteVG() {
		return btnRegistrarClienteVG;
	}

	public JButton getBtnRegistrarEmpleadoVG() {
		return btnRegistrarEmpleadoVG;
	}

	public JButton getBtnRegistrarProductoVG() {
		return btnRegistrarProductoVG;
	}

	public void setBtnRegistrarProductoVG(JButton btnRegistrarProductoVG) {
		this.btnRegistrarProductoVG = btnRegistrarProductoVG;
	}

	public JButton getBtnRegistrarProveedorVG() {
		return btnRegistrarProveedorVG;
	}

	public void setBtnRegistrarProveedorVG(JButton btnRegistrarProveedorVG) {
		this.btnRegistrarProveedorVG = btnRegistrarProveedorVG;
	}

	public JButton getBtnRefreshInformesVG() {
		return btnRefreshInformesVG;
	}

	public void setBtnRefreshInformesVG(JButton btnRefreshInformesVG) {
		this.btnRefreshInformesVG = btnRefreshInformesVG;
	}

	public JButton getBtnRefreshProductosVG() {
		return btnRefreshProductosVG;
	}

	public void setBtnRefreshProductosVG(JButton btnRefreshProductosVG) {
		this.btnRefreshProductosVG = btnRefreshProductosVG;
	}

	public JButton getBtnRefreshPedidosVG() {
		return btnRefreshPedidosVG;
	}

	public void setBtnRefreshPedidosVG(JButton btnRefreshPedidosVG) {
		this.btnRefreshPedidosVG = btnRefreshPedidosVG;
	}

	public JButton getBtnRegistrarPedidosVG() {
		return btnRegistrarPedidosVG;
	}

	public void setBtnRegistrarPedidosVG(JButton btnRegistrarPedidosVG) {
		this.btnRegistrarPedidosVG = btnRegistrarPedidosVG;
	}

	public JButton getBtnEliminarPedidosVG() {
		return btnEliminarPedidosVG;
	}

	public void setBtnEliminarPedidosVG(JButton btnEliminarPedidosVG) {
		this.btnEliminarPedidosVG = btnEliminarPedidosVG;
	}

	public JButton getBtnRefreshEmpleadosVG() {
		return btnRefreshEmpleadosVG;
	}

	public void setBtnRefreshEmpleadosVG(JButton btnRefreshEmpleadosVG) {
		this.btnRefreshEmpleadosVG = btnRefreshEmpleadosVG;
	}

	public void setBtnActualizarProductoVG(JButton btnActualizarProductoVG) {
		this.btnActualizarProductoVG = btnActualizarProductoVG;
	}

	public void setBtnActualizarProveedorVG(JButton btnActualizarProveedorVG) {
		this.btnActualizarProveedorVG = btnActualizarProveedorVG;
	}

	public void setBtnDetalleGerente(JButton btnDetalleGerente) {
		this.btnDetalleGerente = btnDetalleGerente;
	}

	public void setBtnEditarClienteVG(JButton btnEditarClienteVG) {
		this.btnEditarClienteVG = btnEditarClienteVG;
	}

	public void setBtnEditarEmpleadoVG(JButton btnEditarEmpleadoVG) {
		this.btnEditarEmpleadoVG = btnEditarEmpleadoVG;
	}

	public JButton getBtnEditarPedidosVG() {
		return btnEditarPedidosVG;
	}

	public void setBtnEditarPedidosVG(JButton btnEditarPedidosVG) {
		this.btnEditarPedidosVG = btnEditarPedidosVG;
	}

	public void setBtnEliminarClienteVG(JButton btnEliminarClienteVG) {
		this.btnEliminarClienteVG = btnEliminarClienteVG;
	}

	public void setBtnEliminarEmpleadoVG(JButton btnEliminarEmpleadoVG) {
		this.btnEliminarEmpleadoVG = btnEliminarEmpleadoVG;
	}

	public void setBtnEliminarProductoVG(JButton btnEliminarProductoVG) {
		this.btnEliminarProductoVG = btnEliminarProductoVG;
	}

	public void setBtnEliminarProveedorVG(JButton btnEliminarProveedorVG) {
		this.btnEliminarProveedorVG = btnEliminarProveedorVG;
	}

	public void setBtnQuitarTurnoEmpleadoVG(JButton btnQuitarTurnoEmpleadoVG) {
		this.btnQuitarTurnoEmpleadoVG = btnQuitarTurnoEmpleadoVG;
	}

	public void setBtnPonerTurnoEmpleadoVG(JButton btnPonerTurnoEmpleadoVG) {
		this.btnPonerTurnoEmpleadoVG = btnPonerTurnoEmpleadoVG;
	}

	public void setBtnRegistrarClienteVG(JButton btnRegistrarClienteVG) {
		this.btnRegistrarClienteVG = btnRegistrarClienteVG;
	}

	public void setBtnRegistrarEmpleadoVG(JButton btnRegistrarEmpleadoVG) {
		this.btnRegistrarEmpleadoVG = btnRegistrarEmpleadoVG;
	}

	public JTextArea getTxtAreaDetallePedidoGerente() {
		return txtAreaDetallePedidoGerente;
	}

	public void setTxtAreaDetallePedidoGerente(JTextArea txtAreaDetallePedidoGerente) {
		this.txtAreaDetallePedidoGerente = txtAreaDetallePedidoGerente;
	}

	public JTextArea getTxtAreaEmpleadosVG() {
		return txtAreaEmpleadosVG;
	}

	public void setTxtAreaEmpleadosVG(JTextArea txtAreaEmpleadosVG) {
		this.txtAreaEmpleadosVG = txtAreaEmpleadosVG;
	}

	public JTextField getTxtCantidadProductoVG() {
		return txtCantidadProductoVG;
	}

	public void setTxtCantidadProductoVG(JTextField txtCantidadProductoVG) {
		this.txtCantidadProductoVG = txtCantidadProductoVG;
	}

	public JTextField getTxtCantidadProveedorVG() {
		return txtCantidadProveedorVG;
	}

	public void setTxtCantidadProveedorVG(JTextField txtCantidadProveedorVG) {
		this.txtCantidadProveedorVG = txtCantidadProveedorVG;
	}

	public JTextField getTxtDireccionClienteVG() {
		return txtDireccionClienteVG;
	}

	public void setTxtDireccionClienteVG(JTextField txtDireccionClienteVG) {
		this.txtDireccionClienteVG = txtDireccionClienteVG;
	}

	public JTextField getTxtDireccionEmpleadoVG() {
		return txtDireccionEmpleadoVG;
	}

	public void setTxtDireccionEmpleadoVG(JTextField txtDireccionEmpleadoVG) {
		this.txtDireccionEmpleadoVG = txtDireccionEmpleadoVG;
	}

	public JTextField getTxtDNIEmpleadoVG() {
		return txtDNIEmpleadoVG;
	}

	public void setTxtDNIEmpleadoVG(JTextField txtDNIEmpleadoVG) {
		this.txtDNIEmpleadoVG = txtDNIEmpleadoVG;
	}

	public JTextField getTxtDNIClienteVG() {
		return txtDNIClienteVG;
	}

	public void setTxtDNIClienteVG(JTextField txtDNIClienteVG) {
		this.txtDNIClienteVG = txtDNIClienteVG;
	}

	public JTextField getTxtEmailClienteVG() {
		return txtEmailClienteVG;
	}

	public void setTxtEmailClienteVG(JTextField txtEmailClienteVG) {
		this.txtEmailClienteVG = txtEmailClienteVG;
	}

	public JTextField getTxtEmailEmpleadoVG() {
		return txtEmailEmpleadoVG;
	}

	public void setTxtEmailEmpleadoVG(JTextField txtEmailEmpleadoVG) {
		this.txtEmailEmpleadoVG = txtEmailEmpleadoVG;
	}

	public JTextField getTxtEmailProveedorVG() {
		return txtEmailProveedorVG;
	}

	public void setTxtEmailProveedorVG(JTextField txtEmailProveedorVG) {
		this.txtEmailProveedorVG = txtEmailProveedorVG;
	}

	public JTextField getTxtClienteIdClienteVG() {
		return txtClienteIdClienteVG;
	}

	public void setTxtClienteIdClienteVG(JTextField txtClienteIdClienteVG) {
		this.txtClienteIdClienteVG = txtClienteIdClienteVG;
	}

	public JTextField getTxtNombreEmpleadoVG() {
		return txtNombreEmpleadoVG;
	}

	public void setTxtNombreEmpleadoVG(JTextField txtNombreEmpleadoVG) {
		this.txtNombreEmpleadoVG = txtNombreEmpleadoVG;
	}

	public JTextField getTxtNombreProductoVG() {
		return txtNombreProductoVG;
	}

	public void setTxtNombreProductoVG(JTextField txtNombreProductoVG) {
		this.txtNombreProductoVG = txtNombreProductoVG;
	}

	public JTextField getTxtNombreProveedorVG() {
		return txtNombreProveedorVG;
	}

	public void setTxtNombreProveedorVG(JTextField txtNombreProveedorVG) {
		this.txtNombreProveedorVG = txtNombreProveedorVG;
	}

	public JTextField getTxtPrecioProveedorVG() {
		return txtPrecioProveedorVG;
	}

	public void setTxtPrecioProveedorVG(JTextField txtPrecioProveedorVG) {
		this.txtPrecioProveedorVG = txtPrecioProveedorVG;
	}

	public JTextField getTxtPrecioVentaProductoVG() {
		return txtPrecioVentaProductoVG;
	}

	public void setTxtPrecioVentaProductoVG(JTextField txtPrecioVentaProductoVG) {
		this.txtPrecioVentaProductoVG = txtPrecioVentaProductoVG;
	}

	public JTextField getTxtProductoIdProductosVG() {
		return txtProductoIdProductosVG;
	}

	public void setTxtProductoIdProductosVG(JTextField txtProductoIdProductosVG) {
		this.txtProductoIdProductosVG = txtProductoIdProductosVG;
	}

	public JTextField getTxtProductoIdProveedorVG() {
		return txtProductoIdProveedoresVG;
	}

	public void setTxtProductoIdProveedorVG(JTextField txtProductoProveedorVG) {
		this.txtProductoIdProveedoresVG = txtProductoProveedorVG;
	}

	public JTextField getTxtPuntosClienteVG() {
		
		return txtPuntosClienteVG;
	}

	public void setTxtPuntosClienteVG(JTextField txtPuntosClienteVG) {
		this.txtPuntosClienteVG = txtPuntosClienteVG;
	}

	public JTextField getTxtRolEmpleadoVG() {
		return txtRolEmpleadoVG;
	}

	public void setTxtRolEmpleadoVG(JTextField txtRolEmpleadoVG) {
		this.txtRolEmpleadoVG = txtRolEmpleadoVG;
	}

	public  JTextField getTxtSalarioEmpleadoVG() {
		return txtSalarioEmpleadoVG;
	}

	public void setTxtSalarioEmpleadoVG(JTextField txtSalarioEmpleadoVG) {
		this.txtSalarioEmpleadoVG = txtSalarioEmpleadoVG;
	}

	public JTextField getTxtTelefonoClienteVG() {
		return txtTelefonoClienteVG;
	}

	public void setTxtTelefonoClienteVG(JTextField txtTelefonoClienteVG) {
		this.txtTelefonoClienteVG = txtTelefonoClienteVG;
	}

	public JTextField getTxtTelefonoEmpleadoVG() {
		return txtTelefonoEmpleadoVG;
	}

	public void setTxtTelefonoEmpleadoVG(JTextField txtTelefonoEmpleadoVG) {
		this.txtTelefonoEmpleadoVG = txtTelefonoEmpleadoVG;
	}

	public JTextField getTxtTelefonoProveedorVG() {
		return txtTelefonoProveedorVG;
	}

	public void setTxtTelefonoProveedorVG(JTextField txtTelefonoProveedorVG) {
		this.txtTelefonoProveedorVG = txtTelefonoProveedorVG;
	}

	public JTextField getTxtNombreClienteVG() {
		return txtNombreClienteVG;
	}

	public void setTxtNombreClienteVG(JTextField txtNombreClienteVG) {
		this.txtNombreClienteVG = txtNombreClienteVG;
	}

	public JTextField getTxtProveedorIdProveedoresVG() {
		return txtProveedorIdProveedoresVG;
	}

	public void setTxtProveedorIdProveedoresVG(JTextField txtProveedorIdProveedoresVG) {
		this.txtProveedorIdProveedoresVG = txtProveedorIdProveedoresVG;
	}

	public JTextField getTxtProductoIdProveedoresVG() {
		return txtProductoIdProveedoresVG;
	}

	public void setTxtProductoIdProveedoresVG(JTextField txtProductoIdProveedoresVG) {
		this.txtProductoIdProveedoresVG = txtProductoIdProveedoresVG;
	}

	public JTextField getTxtEmpleadoIdEmpleadosVG() {
		return txtEmpleadoIdEmpleadosVG;
	}

	public void setTxtEmpleadoIdEmpleadosVG(JTextField txtEmpleadoIdEmpleadosVG) {
		this.txtEmpleadoIdEmpleadosVG = txtEmpleadoIdEmpleadosVG;
	}

	public JTextField getTxtPedidoIdPedidosVG() {
		return txtPedidoIdPedidosVG;
	}

	public void setTxtPedidoIdPedidosVG(JTextField txtPedidoIdPedidosVG) {
		this.txtPedidoIdPedidosVG = txtPedidoIdPedidosVG;
	}

	public JTextField getTxtClienteIdPedidosVG() {
		return txtClienteIdPedidosVG;
	}

	public void setTxtClienteIdPedidosVG(JTextField txtClienteIdPedidosVG) {
		this.txtClienteIdPedidosVG = txtClienteIdPedidosVG;
	}

	public JTextField getTxtProductoIdPedidosVG() {
		return txtProductoIdPedidosVG;
	}

	public void setTxtProductoIdPedidosVG(JTextField txtProductoIdPedidosVG) {
		this.txtProductoIdPedidosVG = txtProductoIdPedidosVG;
	}

	public JTextField getTxtMetodoPagoClientesVG() {
		return txtMetodoPagoClientesVG;
	}

	public void setTxtMetodoPagoClientesVG(JTextField txtMetodoPagoClientesVG) {
		this.txtMetodoPagoClientesVG = txtMetodoPagoClientesVG;
	}

	public JTextField getTxtNombreProductoClientesVG() {
		return txtNombreProductoPedidosVG;
	}

	public void setTxtNombreProductoClientesVG(JTextField txtNombreProductoClientesVG) {
		this.txtNombreProductoPedidosVG = txtNombreProductoClientesVG;
	}

	public JTextField getTxtCantidadProductoClientesVG() {
		return txtCantidadProductoPedidosVG;
	}

	public void setTxtCantidadProductoClientesVG(JTextField txtCantidadProductoClientesVG) {
		this.txtCantidadProductoPedidosVG = txtCantidadProductoClientesVG;
	}

	public JTextField getTxtTotalTicketPedidoClientesVG() {
		return txtTotalTicketPedidoPedidosVG;
	}

	public void setTxtTotalTicketPedidoClientesVG(JTextField txtTotalTicketPedidoClientesVG) {
		this.txtTotalTicketPedidoPedidosVG = txtTotalTicketPedidoClientesVG;
	}

	public Coordinador getCoordinador() {
		return miCoordinador;
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}