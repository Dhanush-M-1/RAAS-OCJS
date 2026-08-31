import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] supp = new int[n];
        final int[] kek = {0};
        Arrays.stream(supp).map(operand -> (supp[kek[0]] = kek[0]++)).toArray();
        int[][] fullMatrix = new int[n][n];
        Arrays.stream(supp).map(k -> Arrays.stream(supp).map(i -> fullMatrix[k][i] = scanner.nextInt()).sum()).toArray();
        Arrays.stream(supp).map(k -> Arrays.stream(supp).map(i -> Arrays.stream(supp).map(j -> fullMatrix[i][j] = Math.min(fullMatrix[i][k] + fullMatrix[k][j], fullMatrix[i][j])).sum()).sum()).toArray();
        System.out.println(Arrays.stream(fullMatrix).map(ints -> Arrays.stream(ints).max().getAsInt()).mapToInt(value -> (Integer)value).max().getAsInt());
    }
}
