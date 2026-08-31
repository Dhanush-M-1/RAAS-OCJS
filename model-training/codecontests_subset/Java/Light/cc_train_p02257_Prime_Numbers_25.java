import java.util.Scanner;

class Main { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;
        
        boolean primes[] = new boolean [100000000];
        for(int n = 2; n < primes.length; n++){
            if(primes[n]) continue;
            for(int m = 2 * n; m < primes.length; m += n){
                primes[m] = true;
            }
        }
               
        while (N != 0) {
            int num = in.nextInt();
            if (!primes[num]) count++;
            N--;
        }
        
        System.out.println(count);
    }
}