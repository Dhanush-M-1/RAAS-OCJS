#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 20;
int low[MAXN], up[MAXN];
int main() {
  int n, d;
  cin >> n >> d;
  for (int i = 1, s = 0, t; i <= n; i++) {
    cin >> t;
    s += t;
    if (t == 0) low[i] = -s;
    up[i] = d - s;
  }
  for (int i = 1; i <= n; i++) {
    low[i] = max(low[i - 1], low[i]);
  }
  for (int i = 1; i <= n; i++) {
    low[i] = max(low[i - 1], low[i]);
  }
  for (int i = n - 1; i >= 1; --i) {
    up[i] = min(up[i], up[i + 1]);
  }
  int ans = 0, cur = 0;
  for (int i = 1; i <= n; ++i) {
    if (low[i] > up[i]) {
      puts("-1");
      return 0;
    }
    if (cur < low[i]) {
      cur = up[i];
      ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
