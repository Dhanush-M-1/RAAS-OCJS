import java.util.Scanner;

public class Main { 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextInt();
		char[] s = in.next().toCharArray();
		for(int i=0;i<s.length-1;++i) {
			if(s[i]>s[i+1]) {
				System.out.println("YES");
				System.out.println((i+1) + " " + (i+2));
				return;
			}
		}
		System.out.println("NO");
	}
	

}
