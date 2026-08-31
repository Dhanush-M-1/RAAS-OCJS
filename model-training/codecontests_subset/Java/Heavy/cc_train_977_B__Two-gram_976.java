
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.next();
        char ss = 0;
        char ee = 0;
        int res = 0;
        for(int i=0; i<n-1; i++) {
            int cnt = 0;
            for(int j=0; j<n-1; j++) {
                if(s.charAt(i)==s.charAt(j) && s.charAt(j+1)==s.charAt(i+1)) {
                    cnt++;
                }

            }
            if(res<cnt) {
                res = cnt;
                ss = s.charAt(i);
                ee = s.charAt(i+1);
            }
        }
        System.out.println(ss+""+ee);
}}
