import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner read = new Scanner(System.in);
        int counter = 0;
        String word = read.next();
        String[] letters = word.split("");
        ArrayList<Integer> numArr = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (letters[i].equals("1") || letters[i].equals("2") || letters[i].equals("3") ) {numArr.add(Integer.parseInt(letters[i]));}
        }
        Collections.sort(numArr);
        for (int i = 0; i < numArr.size(); i++) {
            System.out.print(numArr.get(i));
            if (i == numArr.size()-1) {continue;}
            else {System.out.print("+");}

        }

    }
}