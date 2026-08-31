import java.util.*;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int k=sc.nextInt();
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			
			for(int i=0;i<n;i++) arr1[i]=sc.nextInt();
			for(int j=0;j<m;j++) arr2[j]=sc.nextInt();
			
			int[] arr3= new int[n+m];
			
			int index=0;
			int left=0;
			int right=0;
			boolean flag=true;
			while(left<n && right<m) {
				if(arr1[left]==0){
					arr3[index++]=arr1[left++];
					k++;
				}
				else if(arr2[right]==0) {
					arr3[index++]=arr2[right++];
					k++;
				}
				else if(arr1[left]!=0 && arr1[left]<=k) {
					arr3[index++]=arr1[left++];
				}
				else if(arr1[left]!=0 && arr1[left]>k) {
					if(arr2[right]!=0 && arr2[right]>k) {
						flag=false; break;
					}
					else {
						arr3[index++]=arr2[right++];
					}
				}
//				else if(arr2[right]!=0 && arr2[right]<=k) {
//					arr3[index++]= arr2[right++];
//				}
//				else {
//					if()
//				}
			}
			
			while(left<n && flag==true) {
				if(arr1[left]<=k && arr1[left]!=0)
					arr3[index++]=arr1[left++];
				else if(arr1[left]==0) {
					k++;
					arr3[index++]=arr1[left++];
				}		
				else 
					flag=false;
			}
			while(right<m && flag==true) { 
				if(arr2[right]<=k && arr2[right]!=0)
					arr3[index++]=arr2[right++];
				else if(arr2[right]==0) {
					k++;
					arr3[index++]=arr2[right++];
				}
				else 
					flag=false;
			}
			if(!flag) System.out.println(-1);
			else {
				for(int i=0;i<arr3.length;i++) {
					System.out.print(arr3[i]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
