import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author merenaas
 */
public class Garden915 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int gardenLength = sc.nextInt();
        int max = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > max && (gardenLength % x == 0) && x <= gardenLength) {
                max = x;
            }
        }
            System.out.println(gardenLength/max);
    }
    
}