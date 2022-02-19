package com.example.baitap_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_Fahrenhiet = findViewById(R.id.editText_Fahrenhiet);
        EditText et_Celcius = findViewById(R.id.editText_Celsius);
        Button bt_CTC = findViewById(R.id.button_CTC);
        Button bt_CTF = findViewById(R.id.button_CTF);
        Button bt_Clear = findViewById(R.id.button_Clear);

        bt_CTC.setOnClickListener(view -> {
            float f = Float.parseFloat(et_Fahrenhiet.getText().toString());
            float rs = (f - 32) * 5 / 9;
            String output = "" + rs;
            et_Celcius.setText(output);
        });
        bt_CTF.setOnClickListener(view -> {
            float c = Float.parseFloat(et_Celcius.getText().toString());
            float rs = c * 9 / 5 + 32;
            String output = "" + rs;
            et_Fahrenhiet.setText(output);
        });
        bt_Clear.setOnClickListener(view -> {
            et_Celcius.setText("");
            et_Fahrenhiet.setText("");
            et_Fahrenhiet.requestFocus();
        });
    }
}