package com.example.zeti.myapplication;

/**
 * Created by Zeti on 8/11/2014.
 */
public class WizytyLista{

    private String imie;
    private String nazwisko;
    private String godzina;
    private String data;

    WizytyLista(){
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    WizytyLista(String imie, String nazwisko, String godzina, String data){

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.godzina = godzina;
        this.data = data;

    }

    @Override
    public String toString() {
        return  imie + " " +  nazwisko + " " + godzina + " " + data;
    }
}
