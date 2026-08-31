import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hpm {
    static Scanner sr = new Scanner(System.in);
    public static void main(String args[]) {
        String ln = sr.nextLine();
        String result = Stream.of(ln.split("\\+")).sorted().collect(Collectors.joining("+"));
        System.out.println(result);
    }	

}