import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    int n,m;
	    int bulbs;
        Scanner sc = new Scanner(System.in);
        Set<Integer> onBulbs = new HashSet<>();
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=1;i<=n;i++){
            bulbs = sc.nextInt();
            int temp;
            for(int j=1;j<=bulbs;j++){
                temp = sc.nextInt();
                onBulbs.add(temp);
            }
        }


        if(m == onBulbs.size())
            System.out.println("YES");
        else
            System.out.println("NO");


    }
}
