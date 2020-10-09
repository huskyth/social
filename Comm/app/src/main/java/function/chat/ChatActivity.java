package function.chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


import com.example.cjlu.R;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import function.connectServer.SendChatContentThread;
import tenghao.tenghao.LoginActivity;

public class ChatActivity extends Activity {
    private static ArrayList<MyMessage> msgList;
    private static Adapter mAdapter;  
    EditText chatEditView;  
    static ListView chatListView;
    Button btn_send;
    DataOutputStream dout;
	DataInputStream din;
	public static String content;
	boolean flag = true;
    Socket s,s_recv;
    public static Handler hander = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
            case 4:
            	mAdapter.notifyDataSetChanged();
            
                break;
            default:
                break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);  
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , 
	    WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat);  
        chatListView = (ListView) findViewById(R.id.listview);   
        chatEditView = (EditText)findViewById(R.id.et_content);  
        btn_send = (Button)findViewById(R.id.btn_send);
        msgList = new ArrayList<MyMessage>();
        //initMessage();
        mAdapter = new Adapter(msgList,ChatActivity.this);  
        chatListView.setAdapter(mAdapter);
        			GetChatContent gCT = new GetChatContent(msgList);
        			gCT.start();
        
        
        
        
    }
    public void send(View v){  
        content = chatEditView.getText().toString(); 
        if(!"".equals(content)){
        	  SendChatContentThread sCCTh = new SendChatContentThread(content);
              sCCTh.start();
              
		        	MyMessage message = new MyMessage(1, LoginActivity.myonly_nickname,content);
		        	msgList.add(message);
		        	mAdapter.notifyDataSetChanged();  
		        	chatListView.setSelection(msgList.size());
		        	chatEditView.setText("");
        }
    }  
    public static void initMessage(){
    	MyMessage message1 = new MyMessage(0,"???","????л??:");
        msgList.add(message1);
    	MyMessage message2 = new MyMessage(0,"???","????????????!");  
        msgList.add(message2);
        MyMessage message3 = new MyMessage(0,"???","????????????!");  
        msgList.add(message3);  
        MyMessage message4 = new MyMessage(0,"???","??????????!");  
        msgList.add(message4);  
        MyMessage message5 = new MyMessage(0,"???","????????!");  //0:left
        msgList.add(message5);
    }  
    public void GetMyNickname(){
    	
    }
}
