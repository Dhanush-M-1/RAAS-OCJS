
import static java.lang.Math.abs;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Haythem
 */
public class NewMain3 {
static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      

        int f1 = Integer.parseInt(scanner.nextLine());
                  

                int f2 = Integer.parseInt(scanner.nextLine());
int a1= abs(f1-f2)/2;
int a2= abs(f1-f2)-a1;
      

int nb=0;
for (int i=0;i<=a1;i++)
{
    nb= nb+i;
}
for (int i=0;i<=a2;i++)
{
    nb= nb+i;
}                    System.out.println(nb);


    }
    
}
