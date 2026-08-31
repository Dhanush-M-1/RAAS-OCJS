import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class KingsPath {
	static TreeSet<node>g;
	static int d;
	
	
	static class node implements Comparable<node> {
		int x;int y;int lvl ;
		node(int x,int y,int lvl){
			this.x=x;
			this.y=y;
			this.lvl=lvl;
		}
		public int compareTo(node a){
			if(a.x==x)return a.y-y;
			return a.x-x;
			
		}
		public String toString(){
			return x+" "+y;
		}
	}
	static void bfs(node u,node z){
		Queue<node>q= new LinkedList<node>();
		TreeSet<node>genr=new TreeSet<node>();
		q.add(u);
		genr.add(u);
		while(!q.isEmpty()){
			
			node x=q.remove();
			if(x.compareTo(z)==0){
				d=x.lvl;
				return;
				}
			for(int i=-1;i<2;i++){
				for(int j=-1;j<2;j++){
					if(i==0&&j==0)continue;
					node w=new node(x.x+i,x.y+j,1+x.lvl);
					if(g.contains(w)&&!genr.contains(w)){q.add(w);}genr.add(w);
				}

			}

		}d=-1;

	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		node s=new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
		node e=new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
		int n= Integer.parseInt(br.readLine());
		g=new TreeSet<node>();
		for(int i=0;i<n;i++){
			st =new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			for(a=a;a<=b;a++){
				g.add(new node(r,a,0));
			}
			
			
		
		}//System.out.println(g.toString());
			bfs(s,e);
			System.out.println(d);
		
		
		

		
		
		
	}

}
