#include <iostream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <list>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <bitset>
#include <numeric>
#include <climits>
#include <cfloat>
using namespace std;

class Point{
public:
    double y, x;
    Point(double y0, double x0){
        y = y0;
        x = x0;
    }
    Point(){
        y = x = 0.0;
    }
    double cross(const Point& p) const{
        return x * p.y - y * p.x;
    }
    Point operator-(const Point& p) const{
        return Point(y - p.y, x - p.x);
    }
};

int main()
{
    for(;;){
        vector<Point> p(4);
        for(int i=0; i<4; ++i){
            char c;
            if(!(cin >> p[i].x >> c >> p[i].y))
                return 0;
            if(i < 3)
                cin >> c;
        }

        bool plus = true;
        bool minus = true;
        for(int i=0; i<4; ++i){
            Point p1 = p[(i+2)%4] - p[(i+1)%4];
            Point p2 = p[i] - p[(i+1)%4];
            if(p1.cross(p2) < 0)
                plus = false;
            else
                minus = false;
        }
        if(plus || minus)
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }
}