import java.util.Scanner;

public class A001 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
        
 
        int n = sc.nextInt();
 
        long first = read(n);
        long second = read(n-1);
        long third = read(n-2);
 
        System.out.println(first - second);
        System.out.println(second - third);
       
    }
 
    static long read(int n) {
        long sum = 0;
        for (int i = 0 ; i < n ; i++) {
            sum += sc.nextLong();
        }
        return sum;
    }
}
