package com.example.app_images;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {


        ImageView imageView;
        ViewFlipper viewFlipper;
        Button buttonAlpha0,buttonAlpha05, buttonAlpha1, previousButton, nextButton, buttonMatrix, buttonFitEnd, buttonFitCenter, buttonCenterInside, buttonCenterCrop, buttonFitStart, buttonFitXY, buttonCenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                //imageView=findViewById(R.id.imageView);

                buttonCenter=findViewById(R.id.buttonCenter);
                buttonCenterCrop=findViewById(R.id.buttonCenterCrop);
                buttonCenterInside=findViewById(R.id.buttonCenterInside);
                buttonFitCenter=findViewById(R.id.buttonFitCenter);
                buttonFitEnd=findViewById(R.id.buttonFitEnd);
                buttonFitStart=findViewById(R.id.buttonFitStart);
                buttonFitXY=findViewById(R.id.buttonFitXY);
                buttonMatrix=findViewById(R.id.buttonMatrix);
                previousButton=findViewById(R.id.previousButton);
                nextButton= findViewById(R.id.nextButton);
                buttonAlpha0=findViewById(R.id.buttonAlpha0);
                buttonAlpha05=findViewById(R.id.buttonAlpha05);
                buttonAlpha1=findViewById(R.id.buttonAlpha1);
                viewFlipper = findViewById(R.id.viewFlipper);

        }

        public void nextImage (View view){
                viewFlipper.showNext();
        }

        public void previousImage(View view){
                viewFlipper.showPrevious();
        }

        public void fitStart(View view) {
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
        }

        public void fitXY(View view) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        public void center(View view) {
                imageView.setScaleType(ImageView.ScaleType.CENTER);
        }

        public void centerCrop(View view) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        public void centerInside(View view) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }

        public void fitCenter(View view) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

        public void fitEnd(View view) {
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
        }

        public void Matrix(View view) {
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }

        public void setImageAlpha0(View view) {
                //imageView.setImageAlpha(0);
        }

        public void setImageAlpha150(View view) {
                //imageView.setImageAlpha(150);
        }

        public void setImageAlpha255(View view) {
                //imageView.setImageAlpha(255);
        }

}



