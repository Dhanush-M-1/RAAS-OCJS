#include <bits/stdc++.h>
int n, m, up, spe, sp;
int a[1010];
int s[1010];
int f[1010];
int v[1010];
int dp[3010];
int findset(int x) {
  if (x == f[x]) return x;
  f[x] = findset(f[x]);
  return f[x];
}
inline void init() {
  int i, fx, fy;
  scanf("%d%d", &n, &m);
  spe = 0;
  sp = m;
  for (i = 1; i <= n; i++) {
    f[i] = i;
    s[i] = 1;
    scanf("%d", &a[i]);
  }
  for (i = 1; i <= n; i++) {
    if (a[i] == 0) continue;
    fx = findset(a[i]);
    fy = findset(i);
    if (fy == sp) spe += s[fx];
    if (a[i] == sp) sp = fy;
    s[fy] += s[fx];
    f[fx] = fy;
  }
  up = 0;
  for (i = 1; i <= n; i++) {
    fx = findset(i);
    if (s[fx] && sp != fx) {
      up++;
      v[up] = s[fx];
      s[fx] = 0;
    }
  }
}
inline void work() {
  int i, j;
  memset(dp, 0, sizeof(dp));
  dp[0] = 1;
  for (i = 1; i <= up; i++)
    for (j = n; j >= v[i]; j--)
      if (dp[j - v[i]]) dp[j] = 1;
  spe++;
  for (i = 0; i <= n - spe; i++)
    if (dp[i]) printf("%d\n", i + spe);
}
int main() {
  init();
  work();
  return 0;
}
