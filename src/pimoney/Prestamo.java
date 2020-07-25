package pimoney;

import java.sql.SQLException;
import java.util.Date;

public class Prestamo {
	private String codigo;
	private Date fecha_inicio;
	private Date fecha_termino;
	private double monto;
	private double tasa_int;
	private Date fecha_sol;
	private Date fecha_aprob;
	private String fiador;
	
	
	public Prestamo(Date fecha_inicio,double monto,double tasa_int,Date fecha_sol,
			Date fecha_aprob,String fiador	) throws ClassNotFoundException, SQLException, Exception
	
	{
		this.fecha_inicio=fecha_inicio;
		this.fecha_termino=null;
		this.monto=monto;
		this.tasa_int=tasa_int;
		this.fecha_sol=fecha_sol;
		this.fecha_aprob=fecha_aprob;
		this.fiador=fiador;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_termino() {
		return fecha_termino;
	}

	public void setFecha_termino(Date fecha_termino) {
		this.fecha_termino = fecha_termino;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getTasa_int() {
		return tasa_int;
	}

	public void setTasa_int(double tasa_int) {
		this.tasa_int = tasa_int;
	}

	public Date getFecha_sol() {
		return fecha_sol;
	}

	public void setFecha_sol(Date fecha_sol) {
		this.fecha_sol = fecha_sol;
	}

	public Date getFecha_aprob() {
		return fecha_aprob;
	}

	public void setFecha_aprob(Date fecha_aprob) {
		this.fecha_aprob = fecha_aprob;
	}

}
