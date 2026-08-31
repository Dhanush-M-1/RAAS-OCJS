/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package cows.and.poker.game;

import java.util.Scanner;

/**
 *
 * @author Mostafa
 */
public class CowsAndPokerGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() , i = 0 , a = 0 , f = 0 ;
        String s = in.next() ;
        for ( int j = 0 ; j < n ; ++j )
            if ( s.charAt(j) == 'A' )
                ++ a ;
            else if ( s.charAt(j) == 'I' )
                ++i ;
            else
                ++f ;
        if ( a > 0 || f > 0 )
        {
            if ( i == 0 )
                System.out.println((a));
            else if ( i == 1 )
                System.out.println(1);
            else
                System.out.println(0);
        }
        else
            System.out.println(0);
    }
    
}
