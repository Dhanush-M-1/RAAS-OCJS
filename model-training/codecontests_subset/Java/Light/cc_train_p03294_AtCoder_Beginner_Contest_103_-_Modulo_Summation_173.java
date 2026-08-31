import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int sum = 0;
        for(int x= 0; x<N; x++){
             sum = sum + scanner.nextInt();
        }
        System.out.println(sum-N);


    }

}
