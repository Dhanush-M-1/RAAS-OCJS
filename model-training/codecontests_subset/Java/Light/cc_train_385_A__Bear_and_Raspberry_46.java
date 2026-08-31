
import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int n=sc.nextInt();
		int c=sc.nextInt();
		int mat[]=new int[n];
		for(int i=0;i<n;i++) {
			
			mat[i]=sc.nextInt();
		}
		int max=Integer.MIN_VALUE;

		for(int i=0;i<n-1;i++) {
			max=Math.max(max, mat[i]-mat[i+1]);
		}
		System.out.println(max-c>0?max-c:0);
	} 
	
	}