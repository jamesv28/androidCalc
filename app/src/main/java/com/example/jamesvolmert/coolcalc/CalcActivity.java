package com.example.jamesvolmert.coolcalc;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    String runningNumber = "";
    String leftVal = "";
    String rightVal = "";
    Operation currentOperation;
    int result = 0;

    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL;
    }

    //  TextView
    TextView resultsTxt;

    //  this is like view did load
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        //  TextView
        resultsTxt = (TextView)findViewById(R.id.resultsText);

        //  create reference for the buttons - in iOS it is like IBAction
        //  The button in the parenthesis is for casting the button
        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);
        Button clearBtn = (Button)findViewById(R.id.clearBtn);


        //  symbols
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton)findViewById(R.id.multiplyBtn);
        ImageButton subtractBtn = (ImageButton)findViewById(R.id.subtractBtn);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);
        ImageButton equalBtn = (ImageButton)findViewById(R.id.calcBtn);

        resultsTxt.setText("");

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(0);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                leftVal = "";
                rightVal = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultsTxt.setText("0");

            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });


    } // end of onCreate

    void processOperation(Operation operation) {
        if (currentOperation != null) {
            if (runningNumber != "") {
                rightVal = runningNumber;
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftVal) + Integer.parseInt(rightVal);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftVal) - Integer.parseInt(rightVal);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftVal) * Integer.parseInt(rightVal);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftVal) / Integer.parseInt(rightVal);
                        break;
                }

                leftVal = String.valueOf(result);
                resultsTxt.setText(leftVal);
            }
        } else {
            leftVal = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
    };  // end of operation

    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultsTxt.setText(runningNumber);

    }
}   // end of class
