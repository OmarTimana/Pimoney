package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import pimoney.DataBase;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Color;

public class ConsulPrestamo implements ActionListener{

	JFrame frame;
	
	private JButton Bacep;
	private JButton Bcanc;
	private JButton Bcan;
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
					ConsulPrestamo window = new ConsulPrestamo("usuario", "tipo",test )   ;
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ConsulPrestamo(String usu, String tip, String[] dat){
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
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(){
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setTitle("CONSULTAR PRESTAMO");
		frame.setBounds(100, 100, 474, 303);
		frame.setTitle("CONSULTA DE PRESTAMOS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel USUARIO = new JPanel();
		USUARIO.setBackground(new Color(0, 255, 204));
		GridBagConstraints gbc_USUARIO = new GridBagConstraints();
		gbc_USUARIO.insets = new Insets(0, 0, 5, 0);
		gbc_USUARIO.fill = GridBagConstraints.BOTH;
		gbc_USUARIO.gridx = 0;
		gbc_USUARIO.gridy = 0;
		frame.getContentPane().add(USUARIO, gbc_USUARIO);
		GridBagLayout gbl_USUARIO = new GridBagLayout();
		gbl_USUARIO.columnWidths = new int[] {90, 90};
		gbl_USUARIO.rowHeights = new int[] {30};
		gbl_USUARIO.columnWeights = new double[]{0.0, 0.0};
		gbl_USUARIO.rowWeights = new double[]{0.0};
		USUARIO.setLayout(gbl_USUARIO);
		
		JLabel lbltipo = new JLabel(tipo);
		GridBagConstraints gbc_lbltipo = new GridBagConstraints();
		gbc_lbltipo.insets = new Insets(0, 0, 5, 5);
		gbc_lbltipo.gridx = 0;
		gbc_lbltipo.gridy = 0;
		USUARIO.add(lbltipo, gbc_lbltipo);
		
		JLabel lblusua = new JLabel(usuario);
		GridBagConstraints gbc_lblusua = new GridBagConstraints();
		gbc_lblusua.insets = new Insets(0, 0, 5, 0);
		gbc_lblusua.gridx = 1;
		gbc_lblusua.gridy = 0;
		USUARIO.add(lblusua, gbc_lblusua);
		
		JPanel DATOS = new JPanel();
		DATOS.setBackground(new Color(51, 102, 255));
		GridBagConstraints gbc_DATOS = new GridBagConstraints();
		gbc_DATOS.insets = new Insets(0, 0, 5, 0);
		gbc_DATOS.fill = GridBagConstraints.BOTH;
		gbc_DATOS.gridx = 0;
		gbc_DATOS.gridy = 1;
		frame.getContentPane().add(DATOS, gbc_DATOS);
		GridBagLayout gbl_DATOS = new GridBagLayout();
		gbl_DATOS.columnWidths = new int[] {65, 65, 65, 65};
		gbl_DATOS.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gbl_DATOS.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_DATOS.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		DATOS.setLayout(gbl_DATOS);
		
		JLabel Lcod = new JLabel("CODIGO:");
		GridBagConstraints gbc_Lcod = new GridBagConstraints();
		gbc_Lcod.insets = new Insets(0, 0, 5, 5);
		gbc_Lcod.gridx = 0;
		gbc_Lcod.gridy = 0;
		DATOS.add(Lcod, gbc_Lcod);
		
		JLabel lblcod = new JLabel(datos[0]);
		GridBagConstraints gbc_lblcod = new GridBagConstraints();
		gbc_lblcod.insets = new Insets(0, 0, 5, 5);
		gbc_lblcod.gridx = 1;
		gbc_lblcod.gridy = 0;
		DATOS.add(lblcod, gbc_lblcod);
		
		JLabel Ldini = new JLabel("FECHA DE INICIO:");
		GridBagConstraints gbc_Ldini = new GridBagConstraints();
		gbc_Ldini.insets = new Insets(0, 0, 5, 5);
		gbc_Ldini.gridx = 2;
		gbc_Ldini.gridy = 0;
		DATOS.add(Ldini, gbc_Ldini);
		
		JLabel lblini = new JLabel(datos[2]);
		GridBagConstraints gbc_lblini = new GridBagConstraints();
		gbc_lblini.insets = new Insets(0, 0, 5, 0);
		gbc_lblini.gridx = 3;
		gbc_lblini.gridy = 0;
		DATOS.add(lblini, gbc_lblini);
		
		JLabel Lnom = new JLabel("PRESTAMISTA:");
		GridBagConstraints gbc_Lnom = new GridBagConstraints();
		gbc_Lnom.insets = new Insets(0, 0, 5, 5);
		gbc_Lnom.gridx = 0;
		gbc_Lnom.gridy = 1;
		DATOS.add(Lnom, gbc_Lnom);
		
		JLabel lblnom = new JLabel(datos[1]);
		GridBagConstraints gbc_lblnom = new GridBagConstraints();
		gbc_lblnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblnom.gridx = 1;
		gbc_lblnom.gridy = 1;
		DATOS.add(lblnom, gbc_lblnom);
		
		JLabel Ldter = new JLabel("FECHA DE TERMINO");
		GridBagConstraints gbc_Ldter = new GridBagConstraints();
		gbc_Ldter.insets = new Insets(0, 0, 5, 5);
		gbc_Ldter.gridx = 2;
		gbc_Ldter.gridy = 1;
		DATOS.add(Ldter, gbc_Ldter);
		
		JLabel lblter = new JLabel(datos[3]);
		GridBagConstraints gbc_lblter = new GridBagConstraints();
		gbc_lblter.insets = new Insets(0, 0, 5, 0);
		gbc_lblter.gridx = 3;
		gbc_lblter.gridy = 1;
		DATOS.add(lblter, gbc_lblter);
		
		JLabel Lfia = new JLabel("FIADOR");
		GridBagConstraints gbc_Lfia = new GridBagConstraints();
		gbc_Lfia.insets = new Insets(0, 0, 5, 5);
		gbc_Lfia.gridx = 0;
		gbc_Lfia.gridy = 2;
		DATOS.add(Lfia, gbc_Lfia);
		
		JLabel lblfia = new JLabel(datos[8]);
		GridBagConstraints gbc_lblfia = new GridBagConstraints();
		gbc_lblfia.insets = new Insets(0, 0, 5, 5);
		gbc_lblfia.gridx = 1;
		gbc_lblfia.gridy = 2;
		DATOS.add(lblfia, gbc_lblfia);
		
		JLabel Ldapr = new JLabel("FECHA DE APROBACION");
		GridBagConstraints gbc_Ldapr = new GridBagConstraints();
		gbc_Ldapr.insets = new Insets(0, 0, 5, 5);
		gbc_Ldapr.gridx = 2;
		gbc_Ldapr.gridy = 2;
		DATOS.add(Ldapr, gbc_Ldapr);
		
		JLabel lblapr = new JLabel(datos[7]);
		GridBagConstraints gbc_lblapr = new GridBagConstraints();
		gbc_lblapr.insets = new Insets(0, 0, 5, 0);
		gbc_lblapr.gridx = 3;
		gbc_lblapr.gridy = 2;
		DATOS.add(lblapr, gbc_lblapr);
		
		JLabel lblNewLabel_2 = new JLabel("ESTADO");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		DATOS.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblest = new JLabel(datos[10]);
		GridBagConstraints gbc_lblest = new GridBagConstraints();
		gbc_lblest.insets = new Insets(0, 0, 5, 5);
		gbc_lblest.gridx = 1;
		gbc_lblest.gridy = 3;
		DATOS.add(lblest, gbc_lblest);
		
		JLabel Ldsol = new JLabel("FECHA DE SOLICITUD");
		GridBagConstraints gbc_Ldsol = new GridBagConstraints();
		gbc_Ldsol.insets = new Insets(0, 0, 5, 5);
		gbc_Ldsol.gridx = 2;
		gbc_Ldsol.gridy = 3;
		DATOS.add(Ldsol, gbc_Ldsol);
		
		JLabel lblsol = new JLabel(datos[6]);
		GridBagConstraints gbc_lblsol = new GridBagConstraints();
		gbc_lblsol.insets = new Insets(0, 0, 5, 0);
		gbc_lblsol.gridx = 3;
		gbc_lblsol.gridy = 3;
		DATOS.add(lblsol, gbc_lblsol);
		
		JLabel Lgar = new JLabel("GARANTIA:");
		GridBagConstraints gbc_Lgar = new GridBagConstraints();
		gbc_Lgar.insets = new Insets(0, 0, 5, 5);
		gbc_Lgar.gridx = 0;
		gbc_Lgar.gridy = 5;
		DATOS.add(Lgar, gbc_Lgar);
		
		JLabel lblgar = new JLabel(datos[9]);
		GridBagConstraints gbc_lblgar = new GridBagConstraints();
		gbc_lblgar.insets = new Insets(0, 0, 5, 5);
		gbc_lblgar.gridx = 1;
		gbc_lblgar.gridy = 5;
		DATOS.add(lblgar, gbc_lblgar);
		
		JLabel lblNewLabel = new JLabel("MONTO:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 5;
		DATOS.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblmon = new JLabel(datos[4]);
		GridBagConstraints gbc_lblmon = new GridBagConstraints();
		gbc_lblmon.insets = new Insets(0, 0, 5, 0);
		gbc_lblmon.gridx = 3;
		gbc_lblmon.gridy = 5;
		DATOS.add(lblmon, gbc_lblmon);
		
		Bcrono = new JButton("CRONOGRAMA");
		GridBagConstraints gbc_Bcrono = new GridBagConstraints();
		gbc_Bcrono.gridwidth = 2;
		gbc_Bcrono.insets = new Insets(0, 0, 0, 5);
		gbc_Bcrono.gridx = 0;
		gbc_Bcrono.gridy = 6;
		DATOS.add(Bcrono, gbc_Bcrono);
		Bcrono.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("TASA DE INTERES:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 6;
		DATOS.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lbltas = new JLabel(datos[5]);
		GridBagConstraints gbc_lbltas = new GridBagConstraints();
		gbc_lbltas.gridx = 3;
		gbc_lbltas.gridy = 6;
		DATOS.add(lbltas, gbc_lbltas);
		
		JPanel EVALUAR = new JPanel();
		EVALUAR.setBackground(Color.GREEN);
		GridBagConstraints gbc_EVALUAR = new GridBagConstraints();
		gbc_EVALUAR.fill = GridBagConstraints.BOTH;
		gbc_EVALUAR.gridx = 0;
		gbc_EVALUAR.gridy = 2;
		frame.getContentPane().add(EVALUAR, gbc_EVALUAR);
		GridBagLayout gbl_EVALUAR = new GridBagLayout();
		gbl_EVALUAR.columnWidths = new int[] {0, 0, 130};
		gbl_EVALUAR.rowHeights = new int[] {0};
		gbl_EVALUAR.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_EVALUAR.rowWeights = new double[]{0.0};
		EVALUAR.setLayout(gbl_EVALUAR);
		
		Bacep = new JButton("ACEPTAR PRESTAMO");
		GridBagConstraints gbc_Bacep = new GridBagConstraints();
		gbc_Bacep.fill = GridBagConstraints.HORIZONTAL;
		gbc_Bacep.insets = new Insets(0, 0, 0, 5);
		gbc_Bacep.gridx = 0;
		gbc_Bacep.gridy = 0;
		EVALUAR.add(Bacep, gbc_Bacep);
		if(tipo.compareTo("Auxiliar de credito")==0) {
			Bacep.setEnabled(false);
		}
		Bacep.addActionListener(this);
		
		
		Bcanc = new JButton("RECHAZAR PRESTAMO");
		GridBagConstraints gbc_Bcanc = new GridBagConstraints();
		gbc_Bcanc.fill = GridBagConstraints.HORIZONTAL;
		gbc_Bcanc.insets = new Insets(0, 0, 0, 5);
		gbc_Bcanc.gridx = 1;
		gbc_Bcanc.gridy = 0;
		EVALUAR.add(Bcanc, gbc_Bcanc);
		if(tipo.compareTo("Auxiliar de credito")==0) {
			Bcanc.setEnabled(false);
		}
		Bcanc.addActionListener(this);
		
		
		Bcan = new JButton("CANCELAR");
		GridBagConstraints gbc_Bcan = new GridBagConstraints();
		gbc_Bcan.fill = GridBagConstraints.HORIZONTAL;
		gbc_Bcan.gridx = 2;
		gbc_Bcan.gridy = 0;
		EVALUAR.add(Bcan, gbc_Bcan);
		Bcan.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DataBase DB;
		if(e.getSource()==Bacep) {
			try {
				DB=new DataBase();
				DB.EPA(datos[0]);
				JOptionPane.showMessageDialog(null, "prestamo Aprobado");
				Ingreso ig=new Ingreso(usuario);
				this.frame.setVisible(false);
				ig.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Bcanc) {
			try {
				DB=new DataBase();
				DB.EPR(datos[0]);
				JOptionPane.showMessageDialog(null, "prestamo Rechazado");
				Ingreso ig=new Ingreso(usuario);
				this.frame.setVisible(false);
				ig.frame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Bcrono) {
			Cronogramas cro=new Cronogramas(datos[0], "p", usuario, tipo, datos);
			this.frame.setVisible(false);
			cro.frame.setVisible(true);
		}
		if(e.getSource()==Bcan) {
			Ingreso ig=new Ingreso(usuario);
			this.frame.setVisible(false);
			ig.frame.setVisible(true);
		}
	}

}
