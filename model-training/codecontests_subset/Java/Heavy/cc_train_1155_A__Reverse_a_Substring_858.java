/*
Roses are red
Memes are neat
All my test cases are wrong
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
         String str = infile.readLine();
         PriorityQueue<Character> pq = new PriorityQueue<Character>();
         for(char c: str.toCharArray())
            pq.add(c);
         for(int i=0; i < N-1; i++)
         {
            char c = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(c > c2)
            {
               System.out.println("YES");
               System.out.println((i+1)+" "+(i+2));
               return;
            }
         }
         System.out.println("NO");
      }
   }