/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());*/
// 		StringTokenizer st=new StringTokenizer(br.readLine());
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t=1;t<=T;t++){
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int[]a=new int[n];
		    int[]arr=new int[1000];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        arr[a[i]-1]=1;
		    }
		    int[]b=new int[m];
		    boolean ans=false;
		    for(int i=0;i<m;i++){
		        b[i]=sc.nextInt();
		    }
		    for(int i=0;i<m;i++){
		        if(arr[b[i]-1]==1){
		            ans=true;
		            System.out.println("YES\n1 "+b[i]);
		            break;
		        }
		    }
		    if(!ans){
		        System.out.println("NO");
		    }
		}
	}
}
