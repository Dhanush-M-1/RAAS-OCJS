#include <bits/stdc++.h>
using namespace std;

#define ls val[k << 1]
#define rs val[k << 1 | 1]
#define mid ((s + t) >> 1)
#define lson k << 1, s, mid
#define rson k << 1 | 1, mid + 1, t
typedef long long ll;
typedef pair <ll, int> node;
typedef pair <int, int> pii;
typedef pair <ll, pii> edge;
const int maxn = 2e5 + 10;
int n, par[maxn]; ll k, a[maxn];
node dat[maxn]; vector <edge> e;
struct sgt {
  node val[maxn << 2];
  void build(int k, int s, int t) {
    if (s == t) {
      val[k] = node(1ll << 60, s); return;
    }
    build(lson), build(rson), val[k] = min(ls, rs);
  }
  void upd(int k, int s, int t, node x) {
    if (s == t) {
      val[k] = x; return;
    }
    if (x.second <= mid) {
      upd(lson, x);
    } else {
      upd(rson, x);
    }
    val[k] = min(ls, rs);
  }
  node query(int k, int s, int t, int l, int r) {
    if (l <= s && t <= r) {
      return val[k];
    }
    node res = node(1ll << 60, 0);
    if (l <= mid) res = query(lson, l, r);
    if (r > mid) res = min(res, query(rson, l, r));
    return res;
  }
} t1, t2;

int find(int x) {
  return par[x] == x ? x : par[x] = find(par[x]);
}

void unite(int x, int y) {
  par[find(x)] = find(y);
}

int main() {
  scanf("%d %lld", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", a + i), dat[i] = node(a[i], i), par[i] = i;
  }
  sort(dat + 1, dat + n + 1);
  t1.build(1, 1, n), t2.build(1, 1, n);
  for (int i = 1; i <= n; i++) {
    int x = dat[i].second; node p;
    p = x < n ? t1.query(1, 1, n, x + 1, n) : node(1ll << 60, 0);
    if (p.first < 1ll << 60) {
      e.push_back(edge(p.first + a[x] - k * x, pii(x, p.second)));
    }
    t1.upd(1, 1, n, node(a[x] + k * x, x));
    p = x > 1 ? t2.query(1, 1, n, 1, x - 1) : node(1ll << 60, 0);
    if (p.first < 1ll << 60) {
      e.push_back(edge(p.first + a[x] - k * (n - x), pii(x, p.second)));
    }
    t2.upd(1, 1, n, node(a[x] + k * (n - x), x));
  }
  sort(e.begin(), e.end());
  ll ans = 0;
  for (edge p : e) {
    int u = p.second.first, v = p.second.second;
    if (find(u) != find(v)) {
      unite(u, v), ans += p.first;
    }
  }
  printf("%lld", ans);
  return 0;
}