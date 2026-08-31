
import java.util.ArrayList;
import java.util.Scanner;

public class Common_Subsequence {

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int x=r.nextInt();
        int c=0;
        while (c<x) {
            ArrayList<Integer> a = new ArrayList<>(1000);
            ArrayList<Integer> b = new ArrayList<>(1000);
            int n = r.nextInt();
            int n2 = r.nextInt();
            for (int i = 0; i < n; i++) {
                a.add(r.nextInt());
            }
            for (int i = 0; i < n2; i++) {
                b.add(r.nextInt());
            }

            for (int i = 0; i <a.size() ; i++) {
                if(b.contains(a.get(i))){
                    System.out.println("Yes\n1 " + a.get(i));
                    break;
            }
                else if(i==(a.size()-1))
                    System.out.println("No");
            }
            c++;
        }
    }
}
