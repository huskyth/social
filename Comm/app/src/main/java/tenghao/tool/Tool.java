package tenghao.tool;

public class Tool {
	public static String publicIp = "192.168.172.1";

	public static int publicCut = 8888;

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

}
