import java.util.Scanner;

/**
 * @author Alexander Grigoryev
 *         Created on 27.07.2011
 */
public
class Main {
    static Scanner in = new Scanner(System.in);
    static int[] mem = new int[100];
    static int t, n, ct = 1;

    public static
    void main(String[] args) {
        t = in.nextInt();
        n = in.nextInt();

        for(int i = 0; i < t; i++) {
            String s = in.next();
            if(s.equals("defragment")) defragment();
            else {
                int x = in.nextInt();
                if(s.equals("alloc")) alloc(x);
                else {
                    if(x == 0) System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    else erase(x);
                }
            }
        }
    }

    static
    void defragment() {
        int st = 0;
        for(int i = 0; i < n; i++) if(mem[i] != 0) mem[st++] = mem[i];
        for(int i = st; i < n; i++) mem[i] = 0;
    }

    static
    void alloc(int x) {
        for(int i = 0; i < n; i++)
            if(mem[i] == 0 && (i == 0 || mem[i - 1] != 0)) {
                int sz = 0;
                for(int j = i; j < n; j++)
                    if(mem[j] != 0) break;
                    else sz++;
                if(sz >= x) {
                    for(int j = 0; j < x; j++) mem[i + j] = ct;
                    System.out.println(ct);
                    ct++;
                    return;
                }
            }
        System.out.println("NULL");
    }

    static
    void erase(int x) {
        boolean found = false;
        for(int i = 0; i < n; i++) {
            if(mem[i] == x) {
                mem[i] = 0;
                found = true;
            }
        }
        if(!found) System.out.println("ILLEGAL_ERASE_ARGUMENT");
    }
}