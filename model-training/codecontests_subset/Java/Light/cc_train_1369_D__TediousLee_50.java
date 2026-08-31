import java.util.*;
import java.io.*;
public class GFG {
      public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int t=sc.nextInt();
		int m=1000000007;
		int arr[]=new int[2000001];
		arr[1]=0;
		arr[2]=0;
		for(int i=3;i<2000001;i++)
		arr[i]=(arr[i-1]%m+(2*arr[i-2])%m+(i%3==0?4:0))%m;
		while(t-->0){
		   int n=sc.nextInt();
		   System.out.println(arr[n]);
		}
    }
}