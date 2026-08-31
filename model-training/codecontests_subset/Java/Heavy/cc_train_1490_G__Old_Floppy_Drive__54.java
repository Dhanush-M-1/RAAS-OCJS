import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import java.io.*;
import java.util.*;

public class A
{
    static int n, m;
    static int[] arr, q;
    static char[] s;
    public static void main(String[] args) throws IOException
    {
        f = new Flash();
        out = new PrintWriter(System.out);
        
        int T = ni();
        for(int tc = 1; tc <= T; tc++){
            n = ni(); m = ni(); arr = arr(n); q = arr(m); fn();
        }
        
        out.flush(); out.close();
    }
    
    static void fn()
    {
        long sum = 0, min = inf, max = -inf;
        long[] pref = new long[n];;
        for(int i = 0; i < n; i++) {
        	sum += arr[i];
        	min = min(min, sum);
        	max = max(max, sum);
        	pref[i] = sum;
        }
        
        for(int i = 1; i < n; i++) {
        	if(pref[i] <= pref[i-1]) pref[i] = pref[i-1];
        }
        //sop(sum);
        long[] ans = new long[m];
        for(int i = 0; i < m; i++) {
        	if(q[i] <= max) {
        		ans[i] = bs(q[i], pref);
        	}
        	
        	else if(sum <= 0) ans[i] = -1;
        	else {
        		long temp = q[i] - max;
    			ans[i] = (temp+sum-1)/sum;
    			q[i] -= sum*ans[i];
    			ans[i] *= n;
    			ans[i] += bs(q[i], pref);
        	}
        }
        
        //sop(Arrays.toString(pref));
        print(ans);
    }
    
    static int bs(long x, long[] pref) {
    	int l = 0, r = pref.length-1;
    	while(l < r) {
    		int mid = l + (r - l) / 2;
    		if(pref[mid] >= x) r = mid;
    		else l = mid + 1;
    	}
    	
    	return l;
    }
    
    static Flash f;
    static PrintWriter out;
    static final long mod = (long)1e9+7;
    static final long inf = Long.MAX_VALUE;
    static final int _inf = Integer.MAX_VALUE;
    static final int maxN = (int)5e5+5;
    static long[] fact, inv;
    
    static void sort(int[] a){
        List<Integer> A = new ArrayList<>();
        for(int i : a) A.add(i);
        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) a[i] = A.get(i);
    }
    
    static void sort(long[] a){
        List<Long> A = new ArrayList<>();
        for(long i : a) A.add(i);
        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) a[i] = A.get(i);
    }
    
    static void print(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++) sb.append(a[i] + " ");
        sop(sb);
    }
    
    static void print(long[] a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++) sb.append(a[i] + " ");
        sop(sb);
    }
    
    static int swap(int itself, int dummy){return itself;}
    static long swap(long itself, long dummy){return itself;}
    static void sop(Object o){out.println(o);}
    static int ni(){return f.ni();}
    static long nl(){return f.nl();}
    static double nd(){return f.nd();}
    static String next(){return f.next();}
    static String ns(){return f.ns();}
    static char[] nc(){return f.nc();}
    static int[] arr(int len){return f.arr(len);}
    static int gcd(int a, int b){if(b == 0) return a; return gcd(b, a%b);}
    static long gcd(long a, long b){if(b == 0) return a; return gcd(b, a%b);}
    static int lcm(int a, int b){return (a*b)/gcd(a, b);}
    static long lcm(long a, long b){return (a*b)/gcd(a, b);}
    
    static class Flash
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        String next(){
            while(!st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            
            return st.nextToken();
        }
        
        String ns(){
            String s = new String();
            try{
                s = br.readLine().trim();
            }catch(IOException e){
                e.printStackTrace();
            }
            
            return s;
        }
        
        int[] arr(int n){
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = ni();
            return a;
        }
        
        char[] nc(){return ns().toCharArray();}
        int ni(){return Integer.parseInt(next());}
        long nl(){return Long.parseLong(next());}
        double nd(){return Double.parseDouble(next());}
    }
}