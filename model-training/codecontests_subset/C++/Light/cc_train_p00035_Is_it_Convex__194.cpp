#include <iostream>
#include <complex>
#include <algorithm>
#include <map>
#include <vector>
#include <string>
#include <cstdio>
#include <cmath>
using namespace std;
typedef complex<double> P;

#define X real()
#define Y imag()

double check(P p1, P p2, P p3, P p4)
{
    return ((p1.X-p2.X)*(p3.Y-p1.Y) + (p1.Y-p2.Y)*(p1.X-p3.X)) * ((p1.X-p2.X)*(p4.Y-p1.Y) + (p1.Y-p2.Y)*(p1.X-p4.X));
}

int main(void)
{
    double x[4],y[4];
    while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",x,y,x+1,y+1,x+2,y+2,x+3,y+3)) {
        P a(x[0], y[0]);
        P b(x[1], y[1]);
        P c(x[2], y[2]);
        P d(x[3], y[3]);

        if(check(a,c,b,d) > 0.0 || check(b,d,a,c) > 0.0)
            puts("NO");
        else
            puts("YES");
    }

    return 0;
}