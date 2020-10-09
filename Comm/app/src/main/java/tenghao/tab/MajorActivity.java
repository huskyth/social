package tenghao.tab;

import com.example.cjlu.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tenghao.tool.MyHandlerTool;

public class MajorActivity extends Activity {
    public static ImageButton iBtn_judge = null;
    public static ArrayList<myMajorContent> majorList;
    private static MajorAdapter mMajorAdapter;
    ListView majorListView;
    public static String major_temp_content = "";
    public static Handler hander = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback(){
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 0) {
                    mMajorAdapter.notifyDataSetChanged();
                }
            return true;
        }
    });

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_major);
        majorListView = (ListView) findViewById(R.id.major_listview);
        majorList = new ArrayList<myMajorContent>();
        initMessage();
        mMajorAdapter = new MajorAdapter(majorList, MajorActivity.this);
        majorListView.setAdapter(mMajorAdapter);
        GetMajorThread gMTH = new GetMajorThread(majorList);
        gMTH.start();
    }

    private void initMessage() {

    }
}  
