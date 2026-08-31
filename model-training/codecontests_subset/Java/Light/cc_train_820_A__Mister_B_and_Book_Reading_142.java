/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Adithya Rao
 */
public class MisterBAndBookReading {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int v0 = in.nextInt();
        int v1 = in.nextInt();
        int a = in.nextInt();
        int l = in.nextInt();
        int read = 0;
        int count = 0;
        while(read < c) {
            if(read == 0) {
                read += v0;
            }
            else {
                read += v0;
            }
            if(v0+a < v1) {
                v0 += a;
            }
            else 
                v0 = v1;
            if(read < c) {
                read -= l;
            }
            ++count;
        }
        System.out.println(count);
    }
}
