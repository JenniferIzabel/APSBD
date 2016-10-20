package produtor;

import Main.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TransacaoDao {
	private static Conexao conexao;
	
	public TransacaoDao(Conexao conexao) {
            this.conexao = conexao;
            Conexao.getCabecalho();
	}

	public static void gravarTransacoes(Schedule schedule) {
		Operacao operacao = null;
		
		Connection conn = conexao.getConnection();
		String sql = "INSERT INTO schedule(indiceTransacao, operacao, itemDado, timestampj) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		while(!schedule.getScheduleInList().isEmpty()) {
			operacao = schedule.getScheduleInList().removeFirst();
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, operacao.getIndice());
				stmt.setString(2, operacao.getOperacao().texto);
				stmt.setString(3, operacao.getDado().getNome());
				stmt.setString(4, new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
				stmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Erro na insercao da transacao");
				e.printStackTrace();
			}
		}
		try {
			conexao.releaseAll(stmt, conn);
		} catch (SQLException e) {
			System.out.println("Erro ao encerrar conex�o");
			e.printStackTrace();
		}
	}
	
	public static int pegarUltimoIndice() {
		int ultimoIndice = 0;
		conexao = new Conexao();
		Connection conn = conexao.getConnection();
		String sql = "SELECT MAX(indiceTransacao) FROM schedule;";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			ultimoIndice = rs.getInt(1);
			
		} catch (SQLException e) {
			System.err.println("Erro na consulta ao �ltimo �ndice");
			e.printStackTrace();
		}
		return ultimoIndice;
	}

}
