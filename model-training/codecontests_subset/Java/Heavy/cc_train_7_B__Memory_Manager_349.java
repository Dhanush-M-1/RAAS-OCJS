import java.util.Scanner;

public class Solution {
    private Scanner sc = new Scanner(System.in);
    private int t = sc.nextInt();
    private int m = sc.nextInt();
    private int[] mem = new int[m];

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.run();
    }

    private void run() throws Exception {
        int curFrag = 1;
        for (int i = 0; i < t; ++i) {
            String s = sc.next();
            if (s.equals("erase")) {
                int num = sc.nextInt();
                if (!erase(num) || num == 0) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            }
            if (s.equals("alloc")) {
                int num = sc.nextInt();
                if (alloc(num, curFrag)) {
                    System.out.println(curFrag);
                    curFrag++;
                } else {
                    System.out.println("NULL");
                }
            }
            if (s.equals("defragment")) {
                defragment();
            }
        }
    }

    private void defragment() {
        int t = 0;
        for (int i = 0; i < m; i++) {
            if (mem[i] != 0) {
                mem[t] = mem[i];
                t++;
            }
        }
        for (int i = t; i < m; ++i) {
            mem[i] = 0;
        }
    }


    private boolean alloc(int num, int curFrag) {
        int ln = 0;
        for (int i = 0; i < mem.length; ++i) {
            if (mem[i] == 0) {
                ln++;
            } else {
                ln = 0;
            }
            if (ln == num) {
                for (int j = i; j >= i - ln + 1; --j) {
                    mem[j] = curFrag;
                }
                return true;
            }
        }
        return false;
    }

    private boolean erase(int num) {
        boolean isGood = false;
        for (int i = 0; i < mem.length; ++i) {
            if (mem[i] == num) {
                mem[i] = 0;
                isGood = true;
            }
        }
        return isGood;
    }
}