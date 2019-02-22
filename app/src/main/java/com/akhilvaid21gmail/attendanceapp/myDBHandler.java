package com.akhilvaid21gmail.attendanceapp;

/**
 * Created by Akhil on 27-Feb-18.
 */

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;


public class myDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="Attendance.db";
    public static final String TABLE_ATTENDANCE="Attendance";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_SUBJECTNAME="Subject Name";
    public myDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+   TABLE_ATTENDANCE+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
               COLUMN_SUBJECTNAME+" TEXT "+
                ");";

            sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
        onCreate(sqLiteDatabase);

    }

    //Add new row to database
    public void addProduct( Attendance_Register attendance)
    {
        ContentValues values = new ContentValues();
        //,COLUMN_DAYS_PRESENT,attendance.getDays_present(),COLUMN_DAYS_ABSENT,attendance.getDays_absent()
        values.put(COLUMN_SUBJECTNAME,attendance.get_subjectName());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_ATTENDANCE,null,values);
        sqLiteDatabase.close();


    }

    //Delete row from database
    public void deleteSubject(String subjectname)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM "+TABLE_ATTENDANCE+" WHERE "+ COLUMN_SUBJECTNAME+ "=\"" + subjectname+"\";");



    }


   // Print Data Base as a String
    public String databaseToString()
    {
        String dbString="";

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query="SELECT * FROM "+TABLE_ATTENDANCE+" WHERE 1";
        //CURSOR POINT TO A LOCATION IN YOUR RESULTS
        Cursor c=sqLiteDatabase.rawQuery(query,null);
        //Move to first row
        c.moveToFirst();
            while(!c.isAfterLast())
            {
                if(c.getString(c.getColumnIndex("Subject Name "))!=null){
                    dbString+=c.getString((c.getColumnIndex("Subject Name")));
                    dbString+="\n";
                    c.moveToNext();
                }
            }

        sqLiteDatabase.close();
            return dbString;
    }




}


