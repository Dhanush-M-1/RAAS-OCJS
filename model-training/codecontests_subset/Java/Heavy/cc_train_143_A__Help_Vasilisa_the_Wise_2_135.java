import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt(); r2 = sc.nextInt(); c1 = sc.nextInt(); c2 = sc.nextInt(); d1 = sc.nextInt(); d2 = sc.nextInt();
        for(int a=1; a<10; a++){
            for(int b=1; b<10; b++){
                for(int c=1; c<10; c++){
                    for(int d=1; d<10; d++){
                        if((a-b)*(a-c)*(a-d)*(b-c)*(b-d)*(c-d)!=0){
                            if(isOk(a, b, c, d)){
                                System.out.println(a+" "+b);
                                System.out.println(c+" "+d);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
    
    static boolean isOk(int a, int b, int c, int d){
        return a+b==r1 && c+d==r2 && a+c==c1 && b+d==c2 && b+c==d2 && a+d==d1;
    }
    
    static int r1, r2, c1, c2, d1, d2;
    
}
            