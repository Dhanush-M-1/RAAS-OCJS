import java.util.*;
import java.io.*;
 import javafx.util.Pair; 
 
 public class Param
{
          
      public static  void main( String[]args) 
    {


	Scanner param = new Scanner(System.in);
	int n=param.nextInt();
	int m=param.nextInt();
	int arr[]=new int[m+1];
	for(int i=0;i<n;i++){
	  arr[param.nextInt()]++;
	}
	int sum=0;
	for(int i=1;i<=m;i++){
	   for(int j=i+1;j<=m;j++){
	      sum+=arr[i]*arr[j];
	   }
	   
	}
	System.out.println(sum);
}
}