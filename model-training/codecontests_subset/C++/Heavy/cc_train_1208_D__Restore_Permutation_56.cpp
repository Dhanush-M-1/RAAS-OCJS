#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
struct node {
  long long w, change;
  int in;
};
vector<long long> a;
vector<node> t;
const long long INF = 1e18;
node combine(node a, node b, long long change) {
  a.w += a.change;
  b.w += b.change;
  node res;
  if (a.w != b.w)
    res = (a.w < b.w) ? a : b;
  else
    res = (a.in > b.in) ? a : b;
  res.change = change;
  return res;
}
void build(int v, int tl, int tr) {
  if (tl == tr) {
    t[v] = {a[tl], 0, tl};
    return;
  }
  int tm = (tl + tr) / 2;
  build(2 * v, tl, tm);
  build(2 * v + 1, tm + 1, tr);
  t[v] = combine(t[2 * v], t[2 * v + 1], t[v].change);
}
void delete_el(int v, int tl, int tr, int pos) {
  if (tl == tr) {
    t[v] = {INF, 0, 0};
    return;
  }
  int tm = (tl + tr) / 2;
  if (pos <= tm)
    delete_el(2 * v, tl, tm, pos);
  else
    delete_el(2 * v + 1, tm + 1, tr, pos);
  t[v] = combine(t[2 * v], t[2 * v + 1], t[v].change);
}
void update(int v, int tl, int tr, int l, int r, long long val) {
  if (l > r) return;
  if (l == tl && r == tr) {
    t[v].change -= val;
    return;
  }
  int tm = (tl + tr) / 2;
  update(2 * v, tl, tm, l, min(r, tm), val);
  update(2 * v + 1, tm + 1, tr, max(l, tm + 1), r, val);
  t[v] = combine(t[2 * v], t[2 * v + 1], t[v].change);
}
int main() {
  int n;
  cin >> n;
  a.resize(n);
  t.resize(4 * n);
  for (int i = 0; i < n; i++) cin >> a[i];
  build(1, 0, n - 1);
  vector<long long> ans(n);
  for (int i = 0; i < n; i++) {
    int in = t[1].in;
    ans[in] = i + 1;
    delete_el(1, 0, n - 1, in);
    update(1, 0, n - 1, in + 1, n - 1, i + 1);
  }
  for (int i = 0; i < n; i++) cout << ans[i] << " ";
  cout << "\n";
  return 0;
}
