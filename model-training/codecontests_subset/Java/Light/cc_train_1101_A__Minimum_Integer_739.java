import java.util.Scanner;

public class cf {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int q=sc.nextInt();

        while(q-->0) {

            int l = sc.nextInt();

            int r = sc.nextInt();
            int d = sc.nextInt();



            if(l-d>0) {
                System.out.println(d);

            }
            else{
                int dubba=r/d;
                dubba++;
                System.out.println(dubba*d);

            }
        }
    }

}
