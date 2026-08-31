import java.util.Scanner;

public class CF007B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[] memory = new int[m];
        int last = 0;
        for (int i = 0; i < t; i++) {
            switch (sc.next()) {
                case "alloc":
                    int need = sc.nextInt();
                    int len = 0;
                    boolean ok = false;
                    for (int s = 0; s < m; s++) {
                        if (memory[s] == 0) {
                            len++;
                        } else {
                            len = 0;
                        }
                        if (len == need) {
                            ok = true;
                            len = s - need + 1;
                            break;
                        }
                    }
                    if (ok) {
                        last++;
                        for (int s = len; s < len + need; s++) {
                            memory[s] = last;
                        }
                        System.out.println(last);
                    } else {
                        System.out.println("NULL");
                    }
                    break;
                case "erase":
                    int b = sc.nextInt();
                    boolean erase = false;
                    for (int s = 0; s < m; s++) {
                        if (memory[s] == b) {
                            memory[s] = 0;
                            erase = true;
                        }
                    }
                    if (b <= 0 || !erase) {
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                    break;
                case "defragment":
                    int d = 0;
                    for (int s = 0; s < m; s++) {
                        if (memory[s] == 0) {
                            d++;
                        } else {
                            memory[s - d] = memory[s];
                        }
                    }
                    for (int s = m - d; s < m; s++) {
                        memory[s] = 0;
                    }
                    break;
                default:
                    System.out.println("???");
                    break;
            }
        }
        sc.close();
    }
}