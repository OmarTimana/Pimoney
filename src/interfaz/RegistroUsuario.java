package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import pimoney.DataBase;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;

public class RegistroUsuario implements ActionListener{

	JFrame frmusu;
	private JTextField txtnom;
	private JTextField txtced;
	private JTextField txtusu;
	private JPasswordField txtcon;
	private JPasswordField txtvco;
	private JButton bcan;
	private JButton bace;
	private JRadioButton RBjef;
	private JRadioButton RBaux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario window = new RegistroUsuario();
					window.frmusu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmusu = new JFrame();
		frmusu.getContentPane().setBackground(Color.GRAY);
		frmusu.setBounds(100, 100, 416, 397);
		frmusu.setTitle("Registro usuario");
		frmusu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {160, 60, 160, 80};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		frmusu.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmusu.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {120, 260, 10};
		gbl_panel.rowHeights = new int[] {20, 20};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtnom = new JTextField();
		GridBagConstraints gbc_txtnom = new GridBagConstraints();
		gbc_txtnom.insets = new Insets(0, 0, 5, 0);
		gbc_txtnom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnom.gridx = 1;
		gbc_txtnom.gridy = 0;
		panel.add(txtnom, gbc_txtnom);
		txtnom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CEDULA");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtced = new JTextField();
		GridBagConstraints gbc_txtced = new GridBagConstraints();
		gbc_txtced.insets = new Insets(0, 0, 5, 0);
		gbc_txtced.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtced.gridx = 1;
		gbc_txtced.gridy = 1;
		panel.add(txtced, gbc_txtced);
		txtced.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frmusu.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {70, 60, 30, 0, 30};
		gbl_panel_1.rowHeights = new int[] {0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TIPO");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		RBaux = new JRadioButton("Aux. Credito");
		RBaux.setBackground(new Color(51, 102, 255));
		RBaux.setSelected(true);
		GridBagConstraints gbc_RBaux = new GridBagConstraints();
		gbc_RBaux.insets = new Insets(0, 0, 0, 5);
		gbc_RBaux.gridx = 2;
		gbc_RBaux.gridy = 0;
		panel_1.add(RBaux, gbc_RBaux);
		
		RBjef = new JRadioButton("Jefe Credito");
		RBjef.setBackground(new Color(51, 102, 255));
		GridBagConstraints gbc_RBjef = new GridBagConstraints();
		gbc_RBjef.insets = new Insets(0, 0, 0, 5);
		gbc_RBjef.gridx = 3;
		gbc_RBjef.gridy = 0;
		panel_1.add(RBjef, gbc_RBjef);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(RBjef);
		bg.add(RBaux);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		frmusu.getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {120, 260, 30};
		gbl_panel_2.rowHeights = new int[] {20, 20, 20};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("USUARIO");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtusu = new JTextField();
		GridBagConstraints gbc_txtusu = new GridBagConstraints();
		gbc_txtusu.insets = new Insets(0, 0, 5, 0);
		gbc_txtusu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtusu.gridx = 1;
		gbc_txtusu.gridy = 0;
		panel_2.add(txtusu, gbc_txtusu);
		txtusu.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CONTRASE\u00D1A");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtcon = new JPasswordField();
		GridBagConstraints gbc_txtcon = new GridBagConstraints();
		gbc_txtcon.insets = new Insets(0, 0, 5, 0);
		gbc_txtcon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcon.gridx = 1;
		gbc_txtcon.gridy = 1;
		panel_2.add(txtcon, gbc_txtcon);
		
		JLabel lblNewLabel_5 = new JLabel("VER. CONTRASE\u00D1A");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtvco = new JPasswordField();
		GridBagConstraints gbc_txtvco = new GridBagConstraints();
		gbc_txtvco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtvco.gridx = 1;
		gbc_txtvco.gridy = 2;
		panel_2.add(txtvco, gbc_txtvco);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		frmusu.getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {0, 50, 50};
		gbl_panel_3.rowHeights = new int[] {30};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_3.rowWeights = new double[]{0.0};
		panel_3.setLayout(gbl_panel_3);
		
		bace = new JButton("ACEPTAR");
		GridBagConstraints gbc_bace = new GridBagConstraints();
		gbc_bace.insets = new Insets(0, 0, 0, 5);
		gbc_bace.gridx = 0;
		gbc_bace.gridy = 0;
		panel_3.add(bace, gbc_bace);
		bace.addActionListener(this);
		
		bcan = new JButton("CANCELAR");
		GridBagConstraints gbc_bcan = new GridBagConstraints();
		gbc_bcan.gridx = 2;
		gbc_bcan.gridy = 0;
		panel_3.add(bcan, gbc_bcan);
		bcan.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==bace) {//aceptar
			if (txtnom.getText().isBlank()||txtced.getText().isBlank()||txtusu.getText().isBlank()||txtcon.getText().isBlank()||txtvco.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "campos incompletos");
			}
			else if (txtcon.getText().compareTo(txtvco.getText())!=0) {
				JOptionPane.showMessageDialog(null, "las contraseñas no coinciden");
			}
			else {
				try {
					String tip=null;
					if(RBaux.isSelected()) {
						tip="A";
					}
					else if(RBjef.isSelected()) {
						tip="J";
					}
					DataBase DB =new DataBase();
					if(DB.findusuarioR(txtusu.getText())) {
						JOptionPane.showMessageDialog(null, "Usuario ya existente");
					}
					else {
						DB.insertusuario(txtusu.getText(), tip, txtcon.getText(), txtced.getText(), txtnom.getText());
						JOptionPane.showMessageDialog(null, "usuario registrado");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource()==bcan) {//cancelar
			Login log = new Login();
			log.frmLogin.setVisible(true);
			frmusu.setVisible(false);
		}
	}
}
