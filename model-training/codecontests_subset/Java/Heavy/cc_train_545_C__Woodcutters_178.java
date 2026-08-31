import java.util.Arrays;
import java.util.Scanner;


public class WoodCutters {
	static long [] arr; 
	static long[] height;
	static int n;
	static int memo[];
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new long [(int) (1e5+5)];
		height = new long [(int) (1e5+5)];
		memo= new int [n];
		Arrays.fill(arr, -1);
		Arrays.fill(memo, -1);
		
		for(int  i = 0 ; i<  n ; i++){
			arr[i]=sc.nextLong();
			height[i]=sc.nextLong();
		}
		
		int count  = n  == 1 ? 1 : 2;
		for(int i = 1 ; i < n-1 ; i++){
			
			if(arr[i]-height[i]>arr[i-1])
				count++;
			
			else if(arr[i]+height[i]<arr[i+1]){
				count++;
				arr[i]+=height[i];
				}
		
		}
		System.out.println(count);
		/*
		if(n==1)System.out.println(1);
		else System.out.println(2+dp(1));
	*/}
	static int dp (int i ){
		if(i == (n-1))return 0;
		
		if(memo[i]!=-1)return memo[i];
		
		int stay=0;
		int left=0;
		int right=0;
		
		stay=dp(i+1);
	//	System.out.println("KHLST STAY "+i);
		if(arr[i]-height[i]>arr[i-1]){
			left=1+dp(i+1);
		}
		if(arr[i]+height[i]<arr[i+1]){
			arr[i] += height[i];
			right=1+dp(i+1);
		}
		
		return memo[i]=Math.max(left,Math.max(right, stay));
	}
	
}