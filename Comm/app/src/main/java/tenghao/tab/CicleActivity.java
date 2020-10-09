package tenghao.tab;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.cjlu.R;

import java.util.ArrayList;

import content.write.CircleAdapter;
import content.write.myCircleContent;
import tenghao.tenghao.RefreshCircle;
import tenghao.tool.MyHandlerTool;


public class CicleActivity extends Activity {

    public static ArrayList<myCircleContent> circleList;
    private static CircleAdapter mCircleAdapter;
    ListView circleListView;
    public static Handler hander = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback(){
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == 0) {
                    mCircleAdapter.notifyDataSetChanged();
                }
            return true;
        }
    });

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_writecircle);
        circleListView = findViewById(R.id.cirlcr_listview);
        circleList = new ArrayList<myCircleContent>();

        mCircleAdapter = new CircleAdapter(circleList, CicleActivity.this);
        circleListView.setAdapter(mCircleAdapter);

        RefreshCircle rC = new RefreshCircle(circleList);
        rC.start();

    }

}  
