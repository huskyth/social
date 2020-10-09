package content.write;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cjlu.R;
import com.giftedcat.picture.lib.selector.MultiImageSelector;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import function.connectServer.WriteCircleThread;
import tenghao.tab.BaseActivity;
import tenghao.tab.NineGridAdapter;
import tenghao.tenghao.LoginActivity;
import tenghao.tenghao.MainActivity;



public class WriteCircleActivity extends BaseActivity {

    private static final int REQUEST_IMAGE = 2;
    private int maxNum = 9;

    Unbinder unbinder;

    @BindView(R.id.rv_images)
    RecyclerView rvImages;

    NineGridAdapter adapter;

    List<String> mSelectList;


    EditText et_send = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.write_circle);
        et_send = findViewById(R.id.et_circle_send);


        unbinder = ButterKnife.bind(this);

        mSelectList = new ArrayList<>();
        initView();

    }


    private void initView() {
        rvImages.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new NineGridAdapter(WriteCircleActivity.this, mSelectList, rvImages);
        adapter.setMaxSize(maxNum);
        rvImages.setAdapter(adapter);
        adapter.setOnAddPicturesListener(new OnAddPicturesListener() {
            @Override
            public void onAdd() {
                pickImage();
            }
        });
    }



    private void pickImage() {
        MultiImageSelector selector = MultiImageSelector.create(context);
        selector.showCamera(true);
        selector.count(maxNum);
        selector.multi();
        selector.origin(mSelectList);
        selector.start(instans, REQUEST_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                List<String> select = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);


                Log.e(MainActivity.TAG,select.get(0));



                mSelectList.clear();
                mSelectList.addAll(select);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    public View SendCircleToServer(View v) {
        String content = et_send.getText().toString();

        if ("".equals(content)){
            Toast.makeText(context,"请输入点什么吧",Toast.LENGTH_SHORT).show();
        }
        else{
            WriteCircleThread wcTh = new WriteCircleThread(mSelectList,content, MainActivity.myonlyid);
            wcTh.start();
        }

        startActivity(new Intent(WriteCircleActivity.this, LoginActivity.class));
        return v;
    }


}
