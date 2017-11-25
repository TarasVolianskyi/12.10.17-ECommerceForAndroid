package com.volianskyi.taras.a121017_ecommerceforandroid.adapter;


/**
 * Created by tarasvolianskyi on 24.11.17.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;
import com.volianskyi.taras.a121017_ecommerceforandroid.activitis.dialogs.DialogNumItem;
import com.volianskyi.taras.a121017_ecommerceforandroid.activitis.user_activities.ProductActivity;
import com.volianskyi.taras.a121017_ecommerceforandroid.pojo.Item;

import java.util.ArrayList;

public class MyBucketAdapter extends BaseAdapter {
    public static final String[] IMAGE_URLS = new String[]{"https://www.petfinder.com/wp-content/uploads/2012/11/91615172-find-a-lump-on-cats-skin-632x475.jpg", "http://www.readersdigest.ca/wp-content/uploads/2011/01/4-ways-cheer-up-depressed-cat.jpg", "https://peterwardhomes.files.wordpress.com/2014/12/goole-area-shot_005.jpg"};
    private ImageView imageViewOfItem;
    private ArrayList<Item> data;
    private Context context;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = (int) view.getTag();
            Intent intent = new Intent(context, ProductActivity.class);
            intent.putExtra("id_of_item", id);
            context.startActivity(intent);
        }
    };
    private View.OnClickListener btnBuyClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int id = (int) view.getTag();
            //Toast.makeText(context, "You click at product number " + id, Toast.LENGTH_SHORT).show();
            DialogNumItem myDialog = new DialogNumItem();
            myDialog.show(((Activity)context).getFragmentManager(),"hello");
        }
    };
   /* private View.OnClickListener btnAddToBucketClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = (int) view.getTag();
            Toast.makeText(context, "You add to bucket product number " + id, Toast.LENGTH_SHORT).show();
        }
    };*/

    public MyBucketAdapter(ArrayList<Item> data, Context context) {
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
        View myView = LayoutInflater.from(context).inflate(R.layout.item_bucket_view_list, viewGroup, false);
        myView.setTag(item.getId());
        myView.setOnClickListener(onItemClickListener);
        TextView tvName = (TextView) myView.findViewById(R.id.tvNameItemBucketViewList);
        TextView tvPrice = (TextView) myView.findViewById(R.id.tvPriceItemFirstViewList);
        TextView tvTotalPrice = (TextView) myView.findViewById(R.id.tvTotalPriceForThisProdItemBucketViewList);
        tvName.setText(item.getName());
        //tvPrice.setText(item.getPrice());
        tvTotalPrice.setText("total price is - " + item.getPrevoiusPrice());

        Button btnNumberOfItems = (Button) myView.findViewById(R.id.btnDialogNumberOfProdItemBucketViewList);
        btnNumberOfItems.setTag(i);
        btnNumberOfItems.setOnClickListener(btnBuyClick);

        return myView;
    }
}
