import java.util.*;

public class Main{
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next() + "#";//.nextLine() + "#";
//        System.err.println(s.length());
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < s.length()-1; ++i) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'o' || ch == 'e' || ch == 'i' || ch == 'y' || ch == 'u') {
                if (ch == s.charAt(i+1)) {
                    ++cnt;
                } else {
                    if ((ch == 'o' || ch == 'e') && cnt == 2) sb.append(ch);
                    sb.append(ch);
                    cnt = 1;
                }
            } else {
                sb.append(ch);
            }
        }
//        String ans = sb.toString();
        System.out.println(sb);
    }
}