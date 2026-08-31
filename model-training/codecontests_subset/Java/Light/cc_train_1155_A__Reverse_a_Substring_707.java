import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		String S=sc.next();
		for(int i=0; i<S.length()-1; i++) {
			if(S.charAt(i)>S.charAt(i+1)) {
				System.out.println("YES");
				System.out.println((i+1)+" "+(i+2));
				return;
			}
		}
		System.out.println("NO");
	}
}