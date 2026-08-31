import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
int a = input.nextInt();
int b = input.nextInt();
int days =a+a/b;
int j = a/b+a%b;
while(j>=b){
    if (j==1){break;}
    int d = j%b;
    j=j/b;
    days+=j;
    j+=d;
}
System.out.println(days);
    }

}
