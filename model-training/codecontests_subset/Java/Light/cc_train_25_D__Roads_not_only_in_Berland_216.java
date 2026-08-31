import java.io.*;
import java.util.*;
public class Main{
	static int[] par;
	public static void main(String args[]) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		StringBuilder sb=new StringBuilder("");
			
		par=new int[n];
		for(int i=0;i<n;i++)
			par[i]=i;
			
		ArrayDeque<Edge> pq=new ArrayDeque<Edge>();
		for(int i=0;i<n-1;i++){
			String[] ab=in.readLine().split(" ");
			int a=Integer.parseInt(ab[0])-1;
			int b=Integer.parseInt(ab[1])-1;
			pq.add(new Edge(a, b));
		}
		
		ArrayDeque<Edge> closed=new ArrayDeque<Edge>();
		int time=0;
		while(pq.size()>0){
			Edge curr=pq.poll();
			int par1=find(curr.from);
			int par2=find(curr.to);
			
			if(par1!=par2){
				union(par1, par2);
			} else {
				time++;
				closed.add(curr);
			}
		}
		
		sb.append(time+"\n");
		for(int i=1;i<n;i++){
			int pari1=find(i);
			int pari2=find(i-1);
			
			if(pari1!=pari2){
				Edge cl=closed.poll();
				sb.append((cl.from+1)+" "+(cl.to+1)+" "+(i+1)+" "+i+"\n");
				union(pari1, pari2);
			}
		}
		
		System.out.print(sb);
	}
	
	static int find(int i){
		if(par[i]!=i) par[i]=find(par[i]);
		return par[i];
	}
	
	static void union(int i, int j){
		par[i]=par[j];
	}
	
	static class Edge{
		int w;
		int from, to;
		
		public Edge(int from, int to){
			this.from=from;
			this.to=to;
		}
	}
}