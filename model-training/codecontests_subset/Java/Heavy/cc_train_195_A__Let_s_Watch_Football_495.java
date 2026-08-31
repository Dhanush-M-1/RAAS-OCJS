import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class A implements Runnable {

    private PrintWriter out = new PrintWriter(System.out, true);
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        int movieBps = scanner.nextInt(), 
            connectionBps = scanner.nextInt(), 
            len = scanner.nextInt();

        int totalMovieSize = movieBps * len;
        int totalTimeToDownload = totalMovieSize / connectionBps;
        
        int result = totalTimeToDownload - len;
        if (totalMovieSize % connectionBps != 0) {
            result++;
        }
        
        out.print(result);
        out.flush();
    }

    void setIn(InputStream in) {
        this.scanner = new Scanner(in);
    }

    void setOut(PrintWriter out) {
        this.out = out;
    }

    public static void main(String[] args) {
        new A().run();
    }
}