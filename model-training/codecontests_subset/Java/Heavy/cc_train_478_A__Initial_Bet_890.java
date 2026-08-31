import java.util.Scanner;

public class Main {
    public void soln(int c1, int c2, int c3, int c4, int c5){
            int sum = c1+c2+c3+c4+c5;
            if(sum%5 == 0 && sum != 0){
                System.out.println(sum/5);
            }
            else{
                System.out.println(-1);
            }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c1,c2,c3,c4,c5;

        c1 = sc.nextInt();
        c2 = sc.nextInt();
        c3 = sc.nextInt();
        c4 = sc.nextInt();
        c5 = sc.nextInt();
        Main obj = new Main();
        obj.soln(c1,c2,c3,c4,c5);

    }


}
