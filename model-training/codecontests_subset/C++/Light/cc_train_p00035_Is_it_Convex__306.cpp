#include <iostream>
#include <cstdio>
#include <complex>
#define EPS 1e-10
#define EQ(a, b) (abs((a) - (b)) < EPS)
using namespace std;
typedef complex<double> P;

double cross(P a, P b) {
    return(a.real() * b.imag() - a.imag() * b.real());
}
int is_intersect(P a1, P a2, P b1, P b2) {
    return(cross(a2-a1, b1-a1) * cross(a2-a1, b2-a1) < EPS) &&
    (cross(b2-a1, a1-b1) * cross(b2-b1, a2-b1) < EPS);
}

int main(void) {
    double xa, ya, xb, yb, xc, yc, xd, yd;
    while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd) != EOF) {
        P a(xa, ya), b(xb, yb), c(xc, yc), d(xd, yd);
        if(is_intersect(a, c, b, d) && is_intersect(b, d, a, c)) cout << "YES" << endl;
        else                                                 cout << "NO"  << endl;
    }
    return(0);
}
     