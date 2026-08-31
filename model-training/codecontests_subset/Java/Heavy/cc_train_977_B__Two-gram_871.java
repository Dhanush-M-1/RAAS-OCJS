import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = sc.nextInt();
            sc.nextLine();

            char[] s = sc.nextLine().toCharArray();
            char[] a = new char[2];
            int res = 0;
            for (int i = 0; i < s.length-1; i++) {
                int cur = 0;
                for (int j = 0; j < s.length-1; j++) {
                    if(s[j]==s[i]&&s[j+1]==s[i+1]){
                        cur++;
                    }
                }
                if(cur>res){
                    res = cur;
                    a[0]=s[i];
                    a[1]=s[i+1];
                }
            }
            System.out.println(a);


        }
    }
}