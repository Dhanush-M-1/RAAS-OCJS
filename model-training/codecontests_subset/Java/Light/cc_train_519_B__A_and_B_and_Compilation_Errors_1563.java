import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = 0, second = 0, third = 0;
        for(int i=0;i<n;i++){
            first+=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            second+=sc.nextInt();
        }
        for(int i=0;i<n-2;i++){
            third+=sc.nextInt();
        }
        System.out.printf("%d\n%d",first-second,second-third);
    }
}