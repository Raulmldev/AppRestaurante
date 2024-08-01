package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Coordinador;

/**
 *
 * @author Raul
 */
public class VentanaCliente extends javax.swing.JFrame {
	
	/**
     * Declaracion de variables.
     */
	private static final long serialVersionUID = 1L;  
	
	private ButtonGroup btnGroupMetodoPago;

	private GroupLayout jPanelLayout;
	private GroupLayout jPanel2Layout;	
	
	private JButton btnAyuda;
	private JButton btnComentario;
	private JButton btnReiniciar;
	private JButton btnVolver;
    private JButton btnAgregar;
    private JButton btnRealizarPedido;    
    
    private JComboBox<String> jComboPizza;
	private JComboBox<String> jComboHamburguesa;
	private JComboBox<String> jComboHotDog;
	private JComboBox<String> jComboPasta;
	private JComboBox<String> jComboEnsalada;
	private JComboBox<String> jComboBebida;
	private JComboBox<String> jComboPostre;

	private JLabel lblEstadoPedidos;
    private JLabel lblNombre;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblDNI;
    private JLabel lblMenu;
    private JLabel lblCantidad;
    private JLabel lblPrecio;
    private JLabel lblTicket;
    private JLabel lblPrecioPizza;
	private JLabel lblPrecioHamburguesa;
    private JLabel lblPrecioHotDog;
    private JLabel lblPrecioPasta;
    private JLabel lblPrecioEnsalada;
    private JLabel lblPrecioBebida;
    private JLabel lblPrecioPostre;
    private JLabel lblTotalVC; 
    private JLabel lblMetodoPagoVC;    
    private JLabel lblPizza;
    private JLabel lblHamburguesa;
    private JLabel lblHotDog;
    private JLabel lblPasta;
    private JLabel lblEnsalada;
    private JLabel lblBebida;
    private JLabel lblPostre;
    private JLabel lblDireccion;
    private JLabel lblTotalTicketVC;  
    
	private JPanel jPanel1;
    private JPanel jPanel2;
    
    private JRadioButton jRadioEfectivo;
 
	private JRadioButton jRadioTarjeta;
    
	private JScrollPane scrollPaneAreaComentario;
	private JScrollPane scrollPaneAreaListaTicket;
	private JScrollPane scrollPaneTabla; 
    
    private JSeparator jSeparator;
	private JSeparator jSeparator1;    
    
    private JSpinner spinnerPizza;
	private JSpinner spinnerHamburguesa;
    private JSpinner spinnerHotDog;
    private JSpinner spinnerPasta;
    private JSpinner spinnerEnsalada;
    private JSpinner spinnerBebida;
    private JSpinner spinnerPostre;
        
    private JTable tbEPCliente;
    
    private JTextArea txtAreaComentario;
    private JTextArea txtAreaListaTicket;
    
	private JTextField txtNombre;
	private JTextField txtDireccion; 
	private JTextField txtDNI;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtComentario;      
    
	/**
     * Crear el formulario Clientes.
     */
    public VentanaCliente() {
		
        initComponents();
    }
    
    /**
	 * Crear el marco.
	 */          
    private void initComponents() {
    	
    	setTitle("CLIENTES");
    	setResizable(false);
    	
    	btnAyuda = new JButton();
    	btnAyuda.setText("Ayuda");
    	
    	btnComentario = new JButton();
        btnComentario.setText("Añadir Comentario");
        
        btnReiniciar = new JButton();
        btnReiniciar.setText("Reiniciar");
        
        btnVolver = new JButton();
        btnVolver.setText("VOLVER");
        
        btnAgregar = new JButton();
        btnAgregar.setText("Agregar");

        btnRealizarPedido = new JButton();
        btnRealizarPedido.setFont(new Font("Arial", 1, 18));
        btnRealizarPedido.setText("REALIZAR PEDIDO");
        
        btnGroupMetodoPago = new ButtonGroup();
        btnGroupMetodoPago.add(jRadioEfectivo);
        btnGroupMetodoPago.add(jRadioTarjeta);
  
        jComboPizza = new JComboBox<>();
        jComboPizza.setModel(new DefaultComboBoxModel<>(new String[] { "Pizza Margarita", "Pizza 4 Quesos", "Pizza Barbacoa", "Pizza Anchoas" }));
    	 
        jComboHamburguesa = new JComboBox<>();
        jComboHamburguesa.setModel(new DefaultComboBoxModel<>(new String[] { "Ternera", "Pollo", "Vegetal", "Pescado" }));
        
        jComboHotDog = new JComboBox<>();
        jComboHotDog.setModel(new DefaultComboBoxModel<>(new String[] { "Normal", "Pavo", "Salchicha Blanca", "Picante" }));
        
        jComboPasta = new JComboBox<>();
        jComboPasta.setModel(new DefaultComboBoxModel<>(new String[] { "Espaguetis", "Macarrones", "Tortelinis", "Tallarines" }));
        
        jComboEnsalada = new JComboBox<>();
        jComboEnsalada.setModel(new DefaultComboBoxModel<>(new String[] { "Mediterránea", "César", "Campera", "Ensaladilla Rusa" }));
        
        jComboBebida = new JComboBox<>();
        jComboBebida.setModel(new DefaultComboBoxModel<>(new String[] { "Agua", "CocaCola", "Naranja", "Limon" }));
        
        jComboPostre = new JComboBox<>();   
        jComboPostre.setModel(new DefaultComboBoxModel<>(new String[] { "Yogurt", "Helado", "Flan", "Tarta" }));   

        lblEstadoPedidos = new JLabel();
        lblEstadoPedidos.setFont(new Font("Arial", 1, 18));
        lblEstadoPedidos.setHorizontalAlignment(SwingConstants.CENTER);
        lblEstadoPedidos.setText("ESTADO PEDIDOS");
        
        lblNombre = new JLabel();       
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNombre.setForeground(new Color(0, 0, 255));
        lblNombre.setText("NOMBRE:");
        
        lblTelefono = new JLabel();
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTelefono.setForeground(new Color(0, 0, 255));
        lblTelefono.setText("TELÉFONO:");
        
        lblEmail = new JLabel();
        lblEmail.setText("EMAIL:");
        
        lblDNI = new JLabel();
        lblDNI.setText("DNI:");
        
        lblMenu = new JLabel();
        lblMenu.setForeground(new Color(0, 0, 255));
        lblMenu.setFont(new Font("Arial", Font.BOLD, 22));
        lblMenu.setText("MENU");
                
        lblCantidad = new JLabel();
        lblCantidad.setFont(new Font("Arial", 1, 18));
        lblCantidad.setText("CANTIDAD");
        
        lblPrecio = new JLabel();
        lblPrecio.setFont(new Font("Arial", 1, 18));
        lblPrecio.setText("PRECIO");
        
        lblTicket = new JLabel();
        lblTicket.setFont(new Font("Arial", 1, 18));
        lblTicket.setText("TICKET"); 
       
        lblPrecioPizza = new JLabel();
        lblPrecioPizza.setText("12€");
        
        lblPrecioHamburguesa = new JLabel();
        lblPrecioHamburguesa.setText("10€");
        
        lblPrecioHotDog = new JLabel();
        lblPrecioHotDog.setText("8€");
        
        lblPrecioPasta = new JLabel();
        lblPrecioPasta.setText("9€");
        
        lblPrecioEnsalada = new JLabel();
        lblPrecioEnsalada.setText("5€");
        
        lblPrecioBebida = new JLabel();
        lblPrecioBebida.setText("2€");
        
        lblPrecioPostre = new JLabel();
        lblPrecioPostre.setText("3€");
        
        lblTotalVC = new JLabel();
        lblTotalVC.setFont(new Font("Arial", 1, 24));
        lblTotalVC.setText("TOTAL:");
               
        lblMetodoPagoVC = new JLabel();
        lblMetodoPagoVC.setText("MÉTODO DE PAGO:");
        
        lblPizza = new JLabel();
        lblPizza.setFont(new Font("Arial", 1, 12));
        lblPizza.setText("Pizza");
        
        lblHamburguesa = new JLabel();
        lblHamburguesa.setFont(new Font("Arial", 1, 12)); 
        lblHamburguesa.setText("Hamburguesa");
        
        lblHotDog = new JLabel();
        lblHotDog.setFont(new Font("Arial", 1, 12)); 
        lblHotDog.setText("Hot Dog");
        
        lblPasta = new JLabel();
        lblPasta.setFont(new Font("Arial", 1, 12)); 
        lblPasta.setText("Pasta");
        
        lblEnsalada = new JLabel();
        lblEnsalada.setFont(new Font("Arial", 1, 12)); 
        lblEnsalada.setText("Ensalada");
        
        lblBebida = new JLabel();
        lblBebida.setFont(new Font("Arial", 1, 12)); 
        lblBebida.setText("Bebida");

        lblPostre = new JLabel();
        lblPostre.setFont(new Font("Arial", 1, 12)); 
        lblPostre.setText("Postre");
        
        lblDireccion = new JLabel("Dirección:");
        
        lblTotalTicketVC = new JLabel();
        lblTotalTicketVC.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalTicketVC.setText("0 €");
        lblTotalTicketVC.setFont(new Font("Arial", 1, 24)); 
        
        jPanel1 = new JPanel();
        
        jPanel2 = new JPanel();
        jPanel2.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        jPanel2Layout = new GroupLayout(jPanel2);
        jPanelLayout = new GroupLayout(getContentPane());
        jPanelLayout.setHorizontalGroup(
        	jPanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnAyuda)
        			.addGap(202)
        			.addComponent(btnRealizarPedido)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnVolver)
        			.addContainerGap(283, Short.MAX_VALUE))
        		.addGroup(jPanelLayout.createSequentialGroup()
        			.addContainerGap(20, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 802, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
        	jPanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanelLayout.createSequentialGroup()
        			.addGap(4)
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(18)
        			.addGroup(jPanelLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanelLayout.createSequentialGroup()
        					.addGroup(jPanelLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnRealizarPedido, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnVolver))
        					.addGap(12))
        				.addGroup(jPanelLayout.createSequentialGroup()
        					.addComponent(btnAyuda)
        					.addContainerGap())))
        );
        
        jRadioEfectivo = new JRadioButton();
        jRadioEfectivo.setSelected(true);
        jRadioEfectivo.setText("EFECTIVO");
        
        jRadioTarjeta = new JRadioButton();
        jRadioTarjeta.setText("TARJETA");
                
        scrollPaneAreaComentario = new JScrollPane();
        scrollPaneAreaComentario.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneAreaComentario.setViewportView(txtAreaComentario);
        
        scrollPaneAreaListaTicket = new JScrollPane();
        
        scrollPaneTabla = new JScrollPane();    
        
        jSeparator =  new JSeparator();
        jSeparator1 = new JSeparator();
        
        spinnerPizza = new JSpinner();
        spinnerPizza.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinnerHamburguesa = new JSpinner();
        spinnerHamburguesa.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinnerHotDog = new JSpinner();
        spinnerHotDog.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinnerPasta = new JSpinner();
        spinnerPasta.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinnerEnsalada = new JSpinner();
        spinnerEnsalada.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinnerBebida = new JSpinner();
        spinnerBebida.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinnerPostre = new JSpinner();
        spinnerPostre.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        
        tbEPCliente = new JTable();
        tbEPCliente.setName("4 colums, 50 rows");
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbEPCliente.setDefaultRenderer(Object.class, centerRenderer);
        scrollPaneTabla.setViewportView(tbEPCliente);
        
        txtComentario = new JTextField();
        txtComentario.setColumns(20);
                 
        txtNombre = new JTextField();     
        txtNombre.setColumns(10);
        
        txtDireccion = new JTextField();
        txtDireccion.setColumns(10);
        
        txtDNI = new JTextField();   
        txtDNI.setColumns(10);
        
        txtTelefono = new JTextField();     
        txtTelefono.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        
        txtAreaComentario = new JTextArea();
        txtAreaComentario.setEditable(false);
        scrollPaneAreaComentario.setViewportView(txtAreaComentario);
        txtAreaComentario.setFont(new Font("Tahoma", Font.BOLD, 11));       
        
        txtAreaListaTicket = new JTextArea();
        txtAreaListaTicket.setEditable(false);
        scrollPaneAreaListaTicket.setViewportView(txtAreaListaTicket);
        txtAreaListaTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
        
                
        jPanel2.setLayout(jPanel2Layout); 
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPaneAreaListaTicket, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        				.addComponent(scrollPaneAreaComentario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(lblTotalVC, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblTotalTicketVC, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(txtComentario, GroupLayout.PREFERRED_SIZE, 172, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnComentario)))
        			.addContainerGap())
        );
       
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnComentario)
        				.addComponent(txtComentario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPaneAreaComentario, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPaneAreaListaTicket, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTotalVC, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTotalTicketVC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jSeparator, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        										.addGroup(jPanel1Layout.createSequentialGroup()
        											.addGap(65)
        											.addComponent(lblMenu)
        											.addGap(77)
        											.addComponent(lblCantidad))
        										.addGroup(jPanel1Layout.createSequentialGroup()
        											.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        												.addGroup(jPanel1Layout.createSequentialGroup()
        													.addComponent(lblBebida)
        													.addGap(59))
        												.addGroup(jPanel1Layout.createSequentialGroup()
        													.addComponent(lblPostre)
        													.addGap(60)))
        											.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        												.addComponent(jComboPostre, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        												.addComponent(jComboBebida, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        									.addGap(34)
        									.addComponent(lblPrecio))
        								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        									.addGroup(jPanel1Layout.createSequentialGroup()
        										.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        											.addComponent(spinnerBebida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        											.addGroup(jPanel1Layout.createSequentialGroup()
        												.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        													.addComponent(lblHamburguesa)
        													.addComponent(lblPizza)
        													.addComponent(lblHotDog)
        													.addComponent(lblPasta)
        													.addComponent(lblEnsalada))
        												.addGap(18)
        												.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        													.addGroup(jPanel1Layout.createSequentialGroup()
        														.addComponent(jComboEnsalada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        														.addComponent(spinnerEnsalada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        													.addGroup(jPanel1Layout.createSequentialGroup()
        														.addComponent(jComboPasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        														.addComponent(spinnerPasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        													.addGroup(jPanel1Layout.createSequentialGroup()
        														.addComponent(jComboHotDog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        														.addComponent(spinnerHotDog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        													.addGroup(jPanel1Layout.createSequentialGroup()
        														.addComponent(jComboHamburguesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        														.addComponent(spinnerHamburguesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        													.addGroup(jPanel1Layout.createSequentialGroup()
        														.addComponent(jComboPizza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        														.addGap(41)
        														.addComponent(spinnerPizza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        											.addComponent(spinnerPostre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        											.addComponent(lblPrecioPizza)
        											.addComponent(lblPrecioHamburguesa)
        											.addComponent(lblPrecioHotDog)
        											.addComponent(lblPrecioPasta)
        											.addComponent(lblPrecioEnsalada)
        											.addComponent(lblPrecioBebida)
        											.addComponent(lblPrecioPostre)))
        									.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)))
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGap(135)
        									.addComponent(lblTicket)
        									.addGap(77)
        									.addComponent(btnReiniciar))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGap(4)
        									.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)))
        							.addGap(18))
        						.addComponent(lblEstadoPedidos, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)))
        				.addComponent(jSeparator1, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(scrollPaneTabla, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNombre)
        						.addComponent(lblDireccion))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lblMetodoPagoVC)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jRadioEfectivo)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jRadioTarjeta))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblTelefono)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblDNI)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblEmail)
        							.addGap(4)
        							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGap(411)))
        			.addGap(0))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(8)
        			.addComponent(lblEstadoPedidos, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPaneTabla, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCantidad)
        				.addComponent(lblPrecio)
        				.addComponent(lblTicket)
        				.addComponent(btnReiniciar)
        				.addComponent(lblMenu))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboPizza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(spinnerPizza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPizza)
        						.addComponent(lblPrecioPizza))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboHamburguesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPrecioHamburguesa)
        						.addComponent(lblHamburguesa)
        						.addComponent(spinnerHamburguesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboHotDog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPrecioHotDog)
        						.addComponent(spinnerHotDog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblHotDog))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboPasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPrecioPasta)
        						.addComponent(spinnerPasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPasta))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboEnsalada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPrecioEnsalada)
        						.addComponent(spinnerEnsalada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblEnsalada))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboBebida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPrecioBebida)
        						.addComponent(spinnerBebida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblBebida))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblPrecioPostre)
        						.addComponent(spinnerPostre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPostre)
        						.addComponent(jComboPostre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(btnAgregar))
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombre)
        				.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTelefono)
        				.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDNI)
        				.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEmail)
        				.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDireccion)
        				.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMetodoPagoVC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jRadioEfectivo)
        				.addComponent(jRadioTarjeta)))
        );
        
        tbEPCliente.setModel(new DefaultTableModel(
        		new Object [][] {
                   
                },
                new String [] {
                    "ORDEN", "NOMBRE", "PEDIDO", "ESTADO"
        	}
        ));
       
        jPanel1.setLayout(jPanel1Layout);
        getContentPane().setLayout(jPanelLayout);

        pack();
    }    
    
	/**
     * Metodos setter y getter.
     */
	public void setCoordinador(Coordinador miCoordinador) {
	}
	
	public JButton getBtnVolver() {	
		return btnVolver;
	}
	
	public JButton getBtnAyuda() {	
		return btnAyuda;
	}
	
	public JButton getBtnReiniciar() {	
		return btnReiniciar;
	}
	
	public JButton getBtnComentario() {	
		return btnComentario;
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	
	public JButton getBtnRealizarPedido() {
		return btnRealizarPedido;
	}

	public void setTxtAreaComentario(String textoComentario) {
		txtAreaComentario.setText(textoComentario);
	}
	
	public JTextArea getTxtAreaComentario() {
		return txtAreaComentario;
	}
	public void setTxtAreaListaTicket(String textoAreaListaTicket) {
		txtAreaListaTicket.setText(textoAreaListaTicket);
	}
	
	public JTextArea getTxtAreaListaTicket() {
		return txtAreaListaTicket;
	}
	
	public JLabel getLblTotalTicket() {
		return lblTotalTicketVC;
	}
	
	public void setLblTotalTicket(JLabel lblTotalTicket) {
		this.lblTotalTicketVC = lblTotalTicket;
	}
	
	public void setTxtComentario(String textoComentario) {
        txtComentario.setText(textoComentario);
    }
	
	public JTextField getTxtComentario() {
		return txtComentario;
	}
	
	public JComboBox<String> getJComboPizza() {
		return jComboPizza;	
	}
	
	public JSpinner getSpinnerPizza() {
		return spinnerPizza;	
	}
	
    public JLabel getLblPrecioPizza() {
		return lblPrecioPizza;
	}
	
    public JComboBox<String> getJComboHamburguesa() {
		return jComboHamburguesa;
	}

	public JSpinner getSpinnerHamburguesa() {
		return spinnerHamburguesa;
	}
	
	public JLabel getLblPrecioHamburguesa() {
		return lblPrecioHamburguesa;
	}
	
    public JComboBox<String> getJComboHotDog() {
		return jComboHotDog;
	}

	public JSpinner getSpinnerHotDog() {
		return spinnerHotDog;
	}
	
	public JLabel getLblPrecioHotDog() {
		return lblPrecioHotDog;
	}

	public JComboBox<String> getJComboPasta() {
		return jComboPasta;
	}

	public JSpinner getSpinnerPasta() {
		return spinnerPasta;
	}
	
	public JLabel getLblPrecioPasta() {
		return lblPrecioPasta;
	}
	
    public JComboBox<String> getJComboEnsalada() {
		return jComboEnsalada;
	}

	public JSpinner getSpinnerEnsalada() {
		return spinnerEnsalada;
	}
	
	public JLabel getLblPrecioEnsalada() {
		return lblPrecioEnsalada;
	}
	
    public JComboBox<String> getJComboBebida() {
		return jComboBebida;
	}

	public JSpinner getSpinnerBebida() {
		return spinnerBebida;
	}
	
	public JLabel getLblPrecioBebida() {
		return lblPrecioBebida;
	}
    
    public JComboBox<String> getJComboPostre() {
		return jComboPostre;
	}

	public JSpinner getSpinnerPostre() {
		return spinnerPostre;
	}

	public JLabel getLblPrecioPostre() {
		return lblPrecioPostre;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public void setTxtNombre(String strnombre) {
		txtNombre.setText(strnombre);
		
	}
	public JTextField getTxtDNI() {
		return txtDNI;
	}
	
	public void setTxtDNI(String strDNI) {
		txtDNI.setText(strDNI);		
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}
		
	public void setTxtTelefono(String strtelefono) {
		txtTelefono.setText(strtelefono);		
	}

	public JTextField getTxtEMail() {
		return txtEmail;
	}
	
	public void setTxtEMail(String strEmail) {
		txtEmail.setText(strEmail);
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}
	
	public void setTxtDireccion(String strDireccion) {
		txtDireccion.setText(strDireccion);
	}

	public JRadioButton getRadioEfectivo() {
		return jRadioEfectivo;
	}

	public JRadioButton getRadioTarjeta() {
		return jRadioTarjeta;
	}

	public String getTextBtnGroupMetodoPago() {
		
   	 if (getRadioEfectivo().isSelected()) {
   	        return getRadioEfectivo().getText();
   	    } else if (getRadioTarjeta().isSelected()) {
   	        return getRadioTarjeta().getText();
   	    } else {
   	        return ""; // Devolver una cadena vacía si no se ha seleccionado ningún método de pago
   	    }
	}
	
	public ButtonGroup getBtnGroupMetodoPago() {
		return btnGroupMetodoPago;
	}

	public JTable getTbEPCliente() {
		return tbEPCliente;
	}

	public void setTbEPCliente(JTable tbEPCliente) {
		this.tbEPCliente = tbEPCliente;
	}
	
}