package tenghao.tool;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;


public class ImageTool {

    public static String getImageType(byte[] imageBytes) {
        try {
            MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(new ByteArrayInputStream(imageBytes));
            Iterator<ImageReader> itr = ImageIO.getImageReaders(memoryCacheImageInputStream);
            while (itr.hasNext()) {
                ImageReader reader = itr.next();
                String imageName = reader.getClass().getSimpleName();
                if ("JPEGImageReader".equalsIgnoreCase(imageName)) {
                    return "jpeg";
                }
                if ("JPGImageReader".equalsIgnoreCase(imageName)) {
                    return "jpg";
                }
                if ("pngImageReader".equalsIgnoreCase(imageName)) {
                    return "png";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws Exception {
//
//        byte[] b1 = image2Bytes("launcher.png");
//
//        buff2Image(b1, "test.jpg");
//
//        System.out.println(getImageType(b1));
//    }

    public static void buff2Image(byte[] b, String tagSrc) throws Exception {
        FileOutputStream fout = new FileOutputStream(tagSrc);
        fout.write(b);
        fout.close();
    }

    public static byte[] image2Bytes(String imgSrc) throws Exception {
        FileInputStream fin = new FileInputStream(new File(imgSrc));
        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        fin.close();
        return bytes;
    }


}
