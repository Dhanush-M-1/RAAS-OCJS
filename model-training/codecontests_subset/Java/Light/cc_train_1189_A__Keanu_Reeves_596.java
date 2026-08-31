//package jsr.codeforces;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int count1=0, count0=0;
        for(int i=0; i<N; i++){
            if(s.charAt(i)=='0'){
                count0++;
            }
            else{
                count1++;
            }
        }
        if(count0==count1){
            System.out.println(2);
            System.out.println(s.substring(0,N-1) + " " + s.charAt(N-1));
        }
        else{
            System.out.println(1);
            System.out.println(s);
        }
    }
}
