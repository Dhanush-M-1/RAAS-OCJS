#include <bits/stdc++.h>
using namespace std;
vector<long long> segta;
vector<long long> segtb;
void build(vector<long long> &seg) {
  for (int i = 0; i < 4 * 100005; i++) {
    seg.push_back(0);
  }
}
long long query(vector<long long> &segt, int id, int l, int r, int ql, int qr) {
  if (ql <= l && r <= qr) return segt[id];
  if (qr < l || r < ql) return 0;
  int m = (r + l) / 2;
  return query(segt, 2 * id, l, m, ql, qr) +
         query(segt, 2 * id + 1, m + 1, r, ql, qr);
}
void update(vector<long long> &segt, int id, int l, int r, int p, long long v,
            int lim) {
  if (l == r) {
    segt[id] += v;
    if (segt[id] > lim) segt[id] = lim;
  } else {
    int m = (r + l) / 2;
    if (p <= m)
      update(segt, 2 * id, l, m, p, v, lim);
    else
      update(segt, 2 * id + 1, m + 1, r, p, v, lim);
    segt[id] = segt[id * 2] + segt[id * 2 + 1];
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  build(segta);
  build(segtb);
  int n, k, a, b, q, c, x, y;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    cin >> c;
    if (c == 1) {
      cin >> x >> y;
      update(segta, 1, 1, n, x, y, a);
      update(segtb, 1, 1, n, x, y, b);
    } else {
      cin >> x;
      long long l = query(segtb, 1, 1, n, 1, x - 1);
      long long r = query(segta, 1, 1, n, x + k, n);
      long long ans = 0LL;
      if (x > 1) ans += l;
      if (x + k - 1 < n) ans += r;
      cout << ans << endl;
    }
  }
}
