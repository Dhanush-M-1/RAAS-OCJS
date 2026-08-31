

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int a[]=new int[n];
		int num[]=new int[200001];
		int cnt[]=new int[200001];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		int ans=Integer.MAX_VALUE;
		for(int i=0; i<n; i++)
	    {
	        int temp=0;
	        int x=a[i];
	        while(x!=0)
	        {
	            cnt[x]++;
	            num[x]+=temp;
	            if(cnt[x]==k) {
	                ans=Math.min(ans,num[x]);
	            }
	            temp++;
	            x/=2;
	        }
	    }
		System.out.println(ans);
	}
}

	 			 		   			   	 	 	 	 	    	