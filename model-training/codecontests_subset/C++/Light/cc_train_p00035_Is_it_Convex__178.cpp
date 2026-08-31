#include<bits/stdc++.h>
#include<vector>
#include<list>
#include<stack>
#include<queue>
#include<algorithm>
#include<map>
#include<cmath>
#include<complex>
using namespace std;

typedef complex<double> P;

#define X real()
#define Y imag()

double is_X (P p1, P p2, P p3, P p4) {
    return ((p1.X-p2.X) * (p3.Y-p1.Y) + (p1.Y-p2.Y) * (p1.X-p3.X)) * ((p1.X-p2.X) * (p4.Y-p1.Y) + (p1.Y-p2.Y) * (p1.X-p4.X));
}

int main(){
    int mod=1000000007;
    int a,b,c;
    double xa,xb,xc,xd,ya,yb,yc,yd;
    while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF) {
        P a(xa,ya);
        P b(xb,yb);
        P c(xc,yc);
        P d(xd,yd);

        if (is_X(a,c,b,d)>0.0 || is_X(b,d,a,c)>0.0) {
            printf("NO\n");
        } else {
            printf("YES\n");
        }
    }
    return 0;
}