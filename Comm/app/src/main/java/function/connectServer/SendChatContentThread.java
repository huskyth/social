package function.connectServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tenghao.tenghao.LoginActivity;
import tenghao.tenghao.MainActivity;
import tenghao.tool.Tool;


public class SendChatContentThread extends Thread{
	Socket s;
	String content;
	public SendChatContentThread(String content){
		this.content = content;
	}
	public void run(){
		try {
			s = new Socket(Tool.publicIp,Tool.publicCut);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("chat_send_content");
			dout.writeUTF(MainActivity.myonlyid);
			dout.writeUTF(LoginActivity.myonly_nickname);
			dout.writeUTF(content);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
