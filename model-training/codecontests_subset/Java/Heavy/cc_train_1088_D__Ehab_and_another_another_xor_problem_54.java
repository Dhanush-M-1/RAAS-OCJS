/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package taskD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author chiendb
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        TaskD solver = new TaskD();
        solver.solve(in);
    }
    
    static class TaskD {
        int a = 0, b = 0;
        public void solve(FastReader in) throws IOException {
            boolean flask = true;
            System.out.println("? " + a + " " + b);
            System.out.flush();
            int res = in.nextInt();
            if (res == -1) {
                flask = false;
            }
            for (int i = 29; i >= 0; --i) {
                int curA, curB, res1, res2;
                curA = a + (1 << i);
                curB = b;
                System.out.println("? " + curA + " " + curB);
                System.out.flush();
                res1 = in.nextInt();
                curA = a;
                curB = b + (1 << i);
                System.out.println("? " + curA + " " + curB);
                System.out.flush();
                res2 = in.nextInt();
                if (res1 == res2) {    
                    if (flask) {
                        a += (1 << i);
                    }
                    else {
                        b += (1 << i);
                    }
                    if (res1 == 1) {
                        flask = true;
                    }
                    else {
                        flask = false;
                    }      
                }
                else if (res1 == -1) {
                    a += (1 << i);
                    b += (1 << i);
                }
            }
            System.out.println("! " + a + " " + b);
            System.out.flush();
        }
    }
    
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(InputStream stream) 
        { 
            br = new BufferedReader(new InputStreamReader(stream)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
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
