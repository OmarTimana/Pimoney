package pimoney;

public class Cronograma {
	private int num_cuotas;
	private int duracion;
	private double monto;
	
	public Cronograma()
	{
		this.num_cuotas=0;
		this.duracion=0;
		this.monto=0.0;
		
	}
	public void generar_cronograma(int num_cuotas,int duracion,double monto)
	{
		this.num_cuotas=num_cuotas;
		this.duracion=duracion;
		this.monto=monto;
	}
}
