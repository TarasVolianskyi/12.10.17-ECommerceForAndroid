package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AdminMain2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main2);
        initView();
    }

    private void initView() {
        ListView listView = (ListView) findViewById(R.id.lvCategoryListAdminMainActivity);
        final String[] array = getResources().getStringArray(R.array.arrayForAdminCategories);
        ArrayAdapter<String> arrayAdapteer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(arrayAdapteer);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdminMain2Activity.this, "" + array[i], Toast.LENGTH_SHORT).show();
                if(l==1){

                }

            }
        });
    }
}
