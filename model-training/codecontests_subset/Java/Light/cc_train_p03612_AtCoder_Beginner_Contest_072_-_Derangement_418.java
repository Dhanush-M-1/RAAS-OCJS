import java.util.*;
import java.io.*;
 
public class Main {
 
	public static void main(String[] args)throws IOException {
		Scanner sc =new Scanner(System.in);
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int A = sc.nextInt();
		int[]arr = new int[A];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
			sc.close();
		int howmany =0;
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] == i+1) {
				swap(arr,i);
				howmany += 1;
			}
		}
		
		System.out.println(howmany);
 
	}
	
	public static void swap(int[] arr, int j) {
		if(j != arr.length-1) {
			int a = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = a;
		}
	}
 
}