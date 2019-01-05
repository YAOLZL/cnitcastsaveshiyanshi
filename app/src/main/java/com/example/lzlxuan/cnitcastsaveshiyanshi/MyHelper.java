package com.example.lzlxuan.cnitcastsaveshiyanshi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {
    //
    public  MyHelper(@Nullable  Context context,@Nullable String name,SQLiteDatabase.CursorFactory factory, int version){
        super(context,"information",null,1);

    }

    public void onCreate(SQLiteDatabase db) {
        String sql="create table information(_id integer primary key autoincrement,score varchar(20) ,name varchar(20),phone varchar(20))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
