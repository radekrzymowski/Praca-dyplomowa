package com.example.radon.aplikacjamedyczna.Algorytmy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
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
import com.example.radon.aplikacjamedyczna.MenuAdapter;
import com.example.radon.aplikacjamedyczna.R;

import java.util.Stack;

public class BradykardiaActivity extends Activity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private BradykardiaFragment1_1 bf1_1 = new BradykardiaFragment1_1();
    private BradykardiaFragment2_1 bf2_1 = new BradykardiaFragment2_1();
    private BradykardiaFragment3_1 bf3_1 = new BradykardiaFragment3_1();
    private BradykardiaFragment3_2 bf3_2 = new BradykardiaFragment3_2();
    private BradykardiaFragment4_1 bf4_1 = new BradykardiaFragment4_1();
    private BradykardiaFragment4_2 bf4_2 = new BradykardiaFragment4_2();
    private BradykardiaFragment5_1 bf5_1 = new BradykardiaFragment5_1();
    private Stack<Fragment> fragmentStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bradykardia);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.navList);

        //set adapter for drawer list
        MenuAdapter drawerAdapter = new MenuAdapter(this,2);
        mDrawerList.setAdapter(drawerAdapter);



        FragmentManager fm  = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.fragment_container, bf1_1);
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

        if(f instanceof BradykardiaFragment1_1)
        {
            fragmentStack.push(bf1_1);
            transaction.replace(R.id.fragment_container, bf2_1);
            transaction.commit();
        }
        if(f instanceof BradykardiaFragment2_1)
        {
            fragmentStack.push(bf2_1);
            transaction.replace(R.id.fragment_container, bf3_1);
            transaction.commit();
        }
        if(f instanceof BradykardiaFragment3_1)
        {
            fragmentStack.push(bf3_1);
            transaction.replace(R.id.fragment_container, bf3_2);
            transaction.commit();
        }
        if(f instanceof BradykardiaFragment3_2)
        {
            fragmentStack.push(bf3_2);
            transaction.replace(R.id.fragment_container, bf4_1);
            transaction.commit();
        }
        if(f instanceof BradykardiaFragment4_1)
        {
            fragmentStack.push(bf4_1);
            transaction.replace(R.id.fragment_container, bf5_1);
            transaction.commit();
        }
    }

    public void buttonNo(View v)
    {
        FragmentManager fm  = getFragmentManager();
        Fragment f = getFragmentManager().findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = fm.beginTransaction();

        if(f instanceof BradykardiaFragment2_1)
        {
            fragmentStack.push(bf2_1);
            transaction.replace(R.id.fragment_container, bf3_2);
            transaction.commit();
        }
        if(f instanceof BradykardiaFragment3_1)
        {
            fragmentStack.push(bf3_1);
            transaction.replace(R.id.fragment_container, bf4_1);
            transaction.commit();
        }
        if(f instanceof BradykardiaFragment3_2)
        {
            fragmentStack.push(bf3_2);
            transaction.replace(R.id.fragment_container, bf4_2);
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
