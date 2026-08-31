#include <bits/stdc++.h>
#pragma GCC optimize "03"
using namespace std;
const long long int N = 2e5 + 5;
const long long int mod = 1e9 + 7;
const long long int inf = 1e18 + 9;
long long int a[N];
long long int t[4 * N], lzy[4 * N];
void build(long long int nd, long long int s, long long int e) {
  if (s == e)
    t[nd] = a[s], a[s] = 0;
  else {
    long long int md = (s + e) >> 1;
    build(2 * nd, s, md);
    build(2 * nd + 1, md + 1, e);
    t[nd] = min(t[2 * nd], t[2 * nd + 1]);
  }
}
void pushdown(long long int nd, long long int s, long long int e) {
  if (s == e) {
    t[nd] -= lzy[nd];
    lzy[nd] = 0;
    return;
  }
  lzy[2 * nd] += lzy[nd];
  lzy[2 * nd + 1] += lzy[nd];
  t[nd] -= lzy[nd];
  lzy[nd] = 0;
}
void upd(long long int nd, long long int s, long long int e, long long int l,
         long long int r, long long int v) {
  if (s > r || e < l || l > r) return;
  if (s >= l && e <= r) {
    lzy[nd] += v;
    return;
  }
  pushdown(nd, s, e);
  long long int md = (s + e) >> 1;
  upd(2 * nd, s, md, l, r, v);
  upd(2 * nd + 1, md + 1, e, l, r, v);
  t[nd] = min(t[2 * nd] - lzy[2 * nd], t[2 * nd + 1] - lzy[2 * nd + 1]);
}
long long int query(long long int nd, long long int s, long long int e) {
  pushdown(nd, s, e);
  if (s == e) return s;
  long long int md = (s + e) >> 1;
  long long int p;
  if (t[2 * nd + 1] - lzy[2 * nd + 1] == 0)
    p = query(2 * nd + 1, md + 1, e);
  else
    p = query(2 * nd, s, md);
  t[nd] = min(t[2 * nd] - lzy[2 * nd], t[2 * nd + 1] - lzy[2 * nd + 1]);
  return p;
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  for (long long int i = 1; i <= n; i++) cin >> a[i];
  build(1, 1, n);
  for (long long int i = 1; i <= n; i++) {
    long long int id = query(1, 1, n);
    a[id] = i;
    upd(1, 1, n, id, id, -inf);
    upd(1, 1, n, id + 1, n, i);
  }
  for (long long int i = 1; i <= n; i++) cout << a[i] << " ";
  return 0;
}
