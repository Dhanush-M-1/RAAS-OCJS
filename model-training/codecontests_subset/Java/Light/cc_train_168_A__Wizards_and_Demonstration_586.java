import java.util.Scanner;

public class Volshebniki {
    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();int x=in.nextInt();int y=in.nextInt();
    int p=(n*y%100>0)?n*y/100+1:n*y/100;
    System.out.println(p-x>0?p-x:0);
    }
}