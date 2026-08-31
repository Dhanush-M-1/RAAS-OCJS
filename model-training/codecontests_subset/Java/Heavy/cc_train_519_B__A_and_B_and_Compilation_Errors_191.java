import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main
{
    int[] borders;

    int search(int elem)
    {
        int index = Arrays.binarySearch(borders, elem);
        if (index < 0)
            return -index;
        return index + 1;
    }

    int t(List<Integer> a, List<Integer> b)
    {
        for (int i = 0; i < b.size(); i++)
        {
            if (!Objects.equals(a.get(i), b.get(i)))
                return a.get(i);
        }
        return a.get(a.size() - 1);
    }

    public void run()
    {
        try (final Scanner scanner = new Scanner(System.in);
             final PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        )
        {
            int n = scanner.nextInt();

            final List<Integer> f1 = IntStream.generate(scanner::nextInt).limit(n).boxed().collect(Collectors.toCollection(ArrayList::new));
            n--;
            Collections.sort(f1);
            final List<Integer> f2 = IntStream.generate(scanner::nextInt).limit(n).boxed().collect(Collectors.toCollection(ArrayList::new));
            n--;
            Collections.sort(f2);
            final List<Integer> f3 = IntStream.generate(scanner::nextInt).limit(n).boxed().collect(Collectors.toCollection(ArrayList::new));
            Collections.sort(f3);


            writer.println(t(f1, f2));
            writer.println(t(f2, f3));
        }
    }


    public static void main(String[] args) throws IOException
    {
        new Main().run();
    }
}
