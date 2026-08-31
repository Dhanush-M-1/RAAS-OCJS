import java.util.*;

public class A{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(in.next());
        }
        int c = 0;
        if (n==1){
            if (sb.toString().compareTo(s)==0 || sb.reverse().toString().compareTo(s)==0) System.out.println("YES");
            else System.out.println("NO");
        }
        else {
            boolean qq = false;
            boolean answer = false;
            for (int i = 1; i < sb.length(); i++) {

                if (sb.charAt(i) == s.charAt(c) && !qq) {
                    c++;
                    qq = true;
                    i++;
                } else if (qq && sb.charAt(i) == s.charAt(c)) {
                    answer = true;
                    break;
                }
                if (qq) i++;

            }
            qq = false;
            c = 0;
            if (!answer) {
                for (int i = sb.length() - 1; i >= 1; i--) {
                    if (qq) i--;
                    if (sb.charAt(i) == s.charAt(c) && !qq) {
                        c++;
                        qq = true;
                        i--;
                    } else if (qq && sb.charAt(i) == s.charAt(c)) {
                        answer = true;
                        break;
                    }
                }
            }
            if(!answer){
                for (int i = 0; i < sb.length()-1; i++) {
                    if (sb.toString().substring(i, i+2).compareTo(s)==0) {
                        answer = true;
                        break;
                    }
                }
            }
            if(!answer){
                sb.reverse();
                for (int i = 0; i < sb.length()-1; i++) {
                    if (sb.toString().substring(i, i+2).compareTo(s)==0) {
                        answer = true;
                        break;
                    }
                }
            }
            if (answer) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}