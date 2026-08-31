/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package codeforces;

import java.util.Scanner;

/**
 *
 * @author Bisan Co
 */
public class Codeforces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int r = s.nextInt();
        if (l == r) {
            System.out.println(l);
        } else {
            System.out.println(2);
        }

    }

}
