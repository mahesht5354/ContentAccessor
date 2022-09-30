package com.example.contentaccessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String authories = "content://in.rajnaresh.CONTENT";
    TextView tv;

    public static final String COL_0 = "student_id";
    public static final String COL_1 = "student_name";
    public static final String COL_2 = "student_age";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.raj);

        Uri CONTENT_URI = Uri.parse(authories);
        Cursor c = getContentResolver().query(CONTENT_URI, null, null, null, null);
        tv.setText("");
        if (c!= null)
        {
            c.moveToFirst();
            do {
                int s_id = c.getInt(0);
                String s_name = c.getString(1);
                int s_age = c.getInt(2);
                tv.append(s_id +"\n"+ s_name+"\n"+ s_age+"\n\n");

            }while (c.moveToNext());
        }

       /* ContentValues values =  new ContentValues();
        values.put(COL_1,"Karthik");
        values.put(COL_2, "57");
        Uri uri = getContentResolver().insert(CONTENT_URI, values);

        if (uri!=null) {
            Toast.makeText(this, "values instered", Toast.LENGTH_SHORT).show();
        }*/

        ContentValues values1 =  new ContentValues();
        values1.put(COL_1,"Ramya");
        values1.put(COL_2, "97");
        values1.put(COL_0, 3);

        int uri2 = getContentResolver().update(CONTENT_URI, values1,COL_0, null);


        Bundle bundle = new Bundle();
        bundle.putInt(COL_0, 2);

        String coltodelete = "3";
        int uri3 = getContentResolver().delete(CONTENT_URI, coltodelete, null);

    }
}