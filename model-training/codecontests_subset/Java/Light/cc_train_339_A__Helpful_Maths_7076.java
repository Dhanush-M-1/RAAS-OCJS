import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int[] count = new int[3];
        for (int i=0; i<input.length(); i+=2){
            count[input.charAt(i)-'1']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i =0; i< count.length;i++){
            for (int j =0;j<count[i];j++){
                if(ans.length()!=0) ans.append("+");
                ans.append(i + 1);
            }
        }
        System.out.println(ans.toString());
    }
}