import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for(int i=0; i<t; i++) {
            int n = input.nextInt();
            int m = input.nextInt();

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            for(int j=0; j<n; j++) {
                setA.add(input.nextInt());
            }

            for(int j=0; j<m; j++) {
                setB.add(input.nextInt());
            }

            setA.retainAll(setB);
            if(setA.size() == 0)
                System.out.println("NO");
            else{
                System.out.println("YES");
                for(Integer num : setA) {
                    System.out.print(1 + " " + num + " ");
                    break;
                }
                System.out.println();
            }
        }
    }
}
