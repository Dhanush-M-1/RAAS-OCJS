import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DataCenterMaintenanceC469 {
	static LinkedList<Integer>[] edges;
	static int[] vals, indAnc;
	static long[] sizes;
	static int gc;
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),h=Integer.parseInt(st.nextToken());
		edges=new LinkedList[n];
		for(int i=0;i<n;i++)
			edges[i]=new LinkedList<Integer>();
		st=new StringTokenizer(in.readLine());
		vals=new int[n];
		for(int i=0;i<n;i++)
			vals[i]=Integer.parseInt(st.nextToken());
		int a,b;
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(in.readLine());
			a=Integer.parseInt(st.nextToken())-1;
			b=Integer.parseInt(st.nextToken())-1;
			if(vals[a]==(vals[b]+1)%h)
				edges[b].add(a);
			if(vals[b]==(vals[a]+1)%h)
				edges[a].add(b);
		}
		initSCC(n);
		int bestInd=-1,t;
		long bestSize=Integer.MAX_VALUE;
		boolean[] check=new boolean[n];
		for(int i=1;i<n;i++) {
			if(!check[i]){
				t=i;
				while(indAnc[t]!=t) {
					check[t]=true;
					t=indAnc[t];
				}
				check[t]=true;
				if(sizes[t]<bestSize) {
					bestSize=sizes[t];
					bestInd=t;
				}
			}
		}
		out.println(sizes[bestInd]);
		printNodes(bestInd,new boolean[n],out );
		out.println();
		in.close();
		out.close();
	}
	public static void initSCC(int n) {
		gc=0;
		sizes=new long[n];
		int[] ind=new int[n];
		int[] anc=new int[n];
		indAnc=new int[n];
		int[] reverse=new int[n];
		boolean[] inc=new boolean[n];
		for(int i=0;i<n;i++)
			ind[i]=-1;
		for(int i=0;i<n;i++) 
			if(ind[i]==-1) 
				traverse(i,new LinkedList<Integer>(),ind,anc,reverse,inc);
	}
	public static void traverse(int pos, LinkedList<Integer> st, int[] ind, int[] anc, int[] reverse, boolean[] inc) {
		inc[pos]=true;
		ind[pos]=anc[pos]=gc;
		reverse[gc]=pos;
		sizes[pos]=1;
		st.add(pos);
		gc++;
		boolean usable=true;
		for(Integer c:edges[pos]) {
			if(ind[c]==-1) {
				traverse(c,st,ind,anc,reverse,inc);
				anc[pos]=Math.min(anc[pos],anc[c]);
				sizes[pos]+=sizes[c];
			}
			else if(inc[c])
				anc[pos]=Math.min(anc[pos],ind[c]);
			else
				usable=false;
		}
		if(!usable) {
			sizes[pos]=Integer.MAX_VALUE;
		}
		if(ind[pos]==anc[pos]) {
			while(!st.isEmpty()&&st.getLast()!=pos)
				inc[st.pollLast()]=false;
			inc[st.pollLast()]=false;
		}
		indAnc[pos]=reverse[anc[pos]];
	}
	public static void printNodes(int ind, boolean[] check,PrintWriter out) {
		out.print((ind+1)+" ");
		check[ind]=true;
		for(Integer c:edges[ind])
			if(!check[c])
				printNodes(c,check,out);
	}
}
