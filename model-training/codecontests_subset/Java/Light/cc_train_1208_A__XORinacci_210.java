// package contest;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int k=0;k<t;k++) {
			long a=scan.nextLong();
			long b=scan.nextLong();
			long n=scan.nextLong();
			n=n%3;
			long c=a^b;
			if(n==0) {
				c=a;
			}
			else if(n==1) {
				c=b;
			}
			System.out.println(c);
		}

	}

}
