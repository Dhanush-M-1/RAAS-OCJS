import java.util.Scanner;

public class Question1 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int n = scan.nextInt();
            int c = b ^ a;

            int div = n % 3;
            switch (div){
                case 0:
                    System.out.println(a);
                    break;
                case 1:
                    System.out.println(b);
                    break;
                case 2:
                    System.out.println(c);
                    break;
            }
        }
    }
}
