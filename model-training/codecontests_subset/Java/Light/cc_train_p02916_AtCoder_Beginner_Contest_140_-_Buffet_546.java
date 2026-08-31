import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int satisfied = 0;
        int[] a = new int[n], c = new int[n-1];

        for(int i = 0; i < n; i++)
        	a[i] = sc.nextInt()-1;

        for(int i = 0; i < n; i++)
        	satisfied += sc.nextInt();

        for(int i = 0; i < n-1; i++)
        	c[i] = sc.nextInt();

        for(int i = 0; i < n-1; i++) {
        	if(a[i] +1 == a[i+1])
        		satisfied += c[a[i]];
        }

        System.out.println(satisfied);
    }
}