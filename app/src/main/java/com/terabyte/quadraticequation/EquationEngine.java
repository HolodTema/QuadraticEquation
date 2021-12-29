package com.terabyte.quadraticequation;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class EquationEngine extends Thread {
    private Activity activity;
    TextView textOutput;
    private double a, b, c;

    public static int count = 0;
    private int instanceNumber;


    // there is equation kinda ax^2+bx+c
    public EquationEngine(Activity activity, TextView textOutput, double a, double b, double c) {
        if(count==2) {
            count = 0;
        }
        count++;
        this.instanceNumber = count;
        this.activity = activity;
        this.textOutput = textOutput;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void run() {
        super.run();
        double discriminant = b*b - 4*a*c;
        double x1 = (-b+Math.sqrt(discriminant))/2*a;
        double x2 = (-b-Math.sqrt(discriminant))/2*a;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textOutput.append(createOutputString(discriminant, x1, x2));
            }
        });


    }

    private String createOutputString(double discriminant, double x1, double x2) {
        String result = "";
        result+="работает поток №"+instanceNumber+"\n";
        if(instanceNumber==1) {
            result+="Решение квадратного уравнения вида ax^2 + bx + c\n";
        }
        if(instanceNumber==2) {
            result+="Решение квадратного уравнения вида bx^2 + cx + d\n";
        }
        result+="Уравнение "+a+"x^2  +  "+b+"x  +  "+c+"\n";
        result+="Дискриминант равен "+discriminant+"\n";
        if(discriminant>=0) {
            result += "x1= " + x1 + "\n";
            result += "x2= " + x2 + "\n";
        }
        else {
            result+="решений нет.\n";
        }
        result+="\n";
        return result;
    }


}
