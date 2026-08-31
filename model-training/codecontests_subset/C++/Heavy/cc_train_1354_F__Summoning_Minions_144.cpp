#include <bits/stdc++.h>
using namespace std;
struct ANS {
  long long sss, i;
  ANS *to;
} dp[80][80];
ANS max_get(ANS a, ANS b, ANS *aa, ANS *bb, long long i) {
  ANS s;
  if (a.sss > b.sss) {
    s.sss = a.sss;
    s.i = 0;
    s.to = aa;
  } else {
    s.sss = b.sss;
    s.i = i;
    s.to = bb;
  }
  return s;
}
struct node {
  long long a, b, i;
  bool operator<(const node x) const { return b < x.b; }
} mp[80];
long long n, m, T;
bool vis[80];
void print(ANS *x) {
  if (x == NULL) return;
  print(x->to);
  if (x->i) {
    printf("%lld ", mp[x->i].i);
    vis[x->i] = 1;
  }
}
int main() {
  scanf("%lld", &T);
  while (T--) {
    memset(vis, 0, sizeof(vis));
    scanf("%lld%lld", &n, &m);
    for (long long i = 1; i <= n; i++) {
      scanf("%lld%lld", &mp[i].a, &mp[i].b);
      mp[i].i = i;
    }
    sort(mp + 1, mp + n + 1);
    if (n <= m) {
      printf("%lld\n", n);
      for (long long i = 1; i <= n; i++) printf("%lld ", mp[i].i);
      printf("\n");
      continue;
    }
    for (long long i = 0; i <= n; i++)
      for (long long j = 0; j <= m; j++) {
        dp[i][j].sss = -1e18;
        dp[i][j].i = 0;
        dp[i][j].to = NULL;
      }
    dp[0][0].sss = 0;
    for (long long i = 1; i <= n; i++) {
      dp[i][0].i = 0;
      dp[i][0].to = &dp[i - 1][0];
      dp[i][0].sss = dp[i - 1][0].sss + mp[i].b * (m - 1);
      for (long long j = 1; j <= m; j++) {
        ANS xa = dp[i - 1][j], xb = dp[i - 1][j - 1];
        xa.sss += mp[i].b * (m - 1);
        xb.sss += mp[i].b * (j - 1) + mp[i].a;
        dp[i][j] = max_get(xa, xb, &dp[i - 1][j], &dp[i - 1][j - 1], i);
      }
    }
    printf("%lld\n", 2 * n - m);
    ANS re = dp[n][m];
    while (!re.i) re = *(re.to);
    print(re.to);
    vis[re.i] = 1;
    for (long long i = 1; i <= n; i++)
      if (!vis[i]) printf("%lld -%lld ", mp[i].i, mp[i].i);
    printf("%lld\n", mp[re.i].i);
  }
  return 0;
}
