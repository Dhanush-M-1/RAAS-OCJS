
import java.util.Scanner;

public class Bearman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int c = sc.nextInt();
       int a[] = new int [n];
       for(int i=0;i<n;i++) {
    	   a[i]= sc.nextInt();
       }
       int max =0;
       int sum =0;
       for(int i=0;i<n-1;i++) {
    	sum =a[i]-a[i+1];
    	max =Math.max(max, sum);
       }
        int ans = max-c;
        if(ans>=0) {
        	System.out.println(ans);
        }else {
        	System.out.println(0);
        }
       }

}
