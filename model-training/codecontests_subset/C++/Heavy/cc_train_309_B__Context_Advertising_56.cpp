#include <bits/stdc++.h>
using namespace std;
char s[6000065];
int n, root, r, c, a[6000065], dp[1000005][21], pw[22], st[1000055], l;
int main() {
  pw[0] = 1;
  for (int i = 1; i <= 20; i++) pw[i] = pw[i - 1] * 2;
  scanf("%d%d%d", &n, &r, &c);
  for (int i = 1; i <= n; i++) {
    scanf("%s", s + root);
    st[i] = root;
    l = strlen(s + root);
    for (int j = root; j < root + l; j++) a[j] = i - 1;
    a[root + l - 1] = i;
    root += l + 1;
    a[root - 1] = i;
  }
  dp[n + 1][0] = n + 1;
  for (int i = 1; i <= n; i++) {
    if (st[i] + c - 1 >= root)
      dp[i][0] = n + 1;
    else
      dp[i][0] = a[st[i] + c - 1] + 1;
  }
  int tot = 0;
  for (int i = 1; i <= 20; i++) {
    bool isok = false;
    for (int j = 1; j <= n + 1; j++) {
      dp[j][i] = dp[dp[j][i - 1]][i - 1];
      if (dp[j][i] != n + 1) isok = true;
    }
    tot++;
    if (!isok) break;
  }
  int ans = 0, ans1 = 0;
  for (int i = 1; i <= n; i++) {
    int t = i, p = r;
    for (int j = tot; j >= 0; j--)
      if (p >= pw[j]) {
        t = dp[t][j];
        p -= pw[j];
      }
    if (ans < t - i || !ans1) {
      ans = t - i;
      ans1 = i;
    }
  }
  for (int i = 1; i <= r; i++) {
    if (ans1 > n) break;
    int t = a[st[ans1] + c - 1];
    if (st[ans1] + c - 1 >= root) t = n;
    if (t < ans1) break;
    for (int j = ans1; j < t; j++) printf("%s ", s + st[j]);
    printf("%s\n", s + st[t]);
    ans1 = t + 1;
  }
  return 0;
}
