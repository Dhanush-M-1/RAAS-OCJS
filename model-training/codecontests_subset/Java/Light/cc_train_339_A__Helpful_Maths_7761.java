import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MathExample {

    public static void main(String[] args) throws IOException {
        // This is unsorted array
        List<Integer> array = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split("\\+");
        for (String str : input) {
            array.add(Integer.parseInt(str));
        }
        Collections.sort(array);
        for (int i = 0; i < array.size() - 1; i++) {
            System.out.print(Integer.toString(array.get(i)));
            System.out.print('+');
        }
        System.out.print(array.get(array.size() - 1));
    }
}