package com.volianskyi.taras.a121017_ecommerceforandroid.activitis;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.volianskyi.taras.a121017_ecommerceforandroid.database.DatabaseHelper;
import com.volianskyi.taras.a121017_ecommerceforandroid.R;

public class AdminUpdateUsersActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName;
    private TextView tvPass;
    private EditText etName;
    private EditText etPass;
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
        tvName.setText("Name - " + numberOfUserFromList);
        tvPass.setText("Password - " + numberOfUserFromList);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateAdminUpdateActivity:
                String nameUser = etName.getText().toString();
                String passUser = etPass.getText().toString();
                ContentValues contentValuesUpdateUsers = new ContentValues();
                contentValuesUpdateUsers.put(DatabaseHelper.NAME_USERS_TABLE, nameUser);
                contentValuesUpdateUsers.put(DatabaseHelper.PASS_USERS_TABLE, passUser);
                getContentResolver().update(DatabaseHelper.URI_USERS, contentValuesUpdateUsers, DatabaseHelper.ID_USERS_TABLE + "=?", new String[]{"" + numberOfUserFromList});
                Toast.makeText(this, "" + numberOfUserFromList + "name - "+nameUser+" pass - "+passUser, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminUpdateUsersActivity.this, AdminUsersActivity.class));
                break;
            case R.id.btnDeleteAdminUpdateActivity:
                getContentResolver().delete(DatabaseHelper.URI_USERS, DatabaseHelper.ID_USERS_TABLE + "=?", new String[]{"" + numberOfUserFromList});
                startActivity(new Intent(AdminUpdateUsersActivity.this, AdminUsersActivity.class));
                break;
        }
    }
}
