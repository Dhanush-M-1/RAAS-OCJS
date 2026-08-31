


import java.util.Scanner;
public class MultiplicationTable {

    
    public static void main(String[] args)
    {
       Scanner scan = new Scanner(System.in);
       int x = scan.nextInt();
       
       for (int i=1; i<x ; i++)
       {
           for (int j=1; j<x;j++)
           {
               System.out.print((i*j/x)*10 + (i*j%x)); 
               System.out.print(" ");
           }
           System.out.println("");
       }
    }
    
}
