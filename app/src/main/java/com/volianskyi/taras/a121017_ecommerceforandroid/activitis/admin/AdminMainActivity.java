package com.volianskyi.taras.a121017_ecommerceforandroid.activitis.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main2);
        getSupportActionBar().setTitle("Admain page");
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
                Toast.makeText(AdminMainActivity.this, "" + array[i], Toast.LENGTH_SHORT).show();
               if (l == 0) {
                    Intent intent = new Intent(AdminMainActivity.this, AdminUsersActivity.class);
                    startActivity(intent);
              } else if (l == 1) {
                    startActivity(new Intent(AdminMainActivity.this, AdminProductsActivity.class));
                }
            }
        });
    }
}
