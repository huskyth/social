package function.chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import tenghao.tenghao.MainActivity;
import tenghao.tool.Tool;

public class GetChatContent extends Thread{
	Socket s;
	public ArrayList<MyMessage> chatList;
	public GetChatContent(ArrayList<MyMessage> chatList){
		this.chatList = chatList;
	}
	public void run(){
		try {
			while(true){
				try {
					Thread.sleep(2000);
					s = new Socket(Tool.publicIp,Tool.publicCut);
					DataOutputStream dout = new DataOutputStream(s.getOutputStream());
					DataInputStream din = new DataInputStream(s.getInputStream());
						dout.writeUTF("refresh_chat");
						chatList.clear();
						int num = Integer.parseInt(din.readUTF());
						for(int i = 0;i < num;i++){
							String temp_id = din.readUTF();
							String temp_nickname = din.readUTF();
							String temp_content = din.readUTF();
							if(MainActivity.myonlyid.equals(temp_id)){
								MyMessage mm = new MyMessage(1,temp_nickname,temp_content);
								chatList.add(mm);
							}
							else{
								MyMessage mm = new MyMessage(0,temp_nickname,temp_content);
								chatList.add(mm);
							}
						}
						ChatActivity.hander.sendEmptyMessage(4);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
