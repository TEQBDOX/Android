package com.example.my.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.my.utils.Calculate;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //变量定义
//    private EditText editText;          //输入框：用于输入数字
//    private TextView textView;          //文本框：显示计算过程和计算结果
    private EditText textView;          //输入框：用于输入数字
    private TextView editText;          //文本框：显示计算过程和计算结果
    private String operator;            //操作符：记录 + - * / 符号
    private double n1 , n2 ,Result;     //操作数：操作符两端的数字，n1为左操作数，n2为右操作数。

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;   //按钮：十个数字
    private Button btnPlus,btnMinus,btnMultiply,btnDivide;              //按钮：加减乘除
    private Button btnPoint,btnEqual,btnClear,btnCancel,btnLeft,btnRight;                          //按钮：小数点，等号，清空

    private View.OnClickListener lisenter = new View.OnClickListener() {//侦听器
        @Override
        public void onClick(View view) {//点击事件
//            editText = (EditText)findViewById(R.id.editviewdavid);//与XML中定义好的EditText控件绑定
//            textView = (TextView)findViewById(R.id.textviewdavid);//与XML中定义好的TextView控件绑定
            textView = (EditText)findViewById(R.id.editviewdavid);//与XML中定义好的EditText控件绑定
            editText = (TextView)findViewById(R.id.textviewdavid);//与XML中定义好的TextView控件绑定

//            editText.setCursorVisible(false);//隐藏输入框光标
            textView.setCursorVisible(false);//隐藏输入框光标
            String str;
            Button button = (Button)view;   //把点击获得的id信息传递给button
            DecimalFormat MyFormat = new DecimalFormat("###.##");//控制Double转为String的格式

            try{
                switch(button.getId())//获取点击按钮的ID，通过ID选择对应的选项执行
                {
                    case R.id.button1://如果点击了按钮：“1”
                    {
                        editText.setText(editText.getText().toString() + 1);//输入框末尾，添加一个“1”
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button2://2
                    {
                        editText.setText(editText.getText().toString() + 2);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button3://3
                    {
                        editText.setText(editText.getText().toString() + 3);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button4://4
                    {
                        editText.setText(editText.getText().toString() + + 4);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button5://5
                    {
                        editText.setText(editText.getText().toString() + 5);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button6://6
                    {
                        editText.setText(editText.getText().toString() +  6);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button7://7
                    {
                        editText.setText(editText.getText().toString() +  7);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button8://8
                    {
                        editText.setText(editText.getText().toString() +   8);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button9://9
                    {
                        editText.setText(editText.getText().toString() +  9);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.button0://0
                    {
                        editText.setText(editText.getText().toString() +  0);
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    case R.id.buttonClear://清楚C
                    {
                        editText.setText("");
                        textView.setText("");
                        Result = 0;
                        break;
                    }
                    case R.id.buttonCancel://回退←
                    {
                        str = editText.getText().toString();
                        if(str.length()>0){
                            str=str.substring(0,str.length()-1);
                            editText.setText(str);
                            if(Character.isDigit(str.charAt(str.length()-1))){
                                Result=Calculate.getResult(editText.getText().toString());
                                textView.setText(MyFormat.format(Result)+"");
                            }
                        }
                        break;
                    }

                    case R.id.buttonLeft://(
                    {
                        str = editText.getText().toString();
                        if(str==null||str.length()==0){
                            editText.setText("(");
                        }else if(str.length()>0 && !Character.isDigit(str.charAt(str.length()-1))&& !('.'==str.charAt(str.length()-1))){
                            editText.setText(str+"(");
                        }
                        break;
                    }
                    case R.id.buttonRight:// )
                    {
                        str = editText.getText().toString();
                        if(str.length()>0){
                            if(Character.isDigit(str.charAt(str.length()-1))||')'==str.charAt(str.length()-1))
                                editText.setText(str+")");
                        }
                        break;
                    }

                    case R.id.buttonPoint://小数点.
                    {
                        str = editText.getText().toString();
                        if(str.length()>0&&Character.isDigit(str.charAt(str.length()-1))){
                            editText.setText(str+".");
                        }
                        break;
                    }
                    case R.id.buttonPlus://操作符+
                    {
                        str = editText.getText().toString();
                        if(str.length()>0){
                            if(Character.isDigit(str.charAt(str.length()-1))||')'==str.charAt(str.length()-1)){
                                editText.setText(str+"+");
                            }
                        }
                        break;
                    }
                    case R.id.buttonMinus://操作符-
                    {
                        str = editText.getText().toString();
                        if(str.length()>0){
                            if(Character.isDigit(str.charAt(str.length()-1))||')'==str.charAt(str.length()-1)){
                                editText.setText(str+"-");
                            }
                        }
                        break;
                    }
                    case R.id.buttonMultiply://操作符*
                    {
                        str = editText.getText().toString();
                        if(str.length()>0){
                            if(Character.isDigit(str.charAt(str.length()-1))||')'==str.charAt(str.length()-1)) {
                                editText.setText(str + "*");
                            }
                        }
                        break;
                    }

                    case R.id.buttonDivide://操作符 /
                    {
                        str = editText.getText().toString();
                        if(str.length()>0){
                            if(Character.isDigit(str.charAt(str.length()-1))||')'==str.charAt(str.length()-1)) {
                                editText.setText(str + "/");
                            }
                        }
                        break;
                    }
                    case R.id.buttonEqual://操作符=
                    {
                        Result=Calculate.getResult(editText.getText().toString());
                        textView.setText("");
                        editText.setText(MyFormat.format(Result)+"");
                        break;
                    }
                    default:
                        break;
                }
            }catch(Exception e){}
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取按钮的id
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn0 = (Button) findViewById(R.id.button0);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        btnPoint = (Button) findViewById(R.id.buttonPoint);
        btnEqual = (Button) findViewById(R.id.buttonEqual);
        btnClear = (Button) findViewById(R.id.buttonClear);
        btnCancel = (Button) findViewById(R.id.buttonCancel);
        btnLeft = (Button) findViewById(R.id.buttonLeft);
        btnRight = (Button) findViewById(R.id.buttonRight);
        //为按钮添加监听器
        btn1.setOnClickListener(lisenter);
        btn2.setOnClickListener(lisenter);
        btn3.setOnClickListener(lisenter);
        btn4.setOnClickListener(lisenter);
        btn5.setOnClickListener(lisenter);
        btn6.setOnClickListener(lisenter);
        btn7.setOnClickListener(lisenter);
        btn8.setOnClickListener(lisenter);
        btn9.setOnClickListener(lisenter);
        btn0.setOnClickListener(lisenter);
        btnPlus.setOnClickListener(lisenter);
        btnMinus.setOnClickListener(lisenter);
        btnMultiply.setOnClickListener(lisenter);
        btnDivide.setOnClickListener(lisenter);
        btnPoint.setOnClickListener(lisenter);
        btnEqual.setOnClickListener(lisenter);
        btnClear.setOnClickListener(lisenter);
        btnCancel.setOnClickListener(lisenter);
        btnLeft.setOnClickListener(lisenter);
        btnRight.setOnClickListener(lisenter);
    }
}
