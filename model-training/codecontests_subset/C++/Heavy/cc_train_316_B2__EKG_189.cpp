#include <bits/stdc++.h>
using namespace std;
const int big = 2000000000;
const double INF = 1e9;
const double EPS = 1e-9;
int par[1002];
int idx[1002];
int sz[1002];
int get_par(int x) {
  if (par[x] == x) {
    idx[x] = 1;
    return x;
  }
  int t = par[x];
  par[x] = get_par(par[x]);
  if (idx[x] == -1) idx[x] = idx[t] + 1;
  if (0) printf(">> %d %d %d %d\n", x, t, par[x], idx[x]);
  return par[x];
}
int main() {
  int n, q;
  memset((idx), -1, sizeof(idx));
  scanf("%d%d", &n, &q);
  --q;
  for (int x = 0, _c = n; x < _c; ++x) {
    scanf("%d", &par[x]);
    --par[x];
    if (par[x] == -1) par[x] = x;
  }
  set<int> blok;
  for (int x = 0, _c = n; x < _c; ++x) {
    if (idx[x] == -1) blok.insert(get_par(x));
    ++sz[par[x]];
  }
  blok.erase(par[q]);
  if (0) printf(">");
  for (int x = 0, _c = n; x < _c; ++x)
    if (0) printf(" %d", idx[x]);
  if (0) printf("\n");
  for (__typeof((blok).begin()) it = (blok).begin(); it != (blok).end(); ++it)
    if (0) printf("> %d %d\n", *it, sz[*it]);
  bool dp[1002];
  memset((dp), 0, sizeof(dp));
  dp[idx[q]] = true;
  for (__typeof((blok).begin()) it = (blok).begin(); it != (blok).end(); ++it)
    for (int x = n, _c = sz[*it]; x >= _c; --x)
      if (dp[x - sz[*it]]) dp[x] = true;
  for (int x = 0, _c = n + 1; x < _c; ++x)
    if (dp[x]) printf("%d\n", x);
  return 0;
}
