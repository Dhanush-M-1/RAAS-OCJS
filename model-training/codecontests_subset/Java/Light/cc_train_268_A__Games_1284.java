import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int counter = 0;
        int[] homeMatches = new int[n];
        int[] awayMatches = new int[n];
        for (int i = 0; i < n; i++) {
            int newHome = read.nextInt();
            int newAway = read.nextInt();
            homeMatches[i] = newHome;
            awayMatches[i] = newAway;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (homeMatches[i] == awayMatches[j]) {counter++;}
            }
        }
        System.out.println(counter);
    }
}