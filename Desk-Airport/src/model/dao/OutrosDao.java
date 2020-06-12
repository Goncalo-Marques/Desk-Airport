package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Aviao;
import model.bean.Marca;
import model.bean.PilotoAviao;

public class OutrosDao {

    public List<Aviao> readAviao() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aviao> avioes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM aviao");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aviao aviao = new Aviao();

                aviao.setMatr(rs.getString("Matr"));
                aviao.setNomeA(rs.getString("NomeA"));
                aviao.setMarca(rs.getString("Marca"));

                avioes.add(aviao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OutrosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return avioes;
    }

    public List<Marca> readMarca() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM marca");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();

                marca.setMarca(rs.getString("Marca"));
                marca.setLugares(rs.getInt("lugares"));
                marca.setAutonomia(rs.getFloat("Autonomia"));

                marcas.add(marca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OutrosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return marcas;
    }

    public List<PilotoAviao> readPilotoAviao() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PilotoAviao> pilotoAvioes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM piloto_has_aviao");
            rs = stmt.executeQuery();

            while (rs.next()) {
                PilotoAviao pilotoAviao = new PilotoAviao();

                pilotoAviao.setPiloto_IdPiloto(rs.getInt("piloto_IdPiloto"));
                pilotoAviao.setAviao_Matr(rs.getString("aviao_Matr"));

                pilotoAvioes.add(pilotoAviao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OutrosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pilotoAvioes;
    }
}
