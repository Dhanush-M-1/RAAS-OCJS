        import java.util.*;
        public class Codechef {
           
            public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int t = sc.nextInt();
                while(t-->0)
                {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int c = sc.nextInt();
                    int n2 = Math.min(b,c/2);
                    b -= n2;
                    int n1 = Math.min(a,b/2);
                    System.out.println((n1+n2)*3);
                   
                }
            }
        }