//package javaapplication268;

//import java.util.HashSet;
//import java.util.ArrayList;
import java.util.Scanner;

public class JavaApplication268 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r1 = s.nextInt();
        int r2 = s.nextInt();
        int c1 = s.nextInt();
        int c2 = s.nextInt();
        int d1 = s.nextInt();
        int d2 = s.nextInt();
        for(int i = 1; i<= 9 ; i++)
            for(int j = 1; j<=9 ; j++)
                for(int k = 1; k<=9 ; k++)
                    for(int l = 1; l<=9 ; l++)
                        if(i!=j && i!=k && i!=l && j!=k && j!=l && k!=l)
                            if(i+j==r1 && k+l==r2 && i+k==c1 && j+l==c2 && 
                            i+l==d1 && k+j==d2)
                            {
                                System.out.println(i +" " + j);
                                System.out.println(k +" " + l);
                                return;
                            }
        System.out.println(-1);
    }
}
