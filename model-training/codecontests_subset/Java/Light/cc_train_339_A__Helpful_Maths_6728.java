import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        String[] inputNum = input.split("\\+");
        int[] output = new int[inputNum.length];
        for (int i = 0; i < inputNum.length; i++) {
            output[i] = Integer.parseInt(inputNum[i]);
        }
        boolean flag;
        int temp;
        for (int i = 0; i < output.length - 1; i++) {
            flag = false;
            for (int j = 0; j < output.length - 1 - i; j++) {
                if (output[j + 1] < output[j]) {
                    temp = output[j];
                    output[j] = output[j + 1];
                    output[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int i = 0; i < output.length - 1; i++) {
            System.out.print(output[i] + "+");
        }
        System.out.println(output[output.length - 1]);
    }
}