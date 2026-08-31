#include <bits/stdc++.h>
using namespace std;
const long long MM = 10000000000000001;
int n;
long long a[200005];
int rs[200005];
long long lazy[4 * 200005];
pair<long long, int> it[4 * 200005];
pair<long long, int> minp(pair<long long, int> A, pair<long long, int> B) {
  if (A.first < B.first) return A;
  if (A.first > B.first) return B;
  if (A.second > B.second) return A;
  return B;
}
void build(int x, int l, int r) {
  if (l == r) {
    it[x] = make_pair(a[l], l);
    return;
  }
  int mid = (l + r) / 2;
  build(2 * x, l, mid);
  build(2 * x + 1, mid + 1, r);
  it[x] = minp(it[2 * x], it[2 * x + 1]);
}
void lazy_upd(int x, int l, int r) {
  it[x].first += lazy[x];
  if (l != r) {
    lazy[2 * x] += lazy[x];
    lazy[2 * x + 1] += lazy[x];
  }
  lazy[x] = 0;
}
void update(int x, int l, int r, int u, int v, long long val) {
  lazy_upd(x, l, r);
  if ((r < u) || (v < l)) return;
  if ((u <= l) && (r <= v)) {
    lazy[x] += val;
    lazy_upd(x, l, r);
    return;
  }
  int mid = (l + r) / 2;
  update(2 * x, l, mid, u, v, val);
  update(2 * x + 1, mid + 1, r, u, v, val);
  it[x] = minp(it[2 * x], it[2 * x + 1]);
}
int main() {
  ios::sync_with_stdio(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  build(1, 1, n);
  for (int i = 1; i <= n; i++) {
    pair<long long, int> p = it[1];
    int id = p.second;
    rs[id] = i;
    update(1, 1, n, id, id, MM);
    update(1, 1, n, id + 1, n, -i);
  }
  for (int i = 1; i <= n; i++) cout << rs[i] << ' ';
  return 0;
}
