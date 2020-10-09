package tenghao.tenghao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tenghao.tool.MyHandlerTool;
import tenghao.tool.Tool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cjlu.R;

public class GetIdActivity extends Activity {
    public static String myid = "";
    public static TextView tv_id = null;
    public static Handler hander = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Log.e(MainActivity.TAG,"您的工号/学号为:" + myid);
            if (msg.what == 3) {
                Log.e(MainActivity.TAG,"您的工号/学号为:" + myid);
                if (!"".equals(myid)) {
                    Log.e(MainActivity.TAG,"您的工号/学号为:" + myid);
                    tv_id.setText("您的工号/学号为:" + myid);
                }
            }
            return true;
        }
    });


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_getid);
        tv_id = (TextView) findViewById(R.id.getid_tv);
        RefreshCircle rC = new RefreshCircle();
        rC.start();
    }

    public static class RefreshCircle extends Thread {
        Socket s;

        public void run() {
            try {
                s = new Socket(Tool.publicIp, Tool.publicCut);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout.writeUTF("get_id");
                myid = din.readUTF();

                hander.sendEmptyMessage(3);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public View FirstLogon(View v) {
        Intent intent = new Intent(GetIdActivity.this, MainActivity.class);
        startActivity(intent);
        return v;

    }






}
