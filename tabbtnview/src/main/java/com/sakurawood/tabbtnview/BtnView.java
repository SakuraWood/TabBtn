package com.sakurawood.tabbtnview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.TextView;

/**
 * Created by leesure on 16-10-27.
 */

public class BtnView extends TextView {
    private Context context;
    private int width;
    private int height;
    private int chooseColor;
    private int unchooseColor;
    private boolean isLeft;
    private boolean isRight;
    private boolean isChoosen;

    public BtnView(Context context) {
        super(context);
    }

    public BtnView(Context context, int height, int width, int chooseColor,
                   int unchooseColor, boolean isLeft, boolean isRight, boolean isChoosen) {
        super(context);
        this.height = height;
        this.width = width;
        this.context = context;
        this.chooseColor = chooseColor;
        this.unchooseColor = unchooseColor;
        this.isLeft = isLeft;
        this.isRight = isRight;
        this.isChoosen = isChoosen;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width)
                , ConvertUtils.dp2px(context, height));
        Paint paint = new Paint();
        paint.setColor(chooseColor);
        paint.setAntiAlias(true);
        paint.setAlpha(255);
        canvas.drawRoundRect(rectF, ConvertUtils.dp2px(context, (float) height / 5)
                , ConvertUtils.dp2px(context, (float) height / 5), paint);
        if (isLeft) {
            if (isChoosen) {
                paint.setColor(chooseColor);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1)
                        , ConvertUtils.dp2px(context, height - 1));
                canvas.drawRoundRect(rectF, ConvertUtils.dp2px(context, (float) height / 5 - 1)
                        , ConvertUtils.dp2px(context, (float) height / 5 - 1), paint);
                rectF = new RectF(ConvertUtils.dp2px(context, height / 5 * 2), 0, ConvertUtils.dp2px(context, width - 1),
                        ConvertUtils.dp2px(context, height - 1 - height / 5 * 2));
                canvas.drawRoundRect(rectF, 0, 0, paint);
            } else {
                paint.setColor(unchooseColor);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1)
                        , ConvertUtils.dp2px(context, height - 1));
                canvas.drawRoundRect(rectF, ConvertUtils.dp2px(context, (float) height / 5 - 1)
                        , ConvertUtils.dp2px(context, (float) height / 5 - 1), paint);
                rectF = new RectF(ConvertUtils.dp2px(context, height / 5 * 2), 0, ConvertUtils.dp2px(context, width - 1),
                        ConvertUtils.dp2px(context, height - 1 - height / 5 * 2));
                canvas.drawRoundRect(rectF, 0, 0, paint);
            }
        }

        if (isRight) {
            if (isChoosen) {
                paint.setColor(chooseColor);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1)
                        , ConvertUtils.dp2px(context, height - 1));
                canvas.drawRoundRect(rectF, ConvertUtils.dp2px(context, (float) height / 5 - 1)
                        , ConvertUtils.dp2px(context, (float) height / 5 - 1), paint);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1 - height / 5),
                        ConvertUtils.dp2px(context, height - 1 - height / 5 * 2));
                canvas.drawRoundRect(rectF, 0, 0, paint);
            } else {
                paint.setColor(unchooseColor);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1)
                        , ConvertUtils.dp2px(context, height - 1));
                canvas.drawRoundRect(rectF, ConvertUtils.dp2px(context, (float) height / 5 - 1)
                        , ConvertUtils.dp2px(context, (float) height / 5 - 1), paint);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1 - height / 5),
                        ConvertUtils.dp2px(context, height - 1 - height / 5 * 2));
                canvas.drawRoundRect(rectF, 0, 0, paint);
            }
        }

        if (!isLeft && !isRight) {
            if (isChoosen) {
                paint.setColor(chooseColor);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1)
                        , ConvertUtils.dp2px(context, height - 1));
                canvas.drawRoundRect(rectF, 0, 0, paint);
            } else {
                paint.setColor(unchooseColor);
                rectF = new RectF(0, 0, ConvertUtils.dp2px(context, width - 1)
                        , ConvertUtils.dp2px(context, height - 1));
                canvas.drawRoundRect(rectF, 0, 0, paint);
            }
        }
    }
}
