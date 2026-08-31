

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = readInt(br);
        while (t-- > 0) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        int n = readInt(br);
        int step = 0;
        while (n != 1) {
            if(n % 6 == 0) {
                n = n / 6;
                step++;
            } else if(n % 3 == 0) {
                n = n * 2;
                step++;
            } else {
                step = -1;
                break;
            }
        }
        System.out.println(step);

    }

    private static int readInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static Integer[] readArray(BufferedReader br) throws IOException {
        Integer[] boxed = Stream.of(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        return boxed;
    }
}
