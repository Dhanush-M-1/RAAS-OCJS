import java.util.*;
import java.io.*;
 
public class A {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		long l,r,d;
		while(t > 0){
			t--;
			l = sc.nextLong();
			r = sc.nextLong();
			d = sc.nextLong();
			if(d<l)
				System.out.println(d);
			else {
				long x = r/d;
				x++;
				long ans = x*d;
				System.out.println(ans);
			}
		}
	}
}