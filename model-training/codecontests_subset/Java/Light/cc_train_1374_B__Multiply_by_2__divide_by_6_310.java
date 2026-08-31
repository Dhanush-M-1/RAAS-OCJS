import java.util.*;
import java.io.*;
public class GFG {
      public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int t=sc.nextInt();
		while (t-->0)
		{
		    int n=sc.nextInt();
		    int c=0,f=0;
		    while(n>1)
		    {
		        if(n%6!=0&&n%3!=0){f=1;
		        break;}
		        if(n%6==0){
		        n/=6;c++;continue;}
		        if(n%3==0){c+=2;n/=3;continue;}
		    }
		    out.println(f==0?c:-1);
		    out.flush();
		}
      }
}