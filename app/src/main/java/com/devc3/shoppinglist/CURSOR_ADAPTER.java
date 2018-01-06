package com.devc3.shoppinglist;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Paul on 7/11/2017.
 */

public class CURSOR_ADAPTER extends CursorAdapter {

    public CURSOR_ADAPTER(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        Log.d("[ |||CUSTOM LOG ||| ]", "ENTERED GETVIEW");
        View view = super.getView(position, convertview, parent);
        Context context = view.getContext();
        Log.d("[ |||CUSTOM LOG ||| ]", "POSITION NUMBER:" + position);
        if (position % 2 == 0) {
            Log.d("[ |||CUSTOM LOG ||| ]", "IF POSITION OUTCOME:  Position: " + position + " % 2 = " + position % 2);
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.COLOR_ONE));
        } else {
            Log.d("[ |||CUSTOM LOG ||| ]", "ELSE POSITION OUTCOME:  Position: " + position + " % 2 = " + position % 2);
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.COLOR_FOUR));
        }
        return view;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row_items, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewName = (TextView) view.findViewById(R.id.ID_ROW_DISPLAY_NAME);
    }
}