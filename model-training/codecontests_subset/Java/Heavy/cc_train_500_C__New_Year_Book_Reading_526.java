import java.util.*;

public class NewYearBookReading500C
{
    public static void main(String[] args) 
    {
        // Set up scanner
        Scanner sc = new Scanner(System.in); 
        // System.out.println("Enter n");     // Number of books
        int n = sc.nextInt();
        // System.out.println("Enter m");    // Number of days reading
        int m = sc.nextInt();

        int[] w = new int[n+1];          // Array of book weights
        for (int i=1; i<=n; i++)
        {
            // System.out.println("Enter next weight");
            w[i] = sc.nextInt();
        }

        List<Integer> a = new LinkedList<Integer>();  // The current ordering on shelf
        Set<Integer> s = new HashSet<Integer>();          // The books we have seen
        int[] b = new int[m+1];                    // The books in the order they are read 
        for (int i=1; i<=m; i++)
        {
            // System.out.println("Enter next book to be read");
            b[i] = sc.nextInt();
            if (!s.contains(b[i]))
            {
                a.add(b[i]);
                s.add(b[i]);
            }
        }
        /*
        System.out.print("The initial ordering of the books is ");
        for (Integer i: a)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        */

        //  Now loop over b and compute the answer (inefficiently at first...)
        int answer = 0;
        for (int i=1; i<=m; i++) 
        {
            int currentbook = b[i];
            // System.out.println("Looking in array a for " + currentbook);
            // Find where it is, and sum up weights above it for lifting
            int pos = 0;
            int weight = 0;
            while (a.get(pos) != currentbook)
            {
                weight = weight + w[a.get(pos)];
                pos++;
            }
            // System.out.println("Book " + currentbook + " found in slot " + pos);
            answer += weight;
            // System.out.println("Weight lifted is now " + answer);
            int temp = a.remove(pos);
            a.add(0, temp);
            /*
            System.out.print("The new ordering of the books is ");
            for (Integer j: a)
            {
                System.out.print(j + " ");
            }
            System.out.println();
            */

        }
        System.out.println(answer);
    }
}

        
         