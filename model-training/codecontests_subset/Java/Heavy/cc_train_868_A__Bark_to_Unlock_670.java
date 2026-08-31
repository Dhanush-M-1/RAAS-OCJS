import java.util.*;

public class BarkUnlock{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String pw = sc.next();
        int n = sc.nextInt();
        String[] sa = new String[n];
        TreeSet<Character> set1 = new TreeSet();
        TreeSet<Character> set2 = new TreeSet();
        for(int i = 0; i < n; i++){
            sa[i] = sc.next();
            set1.add(sa[i].charAt(0));
            set2.add(sa[i].charAt(1));
        }
        for(int i = 0; i < n; i++){
            if(sa[i].equals(pw)){
                System.out.println("YES");
                return;
            }
        }
        if(set1.contains(pw.charAt(1)) && set2.contains(pw.charAt(0))){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}