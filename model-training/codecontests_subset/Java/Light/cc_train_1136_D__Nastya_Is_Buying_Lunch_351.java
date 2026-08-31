import java.util.*;
import java.io.*;



public class answer{
    
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] p = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            p[i] = Integer.parseInt(st.nextToken())-1;
        }
        int u,v;
        HashSet<Integer>[] hs = new HashSet[n];
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken())-1;
            v = Integer.parseInt(st.nextToken())-1;
            if(hs[v]==null) {
                hs[v] = new HashSet<Integer>();
            }
            
            hs[v].add(u);
            
        }
        
        HashSet<Integer> sd = hs[p[n-1]];
        int sum = 0;
        for(int i=n-2;i>=0;i--){
            if(sd==null) break;
            if(sd.isEmpty()) break;
            int k = p[i];
            if(sd.contains(k)){
                sum++;
                sd.remove(k);
                continue;
            }
            if(hs[k]==null) break;
            sd.retainAll(hs[p[i]]);
        }
        System.out.println(sum);
    }
}