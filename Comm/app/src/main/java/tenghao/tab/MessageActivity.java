package tenghao.tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MessageActivity extends Activity {  
    public void onCreate(Bundle savedInstanceState) {  
       super.onCreate(savedInstanceState);  
       TextView textview = new TextView(this);  
       textview.setText("������Ϣ"); 
     
       setContentView(textview);  
    }  
}  
