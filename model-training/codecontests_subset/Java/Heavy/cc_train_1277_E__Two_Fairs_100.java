import java.util.*;
import java.io.*;
public class Main {
    static int favsA=0;
    static int a,b;
    public static void main(String [] args){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        StringBuffer ans =new StringBuffer();
        while(t-->0){
            int n=sc.nextInt(),m=sc.nextInt();a=sc.nextInt();b=sc.nextInt();
            ArrayList<Integer> arr[]=new ArrayList[n+1];
            for(int i=1;i<=n;i++) arr[i]=new ArrayList<>();
            for(int i=0;i<m;i++){
                int aa=sc.nextInt(),bb=sc.nextInt();
                arr[aa].add(bb);
                arr[bb].add(aa);
            }
            boolean vis[]=new boolean[n+1];
            favsA=0;
            dfs(a,arr,vis);
            long temp1=favsA;
            long temp2=-1;
            for(int i=1;i<=n;i++)
            if(!vis[i]) ++temp2;
            ans.append(temp1*temp2);
            ans.append("\n");

        }
        System.out.println(ans);

    }

    static int dfs(int nd,ArrayList<Integer> arr[],boolean []vis)
    {
        if(nd == b){
            return -1;
        }

        vis[nd] =true;
        int sum=(nd != a?1:0);
        for(int i=0;i<arr[nd].size();i++){
            int ch=arr[nd].get(i);
            if(!vis[ch]){
                int val=dfs(ch,arr,vis);
                if(nd != a){
                    if(val == -1 || sum == -1){
                        sum=-1;
                    }else{
                        sum+=val;
                    }
                }
                else{
                    if(val>0) favsA+=val;
                }
            }
        }

        return sum;
    }
    /**
     * Fast I/O
     */
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
				catch (IOException e) 
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
	} 
}
