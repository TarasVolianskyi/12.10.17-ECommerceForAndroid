package com.volianskyi.taras.a121017_ecommerceforandroid.activitis.admin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.volianskyi.taras.a121017_ecommerceforandroid.activitis.firebaseAdapter.UsersListAdapter;
import com.volianskyi.taras.a121017_ecommerceforandroid.database.DatabaseHelper;
import com.volianskyi.taras.a121017_ecommerceforandroid.R;
import com.volianskyi.taras.a121017_ecommerceforandroid.pojo.UsersPojo;

import java.util.ArrayList;
import java.util.List;

public class AdminUsersActivity extends AppCompatActivity {
   // ListView listView;
    DatabaseReference databaseUsers =  FirebaseDatabase.getInstance().getReference("users");;
    ListView lvUsersAdminUsersActivity;
    List<UsersPojo> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_users);
        //getSupportActionBar().setTitle("Users - Admain page");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initFAB();
        //initView();
        lvUsersAdminUsersActivity = (ListView) findViewById(R.id.lvUsersAdminContent);
        usersList = new ArrayList<>();
    }

    /*private void initView() {
        listView = (ListView) findViewById(R.id.lvUsersAdminContent);
        Cursor cursor = getContentResolver().query(DatabaseHelper.URI_USERS, null, null, null, null, null);
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,
                new String[]{DatabaseHelper.NAME_USERS_TABLE, DatabaseHelper.PASS_USERS_TABLE},
                new int[]{android.R.id.text1, android.R.id.text2}, Adapter.NO_SELECTION);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdminUsersActivity.this, "You click at number " + l, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminUsersActivity.this, AdminUpdateUsersActivity.class);
                intent.putExtra("NumberOfUserFromList", l);
                startActivity(intent);
            }
        });
    }*/

    /*private void initView() {
        lvUsersAdminUsersActivity = (ListView) findViewById(R.id.lvUsersAdminContent);
        usersList = new ArrayList<>();
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        databaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usersList.clear();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    UsersPojo user = artistSnapshot.getValue(UsersPojo.class);
                    usersList.add(user);
                }
                UsersListAdapter adapter = new UsersListAdapter(AdminUsersActivity.this, usersList);
                lvUsersAdminUsersActivity.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        lvUsersAdminUsersActivity.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                UsersPojo user = usersList.get(i);
                showUpdateDialog(user.getUserId(), user.getUserName()/*,user.getUserLastName(),user.getUserEmail(),user.getUserPass()*/);
                return false;
            }
        });
    }

    private void initFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminUsersActivity.this, "Go to Add User", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminUsersActivity.this, AdminAddUsersActivity.class));
            }
        });
    }

    private void showUpdateDialog(final String artistID, String artistName) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.layout_update_user_dialog, null);
        dialogBuilder.setView(dialogView);
        final EditText editTextName = (EditText) dialogView.findViewById(R.id.etNameUpdateDialog);
        final Button btnUpdate = (Button) dialogView.findViewById(R.id.btnUpdateDialog);
        final Spinner spinnerUpdate = (Spinner) dialogView.findViewById(R.id.spinnerUpdaetDialog);
        dialogBuilder.setTitle("Update artist " + artistName);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String lastName = spinnerUpdate.getSelectedItem().toString();
                String email = "email@"+spinnerUpdate.getSelectedItem().toString();
                String pass = "pass "+spinnerUpdate.getSelectedItem().toString();


                if (TextUtils.isEmpty(name)) {
                    editTextName.setError("Name required");
                    return;
                }
                updateArtist(artistID, name, lastName,email,pass);

            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private boolean updateArtist(String id, String name, String lastName, String email, String pass) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child(id);
        UsersPojo user = new UsersPojo(id, name, lastName,email,pass);
        databaseReference.setValue(user);
        Toast.makeText(this, "User updated", Toast.LENGTH_SHORT).show();
        return true;
    }

}
