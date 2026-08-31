import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class anuj{
	public static void main (String[] args) { 
		Scanner scn=new Scanner(System.in);
		int T = scn.nextInt();
		while (T-- > 0) {
			int a=scn.nextInt();
			int b=scn.nextInt();
			int[] arr1=new int[a];
        	for(int i=0;i<arr1.length;i++)   arr1[i]=scn.nextInt();
			int[] arr2=new int[b];
        	for(int i=0;i<arr2.length;i++)   arr2[i]=scn.nextInt();
        	sl(arr1,arr2);
		}

	} 
	public static void sl(int arr1[], int arr2[]){
		
		for(int i=0; i< arr1.length; i++){
			for(int j=0; j< arr2.length; j++){
				if(arr1[i]==arr2[j]){
				    System.out.println("YES");
				    System.out.println("1"+" "+arr1[i]);
				    return;
				}
			}
		}System.out.println("NO");
	}
}