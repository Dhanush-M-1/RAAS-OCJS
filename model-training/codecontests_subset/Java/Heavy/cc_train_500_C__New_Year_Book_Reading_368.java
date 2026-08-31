import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class C {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] o = new int[m];
        for (int i = 0; i < n; ++i)
        {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < m; ++i)
        {
            o[i] = sc.nextInt() - 1;
        }
        
        LinkedList<Book> stack = new LinkedList<Book>();
        long sum = 0;
        for (int i = 0; i < m; ++i)
        {
            int index = o[i];
            int we = w[index];
            int add = FindBook(stack, index, we);
            sum += add;
        }
        System.out.println(sum);
    }
    
    private static class Book
    {
        int index;
        int w;
    }
    
    private static int FindBook(LinkedList<Book> stack, int index, int w)
    {
        Iterator<Book> iterator = stack.iterator();
        int sum = 0;
        while (iterator.hasNext())
        {
            Book b = iterator.next();
            if (b.index == index)
            {
                iterator.remove();
                stack.addFirst(b);
                return sum;
            }
            else
            {
                sum += b.w;
            }
        }
        Book b = new Book();
        b.index = index;
        b.w = w;
        stack.addFirst(b);
        return sum;
    }

}
