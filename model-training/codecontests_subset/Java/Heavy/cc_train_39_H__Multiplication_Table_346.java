
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madis
 */
public class Multiplication {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 1;i<N;i++){
            for(int j = 1;j<N;j++){
                System.out.printf("%s ", convert(i*j, N));
            }
            System.out.println();
        }
    }

    public static String convert(int num,int to){
        String result = "";
        while(num>0){
            result = num%to+result;
            num = num/to;
        }
        return result;
    }
}
