import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String str = scanner.next();
		int zeros = 0;
		for(int i=0;i<str.length();++i) {
			if(str.charAt(i)=='0')
				zeros++;
		}
		int ones = str.length() - zeros;
		if(zeros != ones) {
			System.out.println("1");
			System.out.println(str);
		} else {
			System.out.println("2");
			System.out.println(str.substring(0,str.length()-1)+" "+str.charAt(str.length()-1));
		}
	}
}
