package com.zitrojjdev.basicui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UI2Activity extends AppCompatActivity {

    private ImageView imgView;
    private Button btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui2);

        imgView = findViewById(R.id.imageView);

        imgView.setVisibility(View.INVISIBLE);

        btn = findViewById(R.id.submitBtn);
        textView = findViewById(R.id.textView);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = textView.getText().toString();
                if (currentText.equals("Ya hemos dado click a la imagen")){
                    textView.setText("");
                } else {
                    textView.setText("Ya hemos dado click a la imagen");
                }

            }
        });

        Toast.makeText(this,"Hello", Toast.LENGTH_LONG).show();
    }

    private void handleClick(View view){

        int visibility = imgView.getVisibility();
        if (visibility == View.INVISIBLE){
            imgView.setVisibility(View.VISIBLE);
        }
        if (visibility == View.VISIBLE){
            imgView.setVisibility(View.INVISIBLE);
        }

    }
}
