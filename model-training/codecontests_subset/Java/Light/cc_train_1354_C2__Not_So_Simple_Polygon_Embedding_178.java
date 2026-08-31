

import java.util.*;
	public class pract {
		 static int mysol(int n){
	    	 int arr[]=new int[n];
	    	 for(int i=0;i<n;i++)
	    		 arr[i]=i;
	    	 return n*2;
		 }
		
		 
	 public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
		 int mt=scn.nextInt();
		 int mtcs=0;
		 for(int ll=0;ll<5;ll++){
			 int r=mysol(ll);
		 }
		 StringBuilder res=new StringBuilder();
		 while (mtcs++ < mt) {
				int mn = scn.nextInt();
				double mx = Math.PI / (4 * mn);
				double ans = Math.sin(mx) * 2;
				ans = 1 / ans;
				res.append(ans + "\n");
			}
			System.out.print(res);
		}

		
	 
	}