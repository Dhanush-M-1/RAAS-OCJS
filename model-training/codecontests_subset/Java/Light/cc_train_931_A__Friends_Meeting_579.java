import java.util.Scanner;

public class A_FriendsMeeting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int dist = Math.abs(x-y);
        int total = 0;
        int inc = 1;
        for(int i=0 ; i<dist/2 ; i++){
            total+=inc++;
        }
        total*=2;
//        System.out.println(total);
        if(dist%2==1) total+=inc;
        System.out.println(total);
    }
}
