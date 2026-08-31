
	import java.util.*;
	import java.io.*;
	
	public class RunForYourPrize {
	
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int n=Integer.parseInt(br.readLine());
			 	String arr[]=br.readLine().split(" ");
			 	
			 	int arr2[]=new int [n];
			 	for(int i=0;i<n;i++) {
			 		arr2[i]=Integer.parseInt(arr[i]);
			 	}
			 	
			 	int t1=1;
			 	int t2=1000000;
			 	int t3=1000000;
			 	int ans1=0;
			 	int ans2=0;
			 	for(int i=0;i<n;i++) {
			 		if((arr2[i]-t1)<(t2-arr2[i])) {
			 			
			 			ans1=ans1+(arr2[i]-t1);
			 			t2=t2-(arr2[i]-t1);
			 			t1=arr2[i];
			 		}
			 		
			 		else {
			 			ans2=t3-arr2[i];
			 			break;
			 		}
			 	}
			 	
			 
			 	System.out.println(Math.max(ans1,ans2));
			 	
		}
	
	}
