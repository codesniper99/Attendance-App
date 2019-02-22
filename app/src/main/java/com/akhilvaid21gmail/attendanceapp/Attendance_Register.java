package com.akhilvaid21gmail.attendanceapp;

/**
 * Created by Akhil on 27-Feb-18.
 */

public class Attendance_Register {

    private int _id;

    private String _subjectName;

    public Attendance_Register(){

    }


    public Attendance_Register(String _subjectName) {
        this._subjectName = _subjectName;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public void set_subjectName(String _subjectName) {
        this._subjectName = _subjectName;
    }


    public int get_id() {
        return _id;
    }


    public String get_subjectName() {
        return _subjectName;
    }

}
