import java.util.*;

public class Core {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        String pass = in.next();
        int n = in.nextInt();
        String s;
        List<String> ls = new LinkedList<>();
        for(int i=0;i<n;i++){
            s = in.next();
            if(s.equals(pass)){
                System.out.println("YES");
                return;
            }
            ls.add(s);
        }

        for(String i:ls){
            if(pass.charAt(0)==i.charAt(1)) {
                for (String j : ls) {
                    if (pass.charAt(1) == j.charAt(0)) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        for(String i:ls){
            if(i.charAt(0)==pass.charAt(1) && i.charAt(1)==pass.charAt(0)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
        in.close();
    }
}
