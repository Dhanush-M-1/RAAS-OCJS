import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner scn=new Scanner(System.in);
	int test=scn.nextInt();
	while(test-->0){
	    int n=scn.nextInt();
	    int []arr=new int[n];
	    for(int i=0;i<n;i++){
	        arr[i]=scn.nextInt();
	    }
	    if(arr[0]+arr[1]<=arr[arr.length-1]){
	        System.out.println(1+" "+2+" "+arr.length);
	    }else{
	        System.out.println(-1);
	    }
	}
	}
}
