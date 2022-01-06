package com.example.android9;

import static androidx.core.view.ViewCompat.setLayerType;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout ll=findViewById(R.id.frameLayout1);
        ll.addView(new MyView(this));
    }


         class  MyView extends View{
            public MyView(Context content){
                super(content);
            }

            @Override
            protected void onDraw(Canvas canvas) {
                Paint paint = new Paint();
                Shader shader = new LinearGradient(0, 0, 50, 50,Color.RED, Color.GREEN, Shader.TileMode.MIRROR);
                paint.setShader(shader);
                canvas.drawRect(10, 70, 100,150, paint);

                shader = new RadialGradient(160, 110, 50,Color.RED, Color.GREEN, Shader.TileMode.MIRROR);
                paint.setShader(shader);
                canvas.drawRect(115, 70, 205,150, paint);

                shader = new SweepGradient(265, 110, new int[]{Color.RED, Color.GREEN, Color.BLUE}, null);
                paint.setShader(shader);
                canvas.drawRect(220, 70, 310,150, paint);

                super.onDraw(canvas);
            }
        }

}