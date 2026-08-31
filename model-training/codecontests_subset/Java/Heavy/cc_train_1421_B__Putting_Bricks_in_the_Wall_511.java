import java.io.*;
import java.util.*;

public class A
{
    static int n;
    static int[] arr;
    static char[][] s;
    public static void main(String[] args) throws IOException
    {
        Flash f = new Flash();
        int T = f.ni();
        for(int tc = 1; tc <= T; tc++){
            n = f.ni();
            s = new char[n][n];
            for(int i = 0; i < n; i++){
                s[i] = f.ns().toCharArray();
            }
            
            fn();
        }
    }
    
    static void fn()
    {
        List<int[]> ans = new ArrayList<>();
        if(s[1][0] == '0' && s[0][1] == '0'){
            if(s[n-1][n-2] == '0') ans.add(new int[]{n-1, n-2});
            if(s[n-2][n-1] == '0') ans.add(new int[]{n-2, n-1});
        }
        
        else if(s[1][0] == '1' && s[0][1] == '1'){
            if(s[n-1][n-2] == '1') ans.add(new int[]{n-1, n-2});
            if(s[n-2][n-1] == '1') ans.add(new int[]{n-2, n-1});
        }
        
        else{
            if(s[n-1][n-2] == '0' && s[n-2][n-1] == '0'){
                if(s[0][1] == '0') ans.add(new int[]{0, 1});
                if(s[1][0] == '0') ans.add(new int[]{1, 0});
            }
            
            else if(s[n-1][n-2] == '1' && s[n-2][n-1] == '1'){
                if(s[0][1] == '1') ans.add(new int[]{0, 1});
                if(s[1][0] == '1') ans.add(new int[]{1, 0});
            }
            
            else{
                if(s[1][0] == '0') ans.add(new int[]{1, 0});
                else ans.add(new int[]{0, 1});
                
                if(s[n-1][n-2] == '1') ans.add(new int[]{n-1, n-2});
                else ans.add(new int[]{n-2, n-1});
            }
        }
        
        sop(ans.size());
        for(int[] a : ans) sop((a[0]+1) + " " + (a[1]+1));
    }
    
    static void sort(int[] a){
        List<Integer> A = new ArrayList<>();
        for(int i : a) A.add(i);
        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) a[i] = A.get(i);
    }
    
    static int swap(int itself, int dummy){
        return itself;
    }
    
    static void sop(Object o){ System.out.println(o); }
    
    static void print(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++) sb.append(a[i] + " ");
        System.out.println(sb);
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