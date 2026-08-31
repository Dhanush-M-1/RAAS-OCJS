/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package bark.to.unlock;

import java.util.Scanner;

/**
 *
 * @author Mostafa
 */
public class BarkToUnlock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        String s = in.next() ;
        int n = in.nextInt() ;
        boolean w = false ;
        boolean y = false ;
        boolean z = false ;
        boolean x = false ;
        while ( n > 0 )
        {
            String a = in.next() ;
            if ( a.equals(s) )
                w = true ;
            if ( a.charAt(1) == s.charAt(0) )
                x = true ;
            if ( a.charAt(0) == s.charAt(1) )
                y = true ;
            --n ;
        }
        if ( w || ( x && y ) )
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }
    
}
