package function.chat;
import java.util.ArrayList;
import com.example.cjlu.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class Adapter extends BaseAdapter {  
    private ArrayList<MyMessage> msgList;  
    private LayoutInflater mInflater;  
    public Adapter(ArrayList<MyMessage> msgList,Context context){  
        this.msgList = msgList;  
        mInflater = LayoutInflater.from(context);  
    }
    @Override  
    public int getCount() {  
        return msgList.size();  
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
    public int getItemViewType(int position){
    	if(position <= msgList.size()){
    		MyMessage msg = msgList.get(position);  
            return msg.getType(); 
    	}
    	else{
    		 return -1;
    	}
    }  
    @Override  
    public int getViewTypeCount() {  
        return 2;  
    }  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            if(getItemViewType(position) == 0){
                view = mInflater.inflate(R.layout.chat_left,null);
                viewHolder = new ViewHolder();
                viewHolder.text_nickname = (TextView)view.findViewById(R.id.chat_nickname_left);
                viewHolder.text_chatcontent = (TextView)view.findViewById(R.id.textLeft);
            }else {
                view = mInflater.inflate(R.layout.chat_right,null);  
                viewHolder = new ViewHolder();
                viewHolder.text_nickname = (TextView)view.findViewById(R.id.chat_nickname_right);
                viewHolder.text_chatcontent = (TextView)view.findViewById(R.id.textRight);  
            }  
            view.setTag(viewHolder);  
        }else {  
            view = convertView;  
            viewHolder = (ViewHolder)view.getTag();  
        }
        if(position <= msgList.size()){
            viewHolder.text_nickname.setText(msgList.get(position).nickname);  
            viewHolder.text_chatcontent.setText(msgList.get(position).content);
        }
        return view;  
    }  
    static class ViewHolder{
        TextView text_nickname;  
        TextView text_chatcontent;
    }  
}  