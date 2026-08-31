/* AC Please. it has taken me a lot of time to implement */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int sum = 0;
        int max =  Integer.MIN_VALUE;

        int arr[] = new int [n];

        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = Integer.parseInt(st1.nextToken());
            sum += arr[i];

            if(arr[i] > max)
                max = arr[i];
        }

        max = Math.max((int)(Math.ceil(2.0*sum/(1.0*n))) , max);

        int sum2 =0;
        for(int i = 0 ; i < n ; i++)
            sum2 += max - arr[i];

        out.println(sum2 == sum ? max+1 : max );





        out.flush();
        out.close();

    }

    static class Edge implements Comparable<Edge>
    {
        int dX, dY;

        Edge(int a, int b) { dX = a; dY = b; }

        public int compareTo(Edge e){
            if(dX > e.dX)
                return 1;
            if(dX < e.dX)
                return -1;
            if(dX == e.dX)
            {
                if(dY > e.dY)
                    return 1;
                if(dY < e.dY)
                    return -1;
            }

            return 0;
        }

    }
}
