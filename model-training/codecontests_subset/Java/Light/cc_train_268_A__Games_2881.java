import java.util.Scanner;

public class Games {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] arr=new int [n][2];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }


        for(int i=0; i<n ;i++){
            for (int j=i+1; j<n;j++){
                    if(arr[i][0]== arr[j][1]) {
                        sum++;

                    }
                     if(arr[i][1] == arr[j][0]) {
                        sum++;
                    }
            }


        }

        System.out.println(sum);

    }

}



