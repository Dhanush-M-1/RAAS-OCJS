
import java.util.*;
public class WoodCutters545C {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        long a[][] = new long[n][3];

        for(int i =0;i<n;i++){
            long x = input.nextLong();
            long h = input.nextLong();

            a[i][0] =x;
            a[i][1] =h;
            a[i][2] =0;
        }

        if(n==1){
            System.out.println(n);
        }
        else{
            a[0][2] = a[0][0]-a[0][1]; //first tree always falls to the left
            a[n-1][2] = a[n-1][0]+a[n-1][1]; //last tree always falls to the right
            long cutdown = 2;

            for(int i =1;i<n-1;i++){
                long leftFell = a[i][0]-a[i][1];
                boolean left = true;
                if(a[i-1][2]==0){
                    //previous tree is not cut
                    if(a[i-1][0]>=leftFell) left = false; //overlaps with tree position
                }
                else{
                    long prevP1 = a[i-1][0];
                    long prevp2 = a[i-1][2];
                    if(prevp2>prevP1){
                        //previous tree cut to right
                        if(prevp2>=leftFell) left = false;
                    }
                    else{
                        //previous tree cut to left
                        if(prevP1>=leftFell) left = false;
                    }
                }

                if(left == true){
                    a[i][2]=leftFell;
                    cutdown++;
                }
                else if(left == false){
                    long rightFell = a[i][0]+a[i][1];
                    boolean right = true;

                    if(a[i+1][0]<=rightFell) right = false; //overlaps with tree position

                    if(right) {
                        a[i][2]=rightFell; cutdown++;
                    }

                }


            }
            System.out.println(cutdown);
        }




    }
}
