package com.example.mysql_workshop3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText  firstName , secondName , id ;
    RadioButton ti ,dsi ,rsi ;
    TextView edit ;
    StudentDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        firstName = findViewById(R.id.nom);
        secondName = findViewById(R.id.prenom);

        ti = findViewById(R.id.radio1);
        dsi = findViewById(R.id.radio2);
        rsi = findViewById(R.id.radio3);

        edit = findViewById(R.id.edit);

        dao = new StudentDAO(getApplicationContext());



    }

    public void add_student(View view)
    {
        String firstName = this.firstName.getText().toString();
        String secondName = this.secondName.getText().toString();
        String classe ="";
        if(ti.isChecked())
        {
            classe="ti";
        }
        else if(dsi.isChecked())
        {
            classe="dsi";
        }
        else{
            classe="rsi";
        }
        Student s = new Student(firstName,secondName,classe);

        dao.addStudent(s);
    }

    public void show_all(View view)
    {
        Cursor cursor = dao.getStudents();
        String students ="";
        while(cursor.moveToNext())
        {
            if(cursor.getCount()>0)
            {
                students+=cursor.getInt(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+"\n";
            }
        }
        edit.setText(students);
    }

    public void delete_student(View view)
    {
        Student student = new Student();
        student.setFname(firstName.getText().toString());
        student.setSname(secondName.getText().toString());

        dao.deleteStudent(student);

    }

    public void search_student(View view)
    {
        String firstname = this.firstName.getText().toString();
        Cursor cursor = dao.searchStudent(firstname);
        String students ="";
        while(cursor.moveToNext())
        {
            if(cursor.getCount()>0)
            {
                students+=cursor.getInt(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+"\n";
            }
        }
        edit.setText(students);
    }

    public void modify_student(View view)
    {
        String firstName = this.firstName.getText().toString();
        String secondName = this.secondName.getText().toString();
        String idStudent = this.id.getText().toString();
        System.out.println(idStudent);
        String classe ="";
        if(ti.isChecked())
        {
            classe="ti";
        }
        else if(dsi.isChecked())
        {
            classe="dsi";
        }
        else{
            classe="rsi";
        }
        Student s = new Student(Integer.parseInt(idStudent),firstName,secondName,classe);
        System.out.println(s.toString());
        dao.updateStudent(s);

    }


}