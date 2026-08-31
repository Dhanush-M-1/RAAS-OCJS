#include <bits/stdc++.h>
using namespace std;
const int N = 1010;
int n, m, w[N], d[N];
bool vis[N];
int main() {
  while (cin >> n >> m) {
    for (int i = 1; i <= n; ++i) cin >> w[i];
    for (int i = 1; i <= m; ++i) cin >> d[i];
    long long ans = 0;
    for (int i = 1; i <= m; ++i) {
      memset(vis, false, sizeof vis);
      for (int j = i - 1; j > 0; --j) {
        if (d[i] == d[j]) break;
        if (!vis[d[j]]) {
          ans += w[d[j]];
          vis[d[j]] = true;
        }
      }
    }
    cout << ans << endl;
  }
}
