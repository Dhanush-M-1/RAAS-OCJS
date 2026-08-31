import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        long[] array = new long[n];
        for(int i=0;i<n;i++){
            array[i]=Long.parseLong(st.nextToken());
        }
        StringBuffer sb = new StringBuffer();
        sb.append("1 1\n");
        sb.append(-array[0]).append("\n");
        if(n==1){
            sb.append("1 1\n0\n1 1\n0");
            System.out.println(sb);
            return;
        }
        array[0]=0;
        sb.append("2 ").append(n).append("\n");
        for(int i=1;i<n;i++){
            long add = array[i]*(n-1);
            sb.append(add).append(" ");
            array[i]+=add;
        }
        sb.append("\n");
        sb.append("1 ").append(n).append("\n");
        for(int i=0;i<n;i++){
            sb.append(-array[i]).append(" ");
        }
        System.out.println(sb);
    }
}