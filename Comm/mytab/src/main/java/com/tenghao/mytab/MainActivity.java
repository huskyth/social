package com.tenghao.mytab;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public static class TabsFragment extends Fragment {
        View rootView;
        TextView textView;
        EditText editText;
        Button button;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public TabsFragment() {
        }

        public static TabsFragment newInstance(int sectionNumber) {
            TabsFragment fragment = new TabsFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d("ARG_SECTION_NUMBER:",getArguments().getInt(ARG_SECTION_NUMBER)+"");

            /**
             * 防止Fragment多次切换时调用onCreateView重新加载View
             */
            if (null == rootView) {
                rootView = inflater.inflate(R.layout.fragment_main, container, false);
            }

            //child controls init
            textView = (TextView) rootView.findViewById(R.id.section_label);
            editText=(EditText)rootView.findViewById(R.id.editText);
            button=(Button)rootView.findViewById(R.id.button);

            //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }

            return rootView;
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.i("PatrolTaskDetail", "****>>>> onResume");
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
            String dateString = dateFormat.format( now );
            editText.setText("");

            button.setText(dateString);
            Log.d("dateString:",dateString);

            //initView();
        }

        @Override
        public void onHiddenChanged(boolean hidden) {
            Log.d("hidden:",hidden+"");
            Log.d("ARG_SECTION_NUMBER:",getArguments().getInt(ARG_SECTION_NUMBER)+"");
        }

        @Override
        public void onDestroyView(){
            super.onDestroyView();
            Log.d("onDestroyView:",getArguments().getInt(ARG_SECTION_NUMBER)+"");
        }
    }
}
