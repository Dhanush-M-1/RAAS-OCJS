import java.util.Scanner;
public class Main{

   	public static void main(String[] args){
   		Scanner in=new Scanner(System.in);
   		double x1,x2,e;
   		long a,b,c;
   		a=in.nextLong();
   		b=in.nextLong();
   		c=in.nextLong();
   		e=Math.pow(b,2)-4*a*c;
   		if(a==0)
   		{
   			if(b!=0) {System.out.println(1);System.out.format("%.10f",1.0*(-c)/b);}
   			else if(b==0&&c!=0)System.out.print(0);
   			else if(b==0&&c==0)System.out.print(-1);
   		}
   		else
   		{if(e<0)System.out.println(0);
   		else if(e>0)
   		{
   			x1=(-b-Math.sqrt(e))/(2*a);x2=(-b+Math.sqrt(e))/(2*a);
   			System.out.println(2);
   			System.out.format("%.10f\n%.10f",x1<x2?x1:x2,x1>x2?x1:x2);
   		}
   		else if(e==0)
   			{
   			System.out.println(1);
   			System.out.format("%.10f",-b*1.0/(2*a));
   			}}
   	}
}