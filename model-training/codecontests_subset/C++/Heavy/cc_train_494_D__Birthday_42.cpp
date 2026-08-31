#include <bits/stdc++.h>
using namespace std;
const long long N = 100100, MOD = 1000 * 1000 * 1000 + 7;
long long n, q;
vector<pair<long long, long long> > adl[N];
long long ks[N], ks2[N], as[N], as2[N], ted[N], anc[N][20], len[N], hei[N];
bool chk[N];
void dfs(long long v) {
  chk[v] = 1;
  ted[v] = 1;
  for (long long i = 0, u, w; i < adl[v].size(); ++i) {
    u = adl[v][i].first;
    w = adl[v][i].second;
    if (!chk[u]) {
      dfs(u);
      ted[v] += ted[u];
      ks[v] += ks[u];
      ks[v] %= MOD;
      ks[v] += w * ted[u];
      ks[v] %= MOD;
      long long w2 = w * w;
      w2 %= MOD;
      long long res = (w * ks[u]) % MOD;
      ks2[v] += 2 * res;
      ks2[v] %= MOD;
      ks2[v] += ks2[u] + w2 * ted[u];
      ks2[v] %= MOD;
    }
  }
}
void dfs(long long v, long long dad, long long wei) {
  chk[v] = 1;
  anc[v][0] = dad;
  len[v] = len[dad] + wei;
  len[v] %= MOD;
  hei[v] = hei[dad] + 1;
  if (!dad) {
    as[v] = ks[v];
    as2[v] = ks2[v];
  } else {
    long long other = n - ted[v];
    long long dis = other - ted[v];
    while (dis < 0) dis += MOD;
    as[v] = as[dad] + wei * (dis);
    as[v] %= MOD;
    long long sdis = as[dad] - 2 * ks[v] - ted[v] * wei;
    if (sdis < 0) sdis += wei * MOD;
    while (sdis < 0) sdis += MOD;
    sdis %= MOD;
    long long w2 = wei * wei;
    w2 %= MOD;
    as2[v] = as2[dad] + w2 * dis;
    as2[v] %= MOD;
    long long res = (wei * sdis) % MOD;
    as2[v] += res * 2;
    as2[v] %= MOD;
  }
  for (long long i = 0, u, w; i < adl[v].size(); ++i) {
    u = adl[v][i].first;
    w = adl[v][i].second;
    if (!chk[u]) dfs(u, v, w);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  for (long long i = 1, x, y, w; i < n; ++i) {
    cin >> x >> y >> w;
    adl[x].push_back(pair<long long, long long>(y, w));
    adl[y].push_back(pair<long long, long long>(x, w));
  }
  dfs(1);
  memset(chk, 0, sizeof chk);
  dfs(1, 0, 0);
  for (long long i = 1; i < 20; ++i)
    for (long long j = 1; j <= n; ++j) anc[j][i] = anc[anc[j][i - 1]][i - 1];
  cin >> q;
  for (long long i = 1, x, y; i <= q; ++i) {
    cin >> x >> y;
    long long lca, ans = 0, cx = x, cy = y;
    if (hei[x] < hei[y]) swap(x, y);
    long long dis = hei[x] - hei[y];
    for (long long j = 19; j >= 0; --j)
      if (dis & (1 << j)) x = anc[x][j];
    if (x == y) {
      lca = x;
      if (hei[cx] >= hei[cy]) {
        long long fas = len[cx] + len[cy] - 2 * len[lca];
        fas %= MOD;
        long long fas2 = fas * fas;
        fas2 %= MOD;
        long long res = ((fas * (as[cy] - ks[cy])) % MOD);
        ans =
            as2[cx] - 2 * (as2[cy] - ks2[cy] + fas2 * (n - ted[cy]) + 2 * res);
        if (ans < 0) ans += N * MOD;
        while (ans < 0) ans += MOD;
        ans %= MOD;
        cout << ans << "\n";
        continue;
      }
    } else {
      for (long long j = 19; j >= 0; --j)
        if (anc[x][j] != anc[y][j]) {
          x = anc[x][j];
          y = anc[y][j];
        }
      lca = anc[x][0];
    }
    long long fas = len[cx] + len[cy] - 2 * len[lca];
    fas %= MOD;
    long long fas2 = fas * fas;
    fas2 %= MOD;
    ans = ks2[cy] + fas2 * ted[cy];
    ans %= MOD;
    long long res = (fas * ks[cy]) % MOD;
    ans += res * 2;
    ans %= MOD;
    ans = ans - (as2[cx] - ans);
    if (ans < 0) ans += N * MOD;
    while (ans < 0) ans += MOD;
    ans %= MOD;
    cout << ans << "\n";
  }
  return 0;
}
