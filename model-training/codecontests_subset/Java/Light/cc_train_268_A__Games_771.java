
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Character;

public class Main {

    static void addElementToHashMap(HashMap<Integer, Integer> map, int element)
    {
        if (map.containsKey(element)) {
            map.put(element, map.get(element) + 1);
        }
        else {
            map.put(element, 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] homes = new int[n];
        int[] guests = new int[n];

        int result = 0;

        for (int i = 0; i < n; i++)
        {
            String[] line = in.nextLine().split(" ");
            homes[i] = Integer.parseInt(line[0]);
            guests[i] = Integer.parseInt(line[1]);
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (homes[i] == guests[j])
                    result++;
            }
        }

        System.out.println(result);
    }
}
