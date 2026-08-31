//package CodeForces.A;

import java.util.Scanner;

public class Task1060A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String s = scn.next();
        int[] a = new int[2];
        for(int i = 0; i<n; i++){
            if(s.charAt(i)=='8'){
                a[0]++;
            }
            else{
                a[1]++;
            }
        }
        if(a[1]/10<a[0]){
            while(a[0]>a[1]/10){
                a[0]--;
                a[1]++;
            }
        }
        System.out.println(Math.min(a[1]/10, a[0]));
    }
}
