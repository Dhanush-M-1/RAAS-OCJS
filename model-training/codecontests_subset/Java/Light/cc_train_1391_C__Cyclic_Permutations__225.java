import java.util.*;
import java.io.*;

public class C1391 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mod = (long)1e9 + 7;

        long totalWays = 1;
        long nonCyclicWays = 1;

        for(int i = 2;i <= n;i++){
            totalWays *= i;
            nonCyclicWays *= 2;

            totalWays %= mod;
            nonCyclicWays %= mod;
        }

        totalWays -= nonCyclicWays;
        if(totalWays < 0){
            totalWays += mod;
        }

        System.out.println(totalWays);
    }
}
