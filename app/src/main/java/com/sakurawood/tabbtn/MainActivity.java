package com.sakurawood.tabbtn;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sakurawood.tabbtnview.TabContainer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabContainer tabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabBtn = (TabContainer) findViewById(R.id.tabbtn);
        List<String> list = new ArrayList<String>() {
            {
                add("hehe");
                add("haha");
                add("heihei");
                add("huhu");
                add("haha");
                add("heihei");
                add("huhu");
                add("hehe");
                add("haha");
//                add("heihei");
//                add("huhu");
//                add("haha");
//                add("heihei");
//                add("huhu");
            }
        };
        tabBtn.setWidth(300).setHeight(60)
                .setChooseColor(Color.RED)
                .setUnchooseColor(Color.BLUE).setList(list).show();
    }
}
