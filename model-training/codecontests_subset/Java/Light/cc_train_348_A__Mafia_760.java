import java.util.*;
import java.io.*;

public class Main{
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		//PrintStream out = new PrintStream(new FileOutputStream("/Users/akshaykhanna/Desktop/CoolCode.cool"));
        //System.setOut(out);
		int n=sc.nextInt();
		long a[]=new long[n],lo=0,hi=0;
		for(int i=0;i<n;i++) {
			a[i]=sc.nextLong();
			lo=Math.max(a[i], lo);
			hi+=a[i];
		}
		lo--;
		while(lo+1<hi) {
			long mid=(lo+hi)/2,cn=0;
			for(int j=0;j<n;j++) {
				cn+=mid-a[j];
			}
			if(cn>=mid) hi=mid;
			else lo=mid;
		}
		System.out.println(hi);
       }
}