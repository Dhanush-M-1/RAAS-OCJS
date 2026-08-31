
import java.util.Scanner;

/**
 * Created by TuanTai on 17/04/2016.
 */
public class N339A_HelpfulMath {
    public static void main(String[] args) {
        //Scanner s = new Scanner(new FileInputStream("src/sorting/339A.txt"));
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        char[] myArr = str.toCharArray();
        int c1=0, c2=0, c3=0;
        for (int i=0; i<myArr.length; i++)
            if (myArr[i] == '1')
                c1++;
            else if (myArr[i] == '2')
                c2++;
            else if (myArr[i] == '3')
                c3++;
        char[] out = new char[str.length()];
       int pos = 0;

        for (int i=0; i<c1; i++) {
            out[pos++] = '1';
            if (pos < myArr.length)
                out[pos++] = '+';
        }
        for (int i=0; i<c2; i++) {
            out[pos++] = '2';

            if (pos < myArr.length)
                out[pos++] = '+';
        }
        for (int i=0; i<c3; i++) {
            out[pos++] = '3';
            if (pos < myArr.length)
                out[pos++] = '+';
        }


        System.out.println(String.copyValueOf(out));





    }
}
