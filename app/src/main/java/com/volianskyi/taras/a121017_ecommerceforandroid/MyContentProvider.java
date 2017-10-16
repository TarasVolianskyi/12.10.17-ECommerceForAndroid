package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import static android.content.UriMatcher.NO_MATCH;

public class MyContentProvider extends ContentProvider {
    public static final int CODE_USERS = 0;
    public static final int CODE_PRODUCTS = 1;
    private DatabaseHelper databaseHelper;
    private static UriMatcher uriMatcher = new UriMatcher(NO_MATCH);

    static {
        uriMatcher.addURI(DatabaseHelper.AUTHORITIES, DatabaseHelper.USERS_TABLE_NAME, CODE_USERS);
        uriMatcher.addURI(DatabaseHelper.AUTHORITIES, DatabaseHelper.PRODUCTS_TABLE_NAME, CODE_PRODUCTS);
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
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
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
        }
        return ContentUris.withAppendedId(uri, res);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case CODE_USERS:
                return database.query(DatabaseHelper.USERS_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            case CODE_PRODUCTS:
                return database.query(DatabaseHelper.PRODUCTS_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            default:
                return null;
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
