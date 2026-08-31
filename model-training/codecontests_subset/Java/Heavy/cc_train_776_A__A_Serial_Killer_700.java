import java.util.Scanner;

public class A776 {
    public static void main(String... xxx){
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        //sc.nextLine();
        System.out.println(first);
        int n = sc.nextInt();
        sc.nextLine();
        String[] prev = first.split(" ");
        String[] cur;
        for (int i = 0; i < n; i++) {
            cur = sc.nextLine().split(" ");
            //sc.nextLine();
            if (cur[0].equals(prev[0])){System.out.println(prev[1] + " " + cur[1]);prev[0] = cur[1];}
            else {System.out.println(prev[0] + " " + cur[1]);prev[1] = cur[1]; }
        }
        return;
    }
}
