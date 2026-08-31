import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String in=s.next();
		int depth=0;
		int count=0;
		for(int i=0;i<in.length();i++) {
			switch (in.charAt(i)) {
			case'T':
				if(depth==0) count++;
				else depth--;
				break;
			case'S':
				depth++;
				break;
			}
		}
		System.out.println(count*2);
	}
}
