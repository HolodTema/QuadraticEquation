package com.terabyte.quadraticequation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editNumberA, editNumberB, editNumberC, editNumberD;
    TextView textOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNumberA = findViewById(R.id.editNumberA);
        editNumberB = findViewById(R.id.editNumberB);
        editNumberC = findViewById(R.id.editNumberC);
        editNumberD = findViewById(R.id.editNumberD);
        textOutput = findViewById(R.id.textOutput);
    }

    public void onClickButtonDoSolution(View view) {
        textOutput.setText("");
        double a,b,c,d;
        a = editNumberA.getText().toString().equals("") ? 1 : Double.parseDouble(editNumberA.getText().toString());
        b = editNumberB.getText().toString().equals("") ? 1 : Double.parseDouble(editNumberB.getText().toString());
        c = editNumberC.getText().toString().equals("") ? 0 : Double.parseDouble(editNumberC.getText().toString());
        d = editNumberD.getText().toString().equals("") ? 0 : Double.parseDouble(editNumberD.getText().toString());
        EquationEngine thread1 = new EquationEngine(this,textOutput, a, b, c);
        thread1.start();
        EquationEngine thread2 = new EquationEngine(this, textOutput, b, c, d);
        thread2.start();
    }

}