import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pageCount = sc.nextInt();
        int minSpeуd = sc.nextInt();
        int maxSpeed = sc.nextInt();
        int acceleration = sc.nextInt();
        int repeatPage = sc.nextInt();

        int pageRead = 0;
        int answer = 0;
        int speed = 0;
        int repeat;

        while (pageRead < pageCount) {
            speed = Math.min(minSpeуd + acceleration * answer, maxSpeed);
            repeat = Math.min(repeatPage, pageRead);
            pageRead += speed - repeat;
            answer += 1;
        }

        System.out.println(answer);

    }

}
