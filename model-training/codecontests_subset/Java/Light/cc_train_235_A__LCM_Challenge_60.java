import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        long n =in.nextLong();
        if(n<=3){
            if(n==1){ System.out.println(1);
            }else if(n==2){ System.out.println(2);
            }else{ System.out.println(6); }
        }else if(n%2==0&&n>2&&n%3!=0){
            System.out.println((n)*(n-1)*(n-3));
        }else if(n%2==0&&n%3==0){
            System.out.println((n-1)*(n-2)*(n-3));
        } else {
            System.out.println(n*(n-1)*(n-2));
        }
    }
}
