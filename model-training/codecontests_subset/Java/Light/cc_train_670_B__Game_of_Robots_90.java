import java.util.*;
import java.lang.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt(),k=sc.nextInt();
	    int a[]=new int[n+1];
	    for(int i=1;i<=n;i++){
	        a[i]=sc.nextInt();
	    }
	    int cur=0,i=0;
	    for(i=1;cur+i<k;i++){
	        cur+=i;
	    }
	    System.out.println(a[k-cur]);
	}
}