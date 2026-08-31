import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class easy {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumOne = 0, sumTwo = 0, sumThree = 0;
        for(int i = 0; i < n; i++) sumOne += sc.nextInt();
        for(int i = 0; i < n-1; i++) sumTwo += sc.nextInt();
        for(int i = 0; i < n-2; i++) sumThree += sc.nextInt();

        System.out.println(sumOne - sumTwo);
        System.out.println(sumTwo - sumThree);
    }
}
