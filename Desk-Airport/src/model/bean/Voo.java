package model.bean;

import java.sql.Date;
import java.sql.Time;

public class Voo {

    private String num;
    private String matr;
    private Date data;
    private Time hora;
    private String de;
    private String para;
    private int idPiloto;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
