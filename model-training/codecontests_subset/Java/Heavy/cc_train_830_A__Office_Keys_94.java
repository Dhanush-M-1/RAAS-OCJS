import java.io.*;
import java.util.*;

public class Main {
	public static final int MAXN=1000+24;
	public static final int MAXK=2000+24;
	public static final int INF=((int)2e9)+24;
	public static int n,k,p;
	public static int[] pos=new int[MAXN];
	public static int[] keys=new int[MAXK];
	public static boolean[] vis=new boolean[MAXK];
	public static int[][] dist=new int[MAXN][MAXK];
	
	public static boolean check(int x){
		Arrays.fill(vis, false);
		for(int i=0;i<n;i++){
			int keypos=-1;
			for(int j=0;j<k;j++){
				if(dist[i][j]<=x&&vis[j]==false){
					keypos=j; break;
				}
			}
			if(keypos==-1){
				return false;
			}
			vis[keypos]=true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		n=cin.nextInt(); k=cin.nextInt(); p=cin.nextInt();
		for(int i=0;i<n;i++){
			pos[i]=cin.nextInt();
		}
		for(int i=0;i<k;i++){
			keys[i]=cin.nextInt();
		}
		Arrays.sort(pos,0,n);
		Arrays.sort(keys,0,k);
		for(int i=0;i<n;i++){
			Arrays.fill(dist[i],0);
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<k;j++){
				dist[i][j]=Math.abs(pos[i]-keys[j])+Math.abs(keys[j]-p);
//				out.printf("%d ",dist[i][j]);
			}
//			out.println();
		}
		int l=0,r=INF,mid;
		while(r>=l){
			mid=l + ((r - l) >> 1);
			if(check(mid)){
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		out.println(l);
		out.flush(); out.close(); cin.close();
	}
}
