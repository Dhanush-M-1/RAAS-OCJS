#include<iostream>
using namespace std;
int main() {
    double xa, ya, xb, yb, xc, yc, xd, yd;
    char c;
    while (cin >> xa >> c >> ya >> c >> xb >> c >> yb >> c >> xc >> c >> yc >> c >> xd >> c >> yd) {
        double check1, check2;
        bool flg = false;
        check1 = (yb - ya) - (yc - ya) / (xc - xa) * (xb - xa);
        check2 = (yd - ya) - (yc - ya) / (xc - xa) * (xd - xa);
        if (check1 * check2 > 0) { //同じ側
            flg = true;
        }
        check1 = (ya - yb) - (yd - yb) / (xd - xb) * (xa - xb);
        check2 = (yc - yb) - (yd - yb) / (xd - xb) * (xc - xb);
        if (check1 * check2 > 0) { //同じ側
            flg = true;
        }
        if (flg == true) {
            cout << "NO" << endl;
        } else {
            cout << "YES" << endl;
        }
    }
    return 0;
}

