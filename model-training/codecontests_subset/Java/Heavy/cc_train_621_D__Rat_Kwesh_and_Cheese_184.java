import java.math.*;
import java.io.*;
import java.util.*;
public class C621D{
   public static long[] cAr, div;
   public static int N,M,K;
   public static int[] numCycle;
   public static Map<Integer,Set<Integer>> map;
   public static long MOD = 1000000007;
   public static void main(String[] args) throws IOException{
      InputReader in=new InputReader(new InputStreamReader(System.in));
      PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out));
      double[] ar=in.nextDoubleAr();
      double x=ar[0];
      double y=ar[1];
      double z=ar[2];
      double max=-Double.MAX_VALUE;
      boolean bool=false;
      if(x+y+z<10) bool=true;
      String exp="";
      
      {
         double value=z*Math.log10(y)+Math.log10(Math.log10(x));
         if(bool) value=Math.pow(x,Math.pow(y,z));
         if(value>max){max=value; exp="x^y^z";}
      }
      
      { 
         double value=y*Math.log10(z)+Math.log10(Math.log10(x));
         if(bool) value=Math.pow(x,Math.pow(z,y));
         if(value>max){max=value; exp="x^z^y";}
      }
      
      { 
         double value=Math.log10(y*z*Math.log10(x));
         if(bool) value=Math.pow(x,y*z);
         if(value>max){max=value; exp="(x^y)^z";}
      }
      
      { 
         double value=z*Math.log10(x)+Math.log10(Math.log10(y));
         if(bool) value=Math.pow(y,Math.pow(x,z));
         if(value>max){max=value; exp="y^x^z";}
      }
      
      { 
         double value=x*Math.log10(z)+Math.log10(Math.log10(y));
         if(bool) value=Math.pow(y,Math.pow(z,x));
         if(value>max){max=value; exp="y^z^x";}
      }
      
      { 
         double value=Math.log10(x*z*Math.log10(y));
         if(bool) value=Math.pow(y,x*z);
         if(value>max){max=value; exp="(y^x)^z";}
      }
      
      { 
         double value=y*Math.log10(x)+Math.log10(Math.log10(z));
         if(bool) value=Math.pow(z,Math.pow(x,y));
         if(value>max){max=value; exp="z^x^y";}
      }
      { 
         double value=x*Math.log10(y)+Math.log10(Math.log10(z));
         if(bool) value=Math.pow(z,Math.pow(y,x));
         if(value>max){max=value; exp="z^y^x";}
      }
      
      { 
         double value=Math.log10(x*y*Math.log10(z));
         if(bool) value=Math.pow(z,x*y);
         if(value>max){max=value; exp="(z^x)^y";}
      }
      
      System.out.println(exp);
   }
   
   public static void setUpChoose(int t){
      cAr=new long[t+1];
      div=new long[t+1];
      cAr[0]=1;
      div[0]=1;
      
      for(int x=1;x<=t;x++){
         cAr[x]=(x*cAr[x-1])%(MOD);
         div[x]=pow(cAr[x],MOD-2);} 
   }
   
   public static long choose(int x,int y){
      long a=cAr[x+y];
      long b=div[x];
      long c=div[y];
      a=(a*b)%MOD;
      a=(a*c)%MOD;
      return a;
   } 
   
   public static long pow(long a,long b){
      if(b==1) 
         return a;
      long c=b/2;
      long temp=pow(a,c)%MOD;
      temp=(temp*temp)%MOD;
      if(b%2==1) temp=temp*a;
      return temp%MOD;
   }
}

class InputReader{
   private BufferedReader br;
   public InputReader(InputStreamReader in){
      br=new BufferedReader(in);
   }
   public int nextInt(){
      try{
         return Integer.parseInt(br.readLine());}
      catch(IOException e){throw new InputMismatchException();}
   }
   public int[] nextIntAr(){
      try{
         String[] s=br.readLine().split(" ");
         int[] ret=new int[s.length];
         for(int x=0;x<s.length;x++)
            ret[x]=Integer.parseInt(s[x]);
         return ret;}
         
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public long nextLong(){
      try{
         return Long.parseLong(br.readLine());}
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public long[] nextLongAr(){
      try{
         String[] s=br.readLine().split(" ");
         long[] ret=new long[s.length];
         for(int x=0;x<s.length;x++)
            ret[x]=Long.parseLong(s[x]);
         return ret;}
         
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public double[] nextDoubleAr(){
      try{
         String[] s=br.readLine().split(" ");
         double[] ret=new double[s.length];
         for(int x=0;x<s.length;x++)
            ret[x]=Double.parseDouble(s[x]);
         return ret;}
         
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public String[] nextStringAr(){
      try{
         return br.readLine().split(" ");}
         
      catch(IOException e){throw new InputMismatchException();}
   }
   
   public String nextString(){
      try{
         return br.readLine();}
         
      catch(IOException e){throw new InputMismatchException();}
   }
}
   
class Pair implements Comparable<Pair>{
   long a;
   long b;
   
   public Pair(long ma, long mb){
      a = ma;
      b = mb;
   }
   
   public int compareTo(Pair o){
      if(a == o.a){
         if(b==o.b) 
            return 0;
         return b<o.b?-1:1;
      }
      return a<o.a?-1:1;
   }
}