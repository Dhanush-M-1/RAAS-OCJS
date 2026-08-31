import java.io.*;
import java.util.*;
import java.math.*;
// import java.awt.Point;

public class Main {
    public Main(){
        Scanner sc=new Scanner(System.in);
        char[] S=sc.next().toCharArray();

        char[] keyence=new char[]{'k','e','y','e','n','c','e'};
        int index=0;
        for(index=0;index<7;index++){
            if(S[index]!=keyence[index]){
                break;
            }
        }
        if(index==7){
            System.out.println("YES");
            return;
        }
        for(int i=0;i<7-index;i++){
            if(S[S.length-1-i]!=keyence[6-i]){
                System.out.println("NO");
                return;

            }
        }
        System.out.println("YES");
        return;

    }
    public static void main(String[] args){
        Main main=new Main();
    }

}
