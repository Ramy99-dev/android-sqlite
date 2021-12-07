package com.example.mysql_workshop3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentDAO {


    public static final String CREATE_TABLE = "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT , Fname TEXT , Sname TEXT , Cls TEXT)";

    private DatabaseHandler dbHandler ;


    public StudentDAO(Context context)
    {
        this.dbHandler = new DatabaseHandler(context);
    }

    public void addStudent(Student s)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Fname",s.getFname());
        values.put("Sname",s.getSname());
        values.put("Cls",s.getCls());
        db.insert("student",null,values);
        db.close();
    }

    public void deleteStudent(Student s )
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete("student","FName=? ",new String[]{s.getFname()});
        db.close();
    }
    public Cursor getStudents()
    {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        return db.rawQuery("SELECT * FROM student",null);
    }

    public void updateStudent(Student s)
    {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Fname",s.getFname());
        values.put("Sname",s.getSname());
        values.put("Cls",s.getCls());
        db.update("student",values , " id=? ", new String[]{s.getId()+""} );
    }

    public Cursor searchStudent(String word)
    {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        return db.rawQuery("SELECT * FROM student WHERE FName LIKE ?",new String[]{"%"+word+"%"});
    }

}
