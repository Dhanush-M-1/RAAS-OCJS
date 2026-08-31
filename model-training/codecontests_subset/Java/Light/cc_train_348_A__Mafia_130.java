import java.util.*;
import java.io.*;


public class C {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}		
		sc.close();
		Arrays.sort(a);
		
		long max = a[n-1];
		long sum = 0;
		for(int i=0;i<n;i++){
			sum+=(max-a[i]);
		}
		long res = 0;
		if(sum>=max){
			res = max;
		}
		else{
			long remain = max-sum;
			long total = remain * n;
			long t = total/(n-1);
			if(total % (n-1) == 0)
				res = sum+t;
			else
				res = sum+t+1;
		}	
		
		out.println(res);
		out.flush();
	}
}
