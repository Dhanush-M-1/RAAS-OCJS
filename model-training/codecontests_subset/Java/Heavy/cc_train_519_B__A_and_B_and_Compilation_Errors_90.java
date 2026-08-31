import java.util.Scanner;

public class Task43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      //  System.out.println("Количество ошибок первой компиляции:");
        int firstCompilationErrorsCount = scanner.nextInt();
        int[][] errors = new int[3][firstCompilationErrorsCount];
        for (int i = 1; i <= errors.length; i++) {
            firstCompilationErrorsCount -= 1;
          //  System.out.println("строка #" + i);
            for (int j = 0; j <= firstCompilationErrorsCount; j++) {
                errors[i - 1][j] = scanner.nextInt();
            }
        }
        // long start = System.nanoTime();
        int[] fixedErrors = findFixedErrors(errors);
        for (int i = 0; i < fixedErrors.length; i++) {
            System.out.println(fixedErrors[i]);
        }
        // System.out.println(System.nanoTime() - start);
    }

    private static int[] findFixedErrors(int[][] errors) {
        int firstLine = 0;
        int secondLine = 0;
        int thirdLine = 0;
        for (int i = 0; i < errors[0].length; i++) {
            firstLine += errors[0][i];
            secondLine += errors[1][i];
            thirdLine += errors[2][i];
        }
        int[] result = {firstLine - secondLine, secondLine - thirdLine};
        return result;
    }
}