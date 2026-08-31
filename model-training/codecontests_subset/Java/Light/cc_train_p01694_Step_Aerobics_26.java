import java.util.*;

public class Main {
    private static final Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n;
        while((n = scn.nextInt()) > 0) {
            System.out.println(aerobics(n));
        }
    }
    
    private static int aerobics(int n) {
        int count = 0;
        boolean next = true, left = false, right = false;
        for(int i = 0; i < n; i++) {
            switch(scn.next()) {
              case "lu":
                left = true;
                break;
              case "ld":
                left = false;
                break;
              case "ru":
                right = true;
                break;
              case "rd":
                right = false;
                break;
            }
            if(next == left && next == right) {
                next = !next;
                count++;
            }
        }
        return count;
    }
}