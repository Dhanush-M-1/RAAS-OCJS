

import java.util.Scanner;

public class Woodcutters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int n[]=new int[t];
        int h[]=new int[t];
        for (int i = 0; i < t; i++) {
            n[i]=sc.nextInt();
            h[i]=sc.nextInt();
        }
        int c=2;
        for (int i = 1; i <t-1 ; i++) {
            if(n[i]-n[i-1]>h[i]){
                c++;
            }
            else if(n[i+1]-n[i]>h[i]){
                ++c;
                n[i]+=h[i];
            }
        }
        if(t==1){
            System.out.println(1);
        }
        else {
            System.out.println(c);
        }

    }
}
