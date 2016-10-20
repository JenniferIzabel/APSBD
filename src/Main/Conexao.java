package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	static String host = "";
	static String port = "";
	static String nomeBancoDados = "";
	String urlConnection;
	private static String user = "";
	private static String password = "";
	private static List<String> linha;
	
	public Conexao() {
		getCabecalho();
		host = linha.get(0);
		port = linha.get(1);
		nomeBancoDados = linha.get(2);
		user = linha.get(3);
		password = linha.get(4);
		this.urlConnection = "jdbc:postgresql://" + host + ":" + port + "/" + nomeBancoDados;
	}
	
	public Connection getConnection(){
        try {
           return DriverManager.getConnection(urlConnection, user, password);
        } catch (SQLException ex) {
        	throw new RuntimeException(ex);
        }
	}
	
	public void release( PreparedStatement stmt ) throws SQLException{
    	if( stmt != null && !stmt.isClosed())
    		try {
    			stmt.close();
    			stmt = null;
    		} catch (SQLException ex) {
    			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    		}	
    }
   
    public void release( Connection conn ) throws SQLException{
    	if( conn != null  && !conn.isClosed())
    		try {
    			conn.close();
    			conn = null;
    		} catch (SQLException ex) {
    			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    		}
    }
    
    public void release( ResultSet rs ) throws SQLException{
    	if( rs != null &&  !rs.isClosed())
    		try {
    			rs.close();
    		} catch (SQLException ex) {
    			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    		}
  	}
    
    public void releaseAll( PreparedStatement stmt, Connection conn ) throws SQLException{
    	release(stmt);
    	release(conn);
    }
     
    public void releaseAll( ResultSet rs, PreparedStatement stmt, Connection conn ) throws SQLException {
    	release(rs);
    	releaseAll(stmt, conn);
    }

	public void releaseAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			stmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getCabecalho() {
		String temp = null;
		try {
			linha = Files.readAllLines(Paths.get("informacoes_banco.properties", ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
