import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
   static class FastReader{
         BufferedReader br;
         StringTokenizer st;
         public FastReader()throws IOException{
          br=new BufferedReader(new InputStreamReader(System.in));
         }
         public FastReader(String s)throws IOException{
          br=new BufferedReader(new FileReader(new File(s)));
         }
         String next(){
           while(st==null || !st.hasMoreElements()){
             try{
                st=new StringTokenizer(br.readLine());
             }
             catch(Exception e){
               e.printStackTrace();
             }
           }
           return st.nextToken();
         }
         String nextLing(){
            String str="";
            try{
              str=br.readLine();
                 }
             catch(Exception e){
               e.printStackTrace();
             }
             return str;
         }
         int nextInt(){
         return Integer.parseInt(next());
         }
         long nextLong(){
          return Long.parseLong(next());
         }
         double nextDouble(){
          return Double.parseDouble(next());
         }
   
   }
    static class pair implements Comparable<pair>{
             int a,b;
             public pair(int x,int y){
                a=x;b=y;
             
             }
             public int compareTo(pair p){
                      if(a==p.a){
                          return b-p.b;
                      }
                      return a-p.a;
             }
    
    }
   public static void main(String args[])throws IOException{
              FastReader in=new FastReader();
              int T=in.nextInt();
              while(T-->0){
                 int n=in.nextInt();
                long a[]=new long[n];
                for(int i=0;i<n;i++)
                  a[i]=in.nextLong();
               if(a[0]+a[1]<=a[n-1])
                 System.out.println("1 2 "+n);
               else
                 System.out.println("-1");
              
              }
              
           } 	
}  

