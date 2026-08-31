import java.util.Scanner;

public class Main {

    static public void main(String []args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        int t = input.nextInt();
        for(int i = 0 ; i < t; i ++ ){
            int a = input.nextInt();
            int b = input.nextInt();
            int n = input.nextInt();
            int result[] = {a, b , a ^ b};
            System.out.println(result[n % 3]);
        }
    }
}
