package why.task;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MyActivity extends Activity {
    private Button[] btnNum = new Button[11];// 数值按钮
    private Button[] btnCommand = new Button[6];// 符号按钮
    public EditText editText = null;// 显示区域
    private Button btnC = null; // C按钮
    private Button btnCE = null; // CE按钮
    private Button btnBS = null; //BackSpace按钮
    private Button btnZheng = null; // 正号按钮
    private Button btnFu = null; // 负号按钮
    private String lastCommand; // 用于保存运算符
    private String resultString ;
    private String M;
    private double cache;

    private boolean clearFlag; // 用于判断是否清空显示区域的值,true需要,false不需要
    private boolean firstFlag; // 用于判断是否是首次输入,true首次,false不是首次
    private boolean resultFlag;// 用于判断输出是否为结果,true是,false否
    private boolean ceFlag = false ;
    private double result; // 计算结果


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

        public MyActivity() {
            // 初始化各项值
            result = 0; // x的值
            firstFlag = true; // 是首次运算
            clearFlag = false; // 不需要清空
            lastCommand = "="; // 运算符
            resultFlag = false;
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);
            // 获取运算符
            btnCommand[0] = (Button) findViewById(R.id.add);
            btnCommand[1] = (Button) findViewById(R.id.subtract);
            btnCommand[2] = (Button) findViewById(R.id.multiply);
            btnCommand[3] = (Button) findViewById(R.id.divide);
            btnCommand[4] = (Button) findViewById(R.id.equal);
            btnCommand[5] = (Button) findViewById(R.id.Sqrt);


            // 获取数字
            btnNum[0] = (Button) findViewById(R.id.num0);
            btnNum[1] = (Button) findViewById(R.id.num1);
            btnNum[2] = (Button) findViewById(R.id.num2);
            btnNum[3] = (Button) findViewById(R.id.num3);
            btnNum[4] = (Button) findViewById(R.id.num4);
            btnNum[5] = (Button) findViewById(R.id.num5);
            btnNum[6] = (Button) findViewById(R.id.num6);
            btnNum[7] = (Button) findViewById(R.id.num7);
            btnNum[8] = (Button) findViewById(R.id.num8);
            btnNum[9] = (Button) findViewById(R.id.num9);
            btnNum[10] = (Button) findViewById(R.id.point);
            // 初始化显示结果区域
            editText = (EditText) findViewById(R.id.result);
            editText.setText("0.0");
            // 实例化监听器对象
            NumberAction na = new NumberAction();
            CommandAction ca = new CommandAction();

            for (Button bc : btnCommand) {
                bc.setOnClickListener(ca);
            }
            for (Button bc : btnNum) {
                bc.setOnClickListener(na);
            }
            // C按钮的动作
            btnC = (Button) findViewById(R.id.C);
            btnC.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText.setText("0.0");
                    // 初始化各项值
                    result = 0; // x的值
                    firstFlag = true; // 是首次运算
                    clearFlag = false; // 不需要清空
                    lastCommand = "="; // 运算符
                    resultFlag = false ;
                    ceFlag=false;
                }
            });
            // CE按钮的动作
            btnCE = (Button) findViewById(R.id.CE);
            btnCE.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText.setText("");
                    firstFlag = false;
                    clearFlag = false;
                    resultFlag = false;
                    ceFlag=true;
                }
            });
            // 正号按钮的动作
            btnZheng = (Button) findViewById(R.id.Zheng);
            btnZheng.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    cache=Double.parseDouble(editText.getText().toString());
                    cache =Math.abs(cache);
                    editText.setText("" +cache);
                }
            });
            // 负号按钮的动作
            btnFu = (Button) findViewById(R.id.Fu);
            btnFu.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    cache=Double.parseDouble(editText.getText().toString());
                    cache =0-cache;
                    editText.setText("" +cache);
                }
            });
            /* Backspace按钮的动作 */
            btnBS = (Button) findViewById(R.id.BS);
            btnBS.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                if(resultFlag == true){
                return;
                }
                else{resultString = editText.getText().toString();
                    if(resultString.length()>1&&(firstFlag!=true)){
                     resultString = resultString.substring( 0, ( resultString.length()-1 ) );
                     M = resultString;
                     editText.setText(M);}
                    else if((resultString.length()<1)||(firstFlag = true)){
                        editText.setText("0.0");
                        return;
                    }
                }
                }
            });
        }
        // 数字按钮监听器
        private class NumberAction implements OnClickListener {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                String input = btn.getText().toString();
                if (firstFlag) { // 首次输入
                    // 一上就".",就什么也不做
                    if (input.equals(".")) {
                        return;
                    }
                    // 如果是"0.0"的话,就清空
                    if (editText.getText().toString().equals("0.0")) {
                        editText.setText("");
                    }
                    firstFlag = false;// 改变是否首次输入的标记值
                } else {
                    String editTextStr = editText.getText().toString();
                    // 判断显示区域的值里面是否已经有".",如果有,输入的又是".",就什么都不做
                    if (editTextStr.indexOf(".") != -1 && input.equals(".")) {
                        return;
                    }
                    // 判断显示区域的值里面只有"-",输入的又是".",就什么都不做
                    if (editTextStr.equals("-") && input.equals(".")) {
                        return;
                    }
                    // 判断显示区域的值如果是"0",输入的不是".",就什么也不做
                    if (editTextStr.equals("0") && !input.equals(".")) {
                        return;
                    }
                }
                // 如果我点击了运算符以后,再输入数字的话,就要清空显示区域的值
                if (clearFlag) {
                    editText.setText("");
                    clearFlag = false;// 还原初始值,不需要清空

                }
                editText.setText(editText.getText().toString() + input);// 设置显示区域的值
                ceFlag=false;
            }
        }
        // 符号按钮监听器
        private class CommandAction implements OnClickListener {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                String inputCommand = (String) btn.getText();
                if (firstFlag) {
                    // 首次输入运算符的情况
                    if ((inputCommand.equals("+"))||(inputCommand.equals("*"))||(inputCommand.equals("/"))||inputCommand.equals("-"))
                    {
                        firstFlag = true;
                        return;
                    }
                } else {
                    if (!clearFlag&&(ceFlag==false)) {// 如果flag=false不需要清空显示区的值,就调用方法计算
                        cache=Double.parseDouble(editText.getText().toString());
                        calculate(Double.parseDouble(editText.getText().toString()));// 保存显示区域的值,并计算
                    }
                    else if (!clearFlag&&(ceFlag==true)){
                       lastCommand=inputCommand;
                        return;
                    }
                    // 保存点击的运算符
                    lastCommand = inputCommand;
                    clearFlag = true;// 因为我这里已经输入过运算符,
                }
            }
        }
        // 计算用的方法
        private void calculate(double x) {

            if (lastCommand.equals("+")) {
                result =Arith.add(result,x);resultFlag = true;
            } else if (lastCommand.equals("-")) {
                result =Arith.sub(result, x);resultFlag = true;
            } else if (lastCommand.equals("*")) {
                result=Arith.mul(result,x);resultFlag = true;
            } else if (lastCommand.equals("/")) {
                if (x!=0) {
                    result = Arith.div(result, x);
                    resultFlag = true;
                }
                else return;
            } else if (lastCommand.equals("=")) {
                result = Arith.round(result,10);resultFlag = true;
            } else if (lastCommand.equals(("√"))) {
                if (x >= 0 ){
                    result = Math.sqrt(x);
                    result=Arith.round(result,10);
                    resultFlag = true;}
                else {editText.setText("Wrong!"); return;}
            }

            editText.setText("" + result);
        }
    }
