package org.techtown.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MineView extends View {
    public MineView(Context context) {
        super(context);
    }

    public MineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
