import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int n = myObj.nextInt();
        int x = myObj.nextInt();
        int y = myObj.nextInt();
        myObj.nextLine();
        String arr = myObj.nextLine();
        int res = 0, count = 0;
        for (int i = n-1; i > n-x-1 ; i--) {
            if (count < y && arr.charAt(i) == '1') {
                res++;
            }
            else if (count == y && arr.charAt(i) == '0') {
                res++;
            }
            else if (count > y && arr.charAt(i) == '1') {
                res++;
            }
            count++;
        }
        System.out.println(res) ;
    }
}
