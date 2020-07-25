package pimoney;

public class Cuentabancaria {

	private String numero_cuenta;
	private char banco;
	private char tipo;
	
	public Cuentabancaria(String numero_cuenta,char tipo,char banco)
	{
		this.numero_cuenta=numero_cuenta;
		this.banco=banco;
		this.tipo=tipo;
	}
}
