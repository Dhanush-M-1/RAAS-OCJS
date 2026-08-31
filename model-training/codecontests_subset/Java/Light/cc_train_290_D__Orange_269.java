import java.util.Scanner;

/**
 *
 * @author Mbt
 */
public class C {

    public static void main(String[] args) {
        new Solver().solve();
    }
}

class Solver{
    void solve(){
        Scanner reader= new Scanner(System.in);
        String word= reader.nextLine().toLowerCase();
        int n= reader.nextInt();
        
        StringBuilder newWord= new StringBuilder(word.length());
        for (int i=0; i<word.length(); i++){
            if ((int)word.charAt(i)<(97+n))
                newWord.append((char)(((int)word.charAt(i))-32));
            else
                newWord.append((char)(word.charAt(i)));
        }
        System.out.println(newWord.toString());
    }
}    
