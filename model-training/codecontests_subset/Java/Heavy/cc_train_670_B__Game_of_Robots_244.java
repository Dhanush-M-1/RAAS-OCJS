/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package game;

/**
 *
 * @author samsung
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Game{
    
    static class FastScanner{
        BufferedReader s;
        StringTokenizer st;
        
        
        public FastScanner(){
            st = new StringTokenizer("");
            s = new BufferedReader(new InputStreamReader(System.in));
            
        }
        
        public FastScanner(File f) throws FileNotFoundException{
            st = new StringTokenizer("");
            s = new BufferedReader (new FileReader(f));
        }
        
        public int nextInt() throws IOException{
            if(st.hasMoreTokens())
                return Integer.parseInt(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextInt();
            }
        }
        
        public double nextDouble() throws IOException{
            if(st.hasMoreTokens())
                return Double.parseDouble(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextDouble();
            }
        }
        
        public long nextLong() throws IOException{
            if(st.hasMoreTokens())
                return Long.parseLong(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextLong();
            }
        }
        
        public String nextString() throws IOException{
            if(st.hasMoreTokens())
                return st.nextToken();
            else{
                st = new StringTokenizer(s.readLine());
                return nextString();
            }
            
        }
        
        public String readLine() throws IOException{
            return s.readLine();
        }
        
        public void close() throws IOException{
            s.close();
        }
        
    }      //Fastscanner class end
    
   static FastScanner in=new FastScanner();
   static PrintWriter ww=new PrintWriter(new OutputStreamWriter(System.out));
   public static void main(String args[])throws IOException
   {
   //Main ob=new Main();
   Game ob=new Game();
   ob.solve();
   ww.close();
   }
   public void solve()throws IOException
   {
     int n = in.nextInt();
     int k = in.nextInt();
     int a[] = new int[100000];
     int t = 1;
     for(int i=0;i<n;i++)
     {
         a[i]= in.nextInt();
     }
     while(k>t)
     {
         k= k-t;
         t++;
     }
     System.out.println(a[k-1]);
     
 
     
     
    }
}
