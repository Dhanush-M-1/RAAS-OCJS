import java.util.Scanner;

public class KString {
    public static void main(String [] args){
        //note the k-string required
        //k concats means k groups
        //count the number of each alphabet
        //see if the toal of each of these alphabets can be divided into the k groups
        //notes: the alphabet with the least total limits the number k of groups. If 'c' appears 4 times, and this is the least of all the alphabets, then you can have max k of 4 (given other alphabets can be divided evenly)
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int [] alphabetCount = new int[26];
        if (k == 1) System.out.println(s);
        else {
            for (int i = 0; i < s.length(); ++i){
                char curr = s.charAt(i);
                alphabetCount[curr - 97]++;
            }
            boolean possible = true;
            String theString = "";
            for (int i = 0; i < alphabetCount.length; ++i){
                int currCharCount = alphabetCount[i];
                if (currCharCount != 0 && currCharCount % k != 0) {
                    possible = false;
                    break;
                }
                else if (currCharCount != 0 && currCharCount % k == 0) {
                    char curr = (char) (97 + i);
                    int numberOfCharInTheString = currCharCount / k;
                    for (int j = 0; j < numberOfCharInTheString; ++j) 
                        theString += curr;
                }
            }
            if (possible) {
                String toPrint = "";
                for (int r = 0; r < k; ++r){
                    toPrint += theString;
                }
                System.out.println(toPrint);
            }
            else System.out.println(-1);    
        }
        sc.close();
    }         
}
