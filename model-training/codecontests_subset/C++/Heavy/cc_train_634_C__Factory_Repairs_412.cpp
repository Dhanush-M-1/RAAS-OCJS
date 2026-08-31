#include <bits/stdc++.h>
const int inf = 2 * 1e9;
const int mod = 1e9 + 7;
const long long infll = (long long)1e18;
const long double eps = 1e-9;
const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, -1, 0, 1};
using namespace std;
int a, b;
struct node {
  int v1;
  int v2;
  node() : v1(0), v2(0) {}
  node(int v1, int v2) : v1(v1), v2(v2) {}
};
vector<node> t;
node combine(const node& p, const node& q) {
  return node(p.v1 + q.v1, p.v2 + q.v2);
}
void update(int v, int tl, int tr, int pos, int val) {
  if (tl == tr) {
    t[v].v1 = min(a, t[v].v1 + val);
    t[v].v2 = min(b, t[v].v2 + val);
  } else {
    int tm = (tl + tr) / 2;
    if (pos <= tm)
      update(v * 2, tl, tm, pos, val);
    else
      update(v * 2 + 1, tm + 1, tr, pos, val);
    t[v] = combine(t[v * 2], t[v * 2 + 1]);
  }
}
node get(int v, int tl, int tr, int l, int r) {
  if (l > r) return node();
  if (tl == l && tr == r) return t[v];
  int tm = (tl + tr) / 2;
  return combine(get(v * 2, tl, tm, l, min(r, tm)),
                 get(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r));
}
void solve() {
  int n, k, q;
  cin >> n >> k >> a >> b >> q;
  t.resize(4 * n);
  for (int i = 0; i < q; i++) {
    int type;
    cin >> type;
    if (type == 1) {
      int d, a;
      cin >> d >> a;
      d--;
      update(1, 0, n - 1, d, a);
    } else {
      int p;
      cin >> p;
      p--;
      node v1 = p ? get(1, 0, n - 1, 0, p - 1) : node();
      int ind = p + k;
      node v2 = ind != n ? get(1, 0, n - 1, ind, n - 1) : node();
      cout << v1.v2 + v2.v1 << endl;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  solve();
  return 0;
}
