//package codeforces;

import java.util.Scanner;

public class A348 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int [n];
		int max=0;
		double sum=0;
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
			
			if(max<arr[i])
				max=arr[i];
			
		}
		long ans=(long)Math.ceil(sum/(n-1));
		if(ans>=max)
			System.out.println(ans);
		else
			System.out.println(max);

	}

}
