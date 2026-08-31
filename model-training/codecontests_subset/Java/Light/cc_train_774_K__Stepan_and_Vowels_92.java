import java.util.*;

public class Ilya {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        String otv = s.replaceAll("a+", "a");
         otv = otv.replaceAll("i+", "i");
         otv = otv.replaceAll("y+", "y");
         otv = otv.replaceAll("u+", "u");
         otv = otv.replaceAll("ooo+", "o");
         otv = otv.replaceAll("eee+", "e");
         
        System.out.println(otv);
    }
}
