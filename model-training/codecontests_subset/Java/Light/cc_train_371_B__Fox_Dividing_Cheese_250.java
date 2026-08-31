
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aleksandr
 */
public class Main {
    public static void main(String[] args) {
        //ArrayList<Integer> original = new ArrayList<>();
        int[] aDels = new int[4];
        int[] bDels = new int[4];
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        aDels = findDels(a);
        bDels = findDels(b);
        if (aDels[3] != bDels[3]) {
            System.out.println(-1);
        } else {
            int operations = 0;
            operations += Math.abs(aDels[0] - bDels[0]);
            operations += Math.abs(aDels[1] - bDels[1]);
            operations += Math.abs(aDels[2] - bDels[2]);
            System.out.println(operations);
        }
    }
    
    private static int[] findDels(int a) {
        int[] dels = new int[4];
        while (a % 2 == 0) {
            dels[0]++;
            a = a / 2;
        }
        while (a % 3 == 0) {
            dels[1]++;
            a = a / 3;
        }
        while (a % 5 == 0) {
            dels[2]++;
            a = a / 5;
        }
        if (a != 1) {
            dels[3] = a;
        }
        return dels;
    }
}
