import java.io.*;
import java.util.*;
import java.lang.*;
public class Codechef {
	PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
 	
 	class Pair implements Comparable<Pair>
	{
	    int f;
	    int s;
 
	    Pair(int t, int r) {
	       f = t;
	       s = r;
	    }
	    public int compareTo(Pair p)
	    {
	    	if(this.f!=p.f)
	    		return this.f-p.f;
 
	    	return this.s-p.s;
	    }
 	}
 // 	class Sort implements Comparator<String> 
	// { 
	//     public int compare(String a, String b) 
	//     { 
	//     	return (a+b).compareTo(b+a);
	//     } 
	// }
 
	String ns() {
        while (st == null || !st.hasMoreElements()) {
 
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }
 
    int nextInt() {
        return Integer.parseInt(ns());
    }
 
    long nextLong() {
        return Long.parseLong(ns());
    }
 
    double nextDouble() {
        return Double.parseDouble(ns());
    }
	
	int upperBound(long a[],long key)
	{
		int l=0,r=a.length-1;
		int i=-1;
 
		while(l<=r)
		{
			int mid=(l+r)/2;
 
			if(a[mid]<key)
				l=mid+1;
 
			else{
				i=mid;	
				r=mid-1;
			}
			
		}
		return i;
	}
	int lowerBound(Pair[] a , long key)
	{
		int l = 0, r = a.length- 1;
		int i = -1;
 	
		while(l<=r)
		{
			int mid=(l+r)/2;
 
			if(a[mid].f<key)
			{
				i=mid;
				l=mid+1;	
			}
 
			else
				r=mid-1;
			
		}
		return i;
	}
 
	long power(long x,long y)
	{
	    long ans=1;
	    
	    while(y!=0)
	    {
	        if(y%2==1) ans=(ans*x)%mod;
	        x=(x*x)%mod;
	        y/=2;
	    }
	    return ans%mod;
	}
	
 
	int mod= 1000000007;
	long gcd(long x ,long y)
	{
		if(y==0)
			return x;
		return gcd(y,x%y);
	}
 
	// ArrayList a[];
	// int vis[],cnt=0;
	// void dfs(int ver)
	// {
	// 	ArrayList<Integer> l=a[ver];
	// 	if(l.size()==1)
	// 		cnt++;
	// 	for(int v:l)
	// 	{
	// 		if(vis[v]==0){
	// 			vis[v]=vis[ver]+1;
	// 			dfs(v);
	// 		}
	// 	}
	// }
 
 	int countSetBits(long n) 
    { 
        int count = 0; 
        while (n > 0) { 
            n &= (n - 1); 
            count++; 
        } 
        return count; 
    }
  
	void solve() throws IOException{
		int n = nextInt();
		int k = nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> alice = new ArrayList<>();
		ArrayList<Integer> bob = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
		{
			int time = nextInt();
			int a = nextInt();
			int b = nextInt();
			if(a == 1 && b == 1)
				list.add(time);
			else if(a == 1)
				alice.add(time);
			else if(b == 1)
				bob.add(time);
		}
		// System.out.println(list);
		// System.out.println(alice);
		// System.out.println(bob);

		Collections.sort(list);
		Collections.sort(alice);
		Collections.sort(bob);
		int m = Math.min(alice.size(), bob.size());
		
		if(list.size() + m < k){
			out.println(-1);
			return;
		}
		int i = 0, j = 0;
		long sum = 0;

		while(i < list.size() && i < k)
		{
			sum += list.get(i++);
		}

		while(j < m && (i + j) < k)
		{
			sum += alice.get(j);
			sum += bob.get(j++);
		}

		while(i > 0 && j < m)
		{
			long x = list.get(--i);
			
			long y = alice.get(j) + bob.get(j++);
			if(y < x)
			{
				sum -= x;
				sum += y;
			}
			else 
				break;
		}

		out.println(sum);
	}
 
 
	
    void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
		solve();
		out.flush();
 
		out.close();
	}
 
	public static void main(String args[]) throws IOException {
		new Codechef().run();
	}
}
  
