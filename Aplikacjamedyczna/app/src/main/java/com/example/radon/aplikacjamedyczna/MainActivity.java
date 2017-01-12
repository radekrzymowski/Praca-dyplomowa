package com.example.radon.aplikacjamedyczna;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.radon.aplikacjamedyczna.Algorytmy.AlgorytmyActivity;
import com.example.radon.aplikacjamedyczna.Kalkulatory.KalkulatoryActivity;
import com.example.radon.aplikacjamedyczna.Skale.SkaleActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("UWAGA!");
        alertDialog.setMessage(getString(R.string.start_info));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void open_skale_function(View v)
    {
        Intent i = new Intent(this, SkaleActivity.class);
        startActivity(i);
    }

    public void open_algorytmy_function(View v)
    {
        Intent i = new Intent(this, AlgorytmyActivity.class);
        startActivity(i);
    }

    public void open_kalkulatory_function(View v)
    {
        Intent i = new Intent(this, KalkulatoryActivity.class);
        startActivity(i);
    }
}
