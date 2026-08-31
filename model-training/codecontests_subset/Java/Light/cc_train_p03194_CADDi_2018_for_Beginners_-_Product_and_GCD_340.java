import java.util.*;


public class Main {
    public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
           
            long a = sc.nextLong();
            long n = sc.nextLong();
            long[] yakusu = new long[2000000];
            long pro = 1;
            if (a == 1) {
                System.out.println(n);
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    while (n >= i && n % i == 0) {
                        yakusu[i] = yakusu[i] + 1;
                         n = n / i;
                    }
                }   
                for (int i = 2; i < yakusu.length; i++) {
                    while (yakusu[i] >= a) {
                        pro = pro * i;
                        yakusu[i] = yakusu[i] -a;
                    }
                }
                System.out.println(pro);
            }


            sc.close();
        }
    
}

