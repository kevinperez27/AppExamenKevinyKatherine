package com.example.appkevinexamen;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "futbolistas.db";
    private static final String TABLE_NAME = "futbolistas";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_APELLIDO = "apellido";
    private static final String COLUMN_PAIS = "pais";
    private static final String COLUMN_POSICION = "posicion";
    private static final String COLUMN_EDAD = "edad";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_APELLIDO + " TEXT, " +
                COLUMN_PAIS + " TEXT, " +
                COLUMN_POSICION + " TEXT, " +
                COLUMN_EDAD + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertFutbolista(String nombre, String apellido, String pais, String posicion, int edad) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_APELLIDO, apellido);
        values.put(COLUMN_PAIS, pais);
        values.put(COLUMN_POSICION, posicion);
        values.put(COLUMN_EDAD, edad);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Futbolista> getAllFutbolistas() {
        List<Futbolista> futbolistas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (((Cursor) cursor).moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE));
                @SuppressLint("Range") String apellido = cursor.getString(cursor.getColumnIndex(COLUMN_APELLIDO));
                @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(COLUMN_PAIS));
                @SuppressLint("Range") String posicion = cursor.getString(cursor.getColumnIndex(COLUMN_POSICION));
                @SuppressLint("Range") int edad = cursor.getInt(cursor.getColumnIndex(COLUMN_EDAD));
                Futbolista futbolista = new Futbolista(id, nombre, apellido, pais, posicion, edad);
                futbolistas.add(futbolista);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return futbolistas;
    }
}
