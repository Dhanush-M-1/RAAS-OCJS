#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 100;
int n, seg[4 * maxn][2], arr[maxn];
void add(int t, int idx, int val, int L = 0, int R = n, int id = 1) {
  if (L == R - 1) {
    seg[id][t] = val;
    return;
  }
  int mid = (L + R) >> 1;
  if (idx < mid)
    add(t, idx, val, L, mid, id * 2 + 0);
  else
    add(t, idx, val, mid, R, id * 2 + 1);
  seg[id][t] = seg[id * 2 + 0][t] + seg[id * 2 + 1][t];
}
int get(int t, int l, int r, int L = 0, int R = n, int id = 1) {
  if (l == L && r == R) return seg[id][t];
  int mid = (L + R) >> 1, ret = 0;
  if (l < mid) ret += get(t, l, min(mid, r), L, mid, id * 2 + 0);
  if (r > mid) ret += get(t, max(l, mid), r, mid, R, id * 2 + 1);
  return ret;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int t;
    cin >> t;
    if (t == 1) {
      int idx, val;
      cin >> idx >> val;
      idx--, arr[idx] += val;
      add(0, idx, min(a, arr[idx]));
      add(1, idx, min(b, arr[idx]));
    } else {
      int pi;
      cin >> pi;
      pi--;
      int ans = 0;
      if (pi + k < n) ans += get(0, pi + k, n);
      if (0 < pi) ans += get(1, 0, pi);
      cout << ans << '\n';
    }
  }
  return 0;
}
