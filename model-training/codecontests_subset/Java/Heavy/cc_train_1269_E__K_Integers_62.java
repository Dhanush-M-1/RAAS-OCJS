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

   public class x1269E
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int[] arr = new int[N];
         int[] map = new int[N+1];
         st = new StringTokenizer(infile.readLine());
         for(int i=0; i < N; i++)
         {
            arr[i] = Integer.parseInt(st.nextToken());
            map[arr[i]] = i;
         }
         //brain tumor
         StringBuilder sb = new StringBuilder();
         FenwickTree bit = new FenwickTree(N+1);
         FenwickTree pos = new FenwickTree(N+1);
         //ArrayList<Integer> pos = new ArrayList<Integer>();
         long res = 0L;
         for(int i=1; i <= N; i++)
         {
            int dex = map[i]+1;
            res += bit.find(dex, N);
            bit.add(dex, 1);
            pos.add(dex, dex);
            //has pos.size()/2 elements to the left
            int low = 1;
            int high = N;
            while(low != high)
            {
               int mid = (low+high+1)/2;
               if(bit.find(mid-1) > i/2)
                  high = mid-1;
               else
                  low = mid;
            }
            //fft (fuck fenwick trees)
            long left_count = bit.find(low-1);
            long temp = -1*pos.find(low-1);
            temp -= left_count*(left_count+1)/2;
            temp += left_count*(long)low;
            long right_count = bit.find(low+1, N);
            long temp2 = pos.find(low+1, N);
            temp2 -= right_count*(right_count+1)/2;
            temp2 -= right_count*(long)low;
            sb.append(res+temp+temp2+" ");
         }
         System.out.println(sb);
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
      public long find(int l, int r)
      {
         return find(r)-find(l-1);
      }
   }