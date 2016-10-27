package com.sakurawood.tabbtnview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by leesure on 16-10-27.
 */

public class TabContainer extends RelativeLayout {
    private Context context;

    private int width;
    private int height;
    private int chooseColor;
    private int unchooseColor;
    private List<String> list;


    public TabContainer(Context context) {
        super(context);
        this.context = context;
    }

    public TabContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public TabContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void show() {
        TabBtn tabBtn1 = new TabBtn(context, width, height, chooseColor, unchooseColor, list, false);
        TabBtn tabBtn2 = new TabBtn(context, width, height, chooseColor, unchooseColor, list, true);

        addView(tabBtn1);
        addView(tabBtn2);
    }

    public TabContainer setWidth(int width) {
        this.width = width;
        return this;
    }

    public TabContainer setHeight(int height) {
        this.height = height;
        return this;
    }

    public TabContainer setChooseColor(int chooseColor) {
        this.chooseColor = chooseColor;
        return this;
    }

    public TabContainer setUnchooseColor(int unchooseColor) {
        this.unchooseColor = unchooseColor;
        return this;
    }

    public TabContainer setList(List<String> list) {
        this.list = list;
        return this;
    }

}
