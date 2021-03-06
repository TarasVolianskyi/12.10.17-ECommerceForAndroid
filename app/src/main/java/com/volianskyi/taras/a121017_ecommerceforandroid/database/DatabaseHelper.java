package com.volianskyi.taras.a121017_ecommerceforandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.volianskyi.taras.a121017_ecommerceforandroid.R;

/**
 * Created by tarasvolianskyi on 14.10.17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String AUTHORITIES = "com.volianskyi.taras.ecommerce.provider";
    public static final String USERS_TABLE_NAME = "USERS";
    public static final Uri URI_USERS = Uri.parse("content://" + AUTHORITIES + "/" + USERS_TABLE_NAME);
    public static final String PRODUCTS_TABLE_NAME = "PRODUCTS";
    public static final Uri URI_PRODUCTS = Uri.parse("content://" + AUTHORITIES + "/" + PRODUCTS_TABLE_NAME);
    public static final String CATEGORIES_TABLE_NAME = "CATEGORIES";
    public static final Uri URI_CATEGORIES = Uri.parse("content://" + AUTHORITIES + "/" + CATEGORIES_TABLE_NAME);

    public static final String ID_USERS_TABLE = "_id";//is should be different for all tables
    public static final String NAME_USERS_TABLE = "NAME_OF_USER";
    public static final String PASS_USERS_TABLE = "PASS_OF_USER";

    public static final String ID_PRODUCTS_TABLE = "_id";
    public static final String NAME_PRODUCTS_TABLE = "NAME_OF_PRODUCT";
    public static final String PRICE_PRODUCTS_TABLE = "PRICE_OF_PRODUCT";
    public static final String CATEGORY_PRODUCTS_TABLE = "CATEGORY_OF_PRODUCT";

    public static final String ID_CATEGORIES_TABLE = "_id";
    public static final String NAME_CATEGORIES_TABLE = "NAME_OF_CATEGORY";

    public static final String CREATE_TABLE_USERS = "Create table " + USERS_TABLE_NAME
            + " (" + ID_USERS_TABLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_USERS_TABLE + " TEXT, "
            + PASS_USERS_TABLE + " TEXT)";
    public static final String CREATE_TABLE_PRODUCTS = "Create table " + PRODUCTS_TABLE_NAME
            + " (" + ID_PRODUCTS_TABLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_PRODUCTS_TABLE + " TEXT, "
            + PRICE_PRODUCTS_TABLE + " INT, "
            + CATEGORY_PRODUCTS_TABLE + " TEXT)";
    public static final String CREATE_TABLE_CATEGORIES = "Create table " + CATEGORIES_TABLE_NAME
            + " (" + ID_CATEGORIES_TABLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_CATEGORIES_TABLE + " TEXT)";

    private Context context;

    public DatabaseHelper(Context context, int version) {
        super(context, "myEComDB", null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
        sqLiteDatabase.execSQL(CREATE_TABLE_PRODUCTS);
        sqLiteDatabase.execSQL(CREATE_TABLE_CATEGORIES);
        fillDB(sqLiteDatabase);
       // fillProducts(sqLiteDatabase);
    }

    private void fillProducts(SQLiteDatabase sqLiteDatabase) {

        for (int i = 0; i < 10; i++) {
            ContentValues cv = new ContentValues();
            cv.put(NAME_PRODUCTS_TABLE, "Product "+i);
            cv.put(PRICE_PRODUCTS_TABLE, 10*i);
            cv.put(CATEGORY_PRODUCTS_TABLE, "null");
            sqLiteDatabase.insert(PRODUCTS_TABLE_NAME, null, cv);
        }

    }

    private void fillDB(SQLiteDatabase sqLiteDatabase) {
        String[] urls = context.getResources().getStringArray(R.array.cars);
        for (int i = 0; i < urls.length; i++) {
            ContentValues cv = new ContentValues();
            cv.put(NAME_CATEGORIES_TABLE, urls[i]);
            sqLiteDatabase.insert(CATEGORIES_TABLE_NAME, null, cv);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}