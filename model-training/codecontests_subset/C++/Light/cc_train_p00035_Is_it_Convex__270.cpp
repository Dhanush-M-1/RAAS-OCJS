#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <string>
#include <map>
#include <vector>
#include <stack>
using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)

typedef struct P {
    double x;
    double y;
} P;

double isCross(P a, P b, P c, P d)
{
    return ((a.x - b.x)*(c.y - a.y) + (a.y - b.y)*(a.x - c.x)) * ((a.x - b.x)*(d.y - a.y) + (a.y - b.y)*(a.x - d.x));
}

int main(void)
{
    double xa,xb,xc,xd,ya,yb,yc,yd;
    
    while (~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd)) {
        P a = {xa, ya};
        P b = {xb, yb};
        P c = {xc, yc};
        P d = {xd, yd};
        if (isCross(a, b, c, d) > 0.0 && isCross(c, d, a, b) > 0.0) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
    }
    
    return 0;
}