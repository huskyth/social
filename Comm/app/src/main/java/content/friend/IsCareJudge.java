package content.friend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;

import tenghao.tool.Tool;

public class IsCareJudge extends Thread {
	String myid,backid;
	Socket s;
	public IsCareJudge(String myid,String backid){
		this.myid = myid;
		this.backid = backid;
	}
	public void run(){
		try{
			s = new Socket(Tool.publicIp,Tool.publicCut);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			DataInputStream din = new DataInputStream(s.getInputStream());
			dout.writeUTF("insert_care_judge");
			dout.writeUTF(myid);
			dout.writeUTF(backid);
			SingleFriendActivity.result = din.readUTF();
			do{
			}while("".equals(SingleFriendActivity.result));
			SingleFriendActivity.hander.sendEmptyMessage(1);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
