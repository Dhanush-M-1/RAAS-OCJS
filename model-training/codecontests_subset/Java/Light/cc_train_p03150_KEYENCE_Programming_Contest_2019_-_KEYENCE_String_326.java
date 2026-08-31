import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.matches("keyence.*")) {System.out.println("YES"); return;}
        if (input.matches("keyenc.*e")) {System.out.println("YES"); return;}
        if (input.matches("keyen.*ce")) {System.out.println("YES"); return;}
        if (input.matches("keye.*nce")) {System.out.println("YES"); return;}
        if (input.matches("key.*ence")) {System.out.println("YES"); return;}
        if (input.matches("ke.*yence")) {System.out.println("YES"); return;}
        if (input.matches("k.*eyence")) {System.out.println("YES"); return;}
        if (input.matches(".*keyence")) {System.out.println("YES"); return;}

        System.out.println("NO");
    }
}