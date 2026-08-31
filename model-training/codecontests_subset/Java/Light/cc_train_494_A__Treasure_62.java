import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int cnt = 0, cur = 0, last = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '(') {
                if (last < 0) {
                    last = 1;
                } else {
                    last++;    
                }
                cur++;
            } else {
                last--;
                cur--;
                if (cur < 0) {
                    System.out.println(-1);
                    return;
                }
                if (ch == '#') {
                    cnt++;
                    last = 0;
                }
            } 
        }
        if (last > 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < cnt - 1; i++) {
            System.out.println(1);
        }
        System.out.println(cur + 1);
    }
}