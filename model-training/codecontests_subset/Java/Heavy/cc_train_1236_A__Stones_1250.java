import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main implements Runnable, AutoCloseable {
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    //    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream out = new PrintStream(new BufferedOutputStream(System.out));

    @Override
    public void run() {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            doOnce();
        }
    }

    private void doOnce() {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int ansa = 0;
        int v1 = Math.min(c / 2, b);
        ansa += v1;
        b -= v1;
        ansa += Math.min(b / 2, a);
        out.println(ansa * 3);
    }

    public static void main(String[] args) {
        try (Main main = new Main()) {
            main.run();
        }
    }

    @Override
    public void close() {
        out.close();
    }
}