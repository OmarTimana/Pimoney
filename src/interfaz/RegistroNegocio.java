package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.postgresql.util.PSQLException;

import com.toedter.calendar.JDateChooser;

import pimoney.DataBase;
import pimoney.Inversion;

public class RegistroNegocio implements ActionListener{

	JFrame frame;
	JFrame Garantia;
	private JTextField PTXTMONTO;
	private JTextField PTXTTASA;
	private JTextField PTXTCLIENTE;
	private JTextField ITXTMONTO;
	private JTextField ITXTTASA;
	private JTextField ITXTCLIENTE;
	
	private JButton PACEPTAR;
	private JButton PCANCELAR;
	private JButton IACEPTAR;
	private JButton ICANCELAR;
	private JButton BCNT;
	private JButton Bfia;
	private JButton Bgar;
	
	private JDateChooser PDATEINI;
	private JDateChooser PDATETER;
	private JDateChooser PDATESOL;
	private JDateChooser PDATEAPRO;
	private JDateChooser IDATEINI;
	private JDateChooser IDATETER;
	
	private String fiador="";
	private String[] garantia=null;
	private String[] cuentaban=null;
	public String actualusu;
	
	
	private Garantia gar;
	private Cntban cnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroNegocio window = new RegistroNegocio("USUARIO");
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
	public RegistroNegocio(String a) {
		actualusu=a;
		gar=new Garantia();
		cnt=new Cntban();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 554, 407);
		frame.setTitle("REGISTRO NEGOCIO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel PRESTAMO = new JPanel();
		PRESTAMO.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("PRESTAMO", null, PRESTAMO, null);
		GridBagLayout gbl_PRESTAMO = new GridBagLayout();
		gbl_PRESTAMO.columnWidths = new int[] {542};
		gbl_PRESTAMO.rowHeights = new int[] {170, 130, 60};
		gbl_PRESTAMO.columnWeights = new double[]{0.0};
		gbl_PRESTAMO.rowWeights = new double[]{0.0, 0.0, 0.0};
		PRESTAMO.setLayout(gbl_PRESTAMO);
		
		JPanel FECHAS_P = new JPanel();
		FECHAS_P.setBackground(new Color(102, 204, 204));
		GridBagConstraints gbc_FECHAS_P = new GridBagConstraints();
		gbc_FECHAS_P.fill = GridBagConstraints.BOTH;
		gbc_FECHAS_P.insets = new Insets(0, 0, 5, 0);
		gbc_FECHAS_P.gridx = 0;
		gbc_FECHAS_P.gridy = 0;
		PRESTAMO.add(FECHAS_P, gbc_FECHAS_P);
		GridBagLayout gbl_FECHAS_P = new GridBagLayout();
		gbl_FECHAS_P.columnWidths = new int[] {233, 286, 10};
		gbl_FECHAS_P.rowHeights = new int[] {28, 28, 28, 28};
		gbl_FECHAS_P.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_FECHAS_P.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		FECHAS_P.setLayout(gbl_FECHAS_P);
		
		JLabel label = new JLabel("FECHA INICIO");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		FECHAS_P.add(label, gbc_label);
		
		PDATEINI = new JDateChooser();
		GridBagConstraints gbc_PDATEINI = new GridBagConstraints();
		gbc_PDATEINI.insets = new Insets(0, 0, 5, 0);
		gbc_PDATEINI.fill = GridBagConstraints.HORIZONTAL;
		gbc_PDATEINI.gridx = 1;
		gbc_PDATEINI.gridy = 0;
		FECHAS_P.add(PDATEINI, gbc_PDATEINI);
		
		JLabel label_1 = new JLabel("FECHA TERMINO");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		FECHAS_P.add(label_1, gbc_label_1);
		
		PDATETER = new JDateChooser();
		GridBagConstraints gbc_PDATETER = new GridBagConstraints();
		gbc_PDATETER.insets = new Insets(0, 0, 5, 0);
		gbc_PDATETER.fill = GridBagConstraints.HORIZONTAL;
		gbc_PDATETER.gridx = 1;
		gbc_PDATETER.gridy = 1;
		FECHAS_P.add(PDATETER, gbc_PDATETER);
		
		JLabel label_2 = new JLabel("FECHA SOL");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		FECHAS_P.add(label_2, gbc_label_2);
		
		PDATESOL = new JDateChooser();
		GridBagConstraints gbc_PDATESOL = new GridBagConstraints();
		gbc_PDATESOL.insets = new Insets(0, 0, 5, 0);
		gbc_PDATESOL.fill = GridBagConstraints.HORIZONTAL;
		gbc_PDATESOL.gridx = 1;
		gbc_PDATESOL.gridy = 2;
		FECHAS_P.add(PDATESOL, gbc_PDATESOL);
		
		JLabel label_3 = new JLabel("FECHA APROB");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		FECHAS_P.add(label_3, gbc_label_3);
		
		PDATEAPRO = new JDateChooser();
		GridBagConstraints gbc_PDATEAPRO = new GridBagConstraints();
		gbc_PDATEAPRO.fill = GridBagConstraints.HORIZONTAL;
		gbc_PDATEAPRO.gridx = 1;
		gbc_PDATEAPRO.gridy = 3;
		FECHAS_P.add(PDATEAPRO, gbc_PDATEAPRO);
		
		JPanel DATOS_P = new JPanel();
		DATOS_P.setBackground(new Color(102, 204, 0));
		GridBagConstraints gbc_DATOS_P = new GridBagConstraints();
		gbc_DATOS_P.fill = GridBagConstraints.BOTH;
		gbc_DATOS_P.insets = new Insets(0, 0, 5, 0);
		gbc_DATOS_P.gridx = 0;
		gbc_DATOS_P.gridy = 1;
		PRESTAMO.add(DATOS_P, gbc_DATOS_P);
		GridBagLayout gbl_DATOS_P = new GridBagLayout();
		gbl_DATOS_P.columnWidths = new int[] {233, 286, 10};
		gbl_DATOS_P.rowHeights = new int[] {29, 29, 29, 29};
		gbl_DATOS_P.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_DATOS_P.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		DATOS_P.setLayout(gbl_DATOS_P);
		
		JLabel lblNewLabel = new JLabel("MONTO");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		DATOS_P.add(lblNewLabel, gbc_lblNewLabel);
		
		PTXTMONTO = new JTextField();
		GridBagConstraints gbc_PTXTMONTO = new GridBagConstraints();
		gbc_PTXTMONTO.insets = new Insets(0, 0, 5, 0);
		gbc_PTXTMONTO.fill = GridBagConstraints.HORIZONTAL;
		gbc_PTXTMONTO.gridx = 1;
		gbc_PTXTMONTO.gridy = 0;
		DATOS_P.add(PTXTMONTO, gbc_PTXTMONTO);
		PTXTMONTO.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TASA INT");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		DATOS_P.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		PTXTTASA = new JTextField();
		GridBagConstraints gbc_PTXTTASA = new GridBagConstraints();
		gbc_PTXTTASA.insets = new Insets(0, 0, 5, 0);
		gbc_PTXTTASA.fill = GridBagConstraints.HORIZONTAL;
		gbc_PTXTTASA.gridx = 1;
		gbc_PTXTTASA.gridy = 1;
		DATOS_P.add(PTXTTASA, gbc_PTXTTASA);
		PTXTTASA.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CED. CLIENTE");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		DATOS_P.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		PTXTCLIENTE = new JTextField();
		GridBagConstraints gbc_PTXTCLIENTE = new GridBagConstraints();
		gbc_PTXTCLIENTE.insets = new Insets(0, 0, 5, 0);
		gbc_PTXTCLIENTE.fill = GridBagConstraints.HORIZONTAL;
		gbc_PTXTCLIENTE.gridx = 1;
		gbc_PTXTCLIENTE.gridy = 2;
		DATOS_P.add(PTXTCLIENTE, gbc_PTXTCLIENTE);
		PTXTCLIENTE.setColumns(10);
		
		Bfia = new JButton("FIADOR");
		GridBagConstraints gbc_Bfiad = new GridBagConstraints();
		gbc_Bfiad.insets = new Insets(0, 0, 0, 5);
		gbc_Bfiad.gridx = 0;
		gbc_Bfiad.gridy = 3;
		DATOS_P.add(Bfia, gbc_Bfiad);
		Bfia.addActionListener(this);
		
		Bgar = new JButton("GARANTIA");
		GridBagConstraints gbc_Bgar = new GridBagConstraints();
		gbc_Bgar.gridx = 1;
		gbc_Bgar.gridy = 3;
		DATOS_P.add(Bgar, gbc_Bgar);
		Bgar.addActionListener(this);
		
		JPanel BOTONES_P = new JPanel();
		BOTONES_P.setBackground(new Color(102, 255, 0));
		GridBagConstraints gbc_BOTONES_P = new GridBagConstraints();
		gbc_BOTONES_P.fill = GridBagConstraints.BOTH;
		gbc_BOTONES_P.gridx = 0;
		gbc_BOTONES_P.gridy = 2;
		PRESTAMO.add(BOTONES_P, gbc_BOTONES_P);
		GridBagLayout gbl_BOTONES_P = new GridBagLayout();
		gbl_BOTONES_P.columnWidths = new int[] {30, 100, 30};
		gbl_BOTONES_P.rowHeights = new int[] {35};
		gbl_BOTONES_P.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_BOTONES_P.rowWeights = new double[]{0.0};
		BOTONES_P.setLayout(gbl_BOTONES_P);
		
		PACEPTAR = new JButton("ACEPTAR");
		GridBagConstraints gbc_PACEPTAR = new GridBagConstraints();
		gbc_PACEPTAR.fill = GridBagConstraints.BOTH;
		gbc_PACEPTAR.insets = new Insets(0, 0, 5, 5);
		gbc_PACEPTAR.gridx = 0;
		gbc_PACEPTAR.gridy = 0;
		BOTONES_P.add(PACEPTAR, gbc_PACEPTAR);
		PACEPTAR.addActionListener(this);
		
		PCANCELAR = new JButton("REGRESAR");
		GridBagConstraints gbc_PCANCELAR = new GridBagConstraints();
		gbc_PCANCELAR.insets = new Insets(0, 0, 5, 0);
		gbc_PCANCELAR.fill = GridBagConstraints.BOTH;
		gbc_PCANCELAR.gridx = 2;
		gbc_PCANCELAR.gridy = 0;
		BOTONES_P.add(PCANCELAR, gbc_PCANCELAR);
		PCANCELAR.addActionListener(this);
		
		JPanel INVERSION = new JPanel();
		INVERSION.setBackground(new Color(0, 102, 102));
		tabbedPane.addTab("INVERSION", null, INVERSION, null);
		GridBagLayout gbl_INVERSION = new GridBagLayout();
		gbl_INVERSION.columnWidths = new int[] {542};
		gbl_INVERSION.rowHeights = new int[] {150, 110, 90};
		gbl_INVERSION.columnWeights = new double[]{0.0};
		gbl_INVERSION.rowWeights = new double[]{0.0, 0.0, 0.0};
		INVERSION.setLayout(gbl_INVERSION);
		
		JPanel DATOS_I = new JPanel();
		DATOS_I.setBackground(new Color(102, 204, 204));
		GridBagConstraints gbc_DATOS_I = new GridBagConstraints();
		gbc_DATOS_I.insets = new Insets(0, 0, 5, 0);
		gbc_DATOS_I.fill = GridBagConstraints.BOTH;
		gbc_DATOS_I.gridx = 0;
		gbc_DATOS_I.gridy = 0;
		INVERSION.add(DATOS_I, gbc_DATOS_I);
		GridBagLayout gbl_DATOS_I = new GridBagLayout();
		gbl_DATOS_I.columnWidths = new int[] {182, 80, 10};
		gbl_DATOS_I.rowHeights = new int[] {30, 30, 30};
		gbl_DATOS_I.columnWeights = new double[]{0.0, 1.0};
		gbl_DATOS_I.rowWeights = new double[]{0.0, 0.0, 0.0};
		DATOS_I.setLayout(gbl_DATOS_I);
		
		JLabel lblNewLabel_4 = new JLabel("MONTO");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		DATOS_I.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		ITXTMONTO = new JTextField();
		GridBagConstraints gbc_ITXTMONTO = new GridBagConstraints();
		gbc_ITXTMONTO.insets = new Insets(0, 0, 5, 0);
		gbc_ITXTMONTO.fill = GridBagConstraints.HORIZONTAL;
		gbc_ITXTMONTO.gridx = 1;
		gbc_ITXTMONTO.gridy = 0;
		DATOS_I.add(ITXTMONTO, gbc_ITXTMONTO);
		ITXTMONTO.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("TASA INT");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		DATOS_I.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		ITXTTASA = new JTextField();
		GridBagConstraints gbc_ITXTTASA = new GridBagConstraints();
		gbc_ITXTTASA.insets = new Insets(0, 0, 5, 0);
		gbc_ITXTTASA.fill = GridBagConstraints.HORIZONTAL;
		gbc_ITXTTASA.gridx = 1;
		gbc_ITXTTASA.gridy = 1;
		DATOS_I.add(ITXTTASA, gbc_ITXTTASA);
		ITXTTASA.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CLIENTE");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 2;
		DATOS_I.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		ITXTCLIENTE = new JTextField();
		GridBagConstraints gbc_ITXTCLIENTE = new GridBagConstraints();
		gbc_ITXTCLIENTE.insets = new Insets(0, 0, 5, 0);
		gbc_ITXTCLIENTE.fill = GridBagConstraints.HORIZONTAL;
		gbc_ITXTCLIENTE.gridx = 1;
		gbc_ITXTCLIENTE.gridy = 2;
		DATOS_I.add(ITXTCLIENTE, gbc_ITXTCLIENTE);
		ITXTCLIENTE.setColumns(10);
		
		JPanel FECHAS_I = new JPanel();
		FECHAS_I.setBackground(new Color(102, 204, 0));
		GridBagConstraints gbc_FECHAS_I = new GridBagConstraints();
		gbc_FECHAS_I.insets = new Insets(0, 0, 5, 0);
		gbc_FECHAS_I.fill = GridBagConstraints.BOTH;
		gbc_FECHAS_I.gridx = 0;
		gbc_FECHAS_I.gridy = 1;
		INVERSION.add(FECHAS_I, gbc_FECHAS_I);
		GridBagLayout gbl_FECHAS_I = new GridBagLayout();
		gbl_FECHAS_I.columnWidths = new int[] {182, 80, 10};
		gbl_FECHAS_I.rowHeights = new int[] {30, 30};
		gbl_FECHAS_I.columnWeights = new double[]{0.0, 1.0};
		gbl_FECHAS_I.rowWeights = new double[]{0.0, 0.0};
		FECHAS_I.setLayout(gbl_FECHAS_I);
		
		JLabel lblNewLabel_8 = new JLabel("FECHA INICIO");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		FECHAS_I.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		IDATEINI = new JDateChooser();
		GridBagConstraints gbc_IDATEINI = new GridBagConstraints();
		gbc_IDATEINI.insets = new Insets(0, 0, 5, 5);
		gbc_IDATEINI.fill = GridBagConstraints.HORIZONTAL;
		gbc_IDATEINI.gridx = 1;
		gbc_IDATEINI.gridy = 0;
		FECHAS_I.add(IDATEINI, gbc_IDATEINI);
		
		JLabel lblNewLabel_9 = new JLabel("FECHA TERMINO");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 1;
		FECHAS_I.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		IDATETER = new JDateChooser();
		GridBagConstraints gbc_IDATETER = new GridBagConstraints();
		gbc_IDATETER.insets = new Insets(0, 0, 0, 5);
		gbc_IDATETER.fill = GridBagConstraints.HORIZONTAL;
		gbc_IDATETER.gridx = 1;
		gbc_IDATETER.gridy = 1;
		FECHAS_I.add(IDATETER, gbc_IDATETER);
		
		JPanel BOTONES_I = new JPanel();
		BOTONES_I.setBackground(new Color(102, 255, 0));
		GridBagConstraints gbc_BOTONES_I = new GridBagConstraints();
		gbc_BOTONES_I.fill = GridBagConstraints.BOTH;
		gbc_BOTONES_I.gridx = 0;
		gbc_BOTONES_I.gridy = 2;
		INVERSION.add(BOTONES_I, gbc_BOTONES_I);
		GridBagLayout gbl_BOTONES_I = new GridBagLayout();
		gbl_BOTONES_I.columnWidths = new int[] {40, 50, 40, 50, 40};
		gbl_BOTONES_I.rowHeights = new int[] {35, 30};
		gbl_BOTONES_I.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_BOTONES_I.rowWeights = new double[]{0.0, 0.0};
		BOTONES_I.setLayout(gbl_BOTONES_I);
		
		BCNT = new JButton("CNT. BANCARIA");
		GridBagConstraints gbc_BCNT = new GridBagConstraints();
		gbc_BCNT.fill = GridBagConstraints.VERTICAL;
		gbc_BCNT.insets = new Insets(0, 0, 5, 5);
		gbc_BCNT.gridx = 2;
		gbc_BCNT.gridy = 0;
		BOTONES_I.add(BCNT, gbc_BCNT);
		BCNT.addActionListener(this);
		
		IACEPTAR = new JButton("ACEPTAR");
		GridBagConstraints gbc_IACEPTAR = new GridBagConstraints();
		gbc_IACEPTAR.fill = GridBagConstraints.VERTICAL;
		gbc_IACEPTAR.insets = new Insets(0, 0, 0, 5);
		gbc_IACEPTAR.gridx = 0;
		gbc_IACEPTAR.gridy = 1;
		BOTONES_I.add(IACEPTAR, gbc_IACEPTAR);
		IACEPTAR.addActionListener(this);
		
		ICANCELAR = new JButton("REGRESAR");
		GridBagConstraints gbc_ICANCELAR = new GridBagConstraints();
		gbc_ICANCELAR.insets = new Insets(0, 0, 0, 5);
		gbc_ICANCELAR.fill = GridBagConstraints.VERTICAL;
		gbc_ICANCELAR.gridx = 4;
		gbc_ICANCELAR.gridy = 1;
		BOTONES_I.add(ICANCELAR, gbc_ICANCELAR);
		ICANCELAR.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource()==Bfia) {
			fiador=JOptionPane.showInputDialog("ingrese la cedula del fiador");
		}
		if(evento.getSource()==Bgar) {
			gar.frame.setVisible(true);
		}
		if (evento.getSource()==BCNT) {
			cnt.frame.setVisible(true);
		}
		if (evento.getSource()==PACEPTAR) { //aceptar prestamo
			garantia=gar.datos;
			if(noemptyP()) {
				try {
					DataBase DB = new DataBase();
					//System.out.print(DB.consulcliente("123"));
					Double mon=Double.parseDouble(PTXTMONTO.getText());
					Double tas=Double.parseDouble(PTXTTASA.getText());
					if(PDATEINI.getDate().compareTo(PDATETER.getDate())<0 && compareDMA(PDATEINI.getDate(),PDATEAPRO.getDate()) && PDATESOL.getDate().compareTo(PDATEINI.getDate())<0) {
						if(DB.findCliente(PTXTCLIENTE.getText(), "P") && DB.findCliente(fiador, "F")) {
							if(DB.consulcliente(PTXTCLIENTE.getText()).compareTo(fiador)==0) {
								JOptionPane.showMessageDialog(null, "el fiador no puede ser el mismo prestamista");
							}
							else {
								java.sql.Date dini = new java.sql.Date(PDATEINI.getDate().getTime());
								java.sql.Date dter = new java.sql.Date(PDATETER.getDate().getTime());
								java.sql.Date dsol = new java.sql.Date(PDATESOL.getDate().getTime());
								java.sql.Date dapr = new java.sql.Date(PDATEAPRO.getDate().getTime());
								Double val= Double.parseDouble(garantia[1]);
								String codg=DB.insertgarantia(garantia[0], val, garantia[2]);
								String res=DB.insertprestamo(dini, dter, mon, tas, dsol, dapr, fiador, PTXTCLIENTE.getText(), codg);
								long longdias=(PDATETER.getDate().getTime()-PDATEINI.getDate().getTime())/86400000;
								int cantdias=(int)longdias;
								double deci=(cantdias/30.0);
								int cantcuot=(cantdias/30);
								double residuo=deci-cantcuot;
								if(residuo>0) {
									cantcuot++;
								}
								String codc=DB.insertcronograma(cantcuot, cantdias, mon, null, res);
								JOptionPane.showMessageDialog(null, "negocio registrado con exito con el codigo "+res+", con la garantia "+codg+" y con el cronograma "+codc);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "fiador no encontrado");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "las fechas no son correctas");
					}
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "valor de monto o tasa incorrectos");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "campos incompletos");
			}
		}
		if (evento.getSource()==PCANCELAR) {//cancelar prestamo
			Ingreso ing = new Ingreso(actualusu);
			ing.frame.setVisible(true);
			this.frame.setVisible(false);
		}
		if (evento.getSource()==IACEPTAR) {//aceptar inversion
			cuentaban=cnt.datos;
			if(noemptyI()) {
				try {
					DataBase DB = new DataBase();
					Double mon=Double.parseDouble(ITXTMONTO.getText());
					Double tas=Double.parseDouble(ITXTTASA.getText());
					if(IDATEINI.getDate().compareTo(IDATETER.getDate())<0) {
						if(DB.findCliente(ITXTCLIENTE.getText(), "I")) {
							java.sql.Date dini = new java.sql.Date(IDATEINI.getDate().getTime());
							java.sql.Date dter = new java.sql.Date(IDATETER.getDate().getTime());
							int val= Integer.parseInt(cuentaban[0]);
							DB.insertcnt(val, cuentaban[1], cuentaban[2]);
							String res=DB.insertinversion(ITXTCLIENTE.getText(), dini, dter, mon, tas, val);
							long longdias=(IDATETER.getDate().getTime()-IDATEINI.getDate().getTime())/86400000;
							int cantdias=(int)longdias;
							double deci=(cantdias/30.0);
							int cantcuot=(cantdias/30);
							double residuo=deci-cantcuot;
							if(residuo>0) {
								cantcuot++;
							}
							String codc=DB.insertcronograma(cantcuot, cantdias, mon, res, null);
							JOptionPane.showMessageDialog(null, "negocio registrado con exito con el codigo "+res+" y con el cronograma "+codc);
							JOptionPane.showMessageDialog(null, "cuenta bancaria registrada en la base de datos");
						}
						else {
							JOptionPane.showMessageDialog(null, "prestamista no encontrado");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "las fechas no son correctas");
					}
				}catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "valor de monto o tasa incorrectos");
				} catch (PSQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "cuenta bancaria ya existente en el sistema");
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "campos incompletos");
			}
		}
		if (evento.getSource()==ICANCELAR) {//cancelar inversion
			Ingreso ing = new Ingreso(actualusu);
			ing.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
	
	public boolean noemptyP() {
		boolean res=true;
		try {
			if(PTXTMONTO.getText().isBlank()||PTXTTASA.getText().isBlank()||PTXTCLIENTE.getText().isBlank()||fiador.isBlank()||garantia==null||PDATEINI.getDate().toString().isBlank()||PDATETER.getDate().toString().isBlank()||PDATESOL.getDate().toString().isBlank()||PDATEAPRO.getDate().toString().isBlank()) {
				res=false;
			}
		}catch(Exception e){
			res=false;
		}
		return res;
	}

	public boolean noemptyI() {
		boolean res=true;
		try {
			if(ITXTMONTO.getText().isBlank()||ITXTTASA.getText().isBlank()||ITXTCLIENTE.getText().isBlank()||IDATEINI.getDate().toString().isBlank()||IDATETER.getDate().toString().isBlank()||cuentaban==null) {
				res=false;
			}
		}catch(Exception e){
			res=false;
		}
		return res;
	}
	
	public boolean compareDMA(java.util.Date a, java.util.Date b) {
		if(a.getYear()==b.getYear()&&a.getMonth()==b.getMonth()&&a.getDay()==b.getDay()) {
			return true;
		}
		return false;
	}
}
