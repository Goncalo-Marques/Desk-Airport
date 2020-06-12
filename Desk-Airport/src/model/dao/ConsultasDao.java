package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Aviao;
import model.bean.Marca;
import model.bean.Piloto;
import model.bean.Voo;

public class ConsultasDao {

    public List<Marca> readMarcasPiloto(int i) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT Distinct marca.Marca, marca.Lugares, marca.Autonomia FROM marca INNER JOIN (aviao INNER JOIN (piloto_has_aviao INNER JOIN piloto ON piloto_has_aviao.piloto_IdPiloto=piloto.IdPiloto) ON aviao.Matr=piloto_has_aviao.aviao_Matr) ON marca.Marca=aviao.Marca WHERE piloto.IdPiloto=? ORDER BY marca.Marca ASC");
            stmt.setInt(1, i);

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

    public List<Piloto> readPilotoVooData(Date d) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Piloto> pilotos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT piloto.* FROM piloto INNER JOIN voo ON piloto.IdPiloto=voo.IdPiloto WHERE voo.Data=? ORDER BY piloto.IdPiloto ASC");
            stmt.setDate(1, d);

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

    public List<Aviao> readAviaoAutonomia(String operacao, float autonomia) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aviao> avioes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT aviao.* FROM aviao INNER JOIN marca ON aviao.Marca=marca.Marca WHERE marca.Autonomia" + operacao + "? ORDER BY aviao.NomeA");
            stmt.setFloat(1, autonomia);

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

    public List<Piloto> readPilotoPilotaramTodasMarcas() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Piloto> pilotos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT piloto.* FROM piloto INNER JOIN(piloto_has_aviao INNER JOIN(aviao INNER JOIN marca ON aviao.Marca=marca.marca) ON piloto_has_aviao.aviao_Matr=aviao.Matr) ON piloto.IdPiloto=piloto_has_aviao.piloto_IdPiloto GROUP BY piloto.IdPiloto HAVING COUNT(DISTINCT(marca.Marca))=(SELECT COUNT(marca.Marca) FROM marca)");

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

    public List<Voo> readVooAviao(String s) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Voo> voos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT voo.* FROM voo INNER JOIN(piloto INNER JOIN(piloto_has_aviao INNER JOIN aviao ON piloto_has_aviao.aviao_Matr=aviao.Matr) ON piloto.IdPiloto=piloto_has_aviao.piloto_IdPiloto) ON voo.IdPiloto=piloto.IdPiloto WHERE aviao.Matr=?");
            stmt.setString(1, s);

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

    public Aviao readAviaoByMatr(String s) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aviao aviao = new Aviao();

        try {
            stmt = con.prepareStatement("SELECT * FROM aviao WHERE Matr=?");
            stmt.setString(1, s);

            rs = stmt.executeQuery();

            while (rs.next()) {

                aviao.setMatr(rs.getString("Matr"));
                aviao.setNomeA(rs.getString("NomeA"));
                aviao.setMarca(rs.getString("Marca"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OutrosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return aviao;
    }
}
