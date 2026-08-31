import java.util.Scanner;
public class Main {
    public static void main ( String args[]){
        Scanner in = new Scanner(System.in);
        do{
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int  t = ((a-b)*c+b-1)/b;
        System.out.println(t);
        }
        while(in.hasNext());
    }

}