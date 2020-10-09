package tenghao.tenghao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tenghao.tool.MyHandlerTool;
import tenghao.tool.Tool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cjlu.R;

public class RegisterActivity extends Activity {
    Socket s = null;
    DataOutputStream dout;
    DataInputStream din;
    EditText et_phone = null;
    EditText et_pass = null;
    EditText et_ensure_pass = null;
    EditText et_nickname = null;
    Handler myHandler;
    public static final int REGISTER = 0;
    static final int TOGETIDACTIVITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pass = (EditText) findViewById(R.id.et_pasw);
        et_ensure_pass = (EditText) findViewById(R.id.et_ensure_psw);
        et_nickname = (EditText) findViewById(R.id.et_nickname);
        myHandler = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == TOGETIDACTIVITY) {
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    public View submit(View v) {
        if (!Tool.isNumeric(et_phone.getText().toString())) {
            Toast.makeText(this, "手机号必须为数字", Toast.LENGTH_SHORT).show();
        } else if (et_phone.getText().toString().length() != 11) {
            Toast.makeText(this, "手机号必须为11位", Toast.LENGTH_SHORT).show();
        } else if (!et_pass.getText().toString().equals(et_ensure_pass.getText().toString())) {
            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
        } else if ("".equals(et_phone.getText().toString()) ||
                "".equals(et_pass.getText().toString()) ||
                "".equals(et_nickname.getText().toString())) {
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        } else {

            String myphone = et_phone.getText().toString();
            String psw = et_pass.getText().toString();
            String nickname = et_nickname.getText().toString();
            new Thread() {
                public void run() {
                    boolean canIntent = false;
                    try {
                        s = new Socket(Tool.publicIp, Tool.publicCut);
                    } catch (UnknownHostException e) {
                        Log.e(MainActivity.TAG, "UnknownHostException");
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        dout = new DataOutputStream(s.getOutputStream());
                        din = new DataInputStream(s.getInputStream());
                        dout.writeUTF("register");
                        dout.writeUTF(et_phone.getText().toString());
                        dout.writeUTF(et_pass.getText().toString());
                        dout.writeUTF(et_nickname.getText().toString());

                        myHandler.sendEmptyMessage(TOGETIDACTIVITY);
                        Intent intent = new Intent(RegisterActivity.this, GetIdActivity.class);
                        startActivity(intent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (s != null) {
                                s.close();
                            }
                            if (dout != null) {
                                dout.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }.start();


            if (!psw.contains("#") && !nickname.contains("#")) {
            } else {
                Toast.makeText(this, "注册失败:含有特殊字符", Toast.LENGTH_SHORT).show();
            }
        }
        return v;
    }
}
