package content.write;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cjlu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import tenghao.tab.CircleNineGridAdapter;
import tenghao.tenghao.MainActivity;
import tenghao.tenghao.RefreshCircle;

public class CircleAdapter extends BaseAdapter {
    private ArrayList<myCircleContent> circleList;
    private LayoutInflater mInflater;
    public List<String> mSelectList;
    Context ctx;
    Unbinder unbinder;
    CircleNineGridAdapter adapter;

    public CircleAdapter(ArrayList<myCircleContent> circleList, Context context) {
        this.circleList = circleList;
        mInflater = LayoutInflater.from(context);
        this.ctx = context;
        unbinder = ButterKnife.bind((Activity) ctx);


    }

    @Override
    public int getCount() {
        return circleList.size();
    }

    @Override
    public Object getItem(int position) {
        return circleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {

            view = mInflater.inflate(R.layout.circle_item, null);

            viewHolder = new ViewHolder();
            viewHolder.text_name = view.findViewById(R.id.circle_new_name);
            viewHolder.text_content = view.findViewById(R.id.circle_content);
            viewHolder.rv = view.findViewById(R.id.rv_images_circle);
            viewHolder.iv = view.findViewById(R.id.circle_head);
            viewHolder.datetime = view.findViewById(R.id.circle_datetime);


            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        myCircleContent tmp = circleList.get(position);
        mSelectList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String[] st : tmp.name_byte) {
            String dir = RefreshCircle.path + tmp.userid + "/"
                    + tmp.timestamp_imagepath + "/" + st[0];
            mSelectList.add(dir);
            sb.append(dir+"\n");
        }
        Log.e(MainActivity.TAG,tmp.content+"\n"+sb.toString());

        viewHolder.rv.setLayoutManager(new GridLayoutManager(ctx, 3));
        adapter = new CircleNineGridAdapter(ctx, mSelectList, viewHolder.rv);
        adapter.setMaxSize(9);
        viewHolder.rv.setAdapter(adapter);




        viewHolder.text_name.setText(circleList.get(position).newnickname);
        viewHolder.text_content.setText(circleList.get(position).content);
        viewHolder.iv.setImageBitmap(BitmapFactory.decodeResource(ctx.getResources(),R.mipmap.add_icon));
        viewHolder.datetime.setText(circleList.get(position).datetime);
        return view;
    }


    static class ViewHolder {
        TextView text_name;
        TextView text_content;
        TextView datetime;
        ImageView iv;
        RecyclerView rv;
    }
}  