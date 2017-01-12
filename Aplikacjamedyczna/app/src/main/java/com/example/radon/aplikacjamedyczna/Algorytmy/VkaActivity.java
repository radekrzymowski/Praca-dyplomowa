package com.example.radon.aplikacjamedyczna.Algorytmy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;


import com.example.radon.aplikacjamedyczna.Algorytmy.VkaFragments.VkaFragmentStep1;
import com.example.radon.aplikacjamedyczna.Algorytmy.VkaFragments.VkaFragmentStep2_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.VkaFragments.VkaFragmentStep2_2;
import com.example.radon.aplikacjamedyczna.Algorytmy.VkaFragments.VkaFragmentStep2_3;
import com.example.radon.aplikacjamedyczna.Algorytmy.VkaFragments.VkaFragmentStep2_4;
import com.example.radon.aplikacjamedyczna.Algorytmy.VkaFragments.VkaFragmentStep2_5;
import com.example.radon.aplikacjamedyczna.Algorytmy.VkaFragments.VkaFragmentStep2_6;
import com.example.radon.aplikacjamedyczna.MenuAdapter;
import com.example.radon.aplikacjamedyczna.R;

public class VkaActivity extends Activity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vka);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this,2);
        mDrawerList.setAdapter(drawerAdapter);


        VkaFragmentStep1 s = new VkaFragmentStep1();
        FragmentManager fm  = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.fragment_container, s);
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

    public void open_menu(View view)
    {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    public void drawerClose(View view)
    {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public void VkaStep1CheckBoxClick(View v)
    {
        boolean checked = ((CheckBox) v).isChecked();
        CheckBox c1 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_1);
        CheckBox c2 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_2);
        CheckBox c3 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_3);

        switch (v.getId())
        {
            case R.id.Vka_step1_checkbox_1:
                if(checked)
                    c2.setChecked(false);
                    c3.setChecked(false);
                break;

            case R.id.Vka_step1_checkbox_2:
                if(checked)
                    c1.setChecked(false);
                    c3.setChecked(false);
                break;
            case R.id.Vka_step1_checkbox_3:
                if(checked)
                    c1.setChecked(false);
                    c2.setChecked(false);
                break;
        }
    }

    public void buttonYes(View v)
    {
        CheckBox c1 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_1);
        CheckBox c2 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_2);
        CheckBox c3 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_3);


        VkaFragmentStep2_1 step2_1 = new VkaFragmentStep2_1();
        VkaFragmentStep2_3 step2_3 = new VkaFragmentStep2_3();
        VkaFragmentStep2_5 step2_5 = new VkaFragmentStep2_5();

        FragmentManager fm  = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();




        if(c1.isChecked()){
            transaction.replace(R.id.fragment_container, step2_1);
            transaction.commit();
        }
        if(c2.isChecked()){
            transaction.replace(R.id.fragment_container, step2_3);
            transaction.commit();
        }
        if(c3.isChecked()){
            transaction.replace(R.id.fragment_container, step2_5);
            transaction.commit();
        }
    }

    public void buttonNo(View v)
    {
        CheckBox c1 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_1);
        CheckBox c2 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_2);
        CheckBox c3 = (CheckBox)findViewById(R.id.Vka_step1_checkbox_3);

        VkaFragmentStep2_2 step2_2 = new VkaFragmentStep2_2();
        VkaFragmentStep2_4 step2_4 = new VkaFragmentStep2_4();
        VkaFragmentStep2_6 step2_6 = new VkaFragmentStep2_6();

        FragmentManager fm  = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        if(c1.isChecked()){
            transaction.replace(R.id.fragment_container, step2_2);
            transaction.commit();
        }
        if(c2.isChecked()){
            transaction.replace(R.id.fragment_container, step2_4);
            transaction.commit();
        }
        if(c3.isChecked()){
            transaction.replace(R.id.fragment_container, step2_6);
            transaction.commit();
        }
    }

    public void buttonBack(View v)
    {
        FragmentManager fm  = getFragmentManager();
        Fragment f = getFragmentManager().findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = fm.beginTransaction();

        VkaFragmentStep1 s = new VkaFragmentStep1();

        if(!(f instanceof VkaFragmentStep1))
        {
            transaction.replace(R.id.fragment_container, s);
            transaction.commit();
        }
    }

}