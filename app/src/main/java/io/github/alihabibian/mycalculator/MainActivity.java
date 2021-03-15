package io.github.alihabibian.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum Operator {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    TextView txtCalculation, txtResults;

    // Instance Variables
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private Operator currentOperator;
    private int calculationsResult;
    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize
        currentNumber = "";
        calculationsResult = 0;
        calculationsString = "";

        txtCalculation = (TextView) findViewById(R.id.txt_calculations);
        txtResults = (TextView) findViewById(R.id.txt_results);

        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.bnt6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn_equal).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn_plus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn_subtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn_multiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn_divide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn_clear).setOnClickListener(MainActivity.this);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.bnt6:
                numberIsTapped(6);
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btn_equal:
                operatorIsTapped(Operator.EQUAL);
                break;
            case R.id.btn_plus:
                operatorIsTapped(Operator.PLUS);
                calculationsString += " + ";
                break;
            case R.id.btn_subtract:
                operatorIsTapped(Operator.SUBTRACT);
                calculationsString += " - ";
                break;
            case R.id.btn_multiply:
                operatorIsTapped(Operator.MULTIPLY);
                calculationsString += " * ";
                break;
            case R.id.btn_divide:
                operatorIsTapped(Operator.DIVIDE);
                calculationsString += " / ";
                break;
            case R.id.btn_clear:
                clearTapped();
                break;
        }

        txtCalculation.setText(calculationsString);
    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + tappedNumber;
        txtResults.setText(currentNumber);
        calculationsString = currentNumber;
        txtCalculation.setText(calculationsString);
    }

    private void operatorIsTapped(Operator tappedOperator) {
        if (currentOperator != null) {
            if (!currentNumber.equals("")) {
                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {
                    case PLUS:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationsResult);
                txtResults.setText(stringNumberAtLeft);
                calculationsString = stringNumberAtLeft;
            }
        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }

    private void clearTapped() {
        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculationsResult = 0;
        currentNumber = "";
        currentOperator = null;
        txtResults.setText("0");
        calculationsString = "0";
    }
}