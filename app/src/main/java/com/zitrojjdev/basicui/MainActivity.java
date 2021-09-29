package com.zitrojjdev.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private CheckBox nameCheckBox;
    private TextView outputText;
    private Button submitButton;
    private RadioGroup radioGroup;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameCheckBox = findViewById(R.id.nameCheckBox);
        radioGroup = findViewById(R.id.radioGroup);
        progressBar = findViewById(R.id.progressBar);
        submitButton = findViewById(R.id.submitButton);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    progressBar.setProgress(i);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println("ERROR ");
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }

     public void handleClick (View view){
        outputText = findViewById(R.id.outputText);
        nameCheckBox = findViewById(R.id.nameCheckBox);
        int checkedRadioBtnId = radioGroup.getCheckedRadioButtonId();
        RadioButton checkedBtn = findViewById(checkedRadioBtnId);
        //String name = inputName.getText().toString();
        if(nameCheckBox.isChecked()){
            outputText.setText("Checkbox was checked and the gender value is "+checkedBtn.getText().toString() );
            System.out.println("It is checked");
            nameCheckBox.setChecked(false);
        } else {
            outputText.setText("Checkbox was not checked and the gender value is "+checkedBtn.getText().toString() );
            System.out.println("Not checked");
            nameCheckBox.setChecked(true);
        }
         System.out.println(checkedBtn.getText().toString());

     }
}

