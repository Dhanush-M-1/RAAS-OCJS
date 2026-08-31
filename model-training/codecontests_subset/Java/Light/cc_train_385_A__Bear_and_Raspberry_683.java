import java.util.Scanner;


public class BearAndRaspberry {


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int c = in.nextInt();
		
		int ans = 0;
		
		int [] a = new int[n];
		
		for(int i = 0; i < n; i++){
			a[i] = in.nextInt();
		}
		
		for(int i = 1; i < a.length; i++){
			
			ans = Math.max(ans, a[i-1]-a[i]-c);
		}
		System.out.println(Math.max(0,ans));
	}

}
