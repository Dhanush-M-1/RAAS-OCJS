import java.util.*;
import java.util.stream.Stream;

public class Games {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int counter = 0;
        int[] home=new int[101];
        int[] guest=new int[101];
        for (int i = 0; i < n; i++) {
            int[] tem = Stream.of(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            home[tem[0]]+=1;
            guest[tem[1]]+=1;
        }
        for (int i = 0; i < home.length; i++) {
            counter=counter+(home[i]*guest[i]);
        }
        System.out.println(counter);
    }
}
