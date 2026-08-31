/*
roses are red
memes are neat
all my tests cases are wrong
lmao yeet
*/
import java.util.*;
import java.io.*;

   public class A
   {
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int L = Integer.parseInt(st.nextToken());
         int R = Integer.parseInt(st.nextToken());
         if(L == R)
            System.out.println(L);
         else
         {
            System.out.println(2);
         }
      }
   }