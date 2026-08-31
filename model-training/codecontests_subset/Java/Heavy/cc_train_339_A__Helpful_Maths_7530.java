import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] s = scn.nextLine().split("\\+");
        byte[] n = new byte[s.length];
        for (byte i = 0; i < s.length; i++) {
            n[i] = Byte.parseByte(s[i]);
        }
        if (s.length == 1) {
            System.out.println(s[0]);
            return;
        }
        while (true) {
            boolean c = false;
            for (byte i = 0; i < s.length - 1; i++) {
                byte a = n[i];
                byte b = n[i + 1];
                if (a > b) {
                    n[i] = b;
                    n[i + 1] = a;
                    c = true;
                    break;
                }
            }
            if (!c){
                break;
            }
        }
        System.out.print(n[0]);
        for (byte i = 1; i < n.length; i++) {
            System.out.print("+" + n[i]);
        }
        scn.close();
    }
}