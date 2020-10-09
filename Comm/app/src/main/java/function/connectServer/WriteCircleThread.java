package function.connectServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.List;

import tenghao.tenghao.MainActivity;
import tenghao.tool.Tool;

import static tenghao.tool.ImageTool.image2Bytes;

public class WriteCircleThread extends Thread {
    Socket s;
    String content;
    String myid;
    List<String> imagelist;


    public WriteCircleThread(List<String> imagelist, String content, String id) {
        this.content = content;
        this.myid = id;
        this.imagelist = imagelist;

    }


    public void run() {
        DataOutputStream dout;
        DataInputStream din;
        try {
            s = new Socket(Tool.publicIp, Tool.publicCut);
            dout = new DataOutputStream(s.getOutputStream());
            din = new DataInputStream(s.getInputStream());
            dout.writeUTF("write_circle");
            dout.writeUTF(myid);
            dout.writeUTF(content);
            int size = 0;
            for (String t : imagelist) {
                if (!"".equals(t)) {
                    size += 1;
                }
            }

            dout.write(size);
            String rootdir = MainActivity.myonlyid;
            dout.writeUTF(rootdir);


            for (String t : imagelist) {
                if (!"".equals(t)) {
                    int end = t.split("/").length - 1;
                    String name = t.split("/")[end];
                    dout.writeUTF(name);
                    byte[] test = image2Bytes(t);
                    dout.writeUTF(String.valueOf(test.length));
                }
            }




            for (String t : imagelist) {
                if (!"".equals(t)) {

                    File file = new File(t);
                    FileInputStream fis = new FileInputStream(file);

                    byte[] sendBytes = new byte[1024];
                    int length;
                    while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
                        dout.write(sendBytes, 0, length);
                        dout.flush();
                    }
                }
            }

            s.shutdownOutput();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
