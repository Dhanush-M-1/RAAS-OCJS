import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Code {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.next();
        String second = scanner.next();
        int daysCount = scanner.nextInt();

        System.out.println(first + " " + second);
        for(int day = 1; day <= daysCount; day ++) {
            String killed = scanner.next();
            String replaced = scanner.next();

            if(first.equals(killed)) {
                first = replaced;
            } else {
                second = replaced;
            }

            System.out.println(first + " " + second);
        }
    }
}
