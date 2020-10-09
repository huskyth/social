package tenghao.tab;
import java.util.ArrayList;
import com.example.cjlu.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
public class MajorAdapter extends BaseAdapter {  
    private ArrayList<myMajorContent> majorList;  
    private LayoutInflater mInflater;
    public MajorAdapter(ArrayList<myMajorContent> majorList,Context context){  
        this.majorList = majorList;  
        mInflater = LayoutInflater.from(context);  
    }
    @Override  
    public int getCount() {  
        return majorList.size();
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
                view = mInflater.inflate(R.layout.major_item,null);
                viewHolder = new ViewHolder();
                viewHolder.text_content = (TextView)view.findViewById(R.id.major_content);
            view.setTag(viewHolder);
        }else{
            view = convertView;  
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.text_content.setText(majorList.get(position).my_content);
        return view;  
    }

    static class ViewHolder{
        TextView text_content;  
     
    }  
}  