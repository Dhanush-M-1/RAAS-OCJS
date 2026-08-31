import java.util.*;

public class Permutation
{
    static int findmax(int []arr,int i,int j)
    {
        int max=0;
        int ind=0;
        for(int k=i;k<=j;k++)
        {
            if(max<arr[k])
            {
                max=arr[k];
                ind=k;
            }
        }
        return(ind);
    }
    static void find(int []arr,int i,int j,int []ar1,int s)
    {
        int max=findmax(arr,i,j);
        ar1[max]=s;
        s++;
        if(i<max&&j>max)
        {
            find(arr,i,max-1,ar1,s);
            find(arr,max+1,j,ar1,s);
        }
        else if(i==max&&j>max)
        {
            find(arr,max+1,j,ar1,s);
        }
        else if(i<max&&j==max)
        {
            find(arr,i,max-1,ar1,s);
        }
        
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int j=0;j<t;j++)
		{
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    int ar1[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    find(arr,0,n-1,ar1,0);
		    for(int i=0;i<n;i++)
		    {
		        System.out.println(ar1[i]);
		    }
		    
		}
	}
}
