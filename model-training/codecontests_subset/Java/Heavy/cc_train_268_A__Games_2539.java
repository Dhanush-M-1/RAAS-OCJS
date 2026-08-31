import java.util.*;

public class moha {


    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int size=in.nextInt();
        int arr[][]=new int[size][2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                     arr[i][j]=in.nextInt();
            }
        }
                 int counte=0; int k=0;int team=0;
        for (int i = 0; i < size; i++,team++) {
            for (int j = 0 ; j < size-1; j++,k++) {
                 if(k==team){k++;}
                if(arr[team][0]==arr[k][1]){
                    counte++;}
            }
           k=0;
        }
        System.out.println(counte);







    }}