package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Coordinador;

public class VentanaEmpleado extends JFrame {
  
	private static final long serialVersionUID = 1L;
	
	private JButton btnConfirmarPedidoSinConfirmar;  
 	private JButton btnPedidoListo;
    private JButton btnEliminarPedidosConfirmados;
    private JButton btnEliminarPedidoSinConfirmar;
    private JButton btnPedidoEntregado;  
   
    
    private JLabel lblNumPEListosListos;
    private JLabel lblNumPPendientesListos;
    private JLabel lblNumPTotalListos;  
    private JLabel lblPedidosListos;    
    private JLabel lblPPendientesListos;  
    private JLabel lblPTotalListos;   
    private JLabel lblTotalTicketVE;   
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel5;
    
    private JLabel lblMetodoPagoVE;
    private JTextField txtPagoElegidoVE;
    private JLabel lblTotalVE;
    
    private JList<String> lstSinConfirmar;
	private JList<String> lstPedidosConfirmados;
    private JList<String> lstPedidosListos;    
    
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    
    private JSeparator jSeparator1;
    
    private JTabbedPane jTabbedPane1;
    
    private JTable tbSinConfirmar;
    
    private JTextArea txtAreaDetallePedidosConfirmados;
    private JTextArea txtAreaSinConfirmar;    
    
	/**
     * Crear nuevo formulario VentanaEmpleados
     */
    public VentanaEmpleado() {
		
        initComponents();
    }
    
    //Iniciar componentes
    private void initComponents() {
    	
    	btnConfirmarPedidoSinConfirmar = new JButton();
    	btnConfirmarPedidoSinConfirmar.setFont(new Font("Arial", 1, 18)); 
        btnConfirmarPedidoSinConfirmar.setText("CONFIRMAR PEDIDO");
         
    	btnPedidoListo = new JButton();
    	btnPedidoListo.setText("Pedido Listo");
    	 
        btnEliminarPedidosConfirmados = new JButton();
        btnEliminarPedidosConfirmados.setText("Eliminar");
        
        btnEliminarPedidoSinConfirmar = new JButton();
        btnEliminarPedidoSinConfirmar.setText("Eliminar Pedido");
        
        btnPedidoEntregado = new JButton();
        btnPedidoEntregado.setFont(new Font("Arial", 1, 18)); 
        btnPedidoEntregado.setText("Pedido Entregado");
        
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel5 = new JPanel();
  
        jScrollPane4 = new JScrollPane();
        jScrollPane5 = new JScrollPane();
        jScrollPane6 = new JScrollPane();
        jScrollPane7 = new JScrollPane();
        
        jSeparator1 = new JSeparator();
        
        jTabbedPane1 = new JTabbedPane();
        jTabbedPane1.addTab("PEDIDOS SIN CONFIRMAR", jPanel2);
       
        txtAreaDetallePedidosConfirmados = new JTextArea();
        txtAreaDetallePedidosConfirmados.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        txtAreaSinConfirmar = new JTextArea();
        txtAreaSinConfirmar.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        lblMetodoPagoVE = new JLabel();
        lblMetodoPagoVE.setFont(new Font("Arial", 1, 12)); 
        lblMetodoPagoVE.setHorizontalAlignment(SwingConstants.CENTER);
        lblMetodoPagoVE.setText("Método de pago:");
        
        lblNumPEListosListos = new JLabel();
        
        lblNumPPendientesListos = new JLabel();
        
        lblNumPTotalListos = new JLabel();
        
        txtPagoElegidoVE = new JTextField();
        txtPagoElegidoVE.setBorder(new LineBorder(new Color(0, 0, 0)));
        
        lblPedidosListos = new JLabel();
        lblPedidosListos.setFont(new Font("Arial", 1, 12)); 
        lblPedidosListos.setHorizontalAlignment(SwingConstants.CENTER);
        lblPedidosListos.setText("Pedidos listos:");
        
        lblPPendientesListos = new JLabel();
        lblPPendientesListos.setFont(new Font("Arial", 1, 12)); 
        lblPPendientesListos.setHorizontalAlignment(SwingConstants.CENTER);
        lblPPendientesListos.setText("Pedidos pendientes:");
        
        lblPTotalListos = new JLabel();
        lblPTotalListos.setFont(new Font("Arial", 1, 12)); 
        lblPTotalListos.setHorizontalAlignment(SwingConstants.CENTER);
        lblPTotalListos.setText("Pedidos total:");
        
        lblTotalTicketVE = new JLabel();
        lblTotalTicketVE.setFont(new Font("Arial", 1, 18)); 
        
        lblTotalVE = new JLabel();
        lblTotalVE.setFont(new Font("Arial", 1, 18)); 
        lblTotalVE.setText("TOTAL:");
        
        lstPedidosConfirmados = new JList<>(new DefaultListModel<>());
        lstPedidosConfirmados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        
        lstPedidosListos = new JList<>(new DefaultListModel<>());
        lstPedidosListos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        lstSinConfirmar = new JList<>(new DefaultListModel<>());
        lstSinConfirmar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tbSinConfirmar = new JTable();
       
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbSinConfirmar.setDefaultRenderer(Object.class, centerRenderer);
        tbSinConfirmar.setModel(new DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "ORDEN", "NOMBRE", "PEDIDO", "ESTADO"
            }
        ));
        
        tbSinConfirmar.setShowHorizontalLines(true);
        jScrollPane4.setViewportView(tbSinConfirmar);
       
       
        jScrollPane5.setViewportView(lstSinConfirmar);
        
        JScrollPane scrollPanetxtAreaSinConfirmar = new JScrollPane();

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        					.addContainerGap())
        				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(scrollPanetxtAreaSinConfirmar, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
        					.addGap(8)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(btnEliminarPedidoSinConfirmar, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        						.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(lblMetodoPagoVE, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        								.addComponent(lblTotalVE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(txtPagoElegidoVE, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        								.addComponent(lblTotalTicketVE, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
        						.addComponent(btnConfirmarPedidoSinConfirmar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        					.addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblMetodoPagoVE, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtPagoElegidoVE, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblTotalTicketVE, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblTotalVE, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(btnEliminarPedidoSinConfirmar)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnConfirmarPedidoSinConfirmar, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
        				.addComponent(scrollPanetxtAreaSinConfirmar, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
        			.addContainerGap())
        );       
       
        scrollPanetxtAreaSinConfirmar.setViewportView(txtAreaSinConfirmar);
        
        jPanel2.setLayout(jPanel2Layout);

        jScrollPane6.setViewportView(lstPedidosConfirmados);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPedidoListo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarPedidosConfirmados, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAreaDetallePedidosConfirmados, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEliminarPedidosConfirmados)
                        .addGap(108, 108, 108)
                        .addComponent(btnPedidoListo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 152, Short.MAX_VALUE))
                    .addComponent(txtAreaDetallePedidosConfirmados, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PEDIDOS CONFIRMADOS", jPanel3);

        jScrollPane7.setViewportView(lstPedidosListos);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPedidoEntregado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPPendientesListos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPedidosListos, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(lblPTotalListos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumPPendientesListos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumPEListosListos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumPTotalListos, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNumPEListosListos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPedidosListos, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumPPendientesListos, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPPendientesListos, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPTotalListos, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(lblNumPTotalListos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(btnPedidoEntregado, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PEDIDOS LISTOS", jPanel5);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                      
    
    public JLabel getLblNumPEListosListos() {
		return lblNumPEListosListos;
	}

	public void setLblNumPEListosListos(JLabel lblNumPEListosListos) {
		this.lblNumPEListosListos = lblNumPEListosListos;
	}

	public void setCoordinador(Coordinador miCoordinador) {
	}
	
	public JLabel getLblTotalTicketVE() {
		return lblTotalTicketVE;
	}

	public JTextField getTxtPagoElegidoVE() {
		return txtPagoElegidoVE;
	}

	public void setTxtPagoElegidoVE(JTextField txtPagoElegidoVE) {
		this.txtPagoElegidoVE = txtPagoElegidoVE;
	}

	public void setTxtAreaSinConfirmar(JTextArea txtAreaSinConfirmar) {
		this.txtAreaSinConfirmar = txtAreaSinConfirmar;
	}

	public JTextArea getTxtAreaSinConfirmar() {
		return txtAreaSinConfirmar;
	}

	
	 public JButton getBtnConfirmarPedidoSinConfirmar() {
		return btnConfirmarPedidoSinConfirmar;
	}

	public void setBtnConfirmarPedidoSinConfirmar(JButton btnConfirmarPedidoSinConfirmar) {
		this.btnConfirmarPedidoSinConfirmar = btnConfirmarPedidoSinConfirmar;
	}

	public JButton getBtnEliminarPedidosConfirmados() {
		return btnEliminarPedidosConfirmados;
	}

	public void setBtnEliminarPedidosConfirmados(JButton btnEliminarPedidosConfirmados) {
		this.btnEliminarPedidosConfirmados = btnEliminarPedidosConfirmados;
	}

	public JButton getBtnEliminarPedidoSinConfirmar() {
		return btnEliminarPedidoSinConfirmar;
	}

	public void setBtnEliminarPedidoSinConfirmar(JButton btnEliminarPedidoSinConfirmar) {
		this.btnEliminarPedidoSinConfirmar = btnEliminarPedidoSinConfirmar;
	}

	public JButton getBtnPedidoEntregado() {
		return btnPedidoEntregado;
	}

	public void setBtnPedidoEntregado(JButton btnPedidoEntregado) {
		this.btnPedidoEntregado = btnPedidoEntregado;
	}

	public JButton getBtnConfirmarPedido() {
			return btnConfirmarPedidoSinConfirmar;
		}
	 
	 public JButton getBtnPedidoListo() {
		return btnPedidoListo;
	}

	public void setBtnPedidoListo(JButton btnPedidoListo) {
		this.btnPedidoListo = btnPedidoListo;
	}

	public JLabel getLblNumPEntregadosListos() {
		return lblNumPEListosListos;
	}

	public void setLblNumPEntregadosListos(JLabel lblNumPEntregadosListos) {
		this.lblNumPEListosListos = lblNumPEntregadosListos;
	}

	public JLabel getLblNumPPendientesListos() {
		return lblNumPPendientesListos;
	}

	public void setLblNumPPendientesListos(JLabel lblNumPPendientesListos) {
		this.lblNumPPendientesListos = lblNumPPendientesListos;
	}

	public JLabel getLblNumPTotalListos() {
		return lblNumPTotalListos;
	}

	public void setLblNumPTotalListos(JLabel lblNumPTotalListos) {
		this.lblNumPTotalListos = lblNumPTotalListos;
	}

	public JList<String> getLstSinConfirmar() {
			return lstSinConfirmar;
		}

	public void setLstSinConfirmar(JList<String> lstSinConfirmar) {
		this.lstSinConfirmar = lstSinConfirmar;
	}

	public JList<String> getLstPedidosConfirmados() {
		return lstPedidosConfirmados;
	}

	public void setLstPedidosConfirmados(JList<String> lstPedidosConfirmados) {
		this.lstPedidosConfirmados = lstPedidosConfirmados;
	}

	public JList<String> getLstPedidosListos() {
		return lstPedidosListos;
	}

	public void setLstPedidosListos(JList<String> lstPedidosListos) {
		this.lstPedidosListos = lstPedidosListos;
	}

	public JTextArea getTxtAreaDetallePedidosConfirmados() {
		return txtAreaDetallePedidosConfirmados;
	}

	public void setTxtAreaDetallePedidosConfirmados(JTextArea txtAreaDetallePedidosConfirmados) {
		this.txtAreaDetallePedidosConfirmados = txtAreaDetallePedidosConfirmados;
	}

	public JTable getTbSinConfirmar() {
		return tbSinConfirmar;
	}

	public void setTbSinConfirmar(JTable tbSinConfirmar) {
		this.tbSinConfirmar = tbSinConfirmar;
	}
}