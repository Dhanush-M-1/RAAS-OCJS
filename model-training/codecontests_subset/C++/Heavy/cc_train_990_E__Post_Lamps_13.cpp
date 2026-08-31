#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
bool vis[N];
int id[N];
int main() {
  ios::sync_with_stdio(false);
  int k, n, x, m;
  long long val;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> x;
    vis[x] = 1;
  }
  if (vis[0]) {
    cout << -1 << endl;
    return 0;
  }
  for (int i = 0; i < n; i++) id[i] = vis[i] ? id[i - 1] : i;
  long long ans = 1e18;
  for (int i = 1; i <= k; i++) {
    cin >> val;
    long long ret = 0, pos = 0;
    while (1) {
      ret += val;
      if (pos + i >= n) {
        ans = min(ans, ret);
        break;
      }
      if (id[pos + i] == id[pos]) break;
      pos = id[pos + i];
    }
  }
  if (ans == 1e18)
    cout << -1 << endl;
  else
    cout << ans << endl;
  return 0;
}
