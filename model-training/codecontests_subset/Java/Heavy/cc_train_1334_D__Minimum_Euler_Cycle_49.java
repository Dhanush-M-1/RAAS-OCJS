import java.util.*;
import java.io.*;  

public class Solution{
    public static class pair{
        int x;
        int y;
    }
    public static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
        public String next() {
			while (st == null || !st.hasMoreElements())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) {
				a[i]=nextInt();
			}
			return a;
		}public double nextDouble() {
			return Double.parseDouble(next());
		}
    }
    public static void main(String[] args) throws IOException{
        FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		while(t-->0){
		    int n=fs.nextInt();
		    long l=fs.nextLong();
		    long r=fs.nextLong();
		    long sum=0;
		    long val=1;
		    int ln=-1,rn=-1;
		    boolean lb=false,rb=false;
		    long lsum=0;
		    long rsum=0,plsum=0,prsum=0;
		    for(int i=1;i<=n;i++){
		        if(i==n){
		            val=1;
		            sum+=1;
		        }else{
		            val=2*(n-i);
		            sum+=val;
		        }
		        if(!lb&&l<=sum){
		            ln=i;
		            lsum=val;
		            plsum=sum-val;
		            lb=true;
		        }
		        if(!rb&&r<=sum){
		            rn=i;
		            rsum=val;
		            rb=true;
		            prsum=sum-val;
		            break;
		        }
		    }
		  //  System.out.println(ln+" "+rn);
		    if(ln==rn){
		        if(rn==n){
		            System.out.println("1");
		            continue;
		        }
		        ArrayList<Long> list=new ArrayList<>();
		        l=l-plsum;
		        long lu=0;
		        long inc=ln+1;
		        r=r-prsum;
		        for(int i=1;i<=lsum;i++){
		            if(i%2!=0){
		                lu=ln;
		            }else{
		                lu=inc;
		                inc++;
		            }
		            if(l<=i&&r>=i){
		                list.add(lu);
		            }
		        }
		        for(int i=0;i<list.size();i++){
		            System.out.print(list.get(i)+" ");
		        }
		        System.out.println();
		    }else{
		        ArrayList<Long> list=new ArrayList<>();
		        l=l-plsum;
		        long lu=0;
		        long inc=ln+1;
		        for(int i=1;i<=lsum;i++){
		            if(i%2!=0){
		                lu=ln;
		            }else{
		                lu=inc;
		                inc++;
		            }
		            if(l<=i){
		                list.add(lu);
		            }
		        }
		      //  System.out.println(list);
		        for(int j=ln+1;j<rn;j++){
		            lsum-=2;
		            lu=0;
		            inc=j+1;
		            for(int i=1;i<=lsum;i++){
		                if(i%2!=0){
		                    lu=j;
		                }else{
		                    lu=inc;
		                    inc++;
		                }
		                list.add(lu);
		            }
		        }
		        if(rn==n){
		            list.add((long)1);
		            for(int i=0;i<list.size();i++){
		                System.out.print(list.get(i)+" ");
		            }
		            System.out.println();
		            continue;
		        }
		        r=r-prsum;
		        lu=0;
		        inc=rn+1;
		        for(int i=1;i<=rsum;i++){
		            if(i%2!=0){
		                lu=rn;
		            }else{
		                lu=inc;
		                inc++;
		            }
		            if(r>=i){
		                list.add(lu);
		            }else{
		                break;
		            }
		        }
		        for(int i=0;i<list.size();i++){
		            System.out.print(list.get(i)+" ");
		        }
		        System.out.println();
		    }
        }
        out.close();
    }
    public static void dfs(HashMap<Integer,ArrayList<Integer>> map,int r,ArrayList<Integer> end,int c){
        if(map.get(r).size()==0){
            end.add(c);
            return;
        }   
        ArrayList<Integer> l=map.get(r);
        for(int i=0;i<l.size();i++){
            dfs(map,l.get(i),end,c+1);
        }
    }
    public static String com(String s1,String s2){
        if(s1.compareTo(s2)>0){
            return s1;
        }else{
            return s2;
        }
    }
    public static void fost(HashMap<Integer,ArrayList<Integer>> map,int n,int n1){
        ArrayList<Integer> s=map.get(n);
        // System.out.println(s);
        for(int i=0;i<s.size();i++){
            if(s.get(i)==n1){
                s.remove(i);
                break;
            }
        }
        // System.out.println(s);
        for(int i=0;i<s.size();i++){
            fost(map,s.get(i),n);
        }
    }
    public static long calc(long n,long b){
        if(b==1){
            return Long.MAX_VALUE;
        }
        long val=(long)Math.ceil(n/b);
        long p=2;
        long ans=val;
        while(val!=0){
            val=(long)Math.ceil((long)n/(long)Math.pow(b,p));
            p++;
            ans+=val;
        }
        return ans;
    }
    public static long quala(long b){
        long val=(long)Math.ceil(Math.pow(1+(8*b),0.5));
        if(val%2==0){
            long va=(long)(2+val)/(long)2;
            return va;
        }else{
            long va=(long)(1+val)/(long)2;
            return va;
        }
    }
    public static String find(int a,int b){
        if(a==3){
            if(b==1){
                return "abb";
            }else if(b==2){
                return "bab";
            }else{
                return "bba";
            }
        }
        int v=((a-1)*(a-2))/2;
        if(b<=v){
            String s=find(a-1,b);
            StringBuffer sb=new StringBuffer(s);
            int diff=a-s.length();
            while(diff-->0){
                sb.insert(0,"a");
            }
            return sb.toString();
        }else{
            int diff=b-v;
            StringBuffer sb=new StringBuffer();
            sb.append("b");
            for(int i=0;i<a-diff-1;i++){
                sb.append("a");
            }
            sb.append("b");
            for(int i=0;i<diff-1;i++){
                sb.append("a");
            }
            return sb.toString();
        }
        // return new String("a"+s);
    }
    public static long z(long val){
        long p=1;
        while(val!=0){
            long rem=val%10;
            p*=rem;
            val=val/10;
        }
        return p;
    }
    public static int[] soe(int n){
        int[] arr=new int[n];
        arr[0]=0;
        for(int i=1;i<n;i++){
            if(arr[i]==0){
                for(int j=(2*(i+1))-1;j<n;j=j+i+1){
                    arr[j]=1;
                }
            }
        }
        return arr;
    }
    public static int[][] floydWarshall(int graph[][],int V){ 
        int dist[][] = new int[V][V]; 
        int i, j, k; 
        for (i = 0; i < V; i++){ 
            for (j = 0; j < V; j++){
                dist[i][j] = graph[i][j]; 
            }
        }
        for (k = 0; k < V; k++) { 
            for (i = 0; i < V; i++){ 
                for (j = 0; j < V; j++){ 
                    if (dist[i][k] + dist[k][j] < dist[i][j]){ 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                    }
                } 
            } 
        }
        return dist;
    } 
    public static class Comp implements Comparator<pair>{
        public int compare(pair a,pair b){
            if(a.x!=b.x){
                return b.x-a.x;
            }else{
                return a.y-b.y;
            }
        }
    }
    public static long gcd(long a,long b){
        if (b == 0) 
        return a; 
        return gcd(b, a % b);
    }
    public static int lcm(int a,int b){
        int x=Math.max(a,b);
        int y=Math.min(a,b);
        long ans=x;
        while(ans%y!=0){
            ans+=x;
        }
        if(ans>Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans;
    }
    public static long fact(int n){
        long ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
}