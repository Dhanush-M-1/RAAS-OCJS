import java.util.*;
import java.math.*;
public class B {

	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(System.in);
	int n=in.nextInt(),k=in.nextInt();
	int[] t = new int[2001], c = new int[2001], ind = new int[2001], kol = new int[2001],min = new int[2001], ll = new int[2001];
	long[] sum = new long[2001];
	boolean[] use = new boolean[2001];
	int[][] a = new int[2001][2001];
	for (int i=1;i<=n;i++) {c[i]=in.nextInt();t[i]=in.nextInt();ind[i]=i;};
	
	
	for (int i=1;i<n;i++)
		for (int j=i+1;j<=n;j++) if (c[i]<c[j]){
			int yed=c[i];c[i]=c[j];c[j]=yed;
			yed= ind[i];ind[i]=ind[j];ind[j]=yed;
			yed= t[i];t[i]=t[j];t[j]=yed;
		}
	
	
	
	
	int j=0;
	
	

	for (int i=1;i<=n;i++)
		if (t[i]==1) {
			if(j<k) j++;
		kol[j]++; a[j][kol[j]] = ind[i]; use[j]=true;
		 if (c[i]<min[j] || min[j]==0) min[j]=c[i];
		  ll[i]=j;
		}
	
	
	for (int i=1;i<=n;i++)
		if (t[i]==2) {
		if (j<k) j++; 
		kol[j]++; a[j][kol[j]] = ind[i]; 
		 if (c[i]<min[j] || min[j]==0) min[j]=c[i];
		 ll[i]=j;
		}
	
	
	
	
	
	double ans=0;
	for (int i=1;i<=k;i++)
		if (min[i]>0) {
	if (use[i]) ans+=(double)min[i]*0.5; else ans+=min[i];		
		}	
	boolean[] b= new boolean[20001];
	
	for (int i=1;i<=n;i++) {
		if (c[i]!=min[ll[i]]|| b[ll[i]] )
		ans+=c[i];
		else if (c[i]==min[ll[i]]) b[ll[i]]=true;
	
	} 
	
	System.out.printf("%.1f\n",ans);
	for (int i=1;i<=k;i++) {
		System.out.print(kol[i]);
		for (j=1;j<=kol[i];j++) System.out.print(" " + a[i][j]);
		System.out.println();
	}
	
	}
}