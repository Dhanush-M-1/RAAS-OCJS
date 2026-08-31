/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin S
 */
import java.util.Scanner;
public class Phone {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String [] args) {
        int number = sc.nextInt();
        sc.nextLine();
        String combo = sc.nextLine();
        int count = 0;
        int numEight = 0;
        for (char item: combo.toCharArray()) {
            if (item == '8') ++numEight;
        }
        
        if (combo.contains("8") && combo.length() > 10) {
            while (numEight > 0 && number > 10) {  
                count += 1;
                numEight--;
                number = number - 11;
            }
        }
        
        System.out.println(count);
    }
}
