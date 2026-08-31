import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ProblemA {
    
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String[] data = s.readLine().split(" ");
        long n =  Integer.valueOf(data[0]);
        long x =  Integer.valueOf(data[1]);
        long y =  Integer.valueOf(data[2]);
        long need = (n * y + 99) / 100;
        need -= x;
        if (need <= 0) {
            need = 0;
        }
        System.out.println(need);
    }
}