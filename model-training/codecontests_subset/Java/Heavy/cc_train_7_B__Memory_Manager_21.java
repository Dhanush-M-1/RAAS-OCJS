
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madi
 */
public class MemoryManager {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int t = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        long[] bts = new long[m];
        Arrays.fill(bts, 0);

        long storedId = 1;
        long id;
        String com;
        for (int i = 0; i < t; i++) {
            in = sc.nextLine().split(" ");
            if (in.length == 1) {
                int ind = 0;
                for (int j = 0; j < m; j++) {
                    if (bts[j] == 0) {
                        ind = j;
                        for (int k = j + 1; k < m; k++) {
                            if (bts[k] != 0) {
                                ind = k;
                                break;
                            }
                        }
                        bts[j] = bts[ind];
                        bts[ind] = 0;
                    }
                }
            } else {
                com = in[0];
                id = Long.parseLong(in[1]);

                if (com.equalsIgnoreCase("alloc")) {
                    int c = 0;
                    boolean alloc = false;
                    for (int j = 0; j < m; j++) {
                        if (bts[j] == 0) {
                            c++;
                            if (c == id) {
                                for (int k = 0; k < c; k++) {
                                    bts[j - c + k + 1] = storedId;
                                }
                                storedId++;
                                alloc = true;
                            }
                        } else {
                            c = 0;
                        }
                        if (alloc) {
                            break;
                        }
                    }
                    if (alloc) {
                        System.out.println(storedId - 1);
                    } else {
                        System.out.println("NULL");
                    }
                } else {
                    boolean erased = false;
                    if (id > 0) {
                        for (int j = 0; j < m; j++) {
                            if (bts[j] == id) {
                                bts[j] = 0;
                                erased = true;
                            }
                        }
                    }
                    if (!erased) {
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                }

            }
        }



    }
}
