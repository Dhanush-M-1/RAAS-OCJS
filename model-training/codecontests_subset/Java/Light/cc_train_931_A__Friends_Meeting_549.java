


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {






 Scanner in=new Scanner(System.in);
 int n1=in.nextInt();
  int n2=in.nextInt();
int m=Math.abs(n2-n1);
int ca=m/2;
int cb=m-(m/2);

int sum=ca*(ca+1)/2+cb*(cb+1)/2;
        System.out.println(sum);







    }
}