import java.util.Scanner;

public class CodeForces {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int r1 = input.nextInt(), r2 = input.nextInt(), d = input.nextInt();
            System.out.println(MinInt(r1, r2, d));
        }
    }

    private static int MinInt(int r1, int r2, int d){
        for(int i = 0; i < r1; i += d)
            if(i != 0 && i % d == 0)
                return i;
        return (r2 >= d ? r2 - r2 % d + d : d);
    }
}