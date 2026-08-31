#include <bits/stdc++.h>
using namespace std;
int dp[110][10010], n, s1, s2, ans, num, x;
struct node {
  int l, r;
} f[10010];
int cmp(node a, node b) {
  if (a.r != b.r)
    return a.r > b.r;
  else
    return a.l > b.l;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &f[i].l);
    s1 += f[i].l;
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &f[i].r);
    s2 += f[i].r;
  }
  x = s1;
  sort(f + 1, f + 1 + n, cmp);
  while ("Chtholly") {
    x -= f[++num].r;
    if (x <= 0) break;
  }
  memset(dp, -0x7f, sizeof dp);
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++)
    for (int j = s2; j >= f[i].r; j--)
      for (int k = 1; k <= num; k++)
        dp[k][j] = max(dp[k][j], dp[k - 1][j - f[i].r] + f[i].l);
  for (int i = s1; i <= s2; i++) ans = max(ans, dp[num][i]);
  cout << num << " " << s1 - ans;
}
