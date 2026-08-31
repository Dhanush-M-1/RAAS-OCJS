//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
public class Main{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int goodcandles = scan.nextInt(); int group = scan.nextInt(); int badcandles = 0; int time = goodcandles;
        while((goodcandles+badcandles)/group!=0){
            int temp = goodcandles+badcandles;
            goodcandles = temp/group;
            badcandles = temp%group;
            time += goodcandles;
        }
        System.out.println(time);
            
                
}
}