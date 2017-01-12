package com.example.radon.aplikacjamedyczna.Kalkulatory;

import android.app.Activity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.radon.aplikacjamedyczna.MenuAdapter;
import com.example.radon.aplikacjamedyczna.R;

public class DopaminaActivity extends Activity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private EditText dawka;
    private EditText waga;
    private EditText pompa_mg;
    private EditText pompa_ml;
    private EditText wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dopamina);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this,2);
        mDrawerList.setAdapter(drawerAdapter);


        dawka = (EditText) findViewById(R.id.editText_dose);
        waga = (EditText) findViewById(R.id.editText_weight);
        pompa_mg = (EditText) findViewById(R.id.editText_pompa_mg);
        pompa_ml = (EditText) findViewById(R.id.editText_pompa_ml);
        wynik = (EditText) findViewById(R.id.editText_result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_skale, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void open_menu(View view)
    {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    public void drawerClose(View view)
    {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public void checkResult(View v)
    {
        try{
        double tmpDawka = Double.valueOf(dawka.getText().toString());
        double tmpWaga = Double.valueOf(waga.getText().toString());

        double tmpPompaMg = Double.valueOf(pompa_mg.getText().toString());
        double tmpPompaMl = Double.valueOf(pompa_ml.getText().toString());

        double tmpWynik1;
        double tmpWynik2;

        tmpWynik1 = 60 * (tmpDawka*tmpWaga)/1000;
        tmpWynik2 = (tmpWynik1/tmpPompaMg)*tmpPompaMl;



            wynik.setText(String.valueOf(tmpWynik2));
        }
        catch (Exception e)
        {
            wynik.setText(0);
        }
    }
}
