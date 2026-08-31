import java.util.Scanner;

public class Games {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int [][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }
        int c=0;

        for(int i=0; i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i][0]==arr[j][1])
                    c++;
                if(arr[j][0]==arr[i][1])
                    c++;

            }

        }
        System.out.println(c);

    }
}
