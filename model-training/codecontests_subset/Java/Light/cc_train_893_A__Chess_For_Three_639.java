
//package cf_educational_33;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        ProblemA solver;
//        try{
//                File f = new File("src/cf_educational_33/input.txt");
//                solver = new ProblemA( new FileInputStream(f),System.out);
//        }catch(FileNotFoundException ex){
                solver = new ProblemA( System.in,System.out);                           
//        }
        
        solver.solve();
    }
    
    
}
class ProblemA{
    private final Scanner scanner;
    private final PrintStream output;
    public ProblemA(InputStream input,PrintStream output){
        this.scanner = new Scanner(input);
        this.output=output;
    }
    public void solve(){
        int numGames = scanner.nextInt();
        int p1 = 1;
        int p2 = 2;
        int ex = 3;
        boolean possible = true;
        while(numGames-- > 0){
            int winner = scanner.nextInt();
            if(winner == p1 || winner == p2){
                p1 = winner;
                p2 = ex;
                ex = 1+2+3-p1-p2;
            }else{
                possible = false;
            }
        }
        if(possible){
            output.println("YES");
        }else{
            output.println("NO");
        }
    }
}
