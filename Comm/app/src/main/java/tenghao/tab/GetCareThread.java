package tenghao.tab;

import android.os.Bundle;
import android.os.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import content.MineFragment;
import tenghao.tenghao.MainActivity;
import tenghao.tool.Tool;


public class GetCareThread extends Thread {
	Socket s;
	public void run(){
		try{
			s = new Socket(Tool.publicIp,Tool.publicCut);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("get_care_num");
			dout.writeUTF(MainActivity.myonlyid);
			String care_num = din.readUTF();
			String cared_num = din.readUTF();
			Message msg = new Message();
			Bundle b = new Bundle();
			b.putString("care_num",care_num);
			b.putString("cared_num",cared_num);
			msg.setData(b);
			msg.what = MineFragment.CARE;
			
			MineFragment.handler.sendMessage(msg);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
