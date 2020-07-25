package pimoney;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private final static String ADDRESS = "localhost";
	private final static String PORT = "5432";
	private final static String NAME_BBDD = "bdpimoney";
	private final static String URL = "jdbc:postgresql://"+ADDRESS+":"+PORT+"/"+NAME_BBDD;
	private final static String USER = "postgres";
	private final static String PASS = "postgres1";
	
	private final Connection connection;
	
	public DataBase() throws ClassNotFoundException, SQLException, Exception
	{
		connection = getConnection();
	}
	
	public static Connection getConnection()throws ClassNotFoundException, SQLException,Exception
	{
		Class.forName("org.postgresql.Driver");
		final Connection connection = DriverManager.getConnection(URL, USER, PASS);
		if( connection == null )
		{
			throw new Exception("No se pudo encontrar la base de datos");
		}
		return connection;
	}
	
	
	public int getQuantityinversiones() throws SQLException
	{
		int cantidad  = 0; 
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM inversiones" );
		while( resultSet.next() )
		{
			cantidad++;
		}
		return cantidad;
	}
	
	public int getQuantityprestamos() throws SQLException
	{
		int cantidad  = 0; 
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM prestamos" );
		while( resultSet.next() )
		{
			cantidad++;
		}
		return cantidad;
	}
	public int getQuantitygarantias() throws SQLException
	{
		int cantidad  = 0; 
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM garantias" );
		while( resultSet.next() )
		{
			cantidad++;
		}
		return cantidad;
	}
	
	public String insertgarantia(String pTip, double pVal, String pUbi) throws SQLException
	{
		int cant=getQuantitygarantias()+1;
		String sc=Integer.toString(cant);
		final PreparedStatement statement = connection.prepareStatement("INSERT INTO garantias VALUES(?,?,?,?);");
		statement.setString(1, sc);
		statement.setString(2, pTip);
		statement.setDouble(3, pVal);
		statement.setString(4, pUbi);
		statement.executeUpdate();
		statement.close();
		return sc;
	}
	
	
	public String insertinversion(String cedu, java.sql.Date fecha_inicio, java.sql.Date fecha_termino, double pMonto, double pTasa, int pNum) throws SQLException
	{
		int cant=getQuantityinversiones()+1;
		String sc=Integer.toString(cant);
		final PreparedStatement statement = connection.prepareStatement("INSERT INTO inversiones(codigo,cliente,fecha_inicio,fecha_termino,monto,tasa_int,cuenta_b) VALUES(?,?,?,?,?,?,?);");
		statement.setString(1, sc);
		statement.setString(2, cedu);
		statement.setDate(3, fecha_inicio);
		statement.setDate(4, fecha_termino);
		statement.setDouble(5, pMonto);
		statement.setDouble(6, pTasa);
		statement.setInt(7, pNum);
		statement.executeUpdate();
		statement.close();
		return sc;
	}
	
	public String consulInversion( final String pCod )[] throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM inversiones WHERE codigo='"+pCod+"';" );
		while( resultSet.next() )
		{
			return new String[] { resultSet.getString(1), resultSet.getString(2), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(9), resultSet.getString(8)};
		}
		throw new NFException("No se encontro la inversion");
	}
	
	public void EPA(String pCod) throws SQLException{
		final PreparedStatement statement = connection.prepareStatement("update prestamos set estado='A' where codigo='"+pCod+"';");
		statement.executeUpdate();
		statement.close();
	}
	public void EPR(String pCod) throws SQLException{
		final PreparedStatement statement = connection.prepareStatement("update prestamos set estado='R' where codigo='"+pCod+"';");
		statement.executeUpdate();
		statement.close();
	}
	
	public String insertprestamo(java.sql.Date fecha_inicio, java.sql.Date fecha_termino, double pMonto, double pTasa, java.sql.Date fecha_sol, java.sql.Date fecha_aprob, String pFia, String pClie, String pGar) throws SQLException
	{
		int cant=getQuantityprestamos()+1;
		String sc=Integer.toString(cant);
		final PreparedStatement statement = connection.prepareStatement("INSERT INTO prestamos(codigo,cliente,fecha_inicio,fecha_termino,monto,tasa_int,fecha_sol,fecha_aprob,fiador,garantia) VALUES(?,?,?,?,?,?,?,?,?,?);");
		statement.setString(1, sc);
		statement.setString(2, pClie);
		statement.setDate(3, fecha_inicio);
		statement.setDate(4, fecha_termino);
		statement.setDouble(5, pMonto);
		statement.setDouble(6, pTasa);
		statement.setDate(7, fecha_sol);
		statement.setDate(8, fecha_aprob);
		statement.setString(9, pFia);
		statement.setString(10, pGar);
		statement.executeUpdate();
		statement.close();
		return sc;
	}
	
	public String consulPrestamo( final String pCod )[] throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM prestamos WHERE codigo='"+pCod+"';" );
		while( resultSet.next() )
		{
			return new String[] { resultSet.getString(1), resultSet.getString(2), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12) };
		}
		throw new NFException("No se encontro el prestamo");
	}
	
	public void EIA(String pCod) throws SQLException{
		final PreparedStatement statement = connection.prepareStatement("update inversiones set estado='A' where codigo='"+pCod+"';");
		statement.executeUpdate();
		statement.close();
	}
	public void EIR(String pCod) throws SQLException{
		final PreparedStatement statement = connection.prepareStatement("update inversiones set estado='R' where codigo='"+pCod+"';");
		statement.executeUpdate();
		statement.close();
	}
	
	public void insertcliente(String pnombre, String pcedula, String pdireccion, String ptelefono,String ptipo) throws SQLException
	{
		final PreparedStatement statement = connection.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?);");
		statement.setString(4, pcedula);
		statement.setString(5, pnombre);
		statement.setString(1, pdireccion);
		statement.setString(2, ptelefono);
		statement.setString(3, ptipo);
		statement.executeUpdate();
		statement.close();
	}
	
	public boolean findCliente( final String pCedula, String ptip) throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM clientes WHERE ced_clie='"+pCedula+"' and tipo='"+ptip+"';" );
		String res = null;
		while(resultSet.next()) {
			res=resultSet.getString(1);
		}
		if (res!=null) {
			return true;
		}
		else return false;
	}
	
	public String consulcliente( final String pCed ) throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM clientes WHERE ced_clie='"+pCed+"';" );
		String res = null;
		while(resultSet.next()) {
			res=resultSet.getString(4);
		}
		return res;
	}
	
	public void insertusuario(String pusu, String ptipo, String pcon, String pced, String pnom) throws SQLException
	{
		final PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?);");
		statement.setString(1, pusu);
		statement.setString(2, ptipo);
		statement.setString(3, pcon);
		statement.setString(4, pced);
		statement.setString(5, pnom);
		statement.executeUpdate();
		statement.close();
	}
	
	public String consulusuario( final String pusu )[] throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM usuarios WHERE usuario='"+pusu+"';" );
		while( resultSet.next() )
		{
			return new String[] { resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5) };
		}
		throw new Exception("No se encontro al usuario");
	}
	
	public boolean findusuarioL(String pusu, String pcon) throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM usuarios WHERE usuario='"+pusu+"' and contrasena='"+pcon+"';" );
		String res = null;
		while(resultSet.next()) {
			res=resultSet.getString(1);
		}
		if (res!=null) {
			return true;
		}
		else return false;
	}
	public boolean findusuarioR(String pusu) throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM usuarios WHERE usuario='"+pusu+"';" );
		String res = null;
		while(resultSet.next()) {
			res=resultSet.getString(1);
		}
		if (res!=null) {
			return true;
		}
		else return false;
	}
	
	public int getQuantitycronogramas() throws SQLException
	{
		int cantidad  = 0; 
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM cronogramas" );
		while( resultSet.next() )
		{
			cantidad++;
		}
		return cantidad;
	}
	
	public String insertcronograma(int pCoutas, int pDur, Double pCan, String pCodI, String pCodP ) throws SQLException
	{
		int cant=getQuantitycronogramas()+1;
		String sc=Integer.toString(cant);
		final PreparedStatement statement = connection.prepareStatement("INSERT INTO cronogramas VALUES(?,?,?,?,?,?,?);");
		statement.setString(1, sc);
		statement.setInt(2, pCoutas);
		statement.setInt(3, 0);
		statement.setInt(4, pDur);
		statement.setDouble(5, pCan);
		statement.setString(6, pCodI);
		statement.setString(7, pCodP);
		statement.executeUpdate();
		statement.close();
		return sc;
	}
	
	public Object[] consulcronogramaP(String pCod) throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM cronogramas WHERE codigo_pres='"+pCod+"';" );
		while( resultSet.next() )
		{
			return new Object[] {resultSet.getInt(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(1)};
		}
		throw new Exception("No se encontro el cronograma");
	}
	
	public Object[] consulcronogramaI(String pCod) throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM cronogramas WHERE codigo_inv='"+pCod+"';" );
		while( resultSet.next() )
		{
			return new Object[] {resultSet.getInt(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(1)};
		}
		throw new Exception("No se encontro el cronograma");
	}
	
	public void actucronogramaI(String pCodc, int pCant) throws SQLException,Exception
	{
		final PreparedStatement statement = connection.prepareStatement("update cronogramas set num_cuot_pag=num_cuot_pag + "+pCant+" WHERE codigo_inv='"+pCodc+"';");
		statement.executeUpdate();
		statement.close();
	}
	
	public void actucronogramaP(String pCodc, int pCant) throws SQLException,Exception
	{
		final PreparedStatement statement = connection.prepareStatement("update cronogramas set num_cuot_pag=num_cuot_pag + "+pCant+" WHERE codigo_pres='"+pCodc+"';");
		statement.executeUpdate();
		statement.close();
	}
	
	public void insertcnt(int pNum, String pBan, String pTipo) throws SQLException
	{
		final PreparedStatement statement = connection.prepareStatement("INSERT INTO cntbancarias VALUES(?,?,?);");
		statement.setInt(1, pNum);
		statement.setString(2, pBan);
		statement.setString(3, pTipo);
		statement.executeUpdate();
		statement.close();
	}
	
	public boolean findcnt(int pNum) throws SQLException,Exception
	{
		final Statement executor = connection.createStatement();
		final ResultSet resultSet = executor.executeQuery( "SELECT * FROM cntbancarias WHERE numero='"+pNum+"';" );
		String res = null;
		while(resultSet.next()) {
			res=resultSet.getString(1);
		}
		if (res!=null) {
			return true;
		}
		else return false;
	}
}
