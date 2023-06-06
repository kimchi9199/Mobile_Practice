package com.example.lab01_ex5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result, solution;
    MaterialButton buttonC, buttonOpenBr, buttonCloseBr,buttonAC,  buttonDot, buttonEqual;
    MaterialButton  buttonPlus, buttonMinus , buttonDivide, buttonMultiply;
    MaterialButton button0,button1, button2, button3,button4, button5, button6,button7, button8, button9;

    String lastClickedNumber = "";
    String lastClickedOperation = "";
    int memory = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);

        assignID(button0, R.id.bnt_0);
        assignID(button1, R.id.bnt_1);
        assignID(button2, R.id.bnt_2);
        assignID(button3, R.id.bnt_3);
        assignID(button4, R.id.bnt_4);
        assignID(button5, R.id.bnt_5);
        assignID(button6, R.id.bnt_6);
        assignID(button7, R.id.bnt_7);
        assignID(button8, R.id.bnt_8);
        assignID(button9, R.id.bnt_9);
        assignID(buttonC, R.id.bnt_c);
        assignID(buttonPlus, R.id.btn_plus);
        assignID(buttonMinus, R.id.btn_minus);
        assignID(buttonDivide, R.id.btn_divide);
        assignID(buttonMultiply, R.id.bnt_multiply);
        assignID(buttonOpenBr, R.id.bnt_open_bracket);
        assignID(buttonCloseBr, R.id.bnt_close_bracket);
        assignID(buttonAC, R.id.bnt_AC);
        assignID(buttonDot, R.id.bnt_dot);
        assignID(buttonEqual, R.id.btn_equal);
    }

    void assignID(MaterialButton bnt, int id) {
        bnt = findViewById(id);
        bnt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString();
        String calculateData = solution.getText().toString();


        if(buttonText.matches("\\d+(?:\\.\\d+)?"))
        {
            lastClickedNumber = buttonText;
        }

        if (buttonText.equals("+") || buttonText.equals("-") ||
                buttonText.equals("*") || buttonText.equals("/"))
        {
            // String in java is immutable, so we have to use this way to change the value of
            // a string
            lastClickedOperation = String.copyValueOf(buttonText.toCharArray(), 0, buttonText.length());
        }


        if(buttonText.equals("AC")){
            solution.setText("");
            result.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            if (lastClickedOperation.equals("/")) {
                calculateData = calculateData + "/" + lastClickedNumber;
            }
            if (lastClickedOperation.equals("+")) {
                calculateData = calculateData + "+" + lastClickedNumber;
            }
            if (lastClickedOperation.equals("-")) {
                calculateData = calculateData + "-" + lastClickedNumber;
            }
            if(lastClickedOperation.equals("*")) {
                calculateData = calculateData + "*" + lastClickedNumber;
            }
//            solution.setText(result.getText());
            memory += 1;
            solution.setText(calculateData);
            String finalResult = getResult(calculateData);
            if(!finalResult.equals("Error")){
                result.setText(finalResult);
            }
            return;
        }
        if(buttonText.equals("C")){
            calculateData = calculateData.substring(0, calculateData.length()-1);
        } else {
            calculateData = calculateData + buttonText;
        }
        solution.setText(calculateData);
        String finalResult = getResult(calculateData);

        if(!finalResult.equals("Error")){
            result.setText(finalResult);
        }

    }

    String getResult(String data){
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            return "Error";
        }
    }

}