import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int tab[] = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = in.nextInt();
        }
        Arrays.sort(tab);
        int max = Integer.MIN_VALUE;
        for (int element : tab) {
            if(element > max) max = element;
        }
        long couldSupervise = 0;
        for (int element : tab) {
            couldSupervise += (max - element);
        }
        if(couldSupervise >= max) {
            System.out.println(max);
            return;
        }
        long rest = max - couldSupervise;
        if(n > rest) {
            System.out.println(couldSupervise + rest + 1);
        } else {
            System.out.println(couldSupervise + (rest + ((int)Math.ceil(rest / (double) (n-1)))));
        }

    }
}
