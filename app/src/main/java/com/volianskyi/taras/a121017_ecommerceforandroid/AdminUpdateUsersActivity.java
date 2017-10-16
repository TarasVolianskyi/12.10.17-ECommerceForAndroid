package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminUpdateUsersActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName;
    private TextView tvPass;
    private EditText etName;
    private EditText etPass;
    private SQLiteDatabase sqLiteDatabase;
    private long numberOfUserFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_users);
        initView();

    }

    private void initView() {
        numberOfUserFromList = getIntent().getLongExtra("NumberOfUserFromList", 0);
        TextView tvID = (TextView) findViewById(R.id.tvIDAdminUpdateActivity);
        tvName = (TextView) findViewById(R.id.tvNameAdminUpdateActivity);
        tvPass = (TextView) findViewById(R.id.tvPassAdminUpdateActivity);
        etName = (EditText) findViewById(R.id.etNameAdminUpdateActivity);
        etPass = (EditText) findViewById(R.id.etPassAdminUpdateActivity);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdateAdminUpdateActivity);
        Button btnDelete = (Button) findViewById(R.id.btnDeleteAdminUpdateActivity);
        tvID.setText("ID - " + numberOfUserFromList);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateAdminUpdateActivity:
              /*  tvName.setText(etName.getText().toString());
                tvPass.setText(etPass.getText().toString());
                ContentValues contentValues = new ContentValues();
                contentValues.put("NAME", etName.getText().toString());
                contentValues.put("PASS", etPass.getText().toString());
                sqLiteDatabase.update("USERS", contentValues, "_id =?", new String[]{"" + numberOfUserFromList});
                Toast.makeText(this, "Click update ", Toast.LENGTH_SHORT).show();*/
           /*     String nameOfNewUser = etName.getText().toString();
                String passOfNewUser = etPass.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.NAME_USERS_TABLE, nameOfNewUser);
                contentValues.put(DatabaseHelper.PASS_USERS_TABLE, passOfNewUser);
                //getContentResolver().insert(DatabaseHelper.URI_USERS, contentValues);
                getContentResolver().update(DatabaseHelper.URI_USERS, contentValues, "_id =?", new String[]{"" + numberOfUserFromList});
                //startActivity(new Intent(AdminUpdateUsersActivity.this, AdminUsersActivity.class));*/
                finish();
                break;
            case R.id.btnDeleteAdminUpdateActivity:
                sqLiteDatabase.delete("USERS", "_id =?", new String[]{"" + numberOfUserFromList});
                Toast.makeText(this, "Click delete", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
