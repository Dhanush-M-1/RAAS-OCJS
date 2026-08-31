/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author 20173936
 */
public class CodeForces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            c = c/2;
            int stones = 0;
            stones += Math.min(c, b) * 3;
            b -= Math.min(c, b);
            b = b/2;
            stones += Math.min(a, b) * 3;
            
            sb.append(stones + "\n");
        }
        System.out.println(sb);
    }
    
}
