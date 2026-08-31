import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {	
		Scanner s =new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int x[]=new int[n];
		//int y[][]=new int[n][];
		
		int z[]=new int[m+1];z[0]=1;
		
		for(int i=0;i<n;i++){
			x[i]=s.nextInt();
			for(int j=0;j<x[i];j++){
			
				z[s.nextInt()]++;
			}
		}
		Arrays.sort(z);
		if(z[0]==0)System.out.println("NO");
		else System.out.println("YES");
	}
}