import java.util.Arrays;
import java.util.Scanner;

public class A339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sm = sc.next();
        int[] arrInt = new int[(sm.length()/2)+1];
        arrInt[0] = Integer.parseInt(sm.substring(0,1));
        for(int i = 2; i <= sm.length()-1; i++){
            arrInt[i/2] = Integer.parseInt(sm.substring(i, i+1));
            if(i < sm.length()-1) i++;
        }
        Arrays.sort(arrInt);
        String x = "";
        x += arrInt[0];
        for(int i = 1; i < arrInt.length; i++){
            x += "+";
            x += arrInt[i];
        }
        System.out.println(x);
    }
}
