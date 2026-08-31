import java.util.*;
import java.lang.*;

public class Solution{

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		int hgt[] = new int[n];
		int ans=2;
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
			hgt[i]=in.nextInt();
		}
		if(n==1) {System.out.println(1);return;}
		boolean flg = false;
		int pt=0;
		for(int i=1;i<n-1;i++){
			if(flg==false){
				int left = arr[i]-hgt[i];
				if(arr[i-1]<left) {ans++;continue;}
				else {int right = arr[i]+hgt[i];
					if(arr[i+1]>right) {ans++;pt=right;flg=true;continue;}
					
				}
			}
			else{
				int left = arr[i]-hgt[i];
				if(pt<left) {ans++;flg=false;continue;}
				else {int right = arr[i]+hgt[i];
				if(arr[i+1]>right) {ans++;pt=right;flg=true;continue;}
				else pt=arr[i];
				}
			}
		
		}
		System.out.println(ans);
	}


}