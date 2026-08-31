/*
   #######  ######    #####  ######  ######  #####
    #    #  #    #      #    #    #  #    #    #
    #    #  # #  #      #    # ## #  # ## #    #
    #    #  #  #    #   #    #    #  #    #    #
   #######  #   #   # # #    #    #  #    #    #
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.StringTokenizer;
public class runforPrize {
    static PrintStream p = System.out;
    static long mod = (long)10e9+7;
    public static void main(String args[] ) throws Exception {
        int n = nextInt();
        int min = (int)10e5;
        int max = Integer.MIN_VALUE;
        int counta =0;
        int countb = 0;
        for(int i=0;i<n;i++){
            int val = nextInt();
            if(val<=500000){        
                max = val-1;
            }else if(counta==0){
                counta=1;
                min = val;
            }
        }
        
        p.println(Math.max(max,1000000-min));
        
    }



//-------------------------------------------------fast Method---------------------------------------------------------------\\
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    private static int[] inta(int n){
        int [] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
            return a;
    }
    private static long[] longa(long n){
    long[] a = new long[(int)n];
        for(int i = 0;i < n;i++)a[i] = nextLong();
            return a;
    }
    private static void pla(long[] a){
        for(int i = 0;i <a.length;i++)
            p.print(a[i]+" ");
    }
    private static void pia(int[] a){
        for(int i = 0;i <a.length;i++)
            p.print(a[i]+" ");
    }
    private static String next(){
        while (st == null || !st.hasMoreElements()){
            try{
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e){
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    private static int nextInt(){
        return Integer.parseInt(next());
    }

    private static long nextLong(){
        return Long.parseLong(next());
    }

    private static double nextDouble(){
        return Double.parseDouble(next());
    }
    private static String nextLine(){
        String str = "";
        try{
            str = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }
//-------------------------------------------------fast Method---------------------------------------------------------------\\
} 