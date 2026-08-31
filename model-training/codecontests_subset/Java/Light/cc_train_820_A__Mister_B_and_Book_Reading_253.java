import java.util.Scanner;

public class MisterBandBookReading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c= scanner.nextInt();
        int d= scanner.nextInt();
        int e= scanner.nextInt();

        System.out.println(solve(a, b,c,d,e));
    }



    public static int solve(int pages, int firstDay, int maxPages, int speedUp, int reread) {
        int days = 1;
        pages -= firstDay;
        while (pages > 0) {
            if (firstDay + speedUp > maxPages && maxPages - firstDay >= 0&&speedUp>0) {
                firstDay += (maxPages - firstDay);
                pages += reread;
                pages -= firstDay;
                days++;
            }
            else if (firstDay + speedUp <= maxPages && speedUp>0){
                firstDay+=speedUp;
                pages += reread;
                pages -= firstDay;
                days++;
            }
            else {
                pages += reread;
                pages -= firstDay;
                days++;
            }
        }
        return days;
    }

}
