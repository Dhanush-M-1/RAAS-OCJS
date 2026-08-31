import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] ch = new char[str.length()];
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
			if (ch[i] == '+') {
				count++;
			}
		}
		Arrays.sort(ch);
		for(int i = count; i < ch.length; i++) {
			if (i == count) {
				System.out.print(ch[i]);
			} else {	
				System.out.print("+" + ch[i]);
			}
		}
	}
}