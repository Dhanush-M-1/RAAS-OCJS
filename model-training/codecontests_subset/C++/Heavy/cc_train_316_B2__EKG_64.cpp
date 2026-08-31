#include <bits/stdc++.h>
using namespace std;
int dp[1000000];
int rk[1000000], fa[1000000], cnt[1000000];
bool vis[1000000];
int n, x, y;
void init() {
  for (int i = 0; i <= n; i++) fa[i] = i, rk[i] = 0;
}
int find(int a) {
  if (fa[a] != a) {
    int t = fa[a];
    fa[a] = find(fa[a]);
    rk[a] += rk[t];
  }
  return fa[a];
}
int main() {
  scanf("%d%d", &n, &x);
  init();
  for (int i = 1; i <= n; i++) {
    scanf("%d", &y);
    if (y != 0) {
      fa[i] = y;
      rk[i] = 1;
    }
  }
  for (int i = 1; i <= n; i++) {
    int fa1 = find(i);
    cnt[fa1]++;
  }
  int fax = find(x);
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    if (i != fax && cnt[i]) {
      for (int j = n + 1; j >= cnt[i]; j--)
        if (dp[j - cnt[i]]) dp[j] = 1;
    }
  }
  for (int i = 0; i <= n; i++)
    if (dp[i]) {
      printf("%d\n", i + rk[x] + 1);
    }
}
