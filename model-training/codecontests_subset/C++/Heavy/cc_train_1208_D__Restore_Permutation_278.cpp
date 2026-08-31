#include <bits/stdc++.h>
const long long inf = 0x3f3f3f3f;
const long long inn = 0x80808080;
using namespace std;
const long long maxm = 2e5 + 5;
long long mi[maxm << 2];
long long laz[maxm << 2];
long long p[maxm];
long long n;
void pushup(long long node) { mi[node] = min(mi[node * 2], mi[node * 2 + 1]); }
void pushdown(long long node) {
  if (laz[node]) {
    mi[node * 2] += laz[node];
    mi[node * 2 + 1] += laz[node];
    laz[node * 2] += laz[node];
    laz[node * 2 + 1] += laz[node];
    laz[node] = 0;
  }
}
void build(long long l, long long r, long long node) {
  if (l == r) {
    cin >> mi[node];
    return;
  }
  long long mid = (l + r) / 2;
  build(l, mid, node * 2);
  build(mid + 1, r, node * 2 + 1);
  pushup(node);
}
long long ask(long long x, long long l, long long r, long long node) {
  if (l == r) {
    mi[node] = (1LL << 60);
    return l;
  }
  long long mid = (l + r) / 2;
  pushdown(node);
  long long ans = 1;
  if (mi[node * 2 + 1] <= x)
    ans = ask(x, mid + 1, r, node * 2 + 1);
  else
    ans = ask(x, l, mid, node * 2);
  pushup(node);
  return ans;
}
void update(long long st, long long ed, long long val, long long l, long long r,
            long long node) {
  if (st <= l && ed >= r) {
    mi[node] += val;
    laz[node] += val;
    return;
  }
  pushdown(node);
  long long mid = (l + r) / 2;
  if (st <= mid) update(st, ed, val, l, mid, node * 2);
  if (ed >= mid) update(st, ed, val, mid + 1, r, node * 2 + 1);
  pushup(node);
}
signed main() {
  ios::sync_with_stdio(0);
  cin >> n;
  build(1, n, 1);
  for (long long i = 1; i <= n; i++) {
    long long x = ask(0, 1, n, 1);
    p[x] = i;
    if (x != n) {
      update(x + 1, n, -i, 1, n, 1);
    }
  }
  for (long long i = 1; i <= n; i++) {
    cout << p[i] << ' ';
  }
  cout << endl;
  return 0;
}
