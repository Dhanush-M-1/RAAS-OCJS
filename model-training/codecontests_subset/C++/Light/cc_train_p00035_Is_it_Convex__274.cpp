#include <iostream>
#include <cstdio>
#include <cmath>

using namespace std;

double ang(double x1, double y1, double x2, double y2) {
    return acos((x1 * x2 + y1 * y2) / (sqrt(x1 * x1 + y1 * y1) * sqrt(x2 * x2 + y2 * y2)));
}

int main (void) {
    while (true) {
        double x1, x2, x3, x4, y1, y2, y3, y4;
        if (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &x1, &y1, &x2, &y2, &x3, &y3, &x4, &y4) == EOF) break;
        double a = 0;
        a += ang(x2 - x1, y2 - y1, x2 - x3, y2 - y3);
        a += ang(x3 - x2, y3 - y2, x3 - x4, y3 - y4);
        a += ang(x4 - x3, y4 - y3, x4 - x1, y4 - y1);
        a += ang(x1 - x4, y1 - y4, x1 - x2, y1 - y2);
        if (abs(M_PI * 2 - a) < 0.01) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    return 0;
}