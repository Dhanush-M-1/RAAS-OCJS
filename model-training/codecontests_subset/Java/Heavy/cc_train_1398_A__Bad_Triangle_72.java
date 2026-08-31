import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	public static int sign(int a){
		if(a>0){
			return 1;
		}
		else if(a<0){
			return -1;
		}
		else {
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			long [] arr=new long[n];
			for(int i=0;i<n;i++){
				arr[i]=sc.nextLong();
			}
			if(arr[0]+arr[1]>arr[n-1]){
				System.out.println(-1);
			}
			else{
				System.out.println(1+" "+2+" "+n);
			}
		}
			}
	   	 	static class SegmentTree{
	   	 		int[] arr , sTree;
	   	 	static	int N;
	   	 		public SegmentTree(int[] in){
	   	 			arr=in;
	   	 		N=arr.length-1;
	   	 			sTree=new int[2*N];
	   	 			
	   	 			build(1,1,N);
	   	 		}
	   	 		public void build(int node, int l, int r){
	   	 			if(l==r){
	   	 				sTree[node]=arr[l];
	   	 			}
	   	 			else{
	   	 				int leftchild=node*2;
	   	 				int rightchild=node*2+1;
	   	 				int mid =(l+r)/2;
	   	 				build(leftchild,l,mid);
	   	 				build(rightchild,mid+1,r);
	   	 				sTree[node]=sTree[leftchild]&sTree[rightchild];
	   	 			}
	   	 		}
	   	 		public  void update(int i, int val){
	   	 			int node =i+N-1;
	   	 			arr[i]=val;
	   	 			sTree[node]=val;
	   	 			node=node/2;
	   	 			while(node>0){
	   	 			int leftchild=node *2;
   	 				int rightchild=node*2+1;
   	 			sTree[node]=sTree[leftchild]&sTree[rightchild];
   	 			node=node/2;
	   	 			}
	   	 			return;
	   	 			
	   	 		}
	   	 		public int query(int i, int j){
	   	 			 return query(1,1, N,  i, j);
	   	 		}
	   	 		public int query(int node,int l, int r, int i , int j){
	   	 			if(i>r||j<l){
	   	 				return 1<<30;
	   	 			}
	   	 			if(i<=l&&r<=j){
	   	 				return sTree[node];
	   	 			}
	   	 		int leftchild=node*2;
	 				int rightchild=node*2+1;
	 				int mid =(l+r)/2;
	 				
	 			return	query(leftchild,l,mid,i,j)&query(rightchild,mid+1,r,i,j);
	 				
	   	 		}
	   	 	}


	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
 
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
 
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
	}}