import java.util.Scanner;

public class Woodcutters {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int trees = sc.nextInt();

        int x[] = new int[trees];
        int h[] = new int[trees];


        for(int i=0;i<trees;i++){
            x[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        if(trees<=2){
            System.out.println(trees);
            System.exit(0);
        }

        int count=2;
        int end = x[0];
        for(int i=1;i<trees-1;i++){


            if(x[i]-h[i]>x[i-1]){
                count++;
                //System.out.println("left "+x[i]);
            }else if(x[i]+h[i]<x[i+1]){
                count++;
                //System.out.println(x[i]+" right");
                x[i] = x[i]+h[i];
            }
        }
        //int ans = recurse(0,x,h,Integer.MIN_VALUE,0);
        System.out.println(count);
    }

    public static int recurse(int index, int x[], int h[], int end, int cuts){
       // System.out.println(index+" "+end+" "+cuts);
        if(index==x.length)
            return cuts;

        if(index==x.length-1 && end<x[index])
            return cuts+1;

        int right = Integer.MIN_VALUE;

        if(index>0 && index<x.length-1 && end+h[index]<x[index+1])
            right = recurse(index+1,x,h,end+h[index],cuts+1);

        int nocut = recurse(index+1,x,h,x[index],cuts);

        int left = Integer.MIN_VALUE;

        if(x[index]-h[index]>end){
            left = recurse(index+1,x,h,x[index],cuts+1);
        }

        return Math.max(left,Math.max(nocut,right));
    }
}
