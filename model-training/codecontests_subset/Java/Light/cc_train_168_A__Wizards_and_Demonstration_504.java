import java.util.*;
import java.lang.Math;
public class Main
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	    int n= sc.nextInt();
	    int w=sc.nextInt();
	    int y=sc.nextInt();
	    int p=(int)Math.ceil(n*y*.01); 
	    p=p-w;
	    if(p<0)
	    System.out.print("0");
	    else
	    System.out.print(p);
	}
	
}
