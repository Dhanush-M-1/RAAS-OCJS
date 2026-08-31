#include <bits/stdc++.h>
#pragma GCC optimize("O2")
const int MAXN = 1e6 + 5;
const int mod = 1e9 + 7;
using namespace std;
int n, m, k, pre[MAXN];
bool s[MAXN];
long long a[MAXN];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int c;
    cin >> c;
    s[c] = 1;
  }
  for (int i = 1; i <= k; i++) cin >> a[i];
  if (s[0]) {
    cout << -1;
    return 0;
  }
  s[n] = 0;
  pre[0] = 0;
  for (int i = 1; i <= n; i++) {
    pre[i] = pre[i - 1];
    if (!s[i]) pre[i] = i;
  }
  long long ans = -1;
  for (int i = 1; i <= k; i++) {
    long long loc = 0;
    int p = 0;
    bool can = 1;
    while (can) {
      p += i;
      loc += a[i];
      p = min(p, n);
      if (p == n) break;
      int t = pre[p];
      if (t + i <= p) can = 0;
      p = t;
    }
    if (!can) continue;
    ans = min(ans, loc);
    if (ans == -1) ans = loc;
  }
  cout << ans;
  return 0;
}
