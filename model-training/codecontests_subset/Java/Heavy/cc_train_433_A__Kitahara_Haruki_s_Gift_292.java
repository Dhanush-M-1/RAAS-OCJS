/*package whatever //do not write package name here */

import java.util.*;

public class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    int sum = 0;
	    for(int i=0;i<n;i++){
	        arr[i] = sc.nextInt();
	        sum+=arr[i];
	    }
	    if(sum%2!=0){
	        System.out.println("NO");
	        return;
	    }
	    sum/=2;
	    Arrays.sort(arr);
	    int i=0;
	    int j=arr.length-1;
	    while(i<j){
	        if(sum>=arr[j]){
	            sum-=arr[j--];
	        } else {
	            sum-=arr[i++];
	        }
	        if(sum==0){
	            System.out.println("YES");
	            return;
	        }
	        if(sum<0){
	            System.out.println("NO");
	            return;
	        }
	    }
	    System.out.println("NO");
	}
	private static boolean get(int arr[], int s, int sum){
	    if(s==arr.length-1 && arr[s]==sum){
	        return true;
	    }
	    if(s==arr.length-1 && arr[s]!=sum){
	        return false;
	    }
	    return get(arr, s+1, sum-arr[s]) || get(arr,s+1,sum);
	}
}