/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;


public class ProblemA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
     Scanner sc=new Scanner(System.in);
     int Sum=0;
     for(int i=0;i<5;i++)
     {
        Sum+=sc.nextInt();
     }
     
     if(Sum>=5 && Sum%5==0)
     {
         System.out.println(Sum/5);
     }
     else
     {
         System.out.println("-1");
     }
     
    }
}
