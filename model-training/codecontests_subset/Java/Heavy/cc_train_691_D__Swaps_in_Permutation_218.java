
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static int count=0,k1,k2;
	static boolean[] visited;
	static ArrayList<Integer>[] al;
	static ArrayList al1;
	static int[] a;
	static int[] row={-1,-1,0,1,1,1,0,-1};
	static int[] col={0,1,1,1,0,-1,-1,-1};
	static Stack s;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		int t,n,m;
		StringTokenizer st=new StringTokenizer(reader.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		al1=new ArrayList();
		al=new ArrayList[n];
		visited=new boolean[n];
		st=new StringTokenizer(reader.readLine());
		a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(st.nextToken());
			al[i]=new ArrayList<Integer>();
		}
		while(m-->0){
			st=new StringTokenizer(reader.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			x--;y--;
			al[x].add(y);
			al[y].add(x);
		}

		for(int i=0;i<al.length;i++){
			if(!visited[i]){
				al1.add(i);
				visited[i]=true;
				swap(a,i);

				int size=al1.size();
				int b[]=new int[size];
				for(int j=0;j<size;j++)
					b[j]=a[(int)al1.get(j)];
				Arrays.sort(b);
				Collections.sort(al1);
				for(int j=0;j<size;j++){
					a[(int)al1.get(j)]=b[size-j-1];
				}
				al1.clear();
			}
		}
		for(int i=0;i<n;i++){
			writer.print(a[i]+" ");
		}
		writer.flush();
		writer.close();
		reader.close();
	}
	private static void swap(int[] a, int i) {
		if(al[i].isEmpty())
			return;
		for(int child: al[i]){
			if(!visited[child]){
				visited[child]=true;
				al1.add(child);
				swap(a,child);
			}
		}
	}
}