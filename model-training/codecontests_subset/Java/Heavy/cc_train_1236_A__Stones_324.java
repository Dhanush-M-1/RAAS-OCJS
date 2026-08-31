import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());

        while (t-- > 0) {
            String in = s.nextLine();
            String[] arr = in.split(" ");

            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            
            int maxA = Math.min(a, b/2);
            int totalA = maxA;
            if (b - maxA*2 >= 1) {
                totalA += Math.min(b - maxA*2, c/2);
            }
            int maxB = Math.min(b, c/2);
            int totalB = maxB;
            if (b - maxB >= 1) {
                totalB += Math.min(a, (b - maxB)/2);
            }
            System.out.println(Math.max(totalA, totalB)*3);
        }
    }
}
