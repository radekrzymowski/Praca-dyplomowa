package com.example.radon.aplikacjamedyczna.Algorytmy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.radon.aplikacjamedyczna.Algorytmy.BradykardiaFragments.BradykardiaFragment1_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.BradykardiaFragments.BradykardiaFragment2_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.BradykardiaFragments.BradykardiaFragment3_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.BradykardiaFragments.BradykardiaFragment3_2;
import com.example.radon.aplikacjamedyczna.Algorytmy.BradykardiaFragments.BradykardiaFragment4_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.BradykardiaFragments.BradykardiaFragment4_2;
import com.example.radon.aplikacjamedyczna.Algorytmy.BradykardiaFragments.BradykardiaFragment5_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment1_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment2_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment2_2;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment2_3;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment3_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment3_2;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment4_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment4_2;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment4_3;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment4_4;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment6_1;
import com.example.radon.aplikacjamedyczna.Algorytmy.TachykardiaFragments.TachykardiaFragment6_2;
import com.example.radon.aplikacjamedyczna.MenuAdapter;
import com.example.radon.aplikacjamedyczna.R;

import java.util.Stack;

public class TachykardiaActivity extends Activity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private TachykardiaFragment1_1 tf1_1 = new TachykardiaFragment1_1();
    private TachykardiaFragment2_1 tf2_1 = new TachykardiaFragment2_1();
    private TachykardiaFragment2_2 tf2_2 = new TachykardiaFragment2_2();
    private TachykardiaFragment2_3 tf2_3 = new TachykardiaFragment2_3();
    private TachykardiaFragment3_1 tf3_1 = new TachykardiaFragment3_1();
    private TachykardiaFragment3_2 tf3_2 = new TachykardiaFragment3_2();
    private TachykardiaFragment4_1 tf4_1 = new TachykardiaFragment4_1();
    private TachykardiaFragment4_2 tf4_2 = new TachykardiaFragment4_2();
    private TachykardiaFragment4_3 tf4_3 = new TachykardiaFragment4_3();
    private TachykardiaFragment4_4 tf4_4 = new TachykardiaFragment4_4();
    private TachykardiaFragment6_1 tf6_1 = new TachykardiaFragment6_1();
    private TachykardiaFragment6_2 tf6_2 = new TachykardiaFragment6_2();

    private Stack<Fragment> fragmentStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tachykardia);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this,2);
        mDrawerList.setAdapter(drawerAdapter);



        FragmentManager fm  = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.fragment_container, tf1_1);
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

    public void buttonYes(View v)
    {
        FragmentManager fm  = getFragmentManager();
        Fragment f = getFragmentManager().findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = fm.beginTransaction();

        if(f instanceof TachykardiaFragment1_1)
        {
            fragmentStack.push(tf1_1);
            transaction.replace(R.id.fragment_container, tf2_2);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment2_2)
        {
            fragmentStack.push(tf2_2);
            transaction.replace(R.id.fragment_container, tf2_1);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment2_3)
        {
            fragmentStack.push(tf2_3);
            transaction.replace(R.id.fragment_container, tf3_1);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment3_1)
        {
            fragmentStack.push(tf3_1);
            transaction.replace(R.id.fragment_container, tf4_1);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment3_2)
        {
            fragmentStack.push(tf3_2);
            transaction.replace(R.id.fragment_container, tf4_3);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment4_3)
        {
            fragmentStack.push(tf4_3);
            transaction.replace(R.id.fragment_container, tf6_1);
            transaction.commit();
        }
    }

    public void buttonNo(View v)
    {
        FragmentManager fm  = getFragmentManager();
        Fragment f = getFragmentManager().findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = fm.beginTransaction();

        if(f instanceof TachykardiaFragment2_2)
        {
            fragmentStack.push(tf2_2);
            transaction.replace(R.id.fragment_container, tf2_3);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment2_3)
        {
            fragmentStack.push(tf2_3);
            transaction.replace(R.id.fragment_container, tf3_2);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment3_1)
        {
            fragmentStack.push(tf3_1);
            transaction.replace(R.id.fragment_container, tf4_2);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment3_2)
        {
            fragmentStack.push(tf3_2);
            transaction.replace(R.id.fragment_container, tf4_4);
            transaction.commit();
        }
        if(f instanceof TachykardiaFragment4_3)
        {
            fragmentStack.push(tf4_3);
            transaction.replace(R.id.fragment_container, tf6_2);
            transaction.commit();
        }
    }

    public void buttonBack(View v)
    {
        FragmentManager fm  = getFragmentManager();
        Fragment f = getFragmentManager().findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = fm.beginTransaction();

        try {
            Fragment previous = fragmentStack.pop();
            transaction.replace(R.id.fragment_container, previous);
            transaction.commit();
        }
        catch (Exception e)
        {

        }
    }

}
