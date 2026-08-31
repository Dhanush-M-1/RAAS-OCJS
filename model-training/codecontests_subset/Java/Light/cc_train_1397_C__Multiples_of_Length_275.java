import java.util.*;
import java.lang.*;
import java.io.*;
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	   // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=1;
	    //t=sc.nextInt();
	   // int t=Integer.parseInt(br.readLine());
	    while(--t>=0){
	        int n=sc.nextInt();
	         //     int n=Integer.parseInt(br.readLine());
	          //     int k=sc.nextInt();
	          //    String s=br.readLine();
	         //     StringTokenizer st=new StringTokenizer(br.readLine());
	         //      int n=Integer.parseInt(st.nextToken());
	         long a[]=new long[n];
	        for(int i=0;i<n;i++)a[i]=sc.nextLong();
	        
	        
	     
	        System.out.println(1+" "+n);
	        
	        for(int i=0;i<n-1;i++){
	            
	           long ans=(long)(a[i])*(long)(n)*(-1l);
	            System.out.print(ans+" ");
	        }
	        System.out.println(0);
	        if(n==1){
	            System.out.println(1+" "+1);
	            System.out.println(0);
	        }
	        else{
	        System.out.println(1+" "+(n-1));
	        for(int i=0;i<n-1;i++){
	              long ans;
	            ans=(long)(a[i])*(long)(n-1);
	            System.out.print(ans+" ");
	        }
	        System.out.println();
	        }
	        System.out.println(n+" "+n);
	        System.out.println(a[n-1]*(-1));
	        
	        
	        
	    }
	    
	}
}
