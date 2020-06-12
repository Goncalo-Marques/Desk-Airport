package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import model.bean.Piloto;

public class PilotoDao {

    public void Create(Piloto piloto) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO piloto (NomeP, Morada, Localidade, Idade) VALUES(?,?,?,?)");
            stmt.setString(1, piloto.getNomeP());
            stmt.setString(2, piloto.getMorada());
            stmt.setString(3, piloto.getLocalidade());
            stmt.setInt(4, piloto.getIdade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Piloto criado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Piloto> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Piloto> pilotos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM piloto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Piloto piloto = new Piloto();

                piloto.setIdPiloto(rs.getInt("IdPiloto"));
                piloto.setNomeP(rs.getString("NomeP"));
                piloto.setMorada(rs.getString("Morada"));
                piloto.setLocalidade(rs.getString("Localidade"));
                piloto.setIdade(rs.getInt("Idade"));

                pilotos.add(piloto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PilotoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pilotos;
    }

    public void update(Piloto piloto) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE piloto SET NomeP = ?, Morada = ?, Localidade = ?, Idade = ? WHERE IdPiloto = ?");
            stmt.setString(1, piloto.getNomeP());
            stmt.setString(2, piloto.getMorada());
            stmt.setString(3, piloto.getLocalidade());
            stmt.setInt(4, piloto.getIdade());
            stmt.setInt(5, piloto.getIdPiloto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Piloto atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Piloto piloto) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM piloto WHERE IdPiloto = ?");
            stmt.setInt(1, piloto.getIdPiloto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Piloto excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Piloto readId(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Piloto piloto = new Piloto();

        try {
            stmt = con.prepareStatement("SELECT * FROM piloto WHERE IdPiloto = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                piloto.setIdPiloto(rs.getInt("IdPiloto"));
                piloto.setNomeP(rs.getString("NomeP"));
                piloto.setMorada(rs.getString("Morada"));
                piloto.setLocalidade(rs.getString("Localidade"));
                piloto.setIdade(rs.getInt("Idade"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PilotoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return piloto;
    }
}
