#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 10, lg = 19, mod = 1e9 + 7;
long long n, q, cnt[N], down[N], up[N], up2[N], down2[N], high[N], dp[N][lg],
    dis[N][lg];
pair<long long, long long> par[N];
vector<pair<long long, long long> > adj[N];
inline long long SUM(long long a, long long b) {
  long long res = a + b;
  while (res > mod) res -= mod;
  while (res < 0) res += mod;
  return res;
}
inline long long MUL(long long a, long long b) {
  long long res = a * b;
  res %= mod;
  if (res < 0) res += mod;
  return res;
}
void make_par(long long v, long long p, long long h) {
  par[v].first = p;
  high[v] = h;
  cnt[v] = 1;
  for (pair<long long, long long> i : adj[v])
    if (i.first != p) {
      par[i.first].second = i.second;
      make_par(i.first, v, h + 1);
      cnt[v] += cnt[i.first];
    }
}
void make_down(long long v) {
  for (pair<long long, long long> i : adj[v]) {
    long long u = i.first, w = i.second;
    if (u != par[v].first) {
      make_down(u);
      down[v] = SUM(down[v], SUM(MUL(cnt[u], w), down[u]));
    }
  }
}
void make_down2(long long v) {
  for (pair<long long, long long> i : adj[v]) {
    long long u = i.first, w = i.second;
    if (u != par[v].first) {
      make_down2(u);
      down2[v] = SUM(down2[v], SUM(MUL(MUL(w, w), cnt[u]),
                                   SUM(MUL(2 * w, down[u]), down2[u])));
    }
  }
}
void make_up(long long v) {
  if (v) {
    long long p = par[v].first;
    up[v] =
        SUM(SUM(up[p], SUM(down[p], -SUM(down[v], MUL(cnt[v], par[v].second)))),
            MUL(SUM(n, -cnt[v]), par[v].second));
  }
  for (pair<long long, long long> i : adj[v])
    if (i.first != par[v].first) make_up(i.first);
}
void make_up2(long long v) {
  if (v) {
    long long p = par[v].first;
    long long w = par[v].second;
    long long tmp = SUM(SUM(down[p], -down[v]), -MUL(cnt[v], w));
    up2[v] = SUM(SUM(up2[p], MUL(MUL((n - cnt[p]), w), w)), MUL(2 * w, up[p]));
    up2[v] =
        SUM(up2[v],
            SUM(SUM(SUM(SUM(SUM(down2[p], -down2[v]), -MUL(MUL(w, w), cnt[v])),
                        -MUL(2 * w, down[v])),
                    MUL(MUL(w, w), (cnt[p] - cnt[v]))),
                MUL(2 * w, tmp)));
  }
  for (pair<long long, long long> i : adj[v])
    if (i.first != par[v].first) make_up2(i.first);
}
long long go_up(long long v, long long dis) {
  long long u = 0;
  while (dis) {
    if (dis & 1) v = dp[v][u];
    u++;
    dis /= 2;
  }
  return v;
}
long long LCA(long long v, long long u) {
  if (high[v] < high[u]) swap(v, u);
  v = go_up(v, high[v] - high[u]);
  if (v == u) return v;
  for (long long i = lg - 1; i >= 0; i--)
    if (dp[v][i] != dp[u][i]) {
      v = dp[v][i];
      u = dp[u][i];
    }
  return par[v].first;
}
long long get_dis(long long v, long long d) {
  long long res = 0, u = 0;
  while (d) {
    if (d & 1) res = SUM(res, dis[v][u]), v = dp[v][u];
    u++;
    d /= 2;
  }
  return res;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (long long i = 1; i < n; i++) {
    long long v, u, w;
    cin >> v >> u >> w;
    v--;
    u--;
    adj[v].push_back({u, w});
    adj[u].push_back({v, w});
  }
  make_par(0, 0, 0);
  make_down(0);
  make_down2(0);
  make_up(0);
  make_up2(0);
  for (long long i = 0; i < n; i++) dp[i][0] = par[i].first;
  for (long long j = 1; j < lg; j++)
    for (long long i = 0; i < n; i++) dp[i][j] = dp[dp[i][j - 1]][j - 1];
  for (long long i = 0; i < n; i++) dis[i][0] = par[i].second;
  for (long long j = 1; j < lg; j++)
    for (long long i = 0; i < n; i++)
      dis[i][j] = dis[i][j - 1] + dis[dp[i][j - 1]][j - 1];
  cin >> q;
  for (long long i = 0; i < q; i++) {
    long long u, v, p, w;
    cin >> u >> v;
    u--;
    v--;
    p = LCA(v, u);
    w = get_dis(v, high[v] - high[p]) + get_dis(u, high[u] - high[p]);
    if (p != v) {
      long long S =
          SUM(SUM(down2[v], MUL(MUL(cnt[v], w), w)), MUL(2 * w, down[v]));
      long long S2 = SUM(SUM(up2[u], down2[u]), -S);
      long long res = SUM(S, -S2);
      cout << res << '\n';
    } else {
      long long S = SUM(SUM(SUM(SUM(down2[u], up2[u]), -up2[v]),
                            -MUL(MUL(SUM(n, -cnt[v]), w), w)),
                        -MUL(2 * w, up[v]));
      long long S2 = SUM(SUM(up2[u], down2[u]), -S);
      long long res = SUM(S, -S2);
      cout << res << '\n';
    }
  }
}
