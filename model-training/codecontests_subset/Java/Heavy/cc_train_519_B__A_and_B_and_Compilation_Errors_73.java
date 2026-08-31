import java.io.*;
import java.util.*;
public class CF519B {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sum1 = 0;
        for (int i = 0; i < N; i++){
            sum1 += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int sum2 = 0;
        for (int i = 0; i < N-1; i++){
            sum2 += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int sum3 = 0;
        for (int i = 0; i < N-2; i++){
            sum3 += Integer.parseInt(st.nextToken());
        }
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }

}