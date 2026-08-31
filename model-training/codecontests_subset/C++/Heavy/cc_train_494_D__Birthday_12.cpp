#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
const long long MXN = 2e5 + 10;
const long long LOG = 20;
const long long Mod = 1e9 + 7;
long long n, timer, q;
long long Jad[LOG][MXN], dis[MXN], Stm[MXN], Ftm[MXN];
long long dp[2][MXN], sig[2][MXN], sub[MXN], Tdis[MXN];
vector<pair<long long, long long>> adj[MXN];
void prep(long long u, long long par) {
  timer++, Stm[u] = timer, Jad[0][u] = par;
  for (int i = 1; i < LOG; i++) {
    Jad[i][u] = Jad[i - 1][Jad[i - 1][u]];
  }
  for (auto Pr : adj[u]) {
    long long v, w;
    tie(v, w) = Pr;
    if (v == par) continue;
    dis[v] = (dis[u] + w) % Mod;
    Tdis[v] = Tdis[u] + 1;
    prep(v, u);
  }
  Ftm[u] = timer;
}
long long K_Jad(long long u, long long k) {
  for (int i = 0; i < LOG; i++) {
    if ((k >> i) & 1LL) u = Jad[i][u];
  }
  return u;
}
long long LCA(long long u, long long v) {
  if (Tdis[u] > Tdis[v]) swap(u, v);
  v = K_Jad(v, Tdis[v] - Tdis[u]);
  if (u == v) return u;
  for (int i = LOG - 1; ~i; i--) {
    if (Jad[i][u] != Jad[i][v]) {
      u = Jad[i][u], v = Jad[i][v];
    }
  }
  return Jad[0][u];
}
inline long long Fix(long long x) {
  x %= Mod;
  if (x < 0) x += Mod;
  return x;
}
inline long long DIS(long long u, long long v) {
  return Fix(dis[u] + dis[v] - (2ll * dis[LCA(u, v)] % Mod));
}
inline long long Is_Jad(long long x, long long u) {
  return (Stm[x] <= Stm[u] && Ftm[u] <= Ftm[x]);
}
inline long long Func(long long a, long long b) {
  return (((a * a % Mod) * (b * b % Mod) % Mod) + (a * b % Mod) * 2 % Mod) %
         Mod;
}
void DFS_down(long long u, long long par) {
  sub[u] = 1;
  for (auto Pr : adj[u]) {
    long long v, w, nw;
    tie(v, w) = Pr;
    if (v == par) continue;
    DFS_down(v, u);
    sub[u] += sub[v];
    sig[0][u] = (sig[0][u] + sig[0][v] + w * sub[v] % Mod) % Mod;
    nw = (dp[0][v] + sub[v] * (w * w % Mod) % Mod) % Mod;
    nw = (nw + 2 * w * sig[0][v] % Mod) % Mod;
    dp[0][u] = (dp[0][u] + nw) % Mod;
  }
}
void DFS_up(long long u, long long par, long long prw) {
  long long ex, now, nw;
  if (par) {
    sig[1][u] = (sig[1][u] + sig[1][par] + prw * (n - sub[par]) % Mod) % Mod;
    nw = Fix(sig[0][par] - (sig[0][u] + prw * sub[u] % Mod));
    sig[1][u] = (sig[1][u] + nw) % Mod;
    sig[1][u] = (sig[1][u] + (sub[par] - sub[u]) * prw % Mod) % Mod;
    dp[1][u] =
        (dp[1][u] + dp[1][par] + (prw * prw % Mod) * (n - sub[par]) % Mod);
    dp[1][u] = (dp[1][u] + (2 * prw % Mod) * sig[1][par] % Mod) % Mod;
    ex = (dp[0][u] + sub[u] * (prw * prw % Mod) % Mod) % Mod;
    ex = (ex + 2 * prw * sig[0][u] % Mod) % Mod;
    now = (prw * prw % Mod) * (sub[par] - sub[u]) % Mod;
    now = (now + (nw * prw % Mod) * 2) % Mod;
    dp[1][u] = (dp[1][u] + Fix(dp[0][par] - ex) + now) % Mod;
  }
  for (auto Pr : adj[u]) {
    long long v, w, nw;
    tie(v, w) = Pr;
    if (v == par) continue;
    DFS_up(v, u, w);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i < n; i++) {
    long long u, v, w;
    cin >> u >> v >> w;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  prep(1, 0);
  DFS_down(1, 0);
  DFS_up(1, 0, 0);
  cin >> q;
  while (q--) {
    long long u, v, val1, val2, nw, ex, d, kol;
    cin >> u >> v;
    d = DIS(u, v);
    kol = (dp[0][u] + dp[1][u]) % Mod;
    if (Is_Jad(v, u)) {
      val2 = (((dp[1][v] + (d * d % Mod) * (n - sub[v]) % Mod) % Mod) +
              (sig[1][v] * d % Mod) * 2 % Mod) %
             Mod;
      val1 = Fix(kol - val2 + Mod);
      cout << Fix(val1 - val2) << '\n';
    } else {
      val1 = (dp[0][v] + (d * d % Mod) * sub[v] + (d * sig[0][v]) * 2) % Mod;
      val2 = Fix(kol - val1);
      cout << Fix(val1 - val2) << '\n';
    }
  }
  return 0;
}
