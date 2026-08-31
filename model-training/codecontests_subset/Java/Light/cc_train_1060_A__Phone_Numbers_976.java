import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        String str = sc.nextLine();
        int count = 0;
        
        str = sc.nextLine();
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '8') {
                count++;
            }
        }
        
        int div = n / 11;
        
        if(count < div)  {
            System.out.println(count);
        } else {
            System.out.println(div);
        }
    }
}