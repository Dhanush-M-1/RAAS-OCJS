#include <bits/stdc++.h>
using namespace std;
const int maxn = 10000 + 10;
const int MOD = 1000000007;
int n, x;
int at;
int pa[1010], d[1010], s[1010];
int a[1010];
int findset(int x) {
  if (pa[x] != x) {
    int root = findset(pa[x]);
    d[x] += d[pa[x]];
    return pa[x] = root;
  } else
    return x;
}
int dp[1010];
int main() {
  scanf("%d %d", &n, &x);
  for (int i = 0; i < n; ++i) scanf("%d", &a[i + 1]);
  for (int i = 1; i <= n; ++i) {
    s[i] = 1;
    pa[i] = i;
  }
  for (int i = 1; i <= n; ++i) {
    if (a[i] != 0) {
      pa[i] = a[i];
      d[i] = 1;
      int u = findset(i);
      s[u] += s[i];
    }
  }
  map<int, int> tt;
  int mm = findset(x);
  for (int i = 1; i <= n; ++i)
    if (findset(i) != mm) tt[findset(i)] = s[findset(i)];
  dp[d[x] + 1] = 1;
  int kk = 2;
  for (map<int, int>::iterator it = tt.begin(); it != tt.end(); ++kk, ++it)
    for (int i = 1; i <= n; ++i)
      if (dp[i] && dp[i] != kk && (it->second) + i <= n &&
          !dp[it->second + i]) {
        dp[i + (it->second)] = kk;
      }
  for (int i = 1; i <= n; ++i)
    if (dp[i]) printf("%d\n", i);
}
