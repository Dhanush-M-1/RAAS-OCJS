

import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        String str = s.next();
        s.close();
        char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int letter = 0;
        boolean bool = true;
        for (int i = 0; i < length && bool; i++) {
            int counter = 0;
            while (str.charAt(i) != alph[counter]) {
                counter++;
            }
            if (letter > counter) {
                System.out.println("YES");
                System.out.println(i + " " + (i+1));
                bool = false;
            } else {
                letter = counter;
            }
        }
        if (bool) {
            System.out.println("NO");
        }
    }
}
