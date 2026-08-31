/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author aakl
 */
public class CodeForcesP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] ks = new int[n];

        for (int i = 0; i < n; i++) {
            ks[i] = sc.nextInt();
        }
        int ans = k;
        int idx = 0;

        while (ans > 0) {
            ans = ans - idx;
            idx++;
        }
        ans = ans + idx - 2;

        System.out.print(ks[ans]);

    }
}
