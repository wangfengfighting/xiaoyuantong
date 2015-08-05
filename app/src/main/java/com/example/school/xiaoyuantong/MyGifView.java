package com.example.school.xiaoyuantong;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/8/4.
 */
public class MyGifView extends View{
    private long movieStart;
    private Movie movie;
    //�˴�������д�ù��췽��
    public MyGifView(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
//���ļ�����InputStream����ȡ��gifͼƬ��Դ
    movie=Movie.decodeStream(context.getResources().openRawResource(R.drawable.loadt));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        long curTime=android.os.SystemClock.uptimeMillis();
//��һ�β���
        if (movieStart == 0) {
            movieStart = curTime;
        }
        if (movie != null) {
            int duraction = movie.duration();
            int relTime = (int) ((curTime-movieStart)%duraction);
            movie.setTime(relTime);
            movie.draw(canvas, 0, 0);
//ǿ���ػ�
            invalidate();
        }
        super.onDraw(canvas);
    }
}
