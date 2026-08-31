import java.util.Scanner;

public class _0725ReverseaSubstring {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();
		sc.nextLine();
		String s=sc.nextLine();
		for(int i=1;i<n;i++) {
			if(s.charAt(i)<s.charAt(i-1)) {
				System.out.println("YES");
				System.out.println((i)+" "+(i+1));
				return;
			}
		}
		System.out.println("NO");
	}

}
