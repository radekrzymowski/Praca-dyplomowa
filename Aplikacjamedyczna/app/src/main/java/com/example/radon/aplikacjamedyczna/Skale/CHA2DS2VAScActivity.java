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

public class CHA2DS2VAScActivity extends Activity {

    private int wynik = 0;
    private ArrayList<CheckBox> boxList = new ArrayList<>();
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha2_ds2_vasc);

        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_1));
        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_2));
        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_3));
        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_4));
        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_5));
        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_6));
        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_7));
        boxList.add((CheckBox)findViewById(R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_8));


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this,3);
        mDrawerList.setAdapter(drawerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cha2_ds2_vasc_, menu);
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
        for(int i=0;i<8;i++)
        {
            if(boxList.get(i).isChecked()) {
                if (i == 2 || i == 4)wynik+=2;
                else wynik++;
            }
        }

        //wypisanie wyniku

        TextView textView_wynik = (TextView) findViewById(R.id.textView_wynik);
        TextView textView_punkty = (TextView) findViewById(R.id.textView_punkty);
        textView_punkty.setText("Punkty: "+wynik);
        if(wynik==0){
            textView_wynik.setText(R.string.skala_cha2_ds2_vasc_wynik_1);
        }
        else{
            textView_wynik.setText(R.string.skala_cha2_ds2_vasc_wynik_2);
        }
        wynik = 0;
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_1:
                if (checked)
                wynik++;
                else

                break;
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_2:
                if (checked)
                    wynik++;
                else

                    break;
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_3:
                if (checked)
                    wynik++;
                else

                    break;
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_4:
                if (checked)
                    wynik++;
                else

                    break;
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_5:
                if (checked)
                    wynik++;
                else

                    break;
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_6:
                if (checked)
                    wynik++;
                else

                    break;
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_7:
                if (checked)
                    wynik++;
                else

                    break;
            case R.id.skala_cha2_ds2_vasc_czynnik_ryzyka_8:
                if (checked)
                    wynik++;
                else

                    break;
            // TODO: Veggie sandwich
        }
    }

    public void open_menu(View view)
    {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    public void drawerClose(View view)
    {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }


    public void open_add_dialog_6(View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage(getString(R.string.skala_cha2_ds2_vasc_czynnik_6_odnosnik));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void open_info(View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage(getString(R.string.skala_cha2_ds2_vasc_info));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
