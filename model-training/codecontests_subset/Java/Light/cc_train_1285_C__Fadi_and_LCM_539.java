/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LUCIANO
 */
import java.util.*;

public class Solve {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        long x = in.nextLong(); 
        for(int i = (int) Math.floor(Math.sqrt(x)); i >= 1; i--)
        {
            long a = i;
            long b = x / i;
            if(x % b == 0)
            {
                if(gcd(Math.max(a, b), Math.min(a, b)) == 1L)
                {
                    System.out.println(a + " " + b);
                    break;
                }
            }
        }
    }
    public static long gcd(long a, long b)
    {
        if(a % b == 0) return b;
        else return gcd(b, a % b);
    }
}