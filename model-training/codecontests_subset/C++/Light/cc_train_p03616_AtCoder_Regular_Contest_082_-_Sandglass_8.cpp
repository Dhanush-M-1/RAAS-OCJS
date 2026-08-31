#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <stdio.h>
#include <string.h>
#include <math.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int x;
    cin >> x;

    int k;
    cin >> k;

    vector<int> r(k);
    for (int i = 0; i < k; i++) {
        cin >> r[i];
    }

    int q;
    cin >> q;

    int a = 0, b = x, c = 0, e = 0;
    int i = 0, s = 0;
    for (int j = 0; j < q; j++) {
        int t, y;
        cin >> t >> y;

        for (; i < k && r[i] < t; i++) {
            int d = r[i] - s;
            s = r[i];
            if (i % 2 == 0) {
                e = max(e - d, 0);
                c -= d;
                a = max(a, 0 - c);
            } else {
                e = min(e + d, x);
                c += d;
                b = min(b, x - c);
            }
        }

        y = a < b ? (y <= a ? a : y < b ? y : b) + c : e;

        y += (t - s) * (i % 2 == 0 ? -1 : 1);
        y = min(max(y, 0), x);

        cout << y << '\n';
    }

    return 0;
}