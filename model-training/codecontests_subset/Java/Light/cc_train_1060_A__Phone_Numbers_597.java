// package Practice2.CF1060;

import java.util.Scanner;

public class CF1060A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '8'){
                count++;
            }
        }
        System.out.println(Math.min(n/11,count));
    }
}
