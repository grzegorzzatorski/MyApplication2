package com.example.zeti.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zeti on 8/6/2014.
 */
public class Pacjent implements Parcelable {

    private int id;
    private String name;
    private String surename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Pacjent(){
        super();
    }

    Pacjent(String imie, String nazwisko){

        super();
        name=imie;
        surename=nazwisko;
    }

    Pacjent(String imie, String nazwisko, int id){
        name=imie;
        surename=nazwisko;
        this.id = id;
    }

    @Override
    public String toString() {
        return  name + " " + surename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surename);
        dest.writeInt(id);

    }

    private void readFromParcel(Parcel in){
        name = in.readString();
        surename = in.readString();
        id = in.readInt();
    }

    public Pacjent(Parcel in){
        readFromParcel(in);
    }

    public static final Creator<Pacjent> CREATOR = new Parcelable.Creator<Pacjent>() {

        @Override
        public Pacjent createFromParcel(Parcel source) {
            return new Pacjent(source);
        }

        @Override
        public Pacjent[] newArray(int size) {
            return new Pacjent[size];
        }
    };
}
