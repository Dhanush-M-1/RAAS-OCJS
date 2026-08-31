import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int cur = 0;
        String s;
        while (sc.hasNext()) {
            s = sc.nextLine();
            if (s.charAt(0) == '+') {
                cur++;
            } else if (s.charAt(0) == '-') {
                cur--;
            } else {
                String[] temp = s.split(":");
                try {
                    temp[1] = temp[1].trim();
                    total += (cur * temp[1].length());
                } catch (Exception e) {
                
                }
            }
        }
        System.out.println(total);
    }

}