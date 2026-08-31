import java.util.*;
import java.lang.*;
import java.io.*;

public class S1354C1{
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);

		int t=sc.nextInt();
		while(t-->0){
		double n=sc.nextInt();
		double an=Math.PI/(2*n);
		double an2=Math.PI/(4*n);

		double ans=Math.cos(an2)/Math.sin(an);

		System.out.println(ans);
	}
}
}
