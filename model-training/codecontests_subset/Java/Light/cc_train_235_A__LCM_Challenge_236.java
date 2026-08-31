import java.util.Scanner;

public class LcmChallenge {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        long  n = scanner.nextLong();

        if(n <= 2){
            System.out.println(n);
        }
        else if(n % 2 == 0 && n % 3 != 0){
            System.out.println(n * (n - 1) * (n - 3));
        }
        else if(n % 3 == 0 && n % 2 == 0){
            System.out.println((n - 1) * (n - 2) * (n - 3));
        }
        else{
            System.out.println(n * (n - 1) * (n - 2));
        }
    }
}
