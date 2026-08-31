#include <cstdio>
using namespace std;

double xa, ya, xb, yb, xc, yc, xd, yd;

double n1(double x, double y){
    return ((xb-xd)*(y-yb)-(yb-yd)*(x-xb));
}

double n2(double x, double y){
    return ((xa-xc)*(y-ya)-(ya-yc)*(x-xa));
}

int main(){
    while( scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
                 &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != EOF ){
        double f1 = n1(xa, ya) * n1(xc, yc);
        double f2 = n2(xb, yb) * n2(xd, yd);
        if( f1 < 0 && f2 < 0 ){
            printf("YES\n");
        }else{
            printf("NO\n");
        }
    }
    return 0;
}