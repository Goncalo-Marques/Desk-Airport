package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import model.bean.Voo;

public class VooDao {

    public void Create(Voo voo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO voo (Num, Matr, Data, Hora, De, Para, IdPiloto) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, voo.getNum());
            stmt.setString(2, voo.getMatr());
            stmt.setDate(3, voo.getData());
            stmt.setTime(4, voo.getHora());
            stmt.setString(5, voo.getDe());
            stmt.setString(6, voo.getPara());
            stmt.setInt(7, voo.getIdPiloto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Voo criado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Voo> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Voo> voos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM voo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Voo voo = new Voo();

                voo.setNum(rs.getString("Num"));
                voo.setMatr(rs.getString("Matr"));
                voo.setData(rs.getDate("Data"));
                voo.setHora(rs.getTime("Hora"));
                voo.setDe(rs.getString("De"));
                voo.setPara(rs.getString("Para"));
                voo.setIdPiloto(rs.getInt("IdPiloto"));

                voos.add(voo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PilotoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return voos;
    }

    public void update(Voo voo) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE voo SET Matr = ?, Data = ?, Hora = ?, De = ?, Para = ?, IdPiloto = ? WHERE Num = ?");
            stmt.setString(1, voo.getMatr());
            stmt.setDate(2, voo.getData());
            stmt.setTime(3, voo.getHora());
            stmt.setString(4, voo.getDe());
            stmt.setString(5, voo.getPara());
            stmt.setInt(6, voo.getIdPiloto());
            stmt.setString(7, voo.getNum());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Voo atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Voo voo) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM voo WHERE Num = ?");
            stmt.setString(1, voo.getNum());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Voo excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Voo readNum(String num) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Voo voo = new Voo();

        try {
            stmt = con.prepareStatement("SELECT * FROM voo WHERE Num = ?");
            stmt.setString(1, num);
            rs = stmt.executeQuery();

            while (rs.next()) {
                voo.setNum(rs.getString("Num"));
                voo.setMatr(rs.getString("Matr"));
                voo.setData(rs.getDate("Data"));
                voo.setHora(rs.getTime("Hora"));
                voo.setDe(rs.getString("De"));
                voo.setPara(rs.getString("Para"));
                voo.setIdPiloto(rs.getInt("IdPiloto"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PilotoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return voo;
    }
}
