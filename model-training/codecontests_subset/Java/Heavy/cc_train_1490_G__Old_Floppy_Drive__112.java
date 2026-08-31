/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anand
 */
import java.util.*;

public class Solution7 {
    public static void main(String[]   args){
        Scanner inp =  new Scanner(System.in);
      int t=inp.nextInt();
		while(t-->0){
			int n=inp.nextInt();
			int m=inp.nextInt();
			long a[]=new long[n];
                        for(int i=0;i<n;i++){
                            a[i]= inp.nextLong();
                        }
			//input(a,n);
			long x[]=new long[m];
                        for(int i=0;i<m;i++){
                            x[i]= inp.nextLong();
                        }
			//input(x,m);
			long bestPref[]=new long[n+1];
			long sum=0;
			for(int i=0;i<n;i++) {
				sum+=a[i];
				bestPref[i+1]=Math.max(bestPref[i], sum);
			}
			for(long cur: x) {
				if(sum<=0 && bestPref[n]<cur) {
					System.out.print("-1 ");
					continue;
				}
				if(bestPref[n]>=cur) {
					System.out.print((go(bestPref,n,cur)-1)+" ");
					continue;
				}
				long cycles=((cur-bestPref[n])+(sum-1))/sum;
				long gg=cycles*n;
				long rem=cur-cycles*sum;
				System.out.print((gg+go(bestPref,n,rem)-1)+" ");
			}
			System.out.println();
		}

    }
    static long go(long bestPref[], int n, long cur) {
		int left=1,right=n,ans=n;
		while(left<=right) {
			int mid=left+right>>1;
			if(bestPref[mid]>=cur) {
				ans=mid;
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return ans;
	}
    
}
