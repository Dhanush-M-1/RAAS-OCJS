import java.util.Scanner;

/**
 * Created by first on 7/10/2018.
 */
public class FakeNP_A {
    public  static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int r = s.nextInt();
        if(l == r && l%2 == 1){
            System.out.println(l);
        }else{
            System.out.println(2);
        }

    }
}