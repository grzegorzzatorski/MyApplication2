package com.example.zeti.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.zeti.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class WyswietlWizyty extends Activity {

    private ArrayAdapter<WizytyLista> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl_wizyty);


        DatabaseManager dbmgr = new DatabaseManager(this, "database.db", null, 2);
        List<WizytyLista> lista = new ArrayList<WizytyLista>();
        lista=dbmgr.getAllWizyty();

        ListView list1 = (ListView) findViewById(R.id.list_view);
        EditText searchbox = (EditText) findViewById(R.id.inputSearch);

        adapter = new ArrayAdapter<WizytyLista>(this,
                R.layout.list_item, lista);

        list1.setAdapter(adapter);

        searchbox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                WyswietlWizyty.this.adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wyswietl_wizyty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
