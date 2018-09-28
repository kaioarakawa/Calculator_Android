package br.edu.ifc.videira.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

import br.edu.ifc.videira.calculadora.handlers.FinalResult;
import br.edu.ifc.videira.calculadora.handlers.FinalResultsHandler;

public class MainActivity extends AppCompatActivity {

    TextView txtExpression;
    Button btn0, btn1, btn2, btn3, btn4;
    Button btn5, btn6, btn7, btn8, btn9;
    Button btnMinus, btnPlus, btnDivide, btnMultiply;
    Button btnBackspace, btnCalculate, btnReset, btnDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtExpression = (TextView) this.findViewById(R.id.txtExpression);
        btn0 = (Button) this.findViewById(R.id.btn0);
        btn1 = (Button) this.findViewById(R.id.btn1);
        btn2 = (Button) this.findViewById(R.id.btn2);
        btn3 = (Button) this.findViewById(R.id.btn3);
        btn4 = (Button) this.findViewById(R.id.btn4);
        btn5 = (Button) this.findViewById(R.id.btn5);
        btn6 = (Button) this.findViewById(R.id.btn6);
        btn7 = (Button) this.findViewById(R.id.btn7);
        btn8 = (Button) this.findViewById(R.id.btn8);
        btn9 = (Button) this.findViewById(R.id.btn9);
        btnDot = (Button) this.findViewById(R.id.btnDot);

        btnDivide = (Button) this.findViewById(R.id.btnDivide);
        btnMultiply = (Button) this.findViewById(R.id.btnMultiply);
        btnPlus = (Button) this.findViewById(R.id.btnPlus);
        btnMinus = (Button) this.findViewById(R.id.btnMinus);

        btnBackspace = (Button) this.findViewById(R.id.btnBackspace);
        btnReset = (Button) this.findViewById(R.id.btnReset);
        btnCalculate = (Button) this.findViewById(R.id.btnCalculate);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append(".");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("-");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("+");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.append("/");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.setText("");
            }
        });

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String original = txtExpression.getText().toString();
                txtExpression.setText(removeLastChar(original));
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exp = txtExpression.getText().toString();

                Expression e = new Expression(exp);
                double result = e.calculate();

                String finalResult = "" + result;

                if (finalResult.equals("NaN")) {
                    Toast toast = Toast.makeText(
                                        getApplicationContext(),
                                        "Expressão Matemática Incorreta!",
                                        Toast.LENGTH_LONG);

                    toast.show();
                } else {
                    Intent i = new Intent(MainActivity.this, ResultActivity.class);

                    FinalResult fr = new FinalResult();
                    fr.setResult(exp + " = " + finalResult);
                    fr.setDate("" + System.currentTimeMillis());

                    if(FinalResultsHandler.finalResults.size() ==  10){
                        FinalResultsHandler.finalResults.remove(0);
                        FinalResultsHandler.finalResults.add(fr);

                    }else{
                        FinalResultsHandler.finalResults.add(fr);
                    }


                    startActivity(i);
                }



            }
        });

    }

    public String removeLastChar(String s) {
        return (s == null) ? null : s.replaceAll(".$", "");
    }
}
