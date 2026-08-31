import java.util.*;

public class Main {
    static int tot;
    static ArrayList<Integer>[] g;
    static int[] in, out, dfs;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String pwd = sc.next();
        int n = sc.nextInt();
        String a[] = new String[n];
        for(int i = 0 ; i < n ; i ++){
            String t = sc.next();
            a[i]=t;
            if(t.equals(pwd)){
                System.out.println("YES");
                System.exit(0);
            }
        }
        boolean f1 = false,f2=false;
        ArrayList<Integer> s = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            if(a[i].charAt(0)==pwd.charAt(1)){
                f1=true;
            }
        }
        for(int i = 0 ; i < n ; i ++){
            if(s.contains(i)){
                continue;
            }
            if(a[i].charAt(1)==pwd.charAt(0)){
                f2=true;
            }
        }
        if(f1&&f2){
            System.out.println("YES");
        }else{
            System.out.printf("NO");
        }




    }

}


