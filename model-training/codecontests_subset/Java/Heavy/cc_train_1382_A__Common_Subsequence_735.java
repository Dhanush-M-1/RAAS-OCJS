


import java.util.*;
import java.math.*;




public class helloworld {
	static boolean binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return true; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return false; 
    } 
	
	

   
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0;i<t;i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
		
			
			for(int j = 0;j<n;j++) {
				a[j] = in.nextInt();
				
			}
			for(int j = 0;j<m;j++) {
				b[j] = in.nextInt();
				
			}
			Arrays.sort(a);
			int flag = 0;
			int h = 0;
			
			for(int j = 0;j< m;j++) {
				boolean x = binarySearch(a,0,n-1,b[j]);
				
				if(x) {
					flag = 1;
					h = j;
					break;
					
				}
				
				
			}
			
			if(flag ==1) {
				System.out.println("YES");
				System.out.print(1+" ");
				System.out.println(b[h]);
			}
			else if(flag ==0){
				System.out.println("NO");
				
			}
			
			
			
			

			
			
			
			
		
	}
			
		
		
	}	
		
		
		
		
}
	