/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author mostafa.gamal
 */
  public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte k = input.nextByte();
        byte n = input.nextByte();
      
        byte min = Byte.MAX_VALUE;
        for(int i = 0; i < k; ++i)
        {
            byte bucket = input.nextByte();
            if( n % bucket  == 0)
            {
                if(min > n /  bucket )
                {
                    min = (byte)  (n /  bucket );
                }
            }
        }
        System.out.println(min);
    }

}
