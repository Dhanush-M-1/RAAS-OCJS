import java.applet.Applet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Sol1  extends Applet {

	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0)
		{
			long a=sc.nextLong();
			long b=sc.nextLong();
			long n=sc.nextLong();
			if(n==0)
				System.out.println(a);
			else if(n==1)
				System.out.println(b);
			else
			{ 
				long xor=a^b;
				if(n%3==0)
					System.out.println(a);
				else if(n%3==1)
					System.out.println(b);
				else
					System.out.println(xor);
			}
		}
	}

}
