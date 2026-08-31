import java.util.Scanner;

public class _0566BarktoUnlock {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pass = sc.nextLine();
		int n=sc.nextInt();
		boolean leftCross=false;
		boolean rightCross=false;
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String temp=sc.nextLine();
			if(temp.equals(pass)) {
				System.out.println("YES");
				return;
			}
			if(temp.charAt(0)==pass.charAt(1)) {
				leftCross=true;
			}
			if(temp.charAt(1)==pass.charAt(0)) {
				rightCross=true;
			}
			if(leftCross && rightCross ) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		

	}

}
