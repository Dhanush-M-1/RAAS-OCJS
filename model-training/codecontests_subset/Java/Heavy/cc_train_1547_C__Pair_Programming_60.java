import java.util.*;
public class problem1 {
	public static void main(String[] args) {
          
		int t,k,n,m,i,j,q;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while(t-- > 0) {
			k = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();
			int arr1[] = new int[n];
			int arr2[] = new int[m];
			int arr[] = new int[n+m];
			
			for(i=0;i<n;i++)
				arr1[i] = sc.nextInt();
			
			for(i=0;i<m;i++)
				arr2[i] = sc.nextInt();
			
			i=0;
			j=0;
			q=0;
			
			while(i<n && j<m) {
				if(arr1[i] <= k || arr1[i] == 0) {
					arr[q] = arr1[i];
					if(arr1[i] == 0)
						k++;
                    q++;
                    i++;
				}
				else if(arr2[j] <= k || arr2[j] == 0) {
					arr[q] = arr2[j];
					if(arr2[j] == 0)
						k++;
                    q++;
                    j++;
				}
				else {
				    i=n;
				    j=m;
				    break;
				}
			}
			
			while(i<n) {
				if(arr1[i] <= k || arr1[i] == 0) {
					arr[q] = arr1[i];
					if(arr1[i] == 0)
						k++;
                    q++;
                    i++;
				}
				else
					break;
			}
			
			while(j<m) {
				if(arr2[j] <= k || arr2[j] == 0) {
					arr[q] = arr2[j];
					if(arr2[j] == 0)
						k++;
                    q++;
                    j++;
				}
				else
					break;
			}
			
			if(q >= n+m) {
				for(i=0;i<n+m;i++)
					System.out.format("%d ",arr[i]);
			}
			else
				System.out.println(-1);
			System.out.println("\n");
		}
			
	}

}
