package com.example.mini_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_plus, btn_minus, btn_mult, btn_div, btn_clear, btn_del, btn_point, btn_equals;
    TextView screen;

    String mainCalcString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connecting with the elements
        screen = findViewById(R.id.screen);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_mult = findViewById(R.id.btn_mult);
        btn_div = findViewById(R.id.btn_div);
        btn_clear = findViewById(R.id.btn_clear);
        btn_del = findViewById(R.id.btn_del);
        btn_point = findViewById(R.id.btn_point);
        btn_equals = findViewById(R.id.btn_equals);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(1);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arithmeticOperatorPressed(" + ");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arithmeticOperatorPressed(" - ");
            }
        });
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arithmeticOperatorPressed(" * ");
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arithmeticOperatorPressed(" / ");
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pointPressed();
            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delPressed();
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearPressed();
            }
        });
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalsPressed();
            }
        });

    }

    public void setText(String txt) {
        screen.setText(String.valueOf(txt));
    }

    public void numberPressed(int n) {
        mainCalcString += String.valueOf(n);
        setText(mainCalcString);
    }

    public void clearPressed() {
        mainCalcString = "";
        setText(mainCalcString);
    }

    public void delPressed() {
        if(mainCalcString.length()>0) {
            if(mainCalcString.charAt(mainCalcString.length()-1) != ' ') {
                // remove the last char when not space at the last pos
                mainCalcString = mainCalcString.substring(0, mainCalcString.length() - 1);
            } else {
                // remove the 3 last chars ( " + " ) when space at the last pos
                if(mainCalcString.length()>=3) {
                    mainCalcString = mainCalcString.substring(0, mainCalcString.length() - 3);
                }
            }
            screen.setText(String.valueOf(mainCalcString));
        }
    }

    public void arithmeticOperatorPressed(String sign) {
        mainCalcString += sign;
        screen.setText(String.valueOf(mainCalcString));
    }

    public void pointPressed() {
        if(mainCalcString.length()>0) {
            if(mainCalcString.charAt(mainCalcString.length()-1) != '.') {
                mainCalcString+=".";
            }
        }
        screen.setText(String.valueOf(mainCalcString));
    }

    public void equalsPressed() {

        String n1 = "",n2 = "";
        char op = ' ';
        int spaceCount = 0;
        String s = mainCalcString;


        for(int i=0; i<s.length(); i++) {
            if(spaceCount == 0) {
                if(s.charAt(i) != ' ') {
                    n1 = n1 + s.charAt(i);
                } else {
                    spaceCount++;
                }
            } else if(spaceCount == 1) {
                if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                    op = s.charAt(i);
                } else {
                    spaceCount++;
                }
            } else {
                n2 = n2 + s.charAt(i);
            }
        }

        double num1, num2;

        try {
            num1 = Double.valueOf(n1);
            num2 = Double.valueOf(n2);
        } catch (Exception e) {
            screen.setText(String.valueOf("Syntax Err"));
            return;
        }

        double res = 0.0;
        boolean resOk = true;

        if(op == '+') {
            res = num1 + num2;
        } else if(op == '-') {
            res = num1 - num2;
        } else if(op == '*') {
            res = num1 * num2;
        } else if(op == '/') {
            res = num1 / num2;
        } else {
            res = 0.0;
            resOk = false;
        }

        if(resOk) {
            mainCalcString = String.valueOf(res);
        } else {
            mainCalcString = "Syntax Err";
        }

        screen.setText(String.valueOf(mainCalcString));
    }
}