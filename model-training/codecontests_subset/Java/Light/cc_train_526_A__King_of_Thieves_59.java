import java.util.Scanner;

public class Code {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		boolean t = true;
		for(int i=0;i<s.length()&& t;i++) {
			if(s.charAt(i)=='*') {
				for(int j=1;i+4*j<s.length();j++) {
					if(s.charAt(i+j)=='*' && s.charAt(i+2*j)=='*' && s.charAt(i+3*j)=='*' && s.charAt(i+4*j)=='*') {
						System.out.println("yes");
						t= false;
						break;
					}
				}
			}
		}
		if(t) {
			System.out.println("no");
		}
	}

}