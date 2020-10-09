package Tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
    public static void main(String[] args) throws Exception {

        System.out.println();
    }
    public static String[] getFormatTime(){
        Date date=new Date();     //获取一个Date对象
        DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //创建一个格式化日期对象
        String punchTime = simpleDateFormat.format(date);   //格式化后的时间
        return new String[]{punchTime, String.valueOf(System.currentTimeMillis())};
    }
}
