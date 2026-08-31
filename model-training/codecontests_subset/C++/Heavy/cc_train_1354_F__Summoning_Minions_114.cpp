#include <bits/stdc++.h>
struct E {
  int a, b, rt;
} s[76];
int dp[76][76], ch[76][76], v[76];
int st[76];
bool mk[76];
void work() {
  memset(dp, 0xAC, sizeof(dp));
  memset(v, 0, sizeof(v));
  memset(mk, 0, sizeof(mk));
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    s[i].rt = i;
    scanf("%d%d", &s[i].a, &s[i].b);
    s[i].a -= (k - 1) * s[i].b;
  }
  std::sort(s + 1, s + n + 1, [](E x, E y) { return x.b < y.b; });
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = std::min(i, k); j >= 1; j--) {
      ch[i][j] = v[j - 1];
      dp[i][j] = dp[v[j - 1]][j - 1] + (j - 1) * s[i].b + s[i].a;
      if (dp[i][j] > dp[v[j]][j]) v[j] = i;
    }
  }
  int x = v[k], y = k;
  while (y) {
    st[y] = x;
    mk[x] = true;
    x = ch[x][y];
    y--;
  }
  printf("%d\n", 2 * n - k);
  for (int i = 1; i < k; i++) printf("%d ", s[st[i]].rt);
  for (int i = 1; i <= n; i++)
    if (!mk[i]) printf("%d %d ", s[i].rt, -s[i].rt);
  printf("%d ", s[st[k]].rt);
  puts("");
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) work();
}
