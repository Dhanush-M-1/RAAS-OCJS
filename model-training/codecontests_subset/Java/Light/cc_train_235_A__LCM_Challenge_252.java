import java.util.Scanner;
public class sherlock{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long a = n*(n-1)*(n-3);
        long b  = (n-1)*(n-2)*(n-3);
        if(n>2){
            if(n%2==1){
                System.out.println(n*(n-1)*(n-2));
            }
            else{
                if(n%3==0){
                    System.out.println(b);
                }
                else{
                    System.out.println(a);
                }
            }
        }
        else if(n==2){
            System.out.println("2");
        }
        else if(n==1){
            System.out.println("1");
        }
    }
}
