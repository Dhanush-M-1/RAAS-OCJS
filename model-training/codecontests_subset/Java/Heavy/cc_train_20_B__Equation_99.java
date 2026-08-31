/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package test33;

import java.util.Scanner;

/**
 *
 * @author Mostafa
 */
public class Test33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Double a = in.nextDouble() ;
        Double b = in.nextDouble() ;
        Double c = in.nextDouble() ;
        if ( a == 0 && b == 0 && c == 0 )
            System.out.println(-1);
        else if ( a == 0 && b == 0 )
            System.out.println(0);
        else
        {
            if ( ( b * b ) - ( 4 * a * c ) > 0 )
            {
                if ( a == 0 )
                {
                    System.out.println(1);
                    System.out.println((float)(-c/b));
                }
                else if ( b == 0 && c > 0 )
                {
                    System.out.println(0);
                }
                else if ( b == 0 && c == 0 )
                {
                    System.out.println(1);
                    System.out.println(0);
                }
                else
                {
                    double x = (- b + ( Math.sqrt( b * b - 4 * a*c ) ))/(2*a);
                    double y = (- b - ( Math.sqrt( b * b - 4 * a*c ) ))/(2*a);
                    System.out.println(2);
                    if ( y < x )
                    {System.out.println(y);
                    System.out.println(x);}
                    else
                    {System.out.println(x);
                    System.out.println(y);}
                }
            }
            else if (( b * b ) - ( 4 * a * c ) == 0)
            {
                System.out.println(1);
                System.out.println(-b/(2*a));
            }
            else
            {
                System.out.println(0);
            }
        }
    }
    
}
