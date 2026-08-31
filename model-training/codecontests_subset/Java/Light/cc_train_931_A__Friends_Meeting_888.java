import java.util.*;
public class r468a {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = Math.abs(a-b);
		int ans;
		if(n%2 != 0) {
			n = n/2;
			ans =n*(n+1)+n+1;
		}
		else {
			n = n/2;
			ans = n*(n+1);
		}
		System.out.println(ans);
		
	}
	
}
