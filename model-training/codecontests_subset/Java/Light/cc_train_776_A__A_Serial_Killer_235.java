import java.util.*;

public class Senri_Akane {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String nameA = in.next();
        String nameB = in.next();
        System.out.println(nameA + " " + nameB);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String dead = in.next();
            String target = in.next();
            if (nameA.equals(dead)) {
                nameA = target;
            } else {
                nameB = target;
            }
            System.out.println(nameA + " " + nameB);
        }
    }
}