
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A822 {

	 public static void solve(int v0,int c,int a,int l,int v1) {
			int pos = v0;
			int t = 1;
			
			int add = v0;
			
			
			while(pos < c) {
				add = Math.min(v1, add + a);
				
				pos += add - l;
				t++;
			}
			
			System.out.println(t);
		}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int c=in.nextInt(),v0=in.nextInt(),v1=in.nextInt(),a=in.nextInt(),l=in.nextInt();
		solve(v0, c, a, l,v1);

	
	}
}
