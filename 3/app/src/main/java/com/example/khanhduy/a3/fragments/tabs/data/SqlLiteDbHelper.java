package com.example.khanhduy.a3.fragments.tabs.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SqlLiteDbHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "foody.sqlite";
    private static final String DB_PATH_SUFFIX = "/databases/";
    static Context ctx;
    //tham chiếu đến đối tượng lớp cha gần nhất
    public SqlLiteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx = context;
    }
    //lấy quan ăn theo danh mục
    public List<Itemlist> getdanhmuc(int a) {
        List<Itemlist> contactList = new ArrayList<Itemlist>();
        // Select All Query
        String selectQuery = "SELECT * FROM tb_restaurant INNER JOIN danhmuc ON tb_restaurant.id = danhmuc.idquan WHERE loai=?";
        String id= Integer.toString(a);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,new String[]{id});

        // looping through all rows and adding to list
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Itemlist cont = new Itemlist(cursor.getString(5),cursor.getString(3), cursor.getString(4),
                        cursor.getBlob(7),cursor.getString(8));
                // Adding contact to list
                contactList.add(cont);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
    //lấy 62 quán ăn đầu database
    public List<Itemlist> getAllItemlist() {
        List<Itemlist> contactList = new ArrayList<Itemlist>();
            // Select All Query
            String selectQuery = "SELECT * FROM tb_restaurant limit 62";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    Itemlist cont = new Itemlist(cursor.getString(5),cursor.getString(3), cursor.getString(4),
                            cursor.getBlob(7),cursor.getString(8));
                    // Adding contact to list
                    contactList.add(cont);
                } while (cursor.moveToNext());
            }
        // return contact list
        return contactList;
    }
    //lấy tỉnh thành phố trong database
    public List<String> gettinhthanh() {
        List<String> vietnam=new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT * FROM tb_city";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String tinhthanh= cursor.getString(1);
                // Adding contact to list
                vietnam.add(tinhthanh);
            } while (cursor.moveToNext());
        }

        // return contact list
        return vietnam;
    }
    //lấy tỉnh phường xã trong database
    public List<String> getphuongxa(int a) {
        List<String> vietnam=new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT * FROM tb_town WHERE id_district=?";
        String id= Integer.toString(a);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{id});

        // looping through all rows and adding to list
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String tinhthanh= cursor.getString(2);
                // Adding contact to list
                vietnam.add(tinhthanh);
            } while (cursor.moveToNext());
        }

        // return contact list
        return vietnam;
    }
    //lấy tỉnh quận huyện trong database
    public List<quanhuyen> getquanhuyen() {
        List<quanhuyen> vietnam=new ArrayList<quanhuyen>();
        // Select All Query
        String selectQuery = "SELECT * FROM tb_district WHERE id_city=50";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor != null && cursor.moveToFirst()) {
            do {
                quanhuyen cont = new quanhuyen(cursor.getInt(0),cursor.getString(2));
                // Adding contact to list
                vietnam.add(cont);
            } while (cursor.moveToNext());
        }

        // return contact list
        return vietnam;
    }
    //copy database vào trong DatabasePath
    public void CopyDataBaseFromAsset() throws IOException{

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME);

// Path to the just created empty db
        String outFileName = getDatabasePath();

// if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

// Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

// transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

// Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }
    //get DatabasePath
    private static String getDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX
                + DATABASE_NAME;
    }
    //mở database
    public SQLiteDatabase openDataBase() throws SQLException{
        File dbFile = ctx.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            try {
                CopyDataBaseFromAsset();
                System.out.println("Copying sucess from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
