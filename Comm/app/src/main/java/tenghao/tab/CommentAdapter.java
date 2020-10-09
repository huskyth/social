package tenghao.tab;
import java.util.ArrayList;
import com.example.cjlu.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class CommentAdapter extends BaseAdapter{
    private ArrayList<myCommentContent> commentList;  
    private LayoutInflater mInflater;
    public CommentAdapter(ArrayList<myCommentContent> commentList,Context context){  
        this.commentList = commentList;  
        mInflater = LayoutInflater.from(context);  
    }
    @Override  
    public int getCount() {  
        return commentList.size();
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
                view = mInflater.inflate(R.layout.comment_item,null);
                viewHolder = new ViewHolder();
                viewHolder.comment_name = (TextView)view.findViewById(R.id.comment_nickname_right);
                viewHolder.comment_content = (TextView)view.findViewById(R.id.textRight_comment);
            view.setTag(viewHolder);
        }else{
            view = convertView;  
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.comment_name.setTag(commentList.get(position).my_nickname);
        viewHolder.comment_content.setText(commentList.get(position).my_comment_content);
        return view;  
    }
    
   
    static class ViewHolder{
        TextView comment_name;  
        TextView comment_content;  
    }  
}  