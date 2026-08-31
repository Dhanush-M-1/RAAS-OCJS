import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), x = scan.nextInt(), y = scan.nextInt();
        int participant = n-(n - x);
        double required = Math.ceil((((double)y/100)*((double)n)));
        if(required>=participant) System.out.println(((int)required) - participant);
        else System.out.println(0);
    }
}