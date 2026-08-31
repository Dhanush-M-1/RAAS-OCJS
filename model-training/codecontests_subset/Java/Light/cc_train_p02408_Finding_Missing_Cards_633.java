import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args)throws Exception{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<String> cards = new ArrayList<String>();
        trumpAdd(cards, "S");
        trumpAdd(cards, "H");
        trumpAdd(cards, "C");
        trumpAdd(cards, "D");
        for(int I = 0;I <= n - 1;I++){
            trumpRemove(cards, scan.next(),scan.nextInt());
        }
        for(int j = 0;j <= 51 - n;j++){
            System.out.println(cards.get(j));
        }
    }
    
    public static void trumpAdd(ArrayList<String> sample, String mark){
        for(int i = 0;i <= 12;i++){
            sample.add(mark + " " + (i + 1));
        }
    }
    
    public static void trumpRemove(ArrayList<String> sample, String marks, int number){
        sample.remove(marks + " " + number);
    }
}
