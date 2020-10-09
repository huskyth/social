package tenghao.tab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cjlu.R;

import content.friend.FriendActivity;
import content.write.WriteBackActivity;
import content.write.WriteCircleActivity;
import function.chat.ChatActivity;
import tenghao.tenghao.LoginActivity;
import tenghao.tenghao.MainActivity;
import tenghao.tool.MyHandlerTool;

public class PersonActivity extends Activity {

    public static String cared_num = "";
    public static String care_num = "";
    TextView tv_name = null;
    public static TextView tv_care = null;
    public static TextView tv_cared = null;
    public static Handler handler = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if (msg.what == 2) {
                tv_care.setText(care_num);
                tv_cared.setText(cared_num);
            }
            return true;
        }
    });

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.person_layout);
        tv_name = findViewById(R.id.tv_tempname);
        tv_care = findViewById(R.id.tv_care_num);
        tv_cared = findViewById(R.id.tv_iscared_num);

        tv_name.setText(LoginActivity.myonly_nickname);

        GetCareThread gCTH = new GetCareThread();
        gCTH.start();


    }

    public View myFriend(View v) {
        Toast.makeText(this, "在线好友", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PersonActivity.this, FriendActivity.class);
        startActivity(intent);
        return v;
    }

    public View writeCircle(View v) {
        Intent intent = new Intent(PersonActivity.this, WriteCircleActivity.class);
        startActivity(intent);
        return v;
    }

    public View QuitLogin(View v) {
        SharedPreferences settings = getSharedPreferences("setting", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("isAuto", "false");
        editor.putString("name", "null");
        editor.putString("psw", "");
        MainActivity.myonlyid = "";
        editor.commit();
        Toast.makeText(this, "退出成功", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(PersonActivity.this, MainActivity.class);
        startActivity(intent);
        return v;
    }

    public View myGroupChat(View v) {
        Intent intent = new Intent(PersonActivity.this, ChatActivity.class);
        startActivity(intent);
        return v;
    }

    public View EnterBack(View v) {
        Intent intent = new Intent(PersonActivity.this, WriteBackActivity.class);
        startActivity(intent);
        return v;
    }
}  

