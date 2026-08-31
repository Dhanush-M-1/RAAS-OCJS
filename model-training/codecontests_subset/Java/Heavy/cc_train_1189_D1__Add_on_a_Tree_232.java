import java.util.*;
import java.io.*;
public class Solution{
    static ArrayList<Integer> a[];
    static boolean[] v;
    static class pair implements Comparable<pair>{
        int a,b;
        pair(int x,int y){
            a=x;b=y;
        }
        public int compareTo(pair t){
            if(t.a==this.a)
            return this.b-t.b;
            return this.a-t.a;
        }
    }
    public static ArrayList<pair> bfs(String[] a,int r,int c){
        ArrayList<pair> ans=new ArrayList<>();
        Queue<pair> q=new LinkedList<>();
        int[][] dxy={{-1,0,1,0},{0,-1,0,1}};
        q.add(new pair(r,c));
        HashSet<String> h=new HashSet<>();
        while(!q.isEmpty()){
            pair f=q.poll();
            ans.add(f);h.add(f.a+" "+f.b);
            for(int i=0;i<4;i++){
                int dx=f.a+dxy[0][i];
                int dy=f.b+dxy[1][i];
                if(dx<0||dy<0||dx>=a.length||dy>=a.length||h.contains(dx+" "+dy)||
                a[dx].charAt(dy)=='1')
                continue;
                q.add(new pair(dx,dy));
                h.add(dx+" "+dy);
            }
        }
        return ans;
    }    
    public static int dfs(int a[][],boolean[] v,int n){
        v[n]=true;
        int q=1;
        for(int i=0;i<a.length;i++){
            if(!v[i]&&a[n][i]!=0)
            q+=dfs(a,v,i);
        }
        return q;
    }
    public static int pow(int a, int n) {
		long ans = 1;
		long base = a;
		while (n != 0) {
			if ((n & 1) == 1) {
				ans *= base;
				ans %= 1000000007;
			}
			base = (base * base) % 1000000007;
			n >>= 1;
		}
		return (int) ans % 1000000007;
	}
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
// 		int t = s.nextInt();
// 		while(t-- > 0) {
 
			int n = s.nextInt();
		ArrayList<Integer> a[]=new ArrayList[n];
		for(int i=0;i<n-1;i++){
		    int u=s.nextInt()-1;
		    int v=s.nextInt()-1;
		    if(a[u]==null)
		    a[u]=new ArrayList<>();
		    if(a[v]==null)
		    a[v]=new ArrayList<>();
		    a[u].add(v);
		    a[v].add(u);
		}int f=0;
		for(int i=0;i<n;i++){
		    if(a[i]!=null&&a[i].size()==2){
		        f=1;break;
		    }
		}
		if(f==1)
		System.out.println("NO");
		else
		System.out.println("YES");
	//	}
	}
}