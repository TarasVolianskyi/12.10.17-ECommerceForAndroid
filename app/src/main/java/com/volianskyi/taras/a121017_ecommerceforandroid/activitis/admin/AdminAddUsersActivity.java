package com.volianskyi.taras.a121017_ecommerceforandroid.activitis.admin;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.volianskyi.taras.a121017_ecommerceforandroid.database.DatabaseHelper;
import com.volianskyi.taras.a121017_ecommerceforandroid.R;
import com.volianskyi.taras.a121017_ecommerceforandroid.pojo.UsersPojo;

public class AdminAddUsersActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNameOfNewUserFromAdmin;
    EditText etPassOfNewUserFromAdmin;
    DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_users);
        getSupportActionBar().setTitle("Add new User - Admain page");
        initView();
    }

    private void initView() {
        Button btnAdd = (Button) findViewById(R.id.btnAddNewAdminAddUsersActivity);
        btnAdd.setOnClickListener(this);
        etNameOfNewUserFromAdmin = (EditText) findViewById(R.id.etNameAdminAddUsersActivity);
        etPassOfNewUserFromAdmin = (EditText) findViewById(R.id.etPassAdminAddUsersActivity);

    }

    @Override
    public void onClick(View view) {
        String nameOfNewUser = etNameOfNewUserFromAdmin.getText().toString();
        String passOfNewUser = etPassOfNewUserFromAdmin.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME_USERS_TABLE, nameOfNewUser);
        contentValues.put(DatabaseHelper.PASS_USERS_TABLE, passOfNewUser);
        getContentResolver().insert(DatabaseHelper.URI_USERS, contentValues);
        startActivity(new Intent(AdminAddUsersActivity.this, AdminUsersActivity.class));

        String id = databaseUsers.push().getKey();
        UsersPojo user = new UsersPojo(id, nameOfNewUser, nameOfNewUser + " Petrov", nameOfNewUser + "@gmail.com", passOfNewUser);
        databaseUsers.child(id).setValue(user);
    }
}
