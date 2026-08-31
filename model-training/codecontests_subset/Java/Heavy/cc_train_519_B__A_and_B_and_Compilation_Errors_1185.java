import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> errorCodes = getSortedErrorCodes(scanner, n);
        List<Integer> errorCodesWithoutOne = getSortedErrorCodes(scanner, n - 1);
        int errorCodeOne = findErrorCodeElement(errorCodes, errorCodesWithoutOne);

        List<Integer> errorCodesWithoutTwo = getSortedErrorCodes(scanner, n - 2);
        int errorCodeTwo = findErrorCodeElement(errorCodesWithoutOne, errorCodesWithoutTwo);

        System.out.println(errorCodeOne);
        System.out.println(errorCodeTwo);
    }

    private static int findErrorCodeElement(List<Integer> errorCodes, List<Integer> errorCodesWithoutOne) {
        int size = errorCodesWithoutOne.size();
        for (int i = 0; i < size; i++) {
            int errorCode1 = errorCodes.get(i);
            int errorCode2 = errorCodesWithoutOne.get(i);
            if (errorCode1 != errorCode2)
                return errorCode1;
        }

        return errorCodes.get(size);
    }

    private static List<Integer> getSortedErrorCodes(Scanner scanner, int n) {
        List<Integer> errorCodes = new ArrayList<>(n);
        readErrorCodes(scanner, n, errorCodes);
        Collections.sort(errorCodes);
        return errorCodes;
    }

    private static void readErrorCodes(Scanner scanner, int n, List<Integer> errorCodes) {
        for (int i = 0; i < n; i++) {
            int errorCode = scanner.nextInt();
            errorCodes.add(errorCode);
        }
    }

}
