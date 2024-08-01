package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Coordinador;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVentanaCliente;
	private JButton btnVentanaEmpleado;
	private JButton btnVentanaGerente;
	private JButton btnSalir;
	
	private Coordinador miCoordinador;
	
	/**
     * Creates new form VentanaPrincipal
     */
	public VentanaPrincipal() {
		initComponents();
	}
	
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		
		setTitle("VENTANA PRINCIPAL");
		setMinimumSize(new Dimension(1000, 180));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 180);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(3000, 300));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnVentanaCliente = new JButton("VENTANA CLIENTE");		
		panel.add(btnVentanaCliente, BorderLayout.EAST);
		btnVentanaCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		btnVentanaEmpleado = new JButton("VENTANA EMPLEADO");			
		panel.add(btnVentanaEmpleado, BorderLayout.WEST);
		btnVentanaEmpleado.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		btnVentanaGerente = new JButton("VENTANA GERENTE");
		panel.add(btnVentanaGerente, BorderLayout.NORTH);
		btnVentanaGerente.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE GESTION DEL RESTAURANTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(btnSalir, BorderLayout.SOUTH);
	}

	public JButton getBtnVentanaCliente() {
		// TODO Auto-generated method stub
		return btnVentanaCliente;
	}
	
	public JButton getBtnVentanaEmpleado() {
		// TODO Auto-generated method stub
		return btnVentanaEmpleado;
	}

	public JButton getBtnVentanaGerente() {
		// TODO Auto-generated method stub
		return btnVentanaGerente;
	}
	public JButton getBtnSalir() {
		// TODO Auto-generated method stub
		return btnSalir;
	}

	public Coordinador getCoordinador() {
		return miCoordinador;
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}