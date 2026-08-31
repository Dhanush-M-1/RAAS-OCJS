import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char[][] a = new char[300][300];
        int t = input.nextInt();
        while(t-- != 0)
        {
            int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
            int n = input.nextInt();
            for(int i = 0; i < n; i++)
            {
                String s = input.next();
                for(int j = 0; j < n; j++)
                {
                    a[i][j] = s.charAt(j);
                }
            }
            if(a[0][1] == a[1][0])
            {
                if(a[n-1][n-2] == a[0][1]){
                    x1 = n;
                    y1 = n - 1;
                }
                if(a[n - 2][n - 1] == a[0][1]){
                    x2 = n - 1;
                    y2 = n;
                }
            }
            else
            {
                if(a[n - 1][n - 2] == a[n - 2][n - 1])
                {
                    if(a[0][1] == a[n - 1][n - 2]){
                        x1 = 1;
                        y1 = 2;
                    }
                    if(a[1][0] == a[n - 1][n - 2]){
                        x2 = 2;
                        y2 = 1;
                    }
                }
                else
                {
                    if(a[0][1] == '0'){
                        x1 = 1;
                        y1 = 2;
                    }
                    if(a[1][0] == '0'){
                        x1 = 2;
                        y1 = 1;
                    }
                    if(a[n - 1][n - 2] == '1'){
                        x2 = n;
                        y2 = n - 1;
                    }
                    if(a[n - 2][n - 1] == '1'){
                        x2 = n - 1;
                        y2 = n;
                    }
                }
            }
            if(x1!=-1 && x2!=-1)
            {
                System.out.println('2');
                System.out.println(x1 + " " + y1);
                System.out.println(x2 + " " + y2);
            }
            else if(x1!=-1)
            {
                System.out.println('1');
                System.out.println(x1 + " " + y1);
            }
            else if(x2!=-1)
            {
                System.out.println('1');
                System.out.println(x2 + " " + y2);
            }
            else{
                System.out.println('0');
            }
        }
    }
}