import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        StringBuilder s = new StringBuilder(in.nextLine());
        
        correctOrder(s);
    }

    public static void correctOrder(StringBuilder s){
        if(s.length() == 1){
            System.out.println(s.toString());
            return;
        }

        int[] count = new int[3];

        for(int i = 0 ; i < s.length() ; i+=2){
            count[s.charAt(i) - '1']++;
        }

        int index = 0;
        for(int i = 0 ; i < s.length() ; i+=2){
            while(count[index] == 0 && index < 2)
                index++;

            s.replace(i, i+1, getString(index));
            count[index]--;

            while(count[index] == 0 && index < 2)
                index++;
        }

        System.out.println(s.toString());
    }

    public static String getString(int index) {
        if(index == 0)
            return "1";

        if(index == 1)
            return "2";

        return "3";
    }
}
