import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] array = new int[n][2];
        for(int i=0;i<n;i++){
            array[i][0]=Integer.parseInt(st.nextToken());
            array[i][1]=i;
        }
        Arrays.sort(array,(int[] a,int[] b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }
            else{
                return a[1]-b[1];
            }
        });
        int m = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(m-->0){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st1.nextToken());
            int pos = Integer.parseInt(st1.nextToken())-1;
            int[][] seq = new int[k][2];
            for(int i=0;i<k;i++){
                seq[i][0]=array[i][0];
                seq[i][1]=array[i][1];
            }
            Arrays.sort(seq,(int[] a,int[] b)->{return a[1]-b[1];});
            sb.append(seq[pos][0]).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
        