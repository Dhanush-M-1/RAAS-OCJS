import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        HashSet<Character> set=new HashSet<>();
        sb.append('a');
        set.add('a');
        dfs(n-1,sb,set);
    }
    public static void dfs(int n, StringBuilder sb,HashSet<Character> set){
        if(n==0)
        {
            System.out.println(sb.toString());
            return;
        }
        int i=0;
        for(i=0;i<26;i++)
        {
            char c=(char)(i+'a');
            if(set.contains(c))
            {
                sb.append(c);
                dfs(n-1,sb,set);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(c);
                set.add(c);
                dfs(n-1,sb,set);
                sb.deleteCharAt(sb.length()-1);
                set.remove(c);
                break;
            }
        }
    }
}
