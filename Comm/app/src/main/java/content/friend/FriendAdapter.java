package content.friend;

import com.example.cjlu.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendAdapter extends BaseAdapter {
    private ArrayList<myFriendContent> friendList;
    private LayoutInflater mInflater;
    public FriendAdapter(ArrayList<myFriendContent> circleList,Context context){  
        this.friendList = circleList;  
        mInflater = LayoutInflater.from(context);  
    }
    @Override  
    public int getCount() {  
        return friendList.size();  
    }  
    @Override  
    public Object getItem(int position) {  
        return position;
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
        if(convertView == null){
                view = mInflater.inflate(R.layout.friend_item,null);
                viewHolder = new ViewHolder();
                viewHolder.text_nickname = (TextView)view.findViewById(R.id.friend_nickname);
             
            view.setTag(viewHolder);
        }else{
            view = convertView;  
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.text_nickname.setText(friendList.get(position).my_nickname);
        return view;
    }  
    static class ViewHolder{
        TextView text_nickname;  
    }  
}  