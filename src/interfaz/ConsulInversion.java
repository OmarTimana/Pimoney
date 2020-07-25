package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pimoney.DataBase;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;

public class ConsulInversion implements ActionListener{

	JFrame frame;
	
	private JButton Bcan;
	private JButton Bace;
	private JButton Bcance;
	private JButton Bcrono;
	
	private String usuario;
	private String tipo;
	private String[] datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] test= {"1","2"};
					ConsulInversion window = new ConsulInversion("usuario", "tipo",test);
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
	public ConsulInversion(String usu, String tip, String[] dat) {
		usuario=usu;
		datos=dat;
		if(tip.compareTo("A")==0) {
			tipo="Auxiliar de credito";
		}
		else {
			tipo="Jefe de credito";
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setTitle("CONSULTAR INVERSION");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {30, 100, 50};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel usuario = new JPanel();
		usuario.setBackground(new Color(0, 255, 204));
		GridBagConstraints gbc_usuario = new GridBagConstraints();
		gbc_usuario.insets = new Insets(0, 0, 5, 0);
		gbc_usuario.fill = GridBagConstraints.BOTH;
		gbc_usuario.gridx = 0;
		gbc_usuario.gridy = 0;
		frame.getContentPane().add(usuario, gbc_usuario);
		GridBagLayout gbl_usuario = new GridBagLayout();
		gbl_usuario.columnWidths = new int[] {90, 90};
		gbl_usuario.rowHeights = new int[] {30};
		gbl_usuario.columnWeights = new double[]{0.0, 0.0};
		gbl_usuario.rowWeights = new double[]{0.0};
		usuario.setLayout(gbl_usuario);
		
		JLabel lbltipo = new JLabel(tipo);
		GridBagConstraints gbc_lbltipo = new GridBagConstraints();
		gbc_lbltipo.insets = new Insets(0, 0, 5, 5);
		gbc_lbltipo.gridx = 0;
		gbc_lbltipo.gridy = 0;
		usuario.add(lbltipo, gbc_lbltipo);
		
		JLabel lblusua = new JLabel(this.usuario);
		GridBagConstraints gbc_lblusua = new GridBagConstraints();
		gbc_lblusua.insets = new Insets(0, 0, 5, 0);
		gbc_lblusua.gridx = 1;
		gbc_lblusua.gridy = 0;
		usuario.add(lblusua, gbc_lblusua);
		
		JPanel datos = new JPanel();
		datos.setBackground(new Color(51, 102, 255));
		GridBagConstraints gbc_datos = new GridBagConstraints();
		gbc_datos.insets = new Insets(0, 0, 5, 0);
		gbc_datos.fill = GridBagConstraints.BOTH;
		gbc_datos.gridx = 0;
		gbc_datos.gridy = 1;
		frame.getContentPane().add(datos, gbc_datos);
		GridBagLayout gbl_datos = new GridBagLayout();
		gbl_datos.columnWidths = new int[] {65, 65, 65, 65};
		gbl_datos.rowHeights = new int[] {0, 0, 30, 0, 0};
		gbl_datos.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_datos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		datos.setLayout(gbl_datos);
		
		JLabel lblNewLabel_2 = new JLabel("CODIGO:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		datos.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblcod = new JLabel(this.datos[0]);
		GridBagConstraints gbc_lblcod = new GridBagConstraints();
		gbc_lblcod.insets = new Insets(0, 0, 5, 5);
		gbc_lblcod.gridx = 1;
		gbc_lblcod.gridy = 0;
		datos.add(lblcod, gbc_lblcod);
		
		JLabel lblNewLabel_10 = new JLabel("FECHA DE INICIO:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 0;
		datos.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblini = new JLabel(this.datos[2]);
		GridBagConstraints gbc_lblini = new GridBagConstraints();
		gbc_lblini.insets = new Insets(0, 0, 5, 0);
		gbc_lblini.gridx = 3;
		gbc_lblini.gridy = 0;
		datos.add(lblini, gbc_lblini);
		
		JLabel lblNewLabel_4 = new JLabel("INVERSIONISTA:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		datos.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblinv = new JLabel(this.datos[1]);
		GridBagConstraints gbc_lblinv = new GridBagConstraints();
		gbc_lblinv.insets = new Insets(0, 0, 5, 5);
		gbc_lblinv.gridx = 1;
		gbc_lblinv.gridy = 1;
		datos.add(lblinv, gbc_lblinv);
		
		JLabel lblNewLabel_11 = new JLabel("FECHA DE TERMINO:");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 2;
		gbc_lblNewLabel_11.gridy = 1;
		datos.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JLabel lblter = new JLabel(this.datos[3]);
		GridBagConstraints gbc_lblter = new GridBagConstraints();
		gbc_lblter.insets = new Insets(0, 0, 5, 0);
		gbc_lblter.gridx = 3;
		gbc_lblter.gridy = 1;
		datos.add(lblter, gbc_lblter);
		
		JLabel lblNewLabel_1 = new JLabel("CNT. BANCARIA");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		datos.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblcnt = new JLabel(this.datos[7]);
		GridBagConstraints gbc_lblcnt = new GridBagConstraints();
		gbc_lblcnt.insets = new Insets(0, 0, 5, 5);
		gbc_lblcnt.gridx = 1;
		gbc_lblcnt.gridy = 2;
		datos.add(lblcnt, gbc_lblcnt);
		
		JLabel lblNewLabel = new JLabel("ESTADO");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		datos.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblest = new JLabel(this.datos[6]);
		GridBagConstraints gbc_lblest = new GridBagConstraints();
		gbc_lblest.insets = new Insets(0, 0, 5, 0);
		gbc_lblest.gridx = 3;
		gbc_lblest.gridy = 2;
		datos.add(lblest, gbc_lblest);
		
		JLabel lblNewLabel_5 = new JLabel("MONTO:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		datos.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblmon = new JLabel(this.datos[4]);
		GridBagConstraints gbc_lblmon = new GridBagConstraints();
		gbc_lblmon.insets = new Insets(0, 0, 5, 5);
		gbc_lblmon.gridx = 1;
		gbc_lblmon.gridy = 3;
		datos.add(lblmon, gbc_lblmon);
		
		Bcrono = new JButton("CRONOGRAMA");
		GridBagConstraints gbc_Bcrono = new GridBagConstraints();
		gbc_Bcrono.gridwidth = 2;
		gbc_Bcrono.gridheight = 2;
		gbc_Bcrono.gridx = 2;
		gbc_Bcrono.gridy = 3;
		datos.add(Bcrono, gbc_Bcrono);
		Bcrono.addActionListener(this);
		
		JLabel lblNewLabel_6 = new JLabel("TASA DE INTERES:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 4;
		datos.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lbltas = new JLabel(this.datos[5]);
		GridBagConstraints gbc_lbltas = new GridBagConstraints();
		gbc_lbltas.insets = new Insets(0, 0, 0, 5);
		gbc_lbltas.gridx = 1;
		gbc_lbltas.gridy = 4;
		datos.add(lbltas, gbc_lbltas);
		
		JPanel evaluar = new JPanel();
		evaluar.setBackground(Color.GREEN);
		GridBagConstraints gbc_evaluar = new GridBagConstraints();
		gbc_evaluar.fill = GridBagConstraints.BOTH;
		gbc_evaluar.gridx = 0;
		gbc_evaluar.gridy = 2;
		frame.getContentPane().add(evaluar, gbc_evaluar);
		GridBagLayout gbl_evaluar = new GridBagLayout();
		gbl_evaluar.columnWidths = new int[] {0, 0, 130};
		gbl_evaluar.rowHeights = new int[] {0};
		gbl_evaluar.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_evaluar.rowWeights = new double[]{0.0};
		evaluar.setLayout(gbl_evaluar);
		
		Bace = new JButton("ACEPTAR INVERSION");
		GridBagConstraints gbc_Bace = new GridBagConstraints();
		gbc_Bace.insets = new Insets(0, 0, 0, 5);
		gbc_Bace.gridx = 0;
		gbc_Bace.gridy = 0;
		evaluar.add(Bace, gbc_Bace);
		if(tipo.compareTo("Auxiliar de credito")==0) {
			Bace.setEnabled(false);
		}
		Bace.addActionListener(this);
		
		Bcan = new JButton("RECHAZAR INVERSION");
		GridBagConstraints gbc_Bcan = new GridBagConstraints();
		gbc_Bcan.insets = new Insets(0, 0, 0, 5);
		gbc_Bcan.gridx = 1;
		gbc_Bcan.gridy = 0;
		evaluar.add(Bcan, gbc_Bcan);
		if(tipo.compareTo("Auxiliar de credito")==0) {
			Bcan.setEnabled(false);
		}
		Bcan.addActionListener(this);
		
		Bcance = new JButton("CANCELAR");
		GridBagConstraints gbc_Bcance = new GridBagConstraints();
		gbc_Bcance.fill = GridBagConstraints.HORIZONTAL;
		gbc_Bcance.gridx = 2;
		gbc_Bcance.gridy = 0;
		evaluar.add(Bcance, gbc_Bcance);
		Bcance.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DataBase DB;
		if(e.getSource()==Bace) {
			try {
				DB=new DataBase();
				DB.EIA(datos[0]);
				JOptionPane.showMessageDialog(null, "inversion Aprobada");
				Ingreso ig=new Ingreso(usuario);
				this.frame.setVisible(false);
				ig.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Bcan) {
			try {
				DB=new DataBase();
				DB.EIR(datos[0]);
				JOptionPane.showMessageDialog(null, "inversion Rechazada");
				Ingreso ig=new Ingreso(usuario);
				this.frame.setVisible(false);
				ig.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Bcrono) {
			Cronogramas cro=new Cronogramas(datos[0], "i", usuario, tipo, datos);
			this.frame.setVisible(false);
			cro.frame.setVisible(true);
		}
		if(e.getSource()==Bace) {
			Ingreso ig=new Ingreso(usuario);
			this.frame.setVisible(false);
			ig.frame.setVisible(true);
		}
		if(e.getSource()==Bcance) {
			Ingreso ig=new Ingreso(usuario);
			this.frame.setVisible(false);
			ig.frame.setVisible(true);
		}
	}

}
