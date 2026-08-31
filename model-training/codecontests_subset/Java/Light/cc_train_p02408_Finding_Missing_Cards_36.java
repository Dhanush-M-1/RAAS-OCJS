import java.util.*;

public class Main {
    private static final Scanner scn = new Scanner(System.in);
    private static final String[] suit = {"S", "H", "C", "D"};
    
    public static void main(String[] args) {
        LinkedHashSet<String> lhss = new LinkedHashSet<>();
        for(int i = 0; i < 52; i++) {
            lhss.add(suit[i / 13] + " " + (i % 13 + 1));
        }
        for(int n = scn.nextInt(); n > 0; n--) {
            lhss.remove(scn.next() + " " + scn.next());
        }
        for(String elm : lhss) {
            System.out.println(elm);
        }
    }
}