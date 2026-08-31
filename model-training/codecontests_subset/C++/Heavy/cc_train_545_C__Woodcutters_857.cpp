#include <bits/stdc++.h>
using namespace std;
long long x[100005], h[100005], f[100005][5];
int n;
int main() {
  ios::sync_with_stdio(0);
  cin.tie();
  cout.tie();
  cin >> n;
  x[0] = -1e18;
  x[n + 1] = 1e18;
  for (int i = 1; i <= n; i++) cin >> x[i] >> h[i];
  for (int i = 1; i <= n; i++) {
    f[i][0] = max(f[i - 1][2], max(f[i - 1][0], f[i - 1][1]));
    if (x[i] + h[i] < x[i + 1]) f[i][1] = f[i][0] + 1;
    if (x[i] - h[i] > x[i - 1]) {
      if (x[i - 1] + h[i - 1] < x[i] - h[i])
        f[i][2] = f[i - 1][1] + 1;
      else
        f[i][2] = max(f[i - 1][2], f[i - 1][0]) + 1;
    }
  }
  cout << max(f[n][0], max(f[n][1], f[n][2]));
  return 0;
}
