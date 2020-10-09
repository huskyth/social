package tenghao.tenghao;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cjlu.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tenghao.tool.MyHandlerTool;
import tenghao.tool.Permition;
import tenghao.tool.Tool;

public class MainActivity extends Activity {
    public static final String TAG = "husky";
    private static final int OK = 0;
    private static final int ERR = 1;
    private static final int OTHER = 2;
    public static String myonlyid = "";
    EditText et_name = null;
    EditText et_psw = null;
    String login_result = "";
    public static final int LOGIN = 1;
    public static String temp_psw = "";
    public static String temp_name = "";
    Socket s = null;
    DataOutputStream dout;
    DataInputStream din;
    boolean flag;
    Handler mH;
    public RadioGroup mRadioGroup;
    public RadioButton mRadioBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Permition.isGrantExternalRW(this,1);
        mH = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case OK:
                        break;
                    case ERR:
                        Toast.makeText(getApplicationContext(),"用户名密码错误",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_psw = (EditText) findViewById(R.id.et_password);
        mRadioGroup = (RadioGroup) findViewById(R.id.auto_login_group);
        mRadioBtn = (RadioButton) findViewById(R.id.auto_login);
        mRadioGroup.setOnCheckedChangeListener(radiogpchange);

        SharedPreferences settings = getSharedPreferences("setting", 0);
        String name = settings.getString("name", "null");
        String isAuto = settings.getString("isAuto", "null");
        if ("true".equals(isAuto) && !"null".equals(name)) {
            myonlyid = name;
            Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
//            startActivity(new Intent(this, MainActivity.class));
//            return false;
//        }else {
//            return super.onKeyDown(keyCode, event);
//        }
//    }


    public View login(View v) {

        temp_name = et_name.getText().toString();
        temp_psw = et_psw.getText().toString();

        flag = true;
        if ("".equals(temp_name) || "".equals(temp_psw) || !Tool.isNumeric(temp_name)) {
            Toast.makeText(this, "用户名或者密码为空", Toast.LENGTH_LONG).show();

        } else {
            new Thread() {
                public void run() {
                    try {
                        s = new Socket(Tool.publicIp, Tool.publicCut);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        dout = new DataOutputStream(s.getOutputStream());
                        din = new DataInputStream(s.getInputStream());
                        dout.writeUTF("login");
                        if (temp_psw != null && !"".equals(temp_psw) &&
                                temp_name != null && !"".equals(temp_name)) {
                            dout.writeUTF(temp_name);
                            dout.writeUTF(temp_psw);
                        } else {
                            flag = false;
                        }
                        login_result = din.readUTF();

                        if ("loginOk".equals(login_result)) {
                            myonlyid = temp_name;
                            SaveInfo(temp_name, temp_psw);
                            mH.sendEmptyMessage(OK);
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else if ("loginErr".equals(login_result)) {
                            mH.sendEmptyMessage(ERR);
                        }

                        if (dout != null) {
                            dout.close();
                        }
                        if (s != null) {
                            s.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }.start();
        }

        return v;
    }

    private void SaveInfo(String temp_name, String temp_psw) {
        SharedPreferences settings = getSharedPreferences("setting", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name", temp_name);
        editor.putString("psw", temp_psw);
        editor.commit();
    }

    public View register(View v) {
        Toast.makeText(this, "去注册了", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);

        return v;
    }

    public RadioGroup.OnCheckedChangeListener radiogpchange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == mRadioBtn.getId()) {
                Toast.makeText(getApplicationContext(), "设置成功", Toast.LENGTH_SHORT).show();
                SharedPreferences settings = getSharedPreferences("setting", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("isAuto", "true");
                editor.commit();
            }


        }
    };


}
