import java.util.*;

public class A {
public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int n=in.nextInt(),x=in.nextInt(),y=in.nextInt();
	double ans = y*n/100.0 - x;
	if (ans<0) ans =0;
	if (ans==(long)ans) System.out.println((int)ans); else System.out.println((long)ans+1);
	
	
 }
}
