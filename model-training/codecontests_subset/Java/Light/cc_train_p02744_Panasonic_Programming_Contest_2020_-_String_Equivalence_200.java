import java.util.*;
class Main{
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs("",'a');
    }

    public static void dfs(String s,char ch){
        if(s.length() == n){
            System.out.println(s);
            return;
        }
            
            for(char c = 'a';c<=ch;c++)
                dfs(s+c ,((c == ch)?(char)(ch+1):ch));
    }
}