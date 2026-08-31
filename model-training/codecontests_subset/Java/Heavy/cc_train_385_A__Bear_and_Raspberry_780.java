import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");

        String[] days = in.nextLine().split(" ");
        compute(input, days);
    }


    public static void compute(String[] input, String[] days){
        int ans = 0;
        int c = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[0]);
        for(int i = 0 ; i < n - 1 ; i++){
            int temp = Integer.parseInt(days[i]) - c - Integer.parseInt(days[i+1]);
            if(temp > ans)
                ans = temp;
        }

        System.out.println(ans);
    }
}
 