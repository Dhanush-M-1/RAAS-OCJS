import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String str = in.next();
        in.close();
        if(num%2 != 0){
            System.out.println("1");
            System.out.println(str);
        return;
        }
        int[]mass = new int[num];
        int countOne = 0;
        for(int i = 0; i < num; i++){
            mass[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            countOne+=mass[i];
        }
        if(countOne != num-countOne){
            System.out.println("1");
            System.out.println(str);
            return;
        }
        System.out.println("2");
        System.out.print(mass[0]+" ");
        for(int i = 1; i < num; i++) {
            System.out.print(mass[i]);
        }
    }
}
