import java.util.*;
 
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int[] arr=new int[n];
		    int k=n/2-1;
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    while((k>=0)&&(k+1<n)&&(arr[k]==arr[k+1]))
		    k--;
		    int[] brr={0,0,0};
		    brr[0]=1;
		    while((brr[0]<=k)&&(arr[brr[0]]==arr[brr[0]-1]))
		    brr[0]++;
		    brr[1]=2*brr[0]<=k?brr[0]+1:0;
		    if(brr[1]>0)
		    {
		        while((brr[1]+brr[0]<=k)&&(arr[brr[1]+brr[0]]==arr[brr[1]+brr[0]-1]))
		        brr[1]++;
		    }
		    brr[2]=Math.max(0,k+1-brr[0]-brr[1]);
		    if(brr[2]<=brr[0]||brr[1]<=brr[0])
		    brr[0]=brr[1]=brr[2]=0;
		    System.out.println(brr[0]+" "+brr[1]+" "+brr[2]);
		}
	}
}