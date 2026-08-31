import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int m=sc.nextInt();
	    while(m-->0){
	        int a=sc.nextInt(),b=sc.nextInt(),n=sc.nextInt();
	        if(n%3==0)System.out.println(a);
	        else if(n%3==1)System.out.println(b);
	        else if(n%3==2)System.out.println(a^b);
	    }
	}
}