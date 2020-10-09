package tenghao.tenghao;

import android.os.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import content.CircleFragment;
import content.write.myCircleContent;
import tenghao.tool.Tool;

public class RefreshCircle extends Thread {
    Socket s;
    public ArrayList<myCircleContent> circleList;
    //    public static final String path = "data/data/com.tenghao.comm/";
    public static final String path = "/storage/emulated/0/myAppImgs/";

    public RefreshCircle(ArrayList<myCircleContent> circleList) {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        this.circleList = circleList;
    }

    public void run() {
        try {
            ArrayList<myCircleContent> tmp = new ArrayList<>();
            s = new Socket(Tool.publicIp, Tool.publicCut);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            dout.writeUTF("refresh_circle");

            int num = Integer.parseInt(din.readUTF());
            String temp_new_name;
            String temp_content;
            String temp_datetime;
            String temp_timestamp_path;
            String temp_id;
            String img_info;
            int byte_al = 0;

            for (int i = 0; i < num; i++) {
                temp_new_name = din.readUTF();
                temp_content = din.readUTF();
                temp_datetime = din.readUTF();
                temp_timestamp_path = din.readUTF();
                temp_id = din.readUTF();
                img_info = din.readUTF();
                myCircleContent mCC = new myCircleContent(temp_new_name, temp_content,
                        temp_datetime, temp_timestamp_path, temp_id, img_info);
                tmp.add(mCC);
                byte_al += getAllForOne(mCC.name_byte);

            }
            byte[] all = new byte[byte_al];
            int cur = 0;
            int length;
            byte[] inputByte = new byte[1024];
            while ((length = din.read(inputByte, 0, inputByte.length)) > 0) {
                System.arraycopy(inputByte, 0, all, cur, length);
                cur += length;
            }

            cur = 0;
            for (myCircleContent mcc : tmp) {
                String user_dir = path + mcc.userid + "/" + mcc.timestamp_imagepath + "/";
                File f = new File(user_dir);
                if (!f.exists()) {
                    f.mkdirs();
                }
                FileOutputStream ft = new FileOutputStream(new File(user_dir + mcc.userid + ".bak"));
                String wrt = mcc.datetime;
                ft.write(wrt.getBytes());
                ft.flush();
                for (String[] a : mcc.name_byte) {

                    String tmp_img_name = a[0];
                    int b = Integer.parseInt(a[1]);
                    FileOutputStream fos = new FileOutputStream(new File(user_dir
                            + tmp_img_name));
                    fos.write(all, cur, b);
                    cur += b;
                    fos.flush();
                }
            }


            Message msg = new Message();
            msg.what = CircleFragment.REFRESH;
            msg.obj = tmp;

            CircleFragment.handler.sendMessage(msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getAllForOne(ArrayList<String[]> name_byte) {
        int t = 0;
        for (String[] s : name_byte) {
            t += Integer.parseInt(s[1]);
        }
        return t;

    }
}
