import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();
        if((a+b+c+d+e) == 0) {System.out.println(-1);return;}
        if((a+b+c+d+e) % 5 == 0) System.out.println((a+b+c+d+e)/5);
        else System.out.println(-1);

    }
}


