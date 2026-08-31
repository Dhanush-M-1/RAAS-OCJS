import org.omg.DynamicAny._DynArrayStub;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by root on 7/14/14.
 */
public  class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] first = new   int[n];
        int[] second = new  int[n];

        for(int i =0; i<n; i++){
            first[i] = sc.nextInt();
            second[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < first.length; i++) {

            for(int j = 0; j < second.length; j++){

                if(first[i] == second[j]){
                    count++;
                }

            }

        }

        System.out.println(count);




    }









}
