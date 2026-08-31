import java.util.Scanner;

public class SnowBlower {
    int x,y;
    SnowBlower(int x, int y){
        this.x=x;
        this.y=y;
    }

    static long dot(long x1, long y1, long x2, long y2){
        return x1*x2+y1*y2;
    }
    static long cross(long x1, long y1, long x2, long y2){
        return x1*y2-x2*y1;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n= cin.nextInt(); // number of vertices of polygon
        SnowBlower[] snowBlower= new SnowBlower[n];
        int px= cin.nextInt();
        int py= cin.nextInt();

        for (int i=0; i<n;i++){
            int xCoordinate= cin.nextInt()-px;
            int yCoordinate= cin.nextInt()-py;
            snowBlower[i]= new SnowBlower(xCoordinate,yCoordinate);
        }
        double r1=1e100,r2=0;
        for (int i=0;i<n;i++){
            int a= snowBlower[i].x;
            int b= snowBlower[i].y;
            int p= snowBlower[(i+1)%n].x;
            int q= snowBlower[(i+1)%n].y;
            double r= Math.hypot(a,b);
            r2=Math.max(r2,r);
            if(dot(a,b,a-p,b-q)>=0 && dot(p,q,p-a,q-b)>=0) {
                double r_=Math.abs(cross(p,q,a,b))/Math.hypot(a-p,b-q);
                r=Math.min(r,r_);
            }
            r1=Math.min(r1,r);
        }
        System.out.println((r2*r2-r1*r1)*Math.PI);
    }
}
