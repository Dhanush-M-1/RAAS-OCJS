import java.util.Scanner;


public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] nn = sc.next().toCharArray();
        int numA = 0;
        int numI = 0;
        for(char s: nn) {
           if(s == 'A') numA++;
            else if(s == 'I') numI++;

        }
        System.out.println(numI > 1 ? 0 : numI == 1 ? 1 : numA);
    }
}
