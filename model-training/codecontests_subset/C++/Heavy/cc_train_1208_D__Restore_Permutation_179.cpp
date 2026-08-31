#include <bits/stdc++.h>
using namespace std;
void solve();
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t = 1;
  for (int i = 1; i <= t; ++i) solve();
  cerr << "Time taken: " << ((clock() * 1000) / CLOCKS_PER_SEC) << "ms\n";
}
const long long int N = 2e5 + 2;
long long int t[4 * N];
long long int lazy[4 * N];
long long int a[N];
long long int n;
void init() { memset(lazy, 0, sizeof(lazy)); }
void upd(long long int node, long long int l, long long int r,
         long long int x) {
  lazy[node] += x;
  t[node] += x;
  return;
}
void passDown(long long int node, long long int l, long long int r) {
  long long int mid = (l + r) / 2;
  upd(2 * node, l, mid, lazy[node]);
  upd(2 * node + 1, mid + 1, r, lazy[node]);
  lazy[node] = 0;
}
void build(long long int node = 1, long long int tl = 0,
           long long int tr = n - 1) {
  if (tl > tr) {
    return;
  }
  if (tl == tr) {
    t[node] = a[tl];
    return;
  }
  long long int mid = (tl + tr) / 2;
  build(2 * node, tl, mid);
  build(2 * node + 1, mid + 1, tr);
  t[node] = min(t[2 * node], t[2 * node + 1]);
}
void updateRange(long long int l, long long int r, long long int val,
                 long long int node = 1, long long int tl = 0,
                 long long int tr = n - 1) {
  if (r < l or l > tr or tl > r or tl > tr) {
    return;
  }
  if (l <= tl and tr <= r) {
    upd(node, tl, tr, val);
    return;
  }
  passDown(node, tl, tr);
  long long int mid = (tl + tr) / 2;
  updateRange(l, r, val, 2 * node, tl, mid);
  updateRange(l, r, val, 2 * node + 1, mid + 1, tr);
  t[node] = min(t[2 * node], t[2 * node + 1]);
}
long long int queryRange(long long int l, long long int r,
                         long long int node = 1, long long int tl = 0,
                         long long int tr = n - 1) {
  if (r < l or tr < tl or l > tr or tl > r) {
    return 0;
  }
  if (tl == tr) {
    return tl;
  }
  passDown(node, tl, tr);
  long long int mid = (tl + tr) / 2;
  if (t[2 * node + 1])
    return queryRange(l, r, 2 * node, tl, mid);
  else
    return queryRange(l, r, 2 * node + 1, mid + 1, tr);
}
void solve() {
  cin >> n;
  std::vector<long long int> ans(n);
  for (long long int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  init();
  build();
  for (long long int i = 0; i < n; ++i) {
    long long int pos = queryRange(0, n - 1);
    ans[pos] = i + 1;
    updateRange(pos + 1, n - 1, -(i + 1));
    updateRange(pos, pos, 1e14);
  }
  for (long long int i = 0; i < n; ++i) {
    cout << ans[i] << " ";
  }
  cout << '\n';
}
