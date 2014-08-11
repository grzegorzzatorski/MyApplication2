package com.example.zeti.myapplication;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zeti.myapplication.R;

public class Dodaj extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dodaj, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

       private EditText imie, nazwisko;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_dodaj, container, false);

            Button buton = (Button)rootView.findViewById(R.id.button);
            imie = (EditText)rootView.findViewById(R.id.imie2);
            nazwisko = (EditText) rootView.findViewById(R.id.nazwisko);


            buton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DatabaseManager dbmgr = new DatabaseManager(getActivity(), "database.db", null, 2);

                    if(imie.getText().equals(null) || nazwisko.getText().equals(null)){
                        Toast.makeText(getActivity(), "Puste Imie lub Nazwisko", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        dbmgr.addPacjent(new Pacjent(imie.getText().toString(), nazwisko.getText().toString()));
                        getActivity().finish();
                    }
                }
            });

            return rootView;
        }
    }
}
