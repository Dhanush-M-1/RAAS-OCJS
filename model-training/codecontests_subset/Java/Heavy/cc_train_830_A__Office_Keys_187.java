import java.util.Arrays;
import java.util.Scanner;

public class cf830a {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] people = new int[s.nextInt()];
        int[] keys = new int[s.nextInt()];
        int office_location = s.nextInt();

        for(int i = 0; i < people.length;i++)
        {
            people[i] = s.nextInt();
        }
        Arrays.sort(people);
        for(int i = 0; i<keys.length;i++)
        {
            keys[i] = s.nextInt();
        }

        Arrays.sort(keys);

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < keys.length - people.length + 1; i++){
            int max = 0;
            for(int j = 0; j < people.length; j++){
                max = Math.max(Math.abs(people[j]-keys[i+j])+Math.abs(keys[i+j]-office_location),max);
            }
            result = Math.min(result, max);
        }

        System.out.println(result);

    }
}
