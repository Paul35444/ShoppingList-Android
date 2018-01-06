package com.devc3.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void METHOD_SEND_TO_ADD_PERSON(View view) {
//        Intent intent = new Intent(MainActivity.this, CLASS_ADD_PERSON.class);
//        MainActivity.this.startActivity(intent);
//    }

    public void METHOD_SEND_TO_VIEWLIST(View view) {
        Intent intent = new Intent(MainActivity.this, DISPLAY_LIST.class);
        MainActivity.this.startActivity(intent);
    }
}