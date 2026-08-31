//import java.sql.SQLOutput;
import javax.swing.plaf.metal.MetalTheme;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n=sc.nextInt();
        ArrayList<Integer> al= new ArrayList<Integer>();
        int sum_op=0,sum_a=0;
        for(int i=0;i<n; i++)
            al.add(sc.nextInt());
        int op=Collections.max(al);
        for(int i=0; i<n; i++)
            sum_op+=al.get(i);//5
                                //2 2 3 2 2
        while (sum_a<=sum_op){
            sum_a=0;
            for (int i=0; i<n; i++) {
                sum_a += (op - al.get(i));
            }
            //System.out.println(op+" "+sum_a);
            op++;
        }

        System.out.println(op-1);

    }
}
