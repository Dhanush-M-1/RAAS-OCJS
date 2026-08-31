
import java.util.*;
import java.lang.*;
import java.math.*;
public class tc_3_1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		while(t-- !=0) {
		int a=scn.nextInt();
		int b=scn.nextInt();
		int n=scn.nextInt();
		if((n+1)%3==0)
			System.out.println(a^b);
		else if((n+1)%3==2)
			System.out.println(b);
		else
			System.out.println(a);
		}
	}

}