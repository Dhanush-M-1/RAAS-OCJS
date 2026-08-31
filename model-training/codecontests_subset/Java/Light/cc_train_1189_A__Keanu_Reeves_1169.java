import java.util.*;
public class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		int freq0=0,freq1=0;
		for(int i=0;i<n;i++)
		{
		    if(s.charAt(i)=='1')
		    freq1++;
		    if(s.charAt(i)=='0')
		    freq0++;
		}
		if(freq1!=freq0){
		System.out.println(1);
		System.out.println(s);}
		else{
		    System.out.println(2);
		    System.out.println(s.charAt(0)+" "+s.substring(1));
		}
	}
}