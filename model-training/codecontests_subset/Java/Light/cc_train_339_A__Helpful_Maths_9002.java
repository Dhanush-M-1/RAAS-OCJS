
import java.util.Arrays;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        //Scanner scan = new Scanner("A.txt");
        Scanner scan = new Scanner(System.in);
        String[] w = scan.nextLine().split("\\+");
        Arrays.sort(w);
        System.out.println(String.join("+", w));
    }

}
