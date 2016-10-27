package com.sakurawood.tabbtnview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leesure on 16-10-27.
 */

public class TabBtn extends LinearLayout {
    private int num;
    private Context context;
    private float width;
    private float height;
    private int chooseColor;
    private int unchooseColor;
    private List<String> list;
    private List<BtnView> tablist;
    private boolean isChoosen;

    public TabBtn(Context context) {
        super(context);
        this.context = context;
    }

    public TabBtn(Context context, float width, float height
            , int chooseColor, int unchooseColor, List<String> list, boolean isChoosen) {
        super(context);
        this.context = context;
        this.width = width;
        this.height = height;
        this.chooseColor = chooseColor;
        this.unchooseColor = unchooseColor;
        this.list = list;
        this.isChoosen = isChoosen;
        this.num = list.size();
        show();
    }

    public TabBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public TabBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public List<BtnView> getTablist() {
        return tablist;
    }

    private void show() {
        setOrientation(HORIZONTAL);
        if (num != 0) {
            if (list != null) {
                tablist = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    if (i == 0) {
                        if (isChoosen) {
                            BtnView btnView = new BtnView(context, height, width / num,
                                    chooseColor, unchooseColor, true, false, true);
                            tablist.add(btnView);
                        } else {
                            BtnView btnView = new BtnView(context, height, width / num,
                                    chooseColor, unchooseColor, true, false, false);
                            btnView.setText(list.get(i));
                            tablist.add(btnView);
                        }

                    } else if (i == num - 1) {
                        if (isChoosen) {
                            BtnView btnView = new BtnView(context, height, width / num,
                                    chooseColor, unchooseColor, false, true, true);
                            tablist.add(btnView);

                        } else {
                            BtnView btnView = new BtnView(context, height, width / num,
                                    chooseColor, unchooseColor, false, true, false);
                            tablist.add(btnView);
                        }
                    } else {
                        if (isChoosen) {
                            BtnView btnView = new BtnView(context, height, width / num,
                                    chooseColor, unchooseColor, false, false, true);
                            tablist.add(btnView);
                        } else {
                            BtnView btnView = new BtnView(context, height, width / num,
                                    chooseColor, unchooseColor, false, false, false);
                            tablist.add(btnView);
                        }
                    }
                }

                for (int i = 0; i < num; i++) {
                    LayoutParams layoutParams = new LayoutParams(
                            ConvertUtils.dp2px(context, (float) width / num), ConvertUtils.dp2px(context, (float) height));
                    MarginLayoutParams marginLayoutParams = new MarginLayoutParams(layoutParams);
                    marginLayoutParams.leftMargin = ConvertUtils.dp2px(context, 100);
                    tablist.get(i).setLayoutParams(marginLayoutParams);
                    addView(tablist.get(i));
                }
            }
        }
    }
}
