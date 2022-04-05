package org.techtown.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View {
    int x1=78,y1=100;
    int yy = 22;

    int rotate = 0;

    public MyView(Context context){
        super(context);
        init();
    }
    public MyView(Context context, AttributeSet att){
        super(context,att);
        init();
    }
    public MyView(Context context,AttributeSet att, int a){
        super(context,att,a);
        init();
    }


    @Override
    public void onDraw(Canvas c){
        Paint paint= new Paint();
        paint.setColor(Color.DKGRAY);

        Paint paint_rect = new Paint();
        paint_rect.setColor(Color.RED);

        draw_background(c, paint);
        print_background(c, paint_rect);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(Blocks.block_L[rotate % 4][i][j] == 1)
                    c.drawRect(x1 + 22*j, y1 + 22 * i, (x1+19) + 22 * j, (y1+19)+22*i, paint_rect);
            }
        }
    }

    void loop_func() {
        int now_y = (y1 - 54) / yy + 3;
        int now_x = (x1+22) / yy;
        if (overlap_check(rotate, now_x, now_y + 1) == 0) {
            y1 = y1 + yy;
        } else {
            insert_background(rotate, now_x, now_y);
            rotate = 0;
            x1 = 78;
            y1 = 100;
        }
        invalidate(); //데이터갱신
    }

    public void draw_background(Canvas c, Paint paint){
        for(int i = 0; i < 21; i++) {
            c.drawLine(10, 10+22*i, 231, 10+22*i, paint);
        }

        for(int i = 0; i < 11; i++){
            c.drawLine(10+22*i, 10, 10+22*i, 451, paint);
        }
    }

    public void print_background(Canvas c, Paint paint){
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 10; j++){
                if(Blocks.background[i+1][j+1] == 1)
                    c.drawRect(12 + 22*j, 12 + 22*i, 31 + 22 *j, 31+22*i, paint);
            }
        }
    }

    int overlap_check(int rotate, int x, int y) {
        int overlap_count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Blocks.block_L[rotate % 4][i][j] == 1 && Blocks.background[y + i][x + j] == 1)
                    overlap_count++;
            }
        }
        return overlap_count;
    }

    void insert_background(int rotate, int x, int y){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(Blocks.block_L[rotate % 4][i][j] == 1)
                    Blocks.background[y+i][x+j] = 1;
            }
        }
    }

    void moveLeft(){
        int now_y = (y1 - 54) / yy + 3;
        int now_x = (x1+22) / yy;

        if (overlap_check(rotate,now_x-1,now_y)==0){
            int xx = 22;
            x1 = x1 - xx;
            this.invalidate();
        }
    }
    void moveRight(){
        int now_y = (y1 - 54) / yy + 3;
        int now_x = (x1+22) / yy;
        if (overlap_check(rotate,now_x+1,now_y)==0){
            int xx = 22;
            x1 = x1 + xx;
            this.invalidate();
        }
    }
    void rotate(){
        rotate++;
        this.invalidate();
    }

    void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // 코드 작성
                    loop_func();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }



//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int eventAction = event.getAction();
//
//        int x = (int)event.getX();
//        int y = (int)event.getY();
//
//        switch (eventAction) {
//            case MotionEvent.ACTION_DOWN:
//                int now_y = (y1 - 54)/22;
//                int now_x = (x1)/22 ;
//
//                if(y > 360){
//                    rotate++;
//                    this.invalidate();
//                } else if(x < 640 && overlap_check(rotate,now_y,now_x)<1){
//                    int xx = 22;
//                    x1 = x1 - xx;
//                    this.invalidate();
//                } else if(x > 640 && overlap_check(rotate,now_y,now_x)<1){
//                    int xx = 22;
//                    x1 = x1 + xx;
//                    this.invalidate();
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_MOVE:
//                break;
//        }
//
//        return true;
//    }
}