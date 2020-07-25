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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;

public class ActualizarNeg implements ActionListener{

	JFrame frame;
	
	private JButton Bpag;
	private JButton Bden;
	private JButton Breg;
	
	private String usu;
	private String tipo;
	private String[] datosN;
	private Object[] datosC;
	
	private String tipon="tipo de negocio";
	private JLabel lblcod;
	private JLabel txtcuot;
	private JLabel txtcuop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] test= {"a","b"};
					ActualizarNeg window = new ActualizarNeg("wea","wea2", test, test);
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
	public ActualizarNeg(String us, String tip, String[] a, Object[] b) {
		usu=us;
		tipo=tip;
		datosN=a;
		datosC=b;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setTitle("ACTUALIZAR NEGOCIO");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0};
		gridBagLayout.rowHeights = new int[] {154, 108};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel datos = new JPanel();
		datos.setBackground(new Color(0, 255, 204));
		GridBagConstraints gbc_datos = new GridBagConstraints();
		gbc_datos.insets = new Insets(0, 0, 5, 0);
		gbc_datos.fill = GridBagConstraints.BOTH;
		gbc_datos.gridx = 0;
		gbc_datos.gridy = 0;
		frame.getContentPane().add(datos, gbc_datos);
		GridBagLayout gbl_datos = new GridBagLayout();
		gbl_datos.columnWidths = new int[] {127, 67};
		gbl_datos.rowHeights = new int[] {40, 40, 40};
		gbl_datos.columnWeights = new double[]{0.0, 0.0};
		gbl_datos.rowWeights = new double[]{0.0, 0.0, 0.0};
		datos.setLayout(gbl_datos);
		
		if(datosN.length>8) {
			tipon="PRESTAMO";
		}
		else {
			tipon="INVERSION";
		}
		JLabel lbltipo = new JLabel(tipon);
		GridBagConstraints gbc_lbltipo = new GridBagConstraints();
		gbc_lbltipo.insets = new Insets(0, 0, 5, 5);
		gbc_lbltipo.gridx = 0;
		gbc_lbltipo.gridy = 0;
		datos.add(lbltipo, gbc_lbltipo);
		
		lblcod = new JLabel(datosN[0]);
		GridBagConstraints gbc_lblcod = new GridBagConstraints();
		gbc_lblcod.insets = new Insets(0, 0, 5, 0);
		gbc_lblcod.gridx = 1;
		gbc_lblcod.gridy = 0;
		datos.add(lblcod, gbc_lblcod);
		
		JLabel lblcuot = new JLabel("TOTAL CUOTAS");
		GridBagConstraints gbc_lblcuot = new GridBagConstraints();
		gbc_lblcuot.insets = new Insets(0, 0, 5, 5);
		gbc_lblcuot.gridx = 0;
		gbc_lblcuot.gridy = 1;
		datos.add(lblcuot, gbc_lblcuot);
		
		txtcuot = new JLabel(datosC[0].toString());
		GridBagConstraints gbc_txtcuot = new GridBagConstraints();
		gbc_txtcuot.insets = new Insets(0, 0, 5, 0);
		gbc_txtcuot.gridx = 1;
		gbc_txtcuot.gridy = 1;
		datos.add(txtcuot, gbc_txtcuot);
		
		JLabel lblcoutp = new JLabel("CUOTAS PAGADAS");
		GridBagConstraints gbc_lblcoutp = new GridBagConstraints();
		gbc_lblcoutp.insets = new Insets(0, 0, 0, 5);
		gbc_lblcoutp.gridx = 0;
		gbc_lblcoutp.gridy = 2;
		datos.add(lblcoutp, gbc_lblcoutp);
		
		txtcuop = new JLabel(datosC[1].toString());
		GridBagConstraints gbc_txtcuop = new GridBagConstraints();
		gbc_txtcuop.gridx = 1;
		gbc_txtcuop.gridy = 2;
		datos.add(txtcuop, gbc_txtcuop);
		
		JPanel botone = new JPanel();
		botone.setBackground(Color.GREEN);
		GridBagConstraints gbc_botone = new GridBagConstraints();
		gbc_botone.fill = GridBagConstraints.BOTH;
		gbc_botone.gridx = 0;
		gbc_botone.gridy = 1;
		frame.getContentPane().add(botone, gbc_botone);
		GridBagLayout gbl_botone = new GridBagLayout();
		gbl_botone.columnWidths = new int[] {40, 50, 40};
		gbl_botone.rowHeights = new int[] {0, 0};
		gbl_botone.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_botone.rowWeights = new double[]{0.0, 0.0};
		botone.setLayout(gbl_botone);
		
		Bpag = new JButton("PAGAR CUOTA");
		GridBagConstraints gbc_Bpag = new GridBagConstraints();
		gbc_Bpag.insets = new Insets(0, 0, 5, 5);
		gbc_Bpag.gridx = 0;
		gbc_Bpag.gridy = 0;
		botone.add(Bpag, gbc_Bpag);
		Bpag.addActionListener(this);
		
		Bden = new JButton("DENEGAR CUOTA");
		GridBagConstraints gbc_Bden = new GridBagConstraints();
		gbc_Bden.insets = new Insets(0, 0, 5, 0);
		gbc_Bden.gridx = 2;
		gbc_Bden.gridy = 0;
		botone.add(Bden, gbc_Bden);
		Bden.addActionListener(this);
		
		Breg = new JButton("REGRESAR");
		GridBagConstraints gbc_Breg = new GridBagConstraints();
		gbc_Breg.insets = new Insets(0, 0, 0, 5);
		gbc_Breg.gridx = 1;
		gbc_Breg.gridy = 1;
		botone.add(Breg, gbc_Breg);
		Breg.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==Bpag) {
			try {
				DataBase DB=new DataBase();
				if(tipon.compareTo("INVERSION")==0) {
					if(!datosC[0].equals(datosC[1])) {
						DB.actucronogramaI(datosN[0], 1);
						datosC=DB.consulcronogramaI(datosN[0]);
					}
				}
				else {
					if(!datosC[0].equals(datosC[1])) {
						DB.actucronogramaP(datosN[0], 1);
						datosC=DB.consulcronogramaP(datosN[0]);
					}

				}
				txtcuop.setText(datosC[1].toString());
				txtcuot.setText(datosC[0].toString());
			}
			catch (Exception e1){
				e1.printStackTrace();
			}
		}
		if (e.getSource()==Bden) {
			try {
				DataBase DB=new DataBase();
				if(tipon.compareTo("INVERSION")==0) {
					if(!datosC[1].equals(0)) {
						DB.actucronogramaI(datosN[0], -1);
						datosC=DB.consulcronogramaI(datosN[0]);
					}
				}
				else {
					if(!datosC[1].equals(0)) {
						DB.actucronogramaP(datosN[0], -1);
						datosC=DB.consulcronogramaP(datosN[0]);
					}
				}
				txtcuop.setText(datosC[1].toString());
				txtcuot.setText(datosC[0].toString());
			}
			catch (Exception e1){
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Breg) {
			Ingreso ing = new Ingreso(usu);
			ing.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}

}
