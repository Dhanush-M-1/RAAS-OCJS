import java.util.*;
public class LevelStatistics {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int plays[]=new int[n];
			int clears[]=new int[n];
			for(int i=0;i<n;i++) {
				plays[i]=sc.nextInt();
				clears[i]=sc.nextInt();
			}
			
			boolean ans=stat(plays,clears,n);
			
			if(ans==false) System.out.println("NO");
			else System.out.println("YES");
		}

	}
	
	static boolean stat(int plays[],int clears[],int n) {
		if(plays[0]<clears[0]) return false;
		for(int i=1;i<n;i++) {
			int diffp=plays[i]-plays[i-1];
			int diffc=clears[i]-clears[i-1];
			if(plays[i]<clears[i]||plays[i]<plays[i-1]||clears[i]<clears[i-1]||diffc>diffp) return false;
		}
		
		return true;
	}
	

}
