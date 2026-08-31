import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String...args) throws IOException {
       Scanner sc=new Scanner(System.in);
       int count=sc.nextInt();
       int input=0;
       int input100=0;
       int input200=0;
       String output="";
       for(int i=0;i<count;i++) {
           input = sc.nextInt();
           if (input == 100) {
               input100++;
           } else {
               input200++;
           }
       }
           if(count==1){
               output="NO";
           }else {
               if (input200 % 2 == 0) {
                   if (input100 % 2 == 1) {
                       output = "NO";
                   } else {
                       output = "YES";
                   }
               } else {
                   if (input100 % 2 == 0 && input100 >= 2) {
                       output = "YES";
                   } else {
                       output = "NO";
                   }

               }
           }
           System.out.println(output);
           }

}