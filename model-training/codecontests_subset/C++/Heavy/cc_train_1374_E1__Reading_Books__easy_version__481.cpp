#include <bits/stdc++.h>
const long long maxn = 2e5 + 1;
using namespace std;
struct triple {
  long long t, ci;
  bool a = 0, b = 0;
  triple() {}
};
bool cmp(triple x, triple y) { return x.t < y.t; }
triple v[maxn];
bool usd[maxn];
long long ci = -1;
long long cs = 0;
inline void add() {
  ++ci;
  for (; usd[ci]; ci++)
    ;
  cs += v[ci].t;
}
inline void del() {
  if (ci == -1) exit(228);
  cs -= v[ci].t;
  --ci;
  for (; ci >= 0 && usd[ci]; --ci)
    ;
}
inline void dl(long long x) {
  usd[x] = 0;
  if (x < ci) {
    cs += v[x].t - v[ci].t;
    --ci;
    for (; ci >= 0 && usd[ci]; ci--)
      ;
  }
}
inline void ad(long long x) {
  usd[x] = 1;
  if (x <= ci) {
    cs -= v[x].t;
    ++ci;
    for (; usd[ci]; ci++)
      ;
    cs += v[ci].t;
  }
}
long long n, m, k;
long long solve() {
  cin >> n >> m >> k;
  for (long long i = 0; i < n; i++) {
    cin >> v[i].t >> v[i].a >> v[i].b;
    v[i].ci = i + 1;
  }
  sort(v, v + n, cmp);
  vector<long long> oo, oz, zo;
  for (long long i = 0; i < n; i++) {
    if (v[i].a && v[i].b)
      oo.push_back(i);
    else if (v[i].a)
      oz.push_back(i);
    else if (v[i].b)
      zo.push_back(i);
  }
  long long j1 = 0, j2 = 0, mi = -1;
  long long ans = 1e18, can = 0;
  for (long long i = 0; i < m; i++) add();
  for (long long i = 0; i < min(k, (long long)oo.size()); i++) {
    can += v[oo[i]].t;
    del();
    ad(oo[i]);
  }
  for (long long i = min(k, (long long)oo.size()); i >= 0; i--) {
    if (i + min(zo.size(), oz.size()) < k) break;
    if (2 * k - i > m) break;
    if (i < min(k, (long long)oo.size())) {
      dl(oo[i]);
      add();
      can -= v[oo[i]].t;
    }
    for (; i + j1 < k; j1++) {
      can += v[oz[j1]].t;
      del();
      ad(oz[j1]);
    }
    for (; i + j2 < k; j2++) {
      can += v[zo[j2]].t;
      del();
      ad(zo[j2]);
    }
    if (ans > can + cs) {
      ans = can + cs;
      mi = i;
    }
  }
  if (mi == -1) {
    cout << -1;
    return 0;
  }
  cout << ans << '\n';
  for (long long i = 0; i < n; i++) usd[i] = 0;
  for (long long j = 0; j < mi; j++) {
    cout << v[oo[j]].ci << ' ';
    usd[oo[j]] = 1;
  }
  for (long long j = 0; j < k - mi; j++) {
    cout << v[oz[j]].ci << ' ';
    usd[oz[j]] = 1;
  }
  for (long long j = 0; j < k - mi; j++) {
    cout << v[zo[j]].ci << ' ';
    usd[zo[j]] = 1;
  }
  long long cnt = 0;
  for (long long i = 0; cnt < m - (2 * k - mi); i++) {
    if (usd[i]) continue;
    cout << v[i].ci << ' ';
    ++cnt;
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
