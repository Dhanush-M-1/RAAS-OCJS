import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class mp {
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);

        int l=s.nextInt();
        int aa=0;
        int bb=0;
        int cc=0;


        for (int i=0;i<l;i++){
            int a=s.nextInt();
            aa+=a;


        }
        for (int i=0;i<l-1;i++){
            int a=s.nextInt();
            bb+=a;


        }
        for (int i=0;i<l-2;i++){
            int a=s.nextInt();
            cc+=a;


        }

        System.out.println(aa-bb);
        System.out.println(bb-cc);


    }}