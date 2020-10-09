package function.chat;


public class MyMessage {  
	public int type;  
    public String content;
    public String nickname;
    public MyMessage() {  
    }  
    public MyMessage(int type, String nickname,String content) {  
        this.type = type;
        this.nickname = nickname;
        this.content = content;  
    }
    public int getType() {  
        return type;  
    }  
    public void setType(int type) {  
        this.type = type;  
    }
    public String getContent() {
        return content;  
    }
    public void setContent(String content) {  
        this.content = content;  
    }
}  