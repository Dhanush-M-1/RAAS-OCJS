import java.util.Scanner;


public class Stones_1236A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int t =0;t<test;t++){
            int a = sc.nextInt();int b = sc.nextInt();int c = sc.nextInt();

            int stones = 0;

            while (b>0 && c>1){
                b--;
                c-=2;
                stones +=3;
            }

            while (a>0 && b>1){
                a--;
                b-=2;
                stones +=3;
            }

            System.out.println(stones);
        }
    }
}