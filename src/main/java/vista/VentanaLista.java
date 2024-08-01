package vista;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;

import modelo.Coordinador;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 *
 * @author Raul
 */
public class VentanaLista extends javax.swing.JFrame {

	private Coordinador miCoordinador;
	
	private static final long serialVersionUID = 1L;
    private javax.swing.JButton btnNuevoPedidoVL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVentanaLista;
   
	/**
     * Creates new form VentanaLista
     */
    public VentanaLista() {
        initComponents();
    }
                       
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        
        btnNuevoPedidoVL = new javax.swing.JButton();        
        
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVentanaLista = new javax.swing.JTable();
        tbVentanaLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        setTitle("VISUALIZAR PEDIDOS");

        btnNuevoPedidoVL.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnNuevoPedidoVL.setText("NUEVO PEDIDO");
        
        tbVentanaLista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbVentanaLista.setDefaultRenderer(Object.class, centerRenderer);
        tbVentanaLista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tbVentanaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                            
            },
            new String [] {
                "ORDEN", "NOMBRE", "PEDIDO", "ESTADO"
            }
        ) {
        	
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
   
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbVentanaLista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbVentanaLista.setName(""); // NOI18N
        tbVentanaLista.setRowHeight(30);
        tbVentanaLista.setShowGrid(true);
        tbVentanaLista.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tbVentanaLista);
        tbVentanaLista.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGap(10)
        			.addComponent(btnNuevoPedidoVL, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        			.addGap(12)
        			.addComponent(btnNuevoPedidoVL, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }   
    
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public Coordinador getCoordinador() {
		return miCoordinador;
	}
	
    public javax.swing.JTable getTbVentanaLista() {
		return tbVentanaLista;
	}

	public void setTbVentanaLista(javax.swing.JTable tbVentanaLista) {
		this.tbVentanaLista = tbVentanaLista;
	}
	
	public void setBtnNuevoPedidoVL(javax.swing.JButton btnNuevoPedidoVL) {
		this.btnNuevoPedidoVL = btnNuevoPedidoVL;
	}
	
	public javax.swing.JButton getBtnNuevoPedidoVL() {
		return btnNuevoPedidoVL;
	}
	
}