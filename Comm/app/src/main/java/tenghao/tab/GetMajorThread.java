package tenghao.tab;
import android.os.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import content.NewsFragment;
import tenghao.tool.Tool;


public class GetMajorThread extends Thread{
	ArrayList<myMajorContent> majorList = null;
	Socket s;
	public GetMajorThread(ArrayList<myMajorContent> majorList){
		this.majorList = majorList;
	}
	public void run(){
		try{
			ArrayList<myMajorContent> tmp = new ArrayList<>();
			s = new Socket(Tool.publicIp,Tool.publicCut);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("get_major");
			int num = Integer.parseInt(din.readUTF());
			for(int i = 0;i < num;i++){
				String temp_id = din.readUTF();
				String temp_major_content = din.readUTF();
				myMajorContent mMC = new myMajorContent(temp_id,temp_major_content);
				tmp.add(mMC);
			}


			Message msg = new Message();
			msg.obj = tmp;
			msg.what = NewsFragment.REFRESH;
			NewsFragment.handler.sendMessage(msg);




		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
