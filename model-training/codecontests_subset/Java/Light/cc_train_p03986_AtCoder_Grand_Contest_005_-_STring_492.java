import java.util.Scanner;

class Solver{
    final String S;

    Solver(Scanner in){
        S = in.next();
    }

    void solve(){
        char[] chars = S.toCharArray();
        int counter = 0;
        int result = 0;

        for(char ch : chars){
            if(ch == 'S') counter++;
            else if(counter <= 0){
                result++;
            }else counter--;
        }

        System.out.println(result * 2);
    }
}

class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        new Solver(in).solve();

        in.close();
    }
}