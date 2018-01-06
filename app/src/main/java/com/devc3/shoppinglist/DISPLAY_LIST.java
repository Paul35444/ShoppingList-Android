package com.devc3.shoppinglist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.devc3.shoppinglist.Database.DBHELPER;

import java.util.ArrayList;

/**
 * Created by Paul on 7/11/2017.
 */

public class DISPLAY_LIST extends AppCompatActivity {

    private DBHELPER WLDBHELPER;
    private ListView WISHLIST_LISTV;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_list);

        WLDBHELPER = new DBHELPER(this);
        WISHLIST_LISTV = (ListView) findViewById(R.id.ID_LIST_VIEW);

        METHOD_UPDATE_UI();
    }

    private void METHOD_UPDATE_UI() {
        ArrayList<String> wishlist = new ArrayList<>();
        SQLiteDatabase db = WLDBHELPER.getReadableDatabase();

        String[] projection = {
                DBHELPER.WISHLIST_COLUMN_ID,
                DBHELPER.WISHLIST_COLUMN_NAME
        };

        Cursor cursor = db.query(DBHELPER.WISHLIST_TABLE_NAME,
                projection,
                null,
                null, null, null, null);

        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(DBHELPER.WISHLIST_COLUMN_NAME);
            wishlist.add(cursor.getString(idx));
        }

        if (mAdapter == null) {
            Log.d("[ |||CUSTOM LOG ||| ]", "POSITION OUTCOME:  Adapter: " + mAdapter);
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.row_items,
                    R.id.ID_ROW_DISPLAY_NAME,
                    wishlist);
            Log.d("[ |||CUSTOM LOG ||| ]", "POSITION OUTCOME:  Adapter: " + wishlist);
            WISHLIST_LISTV.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(wishlist);
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();

    }

//    public void METHOD_CLICKED_PERSON(View view) {
//        Intent intent = new Intent(DISPLAY_LIST.this, DISPLAY_PERSON.class);
//        // TODO: 2/3/17 Add passing information here
//        TextView name_to_give = (TextView) findViewById(R.id.ID_ROW_DISPLAY_NAME);
//        String name_to_pass = name_to_give.getText().toString();
//        intent.putExtra("THE_NAME_OF_PERSON", name_to_pass);
//        startActivity(intent);
//    }

    public void METHOD_DELETE_TASK(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.ID_ROW_DISPLAY_NAME);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = WLDBHELPER.getWritableDatabase();
        db.delete(WLDBHELPER.WISHLIST_TABLE_NAME,
                WLDBHELPER.WISHLIST_COLUMN_NAME + " = ?",
                new String[]{task});
        db.close();
        METHOD_UPDATE_UI();
    }
}