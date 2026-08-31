// package Practice2.CF44;

import java.util.Scanner;

public class CF044B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        if(a/2 + b + 2*c < n){
            System.out.println(0);
        }else{
            int count = 0;
            for (int i = 0; i <= b; i++) {
                for (int j = 0; j <= c; j++) {
                    int sum = i + 2*j;
                    if(sum == n){
                        count++;
                    }else{
                        int balance = n - sum;
                        if(balance < 0){
                            continue;
                        }
                        if(balance <= a/2){
                            count++;
                        }
                    }
                }

            }
            System.out.println(count);
        }
    }
}
