import java.io.*;
import java.util.*;

public class A
{
    static int l, r;
    static int[] arr;
    static char[] s;
    public static void main(String[] args) throws IOException
    {
        Flash f = new Flash();
        out = new PrintWriter(System.out);
        
        int T = 1; //f.ni();
        for(int tc = 1; tc <= T; tc++){
            l = f.ni(); r = f.ni(); sop(fn());
        }
        
        out.flush(); out.close();
    }
    
    static int fn()
    {
        if(r-l+1 >= 10) return 2;
        
        int[] map = new int[11];
        for(int i = l; i <= r; i++){
            for(int d = 2; d <= 10; d++){
                if(i%d == 0) map[d]++;
            }
        }
        
        int max = 0, ans = l;
        for(int i = 2; i <= 10; i++){
            if(max < map[i]){
                max = map[i];
                ans = i;
            }
        }
        
        return ans;
    }
    
    static PrintWriter out;
    static final long mod = (long)1e9+7;
    static final long inf = Long.MAX_VALUE;
    static final int _inf = Integer.MAX_VALUE;
    
    static void sort(int[] a){
        List<Integer> A = new ArrayList<>();
        for(int i : a) A.add(i);
        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) a[i] = A.get(i);
    }
    
    static int swap(int itself, int dummy){
        return itself;
    }
    
    static void sop(Object o){ 
        out.println(o);
    }
    
    static void print(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++) sb.append(a[i] + " ");
        sop(sb);
    }
    
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
        
        char[] nc(){
            return ns().toCharArray();
        }
        
        int ni(){
            return Integer.parseInt(next());
        }
        
        int[] arr(int n){
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

        long nl(){
            return Long.parseLong(next());
        }
        
        double nd(){
            return Double.parseDouble(next());
        }
    }
}