package content;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cjlu.R;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

import content.write.CircleAdapter;
import content.write.myCircleContent;
import tenghao.tab.CicleActivity;
import tenghao.tenghao.MainActivity;
import tenghao.tenghao.RefreshCircle;
import tenghao.tool.MyHandlerTool;


public class CircleFragment extends Fragment   {
    public static final int REFRESH = 0;
    public static Handler handler;
    private CircleAdapter mCircleAdapter;
    ArrayList<myCircleContent> circleList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View cView = View.inflate(getContext(), R.layout.activity_listview_writecircle, null);


        handler = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback(){
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == REFRESH) {
                    circleList.clear();
                    ArrayList<myCircleContent> tmp = (ArrayList<myCircleContent>) msg.obj;
                    circleList.addAll(tmp);
                    mCircleAdapter.notifyDataSetChanged();
                }
                return true;
            }
        });

        ListView circleListView = cView.findViewById(R.id.cirlcr_listview);
        circleList = new ArrayList<myCircleContent>();
        mCircleAdapter = new CircleAdapter(circleList, getContext());
        circleListView.setAdapter(mCircleAdapter);

        RefreshCircle rC = new RefreshCircle(circleList);
        rC.start();


        return cView;
    }

    public static Fragment newInstance() {
        return new CircleFragment();
    }


}
