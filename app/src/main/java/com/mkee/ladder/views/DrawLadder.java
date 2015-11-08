package com.mkee.ladder.views;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by khjc7265 on 2015-07-31. 응가 뿡뿡
 */
public class DrawLadder extends View {

    Context mContext;
    Paint mPaint;
    Canvas mCanvas;
    Bitmap mBitmap;
    ArrayList<Vertex> mVerticalLineList;
    Path mPath;

    public DrawLadder(Context context,int width, int height, int userNum) {
        super(context);

        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);

        mBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mPath = new Path();

        mVerticalLineList = new ArrayList<>();
        drawVerticalLine(userNum,width,height);

    }

    private void drawVerticalLine(int userNum, int width, int height){

        int gap = width/userNum;
        int x = gap/2;

        mVerticalLineList.add(new Vertex(x, 0, true));
        mVerticalLineList.add(new Vertex(x, height, false));

        mPath.moveTo(x, 0);
        mPath.lineTo(x, height);
        invalidate();


        for(int i=0; i<userNum/2; i++){
            x += gap;
            mVerticalLineList.add(new Vertex(x,0,true));
            mVerticalLineList.add(new Vertex(x, height, false));
            mPath.moveTo(x, 0);
            mPath.lineTo(x, height);
            invalidate();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mVerticalLineList.size() !=0)
            canvas.drawPath(mPath, mPaint);
        else {
            mBitmap.eraseColor(Color.TRANSPARENT);
            canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    class Vertex{

        float startX, startY;
        float endX, endY;

        Vertex(float x, float y,boolean bStart){
            if(bStart){
                startX = x;
                startY = y;
            }
            else{
                endX = x;
                endY = y;
            }
        }
    }
}
