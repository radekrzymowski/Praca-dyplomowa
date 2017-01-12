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
import android.widget.ListView;
import android.widget.TextView;

import com.example.radon.aplikacjamedyczna.MenuAdapter;
import com.example.radon.aplikacjamedyczna.R;

import java.io.OutputStream;
import java.text.DecimalFormat;

public class BmiActivity extends Activity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private EditText masa;
    private EditText wzrost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);




        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this,2);
        mDrawerList.setAdapter(drawerAdapter);


        masa = (EditText)findViewById(R.id.editText_masa);
        wzrost = (EditText)findViewById(R.id.editText_wzrost);

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


    public void oblicz(View v)
    {
        TextView wynik = (TextView) findViewById(R.id.textView_odpowiedz);
        Double tmp;
        try{
            double m = Double.valueOf(masa.getText().toString());
            double w = Double.valueOf(wzrost.getText().toString());

            tmp = m/Math.pow(w,2);
            DecimalFormat df = new DecimalFormat("#.##");
            df.format(tmp);

            if(tmp < 16.0)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien1));
            if(tmp >= 16.0 && tmp <= 16.99)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien2));
            if(tmp >= 17.0 && tmp <= 18.49)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien3));
            if(tmp >= 18.5 && tmp <= 24.99)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien4));
            if(tmp >= 25.0 && tmp <= 29.99)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien5));
            if(tmp >= 30.0 && tmp <= 34.99)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien6));
            if(tmp >= 35.0 && tmp <= 39.99)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien7));
            if(tmp >= 40.0)wynik.setText(df.format(tmp) + "\n" + getString(R.string.bmi_stopien8));
        }
        catch(Exception e)
        {
            System.out.println("**************** " + e + " *** ");
        }

    }
}
