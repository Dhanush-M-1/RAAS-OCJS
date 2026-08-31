/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MasterZhao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(input.nextInt());
        }
        int maxh = k;
        for (int i = 0; i < n; i++) {
            int zs = k/a.get(i);
            int ys = k%a.get(i);
            if (ys == 0) {
                maxh = Integer.min(maxh, zs);
            }
        }
        System.out.println(maxh);
    }
    
}
