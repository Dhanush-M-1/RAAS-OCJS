
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andrey
 */
public class Memmory {

    static int mem[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int m = in.nextInt();
        mem = new int[m];
        Arrays.fill(mem, -100);
        int count = 0;
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            if (str.startsWith("alloc")) {
                int len = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
                String res = alloc(len, count);
                if (!res.equals("NULL")) {
                    count++;
                }
                System.out.println(res);
            } else if (str.startsWith("erase")) {
                int len = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
                String res = erase(len);
                if (res != null) {
                    System.out.println(res);
                }
            } else {
                defragment();
            }
        }

    }

    static String alloc(int len, int i) {
        for (int j = 0; j < mem.length; j++) {
            if (j + len <= mem.length && mem[j] == -100) {
                boolean found = true;
                for (int k = j; k < mem.length && k < j + len; k++) {
                    if (mem[k] != -100) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    for (int k = j; k < j + len; k++) {
                        mem[k] = i + 1;
                    }
                    return "" + (i + 1);
                }
            }
        }
        return "NULL";
    }

    static String erase(int i) {
        if (i == 0 || i<0) {
            return "ILLEGAL_ERASE_ARGUMENT";
        }
        boolean found = false;
        for (int j = 0; j < mem.length; j++) {
            if (mem[j] == i) {
                found = true;
                mem[j] = -100;
            }
        }
        if (!found) {
            return "ILLEGAL_ERASE_ARGUMENT";
        } else {
            return null;
        }
    }

    static void defragment() {
        int i = 0;
        int j = 0;
        while (i < mem.length && j < mem.length) {
            while (j < mem.length && mem[j] == -100) {
                j++;
            }
            while (j < mem.length && mem[j] != -100) {
                mem[i] = mem[j];
                i++;
                j++;
            }
            for (int k = i; k < mem.length && k < j; k++) {
                mem[k] = -100;
            }
        }
        for (int k = i; k < mem.length; k++) {
            mem[k] = -100;
        }
    }
}
