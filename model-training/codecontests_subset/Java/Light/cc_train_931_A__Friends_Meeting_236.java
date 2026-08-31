import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
public class Main {
static int fun(int n) {
		if(n==1) {
			return 1;
		}
		return fun(n-1)+(n-1)*4;
	}
	public static void main(String[] args) {
                  Scanner sc = new Scanner(System.in);
////		    int t = sc.nextInt();
////		    while(t-->0) {
//		        int n = sc.nextInt();
//		        int sum1 = 0;
//		        int sum2 = 0;
//		        int a[] = new int[n];
//		        for(int i=0;i<n;i++) {
//		        	a[i] = sc.nextInt();
//		        	sum1+=a[i];
//		        }
//		        
//		        int b[] = new int[n];
//		        for(int i=0;i<n;i++) {
//		        	b[i] = sc.nextInt();
//		        	sum2+=b[i];
//		        }
//		        if(sum2>sum1) System.out.println("Yes");
//		        else System.out.println("No");
//		    }
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int diff = Math.abs(a-b);
		    if(diff%2==0) System.out.println((diff*(diff+2))/4);
		    else System.out.println(((diff-1)*(diff+1))/4+(diff/2)+1);
}}