import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        int ones = 0;
        int twos = 0;
        int threes = 0;
        String str = "";

        for(int x = 0; x < n.length(); x+=2){
            if(n.charAt(x) == '1') ones++;
            else if (n.charAt(x) == '2') twos++;
            else if(n.charAt(x) == '3') threes++;
        }

        while(ones > 0){
            str = str + "1+";
            ones--;
        }
        while(twos > 0){
            str = str + "2+";
            twos--;
        }
        while(threes > 0){
            str = str + "3+";
            threes--;
        }

        str = str.substring(0, str.length()-1);
        System.out.println(str);
    }
}