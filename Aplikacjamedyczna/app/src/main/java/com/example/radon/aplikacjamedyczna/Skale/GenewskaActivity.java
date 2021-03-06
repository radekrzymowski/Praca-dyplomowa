package com.example.radon.aplikacjamedyczna.Skale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.radon.aplikacjamedyczna.MenuAdapter;
import com.example.radon.aplikacjamedyczna.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenewskaActivity extends Activity {

    private int wynik = 0;
    private ArrayList<CheckBox> boxList = new ArrayList<>();
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private Map<CheckBox,Integer> myMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genewska);

        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_1));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_2));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_3));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_4));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_5));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_6));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_7));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_8));
        boxList.add((CheckBox) findViewById(R.id.skala_genewska_czynnik_ryzyka_9));


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this,3);
        mDrawerList.setAdapter(drawerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_has_bled_actvity, menu);
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
    public void sprawdz_wynik(View view)
    {

        for(int i=0;i<boxList.size();i++)
        {
            if(boxList.get(i).isChecked())
            {
                switch (i)
                {
                    case 0: wynik+=1; break;
                    case 1: wynik+=3; break;
                    case 2: wynik+=2; break;
                    case 3: wynik+=2; break;
                    case 4: wynik+=3; break;
                    case 5: wynik+=2; break;
                    case 6: wynik+=3; break;
                    case 7: wynik+=5; break;
                    case 8: wynik+=4; break;
                }
            }
        }
        //wypisanie wyniku

        TextView textView_wynik = (TextView) findViewById(R.id.textView_wynik);
        TextView textView_punkty = (TextView) findViewById(R.id.textView_punkty);
        textView_punkty.setText("Punkty: "+wynik);
        if(wynik<4){
            textView_wynik.setText(getString(R.string.skala_genewska_wynik_1));
        }
        else{
            if(wynik<11) textView_wynik.setText(getString(R.string.skala_genewska_wynik_2));
            else textView_wynik.setText(getString(R.string.skala_genewska_wynik_3));
        }
        wynik = 0;
    }



    public void open_menu(View view)
    {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    public void drawerClose(View view)
    {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }




    public void open_info(View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage(getString(R.string.skala_genewska_info));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
