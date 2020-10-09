package content.write;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myCircleContent {

	public String newnickname;
	public String content;
	public String datetime;
	public String timestamp_imagepath;//毫秒级别时间，也就是图片文件夹名字
	public String userid;
	public String image_abspath;//服务器图片所在路径
	public List<String[]> list;
	public String image_info;//文件名字加上字节数
	public String[] imgs;//图片文件所有绝对路径
	public ArrayList<String[]> name_byte;
	public myCircleContent(String nickname,String content,String datetime,
						   String imagepath,String userid,String image_info){
		this.newnickname = nickname;
		this.content = content;
		this.datetime = datetime;
		this.timestamp_imagepath = imagepath;
		this.userid = userid;
		this.image_info = image_info;
		name_byte = new ArrayList<>();
		String[] t = image_info.split("<");

		int n = t.length;
		int gp = n / 2;
		for (int i = 0;i < gp;i++){
			name_byte.add(new String[]{t[i*2], t[2*i+1]});
		}











	}

	@Override
	public String toString() {
		return "myCircleContent{" +
				"newnickname='" + newnickname + '\'' +
				", content='" + content + '\'' +
				", datetime='" + datetime + '\'' +
				", timestamp_imagepath='" + timestamp_imagepath + '\'' +
				", userid='" + userid + '\'' +
				", image_abspath='" + image_abspath + '\'' +
				", list=" + list +
				", image_info='" + image_info + '\'' +
				", imgs=" + Arrays.toString(imgs) +
				'}';
	}
}
