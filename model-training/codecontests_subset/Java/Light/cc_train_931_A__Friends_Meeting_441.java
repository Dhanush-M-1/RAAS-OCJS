import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Admin on 2018-01-16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(),b=in.nextInt(),c = 0, d = 0, kroki = 0,zmeczenie=0,zapamietana=0;
        if (a<b){
            c = b;
            d = a;
            kroki = c-d;
        }else{
            kroki = a-b;
        }
        if (kroki % 2 == 0){
            kroki = kroki /2;
            for (int i = 1; i < kroki + 1; i++) {
                zmeczenie += i;
            }
            zmeczenie = zmeczenie * 2 ;
            System.out.println(zmeczenie);
        }else{
            kroki = kroki/2;
            zapamietana = kroki + 1 ;
            for (int i = 1; i < kroki + 1; i++) {
                zmeczenie += i;
            }
            zmeczenie = (zmeczenie * 2) + zapamietana;
            System.out.println(zmeczenie);
        }

    }
}