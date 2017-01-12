package com.example.radon.aplikacjamedyczna;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.radon.aplikacjamedyczna.Algorytmy.AlgorytmyActivity;
import com.example.radon.aplikacjamedyczna.Kalkulatory.KalkulatoryActivity;
import com.example.radon.aplikacjamedyczna.Skale.SkaleActivity;

import java.util.ArrayList;

/**
 * Created by radon on 2016-07-16.
 */
public class MenuAdapter extends BaseAdapter {

    //zmienne
    Context context;
    private static LayoutInflater inflater = null;
    private ArrayList<String> lista_menu =  new ArrayList<>();
    private int contex_num;

    public MenuAdapter(Activity activity,int context_num) {
        super();
        context = activity;
        this.contex_num = context_num;
        lista_menu.add("menu główne");
        lista_menu.add("kalkulatory");
        lista_menu.add("skale");
        lista_menu.add("algorytmy");
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return lista_menu.size()+1;
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
        holder.title = (TextView) rowView.findViewById(R.id.list_view_title);

        if(position==contex_num)
        {


            switch (contex_num)
            {
                case 0:break;
                case 1:

                    break;
                case 2:
                    holder.title.setTextColor(ContextCompat.getColor(context, R.color.white_color));
                    rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.kalkulatory_color));
                    rowView.invalidate();
                    break;
                case 3:
                    holder.title.setTextColor(ContextCompat.getColor(context, R.color.white_color));
                    rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.skale_color));
                    rowView.invalidate();
                    break;
                case 4:
                    holder.title.setTextColor(ContextCompat.getColor(context, R.color.white_color));
                    rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.algorytmy_color));
                    rowView.invalidate();
                    break;
            }
        }

        switch (position)
        {
            case 0: rowView = inflater.inflate(R.layout.close_drawable_layout_custom_list_view, null);

                    break;
            case 1:holder.title.setText(lista_menu.get(0));
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(context, MainActivity.class);
                        context.startActivity(i);
                    }
                });

                    break;
            case 2: holder.title.setText(lista_menu.get(1));
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(context, KalkulatoryActivity.class);
                        context.startActivity(i);
                    }
                });

                    break;
            case 3: holder.title.setText(lista_menu.get(2));
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(context, SkaleActivity.class);
                        context.startActivity(i);
                    }
                });
                    break;
            case 4:
                holder.title.setText(lista_menu.get(3));
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(context, AlgorytmyActivity.class);
                        context.startActivity(i);
                    }
                });
                break;


        }


        return rowView;
    }
}
