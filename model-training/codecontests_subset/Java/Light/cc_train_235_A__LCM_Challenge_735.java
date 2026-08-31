import java.util.Scanner;

public class C_LCM_Challenge {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
//	System.out.println((long)n*(n-1)*(n-2)+" "+lcm(n,n-1,n-2));
	long ans=0;
	for (int a = Math.max(1, n-50); a <=n; a++) {
		for (int b = a; b <=n; b++) {
			for (int c = b; c <=n; c++) {
				ans=Math.max(ans, lcm(a,b,c));
				;
			}
		}
	}
	System.out.print(ans);
}
private static int gcd(int a,int b) {
	return (b==0 ? a:gcd(b,a%b));
}
private static long lcm(int a,int b,int c){
	return ((long)a*b*c)/((long)gcd(a,b)*gcd(b,c)*gcd(a,c));
}


}
