package tenghao.tab;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import tenghao.tool.Tool;

public class GetCommentThread  extends Thread{
	Socket s;
	public ArrayList<myCommentContent> commentList;
	public GetCommentThread(ArrayList<myCommentContent> commentList){
		this.commentList = commentList;
	}
	public void run(){
		try {
			while(true){
				try {
					Thread.sleep(2000);
					s = new Socket(Tool.publicIp,Tool.publicCut);
					DataOutputStream dout = new DataOutputStream(s.getOutputStream());
					DataInputStream din = new DataInputStream(s.getInputStream());
						dout.writeUTF("refresh_comment");
						
						dout.writeUTF(MajorActivity.major_temp_content);
						
						commentList.clear();
						int num = Integer.parseInt(din.readUTF());
						for(int i = 0;i < num;i++){
							String temp_nickname = din.readUTF();
							String temp_content = din.readUTF();
							myCommentContent mCT = new myCommentContent(temp_nickname,temp_content);
							commentList.add(mCT);
						}
						CommentActivity.hander.sendEmptyMessage(0);
					
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

