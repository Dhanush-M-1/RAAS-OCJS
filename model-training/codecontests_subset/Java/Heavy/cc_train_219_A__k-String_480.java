import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.*;
import static java.lang.Math.*;
@SuppressWarnings("unused")
public class round135A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        int [] count = new int [26];
        for(int i = 0 ; i < s.length() ; ++i)
            count[s.charAt(i) - 'a']++;
        for(int i = 0 ; i < 26 ; ++i)
            if(count[i] % k != 0){
                System.out.println(-1);
                return;
            }
        String ans = "";
        for(int i = 0 ; i < k ; ++i)
            for(int j = 0 ; j < 26 ; ++j){
                if(count[j] == 0)
                    continue;
                for(int l = 0 ; l < count[j] / k ; ++l)
                    ans += (char)('a' + j);
            }
        System.out.println(ans);
    }
}
