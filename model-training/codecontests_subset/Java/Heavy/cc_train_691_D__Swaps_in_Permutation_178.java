import java.io.*;

import java.util.*;


/*


*/
public class Main {
	static FastReader sc=null;
	

	
	public static void main(String[] args) {
		sc=new FastReader();
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt(),m=sc.nextInt();
		int a[]=sc.readArray(n);
		DU du=new DU(n);
		for(int i=0;i<m;i++) {
			int p=sc.nextInt()-1,q=sc.nextInt()-1;
			du.unify(p, q);
		}
		Map<Integer,LinkedList<Integer>> map=new HashMap<>();
		Map<Integer,LinkedList<Integer>> ids=new HashMap<>();
		for(int i=0;i<n;i++) {
			int root=du.find(i);
			if(map.containsKey(root)){
				map.get(root).add(a[i]);
				ids.get(root).add(i);
			}
			else {
				LinkedList<Integer> c=new LinkedList<>();
				c.add(a[i]);
				LinkedList<Integer> id=new LinkedList<>();
				id.add(i);
				map.put(root,c);
				ids.put(root,id);
			}
		}
		for(int e:map.keySet()) {
			Collections.sort(map.get(e),Collections.reverseOrder());
			Collections.sort(ids.get(e));
		}
		int ans[]=new int[n];
		for(int e:map.keySet()) {
			while(!map.get(e).isEmpty()) {
				int id=ids.get(e).pollFirst();
				ans[id]=map.get(e).pollFirst();
			}
		}
		for(int e:ans)out.print(e+" ");
		out.println();
		out.close();
		
		
		
		
		
	}
	static class DU{
		 int id[];
		 int size;
		 int comp;
		 int sz[];
		 Map<Integer,ArrayList<Integer>> map=new HashMap<>();
		
		 DU(int size){
			this.size=size;
			id=new int[size];
			sz=new int[size];
			for(int i=0;i<size;i++) {
				id[i]=i;
				sz[i]=1;
			}
			comp=size;
				
		}
		public int find(int p) {
			int root=p;
			
			while(id[root]!=root)
				root=id[root];
			
			while(p!=root) {
				
				int next=id[p];
				id[p]=root;
				p=next;
			}
			return root;
			
		}
		public boolean connected(int p,int q) {
			int r1=find(p),r2=find(q);
			return id[r1]==id[r2];
		}
		public int compsize(int p) {
			return sz[find(p)];
		}
		public void unify(int p,int q) {
			int r1=find(p),r2=find(q);
			
			
			if(r1==r2)return;
			
			if(sz[r1]<sz[r2]) {
				sz[r2]+=sz[r1];
				id[r1]=id[r2];
			}
			else {
				sz[r1]+=sz[r2];
				id[r2]=id[r1];
			}
			
			comp--;	
		}	
	}
	
	
	
	static int[] ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
		
	static int[] reverse(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al,Collections.reverseOrder());
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	static char[] reverse(char a[]) {
		ArrayList<Character> al=new ArrayList<>();
		for(char i:a)al.add(i);
		Collections.sort(al,Collections.reverseOrder());
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	static int gcd(int a,int b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}
	static long gcd(long a,long b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}
		
	static void print(int a[]) {
		for(int e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	static void print(long a[]) {
		for(long e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
        int[] readArray(int n) {
    		int a[]=new int [n];
    		for(int i=0;i<n;i++) {
    			a[i]=sc.nextInt();
    		}
    		return a;
    	}
    } 
}