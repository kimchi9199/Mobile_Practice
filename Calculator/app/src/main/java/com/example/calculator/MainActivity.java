package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv,solutionTv;
    MaterialButton buttonC,buttonBrackOpen,buttonBreakClose;
    MaterialButton buttonDivide,buttonMutiply,buttonPlus,buttonMinus,buttonEquals;
    MaterialButton buttonZero,buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine;
    MaterialButton buttonAc,buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assignId(buttonC,R.id.button_c);
        assignId(buttonBrackOpen,R.id.button_open_bracket);
        assignId(buttonBreakClose,R.id.button_close_bracket);
        assignId(buttonDivide,R.id.button_divide);
        assignId(buttonMutiply,R.id.button_multiply);
        assignId(buttonPlus,R.id.button_plus);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonEquals,R.id.button_equals);
        assignId(buttonZero,R.id.button_zero);
        assignId(buttonOne,R.id.button_one);
        assignId(buttonTwo,R.id.button_two);
        assignId(buttonThree,R.id.button_three);
        assignId(buttonFour,R.id.button_four);
        assignId(buttonFive,R.id.button_five);
        assignId(buttonSix,R.id.button_six);
        assignId(buttonSeven,R.id.button_seven);
        assignId(buttonEight,R.id.button_eight);
        assignId(buttonNine,R.id.button_nine);
        assignId(buttonAc,R.id.button_ac);
        assignId(buttonDot,R.id.button_dot);









    }

    void assignId(MaterialButton btn,int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }

        if(buttonText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
        } else {
            dataToCalculate = dataToCalculate+buttonText;
        }
        solutionTv.setText((dataToCalculate));
    }

    String getResult(String data) {
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initsStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace("0","");
            }
            return finalResult;
        } catch (Exception e) {
            return "Error";
        }
    }
}