package comgreedyai.github.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    private double currentValue = 0;
    private DecimalFormat decimalFormat1;
    private DecimalFormat decimalFormat2;
    private boolean dotPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat1 = new DecimalFormat("#.##########");
        final TextView expression = (TextView) findViewById(R.id.expression);
        final TextView result = (TextView) findViewById(R.id.result);
        Button num_0 = (Button) findViewById(R.id.num_0);
        Button num_1 = (Button) findViewById(R.id.num_1);
        Button num_2 = (Button) findViewById(R.id.num_2);
        Button num_3 = (Button) findViewById(R.id.num_3);
        Button num_4 = (Button) findViewById(R.id.num_4);
        Button num_5 = (Button) findViewById(R.id.num_5);
        Button num_6 = (Button) findViewById(R.id.num_6);
        Button num_7 = (Button) findViewById(R.id.num_7);
        Button num_8 = (Button) findViewById(R.id.num_8);
        Button num_9 = (Button) findViewById(R.id.num_9);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button dot = (Button) findViewById(R.id.dot);
        Button equals = (Button) findViewById(R.id.equals);
        Button ce = (Button) findViewById(R.id.ce);

        num_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "0");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "1");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "2");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "3");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "4");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "5");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "6");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "7");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "8");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        num_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText() + "9");
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expression.length() >= 1) {
                    if((expression.getText().charAt(expression.length() - 1)) != '+' && (expression.getText().charAt(expression.length() - 1)) != '-' && (expression.getText().charAt(expression.length() - 1)) != '.') {
                        calculate(expression, result);
                        expression.setText(expression.getText() + "+");
                        dotPressed = false;
                        result.setText(decimalFormat1.format(currentValue));
                    }
                } else {
                    expression.setText(expression.getText() + "+");
                    dotPressed = false;
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expression.length() >= 1) {
                    if((expression.getText().charAt(expression.length() - 1)) != '+' && (expression.getText().charAt(expression.length() - 1)) != '-' && (expression.getText().charAt(expression.length() - 1)) != '.') {
                        calculate(expression, result);
                        expression.setText(expression.getText() + "-");
                        dotPressed = false;
                        result.setText(decimalFormat1.format(currentValue));
                    }
                } else {
                    expression.setText(expression.getText() + "-");
                    dotPressed = false;
                }
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expression.length() >= 1) {
                    if((expression.getText().charAt(expression.length() - 1)) != '+' && (expression.getText().charAt(expression.length() - 1)) != '-') {
                        if(dotPressed == false && expression.getText().length() != 0) {
                            calculate(expression, result);
                            expression.setText(expression.getText() + ".");
                            dotPressed = true;
                            result.setText(decimalFormat1.format(currentValue));
                        }
                    }
                } else {
                    expression.setText(expression.getText() + "0.");
                    dotPressed = true;
                    }
            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotPressed = false;
                result.setText("0");
                expression.setText("0");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(result.getText());
                calculate(expression, result);
                result.setText(decimalFormat1.format(currentValue));
                expression.setText(decimalFormat1.format(currentValue));
            }
        });

    }

    private void calculate(TextView expression, TextView result) {
        double finalResult = 0;
        String []splitPlus = expression.getText().toString().split("\\+");
        int startIndex;
        if (splitPlus[0].equals("")) {
            for (startIndex = 1; startIndex < splitPlus.length; startIndex++) {
                String[]splitMinus = splitPlus[startIndex].split("\\-");
                if(splitMinus[0].equals("") && splitMinus.length >= 2) {
                    double minusResult = 0;
                    for (int i = 1; i < splitMinus.length ; i++) {
                        minusResult -= Double.parseDouble(splitMinus[i]);
                    }
                    finalResult += minusResult;
                } else {
                    double minusResult = Double.parseDouble(splitMinus[0]);
                    for (int i = 1; i < splitMinus.length ; i++) {
                        minusResult -= Double.parseDouble(splitMinus[i]);
                    }
                    finalResult += minusResult;
                }
            }
        } else {
            for (startIndex = 0; startIndex < splitPlus.length; startIndex++) {
                String[]splitMinus = splitPlus[startIndex].split("\\-");
                if(splitMinus[0].equals("") && splitMinus.length >= 2) {
                    double minusResult = 0;
                    for (int i = 1; i < splitMinus.length ; i++) {
                        minusResult -= Double.parseDouble(splitMinus[i]);
                    }
                    finalResult += minusResult;
                } else {
                    double minusResult = Double.parseDouble(splitMinus[0]);
                    for (int i = 1; i < splitMinus.length ; i++) {
                        minusResult -= Double.parseDouble(splitMinus[i]);
                    }
                    finalResult += minusResult;
                }
            }
        }
            currentValue = finalResult;
    }
}
