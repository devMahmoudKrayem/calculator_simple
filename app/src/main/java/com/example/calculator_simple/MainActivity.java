package com.example.calculator_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
    TextView result,history;
    String opr="=";
    double number=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num0=findViewById(R.id.bt_zero);
        num1=findViewById(R.id.bt_one);
        num2=findViewById(R.id.bt_tow);
        num3=findViewById(R.id.bt_three);
        num4=findViewById(R.id.bt_four);
        num5=findViewById(R.id.bt_five);
        num6=findViewById(R.id.bt_six);
        num7=findViewById(R.id.bt_seven);
        num8=findViewById(R.id.bt_eight);
        num9=findViewById(R.id.bt_nine);
        result=findViewById(R.id.tv_total);
        history=findViewById(R.id.tv_history);
        ImageButton sum=findViewById(R.id.btim_add);
        ImageButton divide=findViewById(R.id.btim_divide);
        ImageButton multiply=findViewById(R.id.btim_multiply);
        ImageButton minus=findViewById(R.id.btim_minus);
        ImageButton equal=findViewById(R.id.btim_equal);
        ImageButton remove_one=findViewById(R.id.btim_remove);
        Button clear=findViewById(R.id.bt_clear);
        remove_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=result.getText().toString();
                temp=temp.substring(0,temp.length()-1);
                result.setText(temp);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=0;
                result.setText("");
                history.setText("");
                opr="=";
            }
        });
        //button number
        {
            num0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "0");
                }
            });
            num1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "1");
                }
            });
            num2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "2");
                }
            });
            num3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "3");
                }
            });
            num4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "4");
                }
            });
            num5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "5");
                }
            });
            num6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "6");
                }
            });
            num7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "7");
                }
            });
            num8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "8");
                }
            });
            num9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result.setText(result.getText().toString() + "9");
                }
            });
        }
        //button operation
        {
            sum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.do_operation("+");

                }
            });
            divide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.do_operation("/");

                }
            });
            multiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.do_operation("*");
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.do_operation("-");
                }
            });
            equal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.do_operation("=");
                }
            });
        }


    }

    public void do_operation(String new_oper)
    {
        if (!result.getText().toString().isEmpty()){

            if (opr=="=")
            {
                history.setText("");

            }
            String temp=history.getText().toString()+result.getText().toString()+new_oper;
            history.setText(temp);


            switch (opr){
                case "=":
                    number=Double.parseDouble(result.getText().toString());
                    break;
                case "+":
                    number+=Double.parseDouble(result.getText().toString());
                    break;
                case "-":
                    number-=Double.parseDouble(result.getText().toString());
                    break;
                case "*":
                    number*=Double.parseDouble(result.getText().toString());
                    break;
                case "/":
                    number/=Double.parseDouble(result.getText().toString());
                    break;

            }
            opr=new_oper;
            result.setHint(number+"");
            result.setText("");

        }
    }

}

