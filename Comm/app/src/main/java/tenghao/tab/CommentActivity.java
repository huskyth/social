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
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import tenghao.tenghao.LoginActivity;
import tenghao.tenghao.MainActivity;
import tenghao.tool.MyHandlerTool;

public class CommentActivity extends Activity {
	 public static ArrayList<myCommentContent> commentList;
	 public static CommentAdapter mCommentAdapter;
     ListView majorCommentListView;
     TextView tv = null;
     EditText et_comment = null;
 	 public static Handler hander = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback(){
		 @Override
		 public boolean handleMessage(Message msg) {
			 if (msg.what == 0) {
				 mCommentAdapter.notifyDataSetChanged();
			 }
			 return true;
		 }
	 });
	    
    public void onCreate(Bundle savedInstanceState) { 
       super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
	   getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , 
	   WindowManager.LayoutParams. FLAG_FULLSCREEN);
       setContentView(R.layout.major_comment_listview);
       majorCommentListView = (ListView) findViewById(R.id.comment_listview);   
       commentList = new  ArrayList<myCommentContent>();  
       tv = (TextView)findViewById(R.id.comment_content_top);
       et_comment = (EditText)findViewById(R.id.et_content_ofcomment);//////////////
       initMessage();
       mCommentAdapter = new CommentAdapter(commentList,CommentActivity.this);
       majorCommentListView.setAdapter(mCommentAdapter);
       if(!"".equals(MajorActivity.major_temp_content)){
    	   tv.setText(MajorActivity.major_temp_content);
       }

       GetCommentThread gCTH = new GetCommentThread(commentList);
       gCTH.start();
       
       
    }
    
    public View sendComment(View v){
    	String temp_comment = et_comment.getText().toString();
    	if(!"".equals(temp_comment)){
    		SendCommentThread sCTH = new SendCommentThread(MainActivity.myonlyid, LoginActivity.myonly_nickname,temp_comment);
    		sCTH.start();
    	}
    		
    	
    	
		return v;
    	
    }
    private void initMessage(){  

	}  
}  
