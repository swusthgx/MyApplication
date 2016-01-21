package com.malata.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;

/*
*
*
* */
public class MainActivity extends Activity implements GestureDetector.OnGestureListener {

    private GestureDetector detector;
    private ImageView imageView;
    private Bitmap bitmap;
    private int width, height;
    private float currentScale = 1;
    private Matrix matrix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detector = new GestureDetector(this);
        imageView = (android.widget.ImageView) findViewById(R.id.ImageView);
        matrix = new Matrix();
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("studio","onTouchEvent");
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.i("studio","onDown");
        Intent intent=new Intent();
        intent.setAction("3");
        sendBroadcast
        sendBroadcastAsUser(intent, new UserHandle(UserHandle.);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.i("studio","onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
        Log.i("studio","onFling   "+"velocityX :"+velocityX);
        velocityX = velocityX > 4000 ? 4000 : velocityX;
        velocityX = velocityX < -4000 ? -4000 : velocityX;
        currentScale += currentScale * velocityX / 1000.0f;
        Log.i("studio","onFling   "+"currentScale :"+currentScale);
        currentScale = currentScale > 0.01f ? currentScale : 0.01f;
        matrix.reset();
        matrix.setScale(currentScale, currentScale, 160, 200);
        BitmapDrawable tmp = (BitmapDrawable) imageView.getDrawable();
        if (!tmp.getBitmap().isRecycled()) {
            tmp.getBitmap().recycle();
        }
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        imageView.setImageBitmap(bitmap2);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
