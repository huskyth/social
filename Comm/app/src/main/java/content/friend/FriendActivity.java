package content.friend;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cjlu.R;

import java.util.ArrayList;

import tenghao.tool.MyHandlerTool;


public class FriendActivity extends Activity {
    public static int selected_position;
    Button btn_care = null;
    public static ArrayList<myFriendContent> friendList;
    private static FriendAdapter mFriendAdapter;
    ListView friendListView;
    TextView tv_temp_nickname = null;
    public static Handler hander = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 0) {
                mFriendAdapter.notifyDataSetChanged();
                //list.setAdapter(smAdapter);
            }
            return true;
        }
    }
    );

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_listview_friend);
        friendListView = (ListView) findViewById(R.id.friend_listview);
        friendList = new ArrayList<myFriendContent>();
        initMessage();
        tv_temp_nickname = (TextView) findViewById(R.id.friend_nickname);
        mFriendAdapter = new FriendAdapter(friendList, FriendActivity.this);
        friendListView.setAdapter(mFriendAdapter);

        FreshFriendsList ffL = new FreshFriendsList(friendList);
        ffL.start();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hander.sendEmptyMessage(0);
            }
        }.start();


        friendListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                selected_position = arg2;
                Log.e("myTag", friendList.get(arg2).my_id);
                Intent intent = new Intent(FriendActivity.this, SingleFriendActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initMessage() {
    }


}  
