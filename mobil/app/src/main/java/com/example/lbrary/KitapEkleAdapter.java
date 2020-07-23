package com.example.lbrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class KitapEkleAdapter extends SQLiteOpenHelper {

    public KitapEkleAdapter(@Nullable Context context) {
        super(context, "Database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create  table books(book_name text primary key,author text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists books");
        onCreate(db);
    }

    public boolean addBook(String book_name,String author)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("book_name",book_name);
        contentValues.put("author",author);

        long ins =db.insert("books",null,contentValues);

        if(ins==-1)
        {
            db.close();
            return false;
        }
        else {
            db.close();
            return true;
        }
    }

    /*public boolean deleteBook(String book_name,String author_name)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        db.delete("books","where book_name=? and author_name=?",new String[]{book_name,author_name});

        return true;
    }
     */


    public boolean checkBook(String book_name)
    {

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from books where book_name=?",new String[]{book_name});

        if(cursor.getCount()==0)
        {
            cursor.close();
            db.close();
            return false;
        }
        else
        {
            cursor.close();
            db.close();
            return true;
        }
    }
    
    public boolean deleteBook(String book_name, String author)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long ins= db.delete("books","book_name=? and author=?",new String[]{book_name,author});

        if(ins==-1)
        {
            db.close();
            return false;
        }
        else {
            db.close();
            return true;
        }
    }

    public Cursor viewData()
    {

        SQLiteDatabase db=this.getReadableDatabase();
        String query="Select * from books";

        Cursor cursor=db.rawQuery(query,null);

        return cursor;
    }

}








