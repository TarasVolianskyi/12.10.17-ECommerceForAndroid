package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * Created by tarasvolianskyi on 14.10.17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String AUTHORITIES = "com.volianskyi.taras.ecommerce.provider";
    public static final String USERS_TABLE_NAME = "USERS";
    public static final Uri URI_USERS = Uri.parse("content://" + AUTHORITIES + "/" + USERS_TABLE_NAME);
    public static final String PRODUCTS_TABLE_NAME = "PRODUCTS";
    public static final Uri URI_PRODUCTS = Uri.parse("content://" + AUTHORITIES + "/" + PRODUCTS_TABLE_NAME);
    public static final String ID_USERS_TABLE = "_id";//is should be different for all tables
    public static final String NAME_USERS_TABLE = "NAME_OF_USER";
    public static final String PASS_USERS_TABLE = "PASS_OF_USER";
    public static final String ID_PRODUCTS_TABLE = "_id";
    public static final String NAME_PRODUCTS_TABLE = "NAME_OF_PRODUCT";
    public static final String PRICE_PRODUCTS_TABLE = "PRICE_OF_PRODUCT";
    public static final String CATEGORY_PRODUCTS_TABLE = "CATEGORY_OF_PRODUCT";
    public static final String CREATE_TABLE_USERS = "Create table " + USERS_TABLE_NAME
            + " (" + ID_USERS_TABLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_USERS_TABLE + " TEXT, "
            + PASS_USERS_TABLE + " TEXT)";
    public static final String CREATE_TABLE_PRODUCTS = "Create table " + PRODUCTS_TABLE_NAME
            + " (" + ID_PRODUCTS_TABLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_PRODUCTS_TABLE + " TEXT, "
            + PRICE_PRODUCTS_TABLE + " INT, "
            + CATEGORY_PRODUCTS_TABLE + " TEXT)";


    public DatabaseHelper(Context context, int version) {
        super(context, "myEComDB", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
        sqLiteDatabase.execSQL(CREATE_TABLE_PRODUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
