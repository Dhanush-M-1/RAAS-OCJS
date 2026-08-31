/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author billy
 */
public class ReadingBooks {

    /**
     * @param args the command line arguments
     */
    
    static class Triple implements Comparable<Triple>{
        int x;
        int y;
        int z;

        Triple (int x0, int y0, int z0){
            x=x0;
            y=y0;
            z = z0;

        }
        public int compareTo(Triple e){
            return x - e.x;
            
        }
    }
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;



    public static void main(String[] args) throws IOException {
        
        int n = readInt();
        int k = readInt();
        ArrayList<Triple> ab = new ArrayList();
        ArrayList<Integer> a = new ArrayList();
        ArrayList<Integer> b = new ArrayList();
        
        
        for (int i=0; i<n; i++){
            int t = readInt();
            int a1 = readInt();
            int b1= readInt();
            
            if (a1 ==1 && b1==1){
                ab.add(new Triple(t,a1,b1));
            }
            else if (a1==1 && b1==0){
                a.add(t);
            }
            else if (a1==0 && b1==1){
                b.add(t);
            }
            else{
                continue;
            }
        }
        Collections.sort(a);
        Collections.sort(b);
        
        for (int i =0; i<Math.min(a.size(), b.size()); i++){
            int t1 = a.get(i);
            int t2 = b.get(i);
            ab.add(new Triple(t1+t2,1,1));
        }
        Collections.sort(ab);
        long ans = 0;
        int ak = 0;
        int bk = 0;
       
        for (int i =0; i<ab.size();i++){
            ans+=ab.get(i).x;
            ak++;
            bk++;
            if (ak>=k){
                break;
            }
        }
        if (ak<k){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
        
        
        
        
        /*
        three lists types to consider
        AB: add to this list
        A: sort by times
        B: sort by times
        pair up A and B to make AB, add to AB list, and sort again
        
        
        */
        
    }





    static String read () throws IOException {
        while (st == null || !st.hasMoreTokens())
           st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    //© Maillew DMOJ
    static long readLong () throws IOException {
        return Long.parseLong(read());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(read());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(read());
    }
    static char readChar () throws IOException {
        return read().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
   
    
}
