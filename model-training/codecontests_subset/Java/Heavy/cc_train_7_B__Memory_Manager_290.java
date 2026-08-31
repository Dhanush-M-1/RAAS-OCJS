import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B7 {

    /*
        http://codeforces.com/contest/7/problem/A
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOps = scanner.nextInt();
        int memSize = scanner.nextInt();
        int[] mem = new int[memSize];
        int freeSpace = memSize;
        scanner.nextLine();
        int curToken = 1;
        Set<Integer> used = new HashSet<Integer>();

        for (int i = 0; i < numOps; ++i) {
            String[] s = scanner.nextLine().split(" ");

            if (s[0].startsWith("a")) { //alloc
                int val = Integer.parseInt(s[1]);
                if (val > freeSpace) System.out.println("NULL");
                else {
                    int startIndex = getIndex(mem, val);
                    if (startIndex == -1) System.out.println("NULL");
                    else {
                        used.add(curToken);
                        for (int j = 0; j < val; ++j) {
                            mem[j + startIndex] = curToken;
                        }
                        System.out.println(curToken);
                        ++curToken;
                        freeSpace -= val;
                    }
                }
            }
            else if (s[0].startsWith("e")) { //erase
                int token = Integer.parseInt(s[1]);
                boolean tokenStart = used.remove(token);
                if (!tokenStart) System.out.println("ILLEGAL_ERASE_ARGUMENT");
                else {
                    for (int j = 0; j < mem.length; ++j) {
                        if (mem[j] == token) {
                            mem[j] = 0;
                            ++freeSpace;
                        }
                    }
                }
            }
            else { //defrag
                mem = defrag(mem);
            }
        }
    }

    private static int getIndex(int[] mem, int val) {
        int emptyStart = -1;
        int emptyCount = 0;
        for (int i = 0; i<mem.length; ++i) {
            if (mem[i] == 0) {
                if (emptyStart == -1) emptyStart = i;
                ++emptyCount;
                if (emptyCount == val) break;
            } else {
                emptyStart = -1;
                emptyCount = 0;
            }
        }
        return emptyCount < val ? -1 : emptyStart;
    }

    private static int[] defrag(int[] oldMem) {
        int[] mem = new int[oldMem.length];
        int i = 0;
        for (int v : oldMem) {
            if (v != 0) {
                mem[i] = v;
                ++i;
            }
        }
        return mem;
    }
}
