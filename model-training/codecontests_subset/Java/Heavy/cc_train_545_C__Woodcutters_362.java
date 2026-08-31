


import java.util.Arrays;
import java.util.Scanner;


public class Watermelon {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		long[]arr1=new long[n];
		long[]arr2=new long[n];
		for(int i=0;i<n;i++) {
			arr1[i]=scanner.nextLong();
			arr2[i]=scanner.nextLong();
		}
		System.out.println(woodCutter(arr1,arr2));
		

	}
	
	public static int woodCutter(long[]arr1,long[]arr2) {
		int result=1;
		int len=arr1.length;
		for(int i=1;i<len-1;i++) {
			if(arr1[i]-arr2[i]>arr1[i-1])result++;
			else if(arr1[i]+arr2[i]<arr1[i+1]) {
				result++;
				arr1[i]=arr1[i]+arr2[i];
			}
		}
		if(len>1)result++;
		return result;
	}
}
