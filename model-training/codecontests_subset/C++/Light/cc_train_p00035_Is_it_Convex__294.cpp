#include <iostream>
#include <cstdio>
using namespace std;

class Point {
public:
    double x, y;
};

bool isIntersect(Point p1, Point p2, Point p3, Point p4) {
    return ((p1.x - p2.x) * (p3.y - p1.y) + (p1.y - p2.y) * (p1.x - p3.x))
        * ((p1.x - p2.x) * (p4.y - p1.y) + (p1.y - p2.y) * (p1.x - p4.x)) < 0;
}

int main () {
    Point p[4];
    while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
                 &p[0].x, &p[0].y, &p[1].x, &p[1].y, &p[2].x, &p[2].y, &p[3].x, &p[3].y) != EOF) {
        if (isIntersect(p[0], p[2], p[1], p[3]) && isIntersect(p[1], p[3], p[0], p[2])) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
}