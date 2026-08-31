import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int index = -1;
        int time1 = -1, time2 = -1;

        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
            if(a[i] >= 500000){

            }
        }

        for(int i = 0; i < n; i++){
            if(a[i] > 500000){
                index = i;
                break;
            }
        }

        if(index != -1){
            time2 = 1000000 - a[index];
            if(index != 0){
                time1 = a[index - 1] - 1;
            }
        }else {
            time1 = a[n - 1] - 1;
        }

        if(time1 == -1){
            System.out.println(time2);
        }else if(time2 == -1){
            System.out.println(time1);
        }else {
            System.out.println((time1 > time2 ? time1 : time2));
        }

    }
}
