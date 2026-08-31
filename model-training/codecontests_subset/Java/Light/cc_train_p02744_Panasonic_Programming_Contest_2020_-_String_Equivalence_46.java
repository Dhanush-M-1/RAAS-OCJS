import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<String> retList = new ArrayList<>();
        getNormalFormNumbers(retList, "a", 1, len);
        retList.forEach(System.out::println);
    }

    private static void getNormalFormNumbers(List<String> normalForms, String intermediate, int usedChars, int len) {
       if (intermediate.length() == len) {
           normalForms.add(intermediate);
           return;
       }
       for (int i=0; i<=usedChars; i++) {
           getNormalFormNumbers(normalForms, intermediate + (char) ('a' + i), usedChars + (i < usedChars ? 0 : 1), len);
       }
    }
}