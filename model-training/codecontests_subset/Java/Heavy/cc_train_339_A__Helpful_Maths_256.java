import java.util.Scanner;
import java.util.Arrays;

public class Mathematics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stroka = in.nextLine();
        char [] mathematic = stroka.toCharArray();
        for(int j=0; j<50; j++) {
            for (int i = 0; i < mathematic.length - 1; i += 2) {
                if (mathematic[i + 2] < mathematic[i] || mathematic[i] > mathematic[i + 2]) {
                    char temp = mathematic[i + 2];
                    mathematic[i + 2] = mathematic[i];
                    mathematic[i] = temp;
                }
            }
        }
        System.out.println(mathematic);
    }
}
