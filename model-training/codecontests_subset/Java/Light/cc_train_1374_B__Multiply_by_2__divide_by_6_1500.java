import java.util.*;
import java.lang.*;
import java.io.*;
public class j9
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0){
			long n=in.nextLong();
			if(n==1){
				System.out.println(0);
				continue;
			}
		 if(n%3==0){
		 	int l=0;
				while(n!=1){
					if(n<10){
						break;
					}
					else if(n%6==0){
						n=n/6;
					}
					else{
						n=n*2;
					}
					l++;
				}
				if(n==1){
				System.out.println(l);
			    }
				else if(n==6){
					System.out.println(l+1);
				}
				else if(n==3){
					System.out.println(l+2);
				}
				else if(n==9){
					System.out.println(l+4);
				}
				else{
					System.out.println(-1);
				}
			}
		
			else{
				System.out.println(-1);
			}
		}
	}
}       