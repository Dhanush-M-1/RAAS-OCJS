
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.ToIntFunction;

public class Solution {

    public static int[] toIntFromString(String[] arr) {
        return Arrays.stream(arr).mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        }).toArray();
    }

    public static int solve(int N, int K, int[] arr) {
        Arrays.sort(arr);
        for (int i = N - 1; i >= 0; i--) {
            if(arr[i]<= K && K % arr[i] == 0) {
                return K / arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = toIntFromString(br.readLine().split(" "));
        int[] arr = toIntFromString(br.readLine().split(" "));
        System.out.println(solve(NK[0], NK[1], arr));
    }
}