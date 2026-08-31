import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Round123A {

    public static void main(String[] args) throws IOException {
        new Round123A().run();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader);
        PrintWriter writer = new PrintWriter(System.out);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        writer.print((int)Math.ceil(((double)(a * c)) / b - c));

        scanner.close();
        writer.close();
    }
}
