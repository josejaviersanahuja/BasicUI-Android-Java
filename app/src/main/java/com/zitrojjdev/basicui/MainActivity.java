package com.zitrojjdev.basicui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    // override 1. here we will inflate the menu items for this activity.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_manu, menu);
        return true;
    }

    // override 2 we will receive the MenuItem when we click and act accordingly
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.UI1:
                Toast.makeText(this, "UI 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.UI2:
                Toast.makeText(this, "UI 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.UI3:
                Toast.makeText(this, "UI 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.UI4:
                Toast.makeText(this, "UI 4 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

