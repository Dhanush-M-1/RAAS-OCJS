#include<iostream>
#include<cmath>
using namespace std;
//凹んでたら小さい方の角をとってしまう
//内角の和が360度か
double check(double x1, double y1, double x2, double y2, double x3, double y3) {
    double e1 = sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    double e2 = sqrt(pow(x3 - x2, 2) + pow(y3 - y2, 2));
    double e3 = sqrt(pow(x3 - x1, 2) + pow(y3 - y1, 2));
    double Cos = (e1 * e1 + e2 * e2 - e3 * e3) / (2 * e1 * e2);
    double PI = (double)acos(-1);
    return acos(Cos) * 180 / PI;
}
int main() {
    double xa, ya, xb, yb, xc, yc, xd, yd;
    char c;
    while (cin >> xa >> c >> ya >> c >> xb >> c >> yb >> c >> xc >> c >> yc >> c >> xd >> c >> yd) {
        double r1, r2, r3, r4;
        r1 = check(xa, ya, xb, yb, xc, yc);
        r2 = check(xb, yb, xc, yc, xd, yd);
        r3 = check(xc, yc, xd, yd, xa, ya);
        r4 = check(xd, yd, xa, ya, xb, yb);
        //cout << r1 << " " << r2 << " " << r3 << " " << r4 << endl;
        double sum =  r1 + r2 + r3 + r4;
        //cout << sum << endl;
        if (sum >= 359 && sum <= 361) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    return 0;
}

