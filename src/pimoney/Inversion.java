package pimoney;
import java.util.Date;
import java.sql.SQLException;

public class Inversion {

	private String codigo;
	private Date fecha_inicio;
	private Date fecha_termino;
	private double monto;
	private double tasa_int;
	
	public Inversion(Date fecha_inicio,double monto,double tasa_int) throws ClassNotFoundException, SQLException,Exception
	{
		this.fecha_inicio=fecha_inicio;
		this.fecha_termino=null;
		this.monto=monto;
		this.tasa_int=tasa_int;
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
	
}
