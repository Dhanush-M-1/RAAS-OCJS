import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int[] sumElem = new int[s.length()/2 + 1];

        for (int i = 0,j = 0; i < s.length(); i=i+2,j++){
            sumElem[j] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        Arrays.sort(sumElem);

        String resultString = "";
        for (int i = 0,j=0;i < s.length(); i=i+2,j++){

            if (j == sumElem.length-1){
                resultString = resultString + sumElem[j];
            }else {
                resultString = resultString + sumElem[j] + "+";
            }
        }

        System.out.println(resultString);
    }
}