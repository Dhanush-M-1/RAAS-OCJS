#include <bits/stdc++.h>
using namespace std;

int n, m, a[50], b[50], c[50], d[50];

int calc(int n, int m) {
    return abs(a[n] - c[m]) + abs(b[n] - d[m]);
}

int main(void){
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
    for (int i = 0; i < m; i++) cin >> c[i] >> d[i];
    for (int i = 0; i < n; i++) {
        int ans = 0;
        for (int j = 1; j < m; j++) if (calc(i, ans) > calc(i, j)) ans = j;
        cout << ans + 1 << endl;
    }
}
