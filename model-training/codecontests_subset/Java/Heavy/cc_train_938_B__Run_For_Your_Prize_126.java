import java.util.*;
import java.io.*;
public class Ankita {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int array[] = new int[n + 2];
        array[0] = 1;
        array[n + 1] = 1000_000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= n;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Math.min(array[n] - 1, 1000_000 - array[1]);
        //System.out.println(ans);
        for(int i = 1;i < n;i++){
            int time = Math.max(array[i] - 1, 1000_000 - array[i + 1]);
            ans = Math.min(ans, time);
        }
        System.out.println(ans);
    }
}
