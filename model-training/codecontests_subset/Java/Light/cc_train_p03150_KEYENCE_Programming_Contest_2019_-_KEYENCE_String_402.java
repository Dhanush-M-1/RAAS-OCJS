import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int length = S.length();
        for(int start=0; start<length; start++) {
            for(int remove_length=start; remove_length<length ; remove_length++) {
                String tmp = S.substring(0, start) + S.substring(remove_length, length);
//                System.out.println(tmp);
                if(tmp.equals("keyence")) {
                    System.out.println("YES");
                    return;
                };
            }
        }
        System.out.println("NO");
    }
}
