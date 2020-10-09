package tenghao.tab;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import tenghao.tool.Tool;

public class SendCommentThread extends Thread{
	Socket s;
	String content;
	String myid;
	String mynickname;
	public SendCommentThread(String id,String mynickname,String content){
		this.content = content;
		this.myid = id;
		this.mynickname = mynickname;
	}
	public void run(){
		DataOutputStream dout;
		try {
			s = new Socket(Tool.publicIp,Tool.publicCut);
			dout = new DataOutputStream(s.getOutputStream());
			
			dout.writeUTF("write_comment");
			dout.writeUTF(myid);
			dout.writeUTF(mynickname);
			dout.writeUTF(content);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
