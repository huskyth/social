package content;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cjlu.R;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import tenghao.tab.GetMajorThread;
import tenghao.tab.MajorActivity;
import tenghao.tab.MajorAdapter;
import tenghao.tab.myMajorContent;
import tenghao.tool.MyHandlerTool;


public class NewsFragment extends Fragment {

    public static final int REFRESH = 0;
    private MajorAdapter mMajorAdapter;
    public static Handler handler;
    ArrayList<myMajorContent> majorList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        handler = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback(){
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == REFRESH) {
                    majorList.clear();
                    ArrayList<myMajorContent> tmp = (ArrayList<myMajorContent>) msg.obj;
                    majorList.addAll(tmp);
                    mMajorAdapter.notifyDataSetChanged();
                }
                return true;
            }
        });
        View newsView = View.inflate(getContext(), R.layout.activity_listview_major, null);

        ListView majorListView;
        majorListView = newsView.findViewById(R.id.major_listview);
        majorList = new ArrayList<myMajorContent>();

        mMajorAdapter = new MajorAdapter(majorList, getContext());
        majorListView.setAdapter(mMajorAdapter);


        GetMajorThread gMTH = new GetMajorThread(majorList);
        gMTH.start();






        return newsView;
    }

    public static Fragment newInstance() {
        return new NewsFragment();
    }
}
