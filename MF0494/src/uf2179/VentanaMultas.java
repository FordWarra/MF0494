package uf2179;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaMultas extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtApellidos;
	private JTextField txtNombre;
	private JTextArea textArea;
	private JLabel lblImporte;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultas frame = new VentanaMultas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("    DGT - Infracciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][][grow]", "[][][][][][grow]"));
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		panel.add(lblMatricula, "cell 0 0,alignx trailing");
		
		txtMatricula = new JTextField();
		panel.add(txtMatricula, "cell 1 0,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre, "cell 2 0,alignx trailing");
		
		txtNombre = new JTextField();
		panel.add(txtNombre, "cell 3 0,growx");
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		panel.add(lblApellidos, "cell 0 1,alignx trailing");
		
		txtApellidos = new JTextField();
		panel.add(txtApellidos, "cell 1 1 3 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblSancion = new JLabel("Sanci\u00F3n:");
		panel.add(lblSancion, "cell 0 2,alignx trailing");
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (comboBox.getSelectedItem().equals("No llevar casco"))
					lblImporte.setText("200");
				else if (comboBox.getSelectedItem().equals("Conducción temeraria"))
					lblImporte.setText("500");
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No llevar casco", "Conducci\u00F3n temeraria"}));
		panel.add(comboBox, "cell 1 2 3 1,growx");
		
		JLabel lblPrecio = new JLabel("Importe:");
		panel.add(lblPrecio, "cell 0 3,alignx right");
		
		lblImporte = new JLabel("200");
		panel.add(lblImporte, "cell 1 3");
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double prontoPago = Integer.parseInt(lblImporte.getText()) * 0.50;
				textArea.setText("Conductor: "+txtNombre.getText()+" "+txtApellidos.getText()+
						"\nInfracción: "+comboBox.getSelectedItem()+
						"\nImporte: "+ lblImporte.getText()+
						"\nPronto pago: "+ prontoPago);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton, "cell 0 4 4 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 5 4 1,grow");
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
