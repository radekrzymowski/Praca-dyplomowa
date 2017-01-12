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

public class ChildaPughActivity extends Activity {

    private int wynik = 0;
    private ArrayList<CheckBox> boxList = new ArrayList<>();
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childa_pugh);

        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_1_1));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_1_2));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_1_3));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_2_1));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_2_2));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_2_3));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_3_1));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_3_2));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_3_3));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_4_1));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_4_2));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_4_3));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_5_1));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_5_2));
        boxList.add((CheckBox) findViewById(R.id.skala_childa_pugh_czynnik_5_3));



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



    //sprawdzenie wyniku
    public void sprawdz_wynik(View view)
    {
        boolean all_checked = true;

        for(int i=0;i<15;i+=3)
        {
            if(!boxList.get(i).isChecked() && !boxList.get(i+1).isChecked() && !boxList.get(i+2).isChecked())
            {
                all_checked = false;

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Info");
                alertDialog.setMessage("zaznacz opcje w każdym punkcie");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                break;
            }
        }




        //wypisanie wyniku

        if(all_checked) {
            for(int i=0;i<15;i+=3)
            {
                if(boxList.get(i).isChecked())wynik+=1;
                if(boxList.get(i+1).isChecked())wynik+=2;
                if(boxList.get(i+2).isChecked())wynik+=3;
            }

            TextView textView_wynik = (TextView) findViewById(R.id.textView_wynik);
            TextView textView_punkty = (TextView) findViewById(R.id.textView_punkty);
            textView_punkty.setText("Punkty: " + wynik);
            if (wynik < 7) {
                textView_wynik.setText(getString(R.string.skala_childa_pugh_wynik_1));
            }
            else {
                if (wynik < 10) {
                    textView_wynik.setText(getString(R.string.skala_childa_pugh_wynik_2));
                }
                else
                {
                    textView_wynik.setText(getString(R.string.skala_childa_pugh_wynik_3));
                }
            }

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
        alertDialog.setMessage(getString(R.string.skala_childa_pugh_info));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void onCheckboxClicked_1(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();



        // Check which checkbox was clicked
        switch(view.getId()) {
            //czynnik 1
            case R.id.skala_childa_pugh_czynnik_1_1:
                if (checked)
                    boxList.get(1).setChecked(false);
                    boxList.get(2).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_1_2:
                if (checked)
                    boxList.get(0).setChecked(false);
                    boxList.get(2).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_1_3:
                if (checked)
                    boxList.get(0).setChecked(false);
                    boxList.get(1).setChecked(false);
                break;
            //czynnik 2
            case R.id.skala_childa_pugh_czynnik_2_1:
                if (checked)
                    boxList.get(4).setChecked(false);
                    boxList.get(5).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_2_2:
                if (checked)
                    boxList.get(3).setChecked(false);
                    boxList.get(5).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_2_3:
                if (checked)
                    boxList.get(3).setChecked(false);
                    boxList.get(4).setChecked(false);
                break;
            //czynnik 3
            case R.id.skala_childa_pugh_czynnik_3_1:
                if (checked)
                    boxList.get(7).setChecked(false);
                    boxList.get(8).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_3_2:
                if (checked)
                    boxList.get(6).setChecked(false);
                    boxList.get(8).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_3_3:
                if (checked)
                    boxList.get(6).setChecked(false);
                    boxList.get(7).setChecked(false);
                break;
            //czynnnik 4
            case R.id.skala_childa_pugh_czynnik_4_1:
                if (checked)
                    boxList.get(10).setChecked(false);
                    boxList.get(11).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_4_2:
                if (checked)
                    boxList.get(9).setChecked(false);
                    boxList.get(11).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_4_3:
                if (checked)
                    boxList.get(9).setChecked(false);
                    boxList.get(10).setChecked(false);
                break;
            //czynnik 5
            case R.id.skala_childa_pugh_czynnik_5_1:
                if (checked)
                    boxList.get(13).setChecked(false);
                    boxList.get(14).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_5_2:
                if (checked)
                    boxList.get(12).setChecked(false);
                    boxList.get(14).setChecked(false);
                break;
            case R.id.skala_childa_pugh_czynnik_5_3:
                if (checked)
                    boxList.get(12).setChecked(false);
                boxList.get(13).setChecked(false);
                break;
            // TODO: Veggie sandwich
        }
    }

}
