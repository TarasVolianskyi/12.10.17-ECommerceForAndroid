package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tarasvolianskyi on 14.10.17.
 */

public class MyAdapter extends BaseAdapter {
    public static final String[] IMAGE_URLS = new String[]{"https://www.petfinder.com/wp-content/uploads/2012/11/91615172-find-a-lump-on-cats-skin-632x475.jpg", "http://www.readersdigest.ca/wp-content/uploads/2011/01/4-ways-cheer-up-depressed-cat.jpg", "https://peterwardhomes.files.wordpress.com/2014/12/goole-area-shot_005.jpg"};
    private ImageView imageViewOfItem;
    private ArrayList<Item> data;
    private Context context;
    private View.OnClickListener btnBuyClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int id = (int) view.getTag();
            Toast.makeText(context, "You click at product number " + id, Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener btnAddToBucketClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = (int) view.getTag();
            Toast.makeText(context, "You add to bucket product number " + id, Toast.LENGTH_SHORT).show();
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
        View myView = LayoutInflater.from(context).inflate(R.layout.item_first_view_list, viewGroup, false);
        TextView tvName = (TextView) myView.findViewById(R.id.tvNameItemFirstViewList);
        TextView tvPrice = (TextView) myView.findViewById(R.id.tvPriceItemFirstViewList);
        TextView tvPreviousPrice = (TextView) myView.findViewById(R.id.tvPreviousPriceItemFirstViewList);
        tvName.setText(item.getName());
        tvPrice.setText(item.getPrice());
        tvPreviousPrice.setText(item.getPrevoiusPrice());
        Button btnBuy = (Button) myView.findViewById(R.id.btnBuyItemFirstViewList);
        Button btnAddToBucket = (Button) myView.findViewById(R.id.btnAddToBucketItemFirstViewList);
        btnBuy.setTag(i);
        btnBuy.setOnClickListener(btnBuyClick);
        btnAddToBucket.setTag(i);
        btnAddToBucket.setOnClickListener(btnAddToBucketClick);
        return myView;
        //init photo


    }
}
