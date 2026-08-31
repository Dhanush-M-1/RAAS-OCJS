
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class NewClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-->0) {
			int n=sc.nextInt();
			String a="", b="", c="", d="";
			for (int i=1; i<=n; i++) {
				String s=sc.next();
				if (i==1) {
					a=s;
				}
				if (i==2) {
					b=s;
				}
				if (i==(n-1)) {
					c=s;
				}
				if (i==n) {
					d=s;
				}
			}
			if (a.charAt(1)==b.charAt(0)&&c.charAt(n-1)==d.charAt(n-2)) {
				if (a.charAt(1)!=c.charAt(n-1)) {
					System.out.println("0");
				}
				else {
					System.out.println("2");
					System.out.println((n-1)+" "+n);
					System.out.println(n+" "+(n-1));
				}
			}
			else if (a.charAt(1)==b.charAt(0)) {
				System.out.println("1");
				if (a.charAt(1)==c.charAt(n-1)) {
					
					System.out.println((n-1)+" "+n);
				}
				else {
		
					System.out.println(n+" "+(n-1));
				}
			}
			else if(c.charAt(n-1)==d.charAt(n-2))
			{System.out.println("1");
			if(c.charAt(n-1)==a.charAt(1))
			{
				System.out.println("1 2");
			}
			else{
				System.out.println("2 1");
			}
			}
			else if(a.charAt(1)!=b.charAt(0))
			{
				System.out.println("2");
				if(a.charAt(1)==c.charAt(n-1)){
					System.out.println("1 2");
					System.out.println(n+" "+(n-1));
				}
				else 
				{
					System.out.println("1 2");
					System.out.println((n-1)+" "+n);
				}
				
			}
		}
	}
}

