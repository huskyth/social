package content.server;

import Tool.ImageTool;
import Tool.TimeTool;
import content.connectMySql.ConnectMySql;
import org.omg.PortableInterceptor.ServerRequestInfo;
import type.data.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static int i = 10;

    public static boolean isExist(ArrayList<SocketAndId> client_send_List, String id, Socket s) {
        for (int i = 0; i < client_send_List.size(); i++) {
            if (id.equals(client_send_List.get(i).id)) {
                client_send_List.get(i).s = s;
                return true;
            }
        }
        return false;
    }

    public static class SendCircleContent extends Thread {
        Socket s;
        ArrayList<CircleData> myCircleData = new ArrayList<CircleData>();


        public SendCircleContent(Socket s, ArrayList<CircleData> myCircleData) {
            this.s = s;
            this.myCircleData = myCircleData;
        }

        public void run() {
            try {
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ConnectMySql.GetCicleData(myCircleData);
                    int num = myCircleData.size();
                    dout.writeUTF(num + "");
                    for (int i = 0; i < num; i++) {
                        String temp_new_name = myCircleData.get(i).newnickname;
                        String temp_content = myCircleData.get(i).content;
                        dout.writeUTF(temp_new_name);
                        dout.writeUTF(temp_content);

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = null;
        Socket s = null;
        DataInputStream din = null;
        DataOutputStream dout = null;
        String phone = "";
        String pass = "";
        String name = "";
        String myid = "";
        String mypsw = "";

        ArrayList<SocketAndId> client_send_circle_List = new ArrayList<SocketAndId>();
        ArrayList<CircleData> myCircleData = new ArrayList<CircleData>();
        ConnectMySql.initI();
        ArrayList<FriendData> myFriendData = new ArrayList<FriendData>();
        ArrayList<MajorData> myMajorData = new ArrayList<MajorData>();
        ArrayList<ChatData> myChatData = new ArrayList<ChatData>();
        ArrayList<CommentData> commentData = new ArrayList<CommentData>();

        try {
            ss = new ServerSocket(8888);
            System.out.println("已监听端口8888");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                s = ss.accept();
                System.out.print("有客户接受**********");
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                String type = din.readUTF();
                System.out.println("类型:" + type);
                if ("register".equals(type)) {
                    phone = din.readUTF();
                    pass = din.readUTF();
                    name = din.readUTF();
                    int temp_id = -1;
                    temp_id = i;
                    if (!"".equals(phone))
                        if (!"".equals(pass))
                            if (!"".equals(name)) {
                                ConnectMySql.insertData(phone, pass, name);
                            }
                } else if ("login".equals(type)) {
                    myid = din.readUTF();
                    mypsw = din.readUTF();
                    if (mypsw.equals(ConnectMySql.getPsw(myid))) {
                        dout.writeUTF("loginOk");
                    } else {
                        dout.writeUTF("loginErr");
                    }
                } else if ("write_circle_init".equals(type)) {
                    String temp_id = din.readUTF();
                    SocketAndId temp_sai = new SocketAndId(s, temp_id);
                    if (isExist(client_send_circle_List, temp_id, s)) {
                        System.out.println("覆盖：" + temp_id);
                    } else {
                        client_send_circle_List.add(temp_sai);
                        System.out.println("添加：" + temp_id);
                    }
                    System.out.println("已存在的个数" + client_send_circle_List.size());

                } else if ("write_circle".equals(type)) {
                    String temp_id = din.readUTF();
                    String temp_content = din.readUTF();
                    System.out.println("我的id：" + temp_id);
                    System.out.println("我的内容：" + temp_content);


                    byte[] buf;
                    int ima_num = din.read();
                    String myroot = din.readUTF();
                    String times[] = TimeTool.getFormatTime();
                    String time = times[0];
                    String timepath = times[1];
                    File file = new File(ImageTool.image_root + myroot + "\\" + timepath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String image_path = ImageTool.image_root + myroot + "\\" + timepath;
                    String img_name;
                    ArrayList<ArrayList<String>> tmp = new ArrayList<>();

                    int all_byte = 0;
                    for (int i = 0; i < ima_num; i++) {
                        String imgname = din.readUTF();
                        int bt = Integer.parseInt(din.readUTF());
                        ArrayList<String> t = new ArrayList<>();
                        t.add(imgname);
                        t.add(String.valueOf(bt));
                        all_byte += bt;
                        tmp.add(t);
                    }

                    byte[] dest = new byte[all_byte];


                    int cur = 0;
                    int length;
                    byte[] inputByte = new byte[1024];
                    while ((length = din.read(inputByte, 0, inputByte.length)) > 0) {
                        System.arraycopy(inputByte, 0, dest, cur, length);
                        cur += length;
                    }


                    cur = 0;
                    for (ArrayList<String> a : tmp) {
                        System.out.println("writing");
                        String tmp_img_name = a.get(0);
                        int b = Integer.parseInt(a.get(1));
                        FileOutputStream fos = new FileOutputStream(new File(image_path + "\\" + tmp_img_name));
                        fos.write(dest, cur, b);
                        cur += b;
                        fos.flush();
                    }

                    if (!"".equals(temp_content))
                        ConnectMySql.insertDbCilcle(temp_id, temp_content,
                                time, timepath);

                } else if ("refresh_circle".equals(type)) {
                    System.out.println("发送CIRCLE");

                    myCircleData.clear();
                    ConnectMySql.GetCicleData(myCircleData);
                    int num = myCircleData.size();
                    dout.writeUTF(num + "");

                    for (int i = 0; i < num; i++) {
                        String temp_new_name = myCircleData.get(i).newnickname;
                        String temp_content = myCircleData.get(i).content;
                        String temp_datetime = myCircleData.get(i).datetime;
                        String temp_timestamp_path = myCircleData.get(i).timestamp_imagepath;
                        String temp_id = myCircleData.get(i).userid;
                        String img_info = myCircleData.get(i).image_info;

                        dout.writeUTF(temp_new_name);
                        dout.writeUTF(temp_content);
                        dout.writeUTF(temp_datetime);

                        dout.writeUTF(temp_timestamp_path);
                        dout.writeUTF(temp_id);
                        dout.writeUTF(img_info);
                    }
                    for (int i = 0; i < num; i++) {
                        CircleData cd = myCircleData.get(i);
                        List<String> imgs = cd.imgs;
                        for (String t:imgs){
                            File file = new File(t);
                            FileInputStream fis = new FileInputStream(file);
                            byte[] sendBytes = new byte[1024];
                            int length;
                            while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
                                dout.write(sendBytes, 0, length);
                                dout.flush();
                            }
                        }
                    }
                    s.shutdownOutput();
                    //目前为止
                } else if ("refresh_friend_list".equals(type)) {
                    System.out.println("发送用户信息");
                    myFriendData.clear();
                    ConnectMySql.GetFriendData(myFriendData);
                    int num = myFriendData.size();
                    dout.writeUTF(num + "");
                    for (int i = 0; i < num; i++) {
                        String temp_id = myFriendData.get(i).my_id;
                        String temp_psw = myFriendData.get(i).my_psw;
                        String temp_nickname = myFriendData.get(i).my_nickname;
                        String temp_phone = myFriendData.get(i).my_phone;
                        dout.writeUTF(temp_id);
                        dout.writeUTF(temp_psw);
                        dout.writeUTF(temp_nickname);
                        dout.writeUTF(temp_phone);
                    }
                } else if ("insert_care_or_cared".equals(type)) {
                    System.out.println("发送关注信息");
                    String myid_of_care = din.readUTF();
                    String backid = din.readUTF();
                    ConnectMySql.insertMyCareTable(myid_of_care, backid);
                } else if ("insert_care_judge".equals(type)) {
                    System.out.println("检查关注信息");
                    String temp_mycareid = din.readUTF();
                    String temp_backid = din.readUTF();
                    dout.writeUTF(ConnectMySql.GetJudgeCareResult(temp_mycareid, temp_backid));
                    System.out.println("结果为" + ConnectMySql.GetJudgeCareResult(temp_mycareid, temp_backid));
                } else if ("get_care_num".equals(type)) {
                    System.out.println("得到关注的数字信息");
                    String id_temp = din.readUTF();
                    dout.writeUTF(ConnectMySql.GetMyCare(id_temp));
                    dout.writeUTF(ConnectMySql.GetMyCared(id_temp));
                } else if ("get_id".equals(type)) {
                    System.out.println("得到Id信息");
                    dout.writeUTF((i - 1) + "");
                } else if ("chat_send_content".equals(type)) {
                    String temp_mychatid = din.readUTF();
                    String temp_mychatname = din.readUTF();
                    String temp_chatcontent = din.readUTF();
                    ConnectMySql.insertChatContent(temp_mychatid, temp_mychatname, temp_chatcontent);
                } else if ("get_nickname".equals(type)) {
                    String temp_myonlyid = din.readUTF();
                    if (!"".equals(temp_myonlyid))
                        dout.writeUTF(ConnectMySql.getNickname(temp_myonlyid));
                } else if ("refresh_chat".equals(type)) {
                    System.out.println("发送聊天内容");
                    myChatData.clear();
                    ConnectMySql.GetChatData(myChatData);
                    int num = myChatData.size();

                    System.out.println("第一个" + myChatData.get(1).userid);

                    dout.writeUTF(num + "");
                    for (int i = 0; i < num; i++) {
                        String temp_new_chat_id = myChatData.get(i).userid;
                        String temp_chat_nickname = myChatData.get(i).usernickname;
                        String temp_chat_of_content = myChatData.get(i).usercontent;
                        dout.writeUTF(temp_new_chat_id);
                        dout.writeUTF(temp_chat_nickname);
                        dout.writeUTF(temp_chat_of_content);
                    }
                } else if ("get_major".equals(type)) {
                    System.out.println("发送Major");
                    myMajorData.clear();
                    ConnectMySql.GetMajorData(myMajorData);
                    int num = myMajorData.size();
                    dout.writeUTF(num + "");
                    for (int i = 0; i < num; i++) {
                        String temp_major_id = myMajorData.get(i).my_major_id;
                        String temp_content = myMajorData.get(i).my_content;
                        dout.writeUTF(temp_major_id);
                        dout.writeUTF(temp_content);
                    }
                } else if ("write_comment".equals(type)) {
                    String temp_id = din.readUTF();
                    String temp_nickname = din.readUTF();
                    String temp_comment_content = din.readUTF();
                    if (!"".equals(temp_id) && !"".equals(temp_nickname) && !"".equals(temp_comment_content))
                        ConnectMySql.insertDbComment(temp_id, temp_nickname, temp_comment_content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (din != null) {
                    din.close();
                }
                if (s != null) {
                    s.close();
                    System.out.println("socket关闭");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}




