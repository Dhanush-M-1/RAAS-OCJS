// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN Main PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
//package Main;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int n = scan.nextInt(), m = scan.nextInt();
        int[] numa = new int[n];
        int[] numb = new int[n];
        for (int i = 0; i < n; i++){
            numa[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++){
            numb[i] = scan.nextInt();
        }
        Arrays.sort(numa);
        Arrays.sort(numb);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int v = (numb[i] - numa[0] + m) % m;
            boolean ok = true;
            for (int j = 0; j < n; j++){
                if ((numb[(i + j) % n] - numa[j] + m) %m != v){
                    ok = false;
                    break;
                }
            }
            if (ok){
                ans = Math.min(ans, v);
            }
        }
        System.out.println(ans);
    }
}
