// package Round676;
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class typeB
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int t=0;t<T;t++){
		   int n = s.nextInt();
		   int[][] arr = new int[n][n];
		   for(int i=0;i<n;i++){
		       char[] str=s.next().toCharArray();
		       for(int j=0;j<n;j++){
		           arr[i][j] = (str[j]-'0');
		       }
		   }
		 
		   int cnt0 = 0;
		   int cnt1 = 0;
		   cnt1+=(arr[0][1]+arr[1][0]+arr[n-1][n-2]+arr[n-2][n-1]);
		   cnt0 = (4-cnt1);
		   if(cnt0==0 || cnt1==0){
		       System.out.println(2);
		       System.out.println(1+" "+2);
		       System.out.println(2+" "+1);
		   }
		   else if(cnt1==cnt0){
		       if(arr[0][1]==arr[1][0])System.out.println(0);
		       else{
		    	   System.out.println(2);
		           System.out.println(1+" "+2);
		           if(arr[n-1][n-2]!=arr[0][1]){
		               System.out.println(n+" "+(n-1));
		           }else System.out.println((n-1)+" "+n);
		       }
		   }else{
		       System.out.println(1);
		       if(arr[0][1]==arr[1][0]){
		            if(arr[n-1][n-2]!=arr[0][1]){
		                System.out.println((n-1)+" "+n);
		            }else{
		                 System.out.println(n+" "+(n-1));
		            }
		       }else{
		           if(arr[n-1][n-2]!=arr[0][1]) System.out.println(2+" "+1);
		           else System.out.println(1+" "+2);
		       }
		       
		   }
		  
		}
		
	}
}