package tenghao.tenghao;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.cjlu.R;
import com.google.android.material.tabs.TabLayout;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import content.CircleFragment;
import content.MineFragment;
import content.NewsFragment;
import tenghao.tool.Tool;

public class LoginActivity extends AppCompatActivity {
    public static String myonly_nickname = "";
    private TabLayout tbMonetary;

    private void initView() {
        tbMonetary = findViewById(R.id.tb_monetary);
        tbMonetary.addTab(tbMonetary.newTab().setText("朋友圈"));
        tbMonetary.addTab(tbMonetary.newTab().setText("新闻"));
        tbMonetary.addTab(tbMonetary.newTab().setText("我的"));

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_monetary_replace, CircleFragment.newInstance()).commit();
        initListener();
    }

    private void initListener() {
        tbMonetary.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (tab.getPosition() == 0) {
                    transaction.replace(R.id.fl_monetary_replace, CircleFragment.newInstance()).commit();
                } else if (tab.getPosition() == 1) {
                    transaction.replace(R.id.fl_monetary_replace, NewsFragment.newInstance()).commit();
                } else if (tab.getPosition() == 2) {
                    transaction.replace(R.id.fl_monetary_replace, MineFragment.newInstance()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layout_tab);
        initView();
        if ("".equals(myonly_nickname) || null == myonly_nickname) {
            GetNickname gN = new GetNickname(MainActivity.myonlyid);
            gN.start();
        }
    }

    public static class GetNickname extends Thread {
        String myid;
        Socket s;

        public GetNickname(String myid) {
            this.myid = myid;
        }

        public void run() {
            try {
                s = new Socket(Tool.publicIp, Tool.publicCut);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout.writeUTF("get_nickname");
                dout.writeUTF(myid);
                myonly_nickname = din.readUTF();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
