import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int counter =0;
        String n = scanner.nextLine();
        String numbers = scanner.nextLine();
        char[] number = numbers.toCharArray();
        for (int i = 0; i < number.length ; i++) {
            if(number[i] == '8'){
                counter++;
            }
        }
        int x = Integer.parseInt(n) / 11;
        int result = Integer.min(x , counter);
        System.out.println(result);

    }
}
