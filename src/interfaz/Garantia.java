package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import pimoney.DataBase;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Garantia implements ActionListener{

	JFrame frame;
	private JTextField txtval;
	private JTextField txtubi;
	
	private JButton Bcan;
	private JButton Bace;
	private JComboBox cbb;
	
	String[] datos=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Garantia window = new Garantia();
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
	public Garantia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setTitle("REGISTRO DE GARANTIA");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[] {200, 60};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100, 0, 10};
		gbl_panel.rowHeights = new int[] {30, 30, 30};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("TIPO:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cbb = new JComboBox();
		cbb.setModel(new DefaultComboBoxModel(new String[] {"VEHICULO", "INMUEBLE", "TERRENO"}));
		GridBagConstraints gbc_cbb = new GridBagConstraints();
		gbc_cbb.insets = new Insets(0, 0, 5, 0);
		gbc_cbb.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbb.gridx = 1;
		gbc_cbb.gridy = 0;
		panel.add(cbb, gbc_cbb);
		
		JLabel lblNewLabel_2 = new JLabel("VALOR:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtval = new JTextField();
		GridBagConstraints gbc_txtval = new GridBagConstraints();
		gbc_txtval.insets = new Insets(0, 0, 5, 0);
		gbc_txtval.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtval.gridx = 1;
		gbc_txtval.gridy = 1;
		panel.add(txtval, gbc_txtval);
		txtval.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("UBICACION:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtubi = new JTextField();
		GridBagConstraints gbc_txtubi = new GridBagConstraints();
		gbc_txtubi.insets = new Insets(0, 0, 5, 0);
		gbc_txtubi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtubi.gridx = 1;
		gbc_txtubi.gridy = 2;
		panel.add(txtubi, gbc_txtubi);
		txtubi.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {150, 50, 150};
		gbl_panel_1.rowHeights = new int[] {30};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0};
		panel_1.setLayout(gbl_panel_1);
		
		Bace = new JButton("ACEPTAR");
		GridBagConstraints gbc_Bace = new GridBagConstraints();
		gbc_Bace.fill = GridBagConstraints.BOTH;
		gbc_Bace.insets = new Insets(0, 0, 0, 5);
		gbc_Bace.gridx = 0;
		gbc_Bace.gridy = 0;
		panel_1.add(Bace, gbc_Bace);
		Bace.addActionListener(this);
		
		Bcan = new JButton("CANCELAR");
		GridBagConstraints gbc_Bcan = new GridBagConstraints();
		gbc_Bcan.fill = GridBagConstraints.BOTH;
		gbc_Bcan.gridx = 2;
		gbc_Bcan.gridy = 0;
		panel_1.add(Bcan, gbc_Bcan);
		Bcan.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Bace) {
			if(noempty()) {
				try {
					Double val=Double.parseDouble(txtval.getText());
					String[] dat= {cbb.getSelectedItem().toString(),txtval.getText(), txtubi.getText()};
					datos=dat;
					this.frame.setVisible(false);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "valor incorrecto");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "campos incompletos");
			}
		}
		if(e.getSource()==Bcan) {
			this.frame.setVisible(false);
		}
	}
	
	public boolean noempty() {
		boolean res=true;
		try {
			if(txtval.getText().isBlank()||txtubi.getText().isBlank()) {
				res=false;
			}
		}catch(Exception e){
			res=false;
		}
		return res;
	}

}
