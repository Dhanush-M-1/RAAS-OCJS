import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t =Integer.parseInt(br.readLine());
      while(t-->0)
      {
         String s = br.readLine();
         StringBuilder sb = new StringBuilder(s);
         for(int i=1;i<sb.length();i++)
         { if(i==1){
         if(sb.charAt(i)==sb.charAt(i-1))
             sb.setCharAt(i,'*');}
            else if(sb.charAt(i)==sb.charAt(i-1)||sb.charAt(i)==sb.charAt(i-2))
            sb.setCharAt(i,'*');
         }
        int count=0;
      
        for(int i=1;i<sb.length();i++)
         {
            if(sb.charAt(i)=='*')
            count++;
         }
         System.out.println(count);
      }
    }
  }