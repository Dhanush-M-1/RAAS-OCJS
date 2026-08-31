#include <bits/stdc++.h>
using namespace std;
long long x[100005], h[100005], f[100005][3];
int main() {
  int n;
  while (cin >> n) {
    memset(f, 0, sizeof(f));
    x[0] = -3e9;
    x[n + 1] = 3e9;
    for (int i = 1; i <= n; ++i) cin >> x[i] >> h[i];
    for (int i = 1; i <= n; ++i) {
      f[i][0] = max(f[i - 1][2], max(f[i - 1][0], f[i - 1][1]));
      if (x[i] - h[i] > x[i - 1] + h[i - 1]) {
        f[i][1] = max(f[i][1], f[i - 1][2] + 1);
        f[i][1] = max(f[i][1], f[i - 1][1] + 1);
        f[i][1] = max(f[i][1], f[i - 1][0] + 1);
      } else if (x[i] - h[i] > x[i - 1]) {
        f[i][1] = max(f[i][1], f[i - 1][0] + 1);
        f[i][1] = max(f[i][1], f[i - 1][1] + 1);
      }
      if (x[i] + h[i] < x[i + 1]) {
        f[i][2] = max(f[i][2], f[i - 1][0] + 1);
        f[i][2] = max(f[i][2], f[i - 1][1] + 1);
        f[i][2] = max(f[i][2], f[i - 1][2] + 1);
      }
    }
    cout << max(f[n][2], max(f[n][1], f[n][0])) << endl;
  }
  return 0;
}
