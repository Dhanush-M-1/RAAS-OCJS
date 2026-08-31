import java.util.Scanner;

/**
 *
 * @author hozhi
 */
public class ASerialKiller776A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
 
        int t = sc.nextInt();
        sc.nextLine();
        
        System.out.println(str);
        while(t-- > 0) {
            String str2 = sc.nextLine();
            String[] str2Arr = str2.split(" ");
            
            if (strArr[0].equalsIgnoreCase(str2Arr[0])) {
                strArr[0] = str2Arr[1];
            } else if (strArr[1].equals(str2Arr[0])) {
                strArr[1] = str2Arr[1];
            }

            System.out.println(strArr[0] + " " + strArr[1]);
        }
    }
}