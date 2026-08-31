#include <bits/stdc++.h>
using namespace std;
int u[128][14];
const char* d = "SHCD";
int main() {
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        char c; int d;
        cin >> c >> d;
        u[c][d] = true;
    }
    for (int i = 0; i < 4; i++) {
        for (int j = 1; j <= 13; j++) {
            if (!u[d[i]][j]) {
                cout << d[i] << " " << j << endl;
            }
        }
    }
}
