#include <bits/stdc++.h>
#define range(i,a,b) for(int i = (a); i < (b); i++)
#define rep(i,b) range(i,0,b)
#define pb(a) push_back(a)
#define all(a) (a).begin(), (a),end()
#define debug(x) cout << "debug " << x << endl;
using namespace std;

double dist(double x1, double y1, double x2, double y2){
    return sqrt( ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) );
}

double outputSin(double x, double y, double z){
    return acos( (x * x +  y * y - z * z) / (2 * x * y) ) ;
}

double inputXY(double x1, double y1, double x2, double y2, double x3, double y3){
    double x, y ,z;
    x = dist(x1, y1, x2, y2);
    y = dist(x2, y2, x3, y3);
    z = dist(x3, y3, x1, y1);
    return outputSin(x, y, z);
}

int main(){
    double x1, y1, x2, y2, x3, y3, x4, y4;
    char gar;
    while(cin >> x1 >> gar >> y1 >> gar >> x2 >> gar >> y2 >> gar >> x3 >> gar >> y3 >> gar >> x4 >> gar >> y4){
        double a, b, c, d;
        a = inputXY(x1, y1, x2, y2, x3, y3);
        b = inputXY(x2, y2, x3, y3, x4, y4);
        c = inputXY(x3, y3, x4, y4, x1, y1);
        d = inputXY(x4, y4, x1, y1, x2, y2);

        if(abs(a + b + c + d - 2 * M_PI) < 0.00001) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
}