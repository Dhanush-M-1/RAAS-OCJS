import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class q5 {
	

	 
	public static void main(String[] args) throws IOException {
		
		Reader.init(System.in);
		StringBuffer output=new StringBuffer("");
		PrintWriter out=new PrintWriter(System.out);
		int n=Reader.nextInt();
		int m=Reader.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) arr[i]=Reader.nextInt();
		HashSet<Integer>[] arr2=new HashSet[n+1];
		for(int i=0;i<=n;i++) arr2[i]=new HashSet<Integer>();
		DisJoint set=new DisJoint(n);
		for(int i=0;i<m;i++) {
			int a=Reader.nextInt();
			int b=Reader.nextInt();
			//set.union(a, b);
			arr2[a].add(b);
			
		}
		//int[] rep=new int[n+1];
		int ce=arr[n-1];
		int ans=0;
		Stack<Integer> stk=new Stack<Integer>();
		HashSet<Integer> set2=new HashSet<Integer>();
		set2.add(ce);
		for(int i=n-2;i>=0;i--) {
			
				
					int count=0;
					for(int l:arr2[arr[i]]) {
						if(set2.contains(l)) count++;
					}
					if(count==set2.size()) ans++;
					else set2.add(arr[i]);
				
				
			
			
		}
		output.append(ans);
		out.write(output.toString());
		out.flush();
		
	}
}

class DisJoint {
	int[] arr;
	int[] parent;
	int[] rank;
	DisJoint(int n){
		arr=new int[n+1];
		parent=new int[n+1];
		rank=new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=i;
			parent[i]=i;
			rank[i]=0;
		}
	}

	int find(int value) {
		int par=parent[value];
		if(par==value)
			return par;
		parent[value]=find(par);
		return parent[value];
	}
	
	void union(int data1,int data2) {
		int parent1=find(data1);
		int parent2=find(data2);
		if(parent1!=parent2) {
			if(rank[parent1]>=rank[parent2]) {
				parent[parent2]=parent1;
				if(rank[parent1]==rank[parent2])
					rank[parent1]++;
			}
			else {
				parent[parent1]=parent2;
			}
		}
		
	}
}
class ode{
	int a;
	int pos;
	int length;
	int index;
	ode(int aa,int p,int i){
		a=aa;pos=p;index=i;
		length=pos-a+1;
	}
}



class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String nextLine() throws IOException{
    	return reader.readLine();
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}




 
 

 