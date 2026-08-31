#include<iostream>
#include<string>
#include<sstream>
#include<algorithm>
#include<cmath>
#include<map>
#include<set>
#include<vector>
#include<stack>
#include<queue>
#include<deque>
using namespace std;

bool sameside (double ax, double ay, double bx, double by, double cx, double cy, double dx, double dy) {
    bool result = false;
    if (ax != bx) {
        double r = (ay - by) / (ax - bx);
        double s = ay - r * ax;
        if ( (r * cx + s - cy) * (r * dx + s - dy) > 0) {
            result = true;
        }
    } else {
        if ( (cx - ax) * (dx - ax) > 0 ) {
            result = true;
        }
    }
    return result;
}

int main() {
     
    double ax, ay, bx, by, cx, cy, dx, dy;
    char c;
    while(cin >> ax >> c >> ay >> c >> bx >> c >> by >> c >> cx >> c >> cy >> c >> dx >> c >> dy) {
        if( sameside(ax, ay, cx, cy, bx, by, dx, dy) || sameside(bx, by, dx, dy, ax, ay, cx, cy) ) {
            cout << "NO" << endl;
        } else {
            cout << "YES" << endl;
        }
    }
    return 0;
}