
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madis
 */
public class Cola {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextInt();
        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();
        if(a*0.5+b+2*c<n){
            System.out.println(0);
        }else {
            int count = 0;
            for(int i = 0;i<=b;i++){
                for(int j = 0;j<=c;j++){
                    if(n-i-2*j>=0 && n-i-2*j<=(a*0.5)){
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
