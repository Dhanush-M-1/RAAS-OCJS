import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
public class MAIN {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        List<ArrayList<Integer>> tree = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++) tree.add(new ArrayList<>());
        for(int i=1;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        for(int i=1;i<=n;i++){
            if(tree.get(i).size()==2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
