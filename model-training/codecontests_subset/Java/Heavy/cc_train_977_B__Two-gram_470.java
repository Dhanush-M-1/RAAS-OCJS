import javax.swing.*;
import java.util.Scanner;

public class trial_1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        //System.out.println("s: " + s);

        /*String tmp = s.substring(0, 2);
        System.out.println("tmp: " + tmp);*/

        int begin_index=0, end_index=begin_index+2, final_count=0;
        String result="";
        for(int i=0; i<n-2; i++) {
            int count=0;
            int outer_begin_index=0;
            for(int j=0; j<n; j++) {
                int tmp_index = s.indexOf(s.substring(begin_index, end_index), outer_begin_index);
                if(tmp_index!=-1) {
                    count++;
                    outer_begin_index = tmp_index+1;
                }
                else break;
            }
            if(count>final_count) {
                final_count = count;
                result = s.substring(begin_index, end_index);
            }
            begin_index++;
            end_index++;
        }
        //System.out.println("final count: " + final_count);
        if(n==2) System.out.println(s);
        else System.out.println(result);
    }
}
