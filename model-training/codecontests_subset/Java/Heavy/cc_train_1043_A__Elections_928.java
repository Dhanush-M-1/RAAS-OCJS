    // Where there is a will, there is a way !


import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        /*
inputCopy
5
1 1 1 5 1
outputCopy
5
inputCopy
5
2 2 3 2 2
outputCopy
5

         */
          int n=Integer.parseInt(br.readLine());
          int [] arr=new int[n];
          st=new StringTokenizer(br.readLine());
          int votes=0;
          int max=Integer.MIN_VALUE;
          for(int i=0;i<arr.length;++i)
          {
              arr[i]=Integer.parseInt(st.nextToken());
              if(arr[i]>max)
              {
                  max=arr[i];
              }
              votes+=arr[i];
          }
          votes=votes+(votes+1);
          //pw.println(votes);
          
          int k=(int)Math.ceil((double)votes/n);
          k=Math.max(k,max);
          pw.println(k);
        pw.flush();
        pw.close();
    }
}
