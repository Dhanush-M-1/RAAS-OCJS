import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int c = input.nextInt();
        int v0 = input.nextInt();
        int v1 = input.nextInt();
        int a = input.nextInt();
        int l = input.nextInt();
        int days = 0, lastPage = l, readSpeed = v0;
        while (true) {
            days++;
            lastPage -= l;
            lastPage += readSpeed;
            if (lastPage >= c) {
                break;
            }
            readSpeed += a;
            if (readSpeed > v1) {
                readSpeed = v1;
            }
        }
        System.out.println(days);
    }
}