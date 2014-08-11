package com.example.zeti.myapplication;

/**
 * Created by Zeti on 8/10/2014.
 */
public class Wizyta {

    private int id;
    private int id_user;
    private String data;
    private String godzina;

    Wizyta(int id_user, String data, String godzina){
        this.id_user = id_user;
        this.data = data;
        this.godzina = godzina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }
}
