import java.util.*;
public class MisterBAndBookReading {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int pages = in.nextInt();
        int initial = in.nextInt();
        int max = in.nextInt();
        int acceleration = in.nextInt();
        int reread = in.nextInt();
        int days = 0;
        int pageSpot = 0;
        while(pageSpot < pages)
        {
            if(days > 0)
            {
                pageSpot -= reread;
            }
            int pagesRead = (initial + acceleration * days);
            if(pagesRead > max)
            {
                pagesRead = max;
            }
            pageSpot += pagesRead;
            days++;
        }
        System.out.println(days);
    }
}
