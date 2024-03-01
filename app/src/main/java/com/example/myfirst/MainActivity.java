package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mFactTV;
    private EditText mFactET;
    private Button mFactBTN;
    //int nombre = Integer.parseInt(mFactET.getText().toString());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }



    private void initView() {
        mFactBTN = findViewById(R.id.button);
        mFactET = findViewById(R.id.editTextText);
        mFactTV = findViewById(R.id.textView2);
    }

    private void initEvent() {
        mFactBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFactET.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.first_helper_text),
                            Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(mFactET.getText().toString()) < 0) {
                    Toast.makeText(MainActivity.this, getString(R.string.second_helper_text),
                            Toast.LENGTH_LONG).show();
                } else {
                     int nombre = Integer.parseInt(mFactET.getText().toString());
                    int fact = calculerFactorielle(nombre);
                    mFactTV.setText("La factorielle de " + nombre + " est : " + fact);
                }
            }
        });
    }

    private int calculerFactorielle(int nombre) {
        if (nombre == 0 || nombre == 1) {
            return 1;
        } else {
            int resultat = 1;
            for (int i = 2; i <= nombre; i++) {
                resultat *= i;
            }
            return resultat;
        }
    }
}