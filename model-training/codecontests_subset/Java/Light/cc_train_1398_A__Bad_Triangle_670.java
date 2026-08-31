import java.util.*;
import java.io.*;
public class Answer {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		while(t-->0) {
			int n;
			n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)arr[i]=sc.nextInt();
			System.out.println(arr[0] + arr[1]<= arr[n-1] ? "1 2 "+n:-1);
			
		}
	}


}
