package com.example.radon.aplikacjamedyczna.Algorytmy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.radon.aplikacjamedyczna.R;
import com.example.radon.aplikacjamedyczna.Skale.CHA2DS2VAScActivity;
import com.example.radon.aplikacjamedyczna.Skale.ChildaPughActivity;
import com.example.radon.aplikacjamedyczna.Skale.GenewskaActivity;
import com.example.radon.aplikacjamedyczna.Skale.HasBledActvity;
import com.example.radon.aplikacjamedyczna.Skale.WellsActivity;

import java.util.ArrayList;

/**
 * Created by radon on 2016-10-10.
 */
public class AdapterAlgorytmy extends BaseAdapter {
    //zmienne
    Context context;
    private static LayoutInflater inflater = null;
    private ArrayList<String> listaSkal = new ArrayList<>();

    public AdapterAlgorytmy(Activity activity) {
        super();
        context = activity;
        listaSkal.add("Przedawkowanie VKA");
        listaSkal.add("Bradykardia");
        listaSkal.add("Tachykardia");
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return listaSkal.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView title;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.custom_list_view, null);
        rowView.setBackgroundColor(ContextCompat.getColor(context,R.color.white_color));
        rowView.invalidate();
        holder.title = (TextView) rowView.findViewById(R.id.list_view_title);


        switch(position)
        {
            case 0: holder.title.setText(listaSkal.get(position));
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(context, VkaActivity.class);
                        context.startActivity(i);
                    }
                });break;
            case 1: holder.title.setText(listaSkal.get(position));
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(context, BradykardiaActivity.class);
                        context.startActivity(i);
                    }
                });break;
            case 2: holder.title.setText(listaSkal.get(position));
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(context, TachykardiaActivity.class);
                        context.startActivity(i);
                    }
                });break;
        }


        return rowView;
    }
}
