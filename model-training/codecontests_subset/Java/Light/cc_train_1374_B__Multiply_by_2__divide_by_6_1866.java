import java.util.Scanner;

public class C1374B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0){
            long n = sc.nextLong();

            int count3 = 0;
            int count2 = 0;
            while (n != 0 || n !=1){
                if (n % 3 == 0){
                    n /=3;
                    count3++;
                    continue;
                }

                if (n % 2 == 0){
                    n /= 2;
                    count2++;
                    continue;
                }

                break;
            }


            System.out.println(n == 1 && count3 >= count2 ? 2*count3 - count2 : -1);
        }
    }
}
