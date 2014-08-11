package com.example.zeti.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeti on 8/7/2014.
 */
public class DatabaseManager extends SQLiteOpenHelper {


    public DatabaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table users(" +
                        "id integer primary key autoincrement, " +
                        "imie text," +
                        "nazwisko text" +
                        ")"
        );
        db.execSQL(
                "create table wizyty(" +
                        "id integer primary key autoincrement, " +
                        "id_user integer, " +
                        "data text," +
                        "godzina text," +
                        "FOREIGN KEY(id_user) REFERENCES users(id)" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS wizyty");
        db.execSQL("DROP TABLE IF EXISTS users");
        this.onCreate(db);

    }

    public void addPacjent(Pacjent p){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("imie", p.getName());
        values.put("nazwisko", p.getSurename());
        db.insertOrThrow("users",null,values);

    }

    public void addWizyta(Wizyta w){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_user", w.getId_user());
        values.put("data", w.getData());
        values.put("godzina", w.getGodzina());
        db.insertOrThrow("wizyty", null, values);
    }

    public List<Pacjent> getAll(){

        List<Pacjent> lista = new ArrayList<Pacjent>();
        String[] columns = {"id", "imie", "nazwisko"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("users", columns,null, null, null, null, null);

        while(kursor.moveToNext()){
            Pacjent pacjent = new Pacjent();
            pacjent.setId(kursor.getInt(0));
            pacjent.setName(kursor.getString(1));
            pacjent.setSurename(kursor.getString(2));
            lista.add(pacjent);
        }

        return lista;
    }

    public List<WizytyLista> getAllWizyty(){

        List<WizytyLista> lista = new ArrayList<WizytyLista>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.rawQuery("SELECT users.imie, users.nazwisko, wizyty.data, wizyty.godzina FROM wizyty JOIN users ON wizyty.id_user=users.id",null);

        while(kursor.moveToNext()){
            WizytyLista w = new WizytyLista();
            w.setImie(kursor.getString(0));
            w.setNazwisko(kursor.getString(1));
            w.setData(kursor.getString(2));
            w.setGodzina(kursor.getString(3));
            lista.add(w);
        }

        return lista;
    }

    public void deletePacjent(int id){

        SQLiteDatabase db = getWritableDatabase();
        String[] args = {""+id};
        db.delete("wizyty","id_user=?",args);
        db.delete("users", "id=?", args);

    }


}
