import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	
	static PrintWriter pr;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		pr = new PrintWriter(System.out);
		int n = sc.nextInt();
		int a[] = new int[n];
		int max=0;
		int b = 0;
		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
			max = Math.max(max, a[i]);
			b+=a[i];
		}
		
		for(int k=max; k<=100000; k++){
			int sum=0;
			for(int i=0; i<n; i++)
				sum+=(k-a[i]);
			if(sum>b){
				pr.println(k);
				pr.close();
				return;
			}
		}
		pr.close();
	}
	
	
}