#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 10, MOD = 1e9 + 7, lg = 19;
int n, h[MAXN], LCA[MAXN][lg], q;
long long cntd[MAXN], cntu[MAXN], dsr[MAXN], zdt2[MAXN], zdt1[MAXN],
    zdtu1[MAXN], zdtu2[MAXN];
vector<pair<int, long long> > Mat[MAXN];
void topar(int v, int hi, long long val, int p) {
  LCA[v][0] = p;
  h[v] = hi;
  dsr[v] += val;
  dsr[v] %= MOD;
  cntd[v] = 1;
  for (int i = 0; i < Mat[v].size(); i++)
    if (Mat[v][i].first != p) {
      topar(Mat[v][i].first, hi + 1, val + Mat[v][i].second, v);
      cntd[v] += cntd[Mat[v][i].first];
      zdt1[v] += zdt1[Mat[v][i].first] +
                 (cntd[Mat[v][i].first] * Mat[v][i].second) % MOD;
      zdt1[v] %= MOD;
      zdt2[v] += zdt2[Mat[v][i].first] +
                 (cntd[Mat[v][i].first] *
                  ((Mat[v][i].second * Mat[v][i].second) % MOD)) %
                     MOD;
      zdt2[v] += 2 * (zdt1[Mat[v][i].first] * Mat[v][i].second) % MOD;
      zdt2[v] %= MOD;
    }
}
void updup(int v, int p, long long val) {
  if (v != 1) {
    cntu[v] = cntu[p] + cntd[p] - cntd[v];
    zdtu1[v] += zdtu1[p] + zdt1[p] - zdt1[v] - (val * cntd[v]) % MOD +
                (cntu[v] * val) % MOD;
    zdtu1[v] %= MOD;
    zdtu2[v] = zdtu2[p];
    zdtu2[v] += (cntu[v] * ((val * val) % MOD)) % MOD;
    zdtu2[v] += (val * (zdtu1[p] + zdt1[p] - zdt1[v] - (val * cntd[v]) % MOD) %
                 MOD * 2) %
                MOD;
    zdtu2[v] += zdt2[p] - zdt2[v] - (cntd[v] * ((val * val) % MOD)) % MOD -
                2 * (zdt1[v] * val) % MOD;
    zdtu2[v] %= MOD;
  }
  for (int i = 0; i < Mat[v].size(); i++)
    if (Mat[v][i].first != p) updup(Mat[v][i].first, v, Mat[v][i].second);
}
int goup(int v, int dis) {
  int k = 0;
  while (dis) {
    if (dis % 2) v = LCA[v][k];
    k++;
    dis /= 2;
  }
  return v;
}
int getLCA(int v, int u) {
  if (h[v] < h[u]) swap(u, v);
  int dis = h[v] - h[u];
  v = goup(v, dis);
  if (v == u) return v;
  for (int i = lg - 1; i >= 0; i--)
    if (LCA[v][i] != LCA[u][i]) v = LCA[v][i], u = LCA[u][i];
  return LCA[u][0];
}
long long getdis(int v, int u) {
  return (dsr[v] + dsr[u] - 2 * dsr[getLCA(v, u)]) % MOD;
}
int main() {
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    Mat[a].push_back({b, c});
    Mat[b].push_back({a, c});
  }
  topar(1, 0, 0, 1);
  updup(1, 1, 0);
  for (int i = 1; i < lg; i++)
    for (int j = 1; j <= n; j++) LCA[j][i] = LCA[LCA[j][i - 1]][i - 1];
  cin >> q;
  while (q--) {
    int v, u;
    cin >> u >> v;
    if (u == 10) u = 10;
    long long d = getdis(v, u);
    long long S = zdt2[u] + zdtu2[u];
    if (getLCA(v, u) == v) {
      S -= 2 * (zdtu2[v] + (cntu[v] * ((d * d) % MOD)) % MOD +
                (((d * zdtu1[v]) % MOD) * 2) % MOD);
      S %= MOD, S += MOD, S %= MOD;
      cout << S << endl;
    } else {
      long long res = 2 * (zdt2[v] + (cntd[v] * ((d * d) % MOD)) % MOD +
                           (((d * zdt1[v]) % MOD) * 2) % MOD);
      res -= S;
      res %= MOD, res += MOD, res %= MOD;
      cout << res << endl;
    }
  }
}
