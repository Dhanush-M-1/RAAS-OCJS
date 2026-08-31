import java.util.*;
 
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String keyence = "keyence";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (keyence.equals(s.substring(0,i)+s.substring(j,s.length()))) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}