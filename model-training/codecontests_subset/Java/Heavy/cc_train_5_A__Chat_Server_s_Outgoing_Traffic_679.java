/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package chat.server.s.outgoing.traffic;

import java.util.Scanner;

/**
 *
 * @author Mostafa
 */
public class ChatServerSOutgoingTraffic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in =new Scanner (System.in) ;
        long sum = 0 ;
        int x = 0 ;
        String s  ;
        for  (  ; in.hasNextLine() ;  )
        {
            s = in.nextLine() ;
//            System.out.println(s);
            if ( s.charAt(0) != '-' && s.charAt(0) != '+' )
            {
                if ( s.indexOf(':') < s.length() )
                {
                    s = s.substring(  s.indexOf(':') + 1 , s.length()) ;
                    sum += s.length() * x ;
                }
//                System.out.println(s + " " + s.length());
//                ++x ;
            }
            else if ( s.charAt(0) == '-' )
                --x ;
            else
                ++x ;
//                        System.out.println(x);
//            s = in.nextLine() ;
//            System.out.println(s);
//            in.close(); 
        }
        System.out.println(sum);
//        in.close();
    }
    
}
