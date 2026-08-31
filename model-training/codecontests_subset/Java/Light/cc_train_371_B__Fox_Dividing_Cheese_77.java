import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
	public static int gcd ( int a, int b ) { 
		   if ( b == 0 ) return a;
		   return gcd ( b, a % b );
		}

	public static void main(String[] args) {
		Scanner Ahmad=new Scanner(System.in);
		int a,b,count=0,count1=0;
		a=Ahmad.nextInt();
		b=Ahmad.nextInt();
		if(a!=b) {
			int g=gcd(a,b);
			a=a/g;
			b=b/g;
		}
		while(a!=1&&a!=b) {
			
			if(a%2==0||a%3==0||a%5==0) {
				count++;
				if(a%2==0) {
					a=a/2;
				}
				else if(a%3==0) {
					a=a-(a/3)*2;
				}
				else  {
					a=a-(a/5)*4;
				}
			}
			
			else {
				break;
			}
			
		}
		while(b!=1&&a!=b) {
			
			if(b%2==0||b%3==0||b%5==0) {
				count1++;
				if(b%2==0) {
					b=b/2;
				}
				else if(b%3==0) {
					b=b-(b/3)*2;
				}
				else  {
					b=b-(b/5)*4;
				}
			}
			
			else {
				break;
			}
			
		}
		if(a==b) {
			System.out.println((count+count1));
		}
		else {
			System.out.println(-1);
		}
	}
}
	  	  	    	  				 	  				    	