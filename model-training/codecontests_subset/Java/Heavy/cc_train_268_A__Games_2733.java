import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

public class Komanda {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int teams = in.nextInt();
        int result = 0;
        List<Integer> home = new ArrayList<>();
        List<Integer> guests = new ArrayList<>();
        for (int i = 0; i < teams; i++) {
            in.nextLine();
            home.add(in.nextInt());
            guests.add(in.nextInt());
        }
        for (int i = 0; i < guests.size(); i++) {
            for (int j = 0; j < home.size(); j++) {
                if(guests.get(i) == home.get(j)) {
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}