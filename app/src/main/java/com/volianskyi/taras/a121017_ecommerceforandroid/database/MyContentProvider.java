package com.volianskyi.taras.a121017_ecommerceforandroid.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import static android.content.UriMatcher.NO_MATCH;


public class MyContentProvider extends ContentProvider {
    public static final int CODE_USERS = 1;
    public static final int CODE_PRODUCTS = 2;
    public static final int CODE_CATEGORIES = 3;
    private DatabaseHelper databaseHelper;
    private static UriMatcher uriMatcher = new UriMatcher(NO_MATCH);

    static {
        uriMatcher.addURI(DatabaseHelper.AUTHORITIES, DatabaseHelper.USERS_TABLE_NAME, CODE_USERS);
        uriMatcher.addURI(DatabaseHelper.AUTHORITIES, DatabaseHelper.PRODUCTS_TABLE_NAME, CODE_PRODUCTS);
        uriMatcher.addURI(DatabaseHelper.AUTHORITIES, DatabaseHelper.CATEGORIES_TABLE_NAME, CODE_CATEGORIES);
    }

    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext(), 1);
        return true;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int res = 0;
        switch (uriMatcher.match(uri)) {
            case CODE_USERS:
                res = database.delete(DatabaseHelper.USERS_TABLE_NAME, selection, selectionArgs);
                break;
            case CODE_PRODUCTS:
                res = database.delete(DatabaseHelper.PRODUCTS_TABLE_NAME, selection, selectionArgs);
                break;
            case CODE_CATEGORIES:
                res = database.delete(DatabaseHelper.CATEGORIES_TABLE_NAME, selection,selectionArgs);
                break;
            default:
                res = 0;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return res;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        long res = 0;
        switch (uriMatcher.match(uri)) {
            case CODE_USERS:
                res = database.insert(DatabaseHelper.USERS_TABLE_NAME, null, values);
                break;
            case CODE_PRODUCTS:
                res = database.insert(DatabaseHelper.PRODUCTS_TABLE_NAME, null, values);
                break;
            case CODE_CATEGORIES:
                res = database.insert(DatabaseHelper.CATEGORIES_TABLE_NAME, null, values);
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, res);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor res = null;
        switch (uriMatcher.match(uri)) {
            case CODE_USERS:
                res = database.query(DatabaseHelper.USERS_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CODE_PRODUCTS:
                res = database.query(DatabaseHelper.PRODUCTS_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CODE_CATEGORIES:
                res = database.query(DatabaseHelper.CATEGORIES_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                res = null;
        }
        res.setNotificationUri(getContext().getContentResolver(), uri);
        return res;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int res = 0;
        switch (uriMatcher.match(uri)) {
            case CODE_USERS:
                res = database.update(DatabaseHelper.USERS_TABLE_NAME, values, selection, selectionArgs);
                break;
            case CODE_PRODUCTS:
                res = database.update(DatabaseHelper.PRODUCTS_TABLE_NAME, values, selection, selectionArgs);
                break;
            case CODE_CATEGORIES:
                res = database.update(DatabaseHelper.CATEGORIES_TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                res = 0;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return res;
    }
}
