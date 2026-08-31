#include <bits/stdc++.h>
long long dx[8] = {0, 1, 0, -1, 1, 1, -1, -1};
long long dy[8] = {1, 0, -1, 0, -1, 1, 1, -1};
using namespace std;
class pa3 {
 public:
  long long x;
  long long y, z;
  pa3(long long x = 0, long long y = 0, long long z = 0) : x(x), y(y), z(z) {}
  bool operator<(const pa3 &p) const {
    if (x != p.x) return x < p.x;
    if (y != p.y) return y < p.y;
    return z < p.z;
  }
  bool operator>(const pa3 &p) const {
    if (x != p.x) return x > p.x;
    if (y != p.y) return y > p.y;
    return z > p.z;
  }
  bool operator==(const pa3 &p) const {
    return x == p.x && y == p.y && z == p.z;
  }
  bool operator!=(const pa3 &p) const {
    return !(x == p.x && y == p.y && z == p.z);
  }
};
class pa4 {
 public:
  long long x;
  long long y, z, w;
  pa4(long long x = 0, long long y = 0, long long z = 0, long long w = 0)
      : x(x), y(y), z(z), w(w) {}
  bool operator<(const pa4 &p) const {
    if (x != p.x) return x < p.x;
    if (y != p.y) return y < p.y;
    if (z != p.z) return z < p.z;
    return w < p.w;
  }
  bool operator>(const pa4 &p) const {
    if (x != p.x) return x > p.x;
    if (y != p.y) return y > p.y;
    if (z != p.z) return z > p.z;
    return w > p.w;
  }
  bool operator==(const pa4 &p) const {
    return x == p.x && y == p.y && z == p.z && w == p.w;
  }
};
class pa2 {
 public:
  long long x, y;
  pa2(long long x = 0, long long y = 0) : x(x), y(y) {}
  pa2 operator+(pa2 p) { return pa2(x + p.x, y + p.y); }
  pa2 operator-(pa2 p) { return pa2(x - p.x, y - p.y); }
  bool operator<(const pa2 &p) const { return y != p.y ? y < p.y : x < p.x; }
  bool operator>(const pa2 &p) const { return x != p.x ? x < p.x : y < p.y; }
  bool operator==(const pa2 &p) const {
    return abs(x - p.x) == 0 && abs(y - p.y) == 0;
  }
  bool operator!=(const pa2 &p) const {
    return !(abs(x - p.x) == 0 && abs(y - p.y) == 0);
  }
};
string itos(long long i) {
  ostringstream s;
  s << i;
  return s.str();
}
long long gcd(long long v, long long b) {
  if (v == 0) return b;
  if (b == 0) return v;
  if (v > b) return gcd(b, v);
  if (v == b) return b;
  if (b % v == 0) return v;
  return gcd(v, b % v);
}
long long mod;
long long extgcd(long long a, long long b, long long &x, long long &y) {
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  }
  long long d = extgcd(b, a % b, y, x);
  y -= a / b * x;
  return d;
}
pair<long long, long long> operator+(const pair<long long, long long> &l,
                                     const pair<long long, long long> &r) {
  return {l.first + r.first, l.second + r.second};
}
pair<long long, long long> operator-(const pair<long long, long long> &l,
                                     const pair<long long, long long> &r) {
  return {l.first - r.first, l.second - r.second};
}
long long pr[10000100];
long long inv[10000010];
long long beki(long long wa, long long rr, long long warukazu) {
  if (rr == 0) return 1 % warukazu;
  if (rr == 1) return wa % warukazu;
  wa %= warukazu;
  if (rr % 2 == 1)
    return ((long long)beki(wa, rr - 1, warukazu) * (long long)wa) % warukazu;
  long long zx = beki(wa, rr / 2, warukazu);
  return (zx * zx) % warukazu;
}
long long comb(long long nn, long long rr) {
  if (rr < 0 || rr > nn || nn < 0) return 0;
  long long r = pr[nn] * inv[rr];
  r %= mod;
  r *= inv[nn - rr];
  r %= mod;
  return r;
}
void gya(long long ert) {
  pr[0] = 1;
  for (long long i = 1; i <= ert; i++) {
    pr[i] = ((long long)pr[i - 1] * i) % mod;
  }
  inv[ert] = beki(pr[ert], mod - 2, mod);
  for (long long i = ert - 1; i >= 0; i--) {
    inv[i] = (long long)inv[i + 1] * (i + 1) % mod;
  }
}
struct unionfind {
 private:
 public:
  vector<long long> par, ranks, kosuu;
  void shoki(long long N) {
    par.resize(N + 1, 0);
    ranks.resize(N + 1, 0);
    kosuu.resize(N + 1, 1);
    for (long long i = 0; i <= N; i++) {
      par[i] = i;
    }
  }
  long long root(long long x) {
    return par[x] == x ? x : par[x] = root(par[x]);
  }
  bool same(long long x, long long y) { return root(x) == root(y); }
  bool is_root(long long x) { return x == root(x); }
  void unite(long long x, long long y) {
    x = root(x);
    y = root(y);
    long long xx = kosuu[x], yy = kosuu[y];
    if (x == y) return;
    if (ranks[x] < ranks[y]) {
      par[x] = y;
      kosuu[y] = yy + xx;
    } else {
      par[y] = x;
      if (ranks[x] == ranks[y]) ranks[x] = ranks[x] + 1;
      kosuu[x] = yy + xx;
    }
    return;
  }
};
vector<pair<long long, long long>> G[100020];
long long d[100020];
vector<pair<long long, long long>> T[100020];
vector<pair<long long, long long>> T2[100020];
long long depth[100020];
long long dp[100020][20] = {};
long long oya[100020][20];
void dfs(long long r, long long p, long long dep) {
  depth[r] = dep;
  for (auto v : T[r])
    if (v.first != p) {
      oya[v.first][0] = r;
      dp[v.first][0] = v.second;
      dfs(v.first, r, dep + 1);
    }
}
long long lca(long long a, long long b) {
  if (depth[a] < depth[b]) swap(a, b);
  long long sa = depth[a] - depth[b];
  for (long long i = 0; i < 20; i++)
    if (sa & (1 << i)) a = oya[a][i];
  if (a == b) return a;
  for (long long i = 19; i >= 0; i--) {
    if (oya[a][i] != oya[b][i]) {
      a = oya[a][i];
      b = oya[b][i];
    }
  }
  return oya[a][0];
}
long long kyo(long long a, long long d) {
  long long ans = -1000000007;
  for (long long i = 19; i >= 0; i--)
    if (d & (1 << i)) {
      ans = max(ans, dp[a][i]);
      a = oya[a][i];
    }
  return ans;
}
signed main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  unionfind uf;
  uf.shoki(100020);
  long long n, m, k, q;
  cin >> n >> m >> k >> q;
  for (long long i = 0; i < m; i++) {
    long long y, yy, yyy;
    cin >> y >> yy >> yyy;
    G[y].push_back(make_pair(yy, yyy));
    G[yy].push_back(make_pair(y, yyy));
  }
  for (long long i = 1; i <= n; i++) d[i] = 1000000007 * 10000000ll;
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      pq;
  for (long long i = 1; i <= k; i++) pq.push(make_pair(0, i));
  while (pq.size()) {
    pair<long long, long long> z = pq.top();
    pq.pop();
    if (d[z.second] != 1000000007 * 10000000ll) continue;
    d[z.second] = z.first;
    for (auto v : G[z.second]) pq.push(make_pair(z.first + v.second, v.first));
  }
  for (long long i = 1; i <= n; i++) {
    for (auto &v : G[i]) v.second += d[i] + d[v.first];
  }
  vector<pa3> eda;
  for (long long i = 1; i <= n; i++)
    for (auto v : G[i])
      if (i < v.first) {
        eda.push_back({v.second, i, v.first});
      }
  sort(eda.begin(), eda.end());
  for (auto v : eda) {
    if (uf.same(v.y, v.z)) continue;
    uf.unite(v.y, v.z);
    T[v.y].push_back(make_pair(v.z, v.x));
    T[v.z].push_back(make_pair(v.y, v.x));
  }
  oya[1][0] = 1;
  dfs(1, 1, 1);
  for (long long i = 1; i < 20; i++)
    for (long long j = 1; j <= n; j++) {
      oya[j][i] = oya[oya[j][i - 1]][i - 1];
      dp[j][i] = max(dp[j][i - 1], dp[oya[j][i - 1]][i - 1]);
    }
  for (long long eR = 0; eR < q; eR++) {
    long long a, b;
    cin >> a >> b;
    long long l = lca(a, b);
    long long e = -1000000007;
    if (a != l) e = max(e, kyo(a, depth[a] - depth[l]));
    if (b != l) e = max(e, kyo(b, depth[b] - depth[l]));
    cout << e << "\n";
  }
  return 0;
}
