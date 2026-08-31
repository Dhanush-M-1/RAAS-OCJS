#include <bits/stdc++.h>
using namespace std;
const long long INF = ~0ull >> 1;
long long _min[2000005 * 5], add[2000005 * 5];
int n;
long long s[2000005];
int ans[2000005];
void pushup(int o) { _min[o] = min(_min[o << 1], _min[o << 1 | 1]); }
void pushdown(int o) {
  if (add[o]) {
    add[o << 1] += add[o];
    add[o << 1 | 1] += add[o];
    _min[o << 1] += add[o];
    _min[o << 1 | 1] += add[o];
    add[o] = 0;
  }
}
void build(int o, int l, int r) {
  if (l == r) {
    _min[o] = s[l];
    return;
  }
  int m = (l + r) >> 1;
  build(o << 1, l, m);
  build(o << 1 | 1, m + 1, r);
  pushup(o);
}
void update(int o, int l, int r, int ql, int qr, long long v) {
  if (ql <= l && qr >= r) {
    add[o] += v;
    _min[o] += v;
    return;
  }
  pushdown(o);
  int m = (l + r) >> 1;
  if (ql <= m && qr >= l) update(o << 1, l, m, ql, qr, v);
  if (ql <= r && qr >= m + 1) update(o << 1 | 1, m + 1, r, ql, qr, v);
  pushup(o);
}
int query(int o, int l, int r, long long v) {
  if (l == r) {
    return l;
  }
  pushdown(o);
  int m = (l + r) >> 1;
  if (_min[o << 1 | 1] == v)
    return query(o << 1 | 1, m + 1, r, v);
  else
    return query(o << 1, l, m, v);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
  }
  build(1, 1, n);
  for (int i = 0; i < n; i++) {
    long long v = _min[1];
    int pos = query(1, 1, n, v);
    ans[pos] = i + 1;
    update(1, 1, n, pos, pos, INF);
    if (pos < n) update(1, 1, n, pos + 1, n, -1 * (i + 1));
  }
  for (int i = 1; i <= n; i++) {
    if (i != 1) cout << " ";
    cout << ans[i];
  }
  cout << endl;
  return 0;
}
