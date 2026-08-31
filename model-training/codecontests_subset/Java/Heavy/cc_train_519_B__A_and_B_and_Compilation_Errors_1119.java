import java.util.Arrays;
import java.util.Scanner;

public class b519 {
    private static int[] readArray(Scanner scanner, int numElements) {
        int[] output = new int[numElements];
        for (int numBug = 0; numBug < numElements; numBug++) {
            output[numBug] = scanner.nextInt();
        }
        Arrays.sort(output);
        scanner.nextLine();
        return output;
    }
    private static int difference(int[] longArray, int[] shortArray) {
        int solution = longArray[longArray.length - 1];
        for(int position = 0; position < shortArray.length; position++) {
            if (longArray[position] != shortArray[position]) {
                solution = longArray[position];
                break;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numBugs = Integer.parseInt(scanner.nextLine());
        int[] original = readArray(scanner, numBugs);
        int[] stepOne = readArray(scanner, numBugs - 1);
        int[] stepTwo = readArray(scanner, numBugs - 2);
        System.out.println(difference(original, stepOne));
        System.out.println( difference(stepOne, stepTwo));

    }
}
