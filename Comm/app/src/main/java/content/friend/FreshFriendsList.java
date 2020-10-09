package content.friend;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import tenghao.tool.Tool;

public class FreshFriendsList extends Thread{
	Socket s;
	public ArrayList<myFriendContent> friendList = new ArrayList<myFriendContent>(); 
	public FreshFriendsList(ArrayList<myFriendContent> friendList){
		this.friendList = friendList;
	}
	public void run(){
		try {
			s = new Socket(Tool.publicIp,Tool.publicCut);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			DataInputStream din = new DataInputStream(s.getInputStream());
				dout.writeUTF("refresh_friend_list");
				if(friendList != null)
					friendList.clear();
				int num = Integer.parseInt(din.readUTF());
				for(int i = 0;i < num;i++){
					String temp_id = din.readUTF();
					String temp_psw = din.readUTF();
					String temp_nickname = din.readUTF();
					String temp_myphone = din.readUTF();
					myFriendContent mFC = new myFriendContent(temp_id,temp_psw,temp_nickname,temp_myphone);
					friendList.add(mFC);
				}
				FriendActivity.hander.sendEmptyMessage(0);
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

