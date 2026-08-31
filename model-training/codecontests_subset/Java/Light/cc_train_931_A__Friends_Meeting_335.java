import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Task solver = new Task();
        solver.friendsMeeting(scan.nextInt(), scan
        .nextInt());
    }

    static class Task {

        public void friendsMeeting(int f1, int f2) {
            int max,min;
            if(f1 >= f2) {
                max = f1; min=f2;
            }else{
                max = f2; min = f1;
            }
            int x = 0, x1 = 0, sum =0;
            while (min < max && min != max){
                min++; max--;
                sum+=++x;
                sum+=++x1;
            }
            if(max!=min)sum-=x;
            System.out.printf("%d",sum);
        }
    }
}