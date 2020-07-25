package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import pimoney.DataBase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;

public class Cronogramas implements ActionListener{

	JFrame frame;
	private JButton Breg;
	
	private String usu;
	private String tipo;
	private String codn;
	private String neg;
	private String[] datosN; 
	private Object[] datos;
	
	private DataBase DB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] test= {"1","2"};
					Cronogramas window = new Cronogramas("2", "p", "God","J",test);
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
	public Cronogramas(String cod, String neg, String us, String tip, String[] datN) {
		codn=cod;
		this.neg=neg;
		usu=us;
		tipo=tip;
		datosN=datN;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 102, 255));
		frame.setTitle("CRONOGRAMA");
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("CRONOGRAMA del negocio con codigo: "+ codn);
		label.setBounds(10, 0, 674, 57);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label);
		
		JTextArea txt = new JTextArea(1,1);
		txt.setBackground(Color.LIGHT_GRAY);
		txt.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		txt.setEditable(false);
		JScrollPane js=new JScrollPane(txt);
		js.setBounds(10,53,674,252);
		frame.getContentPane().add(js);
		
		Breg = new JButton("REGRESAR");
		Breg.setBounds(290, 316, 120, 23);
		frame.getContentPane().add(Breg);
		Breg.addActionListener(this);
		
		try {
			DB=new DataBase();
			if(neg.compareTo("i")==0) {
				datos=DB.consulcronogramaI(codn);
			}
			else {
				datos=DB.consulcronogramaP(codn);
			}
			Double D=(Double) datos[2];
			int dias=D.intValue();
			int cuotas=(int) datos[0];
			int cpagas=(int) datos[1];
			double interes=Double.parseDouble(datosN[5]);
			double monto=(double) datos[3]+(double)datos[3]*interes;
			double valor=monto/cuotas;
			Date fecha= (Date)java.sql.Date.valueOf(datosN[2]);
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(fecha); // Configuramos la fecha que se recibe
			for(int i=0; i<cuotas;i++) { 
				if(dias<30) {//si quieres que el periodo de las cuotas funciones directamente en meses completos cambia dias>=30 por cuotas==1
			        calendar.add(Calendar.DAY_OF_YEAR, dias);// numero de días a añadir, o restar en caso de días<0
					txt.append("\n Cuota "+(i+1)+" // Fecha de vencimiento: "+calendar.getTime()+" // Valor: "+ valor);
				}
				else {
			        calendar.add(Calendar.DAY_OF_YEAR, 30);  // numero de días a añadir, o restar en caso de días<0
			        dias-=30;
					txt.append("\n Cuota "+(i+1)+" // Fecha de vencimiento: "+calendar.getTime()+" // Valor: "+ valor);
				}
				if (i<cpagas) {
					txt.append(" // Cuota pagada");
				}
				else {
					txt.append(" // Cuota pendiente");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Breg && neg.compareTo("i")==0) {
			ConsulInversion con=new ConsulInversion(usu, tipo, datosN);
			con.frame.setVisible(true);
			this.frame.setVisible(false);
		}else {
			ConsulPrestamo con=new ConsulPrestamo(usu, tipo, datosN);
			con.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
}
