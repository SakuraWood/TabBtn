package com.sakurawood.tabbtnview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leesure on 16-10-27.
 */

public class TabContainer extends RelativeLayout {
    private Context context;

    private float width;
    private float layoutwidth;
    private float height;
    private int chooseColor;
    private int unchooseColor;
    private List<String> list;

    private TabBtn tabBtn1;
    private TabBtn tabBtn2;
    private List<TextView> textlist;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;


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
        ViewGroup.LayoutParams layoutParams1;
        if (width != 0 && height != 0) {
            layoutParams1 = new LayoutParams(ConvertUtils.dp2px(context, layoutwidth),
                    ConvertUtils.dp2px(context, height));
            setLayoutParams(layoutParams1);
        } else {
            layoutParams1 = getLayoutParams();
            Log.e("layoutparams", ConvertUtils.px2dp(
                    context, layoutParams1.width) + "  " + ConvertUtils.dp2px(context, layoutParams1.height));
            width = layoutParams1.width - 1;
            height = layoutParams1.height;
        }
        textlist = new ArrayList<>();
        tabBtn1 = new TabBtn(context, width, height, chooseColor, unchooseColor, list, false);
        tabBtn2 = new TabBtn(context, width, height, chooseColor, unchooseColor, list, true);


        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ConvertUtils.dp2px(context, width),
                ConvertUtils.dp2px(context, height));
        linearLayout.setLayoutParams(layoutParams);
        addView(tabBtn1);
        addView(tabBtn2);
        for (String str : list) {
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams_textview = new LinearLayout.LayoutParams(
                    ConvertUtils.dp2px(context, (float) width / list.size()), ConvertUtils.dp2px(context, (float) height));
            textView.setLayoutParams(layoutParams_textview);
            textView.setText(str);
            textView.setGravity(Gravity.CENTER);
            textlist.add(textView);
        }
        for (TextView textView : textlist) {
            linearLayout.addView(textView);
        }
        addView(linearLayout);
        initView();
        initListener();
//        textlist.get(0).setTextColor(Color.RED);
    }

    private void initView() {
        for (int i = 0; i < textlist.size(); i++) {
            if (i != 0) {
                tabBtn2.getTablist().get(i).setVisibility(INVISIBLE);
                textlist.get(i).setTextColor(chooseColor);
            } else {
                tabBtn2.getTablist().get(i).setVisibility(VISIBLE);
                textlist.get(i).setTextColor(unchooseColor);
            }
        }
    }

    private void initListener() {
        if (textlist != null) {
            for (int i = 0; i < textlist.size(); i++) {
                final int j = i;
                textlist.get(i).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int k = 0; k < textlist.size(); k++) {
                            if (k == j) {
                                tabBtn2.getTablist().get(k).setVisibility(VISIBLE);
                                textlist.get(k).setTextColor(unchooseColor);
                            } else {
                                tabBtn2.getTablist().get(k).setVisibility(INVISIBLE);
                                textlist.get(k).setTextColor(chooseColor);
                            }
                            if (onItemClickListener != null) {
                                onItemClickListener.onClick(k);
                            }
                        }
                    }
                });

                textlist.get(i).setOnLongClickListener(new OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        for (int k = 0; k < textlist.size(); k++) {
                            if (k == j) {
                                tabBtn2.getTablist().get(k).setVisibility(VISIBLE);
                                textlist.get(k).setTextColor(unchooseColor);
                            } else {
                                tabBtn2.getTablist().get(k).setVisibility(INVISIBLE);
                                textlist.get(k).setTextColor(chooseColor);
                            }
                            if (onItemLongClickListener != null) {
                                onItemLongClickListener.onLongClick(k);
                            }
                        }
                        return false;
                    }
                });
            }
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public interface OnItemLongClickListener {
        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public TabContainer setWidth(int width) {
        this.width = width - 1;
        this.layoutwidth = width;
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
