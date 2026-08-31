import java.util.*;
 
public class PerformCombo {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			String s = sc.next();
 
			int[]count=new int[n+1];
			
			for(int i=0;i<m;i++) {
				int p=sc.nextInt();
				count[p-1]+=1;
			}
			
			for(int i=n-1;i>0;i--) {
				count[i-1]=count[i-1]+count[i];
			}
			int[]ans=new int[26];
			for(int i=0;i<s.length();i++) {
				char ch=s.charAt(i);
				ans[ch-'a']=ans[ch-'a']+count[i]+1;
			}
			
			for(int i=0;i<ans.length;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			
		}
 
	}
 
}