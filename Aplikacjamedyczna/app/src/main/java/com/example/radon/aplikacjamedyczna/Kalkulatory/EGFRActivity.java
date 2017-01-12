package com.example.radon.aplikacjamedyczna.Kalkulatory;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.radon.aplikacjamedyczna.Kalkulatory.EgfrFragments.Cocroft_GaultFragment;
import com.example.radon.aplikacjamedyczna.Kalkulatory.EgfrFragments.MDRDFragment;
import com.example.radon.aplikacjamedyczna.MenuAdapter;
import com.example.radon.aplikacjamedyczna.R;

public class EGFRActivity extends Activity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private Cocroft_GaultFragment cocroft_gaultFragment;
    private MDRDFragment mdrdFragment;


    private CheckBox box_cocroft;
    private CheckBox box_mdrd;

    private int selectedUnit = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egfr);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this, 2);
        mDrawerList.setAdapter(drawerAdapter);

        cocroft_gaultFragment = new Cocroft_GaultFragment();
        mdrdFragment = new MDRDFragment();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, cocroft_gaultFragment);
        transaction.commit();

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

    public void open_menu(View view) {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    public void drawerClose(View view) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public void checkResult(View v) {

    }

    public void onCheckboxClicked(View v) {
        box_cocroft = (CheckBox) findViewById(R.id.checkBox1);
        box_mdrd = (CheckBox) findViewById(R.id.checkBox2);

        boolean checked = ((CheckBox) v).isChecked();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();


        switch (v.getId()) {
            case R.id.checkBox1:
                if (checked) {
                    box_mdrd.setChecked(false);

                    transaction.replace(R.id.fragment_container, cocroft_gaultFragment);
                    transaction.commit();

                }
                ;
                break;

            case R.id.checkBox2:
                if (checked) {
                    box_cocroft.setChecked(false);

                    transaction.replace(R.id.fragment_container, mdrdFragment);
                    transaction.commit();
                }
                ;
                break;
        }
    }

    public void chooseUnit(View v)
    {
        TextView textView1 = (TextView) findViewById(R.id.textView_unit_micromole);
        TextView textView2 = (TextView) findViewById(R.id.textView_unit_miligram);

        switch (v.getId())
        {
            case R.id.textView_unit_micromole:
                textView1.setTextColor(Color.parseColor("#000000"));
                textView2.setTextColor(Color.parseColor("#808080"));
                selectedUnit = 1;
                break;
            case R.id.textView_unit_miligram:
                textView1.setTextColor(Color.parseColor("#808080"));
                textView2.setTextColor(Color.parseColor("#000000"));
                selectedUnit = 2;
                break;

        }
    }



    public void setWynikCocroftGault(View v)
    {
        CheckBox female = (CheckBox) findViewById(R.id.checkBox_Female);

        EditText wiek = (EditText) findViewById(R.id.editText_wiek);
        EditText masa = (EditText) findViewById(R.id.editText_masa);
        EditText kreat = (EditText) findViewById(R.id.editText_stezenie);
        EditText wynik = (EditText)findViewById(R.id.editText_wynik);
        double dwynik = 0;
        double dwiek = 0;
        double dmasa = 0;
        double dstezenie = 0;


        try {
            dwiek = Double.valueOf(wiek.getText().toString());
            dmasa = Double.valueOf(masa.getText().toString());
            dstezenie = Double.valueOf(kreat.getText().toString());

            Log.i("dwiek: ",Double.toString(dwiek));
            Log.i("dmasa: ",Double.toString(dmasa));
            Log.i("dstezenie: ",Double.toString(dstezenie));


            if(selectedUnit == 1) dstezenie/= 88.4;

            dwynik = ((140 - dwiek) * dmasa) / (dstezenie * 72);
            if (female.isChecked()) dwynik *= 0.85;
            Log.i("dstezenie2 : ",Double.toString(dstezenie));
            if(Double.isNaN(dwynik))dwynik = 0;
            if(Double.isInfinite(dwynik))dwynik = 0;
            wynik.setText(String.valueOf(dwynik));

        }
        catch (Exception e)
        {

        }
    }

    public void setWynikMdrd(View v)
    {
        CheckBox female = (CheckBox) findViewById(R.id.checkBox_Female);
        CheckBox race = (CheckBox) findViewById(R.id.checkBox_race);
        EditText wiek = (EditText) findViewById(R.id.editText_wiek);
        EditText kreat = (EditText) findViewById(R.id.editText_stezenie);
        EditText wynik = (EditText)findViewById(R.id.editText_wynik);
        double dwynik = 0;
        double dwiek = 0;
        double dmasa = 0;
        double dstezenie = 0;


        try {
            dwiek = Double.valueOf(wiek.getText().toString());
            dstezenie = Double.valueOf(kreat.getText().toString());



            if(selectedUnit == 1) dstezenie/= 88.4;

            dwynik = 175*Math.pow(dstezenie,-1.154)*Math.pow(dwiek,-0.203);

            if (female.isChecked()) dwynik *= 0.742;
            if(race.isChecked())dwynik*=1.21;
            Log.i("dstezenie2 : ",Double.toString(dstezenie));
            if(Double.isNaN(dwynik))dwynik = 0;
            if(Double.isInfinite(dwynik))dwynik = 0;
            wynik.setText(String.valueOf(dwynik));

        }
        catch (Exception e)
        {

        }
    }
}