import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio339A{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        List<String> list = Arrays.asList(s.split("\\+"));
        list.sort(Comparator.naturalOrder());
        for (int i=0; i<list.size(); i++)
        {
            System.out.print(list.get(i));
            if (i<list.size()-1) System.out.print("+");
        }
        System.out.println();
    }
}