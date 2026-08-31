#include <iostream>
#include <cmath>
using namespace std;

double theta(int x, int y) {
    double h = sqrt(pow(x,2)+pow(y,2));
    double t = asin(y / h);
    if (x >= 0 && y >= 0)
        return t;
    else if (x < 0 && y >= 0)
        return M_PI - t;
    else if (x < 0 && y < 0)
        return M_PI - t;
    else
        return 2 * M_PI + t;
}

int hoge(double p1[2], double p2[2], double p3[2])
{
    double theta1 = theta(p2[0] - p1[0], p2[1] - p1[1]);
    double theta2 = theta(p3[0] - p1[0], p3[1] - p1[1]);

    if (0 <= theta1 && theta1 <= M_PI)
        if (theta1<=theta2 && theta2 <= theta1 + M_PI)
            return 1;
        else
            return -1;
    else
        if (theta1 <= theta2 || theta2 <= (theta1 - M_PI))
            return 1;
        else
            return -1;
}

int main(void) {
    double p[4][2];
    char c;
    while (cin >> p[0][0]>> c >> p[0][1]) {
        for (int i = 1; i < 4; ++i)
            cin >> c >>  p[i][0] >> c >> p[i][1];

        int sum = 0;
        for (int i = 0; i < 4; ++i)
            sum += hoge(p[i], p[(i+1)%4], p[(i+2)%4]);

        cout << ((sum==4 || sum==-4)? "YES" : "NO") << endl;
    }
    return 0;
}

