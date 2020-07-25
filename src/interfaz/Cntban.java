package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import pimoney.DataBase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cntban implements ActionListener{

	JFrame frame;
	private JTextField txtcnt;
	private JTextField txtban;
	private JTextField txttip;
	
	private JButton Bace;
	private JButton Bcan;
	
	public String datos[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cntban window = new Cntban();
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
	public Cntban() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("REGISTRO DE CUENTA BANCARIA");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {170, 60};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {141, 0, 10};
		gbl_panel.rowHeights = new int[] {10};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("NUMERO DE CUENTA");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtcnt = new JTextField();
		GridBagConstraints gbc_txtcnt = new GridBagConstraints();
		gbc_txtcnt.insets = new Insets(0, 0, 5, 0);
		gbc_txtcnt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtcnt.gridx = 1;
		gbc_txtcnt.gridy = 0;
		panel.add(txtcnt, gbc_txtcnt);
		txtcnt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("BANCO");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtban = new JTextField();
		GridBagConstraints gbc_txtban = new GridBagConstraints();
		gbc_txtban.insets = new Insets(0, 0, 5, 0);
		gbc_txtban.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtban.gridx = 1;
		gbc_txtban.gridy = 1;
		panel.add(txtban, gbc_txtban);
		txtban.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("TIPO DE CUENTA");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txttip = new JTextField();
		GridBagConstraints gbc_txttip = new GridBagConstraints();
		gbc_txttip.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttip.gridx = 1;
		gbc_txttip.gridy = 2;
		panel.add(txttip, gbc_txttip);
		txttip.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 50, 0};
		gbl_panel_1.rowHeights = new int[] {0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0};
		panel_1.setLayout(gbl_panel_1);
		
		Bace = new JButton("ACEPTAR");
		GridBagConstraints gbc_Bace = new GridBagConstraints();
		gbc_Bace.insets = new Insets(0, 0, 0, 5);
		gbc_Bace.gridx = 0;
		gbc_Bace.gridy = 0;
		panel_1.add(Bace, gbc_Bace);
		Bace.addActionListener(this);
		
		Bcan = new JButton("REGRESAR");
		GridBagConstraints gbc_Bcan = new GridBagConstraints();
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
					DataBase DB=new DataBase();
					int val=Integer.parseInt(txtcnt.getText());
					if(DB.findcnt(val)) {
						JOptionPane.showMessageDialog(null, "cuenta bancaria ya existente en el sistema");
					}
					else {
						String[] dat= {txtcnt.getText(),txtban.getText(), txttip.getText()};
						datos=dat;
						this.frame.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "numero de cuenta incorrecto");
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
			if(txtcnt.getText().isBlank()||txtban.getText().isBlank()||txttip.getText().isBlank()) {
				res=false;
			}
		}catch(Exception e){
			res=false;
		}
		return res;
	}
}
