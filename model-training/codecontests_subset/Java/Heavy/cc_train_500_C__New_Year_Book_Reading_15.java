//package p_500_c;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Serg on 22.03.2015.
 */
public class p_500_c {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] weight = new int[n];
        int[] order = new int[m];
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] fl = new int[n];

        for (int i = 0; i < weight.length; i++)
            weight[i] = in.nextInt();

        for (int i = 0; i < order.length; i++)
            order[i] = in.nextInt()-1;

        int i=0;
        int a;



        while(i<m)   {
           // System.out.println(i);
            a=order[i++] ;
            //System.out.println(a);
            if (fl[a]==0){
                fl[a]=1;
                temp.add(a);
            }
        }



        int sum=0;
        for (int j = 0; j < m; j++) {
            int x=0 ;
            while (order[j]!= temp.get(x))
                sum+=weight[temp.get(x++)];
            temp.remove(x);
            temp.add(0, order[j]);

        }

       // System.out.println();
        System.out.println(sum);
                 
               

    }


}
