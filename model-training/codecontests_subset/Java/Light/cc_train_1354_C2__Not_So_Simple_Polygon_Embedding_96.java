import java.io.*;

import java.util.*;

public class CodeForce {
 static ArrayList<Integer> inputarrlist(String[] str){
     ArrayList<Integer> arr=new ArrayList<>();
     for(int i=0;i<str.length;i++)
         arr.add(Integer.parseInt(str[i]));
     
     return arr;
 }
 static long[] inputarr(String[] str){
     long[] arr=new long[str.length];
     for(int i=0;i<str.length;i++)
         arr[i]=(Long.parseLong(str[i]));
     
     return arr;
 }
 
 static long gcd(long a, long b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
 
 static double myfunction(double n, double a) 
    { 
  
       
        if (a < 0 && n < 0) 
            return -1; 
  
        
        return  Math.cos(Math.PI / (2 * n)) / Math.sin(Math.PI / (n)); 
    } 
 
 
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
       int n=Integer.parseInt(br.readLine());
       double ans=myfunction((double)2*n,(double)1);
            System.out.println(ans);
        }
}}