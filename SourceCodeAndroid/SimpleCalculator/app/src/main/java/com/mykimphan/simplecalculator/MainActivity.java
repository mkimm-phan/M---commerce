package com.mykimphan.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import javax.script.ScriptEngineFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtInput, txtResult;
    MaterialButton btnClear, btnOpenBracket, btnCloseBracket, btnDivide, btnMultiply, btnPlus, btnMinus, btnEquals, btnDot, btnAC;
    MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    String Input = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult=findViewById(R.id.txtResult);
        txtInput=findViewById(R.id.txtInput);

        assignID(btnClear, R.id.btnClear);
        assignID(btnOpenBracket, R.id.btnOpenBracket);
        assignID(btnCloseBracket, R.id.btnCloseBracket);
        assignID(btnDivide, R.id.btnDivide);
        assignID(btnMinus, R.id.btnMinus);
        assignID(btnMultiply, R.id.btnMultiply);
        assignID(btnEquals, R.id.btnEquals);
        assignID(btnDot, R.id.btnDot);
        assignID(btnAC, R.id.btnAC);
        assignID(btnPlus, R.id.btnPlus);
        assignID(btn0, R.id.btn0);
        assignID(btn1, R.id.btn1);
        assignID(btn2, R.id.btn2);
        assignID(btn3, R.id.btn3);
        assignID(btn4, R.id.btn4);
        assignID(btn5, R.id.btn5);
        assignID(btn6, R.id.btn6);
        assignID(btn7, R.id.btn7);
        assignID(btn8, R.id.btn8);
        assignID(btn9, R.id.btn9);
    }

    void assignID(MaterialButton btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString();
        String dataToCalculate = txtInput.getText().toString();

        if (buttonText.equals("AC")){
            txtInput.setText("");
            txtResult.setText("0");
            return;
        }
        if (buttonText.equals("=")){
            txtInput.setText(txtResult.getText());
            return;
        }
        if (buttonText.equals("C")){
            dataToCalculate=dataToCalculate.substring(0, dataToCalculate.length()-1);
        }
        else {
            dataToCalculate = dataToCalculate + buttonText;
        }
        txtInput.setText(dataToCalculate);

        String finalResults = getResults(dataToCalculate);

        if (!finalResults.equals("Err")){
            txtResult.setText(finalResults);
        }
    }

    String getResults(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResults = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalResults.endsWith(".0")){
                finalResults = finalResults.replace(".0","");
            }
            return finalResults;
        }
        catch (Exception e){
            return "Err";
        }
    }
}