import java.util.Scanner;
import java.util.Arrays;
public class ques {
	static Scanner scn = new Scanner(System.in);
public static void main(String[] args) {
		int n=scn.nextInt();
		while(n!=0)
		{
			int a=scn.nextInt();
			int b=scn.nextInt();
			int c=scn.nextInt();
			if(c%3==0)	System.out.println(a);
			else if(c%3==1)System.out.println(b);
			else
				System.out.println(a^b);
			
			n--;
		}
	
}


}
