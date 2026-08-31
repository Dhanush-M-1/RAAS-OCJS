import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    

    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] deg = new int[n];
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int l= Integer.parseInt(st.nextToken())-1;
            int r= Integer.parseInt(st.nextToken())-1;
            deg[l]++;
            deg[r]++;
        }
        boolean ok = true;
        for(int i=0;i<n;i++) if(deg[i]==2) ok = false;
        if(ok) System.out.println("YES");
        else System.out.println("NO");
    }
}

