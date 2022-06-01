package com.example.weightconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText txt;
    TextInputLayout body_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.editText);
        body_txt = findViewById(R.id.body);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = txt.getText().toString();
                if (!validateData()) {
                    return;
                }

                int kg = Integer.parseInt(s);
                double pound = 2.205 * kg;
                Toast.makeText(MainActivity.this, "Your Weight in pound is " + pound + ".", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateData() {
        String val = body_txt.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            body_txt.setError("Field cannot be empty");
            return false;
        } else {
            body_txt.setError(null);
            body_txt.setErrorEnabled(false);
            return true;
        }

    }
}