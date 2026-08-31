
//package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		int index = n-1;
		while(index>-1){
		
				if(k%arr[index]==0){
					System.out.println(k/arr[index]);
					break;
				}
				index--;
		}
		sc.close();
	}

}
