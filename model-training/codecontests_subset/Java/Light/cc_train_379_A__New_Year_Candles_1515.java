import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n=scanner.nextInt(),m=scanner.nextInt();
        int sum=0,temp=0,r=0;
        while (true){
            sum+=n;
            r+=n%m;
            n=n/m;
            if (r>=m){
                r-=m;
                n++;
            }
            if (n<=0)
                break;
        }
        System.out.println(sum);


    }

}

