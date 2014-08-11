package com.example.zeti.myapplication;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeti.myapplication.R;

public class DodajWizyte extends Activity {


    private static Pacjent pacjent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wizyte);
        if (savedInstanceState == null) {
             getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){


        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode == RESULT_OK) {
                pacjent = data.getParcelableExtra("pacjent");

                TextView txt = (TextView)findViewById(R.id.danePacjenta);
                txt.setText(pacjent.getName()+ " " + pacjent.getSurename());

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dodaj_wizyte, menu);
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

        private EditText data, godzina;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_dodaj_wizyte, container, false);
            Button wybierzPacjenta = (Button)rootView.findViewById(R.id.dodajPacjenta);


            wybierzPacjenta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent dodajPacjenta = new Intent(getActivity(), WybierzPacjenta.class);
                    getActivity().startActivityForResult(dodajPacjenta, 1);
                }
            });

            Button dodajWizyte = (Button)rootView.findViewById(R.id.dodajwizytedobazy);
            data = (EditText) rootView.findViewById(R.id.data);
            godzina = (EditText) rootView.findViewById(R.id.godzina);




            dodajWizyte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DatabaseManager dbmgr = new DatabaseManager(getActivity(), "database.db", null, 2);
                    Pacjent p = pacjent;

                    if(p != null) {

                       dbmgr.addWizyta(new Wizyta(pacjent.getId(), data.getText().toString(), godzina.getText().toString()));
                       getActivity().finish();
                    }
                }
            });

            return rootView;
        }

    }
}
