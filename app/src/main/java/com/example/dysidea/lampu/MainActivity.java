package com.example.dysidea.lampu;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    ToggleButton tglbtnLampu;
    @SuppressWarnings("deprecation")
    Camera kamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Inisial komponen
        tglbtnLampu = findViewById(R.id.tglbntLampu);
        tglbtnLampu.setOnClickListener(this);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onClick(View view) {

        if (view == tglbtnLampu) {
            try {
                if (tglbtnLampu.isChecked()) {
                    kamera = Camera.open();
                    Camera.Parameters params = kamera.getParameters();
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    kamera.setParameters(params);
                    kamera.startPreview();
                } else {
                    Camera.Parameters params = kamera.getParameters();
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    kamera.setParameters(params);
                    kamera.stopPreview();
                    kamera.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("exceptionku", e.getMessage());
            }
        }
    }
}