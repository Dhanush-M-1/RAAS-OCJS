import java.util.*;
import java.lang.*;
import java.io.*;

public class Ideone
{

	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int s=in.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
		int index=n;
		for(int i=0;i<n;i++){
		    if(arr[i]>=s){
		        index=i;
		        break;
		    }
		}
		int mid=n/2;
		if(index==mid){
		    System.out.println(arr[index]-s);
		}
		else if(index>mid){
		    long sum=0;
		    for(int i=mid;i<index;i++){
		        sum+=(s-arr[i]);
		    }
		    System.out.println(sum);
		}
		else{
		    long sum=0;
		    for(int i=index;i<=mid;i++){
		        sum+=(arr[i]-s);
		    }
		    System.out.println(sum);
		}

		
	}
}
