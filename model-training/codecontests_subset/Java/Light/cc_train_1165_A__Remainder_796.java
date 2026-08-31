import java.util.Scanner;

public class _0902Remainder {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		int count=0;
		for(int i=n-x;i<n;i++) {
			char t=s.charAt(i);
			if(i==n-y-1) {
				if(t=='0')count++;
			}
			else {
				if(t=='1') {
					count++;
				}
			}
			//System.out.println(count);
		}
		System.out.println(count);
	}

}
