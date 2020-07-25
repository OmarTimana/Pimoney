package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.postgresql.util.PSQLException;

import pimoney.DataBase;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;


public class Login implements ActionListener{


	JFrame frmLogin;
	private JTextField txtusu;
	private JPasswordField txtpss;
	private JButton breg;
	private JButton bing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setBackground(new Color(240, 240, 240));
		frmLogin.setBounds(100, 100, 457, 563);
		frmLogin.setTitle("Negocios PIMONEY");
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/oconodef.png")));
		icono.setBounds(96, 56, 256, 254);
		frmLogin.getContentPane().add(icono);
		
		JLabel LbContrasena = new JLabel("CONTRASE\u00D1A:");
		LbContrasena.setForeground(Color.WHITE);
		LbContrasena.setBounds(34, 418, 146, 22);
		frmLogin.getContentPane().add(LbContrasena);
		
		JLabel LbUsuario = new JLabel("USUARIO:");
		LbUsuario.setForeground(Color.WHITE);
		LbUsuario.setBounds(34, 370, 117, 22);
		frmLogin.getContentPane().add(LbUsuario);
		
		txtusu = new JTextField();
		txtusu.setBackground(new Color(32, 178, 170));
		txtusu.setForeground(Color.WHITE);
		txtusu.setBounds(161, 363, 261, 37);
		frmLogin.getContentPane().add(txtusu);
		txtusu.setColumns(10);
		
		txtpss = new JPasswordField();
		txtpss.setBackground(new Color(32, 178, 170));
		txtpss.setForeground(Color.BLACK);
		txtpss.setBounds(197, 411, 225, 37);
		frmLogin.getContentPane().add(txtpss);
		
		bing = new JButton("INGRESAR");
		bing.setForeground(Color.WHITE);
		bing.setBackground(new Color(0, 0, 139));
		bing.setBounds(310, 477, 112, 37);
		frmLogin.getContentPane().add(bing);
		bing.addActionListener(this);
		
		breg = new JButton("REGISTRARSE");
		breg.setBackground(new Color(0, 0, 128));
		breg.setForeground(Color.WHITE);
		breg.setBounds(29, 477, 198, 37);
		frmLogin.getContentPane().add(breg);
		breg.addActionListener(this);
		
		JLabel Fondo = new JLabel("");
		Fondo.setForeground(new Color(0, 0, 0));
		Fondo.setBackground(Color.CYAN);
		Fondo.setBounds(0, 0, 451, 533);
		Fondo.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Fondo1.jpg")));
		frmLogin.getContentPane().add(Fondo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==breg) {//registrarse
			RegistroUsuario usu = new RegistroUsuario();
			usu.frmusu.setVisible(true);
			frmLogin.setVisible(false);
		}
		if (e.getSource()==bing) {//ingresar
			if(!txtusu.getText().isBlank() && !txtpss.getText().isBlank()) {
				try {
					DataBase DB=new DataBase();
					if(DB.findusuarioL(txtusu.getText(), txtpss.getText())) {
						Ingreso ing = new Ingreso(txtusu.getText());
						ing.frame.setVisible(true);
						frmLogin.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"usuario no encontrado");
					}
				} catch (PSQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"debe de introducir todos los datos");
			}
		}
	}
}

