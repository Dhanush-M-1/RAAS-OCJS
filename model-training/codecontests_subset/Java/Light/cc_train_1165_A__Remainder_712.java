
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ddebettencourt20
 */
public class Remainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        String number = sc.next();
        int count = 0;
        for (int i = 0; i<length; i++){
            if (i >= length - x){
                if (i != length - y - 1 && number.charAt(i) != '0'){
                    count ++;
                }
                if (i == length - y - 1 && number.charAt(i) != '1'){
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
