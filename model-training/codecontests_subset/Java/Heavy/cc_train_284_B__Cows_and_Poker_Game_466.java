import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Sol {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ico = 0;
        int c = 0;
        boolean v = false;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'A') {
                c++;
            }
            else if(s.charAt(i) == 'I') {
                v = true;
                ico++;
                if(ico == 2) {
                    v = false;
                    c = 0;
                    break;
                }
            }
        }
        if(v) {
            System.out.println(1);
        }
        else {
            System.out.println(c);
        }
    }
}