import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tst = Integer.parseInt(br.readLine());
        while(tst-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int a = arr[0], b = arr[1], c = arr[n-1];
            if(a+b<=c){
                System.out.println(1+" "+2+" "+(n));
            }
            else System.out.println(-1);
        }
    }
}
