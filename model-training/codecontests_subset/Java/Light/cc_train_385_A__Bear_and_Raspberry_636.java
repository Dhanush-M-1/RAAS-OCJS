import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int r=sc.nextInt();
	    int[] arr=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        arr[i]=sc.nextInt();
	    }int hd=0;int s=0;int e=0;
	    for(int i=0;i<n-1;i++)
	    {
	        if(arr[i]>arr[i+1])
	        {
	            if(hd<arr[i]-arr[i+1])
	            {
	                s=i;e=i+1;
	                hd=arr[i]-arr[i+1];
	            }
	        }
	    }
	    if(arr[s]-arr[e]-r<=0)
	    {
	        System.out.println("0");
	    }
	    else{
	        System.out.println(arr[s]-arr[e]-r);
	    }
	
	}
}