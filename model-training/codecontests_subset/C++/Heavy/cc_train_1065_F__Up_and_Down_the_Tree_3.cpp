#include <bits/stdc++.h>
int min(int a, int b) { return a < b ? a : b; }
int max(int a, int b) { return a > b ? a : b; }
int oo[1 + 1000000 - 1], oj[1 + 1000000 - 1];
int link(int o, int j) {
  static int _ = 1;
  oo[_] = o, oj[_] = j;
  return _++;
}
int ae[1000000], hh[1000000], dp[1000000], dq[1000000], n, k;
int dfs1(int i, int d) {
  int o, d_;
  if (ae[i] == 0) return d;
  d_ = n;
  for (o = ae[i]; o; o = oo[o]) {
    int j = oj[o];
    d_ = min(d_, dfs1(j, d + 1));
  }
  hh[i] = d_ - d;
  return d_;
}
void dfs2(int i) {
  int o;
  if (ae[i] == 0) {
    dp[i] = 1;
    return;
  }
  for (o = ae[i]; o; o = oo[o]) {
    int j = oj[o];
    dfs2(j);
    if (hh[j] < k) dp[i] += dp[j];
  }
}
void dfs3(int i) {
  int o, x = 0;
  for (o = ae[i]; o; o = oo[o]) {
    int j = oj[o];
    dfs3(j);
    x = max(x, dq[j] - (hh[j] < k ? dp[j] : 0));
  }
  dq[i] = dp[i] + x;
}
int main() {
  int i;
  scanf("%d%d", &n, &k);
  for (i = 1; i < n; i++) {
    int p;
    scanf("%d", &p), p--;
    ae[p] = link(ae[p], i);
  }
  dfs1(0, 0);
  dfs2(0);
  dfs3(0);
  printf("%d\n", dq[0]);
  return 0;
}
