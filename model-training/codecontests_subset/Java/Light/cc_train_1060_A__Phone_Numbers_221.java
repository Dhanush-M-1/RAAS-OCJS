import java.util.Scanner;

public class PhoneNumbers_1060A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String line = s.nextLine();
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i)=='8')
                count++;
        }
        if(n>=11 && count>= n/11){
            System.out.println(n/11);
        } else if (n>=11 && count<n/11){
            System.out.println(count);
        } else {
            System.out.println(0);
        }
    }
}
