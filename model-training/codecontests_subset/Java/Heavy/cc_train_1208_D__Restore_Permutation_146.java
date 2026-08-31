/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
If I'm the sun, you're the moon
Because when I go up, you go down
*******************************
I'm kinda bad
Why am I using lazytree to update range when I can just update using BIT
*/
import java.util.*;
import java.io.*;

   public class x1208D2
   {
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         long[] arr = new long[N];
         st = new StringTokenizer(infile.readLine());
         for(int i=0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());
         //ah yes time to change color
         //find prefixes, update while bin searching
         HashSet<Integer> bin = new HashSet<Integer>();
         for(int i=1; i <= N; i++)
            bin.add(i);
         FenwickTree sums = new FenwickTree(N+1);
         for(int i=1; i <= N; i++)
            sums.add(i, i);
         int[] res = new int[N];
         for(int dex=N-1; dex >= 0; dex--)
         {
            //reverse order checks out
            int low = 1;
            int high = N;
            while(low != high)
            {
               int mid = (low+high)/2;
               long check = sums.query(0, mid-1);
               if(check == arr[dex] && bin.contains(mid))
               {
                  sums.add(mid, -1*mid);
                  res[dex] = mid;
                  bin.remove(mid);
                  break;
               }
               else if(check == arr[dex])
                  low = mid+1;
               else if(check < arr[dex])
                  low = mid+1;
               else
                  high = mid-1;
            }
            //guaranteed to have an answer
            if(res[dex] == 0)
            {
               int mid = (low+high)/2;
               long check = sums.query(0, mid-1);
               if(check == arr[dex] && bin.contains(mid))
               {
                  sums.add(mid, -1*mid);
                  res[dex] = mid;
                  bin.remove(mid);
               }
            }
         }
         StringBuilder sb = new StringBuilder();
         for(int i=0; i < N; i++)
            sb.append(res[i]+" ");
         System.out.println(sb.toString());
      }
   }
   class FenwickTree
   {
      //1 indexed
      public long[] tree;
      public int size;
      
      public FenwickTree(int size)
      {
         this.size = size;
         tree = new long[size+5];
      }
      public void add(int i, int v)
      {
         while(i <= size)
         {
            tree[i] += v;
            i += i&-i;
         }
      }
      public long find(int i)
      {
         long res = 0L;
         while(i >= 1)
         {
            res += tree[i];
            i -= i&-i;
         }
         return res;
      }
      public long query(int l, int r)
      {
         //inclusive range
         return find(r)-find(l-1);
      }
   }