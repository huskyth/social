package content.friend;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tenghao.tool.Tool;

public class SendCareThread extends Thread{
	String myid,backid;
	Socket s;
	public SendCareThread(String myid,String backid){
		this.myid = myid;
		this.backid = backid;
	}
	public void run(){
		try{
			s = new Socket(Tool.publicIp,Tool.publicCut);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("insert_care_or_cared");
			dout.writeUTF(myid);
			dout.writeUTF(backid);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
