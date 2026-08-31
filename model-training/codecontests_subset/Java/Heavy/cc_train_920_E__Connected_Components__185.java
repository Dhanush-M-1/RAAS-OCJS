

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, sc, out);
        out.close();
    }

    static class Task {
    	public int[] pre;
    	
    	public int find(int x) {
    		int temp=x;
    		
    		while(temp!=pre[temp])
    			temp=pre[temp];
    		int i=x,j;
    		while(i!=temp) {
    			j=pre[i];
    			pre[i]=temp;
    			i=j;
    		}
    		return temp;
    	}
    	
    	public void join(int x,int y) {
    		int a=find(x);
    		int b=find(y);
    		if(a!=b)
    			pre[a]=b;
    	}
    	
    	public void buildGraph(int[][] G,int[] from,int[] to,int n,int m) {
    		int[] cnt=new int[n];
    		for(int i=0;i<m;i++) {
    			cnt[from[i]]++;
    			cnt[to[i]]++;
    		}
    		for(int i=0;i<n;i++)
    			G[i]=new int[cnt[i]];
    		for(int i=0;i<m;i++) {
    			G[from[i]][--cnt[from[i]]]=to[i];
    			G[to[i]][--cnt[to[i]]]=from[i];
    		}
    	}
    	
    	public void enumConnectedComponentFromComplementGraph(int[][] G) {
    		int minDegreeIndex=-1;
    		int temp=Integer.MAX_VALUE;
    		
    		for(int i=0;i<G.length;i++) {     //找出补图中度数最小的点
    			if(temp>G[i].length) {
    				temp=G[i].length;
    				minDegreeIndex=i;
    			}
    		}
    		Arrays.sort(G[minDegreeIndex]);
    		for(int i=0,j=0;i<G.length;i++) {
    			if(j<G[minDegreeIndex].length&&i==G[minDegreeIndex][j]) {
    				j++;
    			}
    			else
    				join(minDegreeIndex,i);
    		}
    		for(int v:G[minDegreeIndex]) {
    			Arrays.sort(G[v]);
    			for(int i=0,j=0;i<G.length;i++) {
    				if(j<G[v].length&&i==G[v][j])
    					j++;
    				else
    					join(v,i);
    			}
    		}
    	}
    	
        public void solve(int testNumber, InputReader sc, PrintWriter out) throws IOException {
        	int n=sc.nextInt();
        	int m=sc.nextInt();
        	int[] from=new int[m];
        	int[] to=new int[m];
        	pre=new int[n];
        	int[][] G=new int[n][];
        	for(int i=0;i<n;i++)
        		pre[i]=i;
        	
        	for(int i=0;i<m;i++) {
        		from[i]=sc.nextInt()-1;
        		to[i]=sc.nextInt()-1;
        	}
        	buildGraph(G,from,to,n,m);
        	enumConnectedComponentFromComplementGraph(G);
        	HashSet<Integer> set=new HashSet<Integer>();
        	int size=0;
        	int[] cnt=new int[n];
        	for(int i=0;i<n;i++) {
        		int index=find(i);
        		if(index==i)
        			size++;
        		cnt[index]++;
        	}
        	ArrayList<Integer> buf=new ArrayList<Integer>();
        	for(int i=0;i<n;i++)
        		if(cnt[i]!=0)
        			buf.add(cnt[i]);
        	Collections.sort(buf);
        	out.println(size);
        	for(int v:buf)
        		out.print(v+" ");
        	out.println();
        }
    }

    static class InputReader{
        StreamTokenizer tokenizer;
        public InputReader(InputStream stream){
            tokenizer=new StreamTokenizer(new BufferedReader(new InputStreamReader(stream)));
            tokenizer.ordinaryChars(33,126);
            tokenizer.wordChars(33,126);
        }
        public String next() throws IOException {
            tokenizer.nextToken();
            return tokenizer.sval;
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public boolean hasNext() throws IOException {
            int res=tokenizer.nextToken();
            tokenizer.pushBack();
            return res!=tokenizer.TT_EOF;
        }
        
        public double nextDouble() throws NumberFormatException, IOException {
        	return Double.parseDouble(next());
        }
        
        public BigInteger nextBigInteger() throws IOException {
        	return new BigInteger(next());
        }
    }
}
