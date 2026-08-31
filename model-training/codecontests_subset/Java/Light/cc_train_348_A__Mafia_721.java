import java.util.*;
import java.io.*;

public class Class{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long sum = 0; int max = 0;
        for(int i=0; i<n; i++){int a = Integer.parseInt(st.nextToken()); max = Math.max(a,max); sum += a;}
        double d = ((double)sum)/(n-1);
        if(d%1==0)System.out.print(Math.max((int)d,max));
        else System.out.print(Math.max((int)d+1,max));
    }
}