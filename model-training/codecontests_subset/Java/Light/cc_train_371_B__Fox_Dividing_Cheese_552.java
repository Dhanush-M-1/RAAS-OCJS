import java.util.*;
import java.io.*;

/**
 *
 * @author tarsx
 */
public class CF_376B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solve(a,b));
    }
    
    static int solve(int a, int b) {
        int[] aa = countDiviArr(a);
        int[] ba = countDiviArr(b);
        int sol = Math.abs(aa[0] - ba[0]) + Math.abs(aa[1] - ba[1]) + Math.abs(aa[2] - ba[2]);
        if (a / (Math.pow(2, aa[0]) * Math.pow(3, aa[1]) * Math.pow(5,aa[2])) !=
                b / (Math.pow(2, ba[0]) * Math.pow(3, ba[1]) * Math.pow(5,ba[2])))
            return -1;
        return sol;
    }
    
    static int[] countDiviArr(int cislo) {
        int[] solution = {countDiv(cislo,2), countDiv(cislo,3),countDiv(cislo,5)};
        return solution;
    }
    
    static int countDiv(int cislo, int d) {
        int i = 0;
        while (cislo % d == 0) {
            cislo /= d;
            i++;
        }        
        return i;
    }
}