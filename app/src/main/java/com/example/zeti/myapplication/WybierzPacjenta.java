package com.example.zeti.myapplication;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zeti.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class WybierzPacjenta extends Activity {

    private ListView list1;
    private List<Pacjent> lista;
    private ArrayAdapter<Pacjent> adapter;
    private EditText searchbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl);

        DatabaseManager dbmgr = new DatabaseManager(this, "database.db", null, 2);
        lista = dbmgr.getAll();

        list1 = (ListView) findViewById(R.id.list_view);
        searchbox = (EditText) findViewById(R.id.inputSearch);

        adapter = new ArrayAdapter<Pacjent>(this,
                R.layout.list_item, lista);

        list1.setAdapter(adapter);

        searchbox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                WybierzPacjenta.this.adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent pacjentData = new Intent();
                pacjentData.putExtra("pacjent", lista.get((int)id));
                setResult(RESULT_OK, pacjentData);

                Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx", lista.get((int)id).getName());
                finish();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wyswietl, menu);
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
