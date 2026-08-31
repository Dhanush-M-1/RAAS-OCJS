/*
Roses are red
Memes are neat
All my test cases time out
Lmao yeet
*/
import java.util.*;
import java.io.*;

   public class A
   {
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         String input = infile.readLine();
         int[] cnt = new int[2];
         for(int i=0; i < N; i++)
         {
            char c = input.charAt(i);
            if(c == '1')
               cnt[1]++;
            else
               cnt[0]++;
         }
         if(cnt[0] != cnt[1])
         {
            System.out.println(1);
            System.out.println(input);
            return;
         }
         else
         {
            System.out.println(2);
            System.out.println(input.charAt(0)+" "+input.substring(1));
         }
      }
   }