package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pimoney.DataBase;
import pimoney.Prestamo;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class RegistroCliente implements ActionListener{

	JFrame frame;
	private JTextField txtnom;
	private JTextField txtced;
	private JTextField txtdir;
	private JTextField txttel;
	private JButton Bace;
	private JButton Bcan;
	private JComboBox comboBox;
	public String actualusu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCliente window = new RegistroCliente("USUARIO");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroCliente(String a) {
		actualusu=a;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 409, 423);
		frame.setTitle("Registro Cliente");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {180, 180, 80};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(RegistroCliente.class.getResource("/Imagenes/icono22.png")));
		lblNewLabel_1_1.setBounds(137, 11, 170, 161);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {100, 90, 10};
		gbl_panel_1.rowHeights = new int[] {30, 30, 30, 30, 30};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("NOMBRE:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		txtnom = new JTextField();
		GridBagConstraints gbc_txtnom = new GridBagConstraints();
		gbc_txtnom.insets = new Insets(0, 0, 5, 0);
		gbc_txtnom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnom.gridx = 1;
		gbc_txtnom.gridy = 0;
		panel_1.add(txtnom, gbc_txtnom);
		txtnom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CEDULA:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtced = new JTextField();
		GridBagConstraints gbc_txtced = new GridBagConstraints();
		gbc_txtced.insets = new Insets(0, 0, 5, 0);
		gbc_txtced.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtced.gridx = 1;
		gbc_txtced.gridy = 1;
		panel_1.add(txtced, gbc_txtced);
		txtced.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DIRECCION:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtdir = new JTextField();
		GridBagConstraints gbc_txtdir = new GridBagConstraints();
		gbc_txtdir.insets = new Insets(0, 0, 5, 0);
		gbc_txtdir.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdir.gridx = 1;
		gbc_txtdir.gridy = 2;
		panel_1.add(txtdir, gbc_txtdir);
		txtdir.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONO:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txttel = new JTextField();
		GridBagConstraints gbc_txttel = new GridBagConstraints();
		gbc_txttel.insets = new Insets(0, 0, 5, 0);
		gbc_txttel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttel.gridx = 1;
		gbc_txttel.gridy = 3;
		panel_1.add(txttel, gbc_txttel);
		txttel.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("TIPO:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"FIADOR", "INVERSIONISTA", "PRESTAMISTA"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		panel_1.add(comboBox, gbc_comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {40, 10, 40};
		gbl_panel_2.rowHeights = new int[] {30, 0, 30};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0};
		panel_2.setLayout(gbl_panel_2);
		
		Bace = new JButton("ACEPTAR");
		GridBagConstraints gbc_Bace = new GridBagConstraints();
		gbc_Bace.anchor = GridBagConstraints.NORTHWEST;
		gbc_Bace.insets = new Insets(0, 0, 0, 5);
		gbc_Bace.gridx = 0;
		gbc_Bace.gridy = 1;
		panel_2.add(Bace, gbc_Bace);
		Bace.addActionListener(this);
		
		Bcan = new JButton("CANCELAR");
		GridBagConstraints gbc_Bcan = new GridBagConstraints();
		gbc_Bcan.anchor = GridBagConstraints.NORTHWEST;
		gbc_Bcan.gridx = 3;
		gbc_Bcan.gridy = 1;
		panel_2.add(Bcan, gbc_Bcan);
		Bcan.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==Bace) { 
			if(txtnom.getText().isBlank()||txtced.getText().isBlank()||txtdir.getText().isBlank()||txttel.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "campos incompletos");
			}
			else {
				DataBase DB = null;
				try {
					String tip=null;
					DB = new DataBase();
					if (comboBox.getSelectedItem().toString().compareTo("FIADOR")==0) {
						tip="F";
					}
					else if (comboBox.getSelectedItem().toString().compareTo("INVERSIONISTA")==0) {
						tip="I";
					}
					else {
						tip="P";
					}
					if (DB.findCliente(txtced.getText(), tip)) {
						JOptionPane.showMessageDialog(null, "cliente ya existente");
					}
					else {
						//DB.insertpersona(txtnom.getText(), txtced.getText());
						DB.insertcliente(txtnom.getText(), txtced.getText(), txtdir.getText(), txttel.getText(), tip);
						JOptionPane.showMessageDialog(null, "cliente registrado con exito");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource()==Bcan) {
			Ingreso ing = new Ingreso(actualusu);
			ing.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}

}
