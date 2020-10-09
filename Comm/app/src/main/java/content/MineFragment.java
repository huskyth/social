package content;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cjlu.R;

import org.jetbrains.annotations.Nullable;

import content.friend.FriendActivity;
import content.write.WriteBackActivity;
import content.write.WriteCircleActivity;
import function.chat.ChatActivity;
import tenghao.tab.GetCareThread;
import tenghao.tab.PersonActivity;
import tenghao.tenghao.LoginActivity;
import tenghao.tenghao.MainActivity;
import tenghao.tool.MyHandlerTool;


public class MineFragment extends Fragment implements View.OnClickListener {
    public static final int CARE = 0;
    public static Handler handler;
    public static String cared_num = "";
    public static String care_num = "";
    private TextView tv_care;
    private TextView tv_cared;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mineView = View.inflate(getContext(), R.layout.person_layout, null);
        handler = new MyHandlerTool.MyHandler(new MyHandlerTool.MyCallback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == 0) {
                    Bundle b = msg.getData();
                    String care_num = b.getString("care_num");
                    String cared_num = b.getString("cared_num");;
                    tv_care.setText(care_num);
                    tv_cared.setText(cared_num);
                }
                return true;
            }
        });

        TextView tv_name = mineView.findViewById(R.id.tv_tempname);
        tv_care = mineView.findViewById(R.id.tv_care_num);
        tv_cared = mineView.findViewById(R.id.tv_iscared_num);

        GetCareThread gCTH = new GetCareThread();
        gCTH.start();



        tv_name.setText(LoginActivity.myonly_nickname);
        initButton(mineView);
        return mineView;
    }

    public static Fragment newInstance() {
        return new MineFragment();
    }

    private void initButton(View v) {
        Button write = v.findViewById(R.id.write);
        write.setOnClickListener(this);
        Button getFriends = v.findViewById(R.id.getFriends);
        getFriends.setOnClickListener(this);
        Button chatGp = v.findViewById(R.id.chatGp);
        chatGp.setOnClickListener(this);
        Button writeBack = v.findViewById(R.id.writeBack);
        writeBack.setOnClickListener(this);
        Button quit = v.findViewById(R.id.quit);
        quit.setOnClickListener(this);
    }

    private void quit() {
        SharedPreferences settings = getActivity().getSharedPreferences("setting", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("isAuto", "false");
        editor.putString("name", "null");
        editor.putString("psw", "");
        MainActivity.myonlyid = "";
        editor.commit();
        Toast.makeText(getContext(), "退出成功", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.write:
                intent = new Intent(getContext(), WriteCircleActivity.class);
                startActivity(intent);
                break;
            case R.id.getFriends:
                intent = new Intent(getContext(), FriendActivity.class);
                startActivity(intent);
                break;
            case R.id.chatGp:
                intent = new Intent(getContext(), ChatActivity.class);
                startActivity(intent);
                break;
            case R.id.writeBack:
                intent = new Intent(getContext(), WriteBackActivity.class);
                startActivity(intent);
                break;
            case R.id.quit:
                quit();
                break;
        }

    }
}
