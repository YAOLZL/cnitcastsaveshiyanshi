package com.example.lzlxuan.cnitcastsaveshiyanshi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteAdapter {
    SQLiteDatabase db=null;
    Context context=null;



    public  MySQLiteAdapter(Context context){this.context=context; }


    public void openDB() {
        MyHelper myHelper = new MyHelper(context, "database.db", null, 1);
        db = myHelper.getWritableDatabase();

    }
    private void closeDB() {
        if (db.isOpen()) {
            db.close();
        }
        db = null;
    }


    public boolean insert (Student student){
        boolean result=false;
        openDB();
        ContentValues values=new ContentValues();
        values.put("score",student.getScore());
        values.put("name",student.getName());
        values.put("phone",student.getPhone());


        Long rowid=db.insert("information",null,values);
        if (rowid!=-1){
            result=true;
            Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT).show();
            Log.i("数据库操作","添加成功");
        }else {
            Toast.makeText(context, "添加失败", Toast.LENGTH_SHORT).show();
            Log.i("数据库操作", "添加失败");
        }
        closeDB();
        return result;
    }
    public List<Student> query(String s) {
        List<Student> list = new ArrayList<>();
        openDB();
        Cursor cursor = db.query("information", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String score = cursor.getString(cursor.getColumnIndex("score"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Long Phone = cursor.getLong(cursor.getColumnIndex("phone"));
                Student student=new Student();
                student.set_id(id);
                student.setScore(score);
                student.setName(name);
                student.setPhone(Phone);
                list.add(student);
            } while (cursor.moveToNext());
        }
        closeDB();
        return list;


    }
    /* public List<Student> query(String name) {
         List<Student> list = new ArrayList<>();
         openDB();
         Cursor cursor = db.query("information", null, null, null, null, null, null);

         if (cursor.moveToFirst()) {
             do {
                 String mname = cursor.getString(cursor.getColumnIndex("name"));
                 String score= cursor.getString(cursor.getColumnIndex("score"));
                 if (mname.equals(name)){
                     int id = cursor.getInt(cursor.getColumnIndex("_id"));
                     Long Phone = cursor.getLong(cursor.getColumnIndex("phone"));
                     Student student = new Student();
                     student.set_id(id);
                     student.setScore(score);
                     student.setName(mname);
                     student.setPhone(Phone);
                     list.add(student);
                 }

             } while (cursor.moveToNext());
         }
         closeDB();
         return list;


     }*/
    public int deleteByName(String name) {
        int result = -1;
        openDB();
        result = db.delete("information", "name=?", new String[]{name});


        closeDB();
        return result;
    }



}
