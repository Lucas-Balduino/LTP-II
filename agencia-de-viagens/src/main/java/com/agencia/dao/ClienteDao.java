package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.agencia.model.Cliente;
import com.agencia.model.Estrangeiro;
import com.agencia.model.Nacional;
import com.agencia.util.DataBaseConnection;

public class ClienteDao {

    public void inserir(Cliente cliente) throws SQLException {
        Connection conn = null;
        try {
            conn = DataBaseConnection.getConnection();

            String sql;
            PreparedStatement stmt;

            if (cliente instanceof Nacional) {
                sql = "INSERT INTO nacional (nome, telefone, email, cpf) VALUES (?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, ((Nacional) cliente).getCpf());

            } else if (cliente instanceof Estrangeiro) {
                sql = "INSERT INTO estrangeiro (nome, telefone, email, passaporte) VALUES (?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, ((Estrangeiro) cliente).getPassaporte());

            } else {
                throw new IllegalArgumentException("Tipo de cliente desconhecido");
            }

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setId(rs.getLong(1));
                }
            }

        } finally {
            if (conn != null)
                DataBaseConnection.desconectar(conn);
        }
    }
    
    public Nacional buscarNacionalPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM nacional WHERE cpf = ?";
        Connection conn = null;

        try {
            conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Nacional nacional = new Nacional();
                nacional.setId(rs.getLong("id"));
                nacional.setNome(rs.getString("nome"));
                nacional.setTelefone(rs.getString("telefone"));
                nacional.setEmail(rs.getString("email"));
                nacional.setCpf(rs.getString("cpf"));
                return nacional;
            } else {
                return null;
            }
        } finally {
            if (conn != null)
                DataBaseConnection.desconectar(conn);
        }
    }
    
    public Estrangeiro buscarEstrangeiroPorPassaporte(String passaporte) throws SQLException {
        String sql = "SELECT * FROM estrangeiro WHERE passaporte = ?";
        Connection conn = null;

        try {
            conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, passaporte);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Estrangeiro estrangeiro = new Estrangeiro();
                estrangeiro.setId(rs.getLong("id"));
                estrangeiro.setNome(rs.getString("nome"));
                estrangeiro.setTelefone(rs.getString("telefone"));
                estrangeiro.setEmail(rs.getString("email"));
                estrangeiro.setPassaporte(rs.getString("passaporte"));
                return estrangeiro;
            } else {
                return null;
            }
        } finally {
            if (conn != null)
                DataBaseConnection.desconectar(conn);
        }
    }


}
