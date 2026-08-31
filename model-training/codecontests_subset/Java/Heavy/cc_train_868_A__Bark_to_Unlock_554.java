import java.util.Scanner;

/**
 *
 * @author Eng_hossam
 */
public class Problem_868A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String pwd = "";
        int n = 0;

        boolean isstart = false;
        boolean isend = false;

        Scanner scanner = new Scanner(System.in);
        pwd = scanner.nextLine();
        n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }


        String start = pwd.charAt(0) + "";
        String end = pwd.charAt(1) + "";

        for (int i = 0; i < n; i++) {
            if(strs[i].startsWith(start)&&strs[i].endsWith(end)){
                isstart=true;
                isend=true;
            }
            if (strs[i].endsWith(start))  {
                isstart = true;
            }
            if (strs[i].startsWith(end)) {
                isend = true;
            }
        }

        if (isstart && isend) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}