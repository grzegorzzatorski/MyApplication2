package com.example.zeti.myapplication;

import android.app.Activity;
import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.content.Intent;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);


        Button dodaj = (Button) rootView.findViewById(R.id.dodaj);
        Button wyswietl = (Button) rootView.findViewById(R.id.wyswietl);
        Button dodajWizyte = (Button) rootView.findViewById(R.id.dodajWizyte);
        Button wyswietlwizyty = (Button) rootView.findViewById(R.id.wyswietlWizyty);


        dodaj.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v){

                                         Intent i = new Intent(getActivity(), Dodaj.class);
                                         startActivity(i);
                                     }
                                 }
        );

        wyswietl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wyswietl = new Intent(getActivity(), Wyswietl.class);
                startActivity(wyswietl);
            }
        });

        dodajWizyte.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v){

            Intent dodajw = new Intent(getActivity(), DodajWizyte.class);
            startActivity(dodajw);
        }}

        );

        wyswietlwizyty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wyswietlwizyty = new Intent(getActivity(), WyswietlWizyty.class);
                startActivity(wyswietlwizyty);
            }
        });



        return rootView;
    }
}
}
