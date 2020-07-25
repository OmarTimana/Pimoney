package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pimoney.DataBase;
import pimoney.NFException;
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import java.awt.Color;

public class Ingreso implements ActionListener{

	JFrame frame;
	
	private JButton Breg;
	private JButton Bregc;
	private JButton Bregn;
	private JButton Bccli;
	private JButton Bcpre;
	private JButton Bcinv;
	private JButton Bactc;
	private JButton Bactp;
	private JButton Bacti;
	
	public String actualusu;
	private JButton Bcusu;
	private JButton Bactu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso window = new Ingreso("USUARIO");
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
	public Ingreso(String a) {
		actualusu=a;
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String a) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 591, 346);
		frame.setTitle("SESION");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0};
		gridBagLayout.rowHeights = new int[] {70, 30, 48, 61, 50, 50};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {191, 215};
		gbl_panel.rowHeights = new int[] {50};
		gbl_panel.columnWeights = new double[]{1.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("BIENVENIDO");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel lblNewLabel = new JLabel(a);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 255, 204));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {1};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_2 = new JLabel("Eliga la opcion a realizar");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 0;
		panel_3.add(label_2, gbc_label_2);
		
		JPanel RBOTONES = new JPanel();
		RBOTONES.setBackground(new Color(51, 255, 51));
		GridBagConstraints gbc_RBOTONES = new GridBagConstraints();
		gbc_RBOTONES.insets = new Insets(0, 0, 5, 0);
		gbc_RBOTONES.fill = GridBagConstraints.BOTH;
		gbc_RBOTONES.gridx = 0;
		gbc_RBOTONES.gridy = 2;
		frame.getContentPane().add(RBOTONES, gbc_RBOTONES);
		GridBagLayout gbl_RBOTONES = new GridBagLayout();
		gbl_RBOTONES.columnWidths = new int[] {150, 50, 150};
		gbl_RBOTONES.rowHeights = new int[] {40};
		gbl_RBOTONES.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_RBOTONES.rowWeights = new double[]{0.0};
		RBOTONES.setLayout(gbl_RBOTONES);
		
		Bregc = new JButton("REG. CLIENTE");
		GridBagConstraints gbc_Bregc = new GridBagConstraints();
		gbc_Bregc.fill = GridBagConstraints.BOTH;
		gbc_Bregc.insets = new Insets(0, 0, 5, 5);
		gbc_Bregc.gridx = 0;
		gbc_Bregc.gridy = 0;
		RBOTONES.add(Bregc, gbc_Bregc);
		Bregc.addActionListener(this);
		
		Bregn = new JButton("REG. NEGOCIO");
		GridBagConstraints gbc_Bregn = new GridBagConstraints();
		gbc_Bregn.insets = new Insets(0, 0, 5, 0);
		gbc_Bregn.fill = GridBagConstraints.BOTH;
		gbc_Bregn.gridx = 2;
		gbc_Bregn.gridy = 0;
		RBOTONES.add(Bregn, gbc_Bregn);
		Bregn.addActionListener(this);
		
		JPanel CBOTONES = new JPanel();
		CBOTONES.setBackground(new Color(51, 102, 255));
		GridBagConstraints gbc_CBOTONES = new GridBagConstraints();
		gbc_CBOTONES.insets = new Insets(0, 0, 5, 0);
		gbc_CBOTONES.fill = GridBagConstraints.BOTH;
		gbc_CBOTONES.gridx = 0;
		gbc_CBOTONES.gridy = 3;
		frame.getContentPane().add(CBOTONES, gbc_CBOTONES);
		GridBagLayout gbl_CBOTONES = new GridBagLayout();
		gbl_CBOTONES.columnWidths = new int[] {0, 0, 0, 0};
		gbl_CBOTONES.rowHeights = new int[] {40};
		gbl_CBOTONES.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_CBOTONES.rowWeights = new double[]{0.0};
		CBOTONES.setLayout(gbl_CBOTONES);
		
		Bccli = new JButton("CON. CLIENTE");
		GridBagConstraints gbc_Bccli = new GridBagConstraints();
		gbc_Bccli.fill = GridBagConstraints.VERTICAL;
		gbc_Bccli.insets = new Insets(0, 0, 0, 5);
		gbc_Bccli.gridx = 0;
		gbc_Bccli.gridy = 0;
		CBOTONES.add(Bccli, gbc_Bccli);
		Bccli.addActionListener(this);
		
		Bcpre = new JButton("CON. PRESTAMO");
		GridBagConstraints gbc_Bcpre = new GridBagConstraints();
		gbc_Bcpre.fill = GridBagConstraints.VERTICAL;
		gbc_Bcpre.insets = new Insets(0, 0, 0, 5);
		gbc_Bcpre.gridx = 1;
		gbc_Bcpre.gridy = 0;
		CBOTONES.add(Bcpre, gbc_Bcpre);
		Bcpre.addActionListener(this);
		
		Bcinv = new JButton("CON. INVERSION");
		GridBagConstraints gbc_Bcinv = new GridBagConstraints();
		gbc_Bcinv.fill = GridBagConstraints.VERTICAL;
		gbc_Bcinv.insets = new Insets(0, 0, 0, 5);
		gbc_Bcinv.gridx = 2;
		gbc_Bcinv.gridy = 0;
		CBOTONES.add(Bcinv, gbc_Bcinv);
		Bcinv.addActionListener(this);
		
		Bcusu = new JButton("CON. USUARIO");
		GridBagConstraints gbc_Bcusu = new GridBagConstraints();
		gbc_Bcusu.fill = GridBagConstraints.BOTH;
		gbc_Bcusu.gridx = 3;
		gbc_Bcusu.gridy = 0;
		CBOTONES.add(Bcusu, gbc_Bcusu);
		Bcusu.addActionListener(this);
		
		JPanel Salida = new JPanel();
		Salida.setBackground(Color.GREEN);
		GridBagConstraints gbc_Salida = new GridBagConstraints();
		gbc_Salida.insets = new Insets(5, 0, 0, 0);
		gbc_Salida.fill = GridBagConstraints.BOTH;
		gbc_Salida.gridx = 0;
		gbc_Salida.gridy = 5;
		frame.getContentPane().add(Salida, gbc_Salida);
		GridBagLayout gbl_Salida = new GridBagLayout();
		gbl_Salida.columnWidths = new int[] {30};
		gbl_Salida.rowHeights = new int[] {0};
		gbl_Salida.columnWeights = new double[]{0.0};
		gbl_Salida.rowWeights = new double[]{0.0};
		Salida.setLayout(gbl_Salida);
		
		Breg = new JButton("SALIR DE LA SESION");
		GridBagConstraints gbc_Breg = new GridBagConstraints();
		gbc_Breg.anchor = GridBagConstraints.NORTHWEST;
		gbc_Breg.gridx = 0;
		gbc_Breg.gridy = 0;
		Salida.add(Breg, gbc_Breg);
		Breg.addActionListener(this);
		
		JPanel Actualizar = new JPanel();
		Actualizar.setBackground(new Color(204, 255, 153));
		GridBagConstraints gbc_Actualizar = new GridBagConstraints();
		gbc_Actualizar.fill = GridBagConstraints.BOTH;
		gbc_Actualizar.gridx = 0;
		gbc_Actualizar.gridy = 4;
		frame.getContentPane().add(Actualizar, gbc_Actualizar);
		GridBagLayout gbl_Actualizar = new GridBagLayout();
		gbl_Actualizar.columnWidths = new int[] {60, 20, 60, 20, 60, 20, 60};
		gbl_Actualizar.rowHeights = new int[] {30};
		gbl_Actualizar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_Actualizar.rowWeights = new double[]{0.0};
		Actualizar.setLayout(gbl_Actualizar);
		
		Bactc = new JButton("ACT. CLIENTE");
		GridBagConstraints gbc_Bactc = new GridBagConstraints();
		gbc_Bactc.fill = GridBagConstraints.VERTICAL;
		gbc_Bactc.insets = new Insets(0, 0, 0, 5);
		gbc_Bactc.gridx = 0;
		gbc_Bactc.gridy = 0;
		Actualizar.add(Bactc, gbc_Bactc);
		Bactc.addActionListener(this);
		
		Bactp = new JButton("ACT. PRESTAMO");
		GridBagConstraints gbc_Bactp = new GridBagConstraints();
		gbc_Bactp.fill = GridBagConstraints.VERTICAL;
		gbc_Bactp.insets = new Insets(0, 0, 0, 5);
		gbc_Bactp.gridx = 2;
		gbc_Bactp.gridy = 0;
		Actualizar.add(Bactp, gbc_Bactp);
		Bactp.addActionListener(this);
		
		Bacti = new JButton("ACT. INVERSION");
		GridBagConstraints gbc_Bacti = new GridBagConstraints();
		gbc_Bacti.insets = new Insets(0, 0, 0, 5);
		gbc_Bacti.fill = GridBagConstraints.VERTICAL;
		gbc_Bacti.gridx = 4;
		gbc_Bacti.gridy = 0;
		Actualizar.add(Bacti, gbc_Bacti);
		Bacti.addActionListener(this);
		
		Bactu = new JButton("ACT. USUARIO");
		GridBagConstraints gbc_Bactu = new GridBagConstraints();
		gbc_Bactu.fill = GridBagConstraints.VERTICAL;
		gbc_Bactu.gridx = 6;
		gbc_Bactu.gridy = 0;
		Actualizar.add(Bactu, gbc_Bactu);
		Bactu.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==Bregc) {
			RegistroCliente cli=new RegistroCliente(actualusu);
			this.frame.setVisible(false);
			cli.frame.setVisible(true);
		}
		if (e.getSource()==Bregn) {
			RegistroNegocio neg=new RegistroNegocio(actualusu);
			this.frame.setVisible(false);
			neg.frame.setVisible(true);
		}
		if (e.getSource()==Bccli) {
			try {
				ConsulCliente co=new ConsulCliente(actualusu);
				this.frame.setVisible(false);
				co.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==Bcpre) {
			String cod=JOptionPane.showInputDialog("ingrese el codigo del prestamo");
			DataBase DB;
			try {
				DB = new DataBase();
				String[] ps=DB.consulPrestamo(cod);
				String[] us=DB.consulusuario(actualusu);
				ConsulPrestamo cp=new ConsulPrestamo(us[0],us[1],ps);
				this.frame.setVisible(false);
				cp.frame.setVisible(true);
			} catch (NFException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource()==Bcinv) {
			String cod=JOptionPane.showInputDialog("ingrese el codigo de la inversion");
			DataBase DB;
			try {
				DB = new DataBase();
				String[] ps=DB.consulInversion(cod);
				String[] us=DB.consulusuario(actualusu);
				ConsulInversion ci=new ConsulInversion(us[0],us[1],ps);
				this.frame.setVisible(false);
				ci.frame.setVisible(true);
			} catch (NFException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource()==Breg) {
			Login log=new Login();
			this.frame.setVisible(false);
			log.frmLogin.setVisible(true);
		}
		if (e.getSource()==Bactc) {
			ActualizarCli cli=new ActualizarCli(actualusu);
			this.frame.setVisible(false);
			cli.setVisible(true);
		}
		if (e.getSource()==Bactu) {
			ActualizarUsu cli=new ActualizarUsu(actualusu);
			this.frame.setVisible(false);
			cli.setVisible(true);
		}
		if (e.getSource()==Bcusu) {
			try {
				ConsulUsu us=new ConsulUsu(actualusu);
				this.frame.setVisible(false);
				us.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==Bactp) {
			String cod=JOptionPane.showInputDialog("ingrese el codigo del prestamo");
			DataBase DB;
			try {
				DB = new DataBase();
				String[] ps=DB.consulPrestamo(cod);
				String[] us=DB.consulusuario(actualusu);
				Object[] co=DB.consulcronogramaP(cod);
				ActualizarNeg neg= new ActualizarNeg(us[0],us[1],ps,co);
				this.frame.setVisible(false);
				neg.frame.setVisible(true);
			} catch (NFException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource()==Bacti) {
			String cod=JOptionPane.showInputDialog("ingrese el codigo de la inversion");
			DataBase DB;
			try {
				DB = new DataBase();
				String[] ps=DB.consulInversion(cod);
				String[] us=DB.consulusuario(actualusu);
				Object[] co=DB.consulcronogramaI(cod);
				ActualizarNeg neg= new ActualizarNeg(us[0],us[1],ps,co);
				this.frame.setVisible(false);
				neg.frame.setVisible(true);
			} catch (NFException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
