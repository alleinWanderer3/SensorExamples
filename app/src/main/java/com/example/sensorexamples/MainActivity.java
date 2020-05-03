package com.example.sensorexamples;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.tv_data);
    ConstraintLayout constraintLayout = findViewById(R.id.cl_main);
       constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int count=event.getPointerCount();
                textView.setText("пальцы "+count);
                for(int i = 0; i < count;++i){
                    MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
                    event.getPointerCoords(i,coords);
                    textView.append(String.format("\nпалец %d x=%f, y=%f", event.getPointerId(i),coords.x,coords.y ));
                }
                textView.append(("\n"+event.getAction()));
                return true;
            }
        });
    }
}