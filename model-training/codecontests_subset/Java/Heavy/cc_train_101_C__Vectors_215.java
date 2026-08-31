
import java.util.Scanner;

public class C {
    static class Line{
        long a,b,c;
        public Line(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        public boolean intersect(Line l){
            if(a==0&&b==0&&c!=0||l.a==0&&l.b==0&&l.c!=0) return false;
            long det=l.b*a-l.a*b;
            if(det==0) {
                if(c==l.c) return true;
                return false;
            }
            if((l.b*c-l.c*b)%det!=0) return false;
            if((l.c*a-l.a*c)%det!=0) return false;
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x1=sc.nextInt();
        int y1=sc.nextInt();
        int xf=sc.nextInt();
        int yf=sc.nextInt();
        if(xf==x1&&yf==y1){
            System.out.println("YES");
            return;
        }
        int xc=sc.nextInt();
        int yc=sc.nextInt();
        Line l1=new Line(xc,yc,yf+y1);
        Line l2=new Line(-yc,xc,xf+x1);
        if(l1.intersect(l2)){
            System.out.println("YES");
            return;
        }
        l1=new Line(xc,yc,yf-y1);
        l2=new Line(-yc,xc,xf-x1);
        if(l1.intersect(l2)){
            System.out.println("YES");
            return;
        }
        l1=new Line(xc,yc,yf-x1);
        l2=new Line(-yc,xc,xf+y1);
        if(l1.intersect(l2)){
            System.out.println("YES");
            return;
        }
        l1=new Line(xc,yc,yf+x1);
        l2=new Line(-yc,xc,xf-y1);
        if(l1.intersect(l2)){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
        
    }
}
