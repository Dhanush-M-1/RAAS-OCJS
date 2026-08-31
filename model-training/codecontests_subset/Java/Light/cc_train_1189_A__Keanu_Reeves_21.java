import java.util.Scanner;

public class KeanuReeves_1189A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int string = 1;
        int sum = 0;
        s.nextLine();
        String line = s.nextLine();
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i)=='1') sum++;
            else sum--;
        }
        if(sum!=0) {
            System.out.println("1");
            System.out.println(line);
        }
        else System.out.println("2\n"+line.charAt(0)+" "+line.substring(1));
    }
}
