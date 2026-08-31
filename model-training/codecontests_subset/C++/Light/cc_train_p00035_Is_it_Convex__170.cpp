#include <iostream>
using namespace std;

double crs(double x1, double y1, double x2, double y2) {
    return x1 * y2 - y1 * x2;
}

int main() {
    double x[4], y[4];
    char c;
    while (cin>>x[0]>>c>>y[0]>>c>>x[1]>>c>>y[1]>>c>>x[2]>>c>>y[2]>>c>>x[3]>>c>>y[3]) {
        int sum = 0;
        for (int i=0; i<4; ++i) {
            sum += 0 < crs(x[(i+1)%4] - x[i], y[(i+1)%4] - y[i], x[(i+2)%4] - x[(i+1)%4], y[(i+2)%4] - y[(i+1)%4]);
        }
        cout << (sum % 4 == 0 ? "YES" : "NO") << endl;
    }
    return 0;
}