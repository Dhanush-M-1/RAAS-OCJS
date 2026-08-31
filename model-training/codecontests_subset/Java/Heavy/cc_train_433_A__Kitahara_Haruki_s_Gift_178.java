import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println();
        //int n = scanner.nextInt();
        //for(int i=0;i<n;i++)

        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            sum = sum + temp;
            list.add(temp);
        }

        if (sum % 200 != 0) {
            System.out.println("NO");
        }
        else if(sum%400==0)
            System.out.println("YES");
            else {

            if(list.contains(100))
                System.out.println("YES");
            else
                System.out.println("NO");

        }

    }
}
