import java.util.Arrays;
import java.util.Scanner;

/**
 * @author andrenoebbechristiansen
 * @version 06/10/2017
 */
public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\+")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();

        for(int i : numbers){
            sb.append( i + "+");
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }
}