import java.util.*;
import java.io.*;

public class Codeforces {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]){
                case '1':
                    count_1++;
                    break;
                case '2':
                    count_2++;
                    break;
                case '3':
                    count_3++;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder(2*(count_1+count_2+count_3));
        for (int i = 0; i < count_1 - 1; i++) {
            sb.append("1+");
        }
        if(count_1 > 0)
            sb.append('1');

        if(count_1 > 0 && count_2 > 0)
            sb.append('+');
        for (int i = 0; i < count_2 - 1; i++) {
            sb.append("2+");
        }
        if(count_2 > 0)
            sb.append('2');
        if((count_1 > 0 || count_2 > 0) && count_3 > 0)
            sb.append('+');
        for (int i = 0; i < count_3-1; i++) {
            sb.append("3+");
        }
        if(count_3 > 0)
            sb.append('3');
        System.out.println(sb.toString());
    }
}