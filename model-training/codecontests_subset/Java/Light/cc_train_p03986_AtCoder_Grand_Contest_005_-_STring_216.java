import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pre = 0;
		String in = sc.next();
		StringBuffer sb = new StringBuffer(in);
		boolean end = false;
		while(!end) {
			end = true;
			for(int i = pre; i < sb.length()-1; i++) {
				if(i + 3 < sb.length() && sb.charAt(i) == 'S' && sb.charAt(i + 1) == 'S' && sb.charAt(i + 2) == 'T' && sb.charAt(i + 3) == 'T') {
					sb = sb.delete(i, i + 4);
					pre = Math.max(i - 1,0);
					end = false;
					break;
				}
				if(sb.charAt(i) == 'S' && sb.charAt(i + 1) == 'T') {
					sb = sb.delete(i, i + 2);
					pre = Math.max(i - 1,0);
					end = false;
					break;
				}
			}
		}
		System.out.println(sb.toString().length());
	}
}