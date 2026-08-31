import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        Integer []in1 = Arrays.stream(ss.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        String s = sc.nextLine();
        Integer []in = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        f(in1[0], in1[1], in[0], in[1], in[2], in[3]);
    }

    static void f(int n, int k, int a, int b, int c, int d) {
    if(k == n - 1 || n <= 4 || k == n) {
            System.out.println("-1");
            return;
        }   
        
        if(a != c && b != d) {
            int[] commonPath = new int[n - 4];
            
            for(int i = 1, j = 0; j < n - 4; i++) {
                if(i != a && i != b && i != c && i != d)
                    commonPath[j++] =  i;
            }            
            
            int[] path1 = new int[n];
            path1[0] = a;
            path1[n - 1] = b;
            path1[1] = c;
            path1[n - 2] = d;
            
            for(int j = 2, i = 0; j < n - 2; j++) {
                path1[j] = commonPath[i++];
            }
            
            int[]path2 = new int[n];
            System.arraycopy(path1, 0, path2, 0, n);
            path2[0] = c;
              path2[1] = a;
           path2[n - 2] = b;
             path2[n - 1] = d;
            for(int i = 0; i < path1.length; i++) {
                if(i != path1.length - 1)
                 System.out.print(path1[i] + " "); else 
                 System.out.print(path1[i]);
            }
           System.out.println();
            for(int i = 0; i < path2.length; i++) {
                if(i != path2.length - 1)
                 System.out.print(path2[i] + " "); else 
                 System.out.print(path2[i]);
            }
            
        } else {
            System.out.println("unexpected case");
        }
    }
}