#include <bits/stdc++.h>
using namespace std;
const int MAX = 120000;
int n;
int a, b, c;
vector<pair<int, int> > g[MAX];
long long frg[2][MAX];
int f[20][MAX];
long long fuper[20][3][MAX];
int h[MAX];
long long d[MAX];
long long l[MAX];
long long weight[2][MAX];
long long weight1[2][MAX];
long long coun[MAX];
pair<long long, long long> recalc(long long v0, long long v1, long long hm,
                                  long long len) {
  return make_pair(
      (v0 + len * hm) % 1000000007,
      (v1 + len * len % 1000000007 * hm + 2 * len * v0) % 1000000007);
}
void dfs(int v) {
  coun[v]++;
  for (int(i) = (0); i < (g[v].size()); ++(i)) {
    int u = g[v][i].first;
    long long W = g[v][i].second;
    if (u != f[0][v]) {
      f[0][u] = v;
      h[u] = h[v] + 1;
      l[u] = W;
      d[u] = (d[v] + W) % 1000000007;
      for (int(j) = (1); j < (20); ++(j)) f[j][u] = f[j - 1][f[j - 1][u]];
      dfs(u);
      coun[v] += coun[u];
      pair<long long, long long> r =
          recalc(weight[0][u], weight[1][u], coun[u], W);
      frg[0][u] = r.first;
      weight[0][v] = (weight[0][v] + r.first) % 1000000007;
      frg[1][u] = r.second;
      weight[1][v] = (weight[1][v] + r.second) % 1000000007;
    }
  }
}
void dfs2(int v) {
  if (v == 0) {
    weight1[0][v] = weight[0][v];
    weight1[1][v] = weight[1][v];
  }
  for (int(i) = (0); i < (g[v].size()); ++(i)) {
    int u = g[v][i].first;
    int W = g[v][i].second;
    if (u != f[0][v]) {
      weight1[0][u] = weight[0][u];
      weight1[1][u] = weight[1][u];
      long long val0 = (weight1[0][v] - frg[0][u] + 1000000007) % 1000000007;
      long long val1 = (weight1[1][v] - frg[1][u] + 1000000007) % 1000000007;
      long long cnv = n - coun[u];
      pair<long long, long long> r = recalc(val0, val1, cnv, W);
      weight1[0][u] = (weight1[0][u] + r.first) % 1000000007;
      weight1[1][u] = (weight1[1][u] + r.second) % 1000000007;
      dfs2(u);
    }
  }
}
int upp(int a, int b) {
  for (int(i) = (20) - 1; (i) >= (0); --(i)) {
    if (h[a] - (1 << i) >= h[b]) {
      a = f[i][a];
    }
  }
  for (int(i) = (20) - 1; (i) >= (0); --(i)) {
    if (h[b] - (1 << i) >= h[a]) {
      b = f[i][b];
    }
  }
  for (int(i) = (20) - 1; (i) >= (0); --(i)) {
    if (f[i][a] != f[i][b]) {
      b = f[i][b];
      a = f[i][a];
    }
  }
  if (a != b)
    return f[0][a];
  else
    return a;
}
void dfs3(int v) {
  for (int(i) = (0); i < (g[v].size()); ++(i)) {
    int u = g[v][i].first;
    if (u != f[0][v]) {
      dfs3(u);
    }
  }
}
int main() {
  cin >> n;
  for (int(i) = (1); i < (n); ++(i)) {
    scanf("%d%d%d", &a, &b, &c);
    a--;
    b--;
    g[a].push_back(make_pair(b, c));
    g[b].push_back(make_pair(a, c));
  }
  f[0][0] = 0;
  dfs(0);
  dfs2(0);
  int q;
  cin >> q;
  for (int(i) = (0); i < (q); ++(i)) {
    scanf("%d%d", &a, &b);
    a--;
    b--;
    int ft = upp(a, b);
    long long len = (2 * 1000000007 + d[a] + d[b] - 2 * d[ft]) % 1000000007;
    if (ft != b) {
      pair<long long, long long> r =
          recalc(weight[0][b], weight[1][b], coun[b], len);
      cout << (2 * r.second + 1000000007 - weight1[1][a]) % 1000000007 << "\n";
    } else {
      pair<long long, long long> r =
          recalc((weight1[0][b] - weight[0][b] + 1000000007) % 1000000007,
                 (weight1[1][b] - weight[1][b] + 1000000007) % 1000000007,
                 n - coun[b], len);
      cout << (weight1[1][a] + 2 * 1000000007 - 2 * r.second) % 1000000007
           << "\n";
    }
  }
  return 0;
}
