import java.util.Scanner;

public class Watch_Football {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scr = new Scanner(System.in);
        int data = scr.nextInt();
        int ratio = scr.nextInt();
        int video = scr.nextInt();
        int total = data * video;
        int min = 0, max = total;
        int num = total-ratio*video;
    /*  while (min < max) {
            int mid = min + (max - min) / 2;
            if (mid + ratio * video >= total
                    && (mid + ratio * video) - total <= total) {
                num = mid;
                System.out.println(num);
                return;
            } else if (mid + ratio * video < total) {
                min = mid + 1;
            } else if (mid + ratio * video > total) {
                max = mid;
            }
        }*/
        while(num%ratio!=0){
            num++;
        }
        System.out.println(num/ratio);

    }
}
