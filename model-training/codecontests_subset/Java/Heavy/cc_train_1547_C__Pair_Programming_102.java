import java.io.*;
import java.util.*;
public class Solution{
    public static void main (String[] args) throws java.lang.Exception {
        FastReader sc = new FastReader();
        int testCase = sc.nextInt();
        while (testCase-->0){
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
            int k = sc.nextInt();
            int m = sc.nextInt(), p = sc.nextInt();
            int[] mono = new int[m], poly = new int[p];
            for(int i=0; i<m; i++) mono[i] = sc.nextInt();
            for(int i=0; i<p; i++) poly[i] = sc.nextInt();
            int n = m+p;
            int mp=0, pp=0;
            boolean check=true;
            while(n-->0){
                if(mp<m && k>=mono[mp]){
                    output.write(mono[mp]+" ");
                    if(mono[mp]==0) k++;
                    mp++;
                }else if(pp<p && k>=poly[pp]){
                    output.write(poly[pp]+" ");
                    if(poly[pp]==0) k++;
                    pp++;
                }else{
                    check = false; break;
                }
            }
            if(check) {
                output.write("\n");
                output.flush();
            }else{
                System.out.println(-1);
            }
        }
    }
    // Fast Reader Class
    static class FastReader {
        BufferedReader br; StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } }return st.nextToken(); }
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() { return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
        String nextLine() { String str = ""; try { str = br.readLine(); }  catch (IOException e) { e.printStackTrace(); }return str; }
    }
}