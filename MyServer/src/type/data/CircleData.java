package type.data;

import Tool.ImageTool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircleData {
	public String newnickname;
	public String content;
	public String datetime;
	public String timestamp_imagepath;//毫秒级别时间，也就是图片文件夹名字
	public String userid;
	public String image_abspath;//服务器图片所在路径
	public List<String[]> list;
	public String image_info;//文件名字加上字节数
	public List<String> imgs;//图片文件所有绝对路径

	public static List<String[]> getAllFile(String directoryPath) throws Exception {
		List<String[]> list = new ArrayList<>();
		File baseFile = new File(directoryPath);

		File[] files = baseFile.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				throw new Exception("isDirectory");
			} else {
				String abs = file.getAbsolutePath();
				byte[] tb = ImageTool.image2Bytes(abs);

				list.add(new String[]{abs, String.valueOf(tb.length)});
			}
		}
		return list;
	}



	public CircleData(String nickname,String content,String datetime,String imagepath,String userid) throws Exception {
		this.newnickname = nickname;
		this.content = content;
		this.datetime = datetime;
		this.timestamp_imagepath = imagepath;
		this.userid = userid;
		this.image_abspath = ImageTool.image_root+"\\"+userid+"\\"+imagepath;
		this.list = getAllFile(image_abspath);
		this.image_info = getImageInfo(list);
		this.imgs = getImsArray(list);




	}

	private List<String> getImsArray(List<String[]> list) {
		List<String> st = new ArrayList<>();
		for(String[] sti :list){
			st.add(sti[0]);
		}
		return st;



	}

	private String getImageInfo(List<String[]> list) {
		StringBuilder sb = new StringBuilder();
		int n = list.size();
		int cur = 0;
		for(String[] st :list){
			int end = st[0].split("\\\\").length - 1;
			String name = st[0].split("\\\\")[end];

			sb.append(name).append("<").append(st[1]);
			if(cur != n-1)
				sb.append("<");
		}

		return sb.toString();




	}

}
