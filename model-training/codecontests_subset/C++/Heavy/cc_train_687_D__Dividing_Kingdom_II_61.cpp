#include <bits/stdc++.h>
using namespace std;
const long long N = 1 << 20;
const long long second = 1 << 10;
long long n, m, q, v[N], u[N], w[N], par[N], f[second];
vector<long long> seg[N << 2], V;
bool CMP(long long i, long long j) { return w[i] > w[j]; }
long long Find(long long v) {
  if (par[v] == v) return v;
  long long p = Find(par[v]);
  f[v] ^= f[par[v]];
  par[v] = p;
  return p;
}
long long Union(long long v, long long u) {
  long long vv = Find(v), uu = Find(u);
  if (vv == uu) {
    if (f[v] == f[u]) return 0;
    return 1;
  }
  par[vv] = uu;
  f[vv] = f[v] == f[u];
  return 2;
}
void build(int id = 1, int b = 0, int e = m) {
  vector<long long> vec;
  memset(f, 0, sizeof f);
  iota(par, par + n + 1, 0);
  for (int i = b; i < e; i++) vec.push_back(i);
  sort(vec.begin(), vec.end(), CMP);
  for (auto i : vec) {
    long long x = Union(v[i], u[i]);
    if (!x) {
      seg[id].push_back(i);
      break;
    }
    if (x == 1) continue;
    seg[id].push_back(i);
  }
  if (e - b == 1) return;
  build((id << 1), b, ((b + e) >> 1));
  build(((id << 1) | 1), ((b + e) >> 1), e);
}
void get(int l, int r, int id = 1, int b = 0, int e = m) {
  if (r <= b || e <= l) return;
  if (l <= b && e <= r) {
    for (auto i : seg[id]) V.push_back(i);
    return;
  }
  get(l, r, (id << 1), b, ((b + e) >> 1));
  get(l, r, ((id << 1) | 1), ((b + e) >> 1), e);
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> n >> m >> q;
  for (int i = 0; i < m; i++) {
    cin >> v[i] >> u[i] >> w[i];
  }
  build();
  while (q--) {
    long long l, r;
    cin >> l >> r;
    l--;
    memset(f, 0, sizeof f);
    iota(par, par + n + 1, 0);
    V.clear();
    get(l, r);
    long long ans = -1;
    sort(V.begin(), V.end(), CMP);
    for (auto i : V) {
      long long x = Union(v[i], u[i]);
      if (x == 0) {
        ans = w[i];
        break;
      }
    }
    cout << ans << '\n';
  }
}
