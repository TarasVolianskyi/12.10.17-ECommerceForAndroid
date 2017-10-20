package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        ListView listView = (ListView) findViewById(R.id.lvMainListMainActivity);
        final String[] arrayMainList = getResources().getStringArray(R.array.mainList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayMainList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You chouse " + arrayMainList[i], Toast.LENGTH_SHORT).show();
                if (l == 0) {
                    startActivity(new Intent(MainActivity.this, CatalogActivity.class));
                } else if (l == 4) {
                    startActivity(new Intent(MainActivity.this, AdminMainActivity.class));
                }

            }
        });
    }
}
