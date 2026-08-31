import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        br.close();
        int n = new Integer(st.nextToken());
        int c = new Integer(st.nextToken());
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i]=new Integer(st1.nextToken());
        }
        int profit=0;
        for(int i=0;i<n-1;i++){
            profit=Math.max(array[i]-array[i+1]-c,profit);
        }
        System.out.println(profit);
    }
}