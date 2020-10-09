package content.connectMySql;

import content.server.Server;
import type.data.ChatData;
import type.data.CircleData;
import type.data.FriendData;
import type.data.MajorData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectMySql {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void initI() {
        sql = "select max(id) from myusers";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                Server.i = Integer.parseInt(ret.getString(1)) + 1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void insertData(String phone, String psw, String name) {
        int i = Server.i;
        //sql = "insert into myusers values(0,'sadf','asdg','asfaasf')";
        sql = "insert into myusers values(" + i + ",'" + psw + "','" + name + "','" + phone + "')";//SQL???
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            db1.pst.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        db1.close();//???????
        Server.i++;
    }

    public static String getPsw(String myid) {
        sql = "select psw from myusers where id = " + Integer.parseInt(myid);
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                return ret.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static void insertDbCilcle(String myid, String content, String date, String img_path) {
        sql = "select nickname from myusers where id = " + Integer.parseInt(myid);
        String newnickname = "";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                newnickname = ret.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "insert into writecircle values(0,'" + newnickname + "','" + content + "','"+  date + "','"+img_path+ "','"+myid+"')";
        db1 = new DBHelper(sql);
        try {
            db1.pst.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db1.close();
    }

    public static void GetCicleData(ArrayList<CircleData> myCircleData) throws Exception {

        sql = "select newnickname,content,datetime,imagepath,userid from writecircle";
        String newnickname = "";
        String content = "";
        String datetime;
        String imagepath;
        String userid;
        db1 = new DBHelper(sql);
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                newnickname = ret.getString(1);
                content = ret.getString(2);
                int bugi = ret.getString(3).length();
                datetime = ret.getString(3).substring(0,bugi-2);
                imagepath = ret.getString(4);
                userid = ret.getString(5);

        System.out.println(datetime);
        System.out.println(imagepath);
                CircleData cd = new CircleData(newnickname, content,datetime,imagepath,userid);
                myCircleData.add(cd);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void GetFriendData(ArrayList<FriendData> myFriendData) {

        sql = "select id,psw,nickname,myphone from myusers";
        String myid = "";
        String psw = "";
        String nickname = "";
        String myphone = "";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                myid = ret.getString(1);
                psw = ret.getString(2);
                nickname = ret.getString(3);
                myphone = ret.getString(4);
                FriendData fd = new FriendData(myid, psw, nickname, myphone);
                myFriendData.add(fd);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void insertMyCareTable(String myid, String backid) {
        sql = "insert into caretable values(0,'" + myid + "','" + backid + "')";//SQL???
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            db1.pst.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        db1.close();//???????
    }

    public static String GetJudgeCareResult(String myid, String backid) {

        sql = "select count(id) from caretable where myid = '" + myid + "' and backid = '" + backid + "'";
        String result = "";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                result = ret.getString(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static String GetMyCare(String myid) {

        sql = "select count(id) from caretable where myid = '" + myid + "' ";
        String result = "";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                result = ret.getString(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static String GetMyCared(String myid) {

        sql = "select count(id) from caretable where backid = '" + myid + "' ";
        String result = "";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                result = ret.getString(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static void insertChatContent(String myid, String mychat_nickname, String mycontent) {
        sql = "insert into chatcontent values(0,'" + myid + "','" + mycontent + "','" + mychat_nickname + "')";//SQL???
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            db1.pst.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        db1.close();//???????
    }

    public static String getNickname(String myid) {
        sql = "select nickname from myusers where id = " + Integer.parseInt(myid);
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                return ret.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static void GetChatData(ArrayList<ChatData> myChatData) {
        sql = "select userid,usercontent,usernickname from chatcontent";
        String userid = "";
        String usercontent = "";
        String usernickname = "";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                userid = ret.getString(1);
                usercontent = ret.getString(2);
                usernickname = ret.getString(3);
                ChatData cd = new ChatData(userid, usernickname, usercontent);
                myChatData.add(cd);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void GetMajorData(ArrayList<MajorData> myMajorData) {

        sql = "select * from majorcontent";
        String my_major_id = "";
        String mycontent = "";
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            ret = db1.pst.executeQuery(sql);
            while (ret.next()) {
                my_major_id = ret.getString(1);
                mycontent = ret.getString(2);
                MajorData mD = new MajorData(my_major_id, mycontent);
                myMajorData.add(mD);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void insertDbComment(String myid, String myname, String content) {
        sql = "insert into commentcontent values(0,'" + myid + "','" + myname + "','" + content + "')";//SQL???
        db1 = new DBHelper(sql);//????DBHelper????
        try {
            db1.pst.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        db1.close();//???????
    }


}
