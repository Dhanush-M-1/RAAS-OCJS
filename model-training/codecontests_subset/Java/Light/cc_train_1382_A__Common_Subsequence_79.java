import java.util.*;
public class Solution {
	
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t =sc.nextInt();
			while(t-->0) {
				int n1=sc.nextInt();
				int n2=sc.nextInt();
				int[] arr1 = new int[n1];
				int[] arr2 = new int[n2];
				for(int i=0;i<n1;i++) {
					arr1[i]=sc.nextInt();
				}
				for(int i=0;i<n2;i++) {
					arr2[i]=sc.nextInt();
				}
				int ans=0,flag=0;
				for(int i=0;i<n1;i++) {
					for(int j=0;j<n2;j++) {
						if(arr1[i]==arr2[j]) {
							ans=arr1[i];
							flag=1;
							break;
						}
					}
				}
				if(flag==1) {
					System.out.println("YES");
					System.out.println("1"+" "+ans);
				}else System.out.println("NO");
				
			}
			sc.close();
	}
}

