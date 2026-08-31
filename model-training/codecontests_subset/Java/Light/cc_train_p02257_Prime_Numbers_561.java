import java.io.*;

class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int prime = 0;
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(br.readLine());
            if (isPrime(element)) prime++;
        }
        System.out.println(prime);
    }

    static boolean isPrime (int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}