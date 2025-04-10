package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/aulajdbc"; //exibe se a conexao é local e a porta - nome do banco
    private static final String USUARIO = "root";
    private static final String SENHA = "sua_senha";

    //Funcao para conetar com o banco de dados
    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(URL, USUARIO, SENHA);

    }

    //Funcao para desconectar do banco de dados
    public static void desconectar(Connection conn) {

        try {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

        } catch (SQLException e) {

            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }

}
class ExemploSelect {

    public static void main(String[] args) {

        try (Connection conn = Conexao.conectar();

             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa")) {

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));

                System.out.println("Nome: " + rs.getString("nome"));

                System.out.println("Idade: " + rs.getInt("idade"));

                System.out.println("---");

            }

        } catch (Exception e) {
            System.err.println("Erro ao consultar: " + e.getMessage());
        }

    }

}


