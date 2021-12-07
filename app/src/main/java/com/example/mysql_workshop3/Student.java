package com.example.mysql_workshop3;

public class Student {

    int id ;
    String fname , Sname , cls;

    public Student(int id, String fname, String sname, String cls) {
        this.fname = fname;
        Sname = sname;
        this.cls = cls;
        this.id = id;
    }
    public Student( String fname, String sname, String cls) {
        this.fname = fname;
        Sname = sname;
        this.cls = cls;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", Sname='" + Sname + '\'' +
                ", cls='" + cls + '\'' +
                '}';
    }
}
