package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tarasvolianskyi on 14.10.17.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<Item> data;
    private Context context;
    private View.OnClickListener btnBuyClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int id = (int) view.getTag();
            Toast.makeText(context, "You click at product number " + id, Toast.LENGTH_SHORT).show();
        }
    };

    public MyAdapter(ArrayList<Item> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Item item = data.get(i);
        View myView = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        TextView tvName = (TextView) myView.findViewById(R.id.tvNameItrmList);
        TextView tvPrice = (TextView) myView.findViewById(R.id.tvPriceItemList);
        TextView tvPreviousPrice = (TextView) myView.findViewById(R.id.tvPreviousPriceItemList);
        tvName.setText(item.getName());
        tvPrice.setText(item.getPrice());
        tvPreviousPrice.setText(item.getPrevoiusPrice());
        Button btnBuy = (Button) myView.findViewById(R.id.btnBuyItemList);
        btnBuy.setTag(i);
        btnBuy.setOnClickListener(btnBuyClick);
        return myView;
    }
}
