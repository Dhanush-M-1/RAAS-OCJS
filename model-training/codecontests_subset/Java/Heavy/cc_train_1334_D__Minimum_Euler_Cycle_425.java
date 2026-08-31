/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
If I'm the sun, you're the moon
Because when I go up, you go down
*******************************
I'm working for the day I will surpass you
https://www.a2oj.com/Ladder16.html
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class x1334D
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int T = Integer.parseInt(st.nextToken());
         StringBuilder sb = new StringBuilder();
         outer:while(T-->0)
         {
            st = new StringTokenizer(infile.readLine());
            int N = Integer.parseInt(st.nextToken());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            long val = 0L;
            for(int i=1; i < N; i++)
            {
               if(val+2*(N-i) >= L)
               {
                  long startdex = val+1;
                  R -= startdex;
                  L -= startdex;
                  ArrayList<Integer> ls = new ArrayList<Integer>();
                  ls.add(i);
                  int next = i+1;
                  for(int a=1; a < 2*(N-i); a++)
                  {
                     if(a%2 == 1)
                        ls.add(next++);
                     else
                        ls.add(i);
                  }
                  int boof = i;
                  while(boof+1 < N && ls.size() <= R)
                  {
                     ls.add(boof+1);
                     next = boof+2;
                     for(int a=1; a < 2*(N-boof-1); a++)
                     {
                        if(a%2 == 1)
                           ls.add(next++);
                        else
                           ls.add(boof+1);
                     }
                     boof++;
                  }
                  if(boof+1 >= N)
                     ls.add(1);
                  //print
                  for(int a = (int)L; a <= R; a++)
                     sb.append(ls.get(a)+" ");
                  sb.append("\n");
                  continue outer;
               }
               else
                  val += 2*(N-i);
            }
            sb.append("1\n");
         }
         System.out.print(sb);
      }
   }