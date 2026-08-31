import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int t=sc.nextInt();
		while(t--!=0) {
			int x=9999;
			
			int n=sc.nextInt();
			int m=sc.nextInt();
	        int[] arr1=new int[n];
	        for(int i=0;i<n;i++) {
	        	arr1[i]=sc.nextInt();
	        }
	        int[] arr2=new int[m];
	        for(int i=0;i<m;i++) {
	        	arr2[i]=sc.nextInt();
	        }
	        
	        for (int i = 0; i < arr1.length; i++)
	        {
	            for (int j = 0; j < arr2.length; j++)
	            {
	                if(arr1[i]==arr2[j])
	                {
	                	
	                   x=arr1[i];
	                   break;
	                }
	                
	            }
	        }
	        if(x==9999) System.out.println("NO");
	        else {
	        	System.out.println("YES");
	        	System.out.println("1 "+x);
	        	}

	}

	}
	}
