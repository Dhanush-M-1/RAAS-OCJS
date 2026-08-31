import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		Scanner scn =  new Scanner(System.in);
		String str = scn.nextLine();
		String key = "keyence";
		String buf,buf2;
		boolean ans = false;
		for(int i = 0;i <= 7;i++) {
			buf = str.substring(0, i);
			buf2 = str.substring(str.length() - (7-i));
			ans |= key.equals(buf + buf2);
		}
		System.out.println(ans?"YES":"NO");
	}
}
