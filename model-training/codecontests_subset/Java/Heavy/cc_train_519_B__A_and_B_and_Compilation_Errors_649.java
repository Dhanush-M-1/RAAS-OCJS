import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.*;
import java.math.BigInteger;
public class test {
	public static void main (String [] test)  {
		Scanner in = new Scanner (System.in);
	int n = in.nextInt();int num ;
	long sum1 = 0 ;
	long sum2 = 0 ;
	long sum3 = 0  ;
	
	//int arr1 [] = new int [n];   // to save memory
	//int arr2 [] = new int [n-1];
	//int arr3 [] = new int [n-2];
   for(int i = 0 ; i<n ; i++){
	   num=in.nextInt();
		sum1+=num;
	}
	for(int i = 0 ; i<n-1 ; i++){
		num=in.nextInt();
		sum2+=num;
	}
	for(int i = 0 ; i<n-2 ; i++){
		num=in.nextInt();
		sum3+=num;
	}
	System.out.println(sum1-sum2);
	System.out.println(sum2-sum3);

	
		
	
   
   
   
	
	
	
	}
	
}