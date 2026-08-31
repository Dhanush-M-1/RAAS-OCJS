

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for(int p: arr)
        {
            if(isPrime(p)) count++;
        }
        System.out.println(count);
    }
    public static boolean isPrime(int N) {
        if(N == 1) return false;
        for(long i = 2; i * i <= N; i++) {
            if(N % i == 0) return false;
        }
        return true;
    }
}

