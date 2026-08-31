#include <bits/stdc++.h>
using namespace std;
signed main() {
  cin.tie(nullptr)->sync_with_stdio(false);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<bool> bad(n);
  for (long long i = 0; i < m; i++) {
    long long x;
    cin >> x;
    bad[x] = true;
  }
  vector<long long> pv(n);
  queue<long long> q;
  long long lst = -1;
  for (long long i = 0; i < n; i++) {
    if (!bad[i]) lst = i;
    pv[i] = lst;
  }
  long long ans = LLONG_MAX;
  for (long long jp = 1; jp <= k; jp++) {
    long long cost = 0;
    long long c;
    cin >> c;
    long long cur = 0;
    if (bad[cur]) goto done;
    while (true) {
      cost += c;
      if (cur + jp >= n) break;
      long long nxt = pv[cur + jp];
      if (nxt == cur) goto done;
      cur = nxt;
    }
    ans = min(ans, cost);
  done:;
  }
  if (ans == LLONG_MAX) ans = -1;
  cout << ans << "\n";
}
