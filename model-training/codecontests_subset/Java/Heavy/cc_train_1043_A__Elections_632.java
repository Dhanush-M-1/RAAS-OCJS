import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        List<Integer> votes = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        int max = votes.stream().mapToInt(i -> i).max().getAsInt();
        int sum = votes.stream().mapToInt(i -> i).sum();
        int k = Math.max((2 * sum + 1) / n + ((2 * sum + 1) % n != 0 ? 1 : 0), max);
        System.out.println(k);
    }

}