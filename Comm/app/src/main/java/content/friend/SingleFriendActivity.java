package content.friend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cjlu.R;

import tenghao.tenghao.LoginActivity;
import tenghao.tenghao.MainActivity;
import tenghao.tool.MyHandlerTool;

public class SingleFriendActivity extends Activity {
	public static String result = "";
	TextView tv_name = null;
	TextView tv_phone = null;
	static Button btn_care = null;
	 public static Handler hander = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback(){
		 @Override
		 public boolean handleMessage(Message msg) {
			 if (msg.what == 1) {
				 if (!"0".equals(result)) {
					 btn_care.setBackgroundResource(R.drawable.already_care);
					 btn_care.setEnabled(false);
				 }
			 }
			 return true;
		 }
	 });
	  public void onCreate(Bundle savedInstanceState) { 
    	  super.onCreate(savedInstanceState);
    	  requestWindowFeature(Window.FEATURE_NO_TITLE);
    	  getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , 
    	  WindowManager.LayoutParams. FLAG_FULLSCREEN);
          setContentView(R.layout.activity_single_friend); 
          tv_name = findViewById(R.id.single_friend_name);
          tv_phone = findViewById(R.id.single_friend_phone);
          btn_care = findViewById(R.id.care_btn);
          String temp_name = FriendActivity.friendList.get(FriendActivity.selected_position).my_nickname;
          String temp_phone = FriendActivity.friendList.get(FriendActivity.selected_position).my_phone;
          String care_temp_myid = MainActivity.myonlyid;
		  String care_temp_backid = FriendActivity.friendList.get(FriendActivity.selected_position).my_id;
          tv_name.setText("他的昵称:" + temp_name);
          tv_phone.setText("他的电话:" + temp_phone);
          result = "";
          IsCareJudge iCG = new IsCareJudge(care_temp_myid,care_temp_backid);
          iCG.start();

          
	  }
	  public View Care(View v){
		  String temp_myid = MainActivity.myonlyid;
		  String temp_backid = FriendActivity.friendList.get(FriendActivity.selected_position).my_id;
		  SendCareThread sCT = new SendCareThread(temp_myid,temp_backid);
		  sCT.start();
		  Toast.makeText(this, "关注成功", Toast.LENGTH_SHORT).show();
		  Intent intent = new Intent(SingleFriendActivity.this, LoginActivity.class);
		  startActivity(intent);
		  return v;
	  }
	
	
}
