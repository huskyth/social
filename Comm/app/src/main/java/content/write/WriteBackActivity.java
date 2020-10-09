package content.write;
import java.net.Socket;
import java.util.ArrayList;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import com.example.cjlu.R;
public class WriteBackActivity extends Activity{
	//Socket s = null;
	//ConnectThread cTh = new ConnectThread();
	EditText et_send_back = null;
	 public void onCreate(Bundle savedInstanceState) {  
	       super.onCreate(savedInstanceState);  
			 requestWindowFeature(Window.FEATURE_NO_TITLE);
		     getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , 
		     WindowManager.LayoutParams. FLAG_FULLSCREEN);
	         setContentView(R.layout.write_back);
	         et_send_back = (EditText)findViewById(R.id.et_back_send);
	         //cTh.start();
	    }
	 public View WriteBack(View v){
		 if(!"".equals(et_send_back.getText().toString())){
			 Toast.makeText(this, "·´À¡³É¹¦", Toast.LENGTH_SHORT).show();
		 }
		return v;
		 
		 
	 }
	 
	 
	   
}
