import java.util.*;
public class GFG {
   public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
		    while (t-->0)
		    {
		        int n=sc.nextInt();
		        int arr[]=new int[n];
		        int a=-1,b=n;
		        for(int i=0;i<n;i++)
		        arr[i]=sc.nextInt();
		        for(int i=0;i<n;i++)
		        {
		            if(arr[i]>=i){
		            a=i;continue;}
		            break;
		        }
		        for(int i=n-1;i>=0;i--)
		        {
		            if(arr[i]>=(n-1)-i)
		            {b=i;continue;}
		            break;
		        }
		        if(b<=a){
		        System.out.println("Yes");continue;}
		        System.out.println("No");
		    }
   }
}