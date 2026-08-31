// package Quarantine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotSoSimplePolygon {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        StringBuilder print=new StringBuilder();
        while(test--!=0){
            int n=Integer.parseInt(br.readLine());
            double a=45.0/n;
            double b=2*a;
//            System.out.println(Math.cos(Math.PI));
            double num=Math.cos(Math.PI*a/180);
//            System.out.println(num);
            num/=Math.sin(Math.PI*b/180);
            print.append(num+"\n");
        }
        System.out.print(print.toString());
    }
}
