
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_A {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String initial_1 = input.next();
        String initial_2 = input.next();

        List<String> murder_list = new ArrayList<>();
        murder_list.add(initial_1);
        murder_list.add(initial_2);
        System.out.println(murder_list.get(0) + " "+ murder_list.get(1));

        int number = input.nextInt();

        for(int i =0 ; i < number; i++)
        {
            String murder = input.next();
            String replaced = input.next();

            murder_list.remove(murder);
            murder_list.add(replaced);
            System.out.println(murder_list.get(0) + " " + murder_list.get(1));
        }

    }
}
