import java.util.Scanner;

public class water {
    public static  int pangduan(String a[],int x,int y){
        if(a[x].charAt(y)=='1')
            return 1;
        else if(a[x].charAt(y)=='0')
            return 0;
        else {
            System.out.println("出错！");
            return 2;
        }

    }

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int t=input.nextInt();
        int a[]=new int[t];
        for(int i=0;i<t;i++){
           int n=input.nextInt();
           String str []=new String[n];
           int grid[][]=new int[n][n];
           for(int k=0;k<n;k++){
               str[k]=input.next();
           }
           grid[0][1]=pangduan(str,0,1);
           grid[1][0]=pangduan(str,1,0);
           grid[n-2][n-1]=pangduan(str,n-2,n-1);
           grid[n-1][n-2]=pangduan(str,n-1,n-2);
           int g1,g2;
           g1= grid[0][1]+ grid[1][0];
           g2= grid[n-2][n-1]+ grid[n-1][n-2];
           if(g1==1&&g2==1){
               System.out.println("2");
               if(grid[0][1]==1)
                   System.out.println("1 2");
               else
                   System.out.println("2 1");
               if(grid[n-2][n-1]==0)
                   System.out.println((n-1)+" "+n);
               else
                   System.out.println(n+" "+(n-1));
           }
           else if(g1==1&&g2==0){
               System.out.println("1");
               if(grid[0][1]==0)
                   System.out.println("1 2");
               else
                   System.out.println("2 1");

           }
           else if(g1==1&&g2==2){
               System.out.println("1");
               if(grid[0][1]==1)
                   System.out.println("1 2");
               else
                   System.out.println("2 1");

           }
           else if(g1==0&&g2==1){
               System.out.println("1");
               if(grid[n-2][n-1]==0)
                   System.out.println((n-1)+" "+n);
               else
                   System.out.println(n+" "+(n-1));
           }
           else if(g1==0&&g2==2){
               System.out.println("0");

           }
           else if(g1==0&&g2==0){
               System.out.println("2");
               System.out.println((n-1)+" "+n);
               System.out.println(n+" "+(n-1));
           }
           else if(g1==2&&g2==1){
               System.out.println("1");
               if(grid[n-2][n-1]==1)
                   System.out.println((n-1)+" "+n);
               else
                   System.out.println(n+" "+(n-1));
           }
           else if(g1==2&&g2==2){
               System.out.println("2");
               System.out.println((n-1)+" "+n);
               System.out.println(n+" "+(n-1));
           }
           else if(g1==2&&g2==0){
               System.out.println("0");
           }
        }
    }
}
