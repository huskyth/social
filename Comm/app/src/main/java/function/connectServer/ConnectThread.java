package function.connectServer;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tenghao.tenghao.MainActivity;
import tenghao.tool.Tool;

public class ConnectThread extends Thread{
	Socket s;
	/*public ConnectThread(Socket s){
		this.s = s;
	}*/
	public void run(){
		try {
			s = new Socket(Tool.publicIp,Tool.publicCut);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("write_circle_init");
			dout.writeUTF(MainActivity.myonlyid);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
