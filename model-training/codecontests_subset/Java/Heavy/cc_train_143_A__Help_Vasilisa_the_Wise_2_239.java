

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int r1=input.nextInt();
        int r2=input.nextInt();
        int c1=input.nextInt();
        int c2=input.nextInt();
        int d1=input.nextInt();
        int d2=input.nextInt();
        int a00=(r1+c1-d2)/2;
        int a01=r1-a00;
        int a10=c1-a00;
        int a11=d1-a00;
        if (a00!=a01 && a00!=a10 && a00!=a11 && a01!=a10 && a01!=a11 && a10!=a11 && a00>=1 &&a00<=9 && a01>=1 && a01<=9 && a10>=1&& a10<=9 && a11>=1 && a11<=9 && a10+a11==r2 && a01+a11==c2 && a01+a10==d2){
                    System.out.println(a00 + " " + a01);
                    System.out.println(a10 + " " + a11);

        }else
            System.out.println(-1);
    }
}
