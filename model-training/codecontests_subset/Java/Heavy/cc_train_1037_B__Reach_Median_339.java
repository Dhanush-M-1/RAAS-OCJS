import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
		    arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long ans1 = 0, ans2 = 0;
		for(int i = 0; i < n / 2; i++){
		    if(arr[i] > s){
		        ans1 += arr[i] - s;
		    }
		    if(arr[n - i - 1] < s){
		        ans2 += s - arr[n - i - 1];
		    }
		}
		System.out.println(ans1 + ans2 + Math.abs(s - arr[n/2]));
	}
}