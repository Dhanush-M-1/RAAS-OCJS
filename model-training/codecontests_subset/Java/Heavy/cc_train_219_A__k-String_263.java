import java.util.*;
public class Without_testcase {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int k=sc.nextInt();
		String s=sc.next();
		int n=s.length();
		int a[]=new int[123];
		//answer...
			for(int i=0;i<n;i++) {
				a[s.charAt(i)]+=1;
			}
			boolean ans=true;
				for(int i=97;i<123;i++) {
					if( a[i]%k==0);
					else
						ans=false;						
				}
				if(ans) {
					for(int i=0;i<k;i++) {
						for(int j=97;j<123;j++) {
							int m=a[j]/k;
							char an=(char)j;
							while(m-->0) {								
								System.out.print(an);
							}							
						}
					}
				}
				else		{			
					System.out.println(-1);
			}						
		}
	 }	
